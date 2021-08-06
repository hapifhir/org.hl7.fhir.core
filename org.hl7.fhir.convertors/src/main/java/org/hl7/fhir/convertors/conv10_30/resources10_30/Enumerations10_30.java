package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Enumerations10_30 {
  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.NULL);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.ACTIVE);
          break;
        case RETIRED:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.RETIRED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.NULL);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.ACTIVE);
          break;
        case RETIRED:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.RETIRED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.NULL);
    } else {
      switch (src.getValue()) {
        case MALE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.MALE);
          break;
        case FEMALE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE);
          break;
        case OTHER:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.OTHER);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.NULL);
    } else {
      switch (src.getValue()) {
        case MALE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.MALE);
          break;
        case FEMALE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.FEMALE);
          break;
        case OTHER:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.OTHER);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.NULL);
          break;
      }
    }
    return tgt;
  }
}
