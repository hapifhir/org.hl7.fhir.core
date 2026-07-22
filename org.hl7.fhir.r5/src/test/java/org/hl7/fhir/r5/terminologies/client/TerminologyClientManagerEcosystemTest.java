package org.hl7.fhir.r5.terminologies.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.r5.context.ILoggingService;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Live ecosystem tests for language aware routing, using the Czech language claim for
 * EDQM Standard Terms (hl7-cz registers languages: {"cs": ["http://standardterms.edqm.eu"]},
 * with tx.hl7.cz hosting EDQM plus the Czech language designations).
 *
 * These tests talk to the real coordination server (tx-reg), but never to the terminology
 * servers themselves - the clients are fakes, so only routing is tested. The server can be
 * overridden with -Dtx.ecosystem.test.server=http://localhost:3001/r4 to test against a
 * local ecosystem.
 *
 * The tests skip (with a reason) when the ecosystem is unreachable, or when the coordination
 * server is not language aware yet (no languages / language-support properties in the resolve
 * response) - so they become live automatically once the updated registry server is deployed.
 */
public class TerminologyClientManagerEcosystemTest {

  private static final String MASTER = System.getProperty("tx.ecosystem.test.server", "http://tx.fhir.org/r4");
  private static final String EDQM = "http://standardterms.edqm.eu";
  private static final String CZ_SERVER = "https://tx.hl7.cz/r4";

  @BeforeAll
  public static void setup() {
    TerminologyClientContext.setAllowNonConformantServers(true);
  }

  private static String monitorUrl() {
    return Utilities.pathURL(Utilities.getDirectoryForURL(MASTER), "tx-reg");
  }

  /**
   * skip unless the coordination server is reachable AND language aware: a resolve with a
   * language must mark its entries (languages on authoritative matches, language-support
   * on candidates). Before the updated server is deployed, these tests skip rather than fail.
   */
  private static void assumeLanguageAwareEcosystem() {
    boolean languageAware = false;
    String reason;
    try {
      JsonObject json = JsonParser.parseObjectFromUrl(Utilities.pathURL(monitorUrl(),
          "resolve?fhirVersion=R4&url="+Utilities.URLEncode(EDQM)+"&language=cs"));
      for (JsonObject item : json.getJsonObjects("authoritative")) {
        if (item.has("languages")) {
          languageAware = true;
        }
      }
      for (JsonObject item : json.getJsonObjects("candidates")) {
        if (item.has("language-support")) {
          languageAware = true;
        }
      }
      reason = "the coordination server at "+monitorUrl()+" is not language aware (yet)";
    } catch (Exception e) {
      reason = "the ecosystem at "+monitorUrl()+" is not reachable: "+e.getMessage();
    }
    Assumptions.assumeTrue(languageAware, reason);
  }

  private static ITerminologyClient makeFakeClient(final String address) {
    return (ITerminologyClient) Proxy.newProxyInstance(TerminologyClientManagerEcosystemTest.class.getClassLoader(),
        new Class<?>[] { ITerminologyClient.class }, (proxy, method, args) -> {
      switch (method.getName()) {
      case "getAddress": return address;
      case "getUserAgent": return "fhir-core-tests";
      case "getCapabilitiesStatement":
      case "getCapabilitiesStatementQuick": return new CapabilityStatement();
      case "getTerminologyCapabilities": return new TerminologyCapabilities();
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

  private static class TestFactory implements TerminologyClientManager.ITerminologyClientFactory {
    @Override
    public ITerminologyClient makeClient(String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException {
      return makeFakeClient(url);
    }
    @Override
    public String getVersion() {
      return "R4";
    }
  }

  private TerminologyClientManager makeManager() throws IOException {
    TerminologyClientManager mgr = new TerminologyClientManager(new TestFactory(), new ILoggingService() {
      @Override
      public void logMessage(String message) {
      }
      @Override
      public void logDebugMessage(LogCategory category, String message) {
      }
    });
    mgr.setMasterClient(makeFakeClient(MASTER), true);
    return mgr;
  }

  private Set<String> systems() {
    Set<String> s = new HashSet<>();
    s.add(EDQM);
    return s;
  }

  private boolean routedAuthoritatively(TerminologyClientManager mgr) {
    for (TerminologyClientManager.InternalLogEvent e : mgr.getInternalLog()) {
      if (e.getMessage() != null && e.getMessage().startsWith("Found authoritative server")) {
        return true;
      }
    }
    return false;
  }

  @Test
  public void testEdqmInCzechRoutesToCzechServer() throws IOException {
    assumeLanguageAwareEcosystem();
    TerminologyClientManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(), false, "cs");
    assertEquals(CZ_SERVER, tc.getAddress(),
        "a Czech-language EDQM request should route to the server with the Czech language claim");
    assertTrue(routedAuthoritatively(mgr), "the Czech server should be chosen via its authoritative (language) claim");
  }

  @Test
  public void testEdqmWithoutLanguageIsNotAuthoritativelyRouted() throws IOException {
    assumeLanguageAwareEcosystem();
    TerminologyClientManager mgr = makeManager();
    mgr.chooseServer(null, systems(), false);
    // nobody makes a language independent authoritative claim for EDQM, and the Czech
    // language claim must be invisible to a language-free request
    assertTrue(!routedAuthoritatively(mgr),
        "a language-free EDQM request must not be routed via the Czech language claim");
  }
}
