package org.hl7.fhir.standalone.terminology.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.services.client.ClientHeaders;
import org.hl7.fhir.services.client.EFhirClientException;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.model.core.IdType;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.TerminologyCapabilities;
import org.hl7.fhir.services.client.ITerminologyClientFactoryN;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.logging.ILoggingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the $cache-control client logic in TerminologyClientContext:
 * detecting server support, starting a cache, carrying the cache-id as a header,
 * failing safe, and ending the cache. These mock ITerminologyClient and need no
 * network. (Lives in this package so it can call the protected constructor.)
 */
public class TerminologyClientContextTests {

  private static final String CACHE_ID = "cid-12345";

  @BeforeEach
  public void setup() {
    // The mock capability statements don't carry the conformance feature
    // extensions checkFeature() looks for, so allow non-conformant servers.
    TerminologyClientContext.setAllowNonConformantServers(true);
    TerminologyClientContext.setCanUseCacheId(true);
  }

  @AfterEach
  public void teardown() {
    TerminologyClientContext.setCanUseCacheId(false);
    TerminologyClientContext.setAllowNonConformantServers(false);
  }

  private CapabilityStatement capabilityStatement(boolean withCacheControl) {
    CapabilityStatement cs = new CapabilityStatement();
    cs.setSoftware(new CapabilityStatement.CapabilityStatementSoftwareComponent().setVersion("test"));
    CapabilityStatement.CapabilityStatementRestComponent rest = cs.addRest();
    rest.addOperation().setName("expand").setDefinition("http://hl7.org/fhir/OperationDefinition/ValueSet-expand");
    if (withCacheControl) {
      rest.addOperation().setName("cache-control").setDefinition("http://hl7.org/fhir/tools/OperationDefinition/cache-control");
    }
    return cs;
  }

  private Parameters cacheIdResponse(String id) {
    Parameters p = new Parameters();
    p.addParameter().setName("cache-id").setValue(new IdType(id));
    return p;
  }

  /** Matches the START_CACHE request body: Parameters with sealed=false. */
  private static org.mockito.ArgumentMatcher<Parameters> sealedFalseBody() {
    return p -> p != null && p.hasParameter("sealed") && "false".equals(p.getParameterValue("sealed").primitiveValue());
  }

  private ITerminologyClientN baseMock(CapabilityStatement cs) throws IOException {
    ITerminologyClientN client = mock(ITerminologyClientN.class);
    when(client.getAddress()).thenReturn("http://tx.example.org/r6");
    when(client.getCapabilitiesStatement()).thenReturn(cs);
    when(client.getTerminologyCapabilities()).thenReturn(new TerminologyCapabilities());
    when(client.addClientHeader(any())).thenReturn(client);
    return client;
  }

