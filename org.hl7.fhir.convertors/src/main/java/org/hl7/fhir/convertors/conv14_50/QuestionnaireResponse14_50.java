package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class QuestionnaireResponse14_50 {

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r5.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_14_50.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasQuestionnaireElement()) {
            tgt.setQuestionnaire(VersionConvertor_14_50.convertCanonicalToReference(src.getQuestionnaireElement()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertQuestionnaireResponseStatus(src.getStatus()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_14_50.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_14_50.convertReference(src.getEncounter()));
        }
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_14_50.convertReference(src.getAuthor()));
        }
        if (src.hasAuthored())
            tgt.setAuthored(src.getAuthored());
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_14_50.convertReference(src.getSource()));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.QuestionnaireResponse tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_14_50.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasQuestionnaire()) {
            tgt.setQuestionnaireElement(VersionConvertor_14_50.convertReferenceToCanonical(src.getQuestionnaire()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertQuestionnaireResponseStatus(src.getStatus()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_14_50.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_14_50.convertReference(src.getEncounter()));
        }
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_14_50.convertReference(src.getAuthor()));
        }
        if (src.hasAuthored())
            tgt.setAuthored(src.getAuthored());
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_14_50.convertReference(src.getSource()));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkId(src.getLinkId());
        if (src.hasText())
            tgt.setText(src.getText());
        if (src.hasAnswer()) {
            for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkId(src.getLinkId());
        if (src.hasText())
            tgt.setText(src.getText());
        if (src.hasAnswer()) {
            for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus convertQuestionnaireResponseStatus(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus src) throws FHIRException {
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

    static public org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus convertQuestionnaireResponseStatus(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED;
            case AMENDED:
                return org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED;
            default:
                return org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL;
        }
    }
}
