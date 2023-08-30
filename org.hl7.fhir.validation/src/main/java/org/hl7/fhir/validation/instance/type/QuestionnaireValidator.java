package org.hl7.fhir.validation.instance.type;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.QuestionnaireItem;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.TimeType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier.ValidationContextResourceProxy;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.cli.utils.QuestionnaireMode;
import org.hl7.fhir.validation.instance.EnableWhenEvaluator;
import org.hl7.fhir.validation.instance.EnableWhenEvaluator.QStack;
import org.hl7.fhir.validation.instance.type.QuestionnaireValidator.QuestionnaireDerivation;
import org.hl7.fhir.validation.instance.type.QuestionnaireValidator.QuestionnaireDerivationMode;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidatorHostContext;

import ca.uhn.fhir.util.ObjectUtil;

public class QuestionnaireValidator extends BaseValidator {

 
  public enum QuestionnaireDerivationMode {
    EXTENDS, COMPLIES

  }

  public class QuestionnaireDerivation {
    private Questionnaire questionnaire;
    private QuestionnaireDerivationMode mode;
    
    protected QuestionnaireDerivation(Questionnaire questionnaire, QuestionnaireDerivationMode mode) {
      super();
      this.questionnaire = questionnaire;
      this.mode = mode;
    }
    public Questionnaire getQuestionnaire() {
      return questionnaire;
    }
    public QuestionnaireDerivationMode getMode() {
      return mode;
    }
    
  }

  public class ElementWithIndex {

    private Element element;
    private int index;

    public ElementWithIndex(Element element, int index) {
      this.element = element;
      this.index = index;
    }

    public Element getElement() {
      return element;
    }

    public int getIndex() {
      return index;
    }

  }

  public static class QuestionnaireWithContext {
    private Questionnaire q;
    private Element container;
    private String containerPath;

    public static QuestionnaireWithContext fromQuestionnaire(Questionnaire q) {
      if (q == null) {
        return null;
      }
      QuestionnaireWithContext res = new QuestionnaireWithContext();
      res.q = q;
      return res;
    }

    public static QuestionnaireWithContext fromContainedResource(String path, Element e, Questionnaire q) {
      if (q == null) {
        return null;
      }
      QuestionnaireWithContext res = new QuestionnaireWithContext();
      res.q = q;
      res.container = e;
      res.containerPath = path;
      return res;
    }
    
    public Questionnaire q() {
      return q;
    }
  }

  private EnableWhenEvaluator myEnableWhenEvaluator;
  private FHIRPathEngine fpe;
  private QuestionnaireMode questionnaireMode;

  public QuestionnaireValidator(IWorkerContext context, boolean debug, EnableWhenEvaluator myEnableWhenEvaluator, FHIRPathEngine fpe, TimeTracker timeTracker, QuestionnaireMode questionnaireMode, XVerExtensionManager xverManager, Coding jurisdiction) {
    super(context, xverManager, debug);
    source = Source.InstanceValidator;
    this.myEnableWhenEvaluator = myEnableWhenEvaluator;
    this.fpe = fpe;
    this.timeTracker = timeTracker;
    this.questionnaireMode = questionnaireMode;
    this.jurisdiction = jurisdiction;
  }

  public boolean validateQuestionannaire(List<ValidationMessage> errors, Element element, Element element2, NodeStack stack) {
    ArrayList<Element> parents = new ArrayList<>();
    parents.add(element);
    List<QuestionnaireDerivation> derivations = new ArrayList<>();
    boolean ok = checkDerivations(errors, element, element, stack, derivations);
    return validateQuestionannaireItem(errors, element, element, stack, parents, derivations) && ok;    
  }

  private boolean checkDerivations(List<ValidationMessage> errors, Element element, Element questionnaire, NodeStack stack, List<QuestionnaireDerivation> derivations) {
    boolean ok = true;
    List<Element> list = new ArrayList<>();
    element.getNamedChildren("derivedFrom", list);
    for (int i = 0; i < list.size(); i++) {
      Element e = list.get(i);
      NodeStack ns = stack.push(e, i, e.getProperty().getDefinition(), e.getProperty().getDefinition());
      String url = e.primitiveValue();
      Questionnaire q = context.fetchResource(Questionnaire.class, url);
      if (warning(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, q != null, I18nConstants.QUESTIONNAIRE_Q_UNKNOWN_DERIVATION, url)) {
        Element ext = e.getExtension("http://hl7.org/fhir/StructureDefinition/questionnaire-derivationType");
        if (warning(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, ext != null, I18nConstants.QUESTIONNAIRE_Q_NO_DERIVATION_TYPE, url)) {
          NodeStack next = ns.push(ext, -1, ext.getProperty().getDefinition(), ext.getProperty().getDefinition());
          Element v = ext.getNamedChild("value");
          if (warning(errors, "2023-06-15", IssueType.BUSINESSRULE, next, v != null, I18nConstants.QUESTIONNAIRE_Q_NO_DERIVATION_TYPE_VALUE)) {
            NodeStack nv = next.push(v, -1, v.getProperty().getDefinition(), v.getProperty().getDefinition());
            String s = v.getNamedChildValue("system");
            String c = v.getNamedChildValue("code");
            if ("http://hl7.org/fhir/questionnaire-derivationType".equals(s) && "extends".equals(c)) {
              derivations.add(new QuestionnaireDerivation(q, QuestionnaireDerivationMode.EXTENDS));
            } else if ("http://hl7.org/fhir/questionnaire-derivationType".equals(s) && "compliesWith".equals(c)) { 
              derivations.add(new QuestionnaireDerivation(q, QuestionnaireDerivationMode.COMPLIES));
            } else if ("http://hl7.org/fhir/questionnaire-derivationType".equals(s) && "inspiredBy".equals(c)) { 
              hint(errors, "2023-06-15", IssueType.BUSINESSRULE, nv, false, I18nConstants.QUESTIONNAIRE_Q_DERIVATION_TYPE_IGNORED, s+"#"+c);
            } else {
              warning(errors, "2023-06-15", IssueType.BUSINESSRULE, nv, false, I18nConstants.QUESTIONNAIRE_Q_DERIVATION_TYPE_UNKNOWN, s+"#"+c);
            }
          }
        }
      }
    }
    return ok;
  }
  
