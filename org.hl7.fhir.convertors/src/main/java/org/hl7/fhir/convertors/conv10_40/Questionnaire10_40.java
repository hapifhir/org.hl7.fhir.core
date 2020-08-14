package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;

public class Questionnaire10_40 {

    public static org.hl7.fhir.dstu2.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r4.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Questionnaire tgt = new org.hl7.fhir.dstu2.model.Questionnaire();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_40.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireStatus(src.getStatusElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_40.convertString(src.getPublisherElement()));
        for (ContactDetail t : src.getContact()) for (org.hl7.fhir.r4.model.ContactPoint t1 : t.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t1));
        org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent root = tgt.getGroup();
        root.setTitle(src.getTitle());
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) {
            root.addConcept(VersionConvertor_10_40.convertCoding(t));
        }
        for (org.hl7.fhir.r4.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) if (t.getType() == org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP)
            root.addGroup(convertQuestionnaireGroupComponent(t));
        else
            root.addQuestion(convertQuestionnaireQuestionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu2.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire tgt = new org.hl7.fhir.r4.model.Questionnaire();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_40.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireStatus(src.getStatusElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addContact(convertQuestionnaireContactComponent(t));
        org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent root = src.getGroup();
        tgt.setTitle(root.getTitle());
        for (org.hl7.fhir.dstu2.model.Coding t : root.getConcept()) tgt.addCode(VersionConvertor_10_40.convertCoding(t));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        tgt.addItem(convertQuestionnaireGroupComponent(root));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertQuestionnaireContactComponent(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(src));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent convertQuestionnaireGroupComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent tgt = new org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement(VersionConvertor_10_40.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addConcept(VersionConvertor_10_40.convertCoding(t));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_40.convertString(src.getTextElement()));
        if (src.hasRequiredElement())
            tgt.setRequiredElement(VersionConvertor_10_40.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeatsElement())
            tgt.setRepeatsElement(VersionConvertor_10_40.convertBoolean(src.getRepeatsElement()));
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) if (t.getType() == org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP)
            tgt.addGroup(convertQuestionnaireGroupComponent(t));
        else
            tgt.addQuestion(convertQuestionnaireQuestionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireGroupComponent(org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement(VersionConvertor_10_40.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getConcept()) tgt.addCode(VersionConvertor_10_40.convertCoding(t));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_40.convertString(src.getTextElement()));
        tgt.setType(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP);
        if (src.hasRequiredElement())
            tgt.setRequiredElement(VersionConvertor_10_40.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeatsElement())
            tgt.setRepeatsElement(VersionConvertor_10_40.convertBoolean(src.getRepeatsElement()));
        for (org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent t : src.getGroup()) tgt.addItem(convertQuestionnaireGroupComponent(t));
        for (org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent t : src.getQuestion()) tgt.addItem(convertQuestionnaireQuestionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat> convertQuestionnaireItemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormatEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
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
            case CHOICE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.CHOICE);
                break;
            case OPENCHOICE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.OPENCHOICE);
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
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent convertQuestionnaireQuestionComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent tgt = new org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement(VersionConvertor_10_40.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addConcept(VersionConvertor_10_40.convertCoding(t));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_40.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement()));
        if (src.hasRequiredElement())
            tgt.setRequiredElement(VersionConvertor_10_40.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeatsElement())
            tgt.setRepeatsElement(VersionConvertor_10_40.convertBoolean(src.getRepeatsElement()));
        if (src.hasAnswerValueSetElement())
            tgt.setOptions(VersionConvertor_10_40.convertCanonicalToReference(src.getAnswerValueSetElement()));
        for (QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption()) if (t.hasValueCoding())
            try {
                tgt.addOption(VersionConvertor_10_40.convertCoding(t.getValueCoding()));
            } catch (org.hl7.fhir.exceptions.FHIRException e) {
                throw new FHIRException(e);
            }
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addGroup(convertQuestionnaireGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireQuestionComponent(org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement(VersionConvertor_10_40.convertString(src.getLinkIdElement()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getConcept()) tgt.addCode(VersionConvertor_10_40.convertCoding(t));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_40.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setTypeElement(convertQuestionnaireQuestionType(src.getTypeElement()));
        if (src.hasRequiredElement())
            tgt.setRequiredElement(VersionConvertor_10_40.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeatsElement())
            tgt.setRepeatsElement(VersionConvertor_10_40.convertBoolean(src.getRepeatsElement()));
        if (src.hasOptions())
            tgt.setAnswerValueSetElement(VersionConvertor_10_40.convertReferenceToCanonical(src.getOptions()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getOption()) tgt.addAnswerOption().setValue(VersionConvertor_10_40.convertCoding(t));
        for (org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent t : src.getGroup()) tgt.addItem(convertQuestionnaireGroupComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireQuestionType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus> convertQuestionnaireStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> convertQuestionnaireStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.PublicationStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
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