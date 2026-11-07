package org.hl7.fhir.validation.instance.type;

import java.util.List;

import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.SnomedRules;

/**
 * Negation codes: codes that say something is known to be absent (No known allergy, No current
 * problems), and codes that say there's no information (No information about allergies, Patient
 * not asked). A code like that is a statement in its own right, so:
 *
 * - refuting a negation is understood as refuting the negative (the patient does have it), which
 *   is surely not what was meant; refuting 'no information' refutes nothing
 * - an AllergyIntolerance with either kind of code has no reactions
 *
 * SNOMED CT negations are found by their definition (finding context = Known absent, or No known);
 * the IPS absent-unknown codes, the SNOMED CT 'no information' codes and inactive SNOMED CT
 * negations (which have lost their definitions), by list
 */
public class NegationValidator extends BaseValidator {

  private static final String RULE_DATE = "2026-11-07";
  private static final String IPS_ABSENT_UNKNOWN = "http://hl7.org/fhir/uv/ips/CodeSystem/absent-unknown-uv-ips";
  private static final List<String> SCT_NO_INFORMATION = List.of("1631000175102"); // Patient not asked
  // negations that are inactive, so no longer have the definition that says so (inactive concepts
  // keep no relationships): No known latex allergy, which US Core still uses
  private static final List<String> SCT_INACTIVE_NEGATIONS = List.of("716184000");

  private enum Negation {
    KNOWN_ABSENT, NO_INFORMATION
  }

  private SnomedRules rules;

  public NegationValidator(BaseValidator parent) {
    super(parent);
  }

  public void validate(List<ValidationMessage> errors, Element element, NodeStack stack) {
    if (!"AllergyIntolerance".equals(element.fhirType()) && !"Condition".equals(element.fhirType())) {
      return;
    }
    rules = new SnomedRules(context, settings);
    Element code = element.getNamedChild("code", false);
    if (code == null) {
      return;
    }
    NodeStack codeStack = stack.push(code, -1, null, null);
    for (Element coding : code.getChildren("coding")) {
      String system = coding.getNamedChildValue("system", false);
      String c = coding.getNamedChildValue("code", false);
      Negation neg = negation(system, c, coding.getNamedChildValue("version", false));
      if (neg == null) {
        continue;
      }
      String desc = coding.getNamedChildValue("display", false) == null ? c : c + " ('" + coding.getNamedChildValue("display", false) + "')";
      if (isRefuted(element)) {
        warning(errors, RULE_DATE, IssueType.BUSINESSRULE, code.line(), code.col(), codeStack.getLiteralPath(), false,
          neg == Negation.KNOWN_ABSENT ? I18nConstants.NEGATION_REFUTED : I18nConstants.NEGATION_REFUTED_NO_INFO, desc);
      }
      if ("AllergyIntolerance".equals(element.fhirType())) {
        List<Element> reactions = element.getChildren("reaction");
        if (!reactions.isEmpty()) {
          Element r = reactions.get(0);
          warning(errors, RULE_DATE, IssueType.BUSINESSRULE, r.line(), r.col(), stack.push(r, 0, null, null).getLiteralPath(), false,
            neg == Negation.KNOWN_ABSENT ? I18nConstants.NEGATION_ALLERGY_REACTION : I18nConstants.NEGATION_ALLERGY_REACTION_NO_INFO, desc);
        }
      }
      return; // one statement about it is enough
    }
  }

  private Negation negation(String system, String code, String version) {
    if (system == null || code == null) {
      return null;
    }
    if (IPS_ABSENT_UNKNOWN.equals(system)) {
      return code.startsWith("no-known-") ? Negation.KNOWN_ABSENT : code.endsWith("-info") ? Negation.NO_INFORMATION : null;
    }
    if (SnomedRules.SCT.equals(system)) {
      if (SCT_NO_INFORMATION.contains(code)) {
        return Negation.NO_INFORMATION;
      }
      if (SCT_INACTIVE_NEGATIONS.contains(code)) {
        return Negation.KNOWN_ABSENT;
      }
      if (code.contains(":") || code.contains("|")) {
        return null;
      }
      SnomedRules.Concept concept = rules.lookupAny(code, version, null);
      return concept != null && concept.isKnownAbsent() ? Negation.KNOWN_ABSENT : null;
    }
    return null;
  }

  private boolean isRefuted(Element element) {
    Element vs = element.getNamedChild("verificationStatus", false);
    if (vs == null) {
      return false;
    }
    for (Element coding : vs.getChildren("coding")) {
      if ("refuted".equals(coding.getNamedChildValue("code", false))) {
        return true;
      }
    }
    // R3 and earlier: verificationStatus is a code
    return "refuted".equals(vs.primitiveValue());
  }
}
