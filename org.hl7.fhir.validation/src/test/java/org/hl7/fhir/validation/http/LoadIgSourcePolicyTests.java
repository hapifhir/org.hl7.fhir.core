package org.hl7.fhir.validation.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * {@code POST /loadIG} accepts a server-local path only when the server is bound to loopback,
 * where the caller is by definition a process on the same machine. Once the server is reachable
 * over the network, a caller may name a package reference or an http(s) URL, never a path on
 * the host.
 */
class LoadIgSourcePolicyTests {

  // -- the classifier ---------------------------------------------------------------------

  @ParameterizedTest
  @DisplayName("Package references and http(s) URLs may be named by a remote caller")
  @ValueSource(strings = {
    "hl7.fhir.us.core",
    "hl7.fhir.us.core#5.0.1",
    "hl7.fhir.be.core#2.1.2",
    "[4.0]hl7.fhir.us.core#5.0.1",
    "https://example.org/ig/package.tgz",
    "http://example.org/ig/package.tgz",
    "HTTPS://EXAMPLE.ORG/PACKAGE.TGZ",
    "[5.0]https://example.org/ig/package.tgz"
  })
  void remoteLoadableSources(String src) {
    assertTrue(LoadIGHTTPHandler.isRemoteLoadableSource(src), src);
  }

  @ParameterizedTest
  @DisplayName("Anything that names a path on the host may not")
  @ValueSource(strings = {
    "/etc/passwd",
    "/home/op/private-ig",
    "C:\\Users\\op\\ig",
    "..\\..\\secrets",
    "../secrets",
    "./output/package.tgz",
    "output/package.tgz",
    "package.tgz",
    "igpack.zip",
    "validator.pack",
    "my.ig.tgz",
    "file:///etc/passwd",
    "\\\\server\\share\\ig",
    "[4.0]/home/op/private-ig"
  })
  void localPathsAreNotRemoteLoadable(String src) {
    assertFalse(LoadIGHTTPHandler.isRemoteLoadableSource(src), src);
  }

  // -- the handler, by bind mode ----------------------------------------------------------

  private static final int NETWORK_PORT = 18091;
  private static final int LOOPBACK_PORT = 18092;
  private static final String LOCAL_PATH_BODY = "{\"ig\": \"/definitely/not/a/package\"}";

  private static HttpResponse<String> postLoadIg(int port, String body) throws Exception {
    HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("http://127.0.0.1:" + port + "/loadIG"))
      .header("Content-Type", "application/json")
      .POST(HttpRequest.BodyPublishers.ofString(body))
      .build();
    return client.send(request, HttpResponse.BodyHandlers.ofString());
  }

  @Test
  @DisplayName("Network-accessible server refuses a local path with 400, before touching the engine")
  void networkModeRefusesLocalPath() throws Exception {
    // A mocked engine has no IgLoader: if the handler reached it, the result would be a 500,
    // so a 400 here proves the refusal happens first.
    FhirValidatorHttpService service = new FhirValidatorHttpService(mock(ValidationEngine.class), false, NETWORK_PORT);
    service.startServer();
    try {
      HttpResponse<String> response = postLoadIg(NETWORK_PORT, LOCAL_PATH_BODY);
      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("loopback"), response.body());
    } finally {
      service.stop();
    }
  }

  @Test
  @DisplayName("Loopback-only server still hands a local path to the engine")
  void loopbackModePassesLocalPathThrough() throws Exception {
    // Same mocked engine: reaching it yields a 500 from the null loader, which is exactly what
    // shows the path was NOT refused by the policy check.
    FhirValidatorHttpService service = new FhirValidatorHttpService(mock(ValidationEngine.class), true, LOOPBACK_PORT);
    service.startServer();
    try {
      HttpResponse<String> response = postLoadIg(LOOPBACK_PORT, LOCAL_PATH_BODY);
      assertFalse(response.body().contains("loopback"), response.body());
      assertFalse(response.statusCode() == 400, "the policy check must not apply on loopback");
    } finally {
      service.stop();
    }
  }
}
