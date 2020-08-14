package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class QuestionnaireResponse14_30 {

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu3.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_14_30.convertIdentifier(src.getIdentifier()));
        if (src.hasQuestionnaire())
            tgt.setQuestionnaire(VersionConvertor_14_30.convertReference(src.getQuestionnaire()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_14_30.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_14_30.convertReference(src.getContext()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_14_30.convertReference(src.getAuthor()));
        if (src.hasAuthored())
            tgt.setAuthoredElement(VersionConvertor_14_30.convertDateTime(src.getAuthoredElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_14_30.convertReference(src.getSource()));
        for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu3.model.QuestionnaireResponse();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_14_30.convertIdentifier(src.getIdentifier()));
        if (src.hasQuestionnaire())
            tgt.setQuestionnaire(VersionConvertor_14_30.convertReference(src.getQuestionnaire()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_14_30.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_14_30.convertReference(src.getEncounter()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_14_30.convertReference(src.getAuthor()));
        if (src.hasAuthored())
            tgt.setAuthoredElement(VersionConvertor_14_30.convertDateTime(src.getAuthoredElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_14_30.convertReference(src.getSource()));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_30.convertType(src.getValue()));
        for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_30.convertType(src.getValue()));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(VersionConvertor_14_30.convertString(src.getLinkIdElement()));
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_14_30.convertString(src.getTextElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_14_30.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(VersionConvertor_14_30.convertString(src.getLinkIdElement()));
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_14_30.convertString(src.getTextElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_14_30.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
                break;
        }
        return tgt;
    }
}