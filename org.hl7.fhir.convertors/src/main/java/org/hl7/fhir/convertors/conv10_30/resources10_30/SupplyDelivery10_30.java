package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyDelivery10_30 {

  public static org.hl7.fhir.dstu3.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.dstu2.model.SupplyDelivery src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.SupplyDelivery tgt = new org.hl7.fhir.dstu3.model.SupplyDelivery();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasSupplier())
      tgt.setSupplier(Reference10_30.convertReference(src.getSupplier()));
    if (src.hasDestination())
      tgt.setDestination(Reference10_30.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.dstu3.model.SupplyDelivery src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.SupplyDelivery tgt = new org.hl7.fhir.dstu2.model.SupplyDelivery();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasSupplier())
      tgt.setSupplier(Reference10_30.convertReference(src.getSupplier()));
    if (src.hasDestination())
      tgt.setDestination(Reference10_30.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_30.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED);
        break;
      case ABANDONED:
        tgt.setValue(org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
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
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.NULL);
        break;
    }
    return tgt;
  }
}