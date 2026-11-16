package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.SnomedRules;
import org.hl7.fhir.validation.instance.utils.SnomedRules.Concept;
import org.hl7.fhir.validation.instance.utils.SnomedRules.Kind;
import org.hl7.fhir.validation.instance.utils.SnomedRules.Side;

/**
 * Checks SNOMED CT codes against what SNOMED CT says about them, wherever they are used in the
 * resource (so at the base, whatever the bindings and profiles):
 *
 * - the kind of concept (semantic tag) against the element: a condition is a finding, disorder
 *   or situation; a procedure is a procedure; a body site is a body structure; a specimen type
 *   is a specimen; an allergy is to a substance or product; a medication is a product; and an
 *   observation's code is not a finding. Conditions coded by their procedure, and procedures
 *   coded by their condition, are common practice (coding by proxy): those are hints
 * - a planned procedure (procedure context = Planned) recorded as completed
 * - laterality: the sides given by the code's site, the body site, a laterality refinement and
 *   the laterality extension must agree; a side can't be given for a structure that doesn't have
 *   one ('left stomach'); and a hint when a structure that has a side has none given
 */
public class SnomedResourceValidator extends BaseValidator {

  private static final String RULE_DATE = "2026-11-07";
  private static final String EXT_LATERALITY = "http://hl7.org/fhir/StructureDefinition/observation-structureLaterality";

  private SnomedRules rules;

  public SnomedResourceValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validate(List<ValidationMessage> errors, Element element, NodeStack stack) {
    rules = new SnomedRules(context, settings);
    boolean ok = true;
    switch (element.fhirType()) {
    case "Condition":
      ok = checkKind(errors, element, "code", stack, Kind.CONDITION) && ok;
      ok = checkKinds(errors, element, "bodySite", stack, Kind.BODY_SITE) && ok;
      checkLaterality(errors, element, stack, true);
      break;
    case "Procedure":
      ok = checkKind(errors, element, "code", stack, Kind.PROCEDURE) && ok;
      ok = checkKinds(errors, element, "bodySite", stack, Kind.BODY_SITE) && ok;
      checkPlanned(errors, element, stack);
      checkLaterality(errors, element, stack, true);
      break;
    case "Observation":
      ok = checkKind(errors, element, "code", stack, Kind.OBSERVATION) && ok;
      List<Element> components = element.getChildren("component");
      for (int i = 0; i < components.size(); i++) {
        ok = checkKind(errors, components.get(i), "code", stack.push(components.get(i), i, null, null), Kind.OBSERVATION) && ok;
      }
      ok = checkKind(errors, element, "bodySite", stack, Kind.BODY_SITE) && ok;
      checkLaterality(errors, element, stack, false);
      break;
    case "Specimen":
      ok = checkKind(errors, element, "type", stack, Kind.SPECIMEN) && ok;
      Element collection = element.getNamedChild("collection", false);
      if (collection != null) {
        ok = checkKind(errors, collection, "bodySite", stack.push(collection, -1, null, null), Kind.BODY_SITE) && ok;
      }
      break;
    case "AllergyIntolerance":
      ok = checkKind(errors, element, "code", stack, Kind.ALLERGY) && ok;
      break;
    case "Medication":
    case "MedicationKnowledge":
      ok = checkKind(errors, element, "code", stack, Kind.MEDICATION) && ok;
      break;
    case "MedicationRequest":
    case "MedicationStatement":
    case "MedicationAdministration":
    case "MedicationDispense":
      ok = checkKind(errors, element, "medication", stack, Kind.MEDICATION) && ok;
      break;
    default:
      break;
    }
    return ok;
  }

  /** a SNOMED CT coding, where it is */
  private static class SctCoding {
    private final Element element; // the CodeableConcept (for line and column)
    private final String path;
    private final String code;
    private final String version;
    private final String display;

    private SctCoding(Element element, String path, String code, String version, String display) {
      this.element = element;
      this.path = path;
      this.code = code;
      this.version = version;
      this.display = display;
    }
  }

