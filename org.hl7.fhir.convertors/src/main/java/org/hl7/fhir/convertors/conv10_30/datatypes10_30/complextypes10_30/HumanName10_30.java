package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class HumanName10_30 {
  public static org.hl7.fhir.dstu3.model.HumanName convertHumanName(org.hl7.fhir.dstu2.model.HumanName src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.HumanName tgt = new org.hl7.fhir.dstu3.model.HumanName();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasTextElement()) tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getFamily()) tgt.setFamilyElement(String10_30.convertString(t));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getGiven()) tgt.getGiven().add(String10_30.convertString(t));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getPrefix()) tgt.getPrefix().add(String10_30.convertString(t));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getSuffix()) tgt.getSuffix().add(String10_30.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.HumanName convertHumanName(org.hl7.fhir.dstu3.model.HumanName src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.HumanName tgt = new org.hl7.fhir.dstu2.model.HumanName();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasTextElement()) tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    if (src.hasFamily()) tgt.getFamily().add(String10_30.convertString(src.getFamilyElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getGiven()) tgt.getGiven().add(String10_30.convertString(t));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getPrefix()) tgt.getPrefix().add(String10_30.convertString(t));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getSuffix()) tgt.getSuffix().add(String10_30.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.HumanName.NameUseEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.NULL);
    } else {
      switch (src.getValue()) {
        case USUAL:
          tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.USUAL);
          break;
        case OFFICIAL:
          tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.OFFICIAL);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.TEMP);
          break;
        case NICKNAME:
          tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.NICKNAME);
          break;
        case ANONYMOUS:
          tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.ANONYMOUS);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.OLD);
          break;
        case MAIDEN:
          tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.MAIDEN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.HumanName.NameUseEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.NULL);
    } else {
      switch (src.getValue()) {
        case USUAL:
          tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.USUAL);
          break;
        case OFFICIAL:
          tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.OFFICIAL);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.TEMP);
          break;
        case NICKNAME:
          tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.NICKNAME);
          break;
        case ANONYMOUS:
          tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.ANONYMOUS);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.OLD);
          break;
        case MAIDEN:
          tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.MAIDEN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
