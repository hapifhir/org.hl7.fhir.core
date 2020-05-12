package org.hl7.fhir.validation.instance.type;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.JsonParser;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.TimeType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.EnableWhenEvaluator;
import org.hl7.fhir.validation.instance.EnableWhenEvaluator.QStack;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidatorHostContext;

import ca.uhn.fhir.util.ObjectUtil;

public class QuestionnaireValidator extends BaseValidator {

  private EnableWhenEvaluator myEnableWhenEvaluator;
  private FHIRPathEngine fpe;

  public QuestionnaireValidator(IWorkerContext context, EnableWhenEvaluator myEnableWhenEvaluator, FHIRPathEngine fpe, TimeTracker timeTracker) {
    super(context);
    source = Source.InstanceValidator;
    this.myEnableWhenEvaluator = myEnableWhenEvaluator;
    this.fpe = fpe;
    this.timeTracker = timeTracker;
  }

  public void validateQuestionannaire(List<ValidationMessage> errors, Element element, Element element2, NodeStack stack) {
    ArrayList<Element> parents = new ArrayList<>();
    parents.add(element);
    validateQuestionannaireItem(errors, element, element, stack, parents);    
  }
  
  private void validateQuestionannaireItem(List<ValidationMessage> errors, Element element, Element questionnaire, NodeStack stack, List<Element> parents) {
    List<Element> list = getItems(element);
    for (int i = 0; i < list.size(); i++) {
      Element e = list.get(i);
      NodeStack ns = stack.push(e, i, e.getProperty().getDefinition(), e.getProperty().getDefinition());
      validateQuestionnaireElement(errors, ns, questionnaire, e, parents);
      List<Element> np = new ArrayList<Element>();
      np.add(e);
      np.addAll(parents);
      validateQuestionannaireItem(errors, e, questionnaire, ns, np);
    }
  }


  private void validateQuestionnaireElement(List<ValidationMessage> errors, NodeStack ns, Element questionnaire, Element item, List<Element> parents) {
    // R4+
    if ((FHIRVersion.isR4Plus(context.getVersion())) && (item.hasChildren("enableWhen"))) {
      List<Element> ewl = item.getChildren("enableWhen");
      for (Element ew : ewl) {
        String ql = ew.getNamedChildValue("question");
        if (rule(errors, IssueType.BUSINESSRULE, ns.getLiteralPath(), ql != null, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_NOLINK)) {
          Element tgt = getQuestionById(item, ql);
          if (rule(errors, IssueType.BUSINESSRULE, ns.getLiteralPath(), tgt == null, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_ISINNER)) {
            tgt = getQuestionById(questionnaire, ql);
            if (rule(errors, IssueType.BUSINESSRULE, ns.getLiteralPath(), tgt != null, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_NOTARGET, ql)) {
              if (rule(errors, IssueType.BUSINESSRULE, ns.getLiteralPath(), tgt != item, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_SELF)) {
                if (!isBefore(item, tgt, parents)) {
                  warning(errors, IssueType.BUSINESSRULE, ns.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_Q_ENABLEWHEN_AFTER, ql);
                }
              }
            }
          }
        }
      }
    }
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

  public void validateQuestionannaireResponse(ValidatorHostContext hostContext, List<ValidationMessage> errors, Element element, NodeStack stack) throws FHIRException {
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
    if (hint(errors, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), questionnaire != null, I18nConstants.QUESTIONNAIRE_QR_Q_NONE)) {
      long t = System.nanoTime();
      Questionnaire qsrc = questionnaire.startsWith("#") ? loadQuestionnaire(element, questionnaire.substring(1)) : context.fetchResource(Questionnaire.class, questionnaire);
      if (warning(errors, IssueType.REQUIRED, q.line(), q.col(), stack.getLiteralPath(), qsrc != null, I18nConstants.QUESTIONNAIRE_QR_Q_NOTFOUND, questionnaire)) {
        boolean inProgress = "in-progress".equals(element.getNamedChildValue("status"));
        validateQuestionannaireResponseItems(hostContext, qsrc, qsrc.getItem(), errors, element, stack, inProgress, element, new QStack(qsrc, element));
      }
    }
  }

