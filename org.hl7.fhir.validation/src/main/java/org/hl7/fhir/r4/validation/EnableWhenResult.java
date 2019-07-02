package org.hl7.fhir.r4.validation;

/*-
 * #%L
 * org.hl7.fhir.validation
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.hl7.fhir.r4.elementmodel.Element;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent;

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
