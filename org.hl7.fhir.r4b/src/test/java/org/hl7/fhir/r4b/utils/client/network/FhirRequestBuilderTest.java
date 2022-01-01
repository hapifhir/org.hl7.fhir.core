package org.hl7.fhir.r4b.utils.client.network;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.hl7.fhir.r4b.model.OperationOutcome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FhirRequestBuilderTest {

  @Test
  @DisplayName("Test default headers are added correctly.")
  void addDefaultHeaders() {
    Request.Builder request = new Request.Builder().url("http://www.google.com");
    FhirRequestBuilder.addDefaultHeaders(request, null);

    Map<String, List<String>> headersMap = request.build().headers().toMultimap();
    Assertions.assertNotNull(headersMap.get("User-Agent"), "User-Agent header null.");
    Assertions.assertEquals("hapi-fhir-tooling-client", headersMap.get("User-Agent").get(0),
      "User-Agent header not populated with expected value \"hapi-fhir-tooling-client\".");

    Assertions.assertNotNull(headersMap.get("Accept-Charset"), "Accept-Charset header null.");
    Assertions.assertEquals(FhirRequestBuilder.DEFAULT_CHARSET, headersMap.get("Accept-Charset").get(0),
      "Accept-Charset header not populated with expected value " + FhirRequestBuilder.DEFAULT_CHARSET);
  }

  @Test
  @DisplayName("Test resource format headers are added correctly.")
  void addResourceFormatHeaders() {
    String testFormat = "yaml";
    Request.Builder request = new Request.Builder().url("http://www.google.com");
    FhirRequestBuilder.addResourceFormatHeaders(request, testFormat);

    Map<String, List<String>> headersMap = request.build().headers().toMultimap();
    Assertions.assertNotNull(headersMap.get("Accept"), "Accept header null.");
    Assertions.assertEquals(testFormat, headersMap.get("Accept").get(0),
      "Accept header not populated with expected value " + testFormat + ".");

    Assertions.assertNotNull(headersMap.get("Content-Type"), "Content-Type header null.");
    Assertions.assertEquals(testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET, headersMap.get("Content-Type").get(0),
      "Content-Type header not populated with expected value \"" + testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET + "\".");
  }

  @Test
  @DisplayName("Test a list of provided headers are added correctly.")
  void addHeaders() {
    String headerName1 = "headerName1";
    String headerValue1 = "headerValue1";
    String headerName2 = "headerName2";
    String headerValue2 = "headerValue2";

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
}