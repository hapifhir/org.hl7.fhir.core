package org.hl7.fhir.r5.terminologies.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A Coding with a system but no code has nothing to look up, so it is reported as having no code -
 * whether or not the code system is known - rather than as a code system that could not be found.
 * A system that is really a ValueSet or some other resource is still reported as such.
 */
class ValueSetValidatorNoCodeTest {

  private static final String KNOWN_CS = "http://example.org/fhir/CodeSystem/known";
  private static final String UNKNOWN_CS = "http://example.org/fhir/CodeSystem/unknown";
  private static final String VS_URL = "http://example.org/fhir/ValueSet/both";
  private static final String INCOMPLETE_CS = "http://example.org/fhir/CodeSystem/incomplete";
  private static final String INCOMPLETE_VS_URL = "http://example.org/fhir/ValueSet/incomplete";
  private static final String CM_URL = "http://example.org/fhir/ConceptMap/map";

  private SimpleWorkerContext ctxt;

  @BeforeEach
  void setUp() throws Exception {
    ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    ctxt.setExpansionParameters(new Parameters());
    CodeSystem cs = new CodeSystem();
    cs.setUrl(KNOWN_CS);
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("a").setDisplay("A");
    ctxt.cacheResource(cs);
    ValueSet vs = new ValueSet();
    vs.setUrl(VS_URL);
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem(KNOWN_CS);
    vs.getCompose().addInclude().setSystem(UNKNOWN_CS);
    ctxt.cacheResource(vs);
    CodeSystem incomplete = new CodeSystem();
    incomplete.setUrl(INCOMPLETE_CS);
    incomplete.setStatus(PublicationStatus.RETIRED);
    incomplete.setContent(CodeSystemContentMode.NOTPRESENT);
    incomplete.setVersionNeeded(true);
    ctxt.cacheResource(incomplete);
    ValueSet ivs = new ValueSet();
    ivs.setUrl(INCOMPLETE_VS_URL);
    ivs.setStatus(PublicationStatus.ACTIVE);
    ivs.getCompose().addInclude().setSystem(INCOMPLETE_CS);
    ctxt.cacheResource(ivs);
    ConceptMap cm = new ConceptMap();
    cm.setUrl(CM_URL);
    cm.setStatus(PublicationStatus.ACTIVE);
    ctxt.cacheResource(cm);
  }

  private static List<String> messageIds(ValidationResult vr) {
    return vr.getIssues().stream()
      .map(i -> i.getExtensionString(ExtensionDefinitions.EXT_ISSUE_MSG_ID))
      .collect(Collectors.toList());
  }

  private static OperationOutcomeIssueComponent only(ValidationResult vr, String msgId) {
    List<OperationOutcomeIssueComponent> l = vr.getIssues().stream()
      .filter(i -> msgId.equals(i.getExtensionString(ExtensionDefinitions.EXT_ISSUE_MSG_ID)))
      .collect(Collectors.toList());
    assertEquals(1, l.size(), "issues: " + messageIds(vr));
    return l.get(0);
  }

  private static void assertNoCodeSystemNotFound(ValidationResult vr) {
    assertTrue(messageIds(vr).stream().noneMatch(id -> id != null && id.startsWith("UNKNOWN_CODESYSTEM")), "issues: " + messageIds(vr));
  }

