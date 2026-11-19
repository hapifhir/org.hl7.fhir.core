package org.hl7.fhir.standalone.terminology.expansion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.services.client.TerminologyClientR6;
import org.hl7.fhir.services.terminology.ExpansionOptions;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyOperationContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.services.terminology.ValueSetExpansionOutcome;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

class ValueSetExpanderTests {

  private static final String SYSTEM = "http://acme.test/cs";

  private static CodeSystem codeSystem(String version) {
    CodeSystem cs = new CodeSystem();
    cs.setUrl(SYSTEM);
    cs.setVersion(version);
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("a");
    return cs;
  }

  private static ValueSet valueSet(String systemVersion) {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://acme.test/vs");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem(SYSTEM).setVersion(systemVersion).addConcept().setCode("a");
    return vs;
  }

  private static ValueSetExpansionOutcome expand(SimpleWorkerContext context, ValueSet vs) {
    TerminologyOperationContext opContext = new TerminologyOperationContext(context, ValidationOptions.defaults(), "test");
    ValueSetExpander expander = new ValueSetExpander(context, opContext);
    expander.setNoTerminologyServer(true);
    return expander.expand(vs, new Parameters());
  }

  @Test
  void testUnknownVersionWhenALoadedCodeSystemHasNoVersion() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext());
    context.cacheResource(codeSystem(null));
    context.cacheResource(codeSystem("1"));

    ValueSetExpansionOutcome outcome = expand(context, valueSet("2"));

    assertFalse(outcome.isOk());
    assertNotNull(outcome.getError());
    assertTrue(outcome.getError().contains("version '2' could not be found"), outcome.getError());
    assertTrue(outcome.getError().contains("1"), outcome.getError());
    assertFalse(outcome.getError().contains("NullPointerException"), outcome.getError());
  }

  @Test
  void testExceptionWithoutAMessageIsNotOk() throws IOException {
    SimpleWorkerContext context = spy(new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext()));
    doThrow(new NullPointerException()).when(context)
        .fetchSupplementedCodeSystem(anyString(), any(), any(), any(), any());

    ValueSetExpansionOutcome outcome = expand(context, valueSet(null));

    assertFalse(outcome.isOk());
    assertEquals(NullPointerException.class.getName(), outcome.getError());
  }

  // --- compose.exclude on code systems the terminology server provides (fhir-ig-publisher#1469) ---------------------
  //
  // These go through the worker context's expandVS(ExpansionOptions, ValueSet), with the options the IG publisher
  // uses to render expansions, against a real terminology server (tx-dev.fhir.org + the tx ecosystem). The
  // value sets are shared with the validator test cases (validator/vs-exclude-*.json in fhir-test-cases).

  private static SimpleWorkerContext txContext() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext());
    context.connectToTSServer(new TerminologyClientR6.TerminologyClientR6Factory(), "https://tx-dev.fhir.org", "ValueSetExpanderTests", Utilities.path("[tmp]", "tx-log.html"), FhirSettings.getTxEcosystem());
    return context;
  }

  private static ValueSet loadValueSet(SimpleWorkerContext context, String name) throws IOException {
    return (ValueSet) new JsonParser(context.getModelContext()).parse(TestingUtilities.loadTestResourceStream("validator", name));
  }

  private static ValueSet expandAsPublisher(SimpleWorkerContext context, ValueSet vs) {
    ValueSetExpansionOutcome outcome = context.expandVS(new ExpansionOptions().withHierarchical(true).withIncompleteOk(true), vs);
    assertNotNull(outcome.getValueset(), outcome.getError());
    return outcome.getValueset();
  }

  private static Set<String> codes(List<ValueSetExpansionContainsComponent> contains, Set<String> codes) {
    for (ValueSetExpansionContainsComponent c : contains) {
      if (c.hasCode()) {
        codes.add(c.getCode());
      }
      codes(c.getContainsList(), codes);
    }
    return codes;
  }

  private static void checkExpansionParameters(ValueSet exp) {
    Set<String> names = new HashSet<>();
    for (ValueSetExpansionParameterComponent p : exp.getExpansion().getParameterList()) {
      assertTrue(p.hasValue() && !"null".equals(p.getValue().primitiveValue()), "expansion parameter " + p.getName() + " has no value");
      if (!Utilities.existsInList(p.getName(), "used-codesystem", "used-valueset", "used-supplement", "version", "warning-deprecated", "warning-retired", "warning-withdrawn", "warning-draft", "warning-experimental")) {
        assertTrue(names.add(p.getName()), "expansion parameter " + p.getName() + " is repeated");
      }
    }
  }

  @Test
  void testExcludeOnServerSideCodeSystem() throws IOException {
    SimpleWorkerContext context = txContext();
    ValueSet exp = expandAsPublisher(context, loadValueSet(context, "vs-exclude-loinc.json"));
    Set<String> codes = codes(exp.getExpansion().getContainsList(), new HashSet<>());

    // one code from each include
    assertTrue(codes.contains("105604-3"), "105604-3 should be in the expansion");
    assertTrue(codes.contains("10347-3"), "10347-3 should be in the expansion");
    // explicit code excludes
    for (String code : new String[] {"44851-4", "44852-2", "44854-8", "44855-5"}) {
      assertFalse(codes.contains(code), code + " is excluded by code, but is in the expansion");
    }
    // filter exclude (COMPONENT = LP442509-8)
    assertFalse(codes.contains("33270-0"), "33270-0 is excluded by filter, but is in the expansion");
    // tx-dev.fhir.org gives 100 codes for the whole value set with LOINC 2.83 - this may change with a new LOINC version
    assertEquals(100, codes.size());
    if (exp.getExpansion().hasTotal()) {
      assertEquals(codes.size(), exp.getExpansion().getTotal());
    }
    checkExpansionParameters(exp);
  }

  // is-a 46635009, less 290002008 and is-a 70694009 (the same codes in the International and Czech editions)
  private static final List<String> DIABETES_CODES = List.of("1217068008", "1255271005", "190368000", "190372001", "199229001",
      "23045005", "28032008", "31321000119102", "426875007", "444073006", "444074000", "46635009", "609564002", "609566000",
      "703137001", "722454003", "870528001");
  // is-a 49436004, less 314208002 and is-a 282825002 (Estonian edition)
  private static final List<String> AF_CODES = List.of("120041000119109", "1389267007", "233910005", "233911009",
      "280797561000119107", "300996004", "313377641000119105", "426749004", "440028005", "440059007", "489609371000119104",
      "49436004", "706923002", "715395008", "762247006");

  private static void checkSnomedExpansion(String name) throws IOException {
    SimpleWorkerContext context = txContext();
    ValueSet exp = expandAsPublisher(context, loadValueSet(context, name));
    Set<String> codes = codes(exp.getExpansion().getContainsList(), new HashSet<>());

    Set<String> expected = new HashSet<>(DIABETES_CODES);
    expected.addAll(AF_CODES);
    assertEquals(new TreeSet<>(expected), new TreeSet<>(codes));
    if (exp.getExpansion().hasTotal()) {
      assertEquals(expected.size(), exp.getExpansion().getTotal());
    }
    checkExpansionParameters(exp);
  }

  /**
   * International + Estonian editions. term.tehik.ee has both, so one server can do it all
   */
  @Test
  void testExcludeOnOneServer() throws IOException {
    checkSnomedExpansion("vs-exclude-sct-multi.json");
  }

  /**
   * Czech + Estonian editions. Only tx.hl7.cz has the Czech edition, and only term.tehik.ee has the Estonian one,
   * so it takes two servers
   */
  @Test
  void testExcludeAcrossServers() throws IOException {
    checkSnomedExpansion("vs-exclude-sct-split.json");
  }
}
