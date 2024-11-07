package org.hl7.fhir.utilities.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManagedFhirWebAccessorTests {
  final String expectedUserAgent = "dummy-agent";

  @Test
  @DisplayName("Test default headers are added correctly.")
  void addDefaultAgentHeader() {
    // FIXME move to ManagedFhirWebAccessBuilder
    HTTPRequest request = new HTTPRequest().withUrl("http://www.google.com");

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(expectedUserAgent, null);

    HTTPRequest requestWithDefaultHeaders = builder.httpRequestWithDefaultHeaders(request);
    assertRequestContainsExpectedAgentHeader(requestWithDefaultHeaders);
  }

  @Test
  @DisplayName("Test default headers are added correctly.")
  void addDefaultBasicHeader() {
    // FIXME move to ManagedFhirWebAccessBuilder
    HTTPRequest request = new HTTPRequest().withUrl("http://www.google.com");

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(expectedUserAgent, null)
      .withBasicAuth("dummy-user", "dummy-password");

    HTTPRequest requestWithManagedHeaders = builder.requestWithManagedHeaders(request);
    assertRequestContainsExpectedAgentHeader(requestWithManagedHeaders);

    Assertions.assertNotNull(HTTPHeaderUtil.getSingleHeader(requestWithManagedHeaders.getHeaders(),"Authorization"), "Authorization header null.");
  }

  private void assertRequestContainsExpectedAgentHeader(HTTPRequest requestWithDefaultHeaders) {
    Assertions.assertNotNull(HTTPHeaderUtil.getSingleHeader(requestWithDefaultHeaders.getHeaders(),"User-Agent"), "User-Agent header null.");
    Assertions.assertEquals(expectedUserAgent, HTTPHeaderUtil.getSingleHeader(requestWithDefaultHeaders.getHeaders(),"User-Agent"),
      "User-Agent header not populated with expected value \""+expectedUserAgent+"\".");
  }
}
