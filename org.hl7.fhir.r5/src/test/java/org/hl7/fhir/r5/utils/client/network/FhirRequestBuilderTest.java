package org.hl7.fhir.r5.utils.client.network;

import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.model.OperationOutcome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import okhttp3.Headers;
import okhttp3.Request;

class FhirRequestBuilderTest {

  public static final String ACCEPT_HEADER = "Accept";
  public static final String CONTENT_TYPE_HEADER = "Content-Type";
  public static final String USER_AGENT_HEADER = "User-Agent";
  public static final String ACCEPT_CHARSET_HEADER = "Accept-Charset";

  @Test
  @DisplayName("Test default headers are added correctly.")
  void addDefaultHeaders() {
    Request.Builder request = new Request.Builder().url("http://www.google.com");
    FhirRequestBuilder.addDefaultHeaders(request, null);

    Map<String, List<String>> headersMap = request.build().headers().toMultimap();
    Assertions.assertNotNull(headersMap.get(USER_AGENT_HEADER), "User-Agent header null.");
    Assertions.assertEquals("hapi-fhir-tooling-client", headersMap.get(USER_AGENT_HEADER).get(0),
      "User-Agent header not populated with expected value \"hapi-fhir-tooling-client\".");

    Assertions.assertNotNull(headersMap.get(ACCEPT_CHARSET_HEADER), "Accept-Charset header null.");
    Assertions.assertEquals(FhirRequestBuilder.DEFAULT_CHARSET, headersMap.get(ACCEPT_CHARSET_HEADER).get(0),
      "Accept-Charset header not populated with expected value " + FhirRequestBuilder.DEFAULT_CHARSET);
  }

  @Test
  @DisplayName("Test resource format headers are added correctly.")
  void addResourceFormatHeaders() {
    String testFormat = "yaml";
    Request.Builder request = new Request.Builder().url("http://www.google.com");
    FhirRequestBuilder.addResourceFormatHeaders(request, testFormat);

    Map<String, List<String>> headersMap = request.build().headers().toMultimap();

    Assertions.assertNotNull(headersMap.get(ACCEPT_HEADER), "Accept header null.");
    Assertions.assertNotNull(headersMap.get(ACCEPT_HEADER.toLowerCase()), "Accept header null.");
    Assertions.assertEquals(testFormat, headersMap.get(ACCEPT_HEADER).get(0),
      "Accept header not populated with expected value " + testFormat + ".");

    Assertions.assertNotNull(headersMap.get(CONTENT_TYPE_HEADER), "Content-Type header null.");
    Assertions.assertEquals(testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET, headersMap.get(CONTENT_TYPE_HEADER).get(0),
      "Content-Type header not populated with expected value \"" + testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET + "\".");
  }

  @Test
  @DisplayName("Test a list of provided headers are added correctly.")
  void addHeaders() {
    final String headerName1 = "headerName1";
    final String headerValue1 = "headerValue1";
    final String headerName2 = "headerName2";
    final String headerValue2 = "headerValue2";

    Headers headers = new Headers.Builder()
      .add(headerName1, headerValue1)
      .add(headerName2, headerValue2)
      .build();

    Request.Builder request = new Request.Builder().url("http://www.google.com");
    FhirRequestBuilder.addHeaders(request, headers);

    Map<String, List<String>> headersMap = request.build().headers().toMultimap();
    Assertions.assertNotNull(headersMap.get(headerName1), headerName1 + " header null.");
    Assertions.assertEquals(headerValue1, headersMap.get(headerName1).get(0),
      headerName1 + " header not populated with expected value " + headerValue1 + ".");
    Assertions.assertNotNull(headersMap.get(headerName2), headerName2 + " header null.");
    Assertions.assertEquals(headerValue2, headersMap.get(headerName2).get(0),
      headerName2 + " header not populated with expected value " + headerValue2 + ".");
  }

    @Test
    @DisplayName("Test that FATAL issue severity triggers error.")
    void hasErrorTestFatal() {
      OperationOutcome outcome = new OperationOutcome();
      outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
      outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
      outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
      outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.FATAL));
      Assertions.assertTrue(FhirRequestBuilder.hasError(outcome), "Error check not triggered for FATAL issue severity.");
    }

  @Test
  @DisplayName("Test that ERROR issue severity triggers error.")
  void hasErrorTestError() {
    OperationOutcome outcome = new OperationOutcome();
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.ERROR));
    Assertions.assertTrue(FhirRequestBuilder.hasError(outcome), "Error check not triggered for ERROR issue severity.");
  }

  @Test
  @DisplayName("Test that no FATAL or ERROR issue severity does not trigger error.")
  void hasErrorTestNoErrors() {
    OperationOutcome outcome = new OperationOutcome();
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
    Assertions.assertFalse(FhirRequestBuilder.hasError(outcome), "Error check triggered unexpectedly.");
  }

  @Test
  @DisplayName("Test that getLocationHeader returns header for 'location'.")
  void getLocationHeaderWhenOnlyLocationIsSet() {
    final String expectedLocationHeader = "location_header_value";
    Headers headers = new Headers.Builder()
      .add(FhirRequestBuilder.LOCATION_HEADER, expectedLocationHeader)
      .build();
    Assertions.assertEquals(expectedLocationHeader, FhirRequestBuilder.getLocationHeader(headers));
  }

  @Test
  @DisplayName("Test that getLocationHeader returns header for 'content-location'.")
  void getLocationHeaderWhenOnlyContentLocationIsSet() {
    final String expectedContentLocationHeader = "content_location_header_value";
    Headers headers = new Headers.Builder()
      .add(FhirRequestBuilder.CONTENT_LOCATION_HEADER, expectedContentLocationHeader)
      .build();
    Assertions.assertEquals(expectedContentLocationHeader, FhirRequestBuilder.getLocationHeader(headers));
  }

  @Test
  @DisplayName("Test that getLocationHeader returns 'location' header when both 'location' and 'content-location' are set.")
  void getLocationHeaderWhenLocationAndContentLocationAreSet() {
    final String expectedLocationHeader = "location_header_value";
    final String expectedContentLocationHeader = "content_location_header_value";
    Headers headers = new Headers.Builder()
      .add(FhirRequestBuilder.LOCATION_HEADER, expectedLocationHeader)
      .add(FhirRequestBuilder.CONTENT_LOCATION_HEADER, expectedContentLocationHeader)
      .build();
    Assertions.assertEquals(expectedLocationHeader, FhirRequestBuilder.getLocationHeader(headers));
  }

  @Test
  @DisplayName("Test that getLocationHeader returns null when no location available.")
  void getLocationHeaderWhenNoLocationSet() {
    Headers headers = new Headers.Builder()
      .build();
    Assertions.assertNull(FhirRequestBuilder.getLocationHeader(headers));
  }


  /**
   * Assert that our header exists and that it its key is managed case inse
   *
   * @param headers
   * @param headerName
   * @param headerValue
   */
  private void assertHeaderNotNullAndEquals(Headers headers, String headerName, String headerValue) {

    Map<String, List<String>> headersMap = headers.toMultimap();
    Assertions.assertNotNull(headers.get(headerName), headerName + " header null.");
    Assertions.assertNotNull(headers.get(headerName.toLowerCase()), headerName + " header null.");
    Assertions.assertNotNull(headers.get(headerName.toUpperCase()), headerName + " header null.");
    Assertions.assertEquals(headerValue, headersMap.get(headerName).get(0),
      headerName + " header not populated with expected value " + headerValue + ".");

  }
}