package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.SimpleQuantity30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyDelivery30_40 {

  public static org.hl7.fhir.r4.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.dstu3.model.SupplyDelivery src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SupplyDelivery tgt = new org.hl7.fhir.r4.model.SupplyDelivery();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_40.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasSuppliedItem())
      tgt.setSuppliedItem(convertSupplyDeliverySuppliedItemComponent(src.getSuppliedItem()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getOccurrence()));
    if (src.hasSupplier())
      tgt.setSupplier(Reference30_40.convertReference(src.getSupplier()));
    if (src.hasDestination())
      tgt.setDestination(Reference30_40.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference30_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.r4.model.SupplyDelivery src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.SupplyDelivery tgt = new org.hl7.fhir.dstu3.model.SupplyDelivery();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifierFirstRep()));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_40.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasSuppliedItem())
      tgt.setSuppliedItem(convertSupplyDeliverySuppliedItemComponent(src.getSuppliedItem()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getOccurrence()));
    if (src.hasSupplier())
      tgt.setSupplier(Reference30_40.convertReference(src.getSupplier()));
    if (src.hasDestination())
      tgt.setDestination(Reference30_40.convertReference(src.getDestination()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference30_40.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED);
        break;
      case ABANDONED:
        tgt.setValue(org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  public static org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent convertSupplyDeliverySuppliedItemComponent(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent tgt = new org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    if (src.hasItem())
      tgt.setItem(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getItem()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent convertSupplyDeliverySuppliedItemComponent(org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent tgt = new org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    if (src.hasItem())
      tgt.setItem(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getItem()));
    return tgt;
  }
}