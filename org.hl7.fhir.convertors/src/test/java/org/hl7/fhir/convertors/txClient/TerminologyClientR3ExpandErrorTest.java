package org.hl7.fhir.convertors.txClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.BaseWorkerContext;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * The R3 terminology clients report an $expand error from the server like the R4 ones do, with the HTTP status and
 * the OperationOutcome, so the caller can tell a server answer (which is cached across runs) from a failure; and a
 * network failure is an exception, not an empty expansion. No network: the HTTP layer is replaced with a canned
 * response.
 */
class TerminologyClientR3ExpandErrorTest {

  private static final String UNKNOWN_VS = "{\"resourceType\":\"OperationOutcome\",\"issue\":[{\"severity\":\"error\",\"code\":\"not-found\",\"diagnostics\":\"unknown value set\"}]}";

  private ManagedWebAccess.WebAccessPolicy policy = ManagedWebAccess.getAccessPolicy();
  private ManagedWebAccess.IFhirWebAccessor accessor = ManagedWebAccess.getFhirWebAccessor();

  private static void setFhirWebAccessor(ManagedWebAccess.IFhirWebAccessor accessor) throws Exception {
    Field f = ManagedWebAccess.class.getDeclaredField("fhirWebAccessor");
    f.setAccessible(true);
    f.set(null, accessor);
  }

  private static void respondWith(int code, String json) throws Exception {
    setFhirWebAccessor(request -> new HTTPResult(request.getUrl().toString(), code, "error", "application/fhir+json",
      json.getBytes(StandardCharsets.UTF_8), List.of(new HTTPHeader("Content-Type", "application/fhir+json"))));
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.MANAGED);
  }

  @AfterEach
  void restore() throws Exception {
    ManagedWebAccess.setAccessPolicy(policy);
    setFhirWebAccessor(accessor);
  }

  private static org.hl7.fhir.r5.model.ValueSet vs() {
    return new org.hl7.fhir.r5.model.ValueSet().setUrl("http://example.org/vs");
  }

  @Test
  void r5ClientReportsServerAnswer() throws Exception {
    respondWith(404, UNKNOWN_VS);
    TerminologyClient5R3 tc = new TerminologyClient5R3("id", "http://tx.example.org/r3", "test");
    org.hl7.fhir.r5.utils.client.EFhirClientException e = assertThrows(org.hl7.fhir.r5.utils.client.EFhirClientException.class,
      () -> tc.expandValueset(vs(), new org.hl7.fhir.r5.model.Parameters()));
    assertEquals(404, e.getCode());
    assertEquals(org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOTFOUND, e.getServerErrors().get(0).getIssueFirstRep().getCode());
    assertTrue(BaseWorkerContext.isServerAnswer(e));
  }

  @Test
  void r5ClientReportsServerError() throws Exception {
    respondWith(503, UNKNOWN_VS.replace("not-found", "transient"));
    TerminologyClient5R3 tc = new TerminologyClient5R3("id", "http://tx.example.org/r3", "test");
    org.hl7.fhir.r5.utils.client.EFhirClientException e = assertThrows(org.hl7.fhir.r5.utils.client.EFhirClientException.class,
      () -> tc.expandValueset(vs(), new org.hl7.fhir.r5.model.Parameters()));
    assertEquals(503, e.getCode());
    assertFalse(BaseWorkerContext.isServerAnswer(e));
  }

  @Test
  void r5ClientReportsNetworkFailure() throws Exception {
    // PROHIBITED makes the HTTP layer throw an IOException, as a timeout or a refused connection does
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.PROHIBITED);
    TerminologyClient5R3 tc = new TerminologyClient5R3("id", "http://tx.example.org/r3", "test");
    FHIRException e = assertThrows(FHIRException.class, () -> tc.expandValueset(vs(), new org.hl7.fhir.r5.model.Parameters()));
    assertInstanceOf(IOException.class, e.getCause());
    assertFalse(BaseWorkerContext.isServerAnswer(e));
  }

  @Test
  void nClientReportsServerAnswer() throws Exception {
    respondWith(404, UNKNOWN_VS);
    TerminologyClientNR3 tc = new TerminologyClientNR3(org.hl7.fhir.model.ModelContext.fullCoreContext(), "id", "http://tx.example.org/r3", "test");
    org.hl7.fhir.services.client.EFhirClientException e = assertThrows(org.hl7.fhir.services.client.EFhirClientException.class,
      () -> tc.expandValueset(new org.hl7.fhir.model.core.ValueSet().setUrl("http://example.org/vs"), new org.hl7.fhir.model.core.Parameters()));
    assertEquals(404, e.getCode());
    assertEquals(org.hl7.fhir.model.core.OperationOutcome.IssueType.NOTFOUND, e.getServerErrors().get(0).getIssueFirstRep().getCode());
  }
}
