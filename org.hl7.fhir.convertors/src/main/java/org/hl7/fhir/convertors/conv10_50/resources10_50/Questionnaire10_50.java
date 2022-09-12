package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Coding10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.MarkDown10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireAnswerConstraint;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;

public class Questionnaire10_50 {

  public static org.hl7.fhir.r5.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu2.model.Questionnaire src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Questionnaire tgt = new org.hl7.fhir.r5.model.Questionnaire();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireStatus(src.getStatusElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addContact(convertQuestionnaireContactComponent(t));
    org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent root = src.getGroup();
    tgt.setTitle(root.getTitle());
    for (org.hl7.fhir.dstu2.model.Coding t : root.getConcept()) tgt.addCode(Coding10_50.convertCoding(t));
    for (org.hl7.fhir.dstu2.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
    tgt.addItem(convertQuestionnaireGroupComponent(root));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r5.model.Questionnaire src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Questionnaire tgt = new org.hl7.fhir.dstu2.model.Questionnaire();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireStatus(src.getStatusElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
    for (ContactDetail t : src.getContact())
      for (org.hl7.fhir.r5.model.ContactPoint t1 : t.getTelecom())
        tgt.addTelecom(ContactPoint10_50.convertContactPoint(t1));
    org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent root = tgt.getGroup();
    root.setTitle(src.getTitle());
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) {
      root.addConcept(Coding10_50.convertCoding(t));
    }
    for (CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
    for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      if (t.getType() == org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP)
        root.addGroup(convertQuestionnaireGroupComponent(t));
      else
        root.addQuestion(convertQuestionnaireQuestionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactDetail convertQuestionnaireContactComponent(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    tgt.addTelecom(ContactPoint10_50.convertContactPoint(src));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent convertQuestionnaireGroupComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent tgt = new org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLinkIdElement())
      tgt.setLinkIdElement(String10_50.convertString(src.getLinkIdElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addConcept(Coding10_50.convertCoding(t));
    if (src.hasTextElement())
      tgt.setTextElement(String10_50.convertString(src.getTextElement()));
    if (src.hasRequiredElement())
      tgt.setRequiredElement(Boolean10_50.convertBoolean(src.getRequiredElement()));
    if (src.hasRepeatsElement())
      tgt.setRepeatsElement(Boolean10_50.convertBoolean(src.getRepeatsElement()));
    for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      if (t.getType() == org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP)
        tgt.addGroup(convertQuestionnaireGroupComponent(t));
      else
        tgt.addQuestion(convertQuestionnaireQuestionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireGroupComponent(org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLinkIdElement())
      tgt.setLinkIdElement(String10_50.convertString(src.getLinkIdElement()));
    for (org.hl7.fhir.dstu2.model.Coding t : src.getConcept()) tgt.addCode(Coding10_50.convertCoding(t));
    if (src.hasTextElement())
      tgt.setTextElement(MarkDown10_50.convertStringToMarkdown(src.getTextElement()));
    tgt.setType(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP);
    if (src.hasRequiredElement())
      tgt.setRequiredElement(Boolean10_50.convertBoolean(src.getRequiredElement()));
    if (src.hasRepeatsElement())
      tgt.setRepeatsElement(Boolean10_50.convertBoolean(src.getRepeatsElement()));
    for (org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent t : src.getGroup())
      tgt.addItem(convertQuestionnaireGroupComponent(t));
    for (org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent t : src.getQuestion())
      tgt.addItem(convertQuestionnaireQuestionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat> convertQuestionnaireItemType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> src, QuestionnaireAnswerConstraint constraint) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormatEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt, VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL);
    if (src.hasExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL));
    } else {
      switch (src.getValue()) {
        case BOOLEAN:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.BOOLEAN);
          break;
        case DECIMAL:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.DECIMAL);
          break;
        case INTEGER:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.INTEGER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.DATE);
          break;
        case DATETIME:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.DATETIME);
          break;
        case TIME:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.TIME);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.STRING);
          break;
        case TEXT:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.TEXT);
          break;
        case URL:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.URL);
          break;
        case CODING:
          if (constraint == QuestionnaireAnswerConstraint.OPTIONSORSTRING)
            tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.OPENCHOICE);
          else
            tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.CHOICE);
          break;
        case ATTACHMENT:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.ATTACHMENT);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.REFERENCE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.QUANTITY);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent convertQuestionnaireQuestionComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent tgt = new org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLinkIdElement())
      tgt.setLinkIdElement(String10_50.convertString(src.getLinkIdElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addConcept(Coding10_50.convertCoding(t));
    if (src.hasTextElement())
      tgt.setTextElement(String10_50.convertString(src.getTextElement()));
    if (src.hasType())
      tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement(), src.getAnswerConstraint()));
    if (src.hasRequiredElement())
      tgt.setRequiredElement(Boolean10_50.convertBoolean(src.getRequiredElement()));
    if (src.hasRepeatsElement())
      tgt.setRepeatsElement(Boolean10_50.convertBoolean(src.getRepeatsElement()));
    if (src.hasAnswerValueSetElement())
      tgt.setOptions(Reference10_50.convertCanonicalToReference(src.getAnswerValueSetElement()));
    for (QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption())
      if (t.hasValueCoding())
        try {
          tgt.addOption(Coding10_50.convertCoding(t.getValueCoding()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
          throw new FHIRException(e);
        }
    for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      tgt.addGroup(convertQuestionnaireGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireQuestionComponent(org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLinkIdElement())
      tgt.setLinkIdElement(String10_50.convertString(src.getLinkIdElement()));
    for (org.hl7.fhir.dstu2.model.Coding t : src.getConcept()) tgt.addCode(Coding10_50.convertCoding(t));
    if (src.hasTextElement())
      tgt.setTextElement(MarkDown10_50.convertStringToMarkdown(src.getTextElement()));
    if (src.hasType()) {
      tgt.setTypeElement(convertQuestionnaireQuestionType(src.getTypeElement()));
      if (src.getType() == AnswerFormat.CHOICE) {
        tgt.setAnswerConstraint(QuestionnaireAnswerConstraint.OPTIONSONLY);
      } else if (src.getType() == AnswerFormat.OPENCHOICE) {
        tgt.setAnswerConstraint(QuestionnaireAnswerConstraint.OPTIONSORSTRING);
      }
    }
    if (src.hasRequiredElement())
      tgt.setRequiredElement(Boolean10_50.convertBoolean(src.getRequiredElement()));
    if (src.hasRepeatsElement())
      tgt.setRepeatsElement(Boolean10_50.convertBoolean(src.getRepeatsElement()));
    if (src.hasOptions())
      tgt.setAnswerValueSetElement(Reference10_50.convertReferenceToCanonical(src.getOptions()));
    for (org.hl7.fhir.dstu2.model.Coding t : src.getOption())
      tgt.addAnswerOption().setValue(Coding10_50.convertCoding(t));
    for (org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent t : src.getGroup())
      tgt.addItem(convertQuestionnaireGroupComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireQuestionType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    tgt.addExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL, new CodeType(src.getValueAsString()));
    switch (src.getValue()) {
      case BOOLEAN:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.BOOLEAN);
        break;
      case DECIMAL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DECIMAL);
        break;
      case INTEGER:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.INTEGER);
        break;
      case DATE:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DATE);
        break;
      case DATETIME:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DATETIME);
        break;
      case INSTANT:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DATETIME);
        break;
      case TIME:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.TIME);
        break;
      case STRING:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.STRING);
        break;
      case TEXT:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.TEXT);
        break;
      case URL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.URL);
        break;
      case CHOICE:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.CODING);
        break;
      case OPENCHOICE:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.CODING);
        break;
      case ATTACHMENT:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.ATTACHMENT);
        break;
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.REFERENCE);
        break;
      case QUANTITY:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.QUANTITY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus> convertQuestionnaireStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus.PUBLISHED);
        break;
      case RETIRED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus.RETIRED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertQuestionnaireStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
        break;
      case PUBLISHED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.ACTIVE);
        break;
      case RETIRED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.RETIRED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL);
        break;
    }
    return tgt;
  }
}