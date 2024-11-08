package org.hl7.fhir.r4.utils.client.network;

import okhttp3.Request;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.http.HTTPHeaderUtil;
import org.hl7.fhir.utilities.http.HTTPRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FhirRequestBuilderTest {
  @Test
  @DisplayName("Test resource format headers are added correctly.")
  void addResourceFormatHeadersGET() {
    String testFormat = "yaml";
    HTTPRequest request = new HTTPRequest().withUrl("http://www.google.com").withMethod(HTTPRequest.HttpMethod.GET);

    Iterable<HTTPHeader> headers = FhirRequestBuilder.getResourceFormatHeaders(request, testFormat);

    Map<String, List<String>> headersMap = HTTPHeaderUtil.getMultimap(headers);
    Assertions.assertNotNull(headersMap.get("Accept"), "Accept header null.");
    Assertions.assertEquals(testFormat, headersMap.get("Accept").get(0),
      "Accept header not populated with expected value " + testFormat + ".");

    Assertions.assertNull(headersMap.get("Content-Type"), "Content-Type header null.");
  }

  @Test
  @DisplayName("Test resource format headers are added correctly (POST).")
  void addResourceFormatHeadersPOST() {
    String testFormat = "yaml";
    HTTPRequest request = new HTTPRequest().withUrl("http://www.google.com").withMethod(HTTPRequest.HttpMethod.POST);

    Iterable<HTTPHeader> headers = FhirRequestBuilder.getResourceFormatHeaders(request, testFormat);

    Map<String, List<String>> headersMap = HTTPHeaderUtil.getMultimap(headers);
    Assertions.assertNotNull(headersMap.get("Accept"), "Accept header null.");
    Assertions.assertEquals(testFormat, headersMap.get("Accept").get(0),
      "Accept header not populated with expected value " + testFormat + ".");

    Assertions.assertNotNull(headersMap.get("Content-Type"), "Content-Type header null.");
    Assertions.assertEquals(testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET, headersMap.get("Content-Type").get(0),
      "Content-Type header not populated with expected value \"" + testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET + "\".");
  }

  @Test
  @DisplayName("Test that FATAL issue severity triggers error.")
  void hasErrorTestFatal() {
    OperationOutcome outcome = new OperationOutcome();
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.FATAL));
    Assertions.assertTrue(FhirRequestBuilder.hasError(outcome), "Error check not triggered for FATAL issue severity.");
  }

  @Test
  @DisplayName("Test that ERROR issue severity triggers error.")
  void hasErrorTestError() {
    OperationOutcome outcome = new OperationOutcome();
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.ERROR));
    Assertions.assertTrue(FhirRequestBuilder.hasError(outcome), "Error check not triggered for ERROR issue severity.");
  }

  @Test
  @DisplayName("Test that no FATAL or ERROR issue severity does not trigger error.")
  void hasErrorTestNoErrors() {
    OperationOutcome outcome = new OperationOutcome();
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
    outcome.addIssue(
      new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
    Assertions.assertFalse(FhirRequestBuilder.hasError(outcome), "Error check triggered unexpectedly.");
  }

  @Test
  @DisplayName("Test that getLocationHeader returns header for 'location'.")
  void getLocationHeaderWhenOnlyLocationIsSet() {
    final String expectedLocationHeader = "location_header_value";
    Iterable<HTTPHeader> headers =  List.of(new HTTPHeader(FhirRequestBuilder.LOCATION_HEADER, expectedLocationHeader));
    Assertions.assertEquals(expectedLocationHeader, FhirRequestBuilder.getLocationHeader(headers));
  }

  @Test
  @DisplayName("Test that getLocationHeader returns header for 'content-location'.")
  void getLocationHeaderWhenOnlyContentLocationIsSet() {
    final String expectedContentLocationHeader = "content_location_header_value";
    Iterable<HTTPHeader> headers = List.of(new HTTPHeader(FhirRequestBuilder.CONTENT_LOCATION_HEADER, expectedContentLocationHeader));
    Assertions.assertEquals(expectedContentLocationHeader, FhirRequestBuilder.getLocationHeader(headers));
  }

  @Test
  @DisplayName("Test that getLocationHeader returns 'location' header when both 'location' and 'content-location' are set.")
  void getLocationHeaderWhenLocationAndContentLocationAreSet() {
    final String expectedLocationHeader = "location_header_value";
    final String expectedContentLocationHeader = "content_location_header_value";
    Iterable<HTTPHeader> headers = List.of(
      new HTTPHeader(FhirRequestBuilder.LOCATION_HEADER, expectedLocationHeader),
      new HTTPHeader(FhirRequestBuilder.CONTENT_LOCATION_HEADER, expectedContentLocationHeader)
    );
    Assertions.assertEquals(expectedLocationHeader, FhirRequestBuilder.getLocationHeader(headers));
  }

  @Test
  @DisplayName("Test that getLocationHeader returns null when no location available.")
  void getLocationHeaderWhenNoLocationSet() {

    Assertions.assertNull(FhirRequestBuilder.getLocationHeader(Collections.emptyList()));
  }
}
