package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.SimpleQuantity30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyDelivery30_50 {

  public static org.hl7.fhir.r5.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.dstu3.model.SupplyDelivery src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SupplyDelivery tgt = new org.hl7.fhir.r5.model.SupplyDelivery();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasSuppliedItem())
      tgt.setSuppliedItem(convertSupplyDeliverySuppliedItemComponent(src.getSuppliedItem()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getOccurrence()));
    if (src.hasSupplier())
      tgt.setSupplier(Reference30_50.convertReference(src.getSupplier()));
    if (src.hasDestination())
      tgt.setDestination(Reference30_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.r5.model.SupplyDelivery src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.SupplyDelivery tgt = new org.hl7.fhir.dstu3.model.SupplyDelivery();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifierFirstRep()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasSuppliedItem())
      tgt.setSuppliedItem(convertSupplyDeliverySuppliedItemComponent(src.getSuppliedItem()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getOccurrence()));
    if (src.hasSupplier())
      tgt.setSupplier(Reference30_50.convertReference(src.getSupplier()));
    if (src.hasDestination())
      tgt.setDestination(Reference30_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference30_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED);
        break;
      case ABANDONED:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED);
        break;
      case ABANDONED:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent convertSupplyDeliverySuppliedItemComponent(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent tgt = new org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasItem())
      tgt.setItem(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getItem()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent convertSupplyDeliverySuppliedItemComponent(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent tgt = new org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasItem())
      tgt.setItem(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getItem()));
    return tgt;
  }
}