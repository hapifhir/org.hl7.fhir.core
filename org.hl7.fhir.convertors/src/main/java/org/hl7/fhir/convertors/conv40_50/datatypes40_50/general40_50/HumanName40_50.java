package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class HumanName40_50 {
  public static org.hl7.fhir.r5.model.HumanName convertHumanName(org.hl7.fhir.r4.model.HumanName src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.HumanName tgt = new org.hl7.fhir.r5.model.HumanName();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasText()) tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    if (src.hasFamily()) tgt.setFamilyElement(String40_50.convertString(src.getFamilyElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getGiven()) tgt.getGiven().add(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getPrefix()) tgt.getPrefix().add(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getSuffix()) tgt.getSuffix().add(String40_50.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.HumanName convertHumanName(org.hl7.fhir.r5.model.HumanName src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.HumanName tgt = new org.hl7.fhir.r4.model.HumanName();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasText()) tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    if (src.hasFamily()) tgt.setFamilyElement(String40_50.convertString(src.getFamilyElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getGiven()) tgt.getGiven().add(String40_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getPrefix()) tgt.getPrefix().add(String40_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getSuffix()) tgt.getSuffix().add(String40_50.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.HumanName.NameUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.NULL);
    } else {
      switch (src.getValue()) {
        case USUAL:
          tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.USUAL);
          break;
        case OFFICIAL:
          tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.OFFICIAL);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.TEMP);
          break;
        case NICKNAME:
          tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.NICKNAME);
          break;
        case ANONYMOUS:
          tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.ANONYMOUS);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.OLD);
          break;
        case MAIDEN:
          tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.MAIDEN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.HumanName.NameUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.NULL);
    } else {
      switch (src.getValue()) {
        case USUAL:
          tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.USUAL);
          break;
        case OFFICIAL:
          tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.OFFICIAL);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.TEMP);
          break;
        case NICKNAME:
          tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.NICKNAME);
          break;
        case ANONYMOUS:
          tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.ANONYMOUS);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.OLD);
          break;
        case MAIDEN:
          tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.MAIDEN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
