package org.hl7.fhir.terminologies.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.model.core.TerminologyCapabilities;
import org.hl7.fhir.services.client.ITerminologyClientFactoryN;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.standalone.terminology.client.TerminologyClientContext;
import org.hl7.fhir.standalone.terminology.client.TerminologyClientManager;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.logging.ILoggingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests for unknown-host in the ecosystem client: when the registry finds no server for a
 * code system and says that no server hosts any code system on its host, the registry isn't
 * asked about that host's other code systems again (in this run). See 'Unknown Hosts' in the
 * tx ecosystem IG.
 *
 * No network access: the registry is faked by overriding fetchRegistryJson(), and the
 * terminology clients are dynamic proxies.
 */
class TerminologyClientManagerUnknownHostTest {

  private static final String MAIN = "https://main.example.org/r4";
  private static final String OTHER = "https://other.example.org/r4";
  private static final String DN = "http://dnvimatis.com/fhir/CodeSystem/";

  @BeforeAll
  static void setup() {
    TerminologyClientContext.setAllowNonConformantServers(true);
  }

  /**
   * The fake registry: dnvimatis.com is unknown; known.example.org has a server; on
   * odd.example.org the registry names another host as unknown; on mixed.example.org it
   * names the host as unknown, but with a server (which a registry shouldn't do); anything
   * else has no server, and nothing said about the host
   */
  private static class TestManager extends TerminologyClientManager {
    List<String> asked = new ArrayList<>();

    TestManager() {
      super(TestingUtilities.getSharedWorkerContext().getModelContext(), new TestFactory(), quietLogger());
    }

    @Override
    protected JsonObject fetchRegistryJson(String request) throws IOException, JsonException {
      String url = param(request, "url");
      asked.add(url);
      String base = "{\"formatVersion\":\"1\",\"registry-url\":\"http://main.example.org/tx-reg\"";
      String json;
      if (url.toLowerCase().contains("://dnvimatis.com")) {
        json = base + ",\"unknown-host\":\"dnvimatis.com\"}";
      } else if (url.contains("://known.example.org")) {
        json = base + ",\"authoritative\":[{\"server-name\":\"Other\",\"url\":\"" + OTHER + "\"}]}";
      } else if (url.contains("://odd.example.org")) {
        json = base + ",\"unknown-host\":\"dnvimatis.com\"}";
      } else if (url.contains("://mixed.example.org")) {
        json = base + ",\"unknown-host\":\"mixed.example.org\",\"authoritative\":[{\"server-name\":\"Other\",\"url\":\"" + OTHER + "\"}]}";
      } else {
        json = base + "}";
      }
      return JsonParser.parseObject(json);
    }
  }

  private static String param(String request, String name) {
    for (String p : request.substring(request.indexOf('?') + 1).split("&")) {
      if (p.startsWith(name + "=")) {
        return URLDecoder.decode(p.substring(name.length() + 1), StandardCharsets.UTF_8);
      }
    }
    return null;
  }

