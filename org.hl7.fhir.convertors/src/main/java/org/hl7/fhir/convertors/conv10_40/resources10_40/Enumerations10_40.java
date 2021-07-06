package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Enumerations10_40 {
  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.AdministrativeGenderEnumFactory());
    Element10_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.NULL);
    } else {
      switch (src.getValue()) {
        case MALE:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE);
          break;
        case FEMALE:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE);
          break;
        case OTHER:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.OTHER);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGenderEnumFactory());
    Element10_40.copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.SearchParamTypeEnumFactory());
    Element10_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.NULL);
    } else {
      switch (src.getValue()) {
        case NUMBER:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.NUMBER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.DATE);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.STRING);
          break;
        case TOKEN:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.TOKEN);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.REFERENCE);
          break;
        case COMPOSITE:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.COMPOSITE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.QUANTITY);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.URI);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.SearchParamTypeEnumFactory());
    Element10_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NULL);
    } else {
      switch (src.getValue()) {
        case NUMBER:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NUMBER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.DATE);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.STRING);
          break;
        case TOKEN:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.TOKEN);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.REFERENCE);
          break;
        case COMPOSITE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.COMPOSITE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.QUANTITY);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.URI);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.PublicationStatusEnumFactory());
    Element10_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.ACTIVE);
          break;
        case RETIRED:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.RETIRED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> convertConformanceResourceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatusEnumFactory());
    Element10_40.copyElement(src, tgt);
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
}
