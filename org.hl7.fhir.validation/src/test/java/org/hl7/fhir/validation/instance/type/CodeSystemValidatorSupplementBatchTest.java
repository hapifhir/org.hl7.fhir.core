package org.hl7.fhir.validation.instance.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * CodeSystem supplements routinely carry hundreds or thousands of concepts. These tests check that
 * validating them costs a handful of server round trips rather than one per concept, and - the part
 * that actually matters - that batching them does not cost us per-concept diagnostics.
 *
 * The terminology server is a recording fake, so the request counts asserted here are exact.
 *
 * Note: a small, varying number of leading concepts get resolved by the worker context without ever
 * reaching the server. That is pre-existing behaviour of the local validation pass, and it happens
 * whether or not codes are batched, so these tests assert on the shape of the server traffic (one
 * batch call vs one call per concept) rather than on an exact code count.
 */
class CodeSystemValidatorSupplementBatchTest {

  /** must not start with http://example.org or http://acme.com - getTxSupportInfo shortcuts those */
  private static final String BASE_SYSTEM = "http://unit-test.org/fhir/CodeSystem/";

  private static SimpleWorkerContext context;

  @BeforeAll
  static void setUpContext() {
    // our own context rather than the shared one, so that wiring a fake terminology server into it
    // cannot disturb other tests running in parallel
    context = TestingUtilities.getWorkerContext("5.0.0");
  }

  /**
   * A terminology server that records what it was asked. Only the handful of methods the validation
   * path actually uses are implemented; everything else returns a harmless default.
   */
  private static class RecordingServer implements InvocationHandler {
    private final String system;
    private final String txTestVersion;
    private final Set<String> invalidCodes;
    /** if >= 0, answer only this many codes per batch, to simulate a truncated response */
    private final int truncateBatchTo;

    private int validateCSCalls = 0;
    private int batchValidateCSCalls = 0;
    private int batchValidateVSCalls = 0;
    private final List<String> seenCodes = new ArrayList<>();

    RecordingServer(String system, String txTestVersion, Set<String> invalidCodes, int truncateBatchTo) {
      this.system = system;
      this.txTestVersion = txTestVersion;
      this.invalidCodes = invalidCodes;
      this.truncateBatchTo = truncateBatchTo;
    }

    /** total server round trips - the number this whole exercise is about */
    int requests() {
      return validateCSCalls + batchValidateCSCalls + batchValidateVSCalls;
    }

    private CapabilityStatement capabilities() {
      CapabilityStatement cs = new CapabilityStatement();
      cs.getSoftware().setName("recording-fake").setVersion("1.0.0");
      Extension tv = cs.addExtension().setUrl(ExtensionDefinitions.EXT_FEATURE);
      tv.addExtension("definition", new UriType(ExtensionDefinitions.FEATURE_TX_TEST_VERSION));
      tv.addExtension("value", new StringType(txTestVersion));
      Extension csp = cs.addExtension().setUrl(ExtensionDefinitions.EXT_FEATURE);
      csp.addExtension("definition", new UriType(ExtensionDefinitions.FEATURE_TX_CS_PARAMS));
      csp.addExtension("value", new StringType("true"));
      return cs;
    }

    private TerminologyCapabilities terminologyCapabilities() {
      TerminologyCapabilities tc = new TerminologyCapabilities();
      tc.getSoftware().setName("recording-fake").setVersion("1.0.0");
      tc.addCodeSystem().setUri(system);
      return tc;
    }

    /** the answer for a single code, in the shape processValidationResult expects */
    private Parameters resultFor(Coding c) {
      Parameters r = new Parameters();
      boolean ok = !invalidCodes.contains(c.getCode());
      r.addParameter("result", ok);
      r.addParameter().setName("system").setValue(new UriType(c.getSystem()));
      r.addParameter().setName("code").setValue(new CodeType(c.getCode()));
      if (!ok) {
        r.addParameter("message", "Unknown code '" + c.getCode() + "' in the CodeSystem '" + c.getSystem() + "'");
      }
      return r;
    }

    private Coding codingOf(Parameters item) {
      for (ParametersParameterComponent p : item.getParameter()) {
        if ("coding".equals(p.getName()) && p.getValue() instanceof Coding) {
          return (Coding) p.getValue();
        }
      }
      return null;
    }

