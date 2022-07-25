package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class QuestionnaireResponse30_50 {

  public static org.hl7.fhir.r5.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.dstu3.model.QuestionnaireResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getParent()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaireElement(Reference30_50.convertReferenceToCanonical(src.getQuestionnaire()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime30_50.convertDateTime(src.getAuthoredElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference30_50.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(Reference30_50.convertReference(src.getSource()));
    for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r5.model.QuestionnaireResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.QuestionnaireResponse tgt = new org.hl7.fhir.dstu3.model.QuestionnaireResponse();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifierFirstRep()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addParent(Reference30_50.convertReference(t));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaire(Reference30_50.convertCanonicalToReference(src.getQuestionnaireElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime30_50.convertDateTime(src.getAuthoredElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference30_50.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(Reference30_50.convertReference(src.getSource()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String30_50.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri30_50.convertUri(src.getDefinitionElement()));
    if (src.hasText())
      tgt.setTextElement(String30_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String30_50.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri30_50.convertUri(src.getDefinitionElement()));
    if (src.hasText())
      tgt.setTextElement(String30_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.STOPPED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.STOPPED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
        break;
    }
    return tgt;
  }
}