  private Questionnaire loadQuestionnaire(Element resource, String id) throws FHIRException {
    try {
      for (Element contained : resource.getChildren("contained")) {
        if (contained.getIdBase().equals(id)) {
          FhirPublication v = FhirPublication.fromCode(context.getVersion());
          ByteArrayOutputStream bs = new ByteArrayOutputStream();
          new JsonParser(context).compose(contained, bs, OutputStyle.NORMAL, id);
          byte[] json = bs.toByteArray();
          switch (v) {
            case DSTU1:
              throw new FHIRException(context.formatMessage(I18nConstants.UNSUPPORTED_VERSION_R1));
            case DSTU2:
              org.hl7.fhir.dstu2.model.Resource r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(json);
              Resource r5 = VersionConvertor_10_50.convertResource(r2);
              if (r5 instanceof Questionnaire)
                return (Questionnaire) r5;
              else
                return null;
            case DSTU2016May:
              org.hl7.fhir.dstu2016may.model.Resource r2a = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(json);
              r5 = VersionConvertor_14_50.convertResource(r2a);
              if (r5 instanceof Questionnaire)
                return (Questionnaire) r5;
              else
                return null;
            case STU3:
              org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(json);
              r5 = VersionConvertor_30_50.convertResource(r3, false);
              if (r5 instanceof Questionnaire)
                return (Questionnaire) r5;
              else
                return null;
            case R4:
              org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(json);
              r5 = VersionConvertor_40_50.convertResource(r4);
              if (r5 instanceof Questionnaire)
                return (Questionnaire) r5;
              else
                return null;
            case R5:
              r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(json);
              if (r5 instanceof Questionnaire)
                return (Questionnaire) r5;
              else
                return null;
          }
        }
      }
      return null;
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

  private void validateQuestionnaireResponseItem(ValidatorHostContext hostContext, Questionnaire qsrc, QuestionnaireItemComponent qItem, List<ValidationMessage> errors, Element element, NodeStack stack, boolean inProgress, Element questionnaireResponseRoot, QStack qstack) {
    String text = element.getNamedChildValue("text");
    rule(errors, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), Utilities.noString(text) || text.equals(qItem.getText()), I18nConstants.QUESTIONNAIRE_QR_ITEM_TEXT, qItem.getLinkId());

    List<Element> answers = new ArrayList<Element>();
    element.getNamedChildren("answer", answers);
    if (inProgress)
      warning(errors, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), isAnswerRequirementFulfilled(qItem, answers), I18nConstants.QUESTIONNAIRE_QR_ITEM_MISSING, qItem.getLinkId());
    else if (myEnableWhenEvaluator.isQuestionEnabled(hostContext, qItem, qstack, fpe)) {
      rule(errors, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), isAnswerRequirementFulfilled(qItem, answers), I18nConstants.QUESTIONNAIRE_QR_ITEM_MISSING, qItem.getLinkId());
    } else if (!answers.isEmpty()) { // items without answers should be allowed, but not items with answers to questions that are disabled
      // it appears that this is always a duplicate error - it will always already have been reported, so no need to report it again?
      // GDG 2019-07-13
//      rule(errors, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), !isAnswerRequirementFulfilled(qItem, answers), I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTENABLED, qItem.getLinkId());
    }

    if (answers.size() > 1)
      rule(errors, IssueType.INVALID, answers.get(1).line(), answers.get(1).col(), stack.getLiteralPath(), qItem.getRepeats(), I18nConstants.QUESTIONNAIRE_QR_ITEM_ONLYONEA);