  @Test
  void codeableConceptWithUnknownSystemAndNoCode() {
    CodeableConcept cc = new CodeableConcept().addCoding(new Coding().setSystem(UNKNOWN_CS).setDisplay("Something"));
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), cc, null);
    OperationOutcomeIssueComponent iss = only(vr, I18nConstants.NO_CODE_PROVIDED);
    assertEquals("CodeableConcept.coding[0]", iss.getExpression().get(0).getValue());
    assertEquals("No code provided for CodeSystem '" + UNKNOWN_CS + "'", iss.getDetails().getText());
    assertNoCodeSystemNotFound(vr);
  }

  @Test
  void codeableConceptWithUnknownSystemAndNoCodeAgainstValueSet() {
    CodeableConcept cc = new CodeableConcept().addCoding(new Coding().setSystem(UNKNOWN_CS).setDisplay("Something"));
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), cc, ctxt.fetchResource(ValueSet.class, VS_URL));
    only(vr, I18nConstants.NO_CODE_PROVIDED);
    assertNoCodeSystemNotFound(vr);
  }

  @Test
  void codingWithUnknownSystemAndNoCode() {
    Coding c = new Coding().setSystem(UNKNOWN_CS).setDisplay("Something");
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), c, ctxt.fetchResource(ValueSet.class, VS_URL));
    OperationOutcomeIssueComponent iss = only(vr, I18nConstants.NO_CODE_PROVIDED);
    assertEquals("Coding", iss.getExpression().get(0).getValue());
    assertNoCodeSystemNotFound(vr);
  }

  @Test
  void codeableConceptWithKnownSystemAndNoCodeIsUnchanged() {
    CodeableConcept cc = new CodeableConcept().addCoding(new Coding().setSystem(KNOWN_CS).setDisplay("A"));
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), cc, null);
    OperationOutcomeIssueComponent iss = only(vr, I18nConstants.NO_CODE_PROVIDED);
    assertEquals("CodeableConcept.coding[0]", iss.getExpression().get(0).getValue());
  }

  @Test
  void unknownSystemWithACodeIsStillReportedAsUnknown() {
    // control: the same unknown system, with a code, is still reported as not found
    CodeableConcept cc = new CodeableConcept().addCoding(new Coding(UNKNOWN_CS, "x", null));
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), cc, null);
    assertTrue(messageIds(vr).contains(I18nConstants.UNKNOWN_CODESYSTEM), "issues: " + messageIds(vr));
    assertFalse(messageIds(vr).contains(I18nConstants.NO_CODE_PROVIDED));
  }

  @Test
  void codingWithValueSetAsSystemAndNoCodeIsReportedAsAValueSet() {
    Coding c = new Coding().setSystem(VS_URL).setDisplay("Something");
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), c, ctxt.fetchResource(ValueSet.class, VS_URL));
    OperationOutcomeIssueComponent iss = only(vr, I18nConstants.TERMINOLOGY_TX_SYSTEM_VALUESET2);
    assertEquals("Coding.system", iss.getExpression().get(0).getValue());
    assertFalse(messageIds(vr).contains(I18nConstants.NO_CODE_PROVIDED), "issues: " + messageIds(vr));
  }

  @Test
  void codingWithOtherResourceAsSystemAndNoCodeIsReportedAsThatResource() {
    Coding c = new Coding().setSystem(CM_URL).setDisplay("Something");
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), c, ctxt.fetchResource(ValueSet.class, VS_URL));
    OperationOutcomeIssueComponent iss = only(vr, I18nConstants.TERMINOLOGY_TX_SYSTEM_OTHER_RESOURCE);
    assertTrue(iss.getDetails().getText().contains("ConceptMap"), iss.getDetails().getText());
    assertFalse(messageIds(vr).contains(I18nConstants.NO_CODE_PROVIDED), "issues: " + messageIds(vr));
  }

  @Test
  void codeableConceptWithValueSetAsSystemAndNoCodeIsNotReportedAsNoCode() {
    CodeableConcept cc = new CodeableConcept().addCoding(new Coding().setSystem(VS_URL).setDisplay("Something"));
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), cc, null);
    assertFalse(messageIds(vr).contains(I18nConstants.NO_CODE_PROVIDED), "issues: " + messageIds(vr));
    // handled as a coding with a code would be: with no terminology server, the system is not found
    assertEquals("CodeableConcept.coding[0].system", only(vr, I18nConstants.UNKNOWN_CODESYSTEM).getExpression().get(0).getValue());
  }

  @Test
  void codeableConceptWithOtherResourceAsSystemAndNoCodeIsNotReportedAsNoCode() {
    CodeableConcept cc = new CodeableConcept().addCoding(new Coding().setSystem(CM_URL).setDisplay("Something"));
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), cc, null);
    assertFalse(messageIds(vr).contains(I18nConstants.NO_CODE_PROVIDED), "issues: " + messageIds(vr));
    // handled as a coding with a code would be: with no terminology server, the system is not found
    assertEquals("CodeableConcept.coding[0].system", only(vr, I18nConstants.UNKNOWN_CODESYSTEM).getExpression().get(0).getValue());
  }

  @Test
  void codingWithIncompleteCodeSystemAndNoCodeStillGetsCodeSystemChecks() {
    Coding c = new Coding().setSystem(INCOMPLETE_CS).setDisplay("Something");
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), c, ctxt.fetchResource(ValueSet.class, INCOMPLETE_VS_URL));
    only(vr, I18nConstants.NO_CODE_PROVIDED);
    only(vr, I18nConstants.MSG_RETIRED);
    assertEquals("Coding.version", only(vr, I18nConstants.CODESYSTEM_VERSION_NEEDED).getExpression().get(0).getValue());
  }

  @Test
  void codeableConceptWithIncompleteCodeSystemAndNoCodeStillGetsCodeSystemChecks() {
    CodeableConcept cc = new CodeableConcept().addCoding(new Coding().setSystem(INCOMPLETE_CS).setDisplay("Something"));
    ValidationResult vr = ctxt.validateCode(new ValidationOptions(), cc, ctxt.fetchResource(ValueSet.class, INCOMPLETE_VS_URL));
    only(vr, I18nConstants.NO_CODE_PROVIDED);
    only(vr, I18nConstants.MSG_RETIRED);
    assertEquals("CodeableConcept.coding[0].version", only(vr, I18nConstants.CODESYSTEM_VERSION_NEEDED).getExpression().get(0).getValue());
  }
}
