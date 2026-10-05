package org.hl7.fhir.r5.terminologies.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
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
  private static final String DOWN = "https://down.example.org/r4";

  private static final String CS_A = "http://example.org/cs/a";
  private static final String CS_B = "http://example.org/cs/b";
  private static final String CS_C = "http://example.org/cs/c";
  private static final String CS_D = "http://example.org/cs/d";
  private static final String VS_D = "http://example.org/vs/d";
  private static final String CS_UNKNOWN = "http://example.org/cs/nobody-has-this";

  // A and B: MAIN is authoritative, X and Y are candidates (the THO pattern)
  private static final String RESP_AUTH = "{\"authoritative\":[{\"url\":\""+MAIN+"\"}],"+
      "\"candidates\":[{\"url\":\""+X+"\"},{\"url\":\""+Y+"\"}]}";
  // C: nobody authoritative, X and Y are candidates
  private static final String RESP_CAND = "{\"candidates\":[{\"url\":\""+X+"\"},{\"url\":\""+Y+"\"}]}";
  // D: only DOWN is authoritative (the NPU pattern: one national server for the code system)
  private static final String RESP_DOWN = "{\"authoritative\":[{\"url\":\""+DOWN+"\"}]}";
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
  /** server address -> how many more connection attempts fail, as with a server answering 502 */
  private final Map<String, Integer> failures = new HashMap<>();
  /** server address -> how often a connection to it was attempted */
  private final Map<String, Integer> connects = new HashMap<>();
  /** the pauses between connection attempts, which the tests record rather than wait out */
  private final List<Long> pauses = new ArrayList<>();
  /** whether a pause is interrupted, as when the run is cancelled */
  private boolean interruptOnPause;

  private class TestManager extends TerminologyClientManager {
    TestManager() {
      super(new TestFactory(), quietLogger());
    }

    @Override
    protected void pause(long millis) {
      pauses.add(millis);
      if (interruptOnPause) {
        Thread.currentThread().interrupt();
      }
    }

    @Override
    protected JsonObject fetchRegistryJson(String request) throws IOException, JsonException {
      String json;
      if (request.contains(enc(CS_A)) || request.contains(enc(CS_B))) {
        json = RESP_AUTH;
      } else if (request.contains(enc(CS_C))) {
        json = RESP_CAND;
      } else if (request.contains(enc(CS_D)) || request.contains(enc(VS_D))) {
        json = RESP_DOWN;
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
      case "getCapabilitiesStatementQuick":
        connects.put(address, connects.getOrDefault(address, 0) + 1);
        int f = failures.getOrDefault(address, 0);
        if (f > 0) {
          failures.put(address, f - 1);
          throw new FHIRException("Error fetching the server's capability statement: Error from "+address+": 502 Bad Gateway");
        }
        return new CapabilityStatement();
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

  private void down(String address) {
    failures.put(address, Integer.MAX_VALUE);
  }

  @Test
  void testUnreachableServerIsReportedAsUnavailable() throws IOException {
    // the registry routes D to a server that is down: rather than failing on the first code
    // from D, the run gets a context that stands in for the server, and says why
    down(DOWN);
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(CS_D), false);
    assertEquals(DOWN, tc.getAddress());
    assertTrue(tc.isUnavailable());
    assertTrue(tc.getUnavailableReason().contains("502 Bad Gateway"), tc.getUnavailableReason());
    assertTrue(tc.supportsSystem(CS_D), "the requests should be made, and fail as server errors");
    assertTrue(logged(mgr, "Error accessing "+DOWN+" for "+CS_D), "expected the failure to be reported: "+messages(mgr));
    assertFalse(mgr.serverMap().containsKey(DOWN), "an unreachable server must not be registered");
  }

  @Test
  void testConnectIsRetriedBeforeGivingUp() throws IOException {
    down(DOWN);
    TestManager mgr = makeManager();
    mgr.chooseServer(null, systems(CS_D), false);
    assertEquals(3, connects.getOrDefault(DOWN, 0), "expected three attempts: "+connects);
    assertEquals(List.of(2000L, 5000L), pauses);
  }

  @Test
  void testServerThatAnswersOnRetryIsUsed() throws IOException {
    // a server that fails once - restarting, say - is used once it answers
    failures.put(DOWN, 1);
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(CS_D), false);
    assertEquals(DOWN, tc.getAddress());
    assertFalse(tc.isUnavailable());
    assertEquals(2, connects.getOrDefault(DOWN, 0));
    assertFalse(logged(mgr, "Error accessing"), "nothing to report: "+messages(mgr));
  }

  @Test
  void testUnreachableServerIsNotTriedAgain() throws IOException {
    // every code from D is routed to DOWN; one round of attempts is enough to know it's down
    down(DOWN);
    TestManager mgr = makeManager();
    mgr.chooseServer(null, systems(CS_D), false);
    assertTrue(mgr.chooseServer(null, systems(CS_D), true).isUnavailable());
    assertTrue(mgr.chooseServer(VS_D, false).isUnavailable());
    assertEquals(3, connects.getOrDefault(DOWN, 0), "DOWN should be tried in one round only: "+connects);
  }


  @Test
  void testUnreachableCandidateIsDroppedNotReplacedByPrimary() throws IOException {
    // the support check asks whether X itself has C. X being down must count as "no", not
    // be answered by the primary server, which has C too and would then win X's place
    down(X);
    hosted.put(MAIN, systems(CS_C));
    hosted.put(Y, systems(CS_C));
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(CS_C), false);
    assertEquals(Y, tc.getAddress());
    for (String s : searches) {
      assertFalse(s.startsWith(MAIN+"|"), "the primary server should not have been asked: "+searches);
    }
  }








  @Test
  void testServerThatIsNotApprovedIsReportedNotRetried() throws IOException {
    // a server that answers, but fails checkFeature(), isn't down: the reason, and the hint how to
    // allow it, must reach the user, and retrying won't change the answer
    TestManager mgr = makeManager();
    boolean canAllow = TerminologyClientContext.isCanAllowNonConformantServers();
    TerminologyClientContext.setAllowNonConformantServers(false);
    TerminologyClientContext.setCanAllowNonConformantServers(true);
    try {
      TerminologyServiceException e = assertThrows(TerminologyServiceException.class, () -> mgr.chooseServer(null, systems(CS_D), false));
      assertTrue(e.getMessage().contains("-authorise-non-conformant-tx-servers"), e.getMessage());
      assertEquals(1, connects.getOrDefault(DOWN, 0), "should not be retried: "+connects);
      assertTrue(pauses.isEmpty());
    } finally {
      TerminologyClientContext.setAllowNonConformantServers(true);
      TerminologyClientContext.setCanAllowNonConformantServers(canAllow);
    }
  }

  @Test
  void testInterruptStopsRetrying() throws IOException {
    down(DOWN);
    interruptOnPause = true;
    TestManager mgr = makeManager();
    try {
      TerminologyClientContext tc = mgr.chooseServer(null, systems(CS_D), false);
      assertTrue(tc.isUnavailable());
      assertEquals(1, connects.getOrDefault(DOWN, 0), "no attempt after the interrupt: "+connects);
    } finally {
      Thread.interrupted(); // clear the flag for the other tests
    }
  }

}
