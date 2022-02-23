package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ClinicalImpression30_50 {

  public static org.hl7.fhir.dstu3.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.r5.model.ClinicalImpression src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ClinicalImpression tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClinicalImpressionStatus(src.getStatusElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEffective()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPerformer())
      tgt.setAssessor(Reference30_50.convertReference(src.getPerformer()));
    if (src.hasPrevious())
      tgt.setPrevious(Reference30_50.convertReference(src.getPrevious()));
    for (org.hl7.fhir.r5.model.Reference t : src.getProblem()) tgt.addProblem(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getProtocol()) tgt.addProtocol(t.getValue());
    if (src.hasSummary())
      tgt.setSummaryElement(String30_50.convertString(src.getSummaryElement()));
    for (org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding())
      tgt.addFinding(convertClinicalImpressionFindingComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPrognosisCodeableConcept())
      tgt.addPrognosisCodeableConcept(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPrognosisReference())
      tgt.addPrognosisReference(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.dstu3.model.ClinicalImpression src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClinicalImpression tgt = new org.hl7.fhir.r5.model.ClinicalImpression();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClinicalImpressionStatus(src.getStatusElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEffective()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasAssessor())
      tgt.setPerformer(Reference30_50.convertReference(src.getAssessor()));
    if (src.hasPrevious())
      tgt.setPrevious(Reference30_50.convertReference(src.getPrevious()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getProblem()) tgt.addProblem(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getProtocol()) tgt.addProtocol(t.getValue());
    if (src.hasSummary())
      tgt.setSummaryElement(String30_50.convertString(src.getSummaryElement()));
    for (org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding())
      tgt.addFinding(convertClinicalImpressionFindingComponent(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPrognosisCodeableConcept())
      tgt.addPrognosisCodeableConcept(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPrognosisReference())
      tgt.addPrognosisReference(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasItem() && src.getItem().hasConcept())
      tgt.setItem(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getItem().getConcept()));
    else if (src.hasItem() && src.getItem().hasReference())
      tgt.setItem(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getItem().getReference()));
    if (src.hasBasis())
      tgt.setBasisElement(String30_50.convertString(src.getBasisElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasItemCodeableConcept())
      tgt.setItem(Reference30_50.convertCodeableConceptToCodableReference(src.getItemCodeableConcept()));
    if (src.hasItemReference())
      tgt.setItem(Reference30_50.convertReferenceToCodableReference(src.getItemReference()));
    if (src.hasBasis())
      tgt.setBasisElement(String30_50.convertString(src.getBasisElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus> convertClinicalImpressionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.DRAFT);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> convertClinicalImpressionStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ClinicalImpression.ClinicalImpressionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.EventStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL);
        break;
    }
    return tgt;
  }
}