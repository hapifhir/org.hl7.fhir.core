package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Type14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.CodeableConcept14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Coding14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.ContactPoint14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Identifier14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.*;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Reference14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator;
import org.hl7.fhir.r4.model.UsageContext;

public class Questionnaire14_40 {

    public static org.hl7.fhir.r4.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu2016may.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire tgt = new org.hl7.fhir.r4.model.Questionnaire();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier14_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireStatus(src.getStatusElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addContact(convertQuestionnaireContactComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasTitle())
            tgt.setTitleElement(String14_40.convertString(src.getTitleElement()));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getConcept()) tgt.addCode(Coding14_40.convertCoding(t));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r4.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier14_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireStatus(src.getStatusElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
        for (ContactDetail t : src.getContact()) for (org.hl7.fhir.r4.model.ContactPoint t1 : t.getTelecom()) tgt.addTelecom(ContactPoint14_40.convertContactPoint(t1));
        for (UsageContext t : src.getUseContext()) tgt.addUseContext(CodeableConcept14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept14_40.convertCodeableConcept(t));
        if (src.hasTitle())
            tgt.setTitleElement(String14_40.convertString(src.getTitleElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addConcept(Coding14_40.convertCoding(t));
        for (org.hl7.fhir.r4.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertQuestionnaireContactComponent(org.hl7.fhir.dstu2016may.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        tgt.addTelecom(ContactPoint14_40.convertContactPoint(src));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(String14_40.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getConcept()) tgt.addCode(Coding14_40.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(String14_40.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(String14_40.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement()));
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        if (src.hasRequired())
            tgt.setRequiredElement(Boolean14_40.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(Boolean14_40.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(Boolean14_40.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(Integer14_40.convertInteger(src.getMaxLengthElement()));
        if (src.hasOptions())
            tgt.setAnswerValueSetElement(Reference14_40.convertReferenceToCanonical(src.getOptions()));
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent t : src.getOption()) tgt.addAnswerOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.addInitial().setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getInitial()));
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(String14_40.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addConcept(Coding14_40.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(String14_40.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(String14_40.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement()));
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        if (src.hasRequired())
            tgt.setRequiredElement(Boolean14_40.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(Boolean14_40.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(Boolean14_40.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(Integer14_40.convertInteger(src.getMaxLengthElement()));
        if (src.hasAnswerValueSetElement())
            tgt.setOptions(Reference14_40.convertCanonicalToReference(src.getAnswerValueSetElement()));
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption()) tgt.addOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.setInitial(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getInitialFirstRep().getValue()));
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasQuestionElement())
            tgt.setQuestionElement(String14_40.convertString(src.getQuestionElement()));
        if (src.hasAnswered()) {
            tgt.setOperator(QuestionnaireItemOperator.EXISTS);
            if (src.hasAnsweredElement())
                tgt.setAnswer(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getAnsweredElement()));
        }
        if (src.hasAnswer())
            tgt.setAnswer(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getAnswer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasQuestionElement())
            tgt.setQuestionElement(String14_40.convertString(src.getQuestionElement()));
        if (src.hasOperator() && src.getOperator() == QuestionnaireItemOperator.EXISTS)
            tgt.setAnswered(src.getAnswerBooleanType().getValue());
        else
            tgt.setAnswer(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getAnswer()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case GROUP:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DISPLAY);
                break;
            case QUESTION:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.QUESTION);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.BOOLEAN);
                break;
            case DECIMAL:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DECIMAL);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.INTEGER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DATE);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DATETIME);
                break;
            case INSTANT:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DATETIME);
                break;
            case TIME:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.TIME);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.STRING);
                break;
            case TEXT:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.TEXT);
                break;
            case URL:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.URL);
                break;
            case CHOICE:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.CHOICE);
                break;
            case OPENCHOICE:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.OPENCHOICE);
                break;
            case ATTACHMENT:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.ATTACHMENT);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.REFERENCE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.QUANTITY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case GROUP:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DISPLAY);
                break;
            case QUESTION:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.QUESTION);
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
            case CHOICE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.CHOICE);
                break;
            case OPENCHOICE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.OPENCHOICE);
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
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus> convertQuestionnaireStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatusEnumFactory());
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> convertQuestionnaireStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.PublicationStatusEnumFactory());
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT);
                break;
            case PUBLISHED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.ACTIVE);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.RETIRED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL);
                break;
        }
        return tgt;
    }
}