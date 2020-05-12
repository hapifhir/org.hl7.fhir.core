package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class QuestionnaireResponse10_50 {

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent convertQuestionnaireItemToGroup(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent tgt = new org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement(VersionConvertor_10_50.convertString(src.getLinkIdElement()));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) if (t.hasAnswer())
            tgt.addQuestion(convertQuestionnaireItemToQuestion(t));
        else
            tgt.addGroup(convertQuestionnaireItemToGroup(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent convertQuestionnaireItemToQuestion(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent tgt = new org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement(VersionConvertor_10_50.convertString(src.getLinkIdElement()));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r5.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu2.model.QuestionnaireResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        if (src.hasQuestionnaireElement())
            tgt.setQuestionnaire(VersionConvertor_10_50.convertCanonicalToReference(src.getQuestionnaireElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_10_50.convertReference(src.getAuthor()));
        if (src.hasAuthoredElement())
            tgt.setAuthoredElement(VersionConvertor_10_50.convertDateTime(src.getAuthoredElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_10_50.convertReference(src.getSource()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getEncounter()));
        if (src.getItem().size() != 1)
            throw new FHIRException("multiple root items not supported");
        tgt.setGroup(convertQuestionnaireItemToGroup(src.getItem().get(0)));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu2.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.QuestionnaireResponse tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        if (src.hasQuestionnaire())
            tgt.setQuestionnaireElement(VersionConvertor_10_50.convertReferenceToCanonical(src.getQuestionnaire()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_10_50.convertReference(src.getAuthor()));
        if (src.hasAuthoredElement())
            tgt.setAuthoredElement(VersionConvertor_10_50.convertDateTime(src.getAuthoredElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_10_50.convertReference(src.getSource()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getEncounter()));
        if (src.hasGroup())
            tgt.addItem(convertQuestionnaireResponseGroupComponent(src.getGroup()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseGroupComponent(org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement(VersionConvertor_10_50.convertString(src.getLinkIdElement()));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent t : src.getGroup()) tgt.addItem(convertQuestionnaireResponseGroupComponent(t));
        for (org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent t : src.getQuestion()) tgt.addItem(convertQuestionnaireResponseQuestionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent tgt = new org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_50.convertType(src.getValue()));
        for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addGroup(convertQuestionnaireItemToGroup(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_50.convertType(src.getValue()));
        for (org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent t : src.getGroup()) tgt.addItem(convertQuestionnaireResponseGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseQuestionComponent(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement(VersionConvertor_10_50.convertString(src.getLinkIdElement()));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
                break;
        }
        return tgt;
    }
}