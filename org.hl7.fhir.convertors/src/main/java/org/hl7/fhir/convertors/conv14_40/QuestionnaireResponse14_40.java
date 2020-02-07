package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class QuestionnaireResponse14_40 {

    public static org.hl7.fhir.r4.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_14_40.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasQuestionnaire()) {
            tgt.setQuestionnaireElement(VersionConvertor_14_40.convertReferenceToCanonical(src.getQuestionnaire()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertQuestionnaireResponseStatus(src.getStatus()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_14_40.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_14_40.convertReference(src.getEncounter()));
        }
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_14_40.convertReference(src.getAuthor()));
        }
        if (src.hasAuthoredElement())
            tgt.setAuthoredElement((org.hl7.fhir.r4.model.DateTimeType) VersionConvertor_14_40.convertType(src.getAuthoredElement()));
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_14_40.convertReference(src.getSource()));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r4.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_14_40.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasQuestionnaireElement()) {
            tgt.setQuestionnaire(VersionConvertor_14_40.convertCanonicalToReference(src.getQuestionnaireElement()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertQuestionnaireResponseStatus(src.getStatus()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_14_40.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_14_40.convertReference(src.getEncounter()));
        }
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_14_40.convertReference(src.getAuthor()));
        }
        if (src.hasAuthoredElement())
            tgt.setAuthoredElement((org.hl7.fhir.dstu2016may.model.DateTimeType) VersionConvertor_14_40.convertType(src.getAuthoredElement()));
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_14_40.convertReference(src.getSource()));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_40.convertType(src.getValue()));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_40.convertType(src.getValue()));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getLinkIdElement()));
        if (src.hasTextElement())
            tgt.setTextElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getTextElement()));
        if (src.hasAnswer()) {
            for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getLinkIdElement()));
        if (src.hasTextElement())
            tgt.setTextElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getTextElement()));
        if (src.hasAnswer()) {
            for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus convertQuestionnaireResponseStatus(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus convertQuestionnaireResponseStatus(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus src) throws FHIRException {
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
}
