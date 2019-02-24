package org.hl7.fhir.r5.validation;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;

public interface IEnableWhenEvaluator {
	public boolean isQuestionEnabled(QuestionnaireItemComponent questionnaireItem,
			Element questionnaireResponse);

}
