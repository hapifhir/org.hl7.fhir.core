package org.hl7.fhir.r5.validation;


import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent;

public class EnableWhenResult {
    private final boolean enabled;
    private final QuestionnaireItemEnableWhenComponent enableWhenCondition;
    private final Element answerItem;
    private final String linkId;

    /**
     * Evaluation result of enableWhen condition
     * 
     * @param enabled
     *            Evaluation result
     * @param linkId
     *            LinkId of the questionnaire item
     * @param enableWhenCondition
     *            Evaluated enableWhen condition
     * @param responseItem
     *            item in QuestionnaireResponse
     */
    public EnableWhenResult(boolean enabled, String linkId, QuestionnaireItemEnableWhenComponent enableWhenCondition,
            Element answerItem) {
        this.enabled = enabled;
        this.linkId = linkId;
        this.answerItem = answerItem;
        this.enableWhenCondition = enableWhenCondition;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getLinkId() {
        return linkId;
    }

    public Element getAnswerItem() {
        return answerItem;
    }

    public QuestionnaireItemEnableWhenComponent getEnableWhenCondition() {
        return enableWhenCondition;
    }
}
