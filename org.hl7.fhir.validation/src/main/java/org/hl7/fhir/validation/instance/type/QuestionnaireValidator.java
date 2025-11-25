package org.hl7.fhir.validation.instance.type;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fhir.ucum.Decimal;
import org.fhir.ucum.Pair;
import org.fhir.ucum.UcumException;
import org.fhir.ucum.UcumService;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.Enumerations.QuantityComparator;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireAnswerConstraint;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.TimeType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier.ValidationContextResourceProxy;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.instance.utils.EnableWhenEvaluator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;
import org.hl7.fhir.validation.instance.utils.EnableWhenEvaluator.QStack;

import ca.uhn.fhir.util.ObjectUtil;

public class QuestionnaireValidator extends BaseValidator {

 
  private static final String SNOMED_NAME = "SNOMED";
  private static final String UCUM_NAME = "UCUM";

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

  public QuestionnaireValidator(BaseValidator parent, EnableWhenEvaluator myEnableWhenEvaluator, FHIRPathEngine fpe, QuestionnaireMode questionnaireMode) {
    super(parent);
    this.myEnableWhenEvaluator = myEnableWhenEvaluator;
    this.fpe = fpe;
    this.questionnaireMode = questionnaireMode;
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
          Element v = ext.getNamedChild("value", false);
          if (warning(errors, "2023-06-15", IssueType.BUSINESSRULE, next, v != null, I18nConstants.QUESTIONNAIRE_Q_NO_DERIVATION_TYPE_VALUE)) {
            NodeStack nv = next.push(v, -1, v.getProperty().getDefinition(), v.getProperty().getDefinition());
            String s = v.getNamedChildValue("system", false);
            String c = v.getNamedChildValue("code", false);
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
        String ql = ew.getNamedChildValue("question", false);
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
    if ((VersionUtilities.isR4Plus(context.getVersion())) && (item.hasChildren("answerValueSet"))) {
      String url = item.getNamedChildValue("answerValueSet");
      if (url != null) {
        ValueSet vs = context.findTxResource(ValueSet.class, url);
        if (vs != null && vs.hasExtension(ExtensionDefinitions.EXT_VALUESET_PARAMETER)) {
          List<Element> list = item.getNamedChild("answerValueSet").getExtensions(ExtensionDefinitions.EXT_BINDING_PARAMETER);
          for (Extension ve : vs.getExtensionsByUrl(ExtensionDefinitions.EXT_VALUESET_PARAMETER)) {
            if (ve.hasExtension("name")) {
              Element be = findBindingParameter(list, ve.getExtensionString("name"));
              if (rule(errors, "2025-03-22", IssueType.BUSINESSRULE, ns, be != null, I18nConstants.VALUESET_PARAMETER_MISSING_BINDING_PARAMETER, vs.getVersionedUrl(), ve.getExtensionString("name"))) {
                be.setUserData(UserDataNames.matchingParameter, ve);
              } else {
                ok = false;
              }
            }
          }
          for (Element ext : list) {
            if (!ext.hasUserData(UserDataNames.matchingParameter)) {
              String name = ext.getExtensionString("name");
              warning(errors, "2025-03-22", IssueType.BUSINESSRULE, ns, Utilities.existsInList(name, 
                  "abstract", "activeOnly", "check-system-version", "check-valueset-version", "context", "contextDirection", "count", "date", "default-valueset-version", "designation", "displayLanguage", "exclude-system", "excludeNested",
                  "excludeNotForUI", "excludePostCoordinated", "filter", "filterProperty", "force-system-version", "force-valueset-version", "includeDefinition", "includeDesignations", "inferSystem", "lenient-display-validation", 
                  "manifest", "offset", "property", "system-version", "useSupplement", "valueset-membership-only"), 
                  I18nConstants.VALUESET_PARAMETER_UNRECOGNISED_BINDING_PARAMETER, name, vs.getVersionedUrl());
            }
          }
        }
      }
    }
    for (QuestionnaireDerivation qd : derivations) {
      ok = validateQuestionnaireElementDerivation(errors, ns, questionnaire, item, qd) && ok;            
    }
    return ok;
  }

  private Element findBindingParameter(List<Element> list, String n) {
    for (Element ext : list) {
      String name = ext.getExtensionString("name");
      if (n.equals(name)) {
        return ext;
      }
    }
    return null;
  }

  private boolean validateQuestionnaireElementDerivation(List<ValidationMessage> errors, NodeStack ns, Element questionnaire, Element item, QuestionnaireDerivation derivation) {
    boolean ok = true;
    String linkId = item.getNamedChildValue("linkId", false);
    QuestionnaireItemComponent qi = derivation.questionnaire.getQuestion(linkId);
    if (qi == null) {
      ok = rule(errors, "2023-06-15", IssueType.NOTFOUND, ns.getLiteralPath(), derivation.mode == QuestionnaireDerivationMode.EXTENDS, I18nConstants.QUESTIONNAIRE_Q_ITEM_NOT_DERIVED, derivation.questionnaire.getUrl(), linkId) && ok;
    } else {
      // things to check:

      // type must be the same
      if (qi.hasType()) {
        Element e = item.getNamedChild("type", false);
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          String myType = qi.getType().toCode();
          if (qi.getTypeElement().hasExtension(ExtensionDefinitions.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL)) {
            myType = qi.getTypeElement().getExtensionString(ExtensionDefinitions.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL);
          }
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, myType.equals(e.primitiveValue()), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_TYPE, derivation.questionnaire.getUrl(), linkId, qi.getType().toCode(), e.primitiveValue()) && ok;
        }
      }

      // if it doesn't repeat, it can't start repeating
      if (!qi.getRepeats()) {
        Element e = item.getNamedChild("repeats", false);
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, !"true".equals(e.primitiveValue()), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_REPEATS, derivation.questionnaire.getUrl(), linkId) && ok;
        }        
      }
      
      // if it is required, it can't become un-required
      if (qi.getRequired()) {
        Element e = item.getNamedChild("required", false);
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, "true".equals(e.primitiveValue()), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_REQUIRED, derivation.questionnaire.getUrl(), linkId) && ok;
        }        
      }

      // if it has a definition, it shouldn't change
      if (qi.hasDefinition()) {
        Element e = item.getNamedChild("definition", false);
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          hint(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, "true".equals(e.primitiveValue()), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_DEFINITION, derivation.questionnaire.getUrl(), linkId, qi.getDefinition());
        } else {
          hint(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, false, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_DEFINITION, derivation.questionnaire.getUrl(), linkId, qi.getDefinition());          
        }
      }

      // if it has maxLength, that can't get longer
      if (qi.hasMaxLength()) {
        Element e = item.getNamedChild("maxLength", false);
        if (e != null) {
          NodeStack ne = ns.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
          int ml = Utilities.parseInt(e.primitiveValue(), 0);
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ne, ml <= qi.getMaxLength(), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_MAXLENGTH, derivation.questionnaire.getUrl(), linkId, qi.getMaxLength()) && ok;
        } else {
          ok = rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, false, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_MAXLENGTH, derivation.questionnaire.getUrl(), linkId, qi.getMaxLength()) & ok;          
        }
      }

      if (qi.hasAnswerOption()) {
        Element e = item.getNamedChild("answerValueSet", false);
        if (rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, e == null, I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_NC_ANSWER_TYPE, derivation.questionnaire.getUrl(), linkId, "Option", "ValueSet")) {
          // for each answer option here, there must be a matching answer option in the source
          List<Element> list = new ArrayList<>();
          item.getNamedChildren("answerOption", list);
          if (rule(errors, "2023-06-15", IssueType.BUSINESSRULE, ns, !list.isEmpty(), I18nConstants.QUESTIONNAIRE_Q_ITEM_DERIVED_ANSWER_OPTIONS, derivation.questionnaire.getUrl(), linkId, qi.getAnswerOption().size())) {
            for (int i = 0; i < list.size(); i++) {
              Element ao = list.get(i);
              NodeStack nao = ns.push(ao, i, ao.getProperty().getDefinition(), ao.getProperty().getDefinition());
              Element v = ao.getNamedChild("value", false);
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
                  aok = findAOCoding(qi.getAnswerOption(), new Coding().setSystem(v.getNamedChildValue("system", false)).setVersion(v.getNamedChildValue("version", false)).setCode(v.getNamedChildValue("code", false)));
                  break;
                case "Reference": 
                  aok = findAOReference(qi.getAnswerOption(), new Reference().setReference(v.getNamedChildValue("reference", false)));
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
        Element e = item.getNamedChild("answerOption", false);
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
      String v = item.getNamedChildValue("linkId", false);
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

  public boolean validateQuestionannaireResponse(ValidationContext hostContext, List<ValidationMessage> errors, Element element, NodeStack stack) throws FHIRException {
    if (questionnaireMode == QuestionnaireMode.NONE) {
      return true;
    }
    boolean ok = true;
    Element q = element.getNamedChild("questionnaire", false);
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
        boolean notCompleted = !Utilities.existsInList(element.getNamedChildValue("status", false), "completed", "amended");
        ok = checkAuthoringDate(errors,  stack, element, qsrc.q) && ok;
        ok = validateQuestionannaireResponseItems(hostContext, qsrc, qsrc.q().getItem(), errors, element, stack, notCompleted, element, new QStack(qsrc, element)) && ok;
      }
    }
    return ok;
  }

  private boolean checkAuthoringDate(List<ValidationMessage> errors, NodeStack stack, Element element, Questionnaire q) {
    boolean ok = true;
    if ((q.hasEffectivePeriod()) && element.hasChild("authored")) {
      NodeStack vns = stack.push(element.getNamedChild("authored"), -1, null, null);
      DateTimeType vdt = new DateTimeType(element.getNamedChildValue("authored"));
      
      if (q.getEffectivePeriod().hasEnd()) {
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, vns, !vdt.after(q.getEffectivePeriod().getEndElement()), I18nConstants.QUESTIONNAIRE_QR_AUTHOR_END, vdt.toHumanDisplay(), q.getEffectivePeriod().getEndElement().toHumanDisplay());
      }
      if (q.getEffectivePeriod().hasStart()) {
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, vns, !vdt.before(q.getEffectivePeriod().getStartElement()), I18nConstants.QUESTIONNAIRE_QR_AUTHOR_START, vdt.toHumanDisplay(), q.getEffectivePeriod().getStartElement().toHumanDisplay());
      }
      
    } 
    return ok;
    
  }

  private boolean validateQuestionnaireResponseItem(ValidationContext hostContext, QuestionnaireWithContext qsrc, QuestionnaireItemComponent qItem, List<ValidationMessage> errors, Element element, NodeStack stack, boolean notCompleted, Element questionnaireResponseRoot, QStack qstack) {
    BooleanHolder ok = new BooleanHolder();
    
    String text = element.getNamedChildValue("text", false);
    ok.see(rule(errors, NO_RULE_DATE, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), Utilities.noString(text) || text.equals(qItem.getText()), I18nConstants.QUESTIONNAIRE_QR_ITEM_TEXT, qItem.getLinkId()));

    List<Element> answers = new ArrayList<Element>();
    element.getNamedChildren("answer", answers);
    if (notCompleted)
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

    if (qItem.hasExtension(ExtensionDefinitions.EXT_MAXOCCURS)) {
      int mo = ExtensionUtilities.readIntegerExtension(qItem, ExtensionDefinitions.EXT_MAXOCCURS, -1);
      ok.see(rule(errors, NO_RULE_DATE, IssueType.INVALID, stack, mo < 0 || answers.size() < mo, I18nConstants.QUESTIONNAIRE_QR_ITEM_MAX_OCCURS, mo, answers.size()));      
    }
    if (qItem.hasExtension(ExtensionDefinitions.EXT_MINOCCURS)) {
      int mo = ExtensionUtilities.readIntegerExtension(qItem, ExtensionDefinitions.EXT_MINOCCURS, -1);
      ok.see(rule(errors, NO_RULE_DATE, IssueType.INVALID, stack, mo < 0 || answers.size() > mo, I18nConstants.QUESTIONNAIRE_QR_ITEM_MIN_OCCURS, mo, answers.size()));      
    }
    
    int i = 0;
    for (Element answer : answers) {
      NodeStack ns = stack.push(answer, i, null, null);
      if (qItem.getType() != null) {
        switch (qItem.getType()) {
          case GROUP:
            ok.see(rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, answer.line(), answer.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_GROUP, VersionUtilities.isR5Plus(context.getVersion()) ? "group" : "question"));
            break;
          case DISPLAY:  // nothing
            ok.see(rule(errors, "2024-05-07", IssueType.STRUCTURE, answer.line(), answer.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DISPLAY_NO_VALUE, VersionUtilities.isR5Plus(context.getVersion()) ? "group" : "question"));
            break;
          case BOOLEAN:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "boolean");
            break;
          case DECIMAL:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "decimal");
            ok.see(validateQuestionnaireResponseItemDecimal(errors, answer, ns, qItem));
            break;
          case INTEGER:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "integer");
            ok.see(validateQuestionnaireResponseItemInteger(errors, answer, ns, qItem));
            break;
          case DATE:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "date");
            ok.see(validateQuestionnaireResponseItemDate(errors, answer, ns, qItem));
            break;
          case DATETIME:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "dateTime");
            ok.see(validateQuestionnaireResponseItemDateTime(errors, answer, ns, qItem));
            break;
          case TIME:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "time");
            ok.see(validateQuestionnaireResponseItemTime(errors, answer, ns, qItem));
            break;
          case STRING:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "string");
            ok.see(validateQuestionnaireResponseItemString(errors, answer, ns, qItem));
            break;
          case TEXT:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "text");
            break;
          case URL:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "uri");
            break;
          case ATTACHMENT:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "Attachment");
            ok.see(validateQuestionnaireResponseItemAttachment(errors, answer, ns, qItem));
            break;
          case REFERENCE:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "Reference");
            ok.see(validateQuestionnaireResponseItemReference(errors, answer, ns, qItem));
            break;
          case QUANTITY:
            validateQuestionnaireResponseItemType(errors, answer, ns, ok, "Quantity");
            ok.see(validateQuestionnaireResponseItemQuantity(errors, answer, ns, qItem));
            break;
          case CODING:
            String itemType = validateQuestionnaireResponseItemType(errors, answer, ns, ok, "Coding", "date", "time", "integer", "string");
            if (itemType != null) {
              if (itemType.equals("Coding")) validateAnswerCode(errors, answer, ns, qsrc, qItem, false, answers.size());
              else if (itemType.equals("date")) checkOption(errors, answer, ns, qsrc, qItem, "date", answers.size());
              else if (itemType.equals("time")) checkOption(errors, answer, ns, qsrc, qItem, "time", answers.size());
              else if (itemType.equals("integer"))
                ok.see(checkOption(errors, answer, ns, qsrc, qItem, "integer", answers.size()));
              else if (itemType.equals("string")) checkOption(errors, answer, ns, qsrc, qItem, "string", answers.size());
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
        ok.see(validateQuestionannaireResponseItems(hostContext, qsrc, qItem.getItem(), errors, answer, stack, notCompleted, questionnaireResponseRoot, qstack));
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
      List<Element> items = new ArrayList<Element>();
      element.getNamedChildren("item", items);
      ok.see(rule(errors, "2025-05-07", IssueType.INVARIANT, stack, !qItem.getRequired() || items.size() > 0, I18nConstants.QUESTIONNAIRE_QR_ITEM_GROUP_REQUIRED));
      ok.see(validateQuestionannaireResponseItems(hostContext, qsrc, qItem.getItem(), errors, element, stack, notCompleted, questionnaireResponseRoot, qstack));
    }
    return ok.ok();
  }



  private boolean isAnswerRequirementFulfilled(QuestionnaireItemComponent qItem, List<Element> answers) {
    return !answers.isEmpty() || !qItem.getRequired() || qItem.getType() == QuestionnaireItemType.GROUP;
  }

  private boolean validateQuestionnaireResponseItem(ValidationContext hostcontext, QuestionnaireWithContext qsrc, QuestionnaireItemComponent qItem, List<ValidationMessage> errors, List<ElementWithIndex> elements, NodeStack stack, boolean notCompleted, Element questionnaireResponseRoot, QStack qstack) {
    boolean ok = true;
    if (elements.size() > 1) {
      ok = rulePlural(errors, NO_RULE_DATE, IssueType.INVALID, elements.get(1).getElement().line(), elements.get(1).getElement().col(), stack.getLiteralPath(), qItem.getRepeats(), elements.size(), I18nConstants.QUESTIONNAIRE_QR_ITEM_ONLYONEI, qItem.getLinkId()) && ok;
    }
    for (ElementWithIndex element : elements) {
      NodeStack ns = stack.push(element.getElement(), element.getIndex(), null, null);
      ok = validateQuestionnaireResponseItem(hostcontext, qsrc, qItem, errors, element.getElement(), ns, notCompleted, questionnaireResponseRoot, qstack.push(qItem, element.getElement())) && ok;
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

  private boolean validateQuestionannaireResponseItems(ValidationContext hostContext, QuestionnaireWithContext qsrc, List<QuestionnaireItemComponent> qItems, List<ValidationMessage> errors, Element element, NodeStack stack, boolean notCompleted, Element questionnaireResponseRoot, QStack qstack) {
    boolean ok = true;
    List<Element> items = new ArrayList<Element>();
    element.getNamedChildren("item", items);
    // now, sort into stacks
    Map<String, List<ElementWithIndex>> map = new HashMap<String, List<ElementWithIndex>>();
    int lastIndex = -1;
    int counter = 0;
    for (Element item : items) {
      String linkId = item.getNamedChildValue("linkId", false);
      if (rule(errors, NO_RULE_DATE, IssueType.REQUIRED, item.line(), item.col(), stack.getLiteralPath(), !Utilities.noString(linkId), I18nConstants.QUESTIONNAIRE_QR_ITEM_NOLINKID)) {
        int index = getLinkIdIndex(qItems, linkId);
        if (index == -1) {
          QuestionnaireItemComponent qItem = findQuestionnaireItem(qsrc, linkId);
          if (qItem != null) {
            ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, item.line(), item.col(), stack.getLiteralPath(), index > -1, misplacedItemError(qItem)) && ok;
            NodeStack ns = stack.push(item, counter, null, null);
            ok = validateQuestionnaireResponseItem(hostContext, qsrc, qItem, errors, item, ns, notCompleted, questionnaireResponseRoot, qstack.push(qItem, item)) && ok;
          } else
            ok = rule(errors, NO_RULE_DATE, IssueType.NOTFOUND, item.line(), item.col(), stack.getLiteralPath(), index > -1, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTFOUND, linkId) && ok;
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, item.line(), item.col(), stack.getLiteralPath(), index >= lastIndex, I18nConstants.QUESTIONNAIRE_QR_ITEM_ORDER) && ok;
          lastIndex = index;

          List<ElementWithIndex> mapItem = map.computeIfAbsent(linkId, key -> new ArrayList<>());
          mapItem.add(new ElementWithIndex(item, counter));
        }
      } else {
        ok = false;
      }
      counter++;
    }

    // ok, now we have a list of known items, grouped by linkId. We've made an error for anything out of order
    for (QuestionnaireItemComponent qItem : qItems) {
      List<ElementWithIndex> mapItem = map.get(qItem.getLinkId());
      ok = validateQuestionnaireResponseItem(hostContext, qsrc, errors, element, stack, notCompleted, questionnaireResponseRoot, qItem, mapItem, qstack) && ok;
    }
    return ok;
  }

  public boolean validateQuestionnaireResponseItem(ValidationContext hostContext, QuestionnaireWithContext qsrc, List<ValidationMessage> errors, Element element, NodeStack stack, boolean notCompleted, Element questionnaireResponseRoot, QuestionnaireItemComponent qItem, List<ElementWithIndex> mapItem, QStack qstack) {
    boolean ok = true;
    boolean enabled = myEnableWhenEvaluator.isQuestionEnabled(hostContext, qItem, qstack, fpe);
    if (mapItem != null) {
      if (!enabled) {
        for (ElementWithIndex e : mapItem) {
          // If an item has a child called "linkId" but no child called "answer",
          // we'll treat it as not existing for the purposes of enableWhen validation
          if (e.element.hasChildren("answer") || e.element.hasChildren("item")) {
            NodeStack ns = stack.push(e.getElement(), e.getElement().getIndex(), e.getElement().getProperty().getDefinition(), e.getElement().getProperty().getDefinition());
            ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.getElement().line(), e.getElement().col(), ns.getLiteralPath(), enabled, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTENABLED2, qItem.getLinkId()) && ok;
          }
        }
      }

      // Recursively validate child items
      ok = validateQuestionnaireResponseItem(hostContext, qsrc, qItem, errors, mapItem, stack, notCompleted, questionnaireResponseRoot, qstack) && ok;

    } else {

      // item is missing, is the question enabled?
      if (enabled && qItem.getRequired()) {
        String message = context.formatMessage(I18nConstants.QUESTIONNAIRE_QR_ITEM_MISSING, qItem.getLinkId());
        if (notCompleted) {
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

  private boolean validateQuestionnaireResponseItemAttachment(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    if (answer.hasChild("value")) {
      Element value = answer.getNamedChild("value");
      if (qItem.hasExtension(ExtensionDefinitions.EXT_MIMETYPE)) {
        String mimeType = value.getNamedChildValue("contentType");
        if (mimeType == null) {
          ok = rule(errors, "2024-05-07", IssueType.REQUIRED, ns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOT_ATTACHMENT_MIMETYPE) && ok;        
        } else {
          boolean mtok = false;
          List<String> allowed = new ArrayList<String>();
          for (Extension ex : qItem.getExtensionsByUrl(ExtensionDefinitions.EXT_MIMETYPE)) {
            if (ex.hasValue()) {
              allowed.add(ex.getValue().primitiveValue());
              if (mimeTypeMatches(mimeType, ex.getValue().primitiveValue())) {
                mtok = true;
              }
            }
          }
          ok = rule(errors, "2024-05-07", IssueType.REQUIRED, ns, mtok, I18nConstants.QUESTIONNAIRE_QR_ITEM_BAD_ATTACHMENT_MIMETYPE, mimeType, CommaSeparatedStringBuilder.join(", ", allowed)) && ok;
        }      
      }    
      if (qItem.hasExtension(ExtensionDefinitions.EXT_MAX_SIZE) && value.hasChild("data")) {
        int max = ExtensionUtilities.readIntegerExtension(qItem, ExtensionDefinitions.EXT_MAX_SIZE, -1);
        if (max > 0) {
          String b64 = value.getNamedChildValue("data");
          byte[] cnt = java.util.Base64.getMimeDecoder().decode(b64);
          ok = rule(errors, "2024-05-07", IssueType.REQUIRED, ns, cnt.length < max, I18nConstants.QUESTIONNAIRE_QR_ITEM_BAD_ATTACHMENT_LENGTH, max, cnt.length) && ok;
        }
      }
    }
    return ok;
  }

  private boolean mimeTypeMatches(String mimeType, String pattern) {    
    return mimeType.startsWith(pattern);
  }

  private boolean validateQuestionnaireResponseItemDate(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    Element v = answer.getNamedChild("value");
    if (v != null) {
      NodeStack vns = ns.push(v, -1, null, null);
      try {
        DateTimeType vdt = new DateTimeType(v.primitiveValue()); 
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MINVALUE)) {
          DateTimeType dt = new DateTimeType(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MINVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, !dt.after(vdt), I18nConstants.QUESTIONNAIRE_QR_ITEM_DATE_MIN, v.primitiveValue(), dt.primitiveValue()) && ok;
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MAXVALUE)) {
          DateTimeType dt = new DateTimeType(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MAXVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, !dt.before(vdt), I18nConstants.QUESTIONNAIRE_QR_ITEM_DATE_MAX, v.primitiveValue(), dt.primitiveValue()) && ok;
        }
      } catch (Exception e) {
        ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DATE_VALUE_EXCEPTION, e.getMessage()) && ok;
      }
      if (qItem.getAnswerOption().size() > 0) {
        List<DateType> list = new ArrayList<DateType>();
        for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
          try {
            list.add(components.getValueDateType());
          } catch (FHIRException e) {
            // If it's the wrong type, just keep going
          }
        }
        if (list.isEmpty()) {
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSDATE) && ok;
        } else {
          boolean found = false;
          for (DateType item : list) {
            if (item.primitiveValue().equals(v.primitiveValue())) {
              found = true;
              break;
            }
          }
          if (!found) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NODATE, v.primitiveValue()) && ok;
          }
        }
      } else {
      }
    }
    return ok;
  }

  private boolean validateQuestionnaireResponseItemTime(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    Element v = answer.getNamedChild("value");
    if (v != null) {
      NodeStack vns = ns.push(v, -1, null, null);
      try {
        TimeType vdt = new TimeType(v.primitiveValue()); 
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MINVALUE)) {
          TimeType dt = new TimeType(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MINVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, vdt.primitiveValue().compareTo(dt.primitiveValue()) >= 0, I18nConstants.QUESTIONNAIRE_QR_ITEM_TIME_MIN, v.primitiveValue(), dt.primitiveValue()) && ok;
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MAXVALUE)) {
          TimeType dt = new TimeType(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MAXVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, vdt.primitiveValue().compareTo(dt.primitiveValue()) <= 0, I18nConstants.QUESTIONNAIRE_QR_ITEM_TIME_MAX, v.primitiveValue(), dt.primitiveValue()) && ok;
        }
      } catch (Exception e) {
        ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_TIME_VALUE_EXCEPTION, e.getMessage()) && ok;
      }
      if (qItem.getAnswerOption().size() > 0) {
        List<TimeType> list = new ArrayList<TimeType>();
        for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
          try {
            list.add(components.getValueTimeType());
          } catch (FHIRException e) {
            // If it's the wrong type, just keep going
          }
        }
        if (list.isEmpty()) {
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSTIME) && ok;
        } else {
          boolean found = false;
          for (TimeType item : list) {
            if (item.primitiveValue().equals(v.primitiveValue())) {
              found = true;
              break;
            }
          }
          if (!found) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTIME, v.primitiveValue()) && ok;
          }
        }
      } else {
      }
    }
    return ok;
  }

  private boolean validateQuestionnaireResponseItemDateTime(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    Element v = answer.getNamedChild("value");
    if (v != null) {
      NodeStack vns = ns.push(v, -1, null, null);
      try {
        DateTimeType vdt = new DateTimeType(v.primitiveValue()); 
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MINVALUE)) {
          DateTimeType dt = new DateTimeType(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MINVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, !dt.after(vdt), I18nConstants.QUESTIONNAIRE_QR_ITEM_DATE_MIN, v.primitiveValue(), dt.primitiveValue()) && ok;
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MAXVALUE)) {
          DateTimeType dt = new DateTimeType(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MAXVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, !dt.before(vdt), I18nConstants.QUESTIONNAIRE_QR_ITEM_DATE_MAX, v.primitiveValue(), dt.primitiveValue()) && ok;
        }
      } catch (Exception e) {
        ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DATE_VALUE_EXCEPTION, e.getMessage()) && ok;
      }
      if (qItem.getAnswerOption().size() > 0) {
        List<DateTimeType> list = new ArrayList<DateTimeType>();
        for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
          try {
            list.add(new DateTimeType(components.getValueDateType().primitiveValue()));
          } catch (FHIRException e) {
            // If it's the wrong type, just keep going
          }
        }
        if (list.isEmpty()) {
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSDATE) && ok;
        } else {
          boolean found = false;
          for (DateTimeType item : list) {
            if (item.primitiveValue().equals(v.primitiveValue())) {
              found = true;
              break;
            }
          }
          if (!found) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NODATE, v.primitiveValue()) && ok;
          }
        }
      } else {
      }
    }
    return ok;
  }

  private boolean validateQuestionnaireResponseItemString(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    Element v = answer.getNamedChild("value");
    if (v != null) {
      NodeStack vns = ns.push(v, -1, null, null);
      if (v.primitiveValue() != null) {
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MIN_LENGTH) ) {
          int ml = ExtensionUtilities.readIntegerExtension(qItem, ExtensionDefinitions.EXT_MIN_LENGTH, -1);
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, ml < 0 || v.primitiveValue().length() >= ml, I18nConstants.QUESTIONNAIRE_QR_ITEM_STRING_MIN_LENGTH, v.primitiveValue(), ml) && ok;        
        }
        if (qItem.hasMaxLength()) {
          int ml = qItem.getMaxLength();
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, ml < 0 || v.primitiveValue().length() <= ml, I18nConstants.QUESTIONNAIRE_QR_ITEM_STRING_MAX_LENGTH, v.primitiveValue(), ml) && ok;                
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_REGEX) ) {
          String regex = ExtensionUtilities.readStringExtension(qItem, ExtensionDefinitions.EXT_REGEX);
          String ef = ExtensionUtilities.readStringExtension(qItem, ExtensionDefinitions.EXT_ENTRY_FORMAT);
          if (ef == null) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, v.primitiveValue().matches(regex), I18nConstants.QUESTIONNAIRE_QR_ITEM_STRING_REGEX, v.primitiveValue(), regex) && ok;
          } else {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, v.primitiveValue().matches(regex), I18nConstants.QUESTIONNAIRE_QR_ITEM_STRING_REGEX_EF, v.primitiveValue(), regex, ef) && ok;                   
          }
        }
        warning(errors, "2024-05-07", IssueType.INVARIANT, vns, !(v.primitiveValue().contains("\r") || v.primitiveValue().contains("\n")), I18nConstants.QUESTIONNAIRE_QR_ITEM_STRING_ILLEGAL_CHARS, v.primitiveValue());
        if (qItem.hasAnswerValueSet()) {

          ValueSet vs = context.findTxResource(ValueSet.class, qItem.getAnswerValueSet());
          if (vs == null) {
            warning(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_VS_BAD, qItem.getAnswerValueSet()); 
          } else {
            ValidationResult vr = context.validateCode(settings, v.primitiveValue(), vs);
            if (!vr.isOk()) {
              ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_VS_FAIL, v.primitiveValue(), qItem.getAnswerValueSet()) && ok;                
            }
          }
        }
        if (qItem.getAnswerOption().size() > 0) {
          List<StringType> list = new ArrayList<StringType>();
          for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
            try {
              list.add(components.getValueStringType());
            } catch (FHIRException e) {
              // If it's the wrong type, just keep going
            }
          }
          if (list.isEmpty()) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSSTRING) && ok;
          } else {
            boolean found = false;
            for (StringType item : list) {
              if (item.primitiveValue().equals(v.primitiveValue())) {
                found = true;
                break;
              }
            }
            if (!found) {
              ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOSTRING, v.primitiveValue()) && ok;
            }
          }
        } else {
        }
      }
    }
    return ok;
  }

  private boolean validateQuestionnaireResponseItemDecimal(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    Element v = answer.getNamedChild("value");
    if (v != null && v.fhirType().equals("decimal")) {
      NodeStack vns = ns.push(v, -1, null, null);
      try {
        DecimalType vdt = new DecimalType(v.primitiveValue()); 
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MINVALUE)) {
          DecimalType dt = new DecimalType(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MINVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, dt.compareTo(vdt) <= 0, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_MIN, v.primitiveValue(), dt.primitiveValue()) && ok;
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MAXVALUE)) {
          DecimalType dt = new DecimalType(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MAXVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, dt.compareTo(vdt) >= 0, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_MAX, v.primitiveValue(), dt.primitiveValue()) && ok;
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MAX_DECIMALS)) {
          int dt = Integer.parseInt(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MAX_DECIMALS).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, precision(vdt.primitiveValue()) <= dt, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_MAX_DECIMALS, v.primitiveValue(), dt) && ok;
        }
      } catch (Exception e) {
        ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_VALUE_EXCEPTION, e.getMessage()) && ok;
      }
      if (qItem.getAnswerOption().size() > 0) {
        List<DecimalType> list = new ArrayList<DecimalType>();
        for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
          try {
            list.add(new DecimalType(components.getValue().primitiveValue()));
          } catch (FHIRException e) {
            // If it's the wrong type, just keep going
          }
        }
        if (list.isEmpty()) {
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSDECIMAL) && ok;
        } else {
          boolean found = false;
          for (DecimalType item : list) {
            if (item.primitiveValue().equals(v.primitiveValue())) {
              found = true;
              break;
            }
          }
          if (!found) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NODECIMAL, v.primitiveValue()) && ok;
          }
        }
      } else {
      }
    }
    return ok;
  }

  private boolean checkUcumQuantity(List<ValidationMessage> errors, NodeStack vns, Quantity vdt, Quantity dt, boolean isMin) throws UcumException {
    UcumService ucum = context.getUcumService();
    Pair vp = new Pair(new Decimal(vdt.getValue().toPlainString()), vdt.getCode());
    Pair dp = new Pair(new Decimal(dt.getValue().toPlainString()), dt.getCode());
    vp = ucum.getCanonicalForm(vp);
    dp = ucum.getCanonicalForm(dp);

    if (dp.getCode().equals(vp.getCode())) {
      final boolean thePass = isMin ? vp.getValue().comparesTo(dp.getValue()) >= 0 : vp.getValue().comparesTo(dp.getValue()) <= 0;
      final String quantityErrorKey = isMin ? I18nConstants.QUESTIONNAIRE_QR_ITEM_QUANTITY_MIN : I18nConstants.QUESTIONNAIRE_QR_ITEM_QUANTITY_MAX;
      return rule(errors, "2024-05-07", IssueType.INVARIANT, vns, thePass, quantityErrorKey, genDisplay(vdt), genDisplay(dt));
    } else {
      final String cannotCompareErrorKey = isMin ? I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_CANNOT_COMPARE_MIN : I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_CANNOT_COMPARE_MAX;
      return  rule(errors, "2024-05-07", IssueType.INVARIANT, vns,  false, cannotCompareErrorKey, genDisplay(dt), genDisplay(vdt));
    }
  }

  private boolean validateQuestionnaireResponseItemQuantity(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    Element v = answer.getNamedChild("value");
    if (v != null && v.fhirType().equals("Quantity")) {
      NodeStack vns = ns.push(v, -1, null, null);
      try {
        Quantity vdt = new Quantity();
        vdt.setValueElement(new DecimalType(v.getNamedChildValue("value")));
        vdt.setUnit(v.getNamedChildValue("unit"));
        vdt.setSystem(v.getNamedChildValue("system"));
        vdt.setCode(v.getNamedChildValue("code"));
        if (v.hasChild("comparator")) {
          vdt.setComparator(QuantityComparator.valueOf(v.getNamedChildValue("comparator")));
        }

        
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MIN_QUANTITY)) {
          Quantity dt = qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MIN_QUANTITY).getValueQuantity();
          if (!dt.hasSystem() || !dt.hasCode() || !vdt.hasSystem() || !vdt.hasCode()) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns,  false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_CANNOT_COMPARE_MIN_UNITS, genDisplay(dt), genDisplay(vdt)) && ok;            
          } else if (dt.getSystem().equals(vdt.getSystem()) &&  dt.getCode().equals(vdt.getCode())) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, dt.getValue().compareTo(vdt.getValue()) >= 0, I18nConstants.QUESTIONNAIRE_QR_ITEM_QUANTITY_MIN, genDisplay(vdt), genDisplay(dt)) && ok;
          } else if ("http://unitsofmeasure.org".equals(dt.getSystem()) && "http://unitsofmeasure.org".equals(vdt.getSystem())) {
            ok = checkUcumQuantity(errors, vns, vdt, dt, true);
          } else {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns,  false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_CANNOT_COMPARE_MIN, genDisplay(dt), genDisplay(vdt)) && ok;                        
          }
        }
        
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MAX_QUANTITY)) {
          Quantity dt = qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MAX_QUANTITY).getValueQuantity();
          if (!dt.hasSystem() || !dt.hasCode() || !vdt.hasSystem() || !vdt.hasCode()) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns,  false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_CANNOT_COMPARE_MAX_UNITS, genDisplay(dt), genDisplay(vdt)) && ok;            
          } else if (dt.getSystem().equals(vdt.getSystem()) &&  dt.getCode().equals(vdt.getCode())) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, dt.getValue().compareTo(vdt.getValue()) >= 0, I18nConstants.QUESTIONNAIRE_QR_ITEM_QUANTITY_MAX, genDisplay(vdt), genDisplay(dt)) && ok;
          } else if ("http://unitsofmeasure.org".equals(dt.getSystem()) && "http://unitsofmeasure.org".equals(vdt.getSystem())) {
            ok = checkUcumQuantity(errors, vns, vdt, dt, false);
          } else {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns,  false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_CANNOT_COMPARE_MAX, genDisplay(dt), genDisplay(vdt)) && ok;                        
          }
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MAX_DECIMALS)) {
          int dt = Integer.parseInt(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MAX_DECIMALS).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, precision(vdt.getValueElement().primitiveValue()) <= dt, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_MAX_DECIMALS, vdt.getValueElement().primitiveValue(), dt) && ok;
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_Q_UNIT_OPTION)) {
          boolean matched = false;
          List<String> allowed = new ArrayList<>();
          for (Extension ex : qItem.getExtensionsByUrl(ExtensionDefinitions.EXT_Q_UNIT_OPTION)) {
            allowed.add(genDisplay(ex.getValueCoding()));
            matched = matched || matchesUnit(vdt, ex.getValueCoding()); 
          }
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, matched, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_INVALID_UNITS, genDisplay(vdt), CommaSeparatedStringBuilder.join(",", allowed)) && ok;  
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_Q_UNIT_VALUESET)) {
          String url = ExtensionUtilities.readStringExtension(qItem, ExtensionDefinitions.EXT_Q_UNIT_VALUESET);
          ValueSet vs = context.findTxResource(ValueSet.class, url);
          if (vs == null) {
            warning(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_INVALID_UNIT_VS, url); 
          } else {
            ValidationResult vr = context.validateCode(settings, vdt.getSystem(), null, vdt.getCode(), null, vs);
            if (!vr.isOk()) {
              ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_UNIT_FAIL_VS, genDisplay(vdt), url) && ok;                
            }
          }
        }
      } catch (Exception e) {
        ok = rule(errors, "2024-05-07", IssueType.STRUCTURE, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DECIMAL_VALUE_EXCEPTION, e.getMessage()) && ok;
      }
      if (qItem.getAnswerOption().size() > 0) {
        List<DecimalType> list = new ArrayList<DecimalType>();
        for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
          try {
            list.add(new DecimalType(components.getValue().primitiveValue()));
          } catch (FHIRException e) {
            // If it's the wrong type, just keep going
          }
        }
        if (list.isEmpty()) {
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSDECIMAL) && ok;
        } else {
          boolean found = false;
          for (DecimalType item : list) {
            if (item.primitiveValue().equals(v.primitiveValue())) {
              found = true;
              break;
            }
          }
          if (!found) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NODECIMAL, v.primitiveValue()) && ok;
          }
        }
      } else {
      }
    }
    return ok;
  }

  private String genDisplay(Coding c) {
    return (c.hasDisplay() ? c.getDisplay() : "")+(c.hasSystem() || c.hasCode() ? " ("+getSystemName(c.getSystem())+"#"+c.getCode()+")" : "");
  }

  private String genDisplay(Quantity q) {

    return (q.hasComparator() ? q.getComparator().toCode() : "") + q.getValueElement().asStringValue()+(q.hasUnit() ? " "+ q.getUnit() : "")+(q.hasSystem() || q.hasCode() ? " ("+getSystemName(q.getSystem())+"#"+q.getCode()+")" : "");
  }

  public String getSystemName(String system) {
    if (Utilities.noString(system)) {
      return "";
    }
    switch (system) {
    case "http://unitsofmeasure.org": return UCUM_NAME;
    case "http://snomed.info/sct": return SNOMED_NAME;
    }
    return system;
  }
   

  private boolean matchesUnit(Quantity q, Coding c) {    
    return 
        (!c.hasSystem() || c.getSystem().equals(q.getSystem())) &&  
        (!c.hasCode() || c.getCode().equals(q.getCode())) &&  
        (!c.hasDisplay() || c.getDisplay().equals(q.getUnit()));
  }

  private boolean validateQuestionnaireResponseItemInteger(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    Element v = answer.getNamedChild("value");
    if (v != null && v.fhirType().equals("integer")) {
      NodeStack vns = ns.push(v, -1, null, null);
      try {
        int vdt = Integer.parseInt(v.primitiveValue()); 
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MINVALUE)) {
          int dt = Integer.parseInt(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MINVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, vdt >= dt, I18nConstants.QUESTIONNAIRE_QR_ITEM_INTEGER_MIN, vdt, dt) && ok;
        }
        if (qItem.hasExtension(ExtensionDefinitions.EXT_MAXVALUE)) {
          int dt = Integer.parseInt(qItem.getExtensionByUrl(ExtensionDefinitions.EXT_MAXVALUE).getValue().primitiveValue());
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, vdt <= dt, I18nConstants.QUESTIONNAIRE_QR_ITEM_INTEGER_MAX, vdt, dt) && ok;
        }
      } catch (Exception e) {
        ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_INTEGER_VALUE_EXCEPTION, e.getMessage()) && ok;
      }
      if (qItem.getAnswerOption().size() > 0) {
        List<IntegerType> list = new ArrayList<IntegerType>();
        for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
          try {
            list.add(new IntegerType(components.getValue().primitiveValue()));
          } catch (FHIRException e) {
            // If it's the wrong type, just keep going
          }
        }
        if (list.isEmpty()) {
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSINTEGER) && ok;
        } else {
          boolean found = false;
          for (IntegerType item : list) {
            if (item.primitiveValue().equals(v.primitiveValue())) {
              found = true;
              break;
            }
          }
          if (!found) {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOINTEGER, v.primitiveValue()) && ok;
          }
        }
      } else {
      }
    }
    return ok;
  }

  private int precision(String v) {
    if (Utilities.noString(v) || !v.contains(".")) {
      return 0;
    } else {
      return v.length() - v.lastIndexOf(".") - 1;
    }
  }

  private boolean validateQuestionnaireResponseItemReference(List<ValidationMessage> errors, Element answer, NodeStack ns, QuestionnaireItemComponent qItem) {
    boolean ok = true;
    Element v = answer.getNamedChild("value");
    if (v != null && v.fhirType().equals("Reference")) {
      NodeStack vns = ns.push(v, -1, null, null);
      String ref = v.getNamedChildValue("reference");
      if (ref != null && settings.isAssumeValidRestReferences()) {
        String rt = extractResourceType(answer, ref);
        if (qItem.hasExtension(ExtensionDefinitions.EXT_ALLOWEDRESOURCE)) {
          if (rt != null) {
            boolean matched = false;
            List<String> allowed = new ArrayList<>();
            for (Extension ex : qItem.getExtensionsByUrl(ExtensionDefinitions.EXT_ALLOWEDRESOURCE)) {
              allowed.add(ex.getValueCodeType().asStringValue());
              matched = matched || rt.equals(ex.getValueCodeType().asStringValue());
            }
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, matched, I18nConstants.QUESTIONNAIRE_QR_ITEM_REF_INVALID, rt, ref, CommaSeparatedStringBuilder.join(",", allowed)) && ok;
          } else {
            ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, false, I18nConstants.QUESTIONNAIRE_QR_ITEM_REF_CANT, ref) && ok;
          }
        } else {
          ok = rule(errors, "2024-05-07", IssueType.INVARIANT, vns, rt == null || context.getResourceNamesAsSet().contains(rt), I18nConstants.QUESTIONNAIRE_QR_ITEM_REF_INVALID_GENERAL, rt, ref) && ok;          
        }
      }
    }
    return ok;
  }

  private String extractResourceType(Element answer, String ref) {
    if (ref.startsWith("#")) {
      throw new FHIRException("Not handled yet");
    } else {
      return super.extractResourceType(ref);
    }
    
  }

  private String validateQuestionnaireResponseItemType(List<ValidationMessage> errors, Element element, NodeStack stack, BooleanHolder ok, String... types) {
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

      ok.see(rulePlural(errors, "2024-05-07", IssueType.INVARIANT, values.get(0).line(), values.get(0).col(), ns.getLiteralPath(), false, types.length, I18nConstants.QUESTIONNAIRE_QR_ITEM_WRONGTYPE, l.toString(), values.get(0).fhirType()));
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
    if (warning(errors, "2024-05-07", IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), vs != null, I18nConstants.TERMINOLOGY_TX_VALUESET_NOTFOUND, describeReference(ref))) {
      try {
        Coding c = ObjectConverter.readAsCoding(value);
        if (isBlank(c.getCode()) && isBlank(c.getSystem()) && isNotBlank(c.getDisplay())) {
          if (theOpenChoice) {
            return ok;
          }
        }

        if (!noTerminologyChecks) {
          long t = System.nanoTime();
          ValidationContextCarrier vc = makeValidationContext(errors, qSrc);
          ValidationResult res = context.validateCode(new ValidationOptions(FhirPublication.R5, stack.getWorkingLang()), c, vs, vc);
          timeTracker.tx(t, "vc "+c.getSystem()+"#"+c.getCode()+" '"+c.getDisplay()+"'");
          if (!res.isOk()) {
            if (res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
              txWarning(errors, NO_RULE_DATE, res.getTxLink(), res.getDiagnostics(), IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_BADOPTION_CS, c.getSystem(), c.getCode(), vs.present());
            } else {
              ok = txRule(errors, NO_RULE_DATE, res.getTxLink(), res.getDiagnostics(), IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_BADOPTION, c.getSystem(), c.getCode(), vs.present(), res.getMessage()) && ok;
            }
          } else if (res.getSeverity() != null) {
            super.addValidationMessage(errors, NO_RULE_DATE, IssueType.CODEINVALID, value.line(), value.col(), stack.getLiteralPath(), res.getMessage(), res.getSeverity(), Source.TerminologyEngine, null);
          } else if (res.getMessage() != null) {
            super.addValidationMessage(errors, NO_RULE_DATE, IssueType.INFORMATIONAL, value.line(), value.col(), stack.getLiteralPath(), res.getMessage(), res.getSeverity() == null ? IssueSeverity.INFORMATION : res.getSeverity(), Source.TerminologyEngine, null);          
          }
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

  private boolean validateAnswerCode(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean theOpenChoice, int answerCount) {
    Element v = answer.getNamedChild("valueCoding", false);
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0)
      checkCodingOption(errors, answer, stack, qSrc, qItem, theOpenChoice, answerCount);
      //      validateAnswerCode(errors, v, stack, qItem.getOption());
    else if (qItem.hasAnswerValueSet())
      return validateAnswerCode(errors, v, stack, qSrc, qItem.getAnswerValueSet(), theOpenChoice);
    else
      hint(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONS);
    return true;
  }

  private boolean checkOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, String type, int answerCount) {
    return checkOption(errors, answer, stack, qSrc, qItem, type, qItem.getAnswerConstraint() == QuestionnaireAnswerConstraint.OPTIONSORSTRING, answerCount);
  }

  private boolean checkOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, String type, boolean openChoice, int answerCount) {
    if (type.equals("integer")) return checkIntegerOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("date")) return checkDateOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("time")) return checkTimeOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("string")) return checkStringOption(errors, answer, stack, qSrc, qItem, openChoice);
    else if (type.equals("Coding")) return checkCodingOption(errors, answer, stack, qSrc, qItem, openChoice, answerCount);
    return true;
  }

  private boolean checkIntegerOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    Element v = answer.getNamedChild("valueInteger", false);
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
        ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSINTEGER) && ok;
      } else {
        boolean found = false;
        for (IntegerType item : list) {
          if (item.getValue() == Integer.parseInt(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOINTEGER, v.primitiveValue()) && ok;
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_INTNOOPTIONS);
    }
    return ok;
  }

  private boolean checkDateOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    Element v = answer.getNamedChild("valueDate", false);
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
        ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSDATE) && ok;
      } else {
        boolean found = false;
        for (DateType item : list) {
          if (item.getValue().equals(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NODATE, v.primitiveValue()) && ok;
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_DATENOOPTIONS);
    }
    return ok;
  }

  private boolean checkTimeOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    Element v = answer.getNamedChild("valueTime", false);
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
        ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSTIME) && ok;
      } else {
        boolean found = false;
        for (TimeType item : list) {
          if (item.getValue().equals(v.primitiveValue())) {
            found = true;
            break;
          }
        }
        if (!found) {
          ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOTIME, v.primitiveValue()) && ok;
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_TIMENOOPTIONS);
    }
    return ok;
  }

  private boolean checkStringOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice) {
    boolean ok = true;
    Element v = answer.getNamedChild("valueString", false);
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0) {
      boolean found = false;
      boolean empty = true;
      for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
        if (components.getValue() != null && components.hasValueStringType()) {
          empty = false;
          found = found || components.getValue().primitiveValue().equals((v.primitiveValue()));
        }
      }
      if (!openChoice) {
        if (empty) {
          ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSSTRING) && ok;
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOSTRING, v.primitiveValue()) && ok;
        }
      } else {
        found = false;
        for (QuestionnaireItemAnswerOptionComponent components : qItem.getAnswerOption()) {
          if (components.getValue() != null && components.hasValueCoding()) {
            Coding c = components.getValueCoding();
            found = found || (c.hasDisplay() && c.getDisplay().equalsIgnoreCase(v.primitiveValue())) || (c.hasCode() && c.getCode().equalsIgnoreCase(v.primitiveValue()));
          }
        }
        ok = warning(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), !found, I18nConstants.QUESTIONNAIRE_QR_ITEM_STRING_IN_CODING, v.primitiveValue()) && ok;        
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_STRINGNOOPTIONS);
    }
    return ok;
  }

  private boolean checkCodingOption(List<ValidationMessage> errors, Element answer, NodeStack stack, QuestionnaireWithContext qSrc, QuestionnaireItemComponent qItem, boolean openChoice, int answerCount) {
    boolean ok = true;
    
    Element v = answer.getNamedChild("valueCoding", false);
    String system = v.getNamedChildValue("system", false);
    String code = v.getNamedChildValue("code", false);
    List<String> exclusive = new ArrayList<String>();
    NodeStack ns = stack.push(v, -1, null, null);
    if (qItem.getAnswerOption().size() > 0) {
      List<Coding> list = new ArrayList<Coding>();
      for (QuestionnaireItemAnswerOptionComponent component : qItem.getAnswerOption()) {
        try {
          if (component.getValue() != null) {
            if (ExtensionUtilities.readBoolExtension(component, ExtensionDefinitions.EXT_EXCLUSIVE)) {
              exclusive.add(component.getValueCoding().getSystem()+"#+"+component.getValueCoding().getCode());
            }
            list.add(component.getValueCoding());
          }
        } catch (FHIRException e) {
          // If it's the wrong type, just keep going
        }
      }
      if (list.isEmpty() && !openChoice) {
        ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOOPTIONSCODING) && ok;
      } else {
        boolean found = false;
        for (Coding item : list) {
          if (ObjectUtil.equals(item.getSystem(), system) && ObjectUtil.equals(item.getCode(), code)) {
            if (exclusive.contains(item.getSystem()+"#+"+item.getCode())) {
              ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), answerCount == 1, I18nConstants.QUESTIONNAIRE_QR_ITEM_EXCLUSIVE, item.toString()) && ok;
            }
            found = true;
            break;
          }
        }
        if (!found) {
          ok = rule(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), found, I18nConstants.QUESTIONNAIRE_QR_ITEM_NOCODING, system, code) && ok;
        }
      }
    } else {
      hint(errors, NO_RULE_DATE, IssueType.INVARIANT, v.line(), v.col(), stack.getLiteralPath(), false, I18nConstants.QUESTIONNAIRE_QR_ITEM_CODINGNOOPTIONS);
    }
    return ok;
  }


}
