package org.hl7.fhir.convertors.txClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.hl7.fhir.r5.context.BaseWorkerContext;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient5;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The R3 and R4 terminology clients report a failed $expand so that the caller can tell a server that couldn't be
 * reached (a network error, or a 502 etc) from one that answered: the R3 ones keep the HTTP status, and throw on a
 * network error instead of returning an empty expansion; the R4 ones keep the network error as the cause. No network:
 * the HTTP layer is replaced with a canned response.
 */
class TerminologyClientExpandErrorTest {

  private static final String ERROR = "{\"resourceType\":\"OperationOutcome\",\"issue\":[{\"severity\":\"error\",\"code\":\"exception\",\"diagnostics\":\"failed\"}]}";

  private ManagedWebAccess.WebAccessPolicy policy = ManagedWebAccess.getAccessPolicy();
  private ManagedWebAccess.IFhirWebAccessor accessor = ManagedWebAccess.getFhirWebAccessor();

  private static void setFhirWebAccessor(ManagedWebAccess.IFhirWebAccessor accessor) throws Exception {
    Field f = ManagedWebAccess.class.getDeclaredField("fhirWebAccessor");
    f.setAccessible(true);
    f.set(null, accessor);
  }

  private static void respondWith(int code, String contentType, String body) throws Exception {
    setFhirWebAccessor(request -> new HTTPResult(request.getUrl().toString(), code, "error", contentType,
      body.getBytes(StandardCharsets.UTF_8), List.of(new HTTPHeader("Content-Type", contentType))));
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.MANAGED);
  }

  private static void failToConnect() {
    // PROHIBITED makes the HTTP layer throw an IOException, as a timeout or a refused connection does
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.PROHIBITED);
  }

  @AfterEach
  void restore() throws Exception {
    ManagedWebAccess.setAccessPolicy(policy);
    setFhirWebAccessor(accessor);
  }

  private static Exception expand(ITerminologyClient5 tc) {
    return assertThrows(RuntimeException.class,
      () -> tc.expandValueset(new org.hl7.fhir.r5.model.ValueSet().setUrl("http://example.org/vs"), new org.hl7.fhir.r5.model.Parameters()));
  }

  private static Exception expand(ITerminologyClientN tc) {
    return assertThrows(RuntimeException.class,
      () -> tc.expandValueset(new org.hl7.fhir.model.core.ValueSet().setUrl("http://example.org/vs"), new org.hl7.fhir.model.core.Parameters()));
  }

  private static int status(Throwable e) {
    for (Throwable t = e; t != null; t = t.getCause()) {
      if (t instanceof org.hl7.fhir.services.client.EFhirClientException && ((org.hl7.fhir.services.client.EFhirClientException) t).getCode() > 0) {
        return ((org.hl7.fhir.services.client.EFhirClientException) t).getCode();
      }
    }
    return 0;
  }

  private static boolean hasNetworkCause(Throwable e) {
    for (Throwable t = e; t != null; t = t.getCause()) {
      if (t instanceof IOException) {
        return true;
      }
    }
    return false;
  }

  private static ITerminologyClient5 r3() throws Exception {
    return new TerminologyClient5R3("id", "http://tx.example.org/r3", "test");
  }

  private static ITerminologyClient5 r4() throws Exception {
    return new TerminologyClient5R4("id", "http://tx.example.org/r4", "test");
  }

  @ParameterizedTest
  @ValueSource(ints = {408, 429, 502, 503, 504})
  void unavailableStatusIsServerUnavailable(int code) throws Exception {
    respondWith(code, "text/html", "<html><body>" + code + "</body></html>");
    assertTrue(BaseWorkerContext.isServerUnavailable(expand(r3())), "R3");
    assertTrue(BaseWorkerContext.isServerUnavailable(expand(r4())), "R4");
    assertEquals(code, status(expand(new TerminologyClientNR3(org.hl7.fhir.model.ModelContext.fullCoreContext(), "id", "http://tx.example.org/r3", "test"))));
  }

  @ParameterizedTest
  @ValueSource(ints = {400, 401, 404, 422, 500})
  void otherStatusIsAnAnswer(int code) throws Exception {
    respondWith(code, "application/fhir+json", ERROR);
    assertFalse(BaseWorkerContext.isServerUnavailable(expand(r3())), "R3");
    assertFalse(BaseWorkerContext.isServerUnavailable(expand(r4())), "R4");
    assertEquals(code, status(expand(new TerminologyClientNR3(org.hl7.fhir.model.ModelContext.fullCoreContext(), "id", "http://tx.example.org/r3", "test"))));
    // the R3 client fails to parse an error page or broken json with an IOException, but there was a response, so
    // its status decides
    respondWith(code, "text/html", "<html><body>" + code + "</body></html>");
    assertFalse(BaseWorkerContext.isServerUnavailable(expand(r3())), "R3 error page");
    assertFalse(BaseWorkerContext.isServerUnavailable(expand(r4())), "R4 error page");
    respondWith(code, "application/fhir+json", "{\"resourceType\":");
    assertFalse(BaseWorkerContext.isServerUnavailable(expand(r3())), "R3 broken json");
    assertFalse(BaseWorkerContext.isServerUnavailable(expand(r4())), "R4 broken json");
  }

  @ParameterizedTest
  @ValueSource(ints = {3, 4})
  void networkFailureIsServerUnavailable(int version) throws Exception {
    failToConnect();
    assertTrue(BaseWorkerContext.isServerUnavailable(expand(version == 3 ? r3() : r4())));
    ITerminologyClientN n = version == 3
      ? new TerminologyClientNR3(org.hl7.fhir.model.ModelContext.fullCoreContext(), "id", "http://tx.example.org/r3", "test")
      : new TerminologyClientNR4(org.hl7.fhir.model.ModelContext.fullCoreContext(), "id", "http://tx.example.org/r4", "test");
    Exception e = expand(n);
    assertTrue(hasNetworkCause(e), e.toString());
    assertEquals(0, status(e));
  }
}
