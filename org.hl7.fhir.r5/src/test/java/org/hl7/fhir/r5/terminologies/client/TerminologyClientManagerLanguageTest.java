package org.hl7.fhir.r5.terminologies.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.context.ILoggingService;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests for language aware server resolution in the ecosystem client - the tx-reg
 * /resolve language parameter, language specific routing, and the language dimension
 * of the resolution cache. See "Language Specific Claims" in the tx ecosystem IG.
 *
 * These tests run without any network access: the coordination server is faked by
 * overriding TerminologyClientManager.fetchRegistryJson(), and the terminology
 * clients themselves are dynamic proxies that answer only what
 * TerminologyClientContext needs to initialize.
 */
public class TerminologyClientManagerLanguageTest {

  private static final String MAIN = "https://main.example.org/r4";
  private static final String DE_SERVER = "https://de.example.org/r4";
  private static final String CS = "https://example.org/cs/colours";

  // no language: only the default (language independent) authoritative server
  private static final String RESP_NONE = "{\"formatVersion\":\"1\",\"registry-url\":\"http://main.example.org/tx-reg\","+
      "\"authoritative\":[{\"server-name\":\"Main\",\"url\":\""+MAIN+"\"}]}";
  // language=de: the German server first (matched on its language specific claim), then the default
  private static final String RESP_DE = "{\"formatVersion\":\"1\",\"registry-url\":\"http://main.example.org/tx-reg\","+
      "\"authoritative\":[{\"server-name\":\"German\",\"url\":\""+DE_SERVER+"\",\"languages\":[\"de\"]},{\"server-name\":\"Main\",\"url\":\""+MAIN+"\"}],"+
      "\"candidates\":[{\"server-name\":\"Bystander\",\"url\":\"http://x.example.org/r4\",\"language-support\":\"unknown\"}]}";
  // language=fr: nobody claims fr - default routing only
  private static final String RESP_FR = "{\"formatVersion\":\"1\",\"registry-url\":\"http://main.example.org/tx-reg\","+
      "\"authoritative\":[{\"server-name\":\"Main\",\"url\":\""+MAIN+"\"}]}";

  @BeforeAll
  public static void setup() {
    TerminologyClientContext.setAllowNonConformantServers(true);
  }

  private static class TestManager extends TerminologyClientManager {
    List<String> requests = new ArrayList<>();

    TestManager(ITerminologyClientFactory factory, ILoggingService logger) {
      super(factory, logger);
    }

    @Override
    protected JsonObject fetchRegistryJson(String request) throws IOException, JsonException {
      requests.add(request);
      String json;
      if (request.contains("language=de")) { // covers de and de-AT weighted lists
        json = RESP_DE;
      } else if (request.contains("language=fr")) {
        json = RESP_FR;
      } else {
        json = RESP_NONE;
      }
      return JsonParser.parseObject(json);
    }

    String lastRequest() {
      return requests.get(requests.size() - 1);
    }
  }

  private static ITerminologyClient makeFakeClient(final String address) {
    return (ITerminologyClient) Proxy.newProxyInstance(TerminologyClientManagerLanguageTest.class.getClassLoader(),
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
    TestManager mgr = new TestManager(new TestFactory(), quietLogger());
    mgr.setMasterClient(makeFakeClient(MAIN), true);
    return mgr;
  }

  private Set<String> systems() {
    Set<String> s = new HashSet<>();
    s.add(CS);
    return s;
  }

  @Test
  public void testNoLanguageUsesDefaultRouting() throws IOException {
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(), false);
    assertEquals(MAIN, tc.getAddress());
    assertTrue(!mgr.lastRequest().contains("language="), "no language parameter expected, got: "+mgr.lastRequest());
  }

  @Test
  public void testLanguageRoutesToLanguageSpecificServer() throws IOException {
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(), false, "de");
    assertEquals(DE_SERVER, tc.getAddress());
    assertTrue(mgr.lastRequest().contains("&language=de"), "language parameter expected, got: "+mgr.lastRequest());
  }

  @Test
  public void testUnclaimedLanguageFallsBackToDefaultServer() throws IOException {
    TestManager mgr = makeManager();
    TerminologyClientContext tc = mgr.chooseServer(null, systems(), false, "fr");
    assertEquals(MAIN, tc.getAddress());
    assertTrue(mgr.lastRequest().contains("&language=fr"));
  }

  @Test
  public void testResolutionsAreCachedPerLanguage() throws IOException {
    TestManager mgr = makeManager();
    mgr.chooseServer(null, systems(), false, "de");
    int n = mgr.requests.size();
    // same system + same language: cached, no new registry call
    TerminologyClientContext tc = mgr.chooseServer(null, systems(), false, "de");
    assertEquals(DE_SERVER, tc.getAddress());
    assertEquals(n, mgr.requests.size());
    // same system, no language: NOT the German resolution - a fresh registry call, routed to the default
    tc = mgr.chooseServer(null, systems(), false);
    assertEquals(MAIN, tc.getAddress());
    assertEquals(n + 1, mgr.requests.size());
    // and a different language is a different resolution again
    tc = mgr.chooseServer(null, systems(), false, "fr");
    assertEquals(MAIN, tc.getAddress());
    assertEquals(n + 2, mgr.requests.size());
  }

  @Test
  public void testWeightedLanguageListIsPassedThrough() throws IOException {
    TestManager mgr = makeManager();
    String lang = "de-AT, de;q=0.9, en;q=0.1";
    TerminologyClientContext tc = mgr.chooseServer(null, systems(), false, lang);
    assertEquals(DE_SERVER, tc.getAddress());
    assertTrue(mgr.lastRequest().contains("&language="+Utilities.URLEncode(lang)),
        "weighted language list expected in request, got: "+mgr.lastRequest());
  }

  @Test
  public void testExpansionLanguageComesFromExpansionParameters() throws IOException {
    // when no language is passed for an expansion, the displayLanguage fixed in the
    // expansion parameters is used for routing (same pattern as system-version)
    TestManager mgr = makeManager();
    Parameters p = new Parameters();
    p.addParameter("displayLanguage", "de");
    mgr.setExpansionParameters(p);
    TerminologyClientContext tc = mgr.chooseServer(null, systems(), true);
    assertEquals(DE_SERVER, tc.getAddress());
    assertTrue(mgr.lastRequest().contains("&language=de"));
  }

  @Test
  public void testValidationIgnoresExpansionDisplayLanguage() throws IOException {
    // the expansion parameter fallback is only for expansions - a language-free
    // validation must get default routing even when expansion parameters carry a language
    TestManager mgr = makeManager();
    Parameters p = new Parameters();
    p.addParameter("displayLanguage", "de");
    mgr.setExpansionParameters(p);
    TerminologyClientContext tc = mgr.chooseServer(null, systems(), false);
    assertEquals(MAIN, tc.getAddress());
    assertTrue(!mgr.lastRequest().contains("language="));
  }
}
