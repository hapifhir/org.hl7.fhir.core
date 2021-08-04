package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.SimpleQuantity30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Specimen30_50 {

  public static org.hl7.fhir.dstu3.model.Specimen convertSpecimen(org.hl7.fhir.r5.model.Specimen src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Specimen tgt = new org.hl7.fhir.dstu3.model.Specimen();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasAccessionIdentifier())
      tgt.setAccessionIdentifier(Identifier30_50.convertIdentifier(src.getAccessionIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasReceivedTime())
      tgt.setReceivedTimeElement(DateTime30_50.convertDateTime(src.getReceivedTimeElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getParent()) tgt.addParent(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getRequest()) tgt.addRequest(Reference30_50.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent t : src.getProcessing())
      tgt.addProcessing(convertSpecimenProcessingComponent(t));
    for (org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent t : src.getContainer())
      tgt.addContainer(convertSpecimenContainerComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Specimen convertSpecimen(org.hl7.fhir.dstu3.model.Specimen src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Specimen tgt = new org.hl7.fhir.r5.model.Specimen();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasAccessionIdentifier())
      tgt.setAccessionIdentifier(Identifier30_50.convertIdentifier(src.getAccessionIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasReceivedTime())
      tgt.setReceivedTimeElement(DateTime30_50.convertDateTime(src.getReceivedTimeElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getParent()) tgt.addParent(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getRequest()) tgt.addRequest(Reference30_50.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent t : src.getProcessing())
      tgt.addProcessing(convertSpecimenProcessingComponent(t));
    for (org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent t : src.getContainer())
      tgt.addContainer(convertSpecimenContainerComponent(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference30_50.convertReference(src.getCollector()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getCollected()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept30_50.convertCodeableConcept(src.getMethod()));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept30_50.convertCodeableConcept(src.getBodySite()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference30_50.convertReference(src.getCollector()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getCollected()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept30_50.convertCodeableConcept(src.getMethod()));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept30_50.convertCodeableConcept(src.getBodySite()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasCapacity())
      tgt.setCapacity(SimpleQuantity30_50.convertSimpleQuantity(src.getCapacity()));
    if (src.hasSpecimenQuantity())
      tgt.setSpecimenQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getSpecimenQuantity()));
    if (src.hasAdditive())
      tgt.setAdditive(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getAdditive()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasCapacity())
      tgt.setCapacity(SimpleQuantity30_50.convertSimpleQuantity(src.getCapacity()));
    if (src.hasSpecimenQuantity())
      tgt.setSpecimenQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getSpecimenQuantity()));
    if (src.hasAdditive())
      tgt.setAdditive(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getAdditive()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasProcedure())
      tgt.setProcedure(CodeableConcept30_50.convertCodeableConcept(src.getProcedure()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAdditive()) tgt.addAdditive(Reference30_50.convertReference(t));
    if (src.hasTime())
      tgt.setTime(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasProcedure())
      tgt.setProcedure(CodeableConcept30_50.convertCodeableConcept(src.getProcedure()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAdditive()) tgt.addAdditive(Reference30_50.convertReference(t));
    if (src.hasTime())
      tgt.setTime(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getTime()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Specimen.SpecimenStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case AVAILABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.AVAILABLE);
        break;
      case UNAVAILABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.UNAVAILABLE);
        break;
      case UNSATISFACTORY:
        tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.UNSATISFACTORY);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Specimen.SpecimenStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case AVAILABLE:
        tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.AVAILABLE);
        break;
      case UNAVAILABLE:
        tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.UNAVAILABLE);
        break;
      case UNSATISFACTORY:
        tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.UNSATISFACTORY);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.NULL);
        break;
    }
    return tgt;
  }
}