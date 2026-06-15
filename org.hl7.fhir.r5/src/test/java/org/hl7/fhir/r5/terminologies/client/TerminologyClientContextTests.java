package org.hl7.fhir.r5.terminologies.client;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.ILoggingService;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.SAXParserFactory;

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

  private ITerminologyClient baseMock(CapabilityStatement cs) throws IOException {
    ITerminologyClient client = mock(ITerminologyClient.class);
    when(client.getAddress()).thenReturn("http://tx.example.org/r5");
    when(client.getCapabilitiesStatement()).thenReturn(cs);
    when(client.getTerminologyCapabilities()).thenReturn(new TerminologyCapabilities());
    when(client.addClientHeader(any())).thenReturn(client);
    return client;
  }

  @Test
  public void serverAdvertisesCacheControl_startsCacheAndSetsHeader() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), isNull())).thenReturn(cacheIdResponse(CACHE_ID));
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertEquals(CACHE_ID, ctx.getCacheId(), "the server-issued cache-id should be stored");
    assertTrue(ctx.usingCache(), "caching should be engaged");
    verify(client).cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), isNull());
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
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), isNull())).thenThrow(new FHIRException("server unavailable"));
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
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), isNull())).thenReturn(new Parameters()); // no cache-id parameter
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    assertNull(ctx.getCacheId());
    assertFalse(ctx.usingCache());
    verify(logger).logMessage(argThat(m -> m != null && m.contains("no cache-id")));
  }

  @Test
  public void endCache_releasesAndClears() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(true));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.START_CACHE), isNull())).thenReturn(cacheIdResponse(CACHE_ID));
    when(client.cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull())).thenReturn(new Parameters());
    ILoggingService logger = mock(ILoggingService.class);

    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);
    assertEquals(CACHE_ID, ctx.getCacheId());

    ctx.endCache();

    verify(client).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), isNull());
    assertNull(ctx.getCacheId(), "cache-id should be cleared after end");
    assertFalse(ctx.usingCache());
  }

  @Test
  public void endCache_noActiveCache_isNoOp() throws IOException {
    ITerminologyClient client = baseMock(capabilityStatement(false)); // no cache started
    ILoggingService logger = mock(ILoggingService.class);
    TerminologyClientContext ctx = new TerminologyClientContext(client, null, true, logger);

    ctx.endCache();

    verify(client, never()).cacheControl(eq(ITerminologyClient.CacheControlMode.END_CACHE), any());
  }
}
