package org.hl7.fhir.validation.instance;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */


import java.util.*;
import java.util.stream.*;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent;
import org.hl7.fhir.r5.model.Questionnaire.*;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.validation.instance.utils.ValidatorHostContext;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;

/**
 * Evaluates Questionnaire.item.enableWhen against a QuestionnaireResponse.
 * Ignores possible modifierExtensions and extensions.
 */
public class EnableWhenEvaluator {
  public static final String LINKID_ELEMENT = "linkId";
  public static final String ITEM_ELEMENT = "item";
  public static final String ANSWER_ELEMENT = "answer";


  public static class QuestionnaireAnswerPair {
    private QuestionnaireItemComponent q;
    private Element a;

    public QuestionnaireAnswerPair(QuestionnaireItemComponent q, Element a) {
      super();
      this.q = q;
      this.a = a;
    }

    public QuestionnaireItemComponent getQ() {
      return q;
    }

    public Element getA() {
      return a;
    }

  }

  public static class QStack extends ArrayList<QuestionnaireAnswerPair> {

    private static final long serialVersionUID = 1L;
    private Questionnaire q;
    private Element a;

    public QStack(Questionnaire q, Element a) {
      super();
      this.q = q;
      this.a = a;
    }


    public Questionnaire getQ() {
      return q;
    }


    public Element getA() {
      return a;
    }


    public QStack push(QuestionnaireItemComponent q, Element a) {
      QStack self = new QStack(this.q, this.a);
      self.addAll(this);
      self.add(new QuestionnaireAnswerPair(q, a));
      return self;
    }
  }

  public static class EnableWhenResult {
    private final boolean enabled;
    private final QuestionnaireItemEnableWhenComponent enableWhenCondition;

    /**
     * Evaluation result of enableWhen condition
     *
     * @param enabled             Evaluation result
     * @param enableWhenCondition Evaluated enableWhen condition
     */
    public EnableWhenResult(boolean enabled, QuestionnaireItemEnableWhenComponent enableWhenCondition) {
      this.enabled = enabled;
      this.enableWhenCondition = enableWhenCondition;
    }

    public boolean isEnabled() {
      return enabled;
    }

    public QuestionnaireItemEnableWhenComponent getEnableWhenCondition() {
      return enableWhenCondition;
    }
  }

  /**
   * the stack contains a set of QR items that represent the tree of the QR being validated, each tagged with the definition of the item from the Q for the QR being validated
   * <p>
   * the itembeing validated is in the context of the stack. For root items, the stack is empty.
   * <p>
   * The context Questionnaire and QuestionnaireResponse are always available
   */
  public boolean isQuestionEnabled(ValidatorHostContext hostContext, QuestionnaireItemComponent qitem, QStack qstack, FHIRPathEngine engine) {
    if (hasExpressionExtension(qitem)) {
      String expr = getExpression(qitem);
      ExpressionNode node = engine.parse(expr);
      return engine.evaluateToBoolean(hostContext, qstack.a, qstack.a, qstack.a, node);
    }

    if (!qitem.hasEnableWhen()) {
      return true;
    }

    List<EnableWhenResult> evaluationResults = qitem.getEnableWhen()
      .stream()
      .map(enableCondition -> evaluateCondition(enableCondition, qitem, qstack))
      .collect(Collectors.toList());
    return checkConditionResults(evaluationResults, qitem);
  }


  private boolean hasExpressionExtension(QuestionnaireItemComponent qitem) {
    return qitem.hasExtension("http://phr.kanta.fi/StructureDefinition/fiphr-ext-questionnaire-enablewhen") || // finnish extension 
      qitem.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-enableWhenExpression"); // sdc extension
  }

  private String getExpression(QuestionnaireItemComponent qitem) {
    if (qitem.hasExtension("http://phr.kanta.fi/StructureDefinition/fiphr-ext-questionnaire-enablewhen"))
      return qitem.getExtensionString("http://phr.kanta.fi/StructureDefinition/fiphr-ext-questionnaire-enablewhen");
    if (qitem.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-enableWhenExpression")) {
      Expression expr = (Expression) qitem.getExtensionByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-enableWhenExpression").getValue();
      if ("text/fhirpath".equals(expr.getLanguage())) {
        return expr.getExpression();
      } else {
        throw new FHIRException("Unsupported language '" + expr.getLanguage() + "' for enableWhen extension http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-enableWhenExpression");
      }
    }
    throw new Error("How did you get here?");
  }


