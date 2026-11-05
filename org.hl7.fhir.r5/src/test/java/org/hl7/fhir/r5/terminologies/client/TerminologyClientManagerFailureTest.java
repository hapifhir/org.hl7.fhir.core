package org.hl7.fhir.r5.terminologies.client;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.logging.ILoggingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A lookup that failed (registry or terminology server down, timeout, error) must not be
 * persisted in the tx cache as if it were an answer, or every later run reuses it. A server
 * that answered 'not found' is still remembered.
 *
 * No network access: the registry is faked by overriding fetchRegistryJson(), and the
 * terminology clients are dynamic proxies.
 */
public class TerminologyClientManagerFailureTest {

  private static final String MAIN = "https://main.example.org/r4";
  private static final String CS = "https://example.org/cs/colours";
  private static final String VS = "https://example.org/vs/colours";
  private static final String RESP = "{\"formatVersion\":\"1\",\"authoritative\":[{\"server-name\":\"Main\",\"url\":\""+MAIN+"\"}]}";

  @TempDir
  Path folder;

  @BeforeAll
  static void setup() {
    TerminologyClientContext.setAllowNonConformantServers(true);
  }

  private static class TestManager extends TerminologyClientManager {
    boolean registryDown;

    TestManager(ITerminologyClientFactory5 factory) {
      super(factory, new ILoggingService() {
        @Override
        public void logMessage(String message) {
        }
        @Override
        public void logDebugMessage(LogCategory category, String message) {
        }
      });
    }

    @Override
    protected JsonObject fetchRegistryJson(String request) throws IOException, JsonException {
      if (registryDown) {
        throw new SocketTimeoutException("Read timed out");
      }
      return JsonParser.parseObject(RESP);
    }
  }

  // serverDown: every search fails; otherwise every search is answered with an empty bundle (not found)
  private static ITerminologyClient5 makeFakeClient(final String address, final boolean serverDown) {
    return (ITerminologyClient5) Proxy.newProxyInstance(TerminologyClientManagerFailureTest.class.getClassLoader(),
        new Class<?>[] { ITerminologyClient5.class }, (proxy, method, args) -> {
      switch (method.getName()) {
      case "getAddress": return address;
      case "getUserAgent": return "fhir-core-tests";
      case "getCapabilitiesStatement":
      case "getCapabilitiesStatementQuick": return new CapabilityStatement();
      case "getTerminologyCapabilities": return new TerminologyCapabilities();
      case "search":
        if (serverDown) {
          throw new SocketTimeoutException("Read timed out");
        }
        return new Bundle();
      case "toString": return "fake client: " + address;
      case "equals": return proxy == args[0];
      case "hashCode": return System.identityHashCode(proxy);
      default:
        Class<?> rt = method.getReturnType();
        if (rt == boolean.class) return false;
        if (rt == int.class) return 0;
        if (rt == long.class) return 0L;
        return null;
      }
    });
  }

  private TestManager makeManager(boolean registryDown, boolean serverDown) throws IOException {
    TestManager mgr = new TestManager(new ITerminologyClientFactory5() {
      @Override
      public ITerminologyClient5 makeClientR5(String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException {
        return makeFakeClient(url, serverDown);
      }
      @Override
      public String getVersion() {
        return "R4";
      }
    });
    mgr.registryDown = registryDown;
    mgr.setCache(makeCache());
    mgr.setMasterClient(makeFakeClient(MAIN, serverDown), "http://main.example.org/tx-reg");
    return mgr;
  }

  private TerminologyCache makeCache() throws IOException {
    return new TerminologyCache(new Object(), folder.toString());
  }

  private String systemMap() throws IOException {
    File f = folder.resolve("system-map.json").toFile();
    return f.exists() ? FileUtilities.fileToString(f) : "";
  }

  @Test
  void registryFailureIsNotPersisted() throws IOException {
    TestManager mgr = makeManager(true, false);
    mgr.chooseServer(null, Set.of(CS), false);
    assertFalse(systemMap().contains(CS), "a fallback after a registry failure must not be persisted");

    mgr = makeManager(false, false);
    mgr.chooseServer(null, Set.of(CS), false);
    assertTrue(systemMap().contains(CS), "a registry answer is persisted");
  }

  @Test
  void serverFailureIsAFailedLookup() throws IOException {
    TestManager mgr = makeManager(false, true);
    assertNull(mgr.findValueSetOnServer(VS));
    assertTrue(mgr.lookupFailed(VS));
  }

  @Test
  void registryFailureIsAFailedLookup() throws IOException {
    TestManager mgr = makeManager(true, false);
    assertNull(mgr.findValueSetOnServer(VS));
    assertTrue(mgr.lookupFailed(VS));
    assertNull(mgr.findCodeSystemOnServer(CS));
    assertTrue(mgr.lookupFailed(CS));
  }

  @Test
  void lookupsStayFailedOnceTheRegistryIsSwitchedOff() throws IOException {
    TestManager mgr = makeManager(true, false);
    for (int i = 0; i < 4; i++) {
      mgr.findValueSetOnServer(VS + i);
    }
    // the registry is now switched off for this run, so lookups skip it
    assertNull(mgr.findValueSetOnServer(VS));
    assertTrue(mgr.lookupFailed(VS));
    assertNull(mgr.findCodeSystemOnServer(CS));
    assertTrue(mgr.lookupFailed(CS));
    mgr.chooseServer(null, Set.of(CS), false);
    assertFalse(systemMap().contains(CS));
  }

  @Test
  void notFoundIsAnAnswer() throws IOException {
    TestManager mgr = makeManager(false, false);
    assertNull(mgr.findValueSetOnServer(VS));
    assertFalse(mgr.lookupFailed(VS));
    assertNull(mgr.findCodeSystemOnServer(CS));
    assertFalse(mgr.lookupFailed(CS));
  }

  @Test
  void aLaterAnswerClearsTheFailure() throws IOException {
    TestManager mgr = makeManager(true, false);
    mgr.findValueSetOnServer(VS);
    assertTrue(mgr.lookupFailed(VS));
    mgr.registryDown = false;
    mgr.findValueSetOnServer(VS);
    assertFalse(mgr.lookupFailed(VS));
  }

  @Test
  void failedLookupsAreKeptForTheRunButNotSaved() throws IOException {
    TerminologyCache cache = makeCache();
    cache.cacheValueSet(VS, null, false);
    cache.cacheCodeSystem(CS, null, false);
    cache.cacheValueSet(VS + "-known", null, true);
    cache.cacheCodeSystem(CS + "-known", null);
    assertTrue(cache.hasValueSet(VS));
    assertTrue(cache.hasCodeSystem(CS));

    TerminologyCache next = makeCache();
    assertFalse(next.hasValueSet(VS));
    assertFalse(next.hasCodeSystem(CS));
    assertTrue(next.hasValueSet(VS + "-known"));
    assertTrue(next.hasCodeSystem(CS + "-known"));
  }
}
