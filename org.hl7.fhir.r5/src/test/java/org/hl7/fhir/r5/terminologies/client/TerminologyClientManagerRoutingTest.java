package org.hl7.fhir.r5.terminologies.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.logging.ILoggingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests for how chooseServer combines the registry resolutions for several code systems,
 * and when it checks that candidate servers actually have the code systems (a round trip
 * per server, so it should only happen when the check can change the outcome).
 *
 * No network access: the coordination server is faked by overriding fetchRegistryJson(),
 * and the terminology clients are dynamic proxies that record CodeSystem searches.
 */
class TerminologyClientManagerRoutingTest {

  private static final String MAIN = "https://main.example.org/r4";
  private static final String X = "https://x.example.org/r4";
  private static final String Y = "https://y.example.org/r4";

  private static final String CS_A = "http://example.org/cs/a";
  private static final String CS_B = "http://example.org/cs/b";
  private static final String CS_C = "http://example.org/cs/c";
  private static final String CS_UNKNOWN = "http://example.org/cs/nobody-has-this";

  // A and B: MAIN is authoritative, X and Y are candidates (the THO pattern)
  private static final String RESP_AUTH = "{\"authoritative\":[{\"url\":\""+MAIN+"\"}],"+
      "\"candidates\":[{\"url\":\""+X+"\"},{\"url\":\""+Y+"\"}]}";
  // C: nobody authoritative, X and Y are candidates
  private static final String RESP_CAND = "{\"candidates\":[{\"url\":\""+X+"\"},{\"url\":\""+Y+"\"}]}";
  // the registry knows no server at all
  private static final String RESP_NONE = "{}";

  @BeforeAll
  static void setup() {
    TerminologyClientContext.setAllowNonConformantServers(true);
  }

  /** server address -> code systems it really has (complete content) */
  private final Map<String, Set<String>> hosted = new HashMap<>();
  /** "server|criteria" for every CodeSystem search made */
  private final List<String> searches = new ArrayList<>();

  private class TestManager extends TerminologyClientManager {
    TestManager() {
      super(new TestFactory(), quietLogger());
    }

    @Override
    protected JsonObject fetchRegistryJson(String request) throws IOException, JsonException {
      String json;
      if (request.contains(enc(CS_A)) || request.contains(enc(CS_B))) {
        json = RESP_AUTH;
      } else if (request.contains(enc(CS_C))) {
        json = RESP_CAND;
      } else {
        json = RESP_NONE;
      }
      return JsonParser.parseObject(json);
    }
  }

  private static String enc(String url) {
    return org.hl7.fhir.utilities.Utilities.URLEncode(url);
  }

  private ITerminologyClient5 makeFakeClient(final String address) {
    return (ITerminologyClient5) Proxy.newProxyInstance(TerminologyClientManagerRoutingTest.class.getClassLoader(),
        new Class<?>[] { ITerminologyClient5.class }, (proxy, method, args) -> {
      switch (method.getName()) {
      case "getAddress": return address;
      case "getUserAgent": return "fhir-core-tests";
      case "getCapabilitiesStatement":
      case "getCapabilitiesStatementQuick": return new CapabilityStatement();
      case "getTerminologyCapabilities": return new TerminologyCapabilities();
      case "search": return search(address, (String) args[1]);
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

  private Bundle search(String address, String criteria) {
    searches.add(address+"|"+criteria);
    Bundle bnd = new Bundle();
    for (String url : hosted.getOrDefault(address, new HashSet<>())) {
      if (criteria.contains(org.hl7.fhir.utilities.Utilities.escapeUrl(url))) {
        CodeSystem cs = new CodeSystem();
        cs.setUrl(url);
        cs.setContent(CodeSystemContentMode.COMPLETE);
        bnd.addEntry().setResource(cs);
      }
    }
    return bnd;
  }

  private class TestFactory implements ITerminologyClientFactory5 {
    @Override
    public ITerminologyClient5 makeClientR5(String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException {
      return makeFakeClient(url);
    }
    @Override
    public String getVersion() {
      return "R4";
    }
  }

  private static ILoggingService quietLogger() {
    return new ILoggingService() {
      @Override
      public void logMessage(String message) {
      }
      @Override
      public void logDebugMessage(LogCategory category, String message) {
      }
    };
  }

  private TestManager makeManager() throws IOException {
    TestManager mgr = new TestManager();
    mgr.setMasterClient(makeFakeClient(MAIN), true);
    return mgr;
  }

  private static Set<String> systems(String... urls) {
    Set<String> s = new HashSet<>();
    for (String u : urls) {
      s.add(u);
    }
    return s;
  }

  private static List<String> messages(TerminologyClientManager mgr) {
    List<String> res = new ArrayList<>();
    for (TerminologyClientManager.InternalLogEvent e : mgr.getInternalLog()) {
      res.add(e.getMessage());
    }
    return res;
  }

  private static boolean logged(TerminologyClientManager mgr, String prefix) {
    for (TerminologyClientManager.InternalLogEvent e : mgr.getInternalLog()) {
      if (e.getMessage() != null && e.getMessage().startsWith(prefix)) {
        return true;
      }
    }
    return false;
  }

  @Test
  void testUnresolvedSystemDoesNotStopPartiallyAuthoritativeServer() throws IOException {
    // a value set drawing on several THO code systems plus one the registry knows nothing
    // about: MAIN is authoritative for all the known ones, so it's chosen, and no candidate
    // server is ever asked whether it has the code systems
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(CS_A, CS_B, CS_UNKNOWN), false);
    assertEquals(MAIN, tc.getAddress());
    assertTrue(logged(mgr, "Found partially authoritative server"), "expected partially authoritative routing: "+messages(mgr));
    assertEquals(0, searches.size(), "no candidate should be checked: "+searches);
  }

  @Test
  void testCandidateCheckStopsAtFirstServerThatPasses() throws IOException {
    hosted.put(X, systems(CS_C));
    hosted.put(Y, systems(CS_C));
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(CS_C, CS_UNKNOWN), false);
    assertEquals(X, tc.getAddress());
    assertTrue(logged(mgr, "Found candidate server"));
    assertEquals(1, searches.size(), "only the chosen candidate should be checked: "+searches);
    assertTrue(searches.get(0).startsWith(X+"|"));
  }

  @Test
  void testCandidateWithoutCodeSystemIsSkipped() throws IOException {
    hosted.put(Y, systems(CS_C));
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(CS_C), false);
    assertEquals(Y, tc.getAddress());
    assertTrue(logged(mgr, "Candidate server "+X+" dropped for "+CS_C), "expected X to be dropped: "+messages(mgr));
  }

  @Test
  void testNoCandidateHasCodeSystemFallsBackToPrimary() throws IOException {
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(CS_C), false);
    assertEquals(MAIN, tc.getAddress());
    assertEquals(2, searches.size(), "both candidates should have been checked: "+searches);
  }
}
