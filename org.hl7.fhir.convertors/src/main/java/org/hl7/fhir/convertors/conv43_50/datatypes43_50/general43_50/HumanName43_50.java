package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class HumanName43_50 {
  public static org.hl7.fhir.r5.model.HumanName convertHumanName(org.hl7.fhir.r4b.model.HumanName src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.HumanName tgt = new org.hl7.fhir.r5.model.HumanName();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasText()) tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    if (src.hasFamily()) tgt.setFamilyElement(String43_50.convertString(src.getFamilyElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getGiven()) tgt.getGiven().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPrefix()) tgt.getPrefix().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getSuffix()) tgt.getSuffix().add(String43_50.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.HumanName convertHumanName(org.hl7.fhir.r5.model.HumanName src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.HumanName tgt = new org.hl7.fhir.r4b.model.HumanName();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasText()) tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    if (src.hasFamily()) tgt.setFamilyElement(String43_50.convertString(src.getFamilyElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getGiven()) tgt.getGiven().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getPrefix()) tgt.getPrefix().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getSuffix()) tgt.getSuffix().add(String43_50.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.HumanName.NameUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.HumanName.NameUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.HumanName.NameUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.NULL);
    } else {
      switch (src.getValue()) {
        case USUAL:
          tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.USUAL);
          break;
        case OFFICIAL:
          tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.OFFICIAL);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.TEMP);
          break;
        case NICKNAME:
          tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.NICKNAME);
          break;
        case ANONYMOUS:
          tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.ANONYMOUS);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.OLD);
          break;
        case MAIDEN:
          tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.MAIDEN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.HumanName.NameUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
