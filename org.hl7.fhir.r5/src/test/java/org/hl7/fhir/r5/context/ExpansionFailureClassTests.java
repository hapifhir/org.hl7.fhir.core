package org.hl7.fhir.r5.context;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * BaseWorkerContext.classifyExpansionFailure: which failures of an $expand are the server's answer about the value set
 * (cached for later runs), and which are about the server, or the way to it, at the time (asked again next run - see
 * TerminologyCache.isTransientFailure)
 */
class ExpansionFailureClassTests {

  /** a response with no OperationOutcome: its status decides */
  @ParameterizedTest
  @CsvSource({
    // we may not use the server, or the proxy to it
    "401, NOSERVICE", "403, NOSERVICE", "407, NOSERVICE",
    // the server is busy or unavailable
    "408, SERVER_ERROR", "429, SERVER_ERROR", "502, SERVER_ERROR", "503, SERVER_ERROR", "504, SERVER_ERROR",
    // the server failed
    "500, INTERNAL_ERROR",
    // the server's answer
    "400, UNKNOWN", "404, UNKNOWN", "422, UNKNOWN"
  })
  void byStatus(int code, TerminologyServiceErrorClass expected) {
    assertEquals(expected, BaseWorkerContext.classifyExpansionFailure(new EFhirClientException(code, "failed")));
  }

  /** a 4xx with an OperationOutcome: its issue type decides */
  @ParameterizedTest
  @CsvSource({
    // about the server at the time, not the value set
    "TRANSIENT, SERVER_ERROR", "LOCKERROR, SERVER_ERROR", "TIMEOUT, SERVER_ERROR", "THROTTLED, SERVER_ERROR",
    // about the value set
    "TOOCOSTLY, TOO_COSTLY", "NOTFOUND, UNKNOWN", "INVALID, UNKNOWN", "NOTSUPPORTED, UNKNOWN"
  })
  void byIssueType(OperationOutcome.IssueType type, TerminologyServiceErrorClass expected) {
    OperationOutcome oo = new OperationOutcome();
    oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(type).getDetails().setText("failed");
    assertEquals(expected, BaseWorkerContext.classifyExpansionFailure(new EFhirClientException(422, "failed", oo)));
  }

  @Test
  void noResponse() {
    assertEquals(TerminologyServiceErrorClass.SERVER_ERROR, BaseWorkerContext.classifyExpansionFailure(new EFhirClientException(new IOException("connection refused"))));
  }
}