  public boolean checkConditionResults(List<EnableWhenResult> evaluationResults, QuestionnaireItemComponent questionnaireItem) {
    if ((questionnaireItem.hasEnableBehavior() && questionnaireItem.getEnableBehavior() == EnableWhenBehavior.ANY) || evaluationResults.size() == 1) {
      return evaluationResults.stream().anyMatch(EnableWhenResult::isEnabled);
    }
    if (questionnaireItem.hasEnableBehavior() && questionnaireItem.getEnableBehavior() == EnableWhenBehavior.ALL) {
      return evaluationResults.stream().allMatch(EnableWhenResult::isEnabled);
    }
    //TODO: Throw exception? enableBehavior is mandatory when there are multiple conditions
    return true;
  }


  protected EnableWhenResult evaluateCondition(QuestionnaireItemEnableWhenComponent enableCondition, QuestionnaireItemComponent qitem, QStack qstack) {
    List<Element> answerItems = findQuestionAnswers(qstack, qitem, enableCondition);
    QuestionnaireItemOperator operator = enableCondition.getOperator();
    if (operator == QuestionnaireItemOperator.EXISTS) {
      DataType answer = enableCondition.getAnswer();
      if (!(answer instanceof BooleanType)) {
        throw new UnprocessableEntityException("Exists-operator requires answerBoolean");
      }
      return new EnableWhenResult(((BooleanType) answer).booleanValue() != answerItems.isEmpty(), enableCondition);
    }
    boolean result = answerItems
      .stream()
      .anyMatch(answer -> evaluateAnswer(answer, enableCondition.getAnswer(), enableCondition.getOperator()));
    return new EnableWhenResult(result, enableCondition);
  }

  private DataType convertToType(Element element) throws FHIRException {
    if (element.fhirType().equals("BackboneElement")) {
      return null;
    }
    DataType b = new Factory().create(element.fhirType());
    if (b instanceof PrimitiveType) {
      ((PrimitiveType<?>) b).setValueAsString(element.primitiveValue());
    } else {
      for (Element child : element.getChildren()) {
        if (!isExtension(child)) {
          b.setProperty(child.getName(), convertToType(child));
        }
      }
    }
    return b;
  }


  private boolean isExtension(Element element) {
    return "Extension".equals(element.fhirType());
  }

  protected boolean evaluateAnswer(Element answer, DataType expectedAnswer, QuestionnaireItemOperator questionnaireItemOperator) {
    DataType actualAnswer;
    if (isExtension(answer)) {
      return false;
    }
    try {
      actualAnswer = convertToType(answer);
      if (actualAnswer == null) {
        return false;
      }
    } catch (FHIRException e) {
      throw new UnprocessableEntityException("Unexpected answer type", e);
    }
    if (!actualAnswer.getClass().equals(expectedAnswer.getClass())) {
      throw new UnprocessableEntityException("Expected answer and actual answer have incompatible types");
    }
    if (expectedAnswer instanceof Coding) {
      return compareCodingAnswer((Coding) expectedAnswer, (Coding) actualAnswer, questionnaireItemOperator);
    } else if ((expectedAnswer instanceof PrimitiveType)) {
      return comparePrimitiveAnswer((PrimitiveType<?>) actualAnswer, (PrimitiveType<?>) expectedAnswer, questionnaireItemOperator);
    } else if (expectedAnswer instanceof Quantity) {
      return compareQuantityAnswer((Quantity) actualAnswer, (Quantity) expectedAnswer, questionnaireItemOperator);
    }
    // TODO: Attachment, reference?
    throw new UnprocessableEntityException("Unimplemented answer type: " + expectedAnswer.getClass());
  }


  private boolean compareQuantityAnswer(Quantity actualAnswer, Quantity expectedAnswer, QuestionnaireItemOperator questionnaireItemOperator) {
    return compareComparable(actualAnswer.getValue(), expectedAnswer.getValue(), questionnaireItemOperator);
  }


