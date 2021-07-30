package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyRequest10_30 {

  public static org.hl7.fhir.dstu3.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.dstu2.model.SupplyRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.SupplyRequest tgt = new org.hl7.fhir.dstu3.model.SupplyRequest();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.dstu3.model.SupplyRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.SupplyRequest tgt = new org.hl7.fhir.dstu2.model.SupplyRequest();
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.NULL);
    } else {
      switch (src.getValue()) {
        case REQUESTED:
          tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
          break;
        case COMPLETED:
          tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
          break;
        case FAILED:
          tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
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