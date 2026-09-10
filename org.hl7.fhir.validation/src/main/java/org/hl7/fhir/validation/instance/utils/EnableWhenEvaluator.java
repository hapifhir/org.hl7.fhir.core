package org.hl7.fhir.validation.instance.utils;

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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FHIRConstant;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Expression;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Questionnaire.EnableWhenBehavior;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.instance.type.QuestionnaireValidator.QuestionnaireWithContext;

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
    private QuestionnaireWithContext q;
    private Element a;

    /**
     * The launch contexts available to the expressions in this QuestionnaireResponse, worked out
     * once when validation of it starts. Never null; empty when none were supplied or none of the
     * ones supplied are ones this questionnaire declares.
     */
    private Map<String, List<Base>> launchContexts;

    public QStack(QuestionnaireWithContext q, Element a) {
      this(q, a, new LinkedHashMap<>());
    }

    public QStack(QuestionnaireWithContext q, Element a, Map<String, List<Base>> launchContexts) {
      super();
      this.q = q;
      this.a = a;
      this.launchContexts = launchContexts == null ? new LinkedHashMap<>() : launchContexts;
    }

    public Map<String, List<Base>> getLaunchContexts() {
      return launchContexts;
    }


    public QuestionnaireWithContext getQ() {
      return q;
    }


    public Element getA() {
      return a;
    }


    public QStack push(QuestionnaireItemComponent q, Element a) {
      QStack self = new QStack(this.q, this.a, this.launchContexts);
      self.addAll(this);
      self.add(new QuestionnaireAnswerPair(q, a));
      return self;
    }
  }

  /**
   * The result of asking whether an item is enabled: the answer, and - when the question could not
   * actually be answered - why not. See {@link #checkQuestionEnabled}.
   */
  public static class EnableWhenOutcome {
    private final boolean enabled;
    private final String uncheckable;

    private EnableWhenOutcome(boolean enabled, String uncheckable) {
      this.enabled = enabled;
      this.uncheckable = uncheckable;
    }

    public static EnableWhenOutcome evaluated(boolean enabled) {
      return new EnableWhenOutcome(enabled, null);
    }

    public static EnableWhenOutcome notEvaluated(String reason) {
      return new EnableWhenOutcome(true, reason);
    }

    public boolean isEnabled() {
      return enabled;
    }

    /**
     * null if the enableWhen was actually evaluated; otherwise why it wasn't, in which case
     * {@link #isEnabled()} is true because we can't show it isn't.
     */
    public String getUncheckable() {
      return uncheckable;
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
  public boolean isQuestionEnabled(ValidationContext hostContext, QuestionnaireItemComponent qitem, QStack qstack, FHIRPathEngine engine) {
    return checkQuestionEnabled(hostContext, qitem, qstack, engine).isEnabled();
  }

  /**
   * As {@link #isQuestionEnabled}, but also reports whether the answer could be arrived at.
   *
   * <p>An enableWhen expression can reference things the validator does not have - a launchContext
   * variable such as %patient, most obviously, since there is no patient in scope when a
   * QuestionnaireResponse is validated on its own. When that happens we cannot say whether the item
   * is enabled, and we must not say it is disabled: reporting "item has answer, even though it is
   * not enabled" off an expression that never ran is worse than saying nothing. So the item is
   * treated as enabled, and the caller is told why the check did not happen. See #2404.
   */
  public EnableWhenOutcome checkQuestionEnabled(ValidationContext hostContext, QuestionnaireItemComponent qitem, QStack qstack, FHIRPathEngine engine) {
    if (hasExpressionExtension(qitem)) {
      List<String> unresolved = new ArrayList<>();
      try {
        Map<String, List<Base>> variables = collectVariables(hostContext, qitem, qstack, engine, unresolved);
        String expr = getExpression(qitem);
        ExpressionNode node = engine.parse(expr);
        // an expression that names something we can't supply doesn't fail - the FHIRPath host
        // services answer an unknown %name with an empty list - it quietly evaluates to false, and
        // the item gets reported as disabled. So look for those names first (#2404)
        Set<String> missing = new LinkedHashSet<>();
        findUnsuppliableVariables(node, variables.keySet(), collectDefinedVariableNames(node, new LinkedHashSet<>()), missing);
        if (!missing.isEmpty()) {
          return EnableWhenOutcome.notEvaluated(describeMissing(missing, unresolved));
        }
        return EnableWhenOutcome.evaluated(engine.evaluateToBoolean(hostContext, qstack.a, qstack.a, qstack.a, node, variables));
      } catch (FHIRException e) {
        // a FHIRPath problem - the expression, or something it referred to, could not be evaluated.
        // Deliberately not catching Exception: anything else here is a bug in this code, and must
        // not be disguised as an unevaluatable expression
        return EnableWhenOutcome.notEvaluated(describeFailure(e, unresolved));
      }
    }

    if (!qitem.hasEnableWhen()) {
      return EnableWhenOutcome.evaluated(true);
    }

    List<EnableWhenResult> evaluationResults = new ArrayList<>();
    for (QuestionnaireItemEnableWhenComponent enableCondition : qitem.getEnableWhen()) {
      evaluationResults.add(evaluateCondition(enableCondition, qitem, qstack));
    }
    return EnableWhenOutcome.evaluated(checkConditionResults(evaluationResults, qitem));
  }

  /**
   * The names the FHIRPath engine resolves for itself. Anything else has to come from the variables
   * we supply, from defineVariable() inside the expression, or from a host we don't have.
   */
  private static final String[] SYSTEM_VARIABLES = { "sct", "loinc", "ucum", "resource", "rootResource", "context", "us-zip" };

  private String describeMissing(Set<String> missing, List<String> unresolved) {
    StringBuilder b = new StringBuilder();
    b.append("it refers to ");
    boolean first = true;
    for (String s : missing) {
      if (first) { first = false; } else { b.append(", "); }
      b.append("%").append(s);
    }
    b.append(missing.size() == 1 ? ", which is not available when validating a QuestionnaireResponse on its own" :
                                   ", which are not available when validating a QuestionnaireResponse on its own");
    if (!unresolved.isEmpty()) {
      b.append("; these variables could not be evaluated either: ").append(String.join(", ", unresolved));
    }
    return b.toString();
  }

  /**
   * Names the expression introduces for itself with defineVariable(). Collected across the whole
   * expression rather than in evaluation order - being generous here only means we decline to
   * report something, which is the safe direction.
   */
  private Set<String> collectDefinedVariableNames(ExpressionNode node, Set<String> names) {
    if (node == null) {
      return names;
    }
    if (node.getKind() == ExpressionNode.Kind.Function && node.getFunction() == ExpressionNode.Function.DefineVariable
        && node.getParameters() != null && !node.getParameters().isEmpty()) {
      String n = literalNameOf(node.getParameters().get(0));
      if (n != null) {
        names.add(n);
      }
    }
    if (node.getParameters() != null) {
      for (ExpressionNode p : node.getParameters()) {
        collectDefinedVariableNames(p, names);
      }
    }
    collectDefinedVariableNames(node.getInner(), names);
    collectDefinedVariableNames(node.getGroup(), names);
    collectDefinedVariableNames(node.getOpNext(), names);
    return names;
  }

  private String literalNameOf(ExpressionNode node) {
    if (node != null && node.getKind() == ExpressionNode.Kind.Constant && node.getConstant() != null
        && !(node.getConstant() instanceof FHIRConstant)) {
      return node.getConstant().primitiveValue();
    }
    return null;
  }

  private void findUnsuppliableVariables(ExpressionNode node, Set<String> supplied, Set<String> defined, Set<String> missing) {
    if (node == null) {
      return;
    }
    if (node.getKind() == ExpressionNode.Kind.Constant && node.getConstant() instanceof FHIRConstant) {
      String v = ((FHIRConstant) node.getConstant()).getValue();
      if (v != null && v.startsWith("%")) {
        String name = v.substring(1);
        // %`vs-...`, %`cs-...` and %`ext-...` are resolved by the engine itself
        if (!name.startsWith("`") && !name.startsWith("\"") && !Utilities.existsInList(name, SYSTEM_VARIABLES)
            && !supplied.contains(name) && !defined.contains(name)) {
          missing.add(name);
        }
      }
    }
    if (node.getParameters() != null) {
      for (ExpressionNode p : node.getParameters()) {
        findUnsuppliableVariables(p, supplied, defined, missing);
      }
    }
    findUnsuppliableVariables(node.getInner(), supplied, defined, missing);
    findUnsuppliableVariables(node.getGroup(), supplied, defined, missing);
    findUnsuppliableVariables(node.getOpNext(), supplied, defined, missing);
  }

  private String describeFailure(Exception e, List<String> unresolved) {
    String msg = e.getMessage() == null ? e.getClass().getName() : e.getMessage();
    if (unresolved.isEmpty()) {
      return msg;
    } else {
      return msg + " (these variables could not be evaluated either: " + String.join(", ", unresolved) + ")";
    }
  }

  /**
   * Gather the variables declared by the 'variable' extension that are in scope for qitem.
   *
   * <p>Scope runs outwards in: the Questionnaire's own variables are visible everywhere, an item's
   * are visible to that item and its descendants, and an inner declaration of the same name shadows
   * an outer one. Declarations are evaluated in that order, and each one can see the ones before it,
   * because that is how they are written in practice - a variable built from an earlier variable.
   *
   * <p>All of them are evaluated against the QuestionnaireResponse, which is the context the
   * enableWhen expression itself is evaluated in.
   *
   * <p>A variable that cannot be evaluated is left undefined rather than being allowed to abort the
   * whole check: it may be one the expression never touches. If the expression does touch it, the
   * expression itself will fail, and the names collected here go into the message.
   */
  private Map<String, List<Base>> collectVariables(ValidationContext hostContext, QuestionnaireItemComponent qitem, QStack qstack, FHIRPathEngine engine, List<String> unresolved) {
    // a launch context is what a name falls back to when the questionnaire does not define a
    // variable of that name itself, so seed with them and let any variable declaration shadow one
    Map<String, List<Base>> variables = new LinkedHashMap<>(qstack.getLaunchContexts());
    if (qstack.getQ() != null && qstack.getQ().q() != null) {
      addVariables(hostContext, qstack.getQ().q().getExtensionsByUrl(ExtensionDefinitions.EXT_VARIABLE), qstack.a, engine, variables, unresolved);
    }
    for (QuestionnaireAnswerPair pair : qstack) {
      if (pair.getQ() != null) {
        addVariables(hostContext, pair.getQ().getExtensionsByUrl(ExtensionDefinitions.EXT_VARIABLE), qstack.a, engine, variables, unresolved);
      }
    }
    addVariables(hostContext, qitem.getExtensionsByUrl(ExtensionDefinitions.EXT_VARIABLE), qstack.a, engine, variables, unresolved);
    return variables;
  }

  private void addVariables(ValidationContext hostContext, List<Extension> exts, Element base, FHIRPathEngine engine, Map<String, List<Base>> variables, List<String> unresolved) {
    for (Extension ext : exts) {
      if (ext.getValue() instanceof Expression) {
        Expression expr = (Expression) ext.getValue();
        if (expr.hasName() && expr.hasExpression() && "text/fhirpath".equals(expr.getLanguage())) {
          try {
            ExpressionNode node = engine.parse(expr.getExpression());
            // a name declared twice at the same level is the questionnaire's problem, not ours; the
            // map keeps the last one, which is also what shadowing does for the nested case
            variables.put(expr.getName(), engine.evaluate(hostContext, base, base, base, node, new LinkedHashMap<>(variables)));
            unresolved.remove(expr.getName());
          } catch (FHIRException e) {
            variables.remove(expr.getName());
            if (!unresolved.contains(expr.getName())) {
              unresolved.add(expr.getName());
            }
          }
        }
      }
    }
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
    boolean result = false;
    for (Element answer : answerItems) {
      result = result || evaluateAnswer(answer, enableCondition.getAnswer(), enableCondition.getOperator());
    }
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
    QuestionnaireItemComponent targetQ = qstack.getQ().q().getQuestion(ew.getQuestion());
    if (targetQ != null) {
      QuestionnaireItemComponent groupQ = qstack.getQ().q().getCommonGroup(sourceQ, targetQ);
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
    // didn't find it? look inside the items on the answers too
    List<Element> answerChildren = focus.getChildren(ANSWER_ELEMENT);
    for (Element answer : answerChildren) {
      retVal.addAll(findOnItem(answer, question));
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
    Element linkIdChild = item.getNamedChild(LINKID_ELEMENT, false);
    if (linkIdChild != null && linkIdChild.getValue().equals(linkId)) {
      return true;
    }
    return false;
  }
}