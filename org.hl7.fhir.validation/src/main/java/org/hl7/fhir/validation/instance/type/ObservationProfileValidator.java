package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.model.core.Quantity;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.LoincObservationRules;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ProfileFixedCodes;

/**
 * Checks a profile on Observation that fixes a LOINC code - on Observation.code, or on the code
 * of a component slice - against what LOINC says about the code, as ObservationValidator checks
 * instances: the types it allows for value[x] against the scale, a fixed unit against what the
 * code measures, a panel that requires a value or can't have results, an order-only code, and
 * the types it allows for effective[x] against the timing.
 *
 * Only a contradiction is reported: a profile that leaves things open (allows a CodeableConcept
 * as well as a Quantity, say) is fine - the instances are checked anyway
 */
public class ObservationProfileValidator extends BaseValidator {

  private static final String RULE_DATE = "2026-11-07";

  private LoincObservationRules rules;
  private ProfileFixedCodes fixedCodes;

  public ObservationProfileValidator(BaseValidator parent) {
    super(parent);
  }

  public void checkLoinc(List<ValidationMessage> errors, StructureDefinition sd, NodeStack stack) {
    rules = new LoincObservationRules(context, settings);
    fixedCodes = new ProfileFixedCodes(sd);
    List<ElementDefinition> list = sd.getSnapshot().getElementList();
    Map<String, ElementDefinition> byId = new HashMap<>();
    for (ElementDefinition ed : list) {
      if (ed.hasId()) {
        byId.put(ed.getId(), ed);
      }
    }
    String path = stack.getLiteralPath();
    for (Coding c : fixedLoincCodes(list, byId, "Observation.code")) {
      LoincObservationRules.Code info = rules.lookup(c.getCode(), c.getVersion(), c.getDisplay());
      if (info != null) {
        checkObservation(errors, path, byId, info);
        checkValue(errors, path, list, byId, "Observation", info);
      }
    }
    for (ElementDefinition ed : list) {
      if ("Observation.component".equals(ed.getPath()) && ed.hasSliceName() && ed.hasId() && !"0".equals(ed.getMax())) {
        for (Coding c : fixedLoincCodes(list, byId, ed.getId() + ".code")) {
          LoincObservationRules.Code info = rules.lookup(c.getCode(), c.getVersion(), c.getDisplay());
          if (info != null) {
            checkValue(errors, path, list, byId, ed.getId(), info);
          }
        }
      }
    }
  }

  /** the LOINC codes the profile fixes for the code element with this id (only a required coding slice fixes it) */
  private List<Coding> fixedLoincCodes(List<ElementDefinition> list, Map<String, ElementDefinition> byId, String codeId) {
    return fixedCodes.fixedCodes(codeId, LoincObservationRules.LOINC, true);
  }

  private DataType fixedOrPattern(ElementDefinition ed) {
    return ed.hasFixed() ? ed.getFixed() : ed.hasPattern() ? ed.getPattern() : null;
  }

  private String primitive(ElementDefinition ed) {
    DataType v = ed == null ? null : fixedOrPattern(ed);
    return v != null && v.isPrimitive() ? v.primitiveValue() : null;
  }

  private List<String> types(ElementDefinition ed) {
    List<String> res = new ArrayList<>();
    for (TypeRefComponent t : ed.getTypeList()) {
      if (!res.contains(t.getWorkingCode())) {
        res.add(t.getWorkingCode());
      }
    }
    return res;
  }

  private boolean prohibited(ElementDefinition ed) {
    return ed != null && "0".equals(ed.getMax());
  }

