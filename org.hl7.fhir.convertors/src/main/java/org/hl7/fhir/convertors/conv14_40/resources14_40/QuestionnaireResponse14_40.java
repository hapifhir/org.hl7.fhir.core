package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Type14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Identifier14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.DateTime14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Reference14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;

public class QuestionnaireResponse14_40 {

    public static org.hl7.fhir.r4.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier14_40.convertIdentifier(src.getIdentifier()));
        if (src.hasQuestionnaire())
            tgt.setQuestionnaireElement(Reference14_40.convertReferenceToCanonical(src.getQuestionnaire()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(Reference14_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference14_40.convertReference(src.getEncounter()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference14_40.convertReference(src.getAuthor()));
        if (src.hasAuthored())
            tgt.setAuthoredElement(DateTime14_40.convertDateTime(src.getAuthoredElement()));
        if (src.hasSource())
            tgt.setSource(Reference14_40.convertReference(src.getSource()));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r4.model.QuestionnaireResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier14_40.convertIdentifier(src.getIdentifier()));
        if (src.hasQuestionnaireElement())
            tgt.setQuestionnaire(Reference14_40.convertCanonicalToReference(src.getQuestionnaireElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(Reference14_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference14_40.convertReference(src.getEncounter()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference14_40.convertReference(src.getAuthor()));
        if (src.hasAuthored())
            tgt.setAuthoredElement(DateTime14_40.convertDateTime(src.getAuthoredElement()));
        if (src.hasSource())
            tgt.setSource(Reference14_40.convertReference(src.getSource()));
        for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getValue()));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getValue()));
        for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(String14_40.convertString(src.getLinkIdElement()));
        if (src.hasText())
            tgt.setTextElement(String14_40.convertString(src.getTextElement()));
        for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(String14_40.convertString(src.getLinkIdElement()));
        if (src.hasText())
            tgt.setTextElement(String14_40.convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer()) tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
        for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireResponseItemComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
                break;
        }
        return tgt;
    }
}