  private static ITerminologyClientN makeFakeClient(final String address) {
    return (ITerminologyClientN) Proxy.newProxyInstance(TerminologyClientManagerUnknownHostTest.class.getClassLoader(),
        new Class<?>[] { ITerminologyClientN.class }, (proxy, method, args) -> {
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

  private static class TestFactory implements ITerminologyClientFactoryN {
    @Override
    public ITerminologyClientN makeClientN(IModelContext context, String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException {
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
    mgr.setMasterClient(makeFakeClient(MAIN), "http://main.example.org/tx-reg");
    return mgr;
  }

  private static Set<String> systems(String... s) {
    return new HashSet<>(List.of(s));
  }

  @ParameterizedTest
  @CsvSource(nullValues = "null", value = {
    "http://dnvimatis.com/fhir/CodeSystem/x, dnvimatis.com",
    "https://DNVIMATIS.com/x, dnvimatis.com",
    "HTTP://dnvimatis.com, dnvimatis.com",
    "https://termgit.elga.gv.at/CodeSystem/eimpf-impfstoffe|2.6.0+20230724, termgit.elga.gv.at",
    "http://snomed.info/sct|http://snomed.info/sct/45991000052106, snomed.info",
    "http://port.example.org:8080/cs, port.example.org:8080",
    "http://port.example.org:80/cs, port.example.org",
    "https://port.example.org:443/cs, port.example.org",
    "https://port.example.org:80/cs, port.example.org:80",
    "urn:oid:1.2.246.537.6.55, null",
    "urn:rfc3881, null",
    "ftp://example.org/cs, null",
    "example.org/cs, null",
    "http://, null"
  })
  void hostOf(String url, String host) {
    assertEquals(host, TerminologyClientManager.hostOf(url));
  }

  @Test
  void hostOfNull() {
    assertNull(TerminologyClientManager.hostOf(null));
  }

  @Test
  void otherCodeSystemsOnAnUnknownHostAreNotAskedAbout() throws IOException {
    TestManager mgr = makeManager();
    assertEquals(MAIN, mgr.chooseServer(null, systems(DN + "task-subcategoryid"), false).getAddress());
    assertEquals(1, mgr.asked.size());
    assertEquals(MAIN, mgr.chooseServer(null, systems(DN + "task-infectionStatus"), false).getAddress());
    assertEquals(MAIN, mgr.chooseServer(null, systems("https://DNVIMATIS.com/fhir/CodeSystem/x|1.0"), false, "de").getAddress());
    assertNull(mgr.findCodeSystemOnServer(DN + "task-tolocationitemnodeid"));
    assertEquals(1, mgr.asked.size());
    // not a failure: it's known that there's nothing
    assertEquals(false, mgr.lookupFailed(DN + "task-tolocationitemnodeid"));
  }

  @Test
  void findCodeSystemOnServerSeesUnknownHostToo() throws IOException {
    TestManager mgr = makeManager();
    assertNull(mgr.findCodeSystemOnServer(DN + "a"));
    assertEquals(1, mgr.asked.size());
    assertEquals(MAIN, mgr.chooseServer(null, systems(DN + "b"), false).getAddress());
    assertEquals(1, mgr.asked.size());
  }

  @Test
  void onlyTheExactHost() throws IOException {
    TestManager mgr = makeManager();
    mgr.chooseServer(null, systems(DN + "a"), false);
    mgr.chooseServer(null, systems("http://dnvimatis.com.au/cs"), false);
    mgr.chooseServer(null, systems("http://www.dnvimatis.com.example/cs"), false);
    mgr.chooseServer(null, systems("urn:oid:1.2.246.537.6.55"), false);
    assertEquals(4, mgr.asked.size());
  }

  @Test
  void aHostWithAServerIsAskedAboutEachTime() throws IOException {
    TestManager mgr = makeManager();
    assertEquals(OTHER, mgr.chooseServer(null, systems("http://known.example.org/cs/a"), false).getAddress());
    mgr.chooseServer(null, systems("http://known.example.org/cs/b"), false);
    mgr.chooseServer(null, systems("http://nothing.example.org/cs/a"), false);
    mgr.chooseServer(null, systems("http://nothing.example.org/cs/b"), false);
    assertEquals(4, mgr.asked.size());
  }

  @Test
  void anUnknownHostForAnotherHostOrWithServersIsIgnored() throws IOException {
    TestManager mgr = makeManager();
    mgr.chooseServer(null, systems("http://odd.example.org/cs/a"), false);
    mgr.chooseServer(null, systems("http://odd.example.org/cs/b"), false);
    assertEquals(OTHER, mgr.chooseServer(null, systems("http://mixed.example.org/cs/a"), false).getAddress());
    mgr.chooseServer(null, systems("http://mixed.example.org/cs/b"), false);
    assertEquals(4, mgr.asked.size());
    // and the odd answer didn't make dnvimatis.com unknown
    mgr.chooseServer(null, systems(DN + "a"), false);
    assertEquals(5, mgr.asked.size());
  }

  @Test
  void theAnswerDependsOnTheUsage() throws IOException {
    TestManager mgr = makeManager();
    mgr.chooseServer(null, systems(DN + "a"), false);
    mgr.setUsage("publication");
    mgr.chooseServer(null, systems(DN + "b"), false);
    assertEquals(2, mgr.asked.size());
    mgr.chooseServer(null, systems(DN + "c"), false);
    assertEquals(2, mgr.asked.size());
  }

  @Test
  void copyKeepsTheUnknownHosts() throws IOException {
    TestManager mgr = makeManager();
    mgr.chooseServer(null, systems(DN + "a"), false);
    TestManager copy = new TestManager();
    copy.copy(mgr);
    copy.chooseServer(null, systems(DN + "b"), false);
    assertEquals(0, copy.asked.size());
  }
}
