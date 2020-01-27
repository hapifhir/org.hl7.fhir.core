package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class QuestionnaireResponse14_30 {

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu3.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_14_30.convertIdentifier(src.getIdentifier()));
        tgt.setQuestionnaire(VersionConvertor_14_30.convertReference(src.getQuestionnaire()));
        tgt.setStatus(convertQuestionnaireResponseStatus(src.getStatus()));
        tgt.setSubject(VersionConvertor_14_30.convertReference(src.getSubject()));
        tgt.setEncounter(VersionConvertor_14_30.convertReference(src.getContext()));
        tgt.setAuthor(VersionConvertor_14_30.convertReference(src.getAuthor()));
        if (src.hasAuthored())
            tgt.setAuthored(src.getAuthored());
        tgt.setSource(VersionConvertor_14_30.convertReference(src.getSource()));
        for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu3.model.QuestionnaireResponse();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_14_30.convertIdentifier(src.getIdentifier()));
        tgt.setQuestionnaire(VersionConvertor_14_30.convertReference(src.getQuestionnaire()));
        tgt.setStatus(convertQuestionnaireResponseStatus(src.getStatus()));
        tgt.setSubject(VersionConvertor_14_30.convertReference(src.getSubject()));
        tgt.setContext(VersionConvertor_14_30.convertReference(src.getEncounter()));
        tgt.setAuthor(VersionConvertor_14_30.convertReference(src.getAuthor()));
        if (src.hasAuthored())
            tgt.setAuthored(src.getAuthored());
        tgt.setSource(VersionConvertor_14_30.convertReference(src.getSource()));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        tgt.setValue(VersionConvertor_14_30.convertType(src.getValue()));
        for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
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
            tgt.setLinkId(src.getLinkId());
        if (src.hasText())
            tgt.setText(src.getText());
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
            tgt.setLinkId(src.getLinkId());
        if (src.hasText())
            tgt.setText(src.getText());
        tgt.setSubject(VersionConvertor_14_30.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus convertQuestionnaireResponseStatus(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED;
            case AMENDED:
                return org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED;
            default:
                return org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus convertQuestionnaireResponseStatus(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED;
            case AMENDED:
                return org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED;
            default:
                return org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL;
        }
    }
}
