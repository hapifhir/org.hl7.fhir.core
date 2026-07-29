package org.hl7.fhir.utilities.http;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.doReturn;

public class ManagedFhirWebAccessorTests {
  final String expectedUserAgent = "dummy-agent";

  @Test
  @DisplayName("Test default headers are added correctly.")
  void addDefaultAgentHeader() {
    HTTPRequest request = new HTTPRequest().withUrl("http://www.google.com");

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(expectedUserAgent, null);

    HTTPRequest requestWithDefaultHeaders = builder.httpRequestWithDefaultHeaders(request);
    assertRequestContainsExpectedAgentHeader(requestWithDefaultHeaders);
  }

  @Test
  @DisplayName("Test default headers are added correctly.")
  void addDefaultBasicHeader() throws MalformedURLException {
    HTTPRequest request = new HTTPRequest().withUrl("http://www.google.com");

    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
    URL url = URI.create("http://www.google.com").toURL();
    doReturn(true).when(authenticationProvider).canProvideHeaders(url);
    doReturn(Map.of("Authorization", "DUMMY_VALUE")).when(authenticationProvider).getHeaders(url);

    ManagedFhirWebAccessor
      builder = new ManagedFhirWebAccessor(expectedUserAgent, authenticationProvider);

    HTTPRequest requestWithAuthorizationHeaders = builder.requestWithAuthorizationHeaders(request);
    assertRequestContainsExpectedAgentHeader(requestWithAuthorizationHeaders);

    Assertions.assertNotNull(HTTPHeaderUtil.getSingleHeader(requestWithAuthorizationHeaders.getHeaders(),"Authorization"), "Authorization header null.");
  }

  private void assertRequestContainsExpectedAgentHeader(HTTPRequest requestWithDefaultHeaders) {
    Assertions.assertNotNull(HTTPHeaderUtil.getSingleHeader(requestWithDefaultHeaders.getHeaders(),"User-Agent"), "User-Agent header null.");
    Assertions.assertEquals(expectedUserAgent, HTTPHeaderUtil.getSingleHeader(requestWithDefaultHeaders.getHeaders(),"User-Agent"),
      "User-Agent header not populated with expected value \""+expectedUserAgent+"\".");
  }

  @Test
  @DisplayName("Test the call timeout includes the configured retry budget.")
  void callTimeoutIncludesRetries() {
    Assertions.assertEquals(5000, ManagedFhirWebAccessor.calculateCallTimeout(5000, TimeUnit.MILLISECONDS, 0));
    Assertions.assertEquals(19000, ManagedFhirWebAccessor.calculateCallTimeout(5000, TimeUnit.MILLISECONDS, 2));
  }

  @Test
  @DisplayName("Test timed out calls do not retry when retries are disabled.")
  void timeoutWithNoRetriesMakesOneAttempt() throws IOException {
    MockWebServer server = new MockWebServer();
    try {
      server.enqueue(new MockResponse()
        .setHeadersDelay(5, TimeUnit.SECONDS)
        .setBody("{}"));

      ManagedFhirWebAccessor accessor = new ManagedFhirWebAccessor(expectedUserAgent, null)
        .withTimeout(250, TimeUnit.MILLISECONDS)
        .withRetries(0);
      HTTPRequest request = new HTTPRequest()
        .withUrl(server.url("/metadata").toString())
        .withMethod(HTTPRequest.HttpMethod.GET);

      assertTimeoutPreemptively(Duration.ofMillis(1500),
        () -> assertThrows(IOException.class, () -> accessor.httpCall(request)));

      Assertions.assertEquals(1, server.getRequestCount());
    } finally {
      server.shutdown();
    }
  }
}