    private Parameters handleBatch(Parameters in) {
      Parameters out = new Parameters();
      int emitted = 0;
      for (ParametersParameterComponent p : in.getParameter()) {
        if ("validation".equals(p.getName()) && p.getResource() instanceof Parameters) {
          Coding c = codingOf((Parameters) p.getResource());
          seenCodes.add(c.getCode());
          if (truncateBatchTo >= 0 && emitted >= truncateBatchTo) {
            continue;
          }
          out.addParameter().setName("validation").setResource(resultFor(c));
          emitted++;
        }
      }
      return out;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
      switch (method.getName()) {
      case "getAddress":
        // a distinct address per test: terminology capabilities are cached per server address, and a
        // shared address lets one test's capabilities leak into another's
        return "http://tx.unit-test.org/" + system.substring(system.lastIndexOf('/') + 1);
      case "getId":
        return "recording-fake";
      case "getUserAgent":
        return "fhir-core-tests";
      case "getServerVersion":
        return "1.0.0";
      case "getCapabilitiesStatement":
      case "getCapabilitiesStatementQuick":
        return capabilities();
      case "getTerminologyCapabilities":
        return terminologyCapabilities();
      case "validateCS":
        validateCSCalls++;
        seenCodes.add(codingOf((Parameters) args[0]).getCode());
        return resultFor(codingOf((Parameters) args[0]));
      case "batchValidateCS":
        batchValidateCSCalls++;
        return handleBatch((Parameters) args[0]);
      case "batchValidateVS":
        batchValidateVSCalls++;
        return handleBatch((Parameters) args[0]);
      case "toString":
        return "recording fake server";
      case "equals":
        return proxy == args[0];
      case "hashCode":
        return System.identityHashCode(proxy);
      default:
        Class<?> rt = method.getReturnType();
        if (rt == boolean.class) return false;
        if (rt == int.class) return 0;
        if (rt == long.class) return 0L;
        if (ITerminologyClient.class.isAssignableFrom(rt)) return proxy; // chained setters
        return null;
      }
    }
  }

  private static ITerminologyClient asClient(RecordingServer handler) {
    return (ITerminologyClient) Proxy.newProxyInstance(CodeSystemValidatorSupplementBatchTest.class.getClassLoader(),
        new Class<?>[] { ITerminologyClient.class }, handler);
  }

  private static String supplementJson(String system, List<String> codes) {
    StringBuilder b = new StringBuilder();
    b.append("{\"resourceType\":\"CodeSystem\",");
    b.append("\"url\":\"" + system + "-supplement\",");
    b.append("\"version\":\"1.0.0\",");
    b.append("\"name\":\"TestSupplement\",");
    b.append("\"title\":\"Test Supplement\",");
    b.append("\"status\":\"active\",");
    b.append("\"experimental\":false,");
    b.append("\"date\":\"2026-01-01\",");
    b.append("\"publisher\":\"Test\",");
    b.append("\"content\":\"supplement\",");
    b.append("\"supplements\":\"" + system + "\",");
    b.append("\"concept\":[");
    for (int i = 0; i < codes.size(); i++) {
      if (i > 0) {
        b.append(",");
      }
      b.append("{\"code\":\"" + codes.get(i) + "\",\"display\":\"Display for " + codes.get(i) + "\"}");
    }
    b.append("]}");
    return b.toString();
  }

  /** Runs the real CodeSystemValidator over a supplement, against the recording server. */
  private static List<ValidationMessage> validate(RecordingServer server, String system, List<String> codes) throws Exception {
    // a fresh in-memory cache per run, so a cached result never hides a request we expect to see.
    // This must happen before the client is wired in, because the client context captures the cache
    context.initTxCache(new TerminologyCache(new Object(), null));
    context.getTxClientManager().setMasterClient(asClient(server), false);
    context.setExpansionParameters(new Parameters());

    Element cs = Manager.parseSingle(context,
        new ByteArrayInputStream(supplementJson(system, codes).getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON);
    InstanceValidator.setParents(cs);

    InstanceValidator parent = new InstanceValidator(context, null, null, new ValidatorSession(), new ValidatorSettings());
    List<ValidationMessage> errors = new ArrayList<>();
    ValidationContext valContext = new ValidationContext(null, cs);
    NodeStack stack = new NodeStack(context, null, cs, null);

    new CodeSystemValidator(parent).validateCodeSystem(valContext, errors, cs, stack, new ValidationOptions());
    return errors;
  }

  /** just the "this code isn't valid in the supplemented system" messages */
  private static List<ValidationMessage> supplementErrors(List<ValidationMessage> errors) {
    return errors.stream()
        .filter(m -> I18nConstants.CODESYSTEM_CS_SUPP_INVALID_CODE.equals(m.getMessageId()))
        .collect(Collectors.toList());
  }

  private static List<String> codes(int n) {
    List<String> codes = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      codes.add("code-" + i);
    }
    return codes;
  }

