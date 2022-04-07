package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Reference14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Identifier14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.DateTime14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class QuestionnaireResponse14_50 {

  public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r5.model.QuestionnaireResponse src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier14_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasQuestionnaireElement())
      tgt.setQuestionnaire(Reference14_50.convertCanonicalToReference(src.getQuestionnaireElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference14_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference14_50.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference14_50.convertReference(src.getAuthor()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime14_50.convertDateTime(src.getAuthoredElement()));
    if (src.hasSource())
      tgt.setSource(Reference14_50.convertReference(src.getSource()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier14_50.convertIdentifier(src.getIdentifier()));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaireElement(Reference14_50.convertReferenceToCanonical(src.getQuestionnaire()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference14_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference14_50.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference14_50.convertReference(src.getAuthor()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime14_50.convertDateTime(src.getAuthoredElement()));
    if (src.hasSource())
      tgt.setSource(Reference14_50.convertReference(src.getSource()));
    for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getValue()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getValue()));
    for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String14_50.convertString(src.getLinkIdElement()));
    if (src.hasText())
      tgt.setTextElement(String14_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String14_50.convertString(src.getLinkIdElement()));
    if (src.hasText())
      tgt.setTextElement(String14_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    switch (src.getValue()) {
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
}