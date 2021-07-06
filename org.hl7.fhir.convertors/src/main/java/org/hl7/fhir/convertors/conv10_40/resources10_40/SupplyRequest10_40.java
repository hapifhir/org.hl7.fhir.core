package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyRequest10_40 {

    public static org.hl7.fhir.r4.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.dstu2.model.SupplyRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SupplyRequest tgt = new org.hl7.fhir.r4.model.SupplyRequest();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.r4.model.SupplyRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SupplyRequest tgt = new org.hl7.fhir.dstu2.model.SupplyRequest();
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatusEnumFactory());
      Element10_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.NULL);
      } else {
        switch (src.getValue()) {
          case REQUESTED:
            tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
            break;
          case COMPLETED:
            tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
            break;
          case FAILED:
            tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
            break;
          case CANCELLED:
            tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatusEnumFactory());
      Element10_40.copyElement(src, tgt);
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