  /** what the code of the observation itself says about it: a panel, an order-only code, and the timing */
  private void checkObservation(List<ValidationMessage> errors, String path, Map<String, ElementDefinition> byId, LoincObservationRules.Code info) {
    String desc = info.getDesc();
    String panel = info.getPanelType();
    if (panel != null) {
      ElementDefinition value = byId.get("Observation.value[x]");
      warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, value == null || value.getMin() == 0, I18nConstants.SD_LOINC_PANEL_VALUE, desc, panel);
      warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, !(prohibited(byId.get("Observation.hasMember")) && prohibited(byId.get("Observation.component"))),
        I18nConstants.SD_LOINC_PANEL_EMPTY, desc, panel);
    } else {
      warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, !info.isOrderOnly(), I18nConstants.SD_LOINC_ORDER_ONLY, desc);
    }

    ElementDefinition eff = byId.get("Observation.effective[x]");
    if (eff != null && !prohibited(eff) && eff.hasType()) {
      List<String> types = types(eff);
      if (info.isPointInTime()) {
        hint(errors, RULE_DATE, IssueType.BUSINESSRULE, path, !(types.size() == 1 && "Period".equals(types.get(0))), I18nConstants.SD_LOINC_TIME_POINT, desc);
      } else if (info.isTimed()) {
        hint(errors, RULE_DATE, IssueType.BUSINESSRULE, path, types.contains("Period") || !(types.contains("dateTime") || types.contains("instant")),
          I18nConstants.SD_LOINC_TIME_PERIOD, desc, info.getTimeAspect());
      }
    }
  }

  /** what the code of the observation or a component slice (ownerId) says about its value */
  private void checkValue(List<ValidationMessage> errors, String path, List<ElementDefinition> list, Map<String, ElementDefinition> byId, String ownerId, LoincObservationRules.Code info) {
    String valueId = ownerId + ".value[x]";
    ElementDefinition value = byId.get(valueId);
    if (value == null || prohibited(value) || !value.hasType() || info.getPanelType() != null) {
      return; // no value allowed, any type of value, or a panel (which is reported as a panel)
    }
    String desc = info.getDesc();
    List<String> types = types(value);

    LoincObservationRules.Scale scale = info.getScale();
    if (scale != null) {
      boolean any = false;
      for (String t : types) {
        any = any || LoincObservationRules.scaleAllows(scale, t);
      }
      if (!any) {
        String tl = CommaSeparatedStringBuilder.join(" or ", types);
        switch (scale) {
        case QUANTITATIVE:
          warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_LOINC_SCALE_QN, desc, tl);
          break;
        case CODED:
          warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_LOINC_SCALE_CODED, desc, info.getScaleName(), tl);
          break;
        case NARRATIVE:
          warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_LOINC_SCALE_NAR, desc, tl);
          break;
        default:
          warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_LOINC_SCALE_DOC, desc);
        }
        return; // the wrong type of value: whatever else is wrong with it is beside the point
      }
    }

    if (types.contains("Quantity")) {
      // the unit the profile fixes: on the Quantity, or on its system and code
      String system = null;
      String unit = null;
      for (ElementDefinition ed : list) {
        String id = ed.getId();
        if (id == null || !(id.equals(valueId) || id.startsWith(valueId + ".") || id.startsWith(valueId + ":valueQuantity"))) {
          continue;
        }
        DataType fp = fixedOrPattern(ed);
        if (fp instanceof Quantity) {
          system = ((Quantity) fp).hasSystem() ? ((Quantity) fp).getSystem() : system;
          unit = ((Quantity) fp).hasCode() ? ((Quantity) fp).getCode() : unit;
        } else if (fp != null && fp.isPrimitive() && ed.getPath().endsWith(".value[x].system")) {
          system = fp.primitiveValue();
        } else if (fp != null && fp.isPrimitive() && ed.getPath().endsWith(".value[x].code")) {
          unit = fp.primitiveValue();
        }
      }
      if (system != null && !LoincObservationRules.UCUM.equals(system)) {
        warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, !info.isUnitsRequired(), I18nConstants.SD_LOINC_UNITS_REQUIRED, desc, system);
      } else if (unit != null) {
        LoincObservationRules.UnitProblem up = rules.checkUnit(info, unit);
        if (up != null && up.hasProperty()) {
          warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_LOINC_UNITS_PROPERTY, desc, up.getPropertyName(), up.getProperty(), up.getExpected(), unit);
        } else if (up != null) {
          warning(errors, RULE_DATE, IssueType.BUSINESSRULE, path, false, I18nConstants.SD_LOINC_UNITS_EXAMPLE, desc, up.getExpected(), unit);
        }
      }
    }
  }
}