  private boolean validateQuestionannaireItem(List<ValidationMessage> errors, Element element, Element questionnaire, NodeStack stack, List<Element> parents, List<QuestionnaireDerivation> derivations) {
    boolean ok = true;
    List<Element> list = getItems(element);
    for (int i = 0; i < list.size(); i++) {
      Element e = list.get(i);
      NodeStack ns = stack.push(e, i, e.getProperty().getDefinition(), e.getProperty().getDefinition());
      ok = validateQuestionnaireElement(errors, ns, questionnaire, e, parents, derivations) && ok;
      List<Element> np = new ArrayList<Element>();
      np.add(e);
      np.addAll(parents);
      ok = validateQuestionannaireItem(errors, e, questionnaire, ns, np, derivations) && ok;
    }
    return ok;
  }

  private boolean validateQuestionnaireElement(List<ValidationMessage> errors, NodeStack ns, Element questionnaire, Element item, List<Element> parents, List<QuestionnaireDerivation> derivations) {
    boolean ok = true;
    // R4+
    if ((VersionUtilities.isR4Plus(context.getVersion())) && (item.hasChildren("enableWhen"))) {
      List<Element> ewl = item.getChildren("enableWhen");
      for (Element ew : ewl) {
        String ql = ew.getNamedChildValue("question");
        if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, ns, ql != null, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_NOLINK)) {
          Element tgt = getQuestionById(item, ql);
          if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, ns, tgt == null, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_ISINNER)) {
            tgt = getQuestionById(questionnaire, ql);
            if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, ns, tgt != null, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_NOTARGET, ql, item.getChildValue("linkId"))) {
              if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, ns, tgt != item, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_SELF)) {
                if (!isBefore(item, tgt, parents)) {
                  warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, ns, false, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_AFTER, ql);
                }
              } else {
                ok = false;
              }
            } else {
              ok = false;
            }
          } else {
            ok = false;
          }
        } else {
          ok = false;
        }
      }
    }
    for (QuestionnaireDerivation qd : derivations) {
      ok = validateQuestionnaireElementDerivation(errors, ns, questionnaire, item, qd) && ok;            
    }
    return ok;
  }

  private boolean validateQuestionnaireElementDerivation(List<ValidationMessage> errors, NodeStack ns, Element questionnaire, Element item, QuestionnaireDerivation derivation) {
    boolean ok = true;
    String linkId = item.getNamedChildValue("linkId");
    QuestionnaireItemComponent qi = derivation.questionnaire.getQuestion(linkId);
    if (qi == null) {
      ok = rule(errors, "2023-06-15", IssueType.NOTFOUND, ns.getLiteralPath(), derivation.mode == QuestionnaireDerivationMode.EXTENDS, I18nConstants.QUESTIONNAIRE_Q_ITEM_NOT_DERIVED, derivation.questionnaire.getUrl(), linkId) && ok;
    } else {
      // things to check:

      // type must be the same
      if (qi.hasType()) {
        Element e = item.getNamedChild("type");
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, qi.getType().toCode().equals(e.primitiveValue()), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_TYPE, derivation.questionnaire.getUrl(), linkId, qi.getType().toCode(), e.primitiveValue()) && ok;
        }
      }

      // if it doesn't repeat, it can't start repeating
      if (!qi.getRepeats()) {
        Element e = item.getNamedChild("repeats");
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, !"true".equals(e.primitiveValue()), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_REPEATS, derivation.questionnaire.getUrl(), linkId) && ok;
        }        
      }
      
      // if it is required, it can't become un-required
      if (qi.getRequired()) {
        Element e = item.getNamedChild("required");
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, "true".equals(e.primitiveValue()), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_REQUIRED, derivation.questionnaire.getUrl(), linkId) && ok;
        }        
      }

      // if it has a definition, it shouldn't change
      if (qi.hasDefinition()) {
        Element e = item.getNamedChild("definition");
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          hint(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, "true".equals(e.primitiveValue()), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_DEFINITION, derivation.questionnaire.getUrl(), linkId, qi.getDefinition());
        } else {
          hint(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, false, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_DEFINITION, derivation.questionnaire.getUrl(), linkId, qi.getDefinition());          
        }
      }

      // if it has maxLength, that can't get longer
      if (qi.hasMaxLength()) {
        Element e = item.getNamedChild("maxlength");
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          int ml = Utilities.parseInt(e.primitiveValue(), 0);
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, ml <= qi.getMaxLength(), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_MAXLENGTH, derivation.questionnaire.getUrl(), linkId, qi.getMaxLength()) && ok;
        } else {
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, false, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_MAXLENGTH, derivation.questionnaire.getUrl(), linkId, qi.getMaxLength()) & ok;          
        }
      }

      if (qi.hasAnswerOption()) {
        Element e = item.getNamedChild("answerValueSet");
        if (rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, e == null, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_ANSWER_TYPE, derivation.questionnaire.getUrl(), linkId, "Option", "ValueSet")) {
          // for each answer option here, there must be a matching answer option in the source
          List<Element> list = new ArrayList<>();
          item.getNamedChildren("answerOption", list);
          if (rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, !list.isEmpty(), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_ANSWER_OPTIONS, derivation.questionnaire.getUrl(), linkId, qi.getAnswerOption().size())) {
            for (int i = 0; i < list.size(); i++) {
              Element ao = list.get(i);
              NodeStack nao = ns.push(ao, i, ao.getProperty().getDefinition(), ao.getProperty().getDefinition());
              Element v = ao.getNamedChild("value");
              if (v != null) {
                boolean aok = false;
                switch (v.fhirType()) {
                case "integer": 
                  aok = findAOPrimitive(qi.getAnswerOption(), "integer", v.primitiveValue());
                  break;
                case "date": 
                  aok = findAOPrimitive(qi.getAnswerOption(), "date", v.primitiveValue());
                  break;
                case "time": 
                  aok = findAOPrimitive(qi.getAnswerOption(), "time", v.primitiveValue());
                  break;
                case "string": 
                  aok = findAOPrimitive(qi.getAnswerOption(), "string", v.primitiveValue());
                  break;
                case "Coding": 
                  aok = findAOCoding(qi.getAnswerOption(), new Coding().setSystem(v.getNamedChildValue("system")).setVersion(v.getNamedChildValue("version")).setCode(v.getNamedChildValue("code")));
                  break;
                case "Reference": 
                  aok = findAOReference(qi.getAnswerOption(), new Reference().setReference(v.getNamedChildValue("reference")));
                  break;
                }
                ok= rule(errors, "2023-06-15", IssueType.BUSINESSRULE, nao, aok, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_ANSWER_OPTIONS_NEW, derivation.questionnaire.getUrl(), linkId) && ok;
              }
            }
          } else {
            ok = false;
          }
        } else {
          ok = false;
        }
      }
      if (qi.hasAnswerValueSet()) {
        Element e = item.getNamedChild("answerOption");
        if (rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, e == null, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_ANSWER_TYPE, derivation.questionnaire.getUrl(), linkId, "ValueSet", "Option")) {
          warning(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, e == null, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NI_ANSWER_VS, derivation.questionnaire.getUrl(), linkId);
        } else {
          ok = false;;        
        }
      }
      // if it has codings, these should be repeated (can be added to)
      // if it has n enableWhens, there should be at least n EnableWhens
      // if it has answerCOnstraint, that snouldn't change
      // if it has answerOptions, there can't be new answers
    }
    return ok;
  }
      
  private boolean findAOReference(List<QuestionnaireItemAnswerOptionComponent> answerOptions, Reference value) {
    for (QuestionnaireItemAnswerOptionComponent ao : answerOptions) {
      if (ao.hasValue() && ao.getValue() instanceof Reference) {
        Reference r = ao.getValueReference();
        if (r.matches(value)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean findAOCoding(List<QuestionnaireItemAnswerOptionComponent> answerOptions, Coding value) {
    for (QuestionnaireItemAnswerOptionComponent ao : answerOptions) {
      if (ao.hasValue() && ao.getValue() instanceof Coding) {
        Coding c = ao.getValueCoding();
        if (c.matches(value)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean findAOPrimitive(List<QuestionnaireItemAnswerOptionComponent> answerOptions, String type, String v) {
    for (QuestionnaireItemAnswerOptionComponent ao : answerOptions) {
      if (ao.hasValue() && ao.getValue().isPrimitive() && ao.getValue().fhirType().equals(type) && ao.getValue().primitiveValue().equals(v)) {
        return true;
      }
    }
    return false;
  }

  private boolean isBefore(Element item, Element tgt, List<Element> parents) {
    // we work up the list, looking for tgt in the children of the parents
    if (parents.contains(tgt)) {
      // actually, if the target is a parent, that's automatically ok
      return true;
    }
    for (Element p : parents) {
      int i = findIndex(p, item);
      int t = findIndex(p, tgt);
      if (i > -1 && t > -1) {
        return i > t;
      }
    }
    return false; // unsure... shouldn't ever get to this point;
  }


  private int findIndex(Element parent, Element descendant) {
    for (int i = 0; i < parent.getChildren().size(); i++) {
      if (parent.getChildren().get(i) == descendant || isChild(parent.getChildren().get(i), descendant))
        return i;
    }
    return -1;
  }

  private boolean isChild(Element element, Element descendant) {
    for (Element e : element.getChildren()) {
      if (e == descendant)
        return true;
      if (isChild(e, descendant))
        return true;
    }
    return false;
  }

  private Element getQuestionById(Element focus, String ql) {
    List<Element> list = getItems(focus);
    for (Element item : list) {
      String v = item.getNamedChildValue("linkId");
      if (ql.equals(v))
        return item;
      Element tgt = getQuestionById(item, ql);
      if (tgt != null)
        return tgt;
    }
    return null;

  }

  private List<Element> getItems(Element element) {
    List<Element> list = new ArrayList<>();
    element.getNamedChildren("item", list);
    return list;
  }

  public boolean validateQuestionannaireResponse(ValidatorHostContext hostContext, List<ValidationMessage> errors, Element element, NodeStack stack) throws FHIRException {
    if (questionnaireMode == QuestionnaireMode.NONE) {
      return true;
    }
    boolean ok = true;
    Element q = element.getNamedChild("questionnaire");
    String questionnaire = null;
    if (q != null) {
      /*
       * q.getValue() is correct for R4 content, but we'll also accept the second
       * option just in case we're validating raw STU3 content. Being lenient here
       * isn't the end of the world since if someone is actually doing the reference
       * wrong in R4 content it'll get flagged elsewhere by the validator too
       */
      if (isNotBlank(q.getValue())) {
        questionnaire = q.getValue();
      } else if (isNotBlank(q.getChildValue("reference"))) {
        questionnaire = q.getChildValue("reference");
      }
    }
    boolean qok;
    if (questionnaireMode == QuestionnaireMode.REQUIRED) {
      qok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), questionnaire != null, I18nConstants.QUESTIONNAIRE_QR_Q_NONE);
      ok = qok;
    } else {
      qok = hint(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), questionnaire != null, I18nConstants.QUESTIONNAIRE_QR_Q_NONE);
    }
    if (qok) {
      QuestionnaireWithContext qsrc = null;
      if (questionnaire.startsWith("#")) {
        qsrc = QuestionnaireWithContext.fromContainedResource(stack.getLiteralPath(), element, (Questionnaire) loadContainedResource(errors, stack.getLiteralPath(), element, questionnaire.substring(1), Questionnaire.class));        
      } else {
        qsrc = QuestionnaireWithContext.fromQuestionnaire(context.fetchResource(Questionnaire.class, questionnaire));          
      }
      if (questionnaireMode == QuestionnaireMode.REQUIRED) {
        qok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, q.line(), q.col(), stack.getLiteralPath(), qsrc != null, I18nConstants.QUESTIONNAIRE_QR_Q_NOTFOUND, questionnaire);
        ok = qok && ok;
      } else if (questionnaire.startsWith("http://example.org") || questionnaire.startsWith("https://example.org")) {
        qok = hint(errors, NO_RULE_DATE, IssueType.REQUIRED, q.line(), q.col(), stack.getLiteralPath(), qsrc != null, I18nConstants.QUESTIONNAIRE_QR_Q_NOTFOUND, questionnaire);
      } else {
        qok = warning(errors, NO_RULE_DATE, IssueType.REQUIRED, q.line(), q.col(), stack.getLiteralPath(), qsrc != null, I18nConstants.QUESTIONNAIRE_QR_Q_NOTFOUND, questionnaire);
      }
      if (qok) {
        boolean inProgress = "in-progress".equals(element.getNamedChildValue("status"));
        ok = validateQuestionannaireResponseItems(hostContext, qsrc, qsrc.q().getItem(), errors, element, stack, inProgress, element, new QStack(qsrc, element)) && ok;
      }
    }
    return ok;
  }

  private boolean validateQuestionnaireResponseItem(ValidatorHostContext hostContext, QuestionnaireWithContext qsrc, QuestionnaireItemComponent qItem, List<ValidationMessage> errors, Element element, NodeStack stack, boolean inProgress, Element questionnaireResponseRoot, QStack qstack) {
    BooleanValue ok = new BooleanValue(true);
    
    String text = element.getNamedChildValue("text");
    ok.see(rule(errors, NO_RULE_DATE, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), Utilities.noString(text) || text.equals(qItem.getText()), I18nConstants.QUESTIONNAIRE_QR_ITEM_TEXT, qItem.getLinkId()));

    List<Element> answers = new ArrayList<Element>();
    element.getNamedChildren("answer", answers);
    if (inProgress)
      warning(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), isAnswerRequirementFulfilled(qItem, answers), I18nConstants.QUESTIONNAIRE_QR_ITEM_MISSING, qItem.getLinkId());
    else if (myEnableWhenEvaluator.isQuestionEnabled(hostContext, qItem, qstack, fpe)) {
      ok.see(rule(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), isAnswerRequirementFulfilled(qItem, answers), I18nConstants.QUESTIONNAIRE_QR_ITEM_MISSING, qItem.getLinkId()));
    } else if (!answers.isEmpty()) { // items without answers should be allowed, but not items with answers to questions that are disabled
      // it appears that this is always a duplicate error - it will always already have been reported, so no need to report it again?
      // GDG 2019-07-13
//      rule(errors, UNKNOWN_DATE_TIME, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), !isAnswerRequirementFulfilled(qItem, answers), I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTENABLED, qItem.getLinkId());
    }

    if (answers.size() > 1) {
      ok.see(rule(errors, NO_RULE_DATE, IssueType.INVALID, answers.get(1).line(), answers.get(1).col(), stack.getLiteralPath(), qItem.getRepeats(), I18nConstants.QUESTIONNAIRE_QR_ITEM_ONLYONEA));
    }
    
    int i = 0;
    for (Element answer : answers) {
      NodeStack ns = stack.push(answer, i, null, null);
      if (qItem.getType() != null) {
        switch (qItem.getType()) {
          case GROUP:
            ok.see(rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, answer.line(), answer.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_GROUP));
            break;
          case DISPLAY:  // nothing
            break;
          case BOOLEAN:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "boolean");
            break;
          case DECIMAL:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "decimal");
            break;
          case INTEGER:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "integer");
            break;
          case DATE:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "date");
            break;
          case DATETIME:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "dateTime");
            break;
          case TIME:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "time");
            break;
          case STRING:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "string");
            break;
          case TEXT:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "text");
            break;
          case URL:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "uri");
            break;
          case ATTACHMENT:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "Attachment");
            break;
          case REFERENCE:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "Reference");
            break;
          case QUANTITY:
            if ("Quantity".equals(validateQuestionnaireResponseItemType(errors, answer, ns, ok, "Quantity")))
              if (qItem.hasExtension("???"))
                validateQuestionnaireResponseItemQuantity(errors, answer, ns);
            break;
          case CODING:
            String itemType = validateQuestionnaireResponseItemType(errors, answer, ns, ok, "Coding", "date", "time", "integer", "string");
            if (itemType != null) {
              if (itemType.equals("Coding")) validateAnswerCode(errors, answer, ns, qsrc, qItem, false);
              else if (itemType.equals("date")) checkOption(errors, answer, ns, qsrc, qItem, "date");
              else if (itemType.equals("time")) checkOption(errors, answer, ns, qsrc, qItem, "time");
              else if (itemType.equals("integer"))
                ok.see(checkOption(errors, answer, ns, qsrc, qItem, "integer"));
              else if (itemType.equals("string")) checkOption(errors, answer, ns, qsrc, qItem, "string");
            }
            break;