  /** the SNOMED CT codings in a CodeableConcept (or the concept of a CodeableReference) */
  private List<SctCoding> sctCodings(Element cc, NodeStack stack) {
    List<SctCoding> res = new ArrayList<>();
    if (cc == null) {
      return res;
    }
    if ("CodeableReference".equals(cc.fhirType())) {
      Element concept = cc.getNamedChild("concept", false);
      if (concept == null) {
        return res;
      }
      stack = stack.push(concept, -1, null, null);
      cc = concept;
    } else if (!"CodeableConcept".equals(cc.fhirType())) {
      return res;
    }
    for (Element coding : cc.getChildren("coding")) {
      String code = coding.getNamedChildValue("code", false);
      if (SnomedRules.SCT.equals(coding.getNamedChildValue("system", false)) && code != null) {
        res.add(new SctCoding(cc, stack.getLiteralPath(), code.trim(), coding.getNamedChildValue("version", false), coding.getNamedChildValue("display", false)));
      }
    }
    return res;
  }

  private List<SctCoding> sctCodings(Element owner, String name, NodeStack ownerStack) {
    Element cc = owner.getNamedChild(name, false);
    return cc == null ? new ArrayList<>() : sctCodings(cc, ownerStack.push(cc, -1, null, null));
  }

  /** the concept a code is for: for a laterality refinement (69695003:272741003=7771000), its focus concept */
  private Concept lookup(SctCoding c) {
    String[] ref = SnomedRules.lateralityRefinement(c.code);
    if (ref != null) {
      return rules.lookup(ref[0], c.version, null);
    }
    return c.code.contains(":") || c.code.contains("|") ? null : rules.lookup(c.code, c.version, c.display);
  }

  private boolean checkKinds(List<ValidationMessage> errors, Element owner, String name, NodeStack stack, Kind kind) {
    boolean ok = true;
    List<Element> list = owner.getChildren(name);
    for (int i = 0; i < list.size(); i++) {
      for (SctCoding c : sctCodings(list.get(i), stack.push(list.get(i), i, null, null))) {
        ok = checkKind(errors, c, kind) && ok;
      }
    }
    return ok;
  }

  private boolean checkKind(List<ValidationMessage> errors, Element owner, String name, NodeStack stack, Kind kind) {
    boolean ok = true;
    for (SctCoding c : sctCodings(owner, name, stack)) {
      ok = checkKind(errors, c, kind) && ok;
    }
    return ok;
  }

  /** whether the kind of concept fits where it's used */
  private boolean checkKind(List<ValidationMessage> errors, SctCoding c, Kind kind) {
    SnomedRules.Judgement j = rules.judge(kind, lookup(c));
    if (j == null) {
      return true;
    }
    switch (j.getLevel()) {
    case HINT:
      hint(errors, RULE_DATE, IssueType.BUSINESSRULE, c.element.line(), c.element.col(), c.path, false, j.getMessageId(), j.getArgs());
      return true;
    case WARNING:
      warning(errors, RULE_DATE, IssueType.BUSINESSRULE, c.element.line(), c.element.col(), c.path, false, j.getMessageId(), j.getArgs());
      return true;
    default:
      return rule(errors, RULE_DATE, IssueType.BUSINESSRULE, c.element.line(), c.element.col(), c.path, false, j.getMessageId(), j.getArgs());
    }
  }

  /** a planned procedure recorded as done */
  private void checkPlanned(List<ValidationMessage> errors, Element element, NodeStack stack) {
    if (!"completed".equals(element.getNamedChildValue("status", false))) {
      return;
    }
    for (SctCoding c : sctCodings(element, "code", stack)) {
      Concept concept = lookup(c);
      if (concept != null) {
        warning(errors, RULE_DATE, IssueType.BUSINESSRULE, c.element.line(), c.element.col(), c.path, !concept.isPlanned(), I18nConstants.SCT_PROCEDURE_PLANNED_DONE, concept.getDesc());
      }
    }
  }

  /** a side, and where it was given */
  private static class StatedSide {
    private final String desc;
    private final Side side;