  private static Map<Integer, ValidationMessage> byConcept(List<ValidationMessage> messages) {
    Map<Integer, ValidationMessage> map = new HashMap<>();
    for (ValidationMessage m : messages) {
      map.put(conceptIndexOf(m), m);
    }
    return map;
  }

  private static int conceptIndexOf(ValidationMessage m) {
    String loc = m.getLocation();
    return Integer.parseInt(loc.substring(loc.indexOf('[') + 1, loc.indexOf(']')));
  }

  @Test
  void batchedValidationMakesOneRequestForTheWholeSupplement() throws Exception {
    String system = BASE_SYSTEM + "batch-one";
    RecordingServer server = new RecordingServer(system, TerminologyClientContext.LATEST_VERSION, new HashSet<>(), -1);

    List<ValidationMessage> errors = validate(server, system, codes(50));

    assertEquals(1, server.batchValidateCSCalls, "50 concepts should cost exactly one batch request");
    assertEquals(0, server.validateCSCalls, "should not fall back to one-at-a-time validation");
    assertEquals(1, server.requests(), "one round trip in total");
    assertEquals(0, supplementErrors(errors).size(), "all codes are valid, so no supplement errors");
  }

  /**
   * The before/after comparison: a server that does not advertise the batch test version drives the
   * old one-request-per-concept behaviour through exactly the same code.
   */
  @Test
  void unbatchedServerStillValidatesOneCodePerRequest() throws Exception {
    String system = BASE_SYSTEM + "no-batch";
    // 1.6.0 is >= MIN_TEST_VERSION so the server is usable, but < TX_BATCH_VERSION (1.7.8)
    RecordingServer server = new RecordingServer(system, "1.6.0", new HashSet<>(), -1);

    validate(server, system, codes(50));

    assertEquals(0, server.batchValidateCSCalls, "must not batch against a server that cannot do it");
    assertEquals(server.seenCodes.size(), server.validateCSCalls, "one request per code");
    // the contrast that matters: the batched run costs 1 request for the same 50 concepts
    assertTrue(server.validateCSCalls > 10,
        "expected one request per concept, got only " + server.validateCSCalls);
  }

  /**
   * The point of the whole exercise: batching must not blur which concept was wrong.
   */
  @Test
  void everyInvalidConceptIsReportedAgainstItsOwnConcept() throws Exception {
    String system = BASE_SYSTEM + "attribution";
    int n = 50;
    // every code is invalid, so every concept must produce its own error
    RecordingServer server = new RecordingServer(system, TerminologyClientContext.LATEST_VERSION, new HashSet<>(codes(n)), -1);

    List<ValidationMessage> errors = validate(server, system, codes(n));

    assertEquals(1, server.batchValidateCSCalls, "still only one request");

    // every code the server was asked about was invalid, so each must come back as its own error
    Set<String> asked = new HashSet<>(server.seenCodes);
    assertTrue(asked.size() > 10, "sanity: the concepts should have reached the server, got " + asked.size());

    List<ValidationMessage> supp = supplementErrors(errors);
    assertTrue(supp.size() > 10, "the invalid concepts should be reported, got " + supp.size());

    // every message must sit on its own concept and name that concept's own code
    Set<String> reported = new HashSet<>();
    for (ValidationMessage m : supp) {
      int index = conceptIndexOf(m);
      String code = "code-" + index;
      assertTrue(reported.add(code), "concept[" + index + "] reported more than once");
      assertTrue(m.getMessage().contains("'" + code + "'"),
          "message at concept[" + index + "] should name " + code + " but was: " + m.getMessage());
    }
    // this is the property that batching must not break: every code the server rejected comes back
    // as an error on that code's own concept
    assertTrue(reported.containsAll(asked),
        "codes rejected by the server but not reported: " + asked.stream().filter(c -> !reported.contains(c)).collect(Collectors.toList()));
  }