//          case OPENCHOICE:
//            itemType = validateQuestionnaireResponseItemType(errors, answer, ns, "Coding", "date", "time", "integer", "string");
//            if (itemType != null) {
//              if (itemType.equals("Coding")) validateAnswerCode(errors, answer, ns, qsrc, qItem, true);
//              else if (itemType.equals("date")) checkOption(errors, answer, ns, qsrc, qItem, "date");
//              else if (itemType.equals("time")) checkOption(errors, answer, ns, qsrc, qItem, "time");
//              else if (itemType.equals("integer"))
//                checkOption(errors, answer, ns, qsrc, qItem, "integer");
//              else if (itemType.equals("string"))
//                checkOption(errors, answer, ns, qsrc, qItem, "string", true);
//            }
//            break;
//          case QUESTION:
          case NULL:
            // no validation
            break;
        case QUESTION:
          throw new Error("Shouldn't get here?");
        }
      }
      if (qItem.getType() != QuestionnaireItemType.GROUP) {
        // if it's a group, we already have an error before getting here, so no need to hammer away on that 
        validateQuestionannaireResponseItems(hostContext, qsrc, qItem.getItem(), errors, answer, stack, inProgress, questionnaireResponseRoot, qstack);
      }
      i++;
    }
    if (qItem.getType() == null) {
      ok.see(fail(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTYPE, qItem.getLinkId()));
    } else if (qItem.getType() == QuestionnaireItemType.DISPLAY) {
      List<Element> items = new ArrayList<Element>();
      element.getNamedChildren("item", items);
      ok.see(rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, element.line(), element.col(), stack.getLiteralPath(), items.isEmpty(), I18nConstants.QUESTIONNAIRE_QR_ITEM_DISPLAY, qItem.getLinkId()));
    } else if (qItem.getType() != QuestionnaireItemType.GROUP) {
      List<Element> items = new ArrayList<Element>();
      element.getNamedChildren("item", items);
      ok.see(rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, element.line(), element.col(), stack.getLiteralPath(), items.isEmpty(), I18nConstants.QUESTIONNAIRE_QR_ITEM_GROUP_ANSWER, qItem.getLinkId()));
    } else {
      ok.see(validateQuestionannaireResponseItems(hostContext, qsrc, qItem.getItem(), errors, element, stack, inProgress, questionnaireResponseRoot, qstack));
    }
    return ok.isValue();
  }

  private boolean isAnswerRequirementFulfilled(QuestionnaireItemComponent qItem, List<Element> answers) {
    return !answers.isEmpty() || !qItem.getRequired() || qItem.getType() == QuestionnaireItemType.GROUP;
  }

  private boolean validateQuestionnaireResponseItem(ValidatorHostContext hostcontext, QuestionnaireWithContext qsrc, QuestionnaireItemComponent qItem, List<ValidationMessage> errors, List<ElementWithIndex> elements, NodeStack stack, boolean inProgress, Element questionnaireResponseRoot, QStack qstack) {
    boolean ok = true;
    if (elements.size() > 1) {
      ok = rulePlural(errors, NO_RULE_DATE, IssueType.INVALID, elements.get(1).getElement().line(), elements.get(1).getElement().col(), stack.getLiteralPath(), qItem.getRepeats(), elements.size(), I18nConstants.QUESTIONNAIRE_QR_ITEM_ONLYONEI, qItem.getLinkId()) && ok;
    }
    for (ElementWithIndex element : elements) {
      NodeStack ns = stack.push(element.getElement(), element.getIndex(), null, null);
      ok = validateQuestionnaireResponseItem(hostcontext, qsrc, qItem, errors, element.getElement(), ns, inProgress, questionnaireResponseRoot, qstack.push(qItem, element.getElement())) && ok;
    }
    return ok;
  }

  private int getLinkIdIndex(List<QuestionnaireItemComponent> qItems, String linkId) {
    for (int i = 0; i < qItems.size(); i++) {
      if (linkId.equals(qItems.get(i).getLinkId()))
        return i;
    }
    return -1;
  }

  private boolean validateQuestionannaireResponseItems(ValidatorHostContext hostContext, QuestionnaireWithContext qsrc, List<QuestionnaireItemComponent> qItems, List<ValidationMessage> errors, Element element, NodeStack stack, boolean inProgress, Element questionnaireResponseRoot, QStack qstack) {
    boolean ok = true;
    List<Element> items = new ArrayList<Element>();
    element.getNamedChildren("item", items);
    // now, sort into stacks
    Map<String, List<ElementWithIndex>> map = new HashMap<String, List<ElementWithIndex>>();
    int lastIndex = -1;
    int counter = 0;
    for (Element item : items) {
      String linkId = item.getNamedChildValue("linkId");
      if (rule(errors, NO_RULE_DATE, IssueType.REQUIRED, item.line(), item.col(), stack.getLiteralPath(), !Utilities.noString(linkId), I18nConstants.QUESTIONNAIRE_QR_ITEM_NOLINKID)) {
        int index = getLinkIdIndex(qItems, linkId);
        if (index == -1) {
          QuestionnaireItemComponent qItem = findQuestionnaireItem(qsrc, linkId);
          if (qItem != null) {
            ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, item.line(), item.col(), stack.getLiteralPath(), index > -1, misplacedItemError(qItem)) && ok;
            NodeStack ns = stack.push(item, counter, null, null);
            ok = validateQuestionnaireResponseItem(hostContext, qsrc, qItem, errors, item, ns, inProgress, questionnaireResponseRoot, qstack.push(qItem, item)) && ok;
          } else
            ok = rule(errors, NO_RULE_DATE, IssueType.NOTFOUND, item.line(), item.col(), stack.getLiteralPath(), index > -1, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTFOUND, linkId) && ok;
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, item.line(), item.col(), stack.getLiteralPath(), index >= lastIndex, I18nConstants.QUESTIONNAIRE_QR_ITEM_ORDER) && ok;
          lastIndex = index;

          // If an item has a child called "linkId" but no child called "answer",
          // we'll treat it as not existing for the purposes of enableWhen validation
          if (item.hasChildren("answer") || item.hasChildren("item")) {
            List<ElementWithIndex> mapItem = map.computeIfAbsent(linkId, key -> new ArrayList<>());
            mapItem.add(new ElementWithIndex(item, counter));
          }
        }
      } else {
        ok = false;
      }
      counter++;
    }

    // ok, now we have a list of known items, grouped by linkId. We've made an error for anything out of order
    for (QuestionnaireItemComponent qItem : qItems) {
      List<ElementWithIndex> mapItem = map.get(qItem.getLinkId());
      ok = validateQuestionnaireResponseItem(hostContext, qsrc, errors, element, stack, inProgress, questionnaireResponseRoot, qItem, mapItem, qstack) && ok;
    }
    return ok;
  }

  public boolean validateQuestionnaireResponseItem(ValidatorHostContext hostContext, QuestionnaireWithContext qsrc, List<ValidationMessage> errors, Element element, NodeStack stack, boolean inProgress, Element questionnaireResponseRoot, QuestionnaireItemComponent qItem, List<ElementWithIndex> mapItem, QStack qstack) {
    boolean ok = true;
    boolean enabled = myEnableWhenEvaluator.isQuestionEnabled(hostContext, qItem, qstack, fpe);
    if (mapItem != null) {
      if (!enabled) {
        for (ElementWithIndex e : mapItem) {
          NodeStack ns = stack.push(e.getElement(), e.getElement().getIndex(), e.getElement().getProperty().getDefinition(), e.getElement().getProperty().getDefinition());
          ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.getElement().line(), e.getElement().col(), ns.getLiteralPath(), enabled, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTENABLED2, qItem.getLinkId()) && ok;
        }
      }

      // Recursively validate child items
      ok = validateQuestionnaireResponseItem(hostContext, qsrc, qItem, errors, mapItem, stack, inProgress, questionnaireResponseRoot, qstack) && ok;

    } else {

      // item is missing, is the question enabled?
      if (enabled && qItem.getRequired()) {
        String message = context.formatMessage(I18nConstants.QUESTIONNAIRE_QR_ITEM_MISSING, qItem.getLinkId());
        if (inProgress) {
          warning(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), false, message);
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), false, message) && ok;
        }
      }

    }
    return ok;
  }

  private String misplacedItemError(QuestionnaireItemComponent qItem) {
    return qItem.hasLinkId() ? String.format("Structural Error: item with linkid %s is in the wrong place", qItem.getLinkId()) : "Structural Error: item is in the wrong place";
  }

  private void validateQuestionnaireResponseItemQuantity(List<ValidationMessage> errors, Element answer, NodeStack stack) {

  }

  private String validateQuestionnaireResponseItemType(List<ValidationMessage> errors, Element element, NodeStack stack, BooleanValue ok, String... types) {
    List<Element> values = new ArrayList<Element>();
    element.getNamedChildrenWithWildcard("value[x]", values);
    for (int i = 0; i < types.length; i++) {
      if (types[i].equals("text")) {
        types[i] = "string";
      }
    }
    if (values.size() > 0) {
      NodeStack ns = stack.push(values.get(0), -1, null, null);
      CommaSeparatedStringBuilder l = new CommaSeparatedStringBuilder();
      for (String s : types) {
        l.append(s);
        if (values.get(0).getName().equals("value" + Utilities.capitalize(s)))
          return (s);
      }

      ok.see(rulePlural(errors, NO_RULE_DATE, IssueType.STRUCTURE, values.get(0).line(), values.get(0).col(), ns.getLiteralPath(), false, types.length, I18nConstants.QUESTIONNAIRE_QR_ITEM_WRONGTYPE, l.toString()));
    }
    return null;
  }

  private QuestionnaireItemComponent findQuestionnaireItem(QuestionnaireWithContext qSrc, String linkId) {
    return findItem(qSrc.q.getItem(), linkId);
  }

  private QuestionnaireItemComponent findItem(List<QuestionnaireItemComponent> list, String linkId) {
    for (QuestionnaireItemComponent item : list) {
      if (linkId.equals(item.getLinkId()))
        return item;
      QuestionnaireItemComponent result = findItem(item.getItem(), linkId);
      if (result != null)
        return result;
    }
    return null;
  }

  private boolean validateAnswerCode(List<ValidationMessage> errors, Element value, NodeStack stack, QuestionnaireWithContext qSrc, String ref, boolean theOpenChoice) {
    boolean ok = true;
    ValueSet vs = null;
    if (ref.startsWith("#") && qSrc.container != null) {
      vs = (ValueSet) loadContainedResource(errors, qSrc.containerPath, qSrc.container, ref.substring(1), ValueSet.class);
    } else {
      vs = resolveBindingReference(qSrc.q(), ref, qSrc.q().getUrl(), qSrc.q());
    }
    if (warning(errors, NO_RULE_DATE, IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), vs != null, I18nConstants.TERMINOLOGY_TX_VALUESET_NOTFOUND, describeReference(ref))) {
      try {
        Coding c = ObjectConverter.readAsCoding(value);
        if (isBlank(c.getCode()) && isBlank(c.getSystem()) && isNotBlank(c.getDisplay())) {
          if (theOpenChoice) {
            return ok;
          }
        }

        long t = System.nanoTime();
        ValidationContextCarrier vc = makeValidationContext(errors, qSrc);
        ValidationResult res = context.validateCode(new ValidationOptions(stack.getWorkingLang()), c, vs, vc);
        timeTracker.tx(t, "vc "+c.getSystem()+"#"+c.getCode()+" '"+c.getDisplay()+"'");
        if (!res.isOk()) {
          if (res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
            txWarning(errors, NO_RULE_DATE, res.getTxLink(), IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_BADOPTION_CS, c.getSystem(), c.getCode(), vs.present());
          } else {
            ok = txRule(errors, NO_RULE_DATE, res.getTxLink(), IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_BADOPTION, c.getSystem(), c.getCode(), vs.present(), res.getMessage()) && ok;
          }
        } else if (res.getSeverity() != null) {
          super.addValidationMessage(errors, NO_RULE_DATE, IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), res.getMessage(), res.getSeverity(), Source.TerminologyEngine, null);
        } else if (res.getMessage() != null) {
          super.addValidationMessage(errors, NO_RULE_DATE, IssueType.INFORMATIONAL, value.line(), value.col(), stack.getLiteralPath(), res.getMessage(), res.getSeverity() == null ? IssueSeverity.INFORMATION : res.getSeverity(), Source.TerminologyEngine, null);          
        }
      } catch (Exception e) {
        warning(errors, NO_RULE_DATE, IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_CODING, e.getMessage());
      }
    }
    return ok;
  }

  private ValidationContextCarrier makeValidationContext(List<ValidationMessage> errors, QuestionnaireWithContext qSrc) {
    ValidationContextCarrier vc = new ValidationContextCarrier();
    if (qSrc.container == null) {
      vc.getResources().add(new ValidationContextResourceProxy(qSrc.q));
    } else {
      vc.getResources().add(new ValidationContextResourceProxy(errors, qSrc.containerPath, qSrc.container, this));
    }
    return vc;
  }

  private boolean validateAnswerCode(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean theOpenChoice) {
    Element v = answer.getNamedChild("valueCoding");
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0)
      checkCodingOption(errors, answer, stack, qSrc, qItem, theOpenChoice);
      //      validateAnswerCode(errors, v, stack, qItem.getOption());
    else if (qItem.hasAnswerValueSet())
      return validateAnswerCode(errors, v, stack, qSrc, qItem.getAnswerValueSet(), theOpenChoice);
    else
      hint(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONS);
    return true;
  }

  private boolean checkOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, String type) {
    return checkOption(errors, answer, stack, qSrc, qItem, type, false);
  }

  private boolean checkOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, String type, boolean openChoice) {
    if (type.equals("integer")) return checkIntegerOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("date")) return checkDateOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("time")) return checkTimeOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("string")) return checkStringOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("Coding")) return checkCodingOption(errors, answer, stack, qSrc, qItem, openChoice);
    return true;
  }

  private boolean checkIntegerOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    Element v = answer.getNamedChild("valueInteger");
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0) {
      List<IntegerType> list = new ArrayList<IntegerType>();
      for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
        try {
          list.add(components.getValueIntegerType());
        } catch (FHIRException e) {
          // If it's the wrong type, just keep going
        }
      }
      if (list.isEmpty() && !openChoice) {
        ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSINTEGER) && ok;
      } else {
        boolean found = false;
        for (IntegerType item : list) {
          if (item.getValue() == Integer.parseInt(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOINTEGER, v.primitiveValue()) && ok;
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_INTNOOPTIONS);
    }
    return ok;
  }

  private boolean checkDateOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    Element v = answer.getNamedChild("valueDate");
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0) {
      List<DateType> list = new ArrayList<DateType>();
      for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
        try {
          list.add(components.getValueDateType());
        } catch (FHIRException e) {
          // If it's the wrong type, just keep going
        }
      }
      if (list.isEmpty() && !openChoice) {
        ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSDATE) && ok;
      } else {
        boolean found = false;
        for (DateType item : list) {
          if (item.getValue().equals(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NODATE, v.primitiveValue()) && ok;
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DATENOOPTIONS);
    }
    return ok;
  }

  private boolean checkTimeOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    Element v = answer.getNamedChild("valueTime");
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0) {
      List<TimeType> list = new ArrayList<TimeType>();
      for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
        try {
          list.add(components.getValueTimeType());
        } catch (FHIRException e) {
          // If it's the wrong type, just keep going
        }
      }
      if (list.isEmpty() && !openChoice) {
        ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSTIME) && ok;
      } else {
        boolean found = false;
        for (TimeType item : list) {
          if (item.getValue().equals(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTIME, v.primitiveValue()) && ok;
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_TIMENOOPTIONS);
    }
    return ok;
  }

  private boolean checkStringOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    Element v = answer.getNamedChild("valueString");
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0) {
      List<StringType> list = new ArrayList<StringType>();
      for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
        try {
          if (components.getValue() != null) {
            list.add(components.getValueStringType());
          }
        } catch (FHIRException e) {
          // If it's the wrong type, just keep going
        }
      }
      if (!openChoice) {
        if (list.isEmpty()) {
          ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSSTRING) && ok;
        } else {
          boolean found = false;
          for (StringType item : list) {
            if (item.getValue().equals((v.primitiveValue()))) {
              found = true;
              break;
            }
          }
          if (!found) {
            ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOSTRING, v.primitiveValue()) && ok;
          }
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_STRINGNOOPTIONS);
    }
    return ok;
  }

  private boolean checkCodingOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    
    Element v = answer.getNamedChild("valueCoding");
    String system = v.getNamedChildValue("system");
    String code = v.getNamedChildValue("code");
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0) {
      List<Coding> list = new ArrayList<Coding>();
      for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
        try {
          if (components.getValue() != null) {
            list.add(components.getValueCoding());
          }
        } catch (FHIRException e) {
          // If it's the wrong type, just keep going
        }
      }
      if (list.isEmpty() && !openChoice) {
        ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSCODING) && ok;
      } else {
        boolean found = false;
        for (Coding item : list) {
          if (ObjectUtil.equals(item.getSystem(), system) && ObjectUtil.equals(item.getCode(), code)) {
            found = true;
            break;
          }
        }
        if (!found) {
          ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOCODING, system, code) && ok;
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_CODINGNOOPTIONS);
    }
    return ok;
  }


}