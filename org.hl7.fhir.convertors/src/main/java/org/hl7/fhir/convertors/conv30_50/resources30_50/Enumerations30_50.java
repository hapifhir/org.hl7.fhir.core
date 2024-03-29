package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Enumerations30_50 {
  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.NULL);
    } else {
      switch (src.getValue()) {
        case REQUIRED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.REQUIRED);
          break;
        case EXTENSIBLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXTENSIBLE);
          break;
        case PREFERRED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.PREFERRED);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXAMPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.NULL);
    } else {
      switch (src.getValue()) {
        case REQUIRED:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.REQUIRED);
          break;
        case EXTENSIBLE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXTENSIBLE);
          break;
        case PREFERRED:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.PREFERRED);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXAMPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.ACTIVE);
          break;
        case RETIRED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.RETIRED);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NULL);
    } else {
      switch (src.getValue()) {
        case NUMBER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NUMBER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.DATE);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.STRING);
          break;
        case TOKEN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.TOKEN);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.REFERENCE);
          break;
        case COMPOSITE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.COMPOSITE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.QUANTITY);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.URI);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.NULL);
    } else {
      switch (src.getValue()) {
        case NUMBER:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.NUMBER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.DATE);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.STRING);
          break;
        case TOKEN:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.TOKEN);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.REFERENCE);
          break;
        case COMPOSITE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.COMPOSITE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.QUANTITY);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.URI);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.NULL);
    } else {
      switch (src.getValue()) {
        case MALE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.MALE);
          break;
        case FEMALE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.FEMALE);
          break;
        case OTHER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.OTHER);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FilterOperatorEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL);
    } else {
      switch (src.getValue()) {
        case EQUAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EQUAL);
          break;
        case ISA:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISA);
          break;
        case DESCENDENTOF:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.DESCENDENTOF);
          break;
        case ISNOTA:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISNOTA);
          break;
        case REGEX:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.REGEX);
          break;
        case IN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.IN);
          break;
        case NOTIN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NOTIN);
          break;
        case GENERALIZES:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.GENERALIZES);
          break;
        case EXISTS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EXISTS);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL);
          break;
      }
    }
    return tgt;
  }
}
