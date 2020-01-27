package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class QuestionnaireResponse10_40 {

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent convertQuestionnaireItemToGroup(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent tgt = new org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setLinkId(src.getLinkId());
        tgt.setText(src.getText());
        for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) if (t.hasAnswer())
            tgt.addQuestion(convertQuestionnaireItemToQuestion(t));
        else
            tgt.addGroup(convertQuestionnaireItemToGroup(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent convertQuestionnaireItemToQuestion(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent tgt = new org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setLinkId(src.getLinkId());
        tgt.setText(src.getText());
        for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r4.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu2.model.QuestionnaireResponse();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        tgt.setQuestionnaire(VersionConvertor_10_40.convertCanonicalToReference(src.getQuestionnaireElement()));
        tgt.setStatus(convertQuestionnaireResponseStatus(src.getStatus()));
        tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        tgt.setAuthor(VersionConvertor_10_40.convertReference(src.getAuthor()));
        tgt.setAuthored(src.getAuthored());
        tgt.setSource(VersionConvertor_10_40.convertReference(src.getSource()));
        tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        if (src.getItem().size() != 1)
            throw new FHIRException("multiple root items not supported");
        tgt.setGroup(convertQuestionnaireItemToGroup(src.getItem().get(0)));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu2.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        tgt.setQuestionnaireElement(VersionConvertor_10_40.convertReferenceToCanonical(src.getQuestionnaire()));
        tgt.setStatus(convertQuestionnaireResponseStatus(src.getStatus()));
        tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        tgt.setAuthor(VersionConvertor_10_40.convertReference(src.getAuthor()));
        tgt.setAuthored(src.getAuthored());
        tgt.setSource(VersionConvertor_10_40.convertReference(src.getSource()));
        tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        if (src.hasGroup())
            tgt.addItem(convertQuestionnaireResponseGroupComponent(src.getGroup()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseGroupComponent(org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setLinkId(src.getLinkId());
        tgt.setText(src.getText());
        for (org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent t : src.getGroup()) tgt.addItem(convertQuestionnaireResponseGroupComponent(t));
        for (org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent t : src.getQuestion()) tgt.addItem(convertQuestionnaireResponseQuestionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setValue(VersionConvertor_10_40.convertType(src.getValue()));
        for (org.hl7.fhir.dstu2.model.QuestionnaireResponse.GroupComponent t : src.getGroup()) tgt.addItem(convertQuestionnaireResponseGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent tgt = new org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setValue(VersionConvertor_10_40.convertType(src.getValue()));
        for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addGroup(convertQuestionnaireItemToGroup(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseQuestionComponent(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setLinkId(src.getLinkId());
        tgt.setText(src.getText());
        for (org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus convertQuestionnaireResponseStatus(org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED;
            case AMENDED:
                return org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED;
            default:
                return org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus convertQuestionnaireResponseStatus(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED;
            case AMENDED:
                return org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED;
            default:
                return org.hl7.fhir.dstu2.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL;
        }
    }
}