  private boolean comparePrimitiveAnswer(PrimitiveType<?> actualAnswer, PrimitiveType<?> expectedAnswer, QuestionnaireItemOperator questionnaireItemOperator) {
    if (actualAnswer.getValue() instanceof Comparable) {
      return compareComparable((Comparable<?>) actualAnswer.getValue(), (Comparable<?>) expectedAnswer.getValue(), questionnaireItemOperator);
    } else if (questionnaireItemOperator == QuestionnaireItemOperator.EQUAL) {
      return actualAnswer.equalsShallow(expectedAnswer);
    } else if (questionnaireItemOperator == QuestionnaireItemOperator.NOT_EQUAL) {
      return !actualAnswer.equalsShallow(expectedAnswer);
    }
    throw new UnprocessableEntityException("Bad operator for PrimitiveType comparison");
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private boolean compareComparable(Comparable actual, Comparable expected,
                                    QuestionnaireItemOperator questionnaireItemOperator) {
    int result = actual.compareTo(expected);

    if (questionnaireItemOperator == QuestionnaireItemOperator.EQUAL) {
      return result == 0;
    } else if (questionnaireItemOperator == QuestionnaireItemOperator.NOT_EQUAL) {
      return result != 0;
    } else if (questionnaireItemOperator == QuestionnaireItemOperator.GREATER_OR_EQUAL) {
      return result >= 0;
    } else if (questionnaireItemOperator == QuestionnaireItemOperator.LESS_OR_EQUAL) {
      return result <= 0;
    } else if (questionnaireItemOperator == QuestionnaireItemOperator.LESS_THAN) {
      return result < 0;
    } else if (questionnaireItemOperator == QuestionnaireItemOperator.GREATER_THAN) {
      return result > 0;
    }

    throw new UnprocessableEntityException("Bad operator for PrimitiveType comparison: " + questionnaireItemOperator.toCode());

  }

  /**
   * Recursively look for answers to questions with the given link id, working upwards given the context
   * <p>
   * For discussion about this, see https://chat.fhir.org/#narrow/stream/179255-questionnaire/topic/enable-when
   * <p>
   * - given sourceQ - question that contains the enableWhen reference and targetQ - question that the enableWhen references in the Q and also sourceA - answer for sourceQ and targetA - answer for targetQ in the QR
   * - work up from sourceQ until you find the Q group that also contains targetQ - this is groupQ
   * - work up from sourceA until you find the QR group that matches groupQ - this is groupA
   * - any targetA in groupA are input for the enableWhen decision
   */
  private List<Element> findQuestionAnswers(QStack qstack, QuestionnaireItemComponent sourceQ, QuestionnaireItemEnableWhenComponent ew) {
    QuestionnaireItemComponent targetQ = qstack.getQ().getQuestion(ew.getQuestion());
    if (targetQ != null) {
      QuestionnaireItemComponent groupQ = qstack.getQ().getCommonGroup(sourceQ, targetQ);
      if (groupQ == null) { // root is Q itself
        return findOnItem(qstack.getA(), ew.getQuestion());
      } else {
        for (int i = qstack.size() - 1; i >= 0; i--) {
          if (qstack.get(i).getQ() == groupQ) {
            // group A
            return findOnItem(qstack.get(i).getA(), ew.getQuestion());
          }
        }
      }
    }
    return new ArrayList<>();
  }

  private List<Element> findOnItem(Element focus, String question) {
    List<Element> retVal = new ArrayList<>();
    List<Element> items = focus.getChildren(ITEM_ELEMENT);
    for (Element item : items) {
      if (hasLinkId(item, question)) {
        List<Element> answers = extractAnswer(item);
        retVal.addAll(answers);
      }
      retVal.addAll(findOnItem(item, question));
    }

    // In case the question with the enableWhen is a direct child of the question with
    // the answer that it depends on. There is an example of this in the
    // "BO_ConsDrop" question in this test case:
    // https://github.com/jamesagnew/hapi-fhir/blob/master/hapi-fhir-validation/src/test/resources/dstu3/fmc03-questionnaire.json
    if (hasLinkId(focus, question)) {
      List<Element> answers = extractAnswer(focus);
      retVal.addAll(answers);
    }

    return retVal;
  }


  private List<Element> extractAnswer(Element item) {
    return item.getChildrenByName(ANSWER_ELEMENT)
      .stream()
      .flatMap(c -> c.getChildren().stream())
      .collect(Collectors.toList());
  }

  private boolean compareCodingAnswer(Coding expectedAnswer, Coding actualAnswer, QuestionnaireItemOperator questionnaireItemOperator) {
    boolean result = compareSystems(expectedAnswer, actualAnswer) && compareCodes(expectedAnswer, actualAnswer);
    if (questionnaireItemOperator == QuestionnaireItemOperator.EQUAL) {
      return result == true;
    } else if (questionnaireItemOperator == QuestionnaireItemOperator.NOT_EQUAL) {
      return result == false;
    }
    throw new UnprocessableEntityException("Bad operator for Coding comparison");
  }

  private boolean compareCodes(Coding expectedCoding, Coding value) {
    if (expectedCoding.hasCode() != value.hasCode()) {
      return false;
    }
    if (expectedCoding.hasCode()) {
      return expectedCoding.getCode().equals(value.getCode());
    }
    return true;
  }

  private boolean compareSystems(Coding expectedCoding, Coding value) {
    if (expectedCoding.hasSystem() && !value.hasSystem()) {
      return false;
    }
    if (expectedCoding.hasSystem()) {
      return expectedCoding.getSystem().equals(value.getSystem());
    }
    return true;
  }

  private boolean hasLinkId(Element item, String linkId) {
    Element linkIdChild = item.getNamedChild(LINKID_ELEMENT);
    if (linkIdChild != null && linkIdChild.getValue().equals(linkId)) {
      return true;
    }
    return false;
  }
}