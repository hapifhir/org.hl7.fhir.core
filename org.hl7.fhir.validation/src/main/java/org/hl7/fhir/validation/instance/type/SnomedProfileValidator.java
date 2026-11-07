package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ProfileFixedCodes;
import org.hl7.fhir.validation.instance.utils.SnomedRules;
import org.hl7.fhir.validation.instance.utils.SnomedRules.Concept;
import org.hl7.fhir.validation.instance.utils.SnomedRules.Kind;
import org.hl7.fhir.validation.instance.utils.SnomedRules.Side;

/**
 * Checks the SNOMED CT codes a profile fixes, as SnomedResourceValidator checks instances: the
 * kind of concept against the element; a planned procedure with its status fixed to completed;
 * and laterality - a fixed code, a fixed body site and a fixed laterality extension that give
 * different sides, or a side for a structure that doesn't have one. (A profile that doesn't fix
 * a side is fine: the instance gives it.)
 *
 * The problems are the instance messages, wrapped in SD_SCT_FIXED, which names the element
 */
public class SnomedProfileValidator extends BaseValidator {

  private static final String RULE_DATE = "2026-11-07";
  private static final String EXT_LATERALITY = "http://hl7.org/fhir/StructureDefinition/observation-structureLaterality";

  public static final Set<String> TYPES = Set.of("Condition", "Procedure", "Observation", "Specimen", "AllergyIntolerance", "Medication", "MedicationKnowledge",
    "MedicationRequest", "MedicationStatement", "MedicationAdministration", "MedicationDispense");

  private SnomedRules rules;
  private ProfileFixedCodes fixed;

  public SnomedProfileValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean check(List<ValidationMessage> errors, StructureDefinition sd, NodeStack stack) {
    rules = new SnomedRules(context, settings);
    fixed = new ProfileFixedCodes(sd);
    String path = stack.getLiteralPath();
    String t = sd.getTypeName();
    boolean ok = true;
    switch (t) {
    case "Condition":
      ok = kind(errors, path, "Condition.code", Kind.CONDITION) && ok;
      ok = kinds(errors, path, "Condition.bodySite", Kind.BODY_SITE) && ok;
      laterality(errors, path, "Condition", true);
      break;
    case "Procedure":
      ok = kind(errors, path, "Procedure.code", Kind.PROCEDURE) && ok;
      ok = kinds(errors, path, "Procedure.bodySite", Kind.BODY_SITE) && ok;
      planned(errors, path);
      laterality(errors, path, "Procedure", true);
      break;
    case "Observation":
      ok = kind(errors, path, "Observation.code", Kind.OBSERVATION) && ok;
      for (ElementDefinition comp : fixed.slices("Observation.component")) {
        ok = kind(errors, path, comp.getId() + ".code", Kind.OBSERVATION) && ok;
      }
      ok = kind(errors, path, "Observation.bodySite", Kind.BODY_SITE) && ok;
      laterality(errors, path, "Observation", false);
      break;
    case "Specimen":
      ok = kind(errors, path, "Specimen.type", Kind.SPECIMEN) && ok;
      ok = kind(errors, path, "Specimen.collection.bodySite", Kind.BODY_SITE) && ok;
      break;
    case "AllergyIntolerance":
      ok = kind(errors, path, "AllergyIntolerance.code", Kind.ALLERGY) && ok;
      break;
    case "Medication":
    case "MedicationKnowledge":
      ok = kind(errors, path, t + ".code", Kind.MEDICATION) && ok;
      break;
    default: // MedicationRequest, MedicationStatement, MedicationAdministration, MedicationDispense
      for (String id : new String[] { t + ".medication[x]", t + ".medication[x]:medicationCodeableConcept", t + ".medication" }) {
        ok = kind(errors, path, id, Kind.MEDICATION) && ok;
      }
      break;
    }
    return ok;
  }

  private List<Coding> sct(String id) {
    return fixed.fixedCodes(id, SnomedRules.SCT, false);
  }

  /** the element's name for messages (e.g. Condition.code) */
  private String name(String id) {
    // the id, when it names a slice (Observation.component:systolic.code); otherwise the path
    ElementDefinition ed = fixed.get(id);
    return id.contains(":") || ed == null || !ed.hasPath() ? id : ed.getPath();
  }

