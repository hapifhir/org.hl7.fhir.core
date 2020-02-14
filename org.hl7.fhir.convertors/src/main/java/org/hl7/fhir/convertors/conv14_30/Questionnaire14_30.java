package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.UsageContext;
import org.hl7.fhir.exceptions.FHIRException;

public class Questionnaire14_30 {

    public static org.hl7.fhir.dstu2016may.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu3.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_30.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_30.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_30.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatus(convertQuestionnaireStatus(src.getStatus()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_30.convertString(src.getPublisherElement()));
        for (ContactDetail t : src.getContact()) for (org.hl7.fhir.dstu3.model.ContactPoint t1 : t.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t1));
        for (UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_14_30.convertString(src.getTitleElement()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addConcept(VersionConvertor_14_30.convertCoding(t));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu2016may.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire tgt = new org.hl7.fhir.dstu3.model.Questionnaire();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_30.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_30.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_30.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatus(convertQuestionnaireStatus(src.getStatus()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addContact(convertQuestionnaireContactComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_14_30.convertString(src.getTitleElement()));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getConcept()) tgt.addCode(VersionConvertor_14_30.convertCoding(t));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertQuestionnaireContactComponent(org.hl7.fhir.dstu2016may.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(src));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(VersionConvertor_14_30.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getConcept()) tgt.addCode(VersionConvertor_14_30.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(VersionConvertor_14_30.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_14_30.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setType(convertQuestionnaireItemType(src.getType()));
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        if (src.hasRequired())
            tgt.setRequiredElement(VersionConvertor_14_30.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(VersionConvertor_14_30.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(VersionConvertor_14_30.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(VersionConvertor_14_30.convertInteger(src.getMaxLengthElement()));
        if (src.hasOptions())
            tgt.setOptions(VersionConvertor_14_30.convertReference(src.getOptions()));
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent t : src.getOption()) tgt.addOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.setInitial(VersionConvertor_14_30.convertType(src.getInitial()));
        for (org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(VersionConvertor_14_30.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addConcept(VersionConvertor_14_30.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(VersionConvertor_14_30.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_14_30.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setType(convertQuestionnaireItemType(src.getType()));
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        if (src.hasRequired())
            tgt.setRequiredElement(VersionConvertor_14_30.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(VersionConvertor_14_30.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(VersionConvertor_14_30.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(VersionConvertor_14_30.convertInteger(src.getMaxLengthElement()));
        if (src.hasOptions())
            tgt.setOptions(VersionConvertor_14_30.convertReference(src.getOptions()));
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent t : src.getOption()) tgt.addOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.setInitial(VersionConvertor_14_30.convertType(src.getInitial()));
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasQuestionElement())
            tgt.setQuestionElement(VersionConvertor_14_30.convertString(src.getQuestionElement()));
        if (src.hasHasAnswer())
            tgt.setAnsweredElement(VersionConvertor_14_30.convertBoolean(src.getHasAnswerElement()));
        if (src.hasAnswer())
            tgt.setAnswer(VersionConvertor_14_30.convertType(src.getAnswer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasQuestionElement())
            tgt.setQuestionElement(VersionConvertor_14_30.convertString(src.getQuestionElement()));
        if (src.hasAnswered())
            tgt.setHasAnswerElement(VersionConvertor_14_30.convertBoolean(src.getAnsweredElement()));
        if (src.hasAnswer())
            tgt.setAnswer(VersionConvertor_14_30.convertType(src.getAnswer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent tgt = new org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_30.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemOptionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_30.convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType convertQuestionnaireItemType(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GROUP:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.GROUP;
            case DISPLAY:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DISPLAY;
            case QUESTION:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.QUESTION;
            case BOOLEAN:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.BOOLEAN;
            case DECIMAL:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DECIMAL;
            case INTEGER:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.INTEGER;
            case DATE:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DATE;
            case DATETIME:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DATETIME;
            case INSTANT:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DATETIME;
            case TIME:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.TIME;
            case STRING:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.STRING;
            case TEXT:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.TEXT;
            case URL:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.URL;
            case CHOICE:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.CHOICE;
            case OPENCHOICE:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.OPENCHOICE;
            case ATTACHMENT:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.ATTACHMENT;
            case REFERENCE:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.REFERENCE;
            case QUANTITY:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.QUANTITY;
            default:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType convertQuestionnaireItemType(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GROUP:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.GROUP;
            case DISPLAY:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DISPLAY;
            case QUESTION:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.QUESTION;
            case BOOLEAN:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.BOOLEAN;
            case DECIMAL:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DECIMAL;
            case INTEGER:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.INTEGER;
            case DATE:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DATE;
            case DATETIME:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.DATETIME;
            case TIME:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.TIME;
            case STRING:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.STRING;
            case TEXT:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.TEXT;
            case URL:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.URL;
            case CHOICE:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.CHOICE;
            case OPENCHOICE:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.OPENCHOICE;
            case ATTACHMENT:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.ATTACHMENT;
            case REFERENCE:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.REFERENCE;
            case QUANTITY:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.QUANTITY;
            default:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireItemType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus convertQuestionnaireStatus(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus.PUBLISHED;
            case RETIRED:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus.RETIRED;
            default:
                return org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus convertQuestionnaireStatus(org.hl7.fhir.dstu2016may.model.Questionnaire.QuestionnaireStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.DRAFT;
            case PUBLISHED:
                return org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.ACTIVE;
            case RETIRED:
                return org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.RETIRED;
            default:
                return org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.NULL;
        }
    }
}
