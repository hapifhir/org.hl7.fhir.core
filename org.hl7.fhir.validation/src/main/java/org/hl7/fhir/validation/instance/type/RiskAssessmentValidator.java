package org.hl7.fhir.validation.instance.type;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;

import java.util.List;

public class RiskAssessmentValidator extends BaseValidator {

  private FHIRPathEngine fpe;

  public RiskAssessmentValidator(IWorkerContext context, TimeTracker timeTracker, FHIRPathEngine fpe, XVerExtensionManager xverManager) {
    super(context, xverManager);
    source = Source.InstanceValidator;
    this.fpe = fpe;
    this.timeTracker = timeTracker;
  }
  
  public void validateRiskAssessment(List<ValidationMessage> errors, Element cs, NodeStack stack) {

    if (!cs.hasChildren("prediction")) {
      return;
    }
    List<Element> predictions = cs.getChildrenByName("prediction");

    for (Element prediction : predictions) {
      Element probability = prediction.getNamedChild("probability");
      if (probability != null && "decimal".equals(probability.getType())) {
        DecimalType probabilityValue = new DecimalType(probability.getValue());
        if (probabilityValue.compareTo(new DecimalType(100)) > 0) {

          rule(errors, ValidationMessage.IssueType.PROCESSING, prediction.line(), prediction.col(), prediction.getPath(), false, I18nConstants.RISKASSESSMENT_PROBABILITYDECIMAL_INVALID, "ras-2", "Must be <= 100");
        }
      }
    }
  }
}
