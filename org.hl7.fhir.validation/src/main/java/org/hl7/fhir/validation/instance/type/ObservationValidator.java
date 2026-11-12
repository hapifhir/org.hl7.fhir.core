package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.model.ValidationInformation.ValidationMode;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.ResourcePercentageLogger;
import org.hl7.fhir.validation.instance.utils.LoincObservationRules;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

public class ObservationValidator extends BaseValidator {


  public ObservationValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateObservation(ValidationContext valContext, List<ValidationMessage> errors, Element element, NodeStack stack, ResourcePercentageLogger pct, ValidationMode mode) {
    boolean ok = true;
    // all observations should have a subject, a performer, and a time

    ok = bpCheck(errors, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), element.getNamedChild("subject", false) != null, I18nConstants.ALL_OBSERVATIONS_SHOULD_HAVE_A_SUBJECT) && ok;
    List<Element> performers = new ArrayList<>();
    element.getNamedChildren("performer", performers);
    ok = bpCheck(errors, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), performers.size() > 0, I18nConstants.ALL_OBSERVATIONS_SHOULD_HAVE_A_PERFORMER) && ok;
    ok = bpCheck(errors, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), 
          element.getNamedChild("effectiveDateTime", false) != null || element.getNamedChild("effectivePeriod", false) != null || 
          element.getNamedChild("effectiveTiming", false) != null || element.getNamedChild("effectiveInstant", false) != null, 
          I18nConstants.ALL_OBSERVATIONS_SHOULD_HAVE_AN_EFFECTIVEDATETIME_OR_AN_EFFECTIVEPERIOD, element.getProperty().typeSummary()) && ok;   
    
    // Looking for the vital signs code? It's moved to BasePolicyAdvisorForFullValidation.getImpliedProfilesForObservation

    // a LOINC code says a lot about the result it's for: check the observation against it
    List<LoincCode> codes = loincCodes(element);
    for (LoincCode lc : codes) {
      checkLoincObservation(errors, element, stack, lc);
    }
    checkLoincValue(errors, codes, element.getNamedChild("value", false), stack);
    List<Element> components = new ArrayList<>();
    element.getNamedChildren("component", components);
    for (int i = 0; i < components.size(); i++) {
      Element comp = components.get(i);
      checkLoincValue(errors, loincCodes(comp), comp.getNamedChild("value", false), stack.push(comp, i, null, null));
    }
    return ok;
  }

  private static final String RULE_DATE = "2026-11-07";

  private LoincObservationRules loincRules;

  private LoincObservationRules loincRules() {
    if (loincRules == null) {
      loincRules = new LoincObservationRules(context, settings);
    }
    return loincRules;
  }

  /** a LOINC code in Observation.code or component.code, and where it is */
  private static class LoincCode {
    private final Element code;
    private final LoincObservationRules.Code info;

    private LoincCode(Element code, LoincObservationRules.Code info) {
      this.code = code;
      this.info = info;
    }
  }

  /** the LOINC codes in the code of an observation or component that the terminology server knows */
  private List<LoincCode> loincCodes(Element owner) {
    List<LoincCode> res = new ArrayList<>();
    Element code = owner.getNamedChild("code", false);
    if (code == null) {
      return res;
    }
    List<Element> codings = new ArrayList<>();
    code.getNamedChildren("coding", codings);
    for (Element coding : codings) {
      String lc = coding.getNamedChildValue("code", false);
      if (LoincObservationRules.LOINC.equals(coding.getNamedChildValue("system", false)) && lc != null) {
        LoincObservationRules.Code info = loincRules().lookup(lc, coding.getNamedChildValue("version", false), coding.getNamedChildValue("display", false));
        if (info != null) {
          res.add(new LoincCode(code, info));
        }
      }
    }
    return res;
  }

  /**
   * What the LOINC code of the observation itself says about the observation: a panel has its
   * results in hasMember or component, not a value; an order-only code is not for results; and
   * whether the result is for a point in time or a period
   */
  private void checkLoincObservation(List<ValidationMessage> errors, Element element, NodeStack stack, LoincCode lc) {
    String desc = lc.info.getDesc();
    String codePath = stack.getLiteralPath() + ".code";
    Element value = element.getNamedChild("value", false);
    String panel = lc.info.getPanelType();
    if (panel != null) {
      if (value != null) {
        warning(errors, RULE_DATE, IssueType.BUSINESSRULE, value.line(), value.col(), stack.push(value, -1, null, null).getLiteralPath(), false,
          I18nConstants.OBSERVATION_LOINC_PANEL_VALUE, desc, panel);
      } else {
        // (hasMember and component repeat: getNamedChild() won't do)
        boolean results = !element.getChildren("hasMember").isEmpty() || !element.getChildren("component").isEmpty() || !element.getChildren("dataAbsentReason").isEmpty();
        warning(errors, RULE_DATE, IssueType.BUSINESSRULE, lc.code.line(), lc.code.col(), codePath, results,
          I18nConstants.OBSERVATION_LOINC_PANEL_EMPTY, desc, panel);
      }
    } else if (lc.info.isOrderOnly()) {
      warning(errors, RULE_DATE, IssueType.BUSINESSRULE, lc.code.line(), lc.code.col(), codePath, false,
        I18nConstants.OBSERVATION_LOINC_ORDER_ONLY, desc);
    }

    Element eff = element.getNamedChild("effective", false);
    if (eff != null) {
      String effPath = stack.push(eff, -1, null, null).getLiteralPath();
      if ("Period".equals(eff.fhirType()) && lc.info.isPointInTime()) {
        // a period that starts and ends at the same time, or is open, is a point in time
        String start = eff.getNamedChildValue("start", false);
        String end = eff.getNamedChildValue("end", false);
        hint(errors, RULE_DATE, IssueType.BUSINESSRULE, eff.line(), eff.col(), effPath, start == null || end == null || start.equals(end),
          I18nConstants.OBSERVATION_LOINC_TIME_POINT, desc);
      } else if (Utilities.existsInList(eff.fhirType(), "dateTime", "instant") && lc.info.isTimed()) {
        hint(errors, RULE_DATE, IssueType.BUSINESSRULE, eff.line(), eff.col(), effPath, false,
          I18nConstants.OBSERVATION_LOINC_TIME_PERIOD, desc, lc.info.getTimeAspect());
      }
    }
  }

  /**
   * What the LOINC code of an observation or component says about its value: what type it is
   * (SCALE_TYP), whether it needs units (UNITSREQUIRED), and what units (PROPERTY,
   * EXAMPLE_UCUM_UNITS)
   */
  private void checkLoincValue(List<ValidationMessage> errors, List<LoincCode> codes, Element value, NodeStack stack) {
    if (value == null) {
      return;
    }
    String path = stack.push(value, -1, null, null).getLiteralPath();
    String type = value.fhirType();
    for (LoincCode lc : codes) {
      if (lc.info.getPanelType() != null) {
        continue; // a panel shouldn't have a value at all - see checkLoincObservation
      }
      if (!checkLoincScale(errors, value, path, type, lc.info)) {
        continue; // the wrong type of value: whatever else is wrong with it is beside the point
      }
      if ("Quantity".equals(type)) {
        String unit = value.getNamedChildValue("code", false);
        boolean ucum = unit != null && LoincObservationRules.UCUM.equals(value.getNamedChildValue("system", false));
        warning(errors, RULE_DATE, IssueType.BUSINESSRULE, value.line(), value.col(), path, ucum || !lc.info.isUnitsRequired(),
          I18nConstants.OBSERVATION_LOINC_UNITS_REQUIRED, lc.info.getDesc());
        if (ucum) {
          LoincObservationRules.UnitProblem up = loincRules().checkUnit(lc.info, unit);
          if (up != null && up.hasProperty()) {
            warning(errors, RULE_DATE, IssueType.BUSINESSRULE, value.line(), value.col(), path, false, I18nConstants.OBSERVATION_LOINC_UNITS_PROPERTY,
              lc.info.getDesc(), up.getPropertyName(), up.getProperty(), up.getExpected(), unit);
          } else if (up != null) {
            warning(errors, RULE_DATE, IssueType.BUSINESSRULE, value.line(), value.col(), path, false, I18nConstants.OBSERVATION_LOINC_UNITS_EXAMPLE,
              lc.info.getDesc(), up.getExpected(), unit);
          }
        }
      }
    }
  }

  /** whether the type of the value fits the LOINC scale: if it doesn't, it's reported */
  private boolean checkLoincScale(List<ValidationMessage> errors, Element value, String path, String type, LoincObservationRules.Code info) {
    LoincObservationRules.Scale scale = info.getScale();
    if (scale == null || LoincObservationRules.scaleAllows(scale, type)) {
      return true;
    }
    switch (scale) {
    case QUANTITATIVE:
      return warning(errors, RULE_DATE, IssueType.BUSINESSRULE, value.line(), value.col(), path, false, I18nConstants.OBSERVATION_LOINC_SCALE_QN, info.getDesc(), type);
    case CODED:
      return warning(errors, RULE_DATE, IssueType.BUSINESSRULE, value.line(), value.col(), path, false, I18nConstants.OBSERVATION_LOINC_SCALE_CODED, info.getDesc(), info.getScaleName(), type);
    case NARRATIVE:
      return warning(errors, RULE_DATE, IssueType.BUSINESSRULE, value.line(), value.col(), path, false, I18nConstants.OBSERVATION_LOINC_SCALE_NAR, info.getDesc(), type);
    default:
      return warning(errors, RULE_DATE, IssueType.BUSINESSRULE, value.line(), value.col(), path, false, I18nConstants.OBSERVATION_LOINC_SCALE_DOC, info.getDesc());
    }
  }

}