  /**
   * Batched and unbatched validation must produce identical diagnostics.
   */
  @Test
  void batchedAndUnbatchedProduceTheSameDiagnostics() throws Exception {
    int n = 60;
    Set<String> bad = new HashSet<>(codes(n));

    String batchedSystem = BASE_SYSTEM + "same-batched";
    List<ValidationMessage> batched = supplementErrors(
        validate(new RecordingServer(batchedSystem, TerminologyClientContext.LATEST_VERSION, bad, -1), batchedSystem, codes(n)));

    String singleSystem = BASE_SYSTEM + "same-single";
    List<ValidationMessage> single = supplementErrors(
        validate(new RecordingServer(singleSystem, "1.6.0", bad, -1), singleSystem, codes(n)));

    assertTrue(single.size() > 5, "sanity: the unbatched run should flag the concepts, got " + single.size());
    assertTrue(batched.size() > 5, "sanity: the batched run should flag the concepts, got " + batched.size());

    // compare concept-by-concept: for every concept both runs reported, the diagnostic must be identical
    Map<Integer, ValidationMessage> singleByConcept = byConcept(single);
    Map<Integer, ValidationMessage> batchedByConcept = byConcept(batched);
    Set<Integer> common = new HashSet<>(singleByConcept.keySet());
    common.retainAll(batchedByConcept.keySet());
    assertTrue(common.size() > 5, "the two runs should overlap on the concepts, got " + common.size());

    for (Integer i : common) {
      ValidationMessage s = singleByConcept.get(i);
      ValidationMessage b = batchedByConcept.get(i);
      assertEquals(s.getLocation(), b.getLocation(), "same location, concept " + i);
      assertEquals(s.getLevel(), b.getLevel(), "same severity, concept " + i);
      // the messages embed the code system url, which differs between the two runs by construction
      assertEquals(s.getMessage().replace(singleSystem, ""), b.getMessage().replace(batchedSystem, ""),
          "same message text, concept " + i);
    }
  }

  @Test
  void largeSupplementIsSplitIntoCappedBatches() throws Exception {
    String system = BASE_SYSTEM + "capped";
    RecordingServer server = new RecordingServer(system, TerminologyClientContext.LATEST_VERSION, new HashSet<>(), -1);

    validate(server, system, codes(700));

    // VALIDATION_BATCH_SIZE is 300, so ~700 concepts is several batches, not one giant request
    assertTrue(server.seenCodes.size() > 600, "most concepts should still be validated, got " + server.seenCodes.size());
    int expectedBatches = (server.seenCodes.size() + 299) / 300;
    assertEquals(expectedBatches, server.batchValidateCSCalls, "batches should be capped at 300 codes each");
    assertTrue(server.batchValidateCSCalls >= 3, "700 concepts should need at least 3 batches");
  }

  /**
   * If the server answers a batch incompletely we must not mis-attribute the answers we did get, and
   * must not blow up - every unanswered concept gets its own error.
   */
  @Test
  void truncatedBatchResponseIsReportedPerConcept() throws Exception {
    String system = BASE_SYSTEM + "truncated";
    int answered = 4;
    RecordingServer server = new RecordingServer(system, TerminologyClientContext.LATEST_VERSION, new HashSet<>(), answered);

    List<ValidationMessage> errors = validate(server, system, codes(100));

    assertEquals(1, server.batchValidateCSCalls);
    assertTrue(server.seenCodes.size() > answered, "sanity: more codes were sent than the server answered");

    List<ValidationMessage> supp = supplementErrors(errors);
    assertEquals(server.seenCodes.size() - answered, supp.size(),
        "every code the server failed to answer should be reported individually");

    // the codes the server did answer must not be reported as errors
    Set<String> answeredCodes = new HashSet<>(server.seenCodes.subList(0, answered));
    for (ValidationMessage m : supp) {
      String code = "code-" + conceptIndexOf(m);
      assertTrue(!answeredCodes.contains(code), "code " + code + " was answered OK but was reported as an error");
    }
  }
}
