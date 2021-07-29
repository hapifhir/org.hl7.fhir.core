package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Type14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.CodeableConcept14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Coding14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.ContactPoint14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Identifier14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.*;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Reference14_50;
import org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext14_50; 
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireAnswerConstraint;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator;
import org.hl7.fhir.r5.model.UsageContext;

public class Questionnaire14_50 {

    public static org.hl7.fhir.r5.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu2016may.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Questionnaire tgt = new org.hl7.fhir.r5.model.Questionnaire();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier14_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireStatus(src.getStatusElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addContact(convertQuestionnaireContactComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (CodeableConcept14_50.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasTitle())
            tgt.setTitleElement(String14_50.convertString(src.getTitleElement()));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getConcept()) tgt.addCode(Coding14_50.convertCoding(t));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r5.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier14_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireStatus(src.getStatusElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
        for (ContactDetail t : src.getContact()) for (org.hl7.fhir.r5.model.ContactPoint t1 : t.getTelecom()) tgt.addTelecom(ContactPoint14_50.convertContactPoint(t1));
        for (UsageContext t : src.getUseContext()) tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t));
        if (src.hasTitle())
            tgt.setTitleElement(String14_50.convertString(src.getTitleElement()));
        for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addConcept(Coding14_50.convertCoding(t));
        for (CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertQuestionnaireContactComponent(org.hl7.fhir.dstu2016may.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        tgt.addTelecom(ContactPoint14_50.convertContactPoint(src));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(String14_50.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addConcept(Coding14_50.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(String14_50.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(String14_50.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement(), src.getAnswerConstraint()));
        for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        if (src.hasRequired())
            tgt.setRequiredElement(Boolean14_50.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(Boolean14_50.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(Boolean14_50.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(Integer14_50.convertInteger(src.getMaxLengthElement()));
        if (src.hasAnswerValueSetElement())
            tgt.setOptions(Reference14_50.convertCanonicalToReference(src.getAnswerValueSetElement()));
        for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption()) tgt.addOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.setInitial(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getInitialFirstRep().getValue()));
        for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(String14_50.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getConcept()) tgt.addCode(Coding14_50.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(String14_50.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(String14_50.convertStringToMarkdown(src.getTextElement()));
        if (src.hasType()) {
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement()));
            if (src.getType() == QuestionnaireItemType.CHOICE) {
              tgt.setAnswerConstraint(QuestionnaireAnswerConstraint.OPTIONSONLY);
            } else if (src.getType() == QuestionnaireItemType.OPENCHOICE) {
              tgt.setAnswerConstraint(QuestionnaireAnswerConstraint.OPTIONSORSTRING);
            } 
        }
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        if (src.hasRequired())
            tgt.setRequiredElement(Boolean14_50.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(Boolean14_50.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(Boolean14_50.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(Integer14_50.convertInteger(src.getMaxLengthElement()));
        if (src.hasOptions())
            tgt.setAnswerValueSetElement(Reference14_50.convertReferenceToCanonical(src.getOptions()));
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent t : src.getOption()) tgt.addAnswerOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.addInitial().setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getInitial()));
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        if (src.hasQuestionElement())
            tgt.setQuestionElement(String14_50.convertString(src.getQuestionElement()));
        if (src.hasAnswered()) {
            tgt.setOperator(QuestionnaireItemOperator.EXISTS);
            if (src.hasAnsweredElement())
                tgt.setAnswer(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getAnsweredElement()));
        }
        if (src.hasAnswer())
            tgt.setAnswer(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getAnswer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        if (src.hasQuestionElement())
            tgt.setQuestionElement(String14_50.convertString(src.getQuestionElement()));
        if (src.hasOperator() && src.getOperator() == QuestionnaireItemOperator.EXISTS)
            tgt.setAnswered(src.getAnswerBooleanType().getValue());
        else
            tgt.setAnswer(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getAnswer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        tgt.addExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL, new CodeType(src.getValueAsString()));
        switch(src.getValue()) {
            case GROUP:
                tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DISPLAY);
                break;
            case QUESTION:
                tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> src, QuestionnaireAnswerConstraint constraint) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt, VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL);
        if (src.hasExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL)) {
          tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL));
        } else {
          switch(src.getValue()) {
            case GROUP:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DISPLAY);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.BOOLEAN);
                break;
            case DECIMAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DECIMAL);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.INTEGER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DATE);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DATETIME);
                break;
            case TIME:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.TIME);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.STRING);
                break;
            case TEXT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.TEXT);
                break;
            case URL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.URL);
                break;
            case CODING:
              if (constraint == QuestionnaireAnswerConstraint.OPTIONSORSTRING)
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.OPENCHOICE);
              else 
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.CHOICE);
              break;
            case ATTACHMENT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.ATTACHMENT);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.REFERENCE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.QUANTITY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.NULL);
                break;
        }
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertQuestionnaireStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus> convertQuestionnaireStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatusEnumFactory());
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus.PUBLISHED);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus.RETIRED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus.NULL);
                break;
        }
        return tgt;
    }
}