  @Test
  public void serverAdvertisesCacheControl_startsCacheAndSetsHeader() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(cacheIdResponse(CACHE_ID));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertEquals(CACHE_ID, ctx.getCacheId(), "the server-issued cache-id should be stored");
    assertTrue(ctx.usingCache(), "caching should be engaged");
    verify(client).cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), argThat(sealedFalseBody()));
    verify(client).addClientHeader(argThat(h ->
      TerminologyClientContext.CACHE_ID_HEADER.equals(h.getName()) && CACHE_ID.equals(h.getValue())));
  }

  @Test
  public void serverDoesNotAdvertiseCacheControl_noCacheStarted() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(false));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertNull(ctx.getCacheId(), "no cache should be started when the operation isn't advertised");
    assertFalse(ctx.usingCache());
    verify(client, never()).cacheControl(any(), any());
    verify(client, never()).addClientHeader(any());
  }

  @Test
  public void cachingDisabled_noCacheStartedEvenIfAdvertised() throws IOException {
    TerminologyClientContext.setCanUseCacheId(false);
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertNull(ctx.getCacheId());
    assertFalse(ctx.usingCache());
    verify(client, never()).cacheControl(any(), any());
  }

  @Test
  public void startFails_cachingOffAndLogged() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenThrow(new FHIRException("server unavailable"));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertNull(ctx.getCacheId(), "a failed start must leave the cache-id null");
    assertFalse(ctx.usingCache());
    verify(logger).logMessage(argThat(m -> m != null && m.contains("tx.example.org")));
    verify(client, never()).addClientHeader(any());
  }

  @Test
  public void startReturnsNoCacheId_cachingOffAndLogged() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(new Parameters()); // no cache-id parameter
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertNull(ctx.getCacheId());
    assertFalse(ctx.usingCache());
    verify(logger).logMessage(argThat(m -> m != null && m.contains("no cache-id")));
  }

  @Test
  public void shutdown_releasesOwnedCache() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(cacheIdResponse(CACHE_ID));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull())).thenReturn(new Parameters());
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);
    assertEquals(CACHE_ID, ctx.getCacheId());

    ctx.shutdown();

    verify(client).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull());
    assertNull(ctx.getCacheId(), "no cache-id should be reported after shutdown");
    assertFalse(ctx.usingCache());
  }

  @Test
  public void shutdown_isIdempotent_releasesOnlyOnce() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(cacheIdResponse(CACHE_ID));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull())).thenReturn(new Parameters());
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    ctx.shutdown();
    ctx.shutdown(); // reached from best-effort teardown paths; must be a safe no-op

    verify(client, times(1)).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull());
    assertNull(ctx.getCacheId());
    assertFalse(ctx.usingCache());
  }

  @Test
  public void shutdown_noActiveCache_isNoOp() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(false)); // no cache started
    ILoggingService logger = mock(ILoggingService.class);
    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    ctx.shutdown();

    verify(client, never()).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), any());
  }

  /**
   * When a second context wraps a client that already carries a cache-id header
   * (the IG publisher's version comparators reuse the master client for their
   * per-version contexts), it must adopt that cache rather than starting a second
   * one. Starting again appended a second X-Cache-Id header, which the server
   * reads as one unknown id ("id1, id2") and rejects with CACHE_ID_UNKNOWN.
   */
  @Test
  public void sharedClientWithExistingCacheId_adoptsInsteadOfStartingSecondCache() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.getClientHeaders()).thenReturn(java.util.Collections.singletonList(
      new HTTPHeader(TerminologyClientContext.CACHE_ID_HEADER, CACHE_ID)));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, false, logger);

    assertEquals(CACHE_ID, ctx.getCacheId(), "the existing cache-id should be adopted");
    assertTrue(ctx.usingCache());
    verify(client, never()).cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any());
    verify(client, never()).addClientHeader(any());
  }

  @Test
  public void adoptedCache_isNotReleasedByShutdown() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.getClientHeaders()).thenReturn(java.util.Collections.singletonList(
      new HTTPHeader(TerminologyClientContext.CACHE_ID_HEADER, CACHE_ID)));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, false, logger);
    assertEquals(CACHE_ID, ctx.getCacheId());

    ctx.shutdown();

    // the owning context may still be using the cache; the adopter must not end it
    verify(client, never()).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), any());
    assertNull(ctx.getCacheId(), "the adopter no longer reports the cache after shutdown");
    assertFalse(ctx.usingCache());
  }

  // ---- shared contexts (TerminologyClientManager.copy) ----
  //
  // TerminologyClientManager.copy shares server contexts by reference, so a worker
  // context built by copying another ends up with the SAME TerminologyClientContext
  // in its manager - and the same server-side cache. Whichever worker context is
  // unloaded first must not end that cache: the other one is still sending its
  // cache-id on every request, and the server would (correctly) reject those as
  // referencing a cache that no longer exists.

  private TerminologyClientManager newManager() {
    return new TerminologyClientManager(mock(IModelContext.class), mock(ITerminologyClientFactoryN.class), mock(ILoggingService.class));
  }

  private TerminologyClientManager managerFor(ITerminologyClientN client) throws IOException {
    TerminologyClientManager mgr = newManager();
    mgr.setMasterClient(client, null);
    return mgr;
  }

  private ITerminologyClientN cachingClientMock() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(cacheIdResponse(CACHE_ID));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull())).thenReturn(new Parameters());
    return client;
  }

  @Test
  public void unsharedManager_shutdownStillEndsTheCache() throws IOException {
    ITerminologyClientN client = cachingClientMock();
    TerminologyClientManager mgr = managerFor(client);
    assertEquals(1, mgr.getMaster().getHolderCount());

    mgr.shutdown();

    verify(client, times(1)).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull());
  }

  @Test
  public void copiedManager_firstShutdownDoesNotEndTheSharedCache() throws IOException {
    ITerminologyClientN client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientManager copy = newManager();
    copy.copy(original);

    assertEquals(2, original.getMaster().getHolderCount(), "both managers hold the same context");

    copy.shutdown();

    verify(client, never()).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), any());
    assertTrue(original.getMaster().usingCache(), "the original manager is still caching");
    assertEquals(CACHE_ID, original.getMaster().getCacheId());
  }

  @Test
  public void copiedManager_lastShutdownEndsTheCacheExactlyOnce() throws IOException {
    ITerminologyClientN client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientManager copy = newManager();
    copy.copy(original);

    copy.shutdown();
    original.shutdown();

    verify(client, times(1)).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull());
  }

  @Test
  public void copiedManager_orderDoesNotMatter_originalFirst() throws IOException {
    ITerminologyClientN client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientManager copy = newManager();
    copy.copy(original);

    // The manager that started the cache lets go first - the copy is still working.
    original.shutdown();

    verify(client, never()).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), any());
    assertTrue(copy.getMaster().usingCache());

    copy.shutdown();
    verify(client, times(1)).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull());
  }

  /**
   * unload() is best-effort and may run more than once, so a repeated manager
   * shutdown must not consume a second hold - that would end a cache the other
   * manager is still using, which is the very bug this counting prevents.
   */
  @Test
  public void managerShutdown_isIdempotent_doesNotOverReleaseASharedContext() throws IOException {
    ITerminologyClientN client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientManager copy = newManager();
    copy.copy(original);

    copy.shutdown();
    copy.shutdown();
    copy.shutdown();

    verify(client, never()).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), any());
    assertEquals(1, original.getMaster().getHolderCount(), "only one hold should have been released");
    assertTrue(original.getMaster().usingCache());
  }

  @Test
  public void copyingAfterShutdown_doesNotResurrectAHold() throws IOException {
    ITerminologyClientN client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientContext ctx = original.getMaster();

    original.shutdown();
    assertEquals(0, ctx.getHolderCount());

    ctx.retain(); // a copy of an already-torn-down manager
    assertEquals(0, ctx.getHolderCount(), "a released context has nothing left to hold");

    ctx.shutdown();
    verify(client, times(1)).cacheControl(eq(ITerminologyClientN.CacheControlMode.END_CACHE), isNull());
  }

  // ---- when the server no longer has the cache ----

  /** A client mock that keeps its headers, as a real client does. */
  private ITerminologyClientN headerKeepingMock(CapabilityStatement cs, List<HTTPHeader> headers) throws IOException {
    ITerminologyClientN client = baseMock(cs);
    when(client.addClientHeader(any())).thenAnswer(inv -> { headers.add(inv.getArgument(0)); return client; });
    when(client.setClientHeaders(any())).thenAnswer(inv -> { headers.clear(); headers.addAll(((ClientHeaders) inv.getArgument(0)).headers()); return client; });
    when(client.getClientHeaders()).thenAnswer(inv -> new ArrayList<>(headers));
    return client;
  }

  private static String cacheHeader(List<HTTPHeader> headers) {
    String v = null;
    int n = 0;
    for (HTTPHeader h : headers) {
      if (TerminologyClientContext.CACHE_ID_HEADER.equals(h.getName())) {
        v = h.getValue();
        n++;
      }
    }
    assertTrue(n <= 1, "never more than one cache-id header");
    return v;
  }

  /** The error the server sends for a cache it doesn't have: 404, tx-issue-type cache-id-unknown. */
  private static EFhirClientException cacheIdUnknown(String id) {
    OperationOutcome oo = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent iss = oo.addIssue();
    iss.setSeverity(OperationOutcome.IssueSeverity.ERROR);
    iss.setCode(OperationOutcome.IssueType.NOTFOUND);
    iss.getDetails().setText("The cache '" + id + "' was never issued by this server");
    iss.getDetails().addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "cache-id-unknown", null);
    iss.addExtension("http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id", new StringType("CACHE_ID_UNKNOWN"));
    return new EFhirClientException(404, "Server returned error code 404: The cache '" + id + "' was never issued by this server", oo);
  }

  @Test
  public void cacheGone_forgetsWhatTheServerHad_startsANewCache_andSendsTheRequestAgain() throws IOException {
    List<HTTPHeader> headers = new ArrayList<>();
    ITerminologyClientN client = headerKeepingMock(capabilityStatement(true), headers);
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any())).thenReturn(cacheIdResponse("one"), cacheIdResponse("two"));
    ILoggingService logger = mock(ILoggingService.class);
    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);
    ctx.getCached().add("http://example.org/ValueSet/x|1");

    List<String> seen = new ArrayList<>();
    String result = ctx.send(again -> {
      // what the request would send by reference, and the cache it goes with
      seen.add(again + ":" + cacheHeader(headers) + ":" + ctx.getCached().size());
      if (!again) {
        throw cacheIdUnknown("one");
      }
      return "done";
    });

    assertEquals("done", result);
    assertEquals(List.of("false:one:1", "true:two:0"), seen, "the second time, a new cache, and nothing assumed to be in it");
    assertEquals("two", ctx.getCacheId());
    assertTrue(ctx.usingCache());
    verify(client, times(2)).cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any());
    verify(logger).logMessage(argThat(m -> m != null && m.contains("no longer has the cache one")));
  }

  @Test
  public void cacheGoneAgain_theErrorGoesToTheCaller_afterOneNewCache() throws IOException {
    List<HTTPHeader> headers = new ArrayList<>();
    ITerminologyClientN client = headerKeepingMock(capabilityStatement(true), headers);
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any())).thenReturn(cacheIdResponse("one"), cacheIdResponse("two"), cacheIdResponse("three"));
    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, mock(ILoggingService.class));

    AtomicInteger runs = new AtomicInteger();
    EFhirClientException e = assertThrows(EFhirClientException.class, () -> ctx.send(again -> {
      runs.incrementAndGet();
      throw cacheIdUnknown(ctx.getCacheId());
    }));
    assertTrue(TerminologyClientContext.isCacheGone(e));
    assertEquals(2, runs.get(), "once, and once again - no more");
    verify(client, times(2)).cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any());
  }

  @Test
  public void otherErrors_areNotRetried() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any())).thenReturn(cacheIdResponse(CACHE_ID));
    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, mock(ILoggingService.class));

    AtomicInteger runs = new AtomicInteger();
    assertThrows(EFhirClientException.class, () -> ctx.send(again -> {
      runs.incrementAndGet();
      throw new EFhirClientException(404, "Unknown code", (OperationOutcome) null);
    }));
    assertEquals(1, runs.get());
    verify(client, times(1)).cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any());
  }

  @Test
  public void noCache_errorsAreNotRetried() throws IOException {
    ITerminologyClientN client = baseMock(capabilityStatement(false));
    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, mock(ILoggingService.class));

    AtomicInteger runs = new AtomicInteger();
    assertThrows(EFhirClientException.class, () -> ctx.send(again -> {
      runs.incrementAndGet();
      throw cacheIdUnknown("x");
    }));
    assertEquals(1, runs.get(), "a client that didn't send a cache-id has no cache to replace");
  }

  @Test
  public void newCacheCannotStart_theRequestGoesAgainWithoutACache() throws IOException {
    List<HTTPHeader> headers = new ArrayList<>();
    ITerminologyClientN client = headerKeepingMock(capabilityStatement(true), headers);
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any())).thenReturn(cacheIdResponse("one")).thenThrow(new FHIRException("down"));
    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, mock(ILoggingService.class));

    String result = ctx.send(again -> {
      if (!again) {
        throw cacheIdUnknown("one");
      }
      return "inline";
    });
    assertEquals("inline", result);
    assertNull(ctx.getCacheId());
    assertFalse(ctx.usingCache(), "without a cache, everything is sent with the request");
    assertNull(cacheHeader(headers), "and no cache-id is sent");
  }

  @Test
  public void sharedClient_theOtherContextFollowsTheNewCache() throws IOException {
    List<HTTPHeader> headers = new ArrayList<>();
    ITerminologyClientN client = headerKeepingMock(capabilityStatement(true), headers);
    when(client.cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any())).thenReturn(cacheIdResponse("one"), cacheIdResponse("two"));
    TerminologyClientContext first = new TerminologyClientContext(client, null, true, mock(ILoggingService.class));
    TerminologyClientContext second = new TerminologyClientContext(client, null, false, mock(ILoggingService.class));
    assertEquals("one", second.getCacheId(), "the second context adopts the first's cache");
    second.getCached().add("http://example.org/CodeSystem/y|2");

    first.send(again -> {
      if (!again) {
        throw cacheIdUnknown("one");
      }
      return null;
    });
    List<String> seen = new ArrayList<>();
    second.send(again -> {
      seen.add(again + ":" + second.getCacheId() + ":" + second.getCached().size());
      return null;
    });
    assertEquals(List.of("false:two:0"), seen, "the second context uses the new cache, and assumes nothing is in it");
    verify(client, times(2)).cacheControl(eq(ITerminologyClientN.CacheControlMode.START_CACHE), any());
  }

  @Test
  public void cacheGone_isTheCodingNotTheMessageId() {
    // a cache dropped for growing too big: 404, coded cache-id-unknown, with a message id saying why
    OperationOutcome oo = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent iss = oo.addIssue();
    iss.setCode(OperationOutcome.IssueType.NOTFOUND);
    iss.getDetails().addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "cache-id-unknown", null);
    iss.addExtension("http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id", new StringType("CACHE_ID_DISCARDED_TOO_BIG"));
    assertTrue(TerminologyClientContext.isCacheGone(new EFhirClientException(404, "too big", oo)));
    // a request too big for any cache is too-costly: about the request, not the cache, so not retried
    OperationOutcome tooCostly = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent iss2 = tooCostly.addIssue();
    iss2.setCode(OperationOutcome.IssueType.TOOCOSTLY);
    iss2.getDetails().addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "too-costly", null);
    assertFalse(TerminologyClientContext.isCacheGone(new EFhirClientException(422, "too costly", tooCostly)));
    // nor a 404 that isn't about the cache, nor something wrapped that is
    assertFalse(TerminologyClientContext.isCacheGone(new EFhirClientException(404, "Unknown code", (OperationOutcome) null)));
    assertTrue(TerminologyClientContext.isCacheGone(new FHIRException("wrapped", cacheIdUnknown("x"))));
  }
}
