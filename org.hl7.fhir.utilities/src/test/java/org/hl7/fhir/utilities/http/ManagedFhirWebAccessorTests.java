package org.hl7.fhir.utilities.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

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
    URL url = new URL("http://www.google.com");
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
}
