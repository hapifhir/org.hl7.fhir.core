package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Address;

public class Address40_N {
  public static org.hl7.fhir.model.core.Address convertAddress(org.hl7.fhir.r4.model.Address src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Address tgt = new org.hl7.fhir.model.core.Address();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertAddressUse(src.getUseElement()));
    if (src.hasType()) tgt.setTypeElement(convertAddressType(src.getTypeElement()));
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getLine()) tgt.getLineList().add(String40_N.convertString(t));
    if (src.hasCity()) tgt.setCityElement(String40_N.convertString(src.getCityElement()));
    if (src.hasDistrict()) tgt.setDistrictElement(String40_N.convertString(src.getDistrictElement()));
    if (src.hasState()) tgt.setStateElement(String40_N.convertString(src.getStateElement()));
    if (src.hasPostalCode()) tgt.setPostalCodeElement(String40_N.convertString(src.getPostalCodeElement()));
    if (src.hasCountry()) tgt.setCountryElement(String40_N.convertString(src.getCountryElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Address convertAddress(org.hl7.fhir.model.core.Address src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Address tgt = new org.hl7.fhir.r4.model.Address();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertAddressUse(src.getUseElement()));
    if (src.hasType()) tgt.setTypeElement(convertAddressType(src.getTypeElement()));
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getLineList()) tgt.getLine().add(String40_N.convertString(t));
    if (src.hasCity()) tgt.setCityElement(String40_N.convertString(src.getCityElement()));
    if (src.hasDistrict()) tgt.setDistrictElement(String40_N.convertString(src.getDistrictElement()));
    if (src.hasState()) tgt.setStateElement(String40_N.convertString(src.getStateElement()));
    if (src.hasPostalCode()) tgt.setPostalCodeElement(String40_N.convertString(src.getPostalCodeElement()));
    if (src.hasCountry()) tgt.setCountryElement(String40_N.convertString(src.getCountryElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Address.AddressUse> convertAddressUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Address.AddressUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Address.AddressUseEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case HOME:
                    tgt.setValue(Address.AddressUse.HOME);
                    break;
                case WORK:
                    tgt.setValue(Address.AddressUse.WORK);
                    break;
                case TEMP:
                    tgt.setValue(Address.AddressUse.TEMP);
                    break;
                case OLD:
                    tgt.setValue(Address.AddressUse.OLD);
                    break;
                case BILLING:
                    tgt.setValue(Address.AddressUse.BILLING);
                    break;
                default:
                    tgt.setValue(Address.AddressUse.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Address.AddressUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Address.AddressUseEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Address.AddressType> convertAddressType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Address.AddressType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Address.AddressTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case POSTAL:
                    tgt.setValue(Address.AddressType.POSTAL);
                    break;
                case PHYSICAL:
                    tgt.setValue(Address.AddressType.PHYSICAL);
                    break;
                case BOTH:
                    tgt.setValue(Address.AddressType.BOTH);
                    break;
                default:
                    tgt.setValue(Address.AddressType.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> convertAddressType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Address.AddressType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Address.AddressTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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
