package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Enumerations14_40 {
  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.BindingStrengthEnumFactory());
    Element14_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL);
    } else {
      switch (src.getValue()) {
        case REQUIRED:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.REQUIRED);
          break;
        case EXTENSIBLE:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXTENSIBLE);
          break;
        case PREFERRED:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.PREFERRED);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXAMPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrengthEnumFactory());
    Element14_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.NULL);
    } else {
      switch (src.getValue()) {
        case REQUIRED:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.REQUIRED);
          break;
        case EXTENSIBLE:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.EXTENSIBLE);
          break;
        case PREFERRED:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.PREFERRED);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.EXAMPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.PublicationStatusEnumFactory());
    Element14_40.copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> convertConformanceResourceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatusEnumFactory());
    Element14_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.NULL);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.ACTIVE);
          break;
        case RETIRED:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.RETIRED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.SearchParamTypeEnumFactory());
    Element14_40.copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamTypeEnumFactory());
    Element14_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NULL);
    } else {
      switch (src.getValue()) {
        case NUMBER:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NUMBER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.DATE);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.STRING);
          break;
        case TOKEN:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.TOKEN);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.REFERENCE);
          break;
        case COMPOSITE:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.COMPOSITE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.QUANTITY);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.URI);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NULL);
          break;
      }
    }
    return tgt;
  }
}
