package org.hl7.fhir.validation.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient5;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.services.client.TerminologyClientR6;
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
 * The terminology clients, for each FHIR version - those the R5 stack uses (ITerminologyClient5) and
 * those the R6 stack uses (ITerminologyClientN) - send the credentials that fhir-settings.json
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

  /** "R5": the client the R5 stack uses, "R6": the one the R6 stack uses; "R6-default" is the R6 stack's own client */
  static Stream<Arguments> clients() {
    Stream.Builder<Arguments> b = Stream.builder();
    for (String authenticationType : List.of("token", "apikey")) {
      for (String version : List.of("3.0.2", "4.0.1", "5.0.0")) {
        b.add(Arguments.of("R5", version, authenticationType));
      }
      for (String version : List.of("3.0.2", "4.0.1", "5.0.0", "6.0.0")) {
        b.add(Arguments.of("R6", version, authenticationType));
      }
      b.add(Arguments.of("R6-default", "6.0.0", authenticationType));
    }
    return b.build();
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

  /** A $lookup through the terminology client for the stack and version: the request the server got */
  private static RecordedRequest lookup(MockWebServer server, String stack, String version) throws Exception {
    server.enqueue(new MockResponse().setResponseCode(200).setHeader("Content-Type", "application/fhir+json")
      .setBody("{\"resourceType\":\"Parameters\"}"));
    String url = server.url("/").toString();
    switch (stack) {
    case "R5": {
      ITerminologyClient5 client = new TerminologyClientFactory(version).makeClientR5("test", url, "fhir/publisher/test", null);
      Parameters p = new Parameters();
      p.addParameter("system", "http://loinc.org");
      p.addParameter("code", "1234-5");
      client.lookupCode(p);
      break;
    }
    default: {
      ModelContext mc = ModelContext.fullCoreContext();
      ITerminologyClientN client = "R6".equals(stack)
        ? new TerminologyClientFactory(version).makeClientN(mc, "test", url, "fhir/publisher/test", null)
        : new TerminologyClientR6.TerminologyClientR6Factory().makeClientN(mc, "test", url, "fhir/publisher/test", null);
      org.hl7.fhir.model.core.Parameters p = new org.hl7.fhir.model.core.Parameters(mc);
      p.addParameter("system", "http://loinc.org");
      p.addParameter("code", "1234-5");
      client.lookupCode(p);
    }
    }
    RecordedRequest request = server.takeRequest(10, TimeUnit.SECONDS);
    assertNotNull(request, "the server got no request");
    return request;
  }

  @ParameterizedTest(name = "{0} {1}, {2}")
  @MethodSource("clients")
  void sendsTheCredentialsForTheServer(String stack, String version, String authenticationType) throws Exception {
    settings(authenticationType);
    RecordedRequest request = lookup(withCredentials, stack, version);
    if ("token".equals(authenticationType)) {
      assertEquals("Bearer " + TOKEN, request.getHeader("Authorization"));
    } else {
      assertEquals(API_KEY, request.getHeader("Api-Key"));
    }
  }

  @ParameterizedTest(name = "{0} {1}, {2}")
  @MethodSource("clients")
  void sendsThemToNoOtherServer(String stack, String version, String authenticationType) throws Exception {
    settings(authenticationType);
    RecordedRequest request = lookup(without, stack, version);
    assertNull(request.getHeader("Authorization"));
    assertNull(request.getHeader("Api-Key"));
  }
}
