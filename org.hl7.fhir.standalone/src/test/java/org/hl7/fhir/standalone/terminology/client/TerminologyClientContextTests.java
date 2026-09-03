package org.hl7.fhir.standalone.terminology.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.model.core.IdType;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.TerminologyCapabilities;
import org.hl7.fhir.services.context.ILoggingService;
import org.hl7.fhir.services.terminology.ITerminologyClient;
import org.hl7.fhir.services.terminology.ITerminologyClientFactory;
import org.hl7.fhir.utilities.http.HTTPHeader;
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

  private ITerminologyClient baseMock(CapabilityStatement cs) throws IOException {
    ITerminologyClient client = mock(ITerminologyClient.class);
    when(client.getAddress()).thenReturn("http://tx.example.org/r6");
    when(client.getCapabilitiesStatement()).thenReturn(cs);
    when(client.getTerminologyCapabilities()).thenReturn(new TerminologyCapabilities());
    when(client.addClientHeader(any())).thenReturn(client);
    return client;
  }

  @Test
  public void serverAdvertisesCacheControl_startsCacheAndSetsHeader() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(cacheIdResponse(CACHE_ID));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertEquals(CACHE_ID, ctx.getCacheId(), "the server-issued cache-id should be stored");
    assertTrue(ctx.usingCache(), "caching should be engaged");
    verify(client).cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), argThat(sealedFalseBody()));
    verify(client).addClientHeader(argThat(h ->
      TerminologyClientContext.CACHE_ID_HEADER.equals(h.getName()) && CACHE_ID.equals(h.getValue())));
  }

  @Test
  public void serverDoesNotAdvertiseCacheControl_noCacheStarted() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(false));
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
    ITerminologyClient client = baseMock(capabilityStatement(true));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertNull(ctx.getCacheId());
    assertFalse(ctx.usingCache());
    verify(client, never()).cacheControl(any(), any());
  }

  @Test
  public void startFails_cachingOffAndLogged() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenThrow(new FHIRException("server unavailable"));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertNull(ctx.getCacheId(), "a failed start must leave the cache-id null");
    assertFalse(ctx.usingCache());
    verify(logger).logMessage(argThat(m -> m != null && m.contains("tx.example.org")));
    verify(client, never()).addClientHeader(any());
  }

  @Test
  public void startReturnsNoCacheId_cachingOffAndLogged() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(new Parameters()); // no cache-id parameter
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertNull(ctx.getCacheId());
    assertFalse(ctx.usingCache());
    verify(logger).logMessage(argThat(m -> m != null && m.contains("no cache-id")));
  }

  @Test
  public void shutdown_releasesOwnedCache() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(cacheIdResponse(CACHE_ID));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull())).thenReturn(new Parameters());
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);
    assertEquals(CACHE_ID, ctx.getCacheId());

    ctx.shutdown();

    verify(client).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull());
    assertNull(ctx.getCacheId(), "no cache-id should be reported after shutdown");
    assertFalse(ctx.usingCache());
  }

  @Test
  public void shutdown_isIdempotent_releasesOnlyOnce() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(cacheIdResponse(CACHE_ID));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull())).thenReturn(new Parameters());
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    ctx.shutdown();
    ctx.shutdown(); // reached from best-effort teardown paths; must be a safe no-op

    verify(client, times(1)).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull());
    assertNull(ctx.getCacheId());
    assertFalse(ctx.usingCache());
  }

  @Test
  public void shutdown_noActiveCache_isNoOp() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(false)); // no cache started
    ILoggingService logger = mock(ILoggingService.class);
    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    ctx.shutdown();

    verify(client, never()).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), any());
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
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.getClientHeaders()).thenReturn(java.util.Collections.singletonList(
      new HTTPHeader(TerminologyClientContext.CACHE_ID_HEADER, CACHE_ID)));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, false, logger);

    assertEquals(CACHE_ID, ctx.getCacheId(), "the existing cache-id should be adopted");
    assertTrue(ctx.usingCache());
    verify(client, never()).cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), any());
    verify(client, never()).addClientHeader(any());
  }

  @Test
  public void adoptedCache_isNotReleasedByShutdown() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.getClientHeaders()).thenReturn(java.util.Collections.singletonList(
      new HTTPHeader(TerminologyClientContext.CACHE_ID_HEADER, CACHE_ID)));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, false, logger);
    assertEquals(CACHE_ID, ctx.getCacheId());

    ctx.shutdown();

    // the owning context may still be using the cache; the adopter must not end it
    verify(client, never()).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), any());
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
    return new TerminologyClientManager(mock(IModelContext.class), mock(ITerminologyClientFactory.class), mock(ILoggingService.class));
  }

  private TerminologyClientManager managerFor(ITerminologyClient client) throws IOException {
    TerminologyClientManager mgr = newManager();
    mgr.setMasterClient(client, false);
    return mgr;
  }

  private ITerminologyClient cachingClientMock() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), argThat(sealedFalseBody()))).thenReturn(cacheIdResponse(CACHE_ID));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull())).thenReturn(new Parameters());
    return client;
  }

  @Test
  public void unsharedManager_shutdownStillEndsTheCache() throws IOException {
    ITerminologyClient client = cachingClientMock();
    TerminologyClientManager mgr = managerFor(client);
    assertEquals(1, mgr.getMaster().getHolderCount());

    mgr.shutdown();

    verify(client, times(1)).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull());
  }

  @Test
  public void copiedManager_firstShutdownDoesNotEndTheSharedCache() throws IOException {
    ITerminologyClient client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientManager copy = newManager();
    copy.copy(original);

    assertEquals(2, original.getMaster().getHolderCount(), "both managers hold the same context");

    copy.shutdown();

    verify(client, never()).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), any());
    assertTrue(original.getMaster().usingCache(), "the original manager is still caching");
    assertEquals(CACHE_ID, original.getMaster().getCacheId());
  }

  @Test
  public void copiedManager_lastShutdownEndsTheCacheExactlyOnce() throws IOException {
    ITerminologyClient client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientManager copy = newManager();
    copy.copy(original);

    copy.shutdown();
    original.shutdown();

    verify(client, times(1)).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull());
  }

  @Test
  public void copiedManager_orderDoesNotMatter_originalFirst() throws IOException {
    ITerminologyClient client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientManager copy = newManager();
    copy.copy(original);

    // The manager that started the cache lets go first - the copy is still working.
    original.shutdown();

    verify(client, never()).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), any());
    assertTrue(copy.getMaster().usingCache());

    copy.shutdown();
    verify(client, times(1)).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull());
  }

  /**
   * unload() is best-effort and may run more than once, so a repeated manager
   * shutdown must not consume a second hold - that would end a cache the other
   * manager is still using, which is the very bug this counting prevents.
   */
  @Test
  public void managerShutdown_isIdempotent_doesNotOverReleaseASharedContext() throws IOException {
    ITerminologyClient client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientManager copy = newManager();
    copy.copy(original);

    copy.shutdown();
    copy.shutdown();
    copy.shutdown();

    verify(client, never()).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), any());
    assertEquals(1, original.getMaster().getHolderCount(), "only one hold should have been released");
    assertTrue(original.getMaster().usingCache());
  }

  @Test
  public void copyingAfterShutdown_doesNotResurrectAHold() throws IOException {
    ITerminologyClient client = cachingClientMock();
    TerminologyClientManager original = managerFor(client);
    TerminologyClientContext ctx = original.getMaster();

    original.shutdown();
    assertEquals(0, ctx.getHolderCount());

    ctx.retain(); // a copy of an already-torn-down manager
    assertEquals(0, ctx.getHolderCount(), "a released context has nothing left to hold");

    ctx.shutdown();
    verify(client, times(1)).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull());
  }
}