  private boolean report(List<ValidationMessage> errors, String path, String element, SnomedRules.Level level, String messageId, Object... args) {
    String inner = context.formatMessage(messageId, args);
    switch (level) {
    case HINT:
      hint(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_SCT_FIXED, element, inner);
      return true;
    case WARNING:
      warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_SCT_FIXED, element, inner);
      return true;
    default:
      return rule(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_SCT_FIXED, element, inner);
    }
  }

  private Concept lookup(Coding c) {
    String[] ref = SnomedRules.lateralityRefinement(c.getCode());
    if (ref != null) {
      return rules.lookup(ref[0], c.getVersion(), null);
    }
    return c.getCode().contains(":") || c.getCode().contains("|") ? null : rules.lookup(c.getCode(), c.getVersion(), c.getDisplay());
  }

  private boolean kind(List<ValidationMessage> errors, String path, String id, Kind kind) {
    boolean ok = true;
    for (Coding c : sct(id)) {
      SnomedRules.Judgement j = rules.judge(kind, lookup(c));
      if (j != null) {
        ok = report(errors, path, name(id), j.getLevel(), j.getMessageId(), j.getArgs()) && ok;
      }
    }
    return ok;
  }

  /** a repeating element: itself, and its slices */
  private boolean kinds(List<ValidationMessage> errors, String path, String id, Kind kind) {
    boolean ok = kind(errors, path, id, kind);
    for (ElementDefinition s : fixed.slices(id)) {
      ok = kind(errors, path, s.getId(), kind) && ok;
    }
    return ok;
  }

  /** a planned procedure, with the status fixed to completed */
  private void planned(List<ValidationMessage> errors, String path) {
    if (!"completed".equals(fixed.primitive("Procedure.status"))) {
      return;
    }
    for (Coding c : sct("Procedure.code")) {
      Concept concept = lookup(c);
      if (concept != null && concept.isPlanned()) {
        report(errors, path, "Procedure.code", SnomedRules.Level.WARNING, I18nConstants.SCT_PROCEDURE_PLANNED_DONE, concept.getDesc());
      }
    }
  }

  private static class StatedSide {
    private final String desc;
    private final Side side;

    private StatedSide(String desc, Side side) {
      this.desc = desc;
      this.side = side;
    }
  }

  /** the ids of a repeating element and its slices */
  private List<String> withSlices(String id) {
    List<String> res = new ArrayList<>();
    res.add(id);
    for (ElementDefinition s : fixed.slices(id)) {
      res.add(s.getId());
    }
    return res;
  }

  /**
   * The sides the profile fixes - by the code's site, the body site (with any laterality
   * refinement) and the laterality extension - must agree, and must be for structures that have
   * a side
   */
  private void laterality(List<ValidationMessage> errors, String path, String type, boolean useCodeSite) {
    List<StatedSide> stated = new ArrayList<>();
    String what = type + ".code, " + type + ".bodySite";
    if (useCodeSite) {
      for (Coding c : sct(type + ".code")) {
        Concept concept = lookup(c);
        Concept site = concept == null ? null : concept.getSite();
        if (site != null && site.getSide().isStated()) {
          stated.add(new StatedSide(site.getDesc(), site.getSide()));
        }
      }
    }
    Concept bodySite = null;
    for (String id : withSlices(type + ".bodySite")) {
      for (Coding c : sct(id)) {
        Concept concept = lookup(c);
        if (concept == null) {
          continue;
        }
        bodySite = concept;
        String[] ref = SnomedRules.lateralityRefinement(c.getCode());
        Side given = ref == null ? null : SnomedRules.sideOfQualifier(ref[1]);
        if (given != null && given.isStated()) {
          if (concept.getSide() == Side.NONE) {
            report(errors, path, name(id), SnomedRules.Level.WARNING, I18nConstants.SCT_LATERALITY_NOT_LATERALIZABLE, SnomedRules.sideName(given), concept.getDesc());
          } else {
            stated.add(new StatedSide(c.getCode(), given));
          }
        } else if (concept.getSide().isStated()) {
          stated.add(new StatedSide(concept.getDesc(), concept.getSide()));
        }
      }
    }
    // a fixed laterality extension on the body site
    for (ElementDefinition ed : fixed.getList()) {
      if (ed.getId() != null && ed.getPath().equals(type + ".bodySite.extension") && isLateralityExtension(ed)) {
        DataType v = ProfileFixedCodes.fixedOrPattern(fixed.get(ed.getId() + ".value[x]"));
        if (v instanceof CodeableConcept) {
          for (Coding c : ((CodeableConcept) v).getCodingList()) {
            Side given = SnomedRules.SCT.equals(c.getSystem()) ? SnomedRules.sideOfQualifier(c.getCode()) : null;
            if (given != null && given.isStated()) {
              if (bodySite != null && bodySite.getSide() == Side.NONE) {
                report(errors, path, name(ed.getId()), SnomedRules.Level.WARNING, I18nConstants.SCT_LATERALITY_NOT_LATERALIZABLE, SnomedRules.sideName(given), bodySite.getDesc());
              } else {
                stated.add(new StatedSide(c.getCode() + " (" + EXT_LATERALITY + ")", given));
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
        report(errors, path, what, SnomedRules.Level.WARNING, I18nConstants.SCT_LATERALITY_CONFLICT, a.desc, SnomedRules.sideName(a.side), b.desc, SnomedRules.sideName(b.side));
        return;
      }
    }
  }

  private boolean isLateralityExtension(ElementDefinition ed) {
    for (TypeRefComponent t : ed.getTypeList()) {
      for (var p : t.getProfileList()) {
        if (EXT_LATERALITY.equals(p.getValue())) {
          return true;
        }
      }
    }
    return false;
  }
}
