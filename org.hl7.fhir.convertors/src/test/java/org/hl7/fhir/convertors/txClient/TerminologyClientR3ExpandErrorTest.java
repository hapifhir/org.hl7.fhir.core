package org.hl7.fhir.convertors.txClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.lang.reflect.Field;
import java.net.SocketTimeoutException;

import org.hl7.fhir.dstu3.model.OperationOutcome;
import org.hl7.fhir.dstu3.support.utils.client.EFhirClientException;
import org.hl7.fhir.dstu3.support.utils.client.FHIRToolingClient;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.BaseWorkerContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * The R3 terminology clients translate an $expand error from the server like the R4 ones do, so the caller sees
 * the HTTP code and the OperationOutcome, and can tell a server answer (which is cached across runs) from a failure.
 */
class TerminologyClientR3ExpandErrorTest {

  private static FHIRToolingClient failingClient(RuntimeException failure) {
    FHIRToolingClient client = Mockito.mock(FHIRToolingClient.class);
    Mockito.doThrow(failure).when(client).expandValueset(any(), any());
    return client;
  }

  private static void setClient(Object tc, FHIRToolingClient client) throws Exception {
    Field f = tc.getClass().getDeclaredField("client");
    f.setAccessible(true);
    f.set(tc, client);
  }

  private static EFhirClientException unknownValueSet() {
    OperationOutcome oo = new OperationOutcome();
    oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(OperationOutcome.IssueType.NOTFOUND).setDiagnostics("unknown value set");
    return new EFhirClientException(404, "unknown value set", oo);
  }

  @Test
  void r5ClientTranslatesServerAnswer() throws Exception {
    TerminologyClient5R3 tc = new TerminologyClient5R3("id", "http://tx.example.org/r3", "test");
    setClient(tc, failingClient(unknownValueSet()));
    org.hl7.fhir.r5.utils.client.EFhirClientException e = assertThrows(org.hl7.fhir.r5.utils.client.EFhirClientException.class,
      () -> tc.expandValueset(new org.hl7.fhir.r5.model.ValueSet(), new org.hl7.fhir.r5.model.Parameters()));
    assertEquals(404, e.getCode());
    assertEquals(org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOTFOUND, e.getServerErrors().get(0).getIssueFirstRep().getCode());
    assertTrue(BaseWorkerContext.isServerAnswer(e));
  }

  @Test
  void r5ClientPassesOtherFailuresOn() throws Exception {
    TerminologyClient5R3 tc = new TerminologyClient5R3("id", "http://tx.example.org/r3", "test");
    FHIRException timeout = new FHIRException(new SocketTimeoutException("timed out"));
    setClient(tc, failingClient(timeout));
    assertSame(timeout, assertThrows(FHIRException.class,
      () -> tc.expandValueset(new org.hl7.fhir.r5.model.ValueSet(), new org.hl7.fhir.r5.model.Parameters())));
  }

  @Test
  void nClientTranslatesServerAnswer() throws Exception {
    TerminologyClientNR3 tc = new TerminologyClientNR3(org.hl7.fhir.model.ModelContext.fullCoreContext(), "id", "http://tx.example.org/r3", "test");
    setClient(tc, failingClient(unknownValueSet()));
    org.hl7.fhir.services.client.EFhirClientException e = assertThrows(org.hl7.fhir.services.client.EFhirClientException.class,
      () -> tc.expandValueset(new org.hl7.fhir.model.core.ValueSet(), new org.hl7.fhir.model.core.Parameters()));
    assertEquals(404, e.getCode());
    assertEquals(org.hl7.fhir.model.core.OperationOutcome.IssueType.NOTFOUND, e.getServerErrors().get(0).getIssueFirstRep().getCode());
  }
}
