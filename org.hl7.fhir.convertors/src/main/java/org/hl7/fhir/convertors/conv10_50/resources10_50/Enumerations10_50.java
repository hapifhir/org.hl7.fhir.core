package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Enumerations;

public class Enumerations10_50 {
  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case REQUIRED:
                    tgt.setValue(Enumerations.BindingStrength.REQUIRED);
                    break;
                case EXTENSIBLE:
                    tgt.setValue(Enumerations.BindingStrength.EXTENSIBLE);
                    break;
                case PREFERRED:
                    tgt.setValue(Enumerations.BindingStrength.PREFERRED);
                    break;
                case EXAMPLE:
                    tgt.setValue(Enumerations.BindingStrength.EXAMPLE);
                    break;
                default:
                    tgt.setValue(Enumerations.BindingStrength.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case REQUIRED:
                    tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.REQUIRED);
                    break;
                case EXTENSIBLE:
                    tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXTENSIBLE);
                    break;
                case PREFERRED:
                    tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.PREFERRED);
                    break;
                case EXAMPLE:
                    tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXAMPLE);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case MALE:
                    tgt.setValue(Enumerations.AdministrativeGender.MALE);
                    break;
                case FEMALE:
                    tgt.setValue(Enumerations.AdministrativeGender.FEMALE);
                    break;
                case OTHER:
                    tgt.setValue(Enumerations.AdministrativeGender.OTHER);
                    break;
                case UNKNOWN:
                    tgt.setValue(Enumerations.AdministrativeGender.UNKNOWN);
                    break;
                default:
                    tgt.setValue(Enumerations.AdministrativeGender.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case NUMBER:
                    tgt.setValue(Enumerations.SearchParamType.NUMBER);
                    break;
                case DATE:
                    tgt.setValue(Enumerations.SearchParamType.DATE);
                    break;
                case STRING:
                    tgt.setValue(Enumerations.SearchParamType.STRING);
                    break;
                case TOKEN:
                    tgt.setValue(Enumerations.SearchParamType.TOKEN);
                    break;
                case REFERENCE:
                    tgt.setValue(Enumerations.SearchParamType.REFERENCE);
                    break;
                case COMPOSITE:
                    tgt.setValue(Enumerations.SearchParamType.COMPOSITE);
                    break;
                case QUANTITY:
                    tgt.setValue(Enumerations.SearchParamType.QUANTITY);
                    break;
                case URI:
                    tgt.setValue(Enumerations.SearchParamType.URI);
                    break;
                default:
                    tgt.setValue(Enumerations.SearchParamType.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case DRAFT:
                    tgt.setValue(Enumerations.PublicationStatus.DRAFT);
                    break;
                case ACTIVE:
                    tgt.setValue(Enumerations.PublicationStatus.ACTIVE);
                    break;
                case RETIRED:
                    tgt.setValue(Enumerations.PublicationStatus.RETIRED);
                    break;
                default:
                    tgt.setValue(Enumerations.PublicationStatus.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> convertConformanceResourceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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
