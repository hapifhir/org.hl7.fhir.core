package org.hl7.fhir.validation.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient5;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.settings.FhirSettingsPOJO;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * The terminology clients, for each FHIR version, send the credentials that fhir-settings.json
 * gives for a terminology server (an API token, or an API key) with their requests, and send them
 * to no other server. The IG Publisher and the validator rely on this when a terminology server
 * gives a client with a token more (tx.fhir.org: a bigger $cache-control cache), or needs a login
 * for some requests (FHIRsmith's auth.loginForExpensive).
 */
class TerminologyClientCredentialsTests {

  private static final String TOKEN = "fhs_test-token";
  private static final String API_KEY = "test-api-key";

  private static MockWebServer withCredentials;
  private static MockWebServer without;

  @BeforeAll
  static void beforeAll() throws IOException {
    withCredentials = new MockWebServer();
    withCredentials.start();
    without = new MockWebServer();
    without.start();
  }

  @AfterAll
  static void afterAll() throws IOException {
    ManagedWebAccess.loadFromFHIRSettings();
    withCredentials.shutdown();
    without.shutdown();
  }

  static Stream<Arguments> clients() {
    return Stream.of(
      Arguments.of("3.0.2", "token"),
      Arguments.of("4.0.1", "token"),
      Arguments.of("5.0.0", "token"),
      Arguments.of("3.0.2", "apikey"),
      Arguments.of("4.0.1", "apikey"),
      Arguments.of("5.0.0", "apikey")
    );
  }

  /** fhir-settings.json with the credentials for one server, and none for the other */
  private static void settings(String authenticationType) {
    ServerDetailsPOJO credentials = ServerDetailsPOJO.builder()
      .url(withCredentials.url("/").toString()).type("fhir").authenticationType(authenticationType)
      .token(TOKEN).apikey(API_KEY).allowHttp(true).allowPrivateNetwork(true).build();
    ServerDetailsPOJO none = ServerDetailsPOJO.builder()
      .url(without.url("/").toString()).type("fhir").authenticationType("none")
      .allowHttp(true).allowPrivateNetwork(true).build();
    ManagedWebAccess.loadFromSettings(FhirSettingsPOJO.builder().servers(List.of(credentials, none)).build());
  }

  /** A $lookup through the terminology client the factory makes for the version: the request the server got */
  private static RecordedRequest lookup(MockWebServer server, String version) throws Exception {
    server.enqueue(new MockResponse().setResponseCode(200).setHeader("Content-Type", "application/fhir+json")
      .setBody("{\"resourceType\":\"Parameters\"}"));
    ITerminologyClient5 client = new TerminologyClientFactory(version).makeClientR5("test", server.url("/").toString(), "fhir/publisher/test", null);
    Parameters p = new Parameters();
    p.addParameter("system", "http://loinc.org");
    p.addParameter("code", "1234-5");
    client.lookupCode(p);
    RecordedRequest request = server.takeRequest(10, TimeUnit.SECONDS);
    assertNotNull(request, "the server got no request");
    return request;
  }

  @ParameterizedTest(name = "{0}, {1}")
  @MethodSource("clients")
  void sendsTheCredentialsForTheServer(String version, String authenticationType) throws Exception {
    settings(authenticationType);
    RecordedRequest request = lookup(withCredentials, version);
    if ("token".equals(authenticationType)) {
      assertEquals("Bearer " + TOKEN, request.getHeader("Authorization"));
    } else {
      assertEquals(API_KEY, request.getHeader("Api-Key"));
    }
  }

  @ParameterizedTest(name = "{0}, {1}")
  @MethodSource("clients")
  void sendsThemToNoOtherServer(String version, String authenticationType) throws Exception {
    settings(authenticationType);
    RecordedRequest request = lookup(without, version);
    assertNull(request.getHeader("Authorization"));
    assertNull(request.getHeader("Api-Key"));
  }
}
