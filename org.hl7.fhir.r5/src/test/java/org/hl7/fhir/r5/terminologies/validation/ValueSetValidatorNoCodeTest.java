package org.hl7.fhir.r5.terminologies.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeableConcept;
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
 */
class ValueSetValidatorNoCodeTest {

  private static final String KNOWN_CS = "http://example.org/fhir/CodeSystem/known";
  private static final String UNKNOWN_CS = "http://example.org/fhir/CodeSystem/unknown";
  private static final String VS_URL = "http://example.org/fhir/ValueSet/both";

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
    assertTrue(!messageIds(vr).contains(I18nConstants.NO_CODE_PROVIDED));
  }
}
