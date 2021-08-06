package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Address40_50 {
  public static org.hl7.fhir.r5.model.Address convertAddress(org.hl7.fhir.r4.model.Address src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Address tgt = new org.hl7.fhir.r5.model.Address();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertAddressUse(src.getUseElement()));
    if (src.hasType()) tgt.setTypeElement(convertAddressType(src.getTypeElement()));
    if (src.hasText()) tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getLine()) tgt.getLine().add(String40_50.convertString(t));
    if (src.hasCity()) tgt.setCityElement(String40_50.convertString(src.getCityElement()));
    if (src.hasDistrict()) tgt.setDistrictElement(String40_50.convertString(src.getDistrictElement()));
    if (src.hasState()) tgt.setStateElement(String40_50.convertString(src.getStateElement()));
    if (src.hasPostalCode()) tgt.setPostalCodeElement(String40_50.convertString(src.getPostalCodeElement()));
    if (src.hasCountry()) tgt.setCountryElement(String40_50.convertString(src.getCountryElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Address convertAddress(org.hl7.fhir.r5.model.Address src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Address tgt = new org.hl7.fhir.r4.model.Address();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertAddressUse(src.getUseElement()));
    if (src.hasType()) tgt.setTypeElement(convertAddressType(src.getTypeElement()));
    if (src.hasText()) tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLine()) tgt.getLine().add(String40_50.convertString(t));
    if (src.hasCity()) tgt.setCityElement(String40_50.convertString(src.getCityElement()));
    if (src.hasDistrict()) tgt.setDistrictElement(String40_50.convertString(src.getDistrictElement()));
    if (src.hasState()) tgt.setStateElement(String40_50.convertString(src.getStateElement()));
    if (src.hasPostalCode()) tgt.setPostalCodeElement(String40_50.convertString(src.getPostalCodeElement()));
    if (src.hasCountry()) tgt.setCountryElement(String40_50.convertString(src.getCountryElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Address.AddressUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.NULL);
    } else {
      switch (src.getValue()) {
        case HOME:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.HOME);
          break;
        case WORK:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.WORK);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.TEMP);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.OLD);
          break;
        case BILLING:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.BILLING);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Address.AddressUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.NULL);
    } else {
      switch (src.getValue()) {
        case HOME:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.HOME);
          break;
        case WORK:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.WORK);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.TEMP);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.OLD);
          break;
        case BILLING:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.BILLING);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> convertAddressType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Address.AddressTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.NULL);
    } else {
      switch (src.getValue()) {
        case POSTAL:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.POSTAL);
          break;
        case PHYSICAL:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.PHYSICAL);
          break;
        case BOTH:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.BOTH);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> convertAddressType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Address.AddressTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.NULL);
    } else {
      switch (src.getValue()) {
        case POSTAL:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.POSTAL);
          break;
        case PHYSICAL:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.PHYSICAL);
          break;
        case BOTH:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.BOTH);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.NULL);
          break;
      }
    }
    return tgt;
  }
}
