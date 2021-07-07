package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyDelivery10_50 {

    public static org.hl7.fhir.dstu2.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.r5.model.SupplyDelivery src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SupplyDelivery tgt = new org.hl7.fhir.dstu2.model.SupplyDelivery();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier10_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
        if (src.hasPatient())
            tgt.setPatient(Reference10_50.convertReference(src.getPatient()));
        if (src.hasType())
            tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
        if (src.hasSupplier())
            tgt.setSupplier(Reference10_50.convertReference(src.getSupplier()));
        if (src.hasDestination())
            tgt.setDestination(Reference10_50.convertReference(src.getDestination()));
        for (org.hl7.fhir.r5.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.dstu2.model.SupplyDelivery src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.SupplyDelivery tgt = new org.hl7.fhir.r5.model.SupplyDelivery();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
        if (src.hasPatient())
            tgt.setPatient(Reference10_50.convertReference(src.getPatient()));
        if (src.hasType())
            tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
        if (src.hasSupplier())
            tgt.setSupplier(Reference10_50.convertReference(src.getSupplier()));
        if (src.hasDestination())
            tgt.setDestination(Reference10_50.convertReference(src.getDestination()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_50.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
        Element10_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
        Element10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED);
                break;
            case ABANDONED:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.NULL);
                break;
        }
        return tgt;
    }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatusEnumFactory());
    Element10_50.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.NULL);
    } else {
      switch (src.getValue()) {
        case REQUESTED:
          tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
          break;
        case COMPLETED:
          tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
          break;
        case FAILED:
          tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatusEnumFactory());
    Element10_50.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.NULL);
    } else {
      switch (src.getValue()) {
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.REQUESTED);
          break;
        case COMPLETED:
          tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.NULL);
          break;
      }
    }
    return tgt;
  }
}