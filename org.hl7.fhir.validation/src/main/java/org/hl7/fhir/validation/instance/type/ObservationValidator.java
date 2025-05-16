package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base.ValidationMode;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.ResourcePercentageLogger;
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
    return ok;
  }

}