    for (Element answer : answers) {
      NodeStack ns = stack.push(answer, -1, null, null);
      if (qItem.getType() != null) {
        switch (qItem.getType()) {
          case GROUP:
            rule(errors, IssueType.STRUCTURE, answer.line(), answer.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_GROUP);
            break;
          case DISPLAY:  // nothing
            break;
          case BOOLEAN:
            validateQuestionnaireResponseItemType(errors, answer, ns, "boolean");
            break;
          case DECIMAL:
            validateQuestionnaireResponseItemType(errors, answer, ns, "decimal");
            break;
          case INTEGER:
            validateQuestionnaireResponseItemType(errors, answer, ns, "integer");
            break;
          case DATE:
            validateQuestionnaireResponseItemType(errors, answer, ns, "date");
            break;
          case DATETIME:
            validateQuestionnaireResponseItemType(errors, answer, ns, "dateTime");
            break;
          case TIME:
            validateQuestionnaireResponseItemType(errors, answer, ns, "time");
            break;
          case STRING:
            validateQuestionnaireResponseItemType(errors, answer, ns, "string");
            break;
          case TEXT:
            validateQuestionnaireResponseItemType(errors, answer, ns, "text");
            break;
          case URL:
            validateQuestionnaireResponseItemType(errors, answer, ns, "uri");
            break;
          case ATTACHMENT:
            validateQuestionnaireResponseItemType(errors, answer, ns, "Attachment");
            break;
          case REFERENCE:
            validateQuestionnaireResponseItemType(errors, answer, ns, "Reference");
            break;
          case QUANTITY:
            if ("Quantity".equals(validateQuestionnaireResponseItemType(errors, answer, ns, "Quantity")))
              if (qItem.hasExtension("???"))
                validateQuestionnaireResponseItemQuantity(errors, answer, ns);
            break;
          case CHOICE:
            String itemType = validateQuestionnaireResponseItemType(errors, answer, ns, "Coding", "date", "time", "integer", "string");
            if (itemType != null) {
              if (itemType.equals("Coding")) validateAnswerCode(errors, answer, ns, qsrc, qItem, false);
              else if (itemType.equals("date")) checkOption(errors, answer, ns, qsrc, qItem, "date");
              else if (itemType.equals("time")) checkOption(errors, answer, ns, qsrc, qItem, "time");
              else if (itemType.equals("integer"))
                checkOption(errors, answer, ns, qsrc, qItem, "integer");
              else if (itemType.equals("string")) checkOption(errors, answer, ns, qsrc, qItem, "string");
            }
            break;
          case OPENCHOICE:
            itemType = validateQuestionnaireResponseItemType(errors, answer, ns, "Coding", "date", "time", "integer", "string");
            if (itemType != null) {
              if (itemType.equals("Coding")) validateAnswerCode(errors, answer, ns, qsrc, qItem, true);
              else if (itemType.equals("date")) checkOption(errors, answer, ns, qsrc, qItem, "date");
              else if (itemType.equals("time")) checkOption(errors, answer, ns, qsrc, qItem, "time");
              else if (itemType.equals("integer"))
                checkOption(errors, answer, ns, qsrc, qItem, "integer");
              else if (itemType.equals("string"))
                checkOption(errors, answer, ns, qsrc, qItem, "string", true);
            }
            break;
//          case QUESTION:
          case NULL:
            // no validation
            break;
        }
      }
      if (qItem.getType() != QuestionnaireItemType.GROUP) {
        // if it's a group, we already have an error before getting here, so no need to hammer away on that 
        validateQuestionannaireResponseItems(hostContext, qsrc, qItem.getItem(), errors, answer, stack, inProgress, questionnaireResponseRoot, qstack);
      }
    }
    if (qItem.getType() == null) {
      fail(errors, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTYPE, qItem.getLinkId());
    } else if (qItem.getType() == QuestionnaireItemType.DISPLAY) {
      List<Element> items = new ArrayList<Element>();
      element.getNamedChildren("item", items);
      rule(errors, IssueType.STRUCTURE, element.line(), element.col(), stack.getLiteralPath(), items.isEmpty(), I18nConstants.QUESTIONNAIRE_QR_ITEM_DISPLAY, qItem.getLinkId());
    } else if (qItem.getType() != QuestionnaireItemType.GROUP) {
      List<Element> items = new ArrayList<Element>();
      element.getNamedChildren("item", items);
      rule(errors, IssueType.STRUCTURE, element.line(), element.col(), stack.getLiteralPath(), items.isEmpty(), I18nConstants.QUESTIONNAIRE_QR_ITEM_GROUP_ANSWER, qItem.getLinkId());
    } else {
       validateQuestionannaireResponseItems(hostContext, qsrc, qItem.getItem(), errors, element, stack, inProgress, questionnaireResponseRoot, qstack);
    }
  }

  private boolean isAnswerRequirementFulfilled(QuestionnaireItemComponent qItem, List<Element> answers) {
    return !answers.isEmpty() || !qItem.getRequired() || qItem.getType() == QuestionnaireItemType.GROUP;
  }

  private void validateQuestionnaireResponseItem(ValidatorHostContext hostcontext, Questionnaire qsrc, QuestionnaireItemComponent qItem, List<ValidationMessage> errors, List<Element> elements, NodeStack stack, boolean inProgress, Element questionnaireResponseRoot, QStack qstack) {
    if (elements.size() > 1)
      rule(errors, IssueType.INVALID, elements.get(1).line(), elements.get(1).col(), stack.getLiteralPath(), qItem.getRepeats(), I18nConstants.QUESTIONNAIRE_QR_ITEM_ONLYONEI, qItem.getLinkId());
    int i = 0;
    for (Element element : elements) {
      NodeStack ns = stack.push(element, i, null, null);
      validateQuestionnaireResponseItem(hostcontext, qsrc, qItem, errors, element, ns, inProgress, questionnaireResponseRoot, qstack.push(qItem, element));
      i++;
    }
  }

  private int getLinkIdIndex(List<QuestionnaireItemComponent> qItems, String linkId) {
    for (int i = 0; i < qItems.size(); i++) {
      if (linkId.equals(qItems.get(i).getLinkId()))
        return i;
    }
    return -1;
  }

  private void validateQuestionannaireResponseItems(ValidatorHostContext hostContext, Questionnaire qsrc, List<QuestionnaireItemComponent> qItems, List<ValidationMessage> errors, Element element, NodeStack stack, boolean inProgress, Element questionnaireResponseRoot, QStack qstack) {
    List<Element> items = new ArrayList<Element>();
    element.getNamedChildren("item", items);
    // now, sort into stacks
    Map<String, List<Element>> map = new HashMap<String, List<Element>>();
    int lastIndex = -1;
    for (Element item : items) {
      String linkId = item.getNamedChildValue("linkId");
      if (rule(errors, IssueType.REQUIRED, item.line(), item.col(), stack.getLiteralPath(), !Utilities.noString(linkId), I18nConstants.QUESTIONNAIRE_QR_ITEM_NOLINKID)) {
        int index = getLinkIdIndex(qItems, linkId);
        if (index == -1) {
          QuestionnaireItemComponent qItem = findQuestionnaireItem(qsrc, linkId);
          if (qItem != null) {
            rule(errors, IssueType.STRUCTURE, item.line(), item.col(), stack.getLiteralPath(), index > -1, misplacedItemError(qItem));
            NodeStack ns = stack.push(item, -1, null, null);
            validateQuestionnaireResponseItem(hostContext, qsrc, qItem, errors, item, ns, inProgress, questionnaireResponseRoot, qstack.push(qItem, item));
          } else
            rule(errors, IssueType.NOTFOUND, item.line(), item.col(), stack.getLiteralPath(), index > -1, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTFOUND, linkId);
        } else {
          rule(errors, IssueType.STRUCTURE, item.line(), item.col(), stack.getLiteralPath(), index >= lastIndex, I18nConstants.QUESTIONNAIRE_QR_ITEM_ORDER);
          lastIndex = index;

          // If an item has a child called "linkId" but no child called "answer",
          // we'll treat it as not existing for the purposes of enableWhen validation
          if (item.hasChildren("answer") || item.hasChildren("item")) {
            List<Element> mapItem = map.computeIfAbsent(linkId, key -> new ArrayList<>());
            mapItem.add(item);
          }
        }
      }
    }

    // ok, now we have a list of known items, grouped by linkId. We've made an error for anything out of order
    for (QuestionnaireItemComponent qItem : qItems) {
      List<Element> mapItem = map.get(qItem.getLinkId());
      validateQuestionnaireResponseItem(hostContext, qsrc, errors, element, stack, inProgress, questionnaireResponseRoot, qItem, mapItem, qstack);
    }
  }

  public void validateQuestionnaireResponseItem(ValidatorHostContext hostContext, Questionnaire qsrc, List<ValidationMessage> errors, Element element, NodeStack stack, boolean inProgress, Element questionnaireResponseRoot, QuestionnaireItemComponent qItem, List<Element> mapItem, QStack qstack) {
    boolean enabled = myEnableWhenEvaluator.isQuestionEnabled(hostContext, qItem, qstack, fpe);
    if (mapItem != null) {
      if (!enabled) {
        int i = 0;
        for (Element e : mapItem) {
          NodeStack ns = stack.push(e, i, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          rule(errors, IssueType.INVALID, e.line(), e.col(), ns.getLiteralPath(), enabled, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTENABLED2, qItem.getLinkId());
          i++;
        }
      }

      // Recursively validate child items
      validateQuestionnaireResponseItem(hostContext, qsrc, qItem, errors, mapItem, stack, inProgress, questionnaireResponseRoot, qstack);

    } else {

      // item is missing, is the question enabled?
      if (enabled && qItem.getRequired()) {
        String message = context.formatMessage(I18nConstants.QUESTIONNAIRE_QR_ITEM_MISSING, qItem.getLinkId());
        if (inProgress) {
          warning(errors, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), false, message);
        } else {
          rule(errors, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), false, message);
        }
      }

    }

  }

  private String misplacedItemError(QuestionnaireItemComponent qItem) {
    return qItem.hasLinkId() ? String.format("Structural Error: item with linkid %s is in the wrong place", qItem.getLinkId()) : "Structural Error: item is in the wrong place";
  }

  private void validateQuestionnaireResponseItemQuantity(List<ValidationMessage> errors, Element answer, NodeStack stack) {

  }

  private String validateQuestionnaireResponseItemType(List<ValidationMessage> errors, Element element, NodeStack stack, String... types) {
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
      if (types.length == 1)
        rule(errors, IssueType.STRUCTURE, values.get(0).line(), values.get(0).col(), ns.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_WRONGTYPE, types[0]);
      else
        rule(errors, IssueType.STRUCTURE, values.get(0).line(), values.get(0).col(), ns.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_WRONGTYPE2, l.toString());
    }
    return null;
  }

  private QuestionnaireItemComponent findQuestionnaireItem(Questionnaire qSrc, String linkId) {
    return findItem(qSrc.getItem(), linkId);
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

  private void validateAnswerCode(List<ValidationMessage> errors, Element value, NodeStack stack, Questionnaire qSrc, String ref, boolean theOpenChoice) {
    ValueSet vs = resolveBindingReference(qSrc, ref, qSrc.getUrl());
    if (warning(errors, IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), vs != null, I18nConstants.TERMINOLOGY_TX_VALUESET_NOTFOUND, describeReference(ref))) {
      try {
        Coding c = ObjectConverter.readAsCoding(value);
        if (isBlank(c.getCode()) && isBlank(c.getSystem()) && isNotBlank(c.getDisplay())) {
          if (theOpenChoice) {
            return;
          }
        }

        long t = System.nanoTime();
        ValidationResult res = context.validateCode(new ValidationOptions(stack.getWorkingLang()), c, vs);
        timeTracker.tx(t, System.nanoTime());
        if (!res.isOk()) {
          txRule(errors, res.getTxLink(), IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_BADOPTION, c.getSystem(), c.getCode());
        } else if (res.getSeverity() != null) {
          super.addValidationMessage(errors, IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), res.getMessage(), res.getSeverity(), Source.TerminologyEngine, null);
        }
      } catch (Exception e) {
        warning(errors, IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_CODING, e.getMessage());
      }
    }
  }

  private void validateAnswerCode(List<ValidationMessage> errors, Element answer, NodeStack stack, Questionnaire qSrc, QuestionnaireItemComponent qItem, boolean theOpenChoice) {
    Element v = answer.getNamedChild("valueCoding");
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0)
      checkCodingOption(errors, answer, stack, qSrc, qItem, theOpenChoice);
      //      validateAnswerCode(errors, v, stack, qItem.getOption());
    else if (qItem.hasAnswerValueSet())
      validateAnswerCode(errors, v, stack, qSrc, qItem.getAnswerValueSet(), theOpenChoice);
    else
      hint(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONS);
  }

  private void checkOption(List<ValidationMessage> errors, Element answer, NodeStack stack, Questionnaire qSrc, QuestionnaireItemComponent qItem, String type) {
    checkOption(errors, answer, stack, qSrc, qItem, type, false);
  }

  private void checkOption(List<ValidationMessage> errors, Element answer, NodeStack stack, Questionnaire qSrc, QuestionnaireItemComponent qItem, String type, boolean openChoice) {
    if (type.equals("integer")) checkIntegerOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("date")) checkDateOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("time")) checkTimeOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("string")) checkStringOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("Coding")) checkCodingOption(errors, answer, stack, qSrc, qItem, openChoice);
  }

  private void checkIntegerOption(List<ValidationMessage> errors, Element answer, NodeStack stack, Questionnaire qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
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
        rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSINTEGER);
      } else {
        boolean found = false;
        for (IntegerType item : list) {
          if (item.getValue() == Integer.parseInt(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOINTEGER, v.primitiveValue());
        }
      }
    } else
      hint(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_INTNOOPTIONS);
  }

  private void checkDateOption(List<ValidationMessage> errors, Element answer, NodeStack stack, Questionnaire qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
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
        rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSDATE);
      } else {
        boolean found = false;
        for (DateType item : list) {
          if (item.getValue().equals(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NODATE, v.primitiveValue());
        }
      }
    } else
      hint(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DATENOOPTIONS);
  }

  private void checkTimeOption(List<ValidationMessage> errors, Element answer, NodeStack stack, Questionnaire qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
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
        rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSTIME);
      } else {
        boolean found = false;
        for (TimeType item : list) {
          if (item.getValue().equals(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTIME, v.primitiveValue());
        }
      }
    } else
      hint(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_TIMENOOPTIONS);
  }

  private void checkStringOption(List<ValidationMessage> errors, Element answer, NodeStack stack, Questionnaire qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
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
          rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSSTRING);
        } else {
          boolean found = false;
          for (StringType item : list) {
            if (item.getValue().equals((v.primitiveValue()))) {
              found = true;
              break;
            }
          }
          if (!found) {
            rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOSTRING, v.primitiveValue());
          }
        }
      }
    } else {
      hint(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_STRINGNOOPTIONS);
    }
  }

  private void checkCodingOption(List<ValidationMessage> errors, Element answer, NodeStack stack, Questionnaire qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
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
        rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSCODING);
      } else {
        boolean found = false;
        for (Coding item : list) {
          if (ObjectUtil.equals(item.getSystem(), system) && ObjectUtil.equals(item.getCode(), code)) {
            found = true;
            break;
          }
        }
        if (!found) {
          rule(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOCODING, system, code);
        }
      }
    } else
      hint(errors, IssueType.STRUCTURE, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_CODINGNOOPTIONS);
  }


}