    private StatedSide(String desc, Side side) {
      this.desc = desc;
      this.side = side;
    }
  }

  /**
   * The sides given by the code's site (useCodeSite), the body sites (with any laterality
   * refinement) and the laterality extension must agree, and must be for structures that have a
   * side; when a structure has a side and none is given anywhere, that's a hint
   */
  private void checkLaterality(List<ValidationMessage> errors, Element element, NodeStack stack, boolean useCodeSite) {
    List<StatedSide> stated = new ArrayList<>();
    String unstated = null; // a structure that has a side, but doesn't say which

    if (useCodeSite) {
      for (SctCoding c : sctCodings(element, "code", stack)) {
        Concept concept = lookup(c);
        Concept site = concept == null ? null : concept.getSite();
        if (site != null) {
          Side s = site.getSide();
          if (s.isStated()) {
            stated.add(new StatedSide(site.getDesc(), s));
          } else if (s == Side.UNSTATED && unstated == null) {
            unstated = site.getDesc();
          }
        }
      }
    }

    List<Element> bodySites = element.getChildren("bodySite");
    Concept bodySiteConcept = null;
    for (int i = 0; i < bodySites.size(); i++) {
      Element bs = bodySites.get(i);
      NodeStack bsStack = stack.push(bs, i, null, null);
      for (SctCoding c : sctCodings(bs, bsStack)) {
        Concept concept = lookup(c);
        if (concept == null) {
          continue;
        }
        bodySiteConcept = concept;
        String[] ref = SnomedRules.lateralityRefinement(c.code);
        Side given = ref == null ? null : SnomedRules.sideOfQualifier(ref[1]);
        if (given != null && given.isStated()) {
          if (warning(errors, RULE_DATE, IssueType.BUSINESSRULE, bs.line(), bs.col(), c.path, concept.getSide() != Side.NONE,
              I18nConstants.SCT_LATERALITY_NOT_LATERALIZABLE, SnomedRules.sideName(given), concept.getDesc())) {
            stated.add(new StatedSide(c.code, given));
          }
        } else {
          Side s = concept.getSide();
          if (s.isStated()) {
            stated.add(new StatedSide(concept.getDesc(), s));
          } else if (s == Side.UNSTATED && unstated == null) {
            unstated = concept.getDesc();
          }
        }
      }
      // the laterality extension (Observation.bodySite)
      for (Element ext : bs.getChildren("extension")) {
        if (EXT_LATERALITY.equals(ext.getNamedChildValue("url", false))) {
          for (SctCoding c : sctCodings(ext.getNamedChild("value", false), bsStack.push(ext, -1, null, null))) {
            Side given = SnomedRules.sideOfQualifier(c.code);
            if (given != null && given.isStated()) {
              if (warning(errors, RULE_DATE, IssueType.BUSINESSRULE, ext.line(), ext.col(), c.path, bodySiteConcept == null || bodySiteConcept.getSide() != Side.NONE,
                  I18nConstants.SCT_LATERALITY_NOT_LATERALIZABLE, SnomedRules.sideName(given), bodySiteConcept == null ? "" : bodySiteConcept.getDesc())) {
                stated.add(new StatedSide(c.code + " (" + EXT_LATERALITY + ")", given));
              }
            }
          }
        }
      }
    }

    for (int i = 1; i < stated.size(); i++) {
      StatedSide a = stated.get(0);
      StatedSide b = stated.get(i);
      if (a.side != b.side) {
        warning(errors, RULE_DATE, IssueType.BUSINESSRULE, element.line(), element.col(), stack.getLiteralPath(), false,
          I18nConstants.SCT_LATERALITY_CONFLICT, a.desc, SnomedRules.sideName(a.side), b.desc, SnomedRules.sideName(b.side));
        return;
      }
    }
    if (stated.isEmpty() && unstated != null) {
      hint(errors, RULE_DATE, IssueType.BUSINESSRULE, element.line(), element.col(), stack.getLiteralPath(), false, I18nConstants.SCT_LATERALITY_MISSING, unstated);
    }
  }
}
