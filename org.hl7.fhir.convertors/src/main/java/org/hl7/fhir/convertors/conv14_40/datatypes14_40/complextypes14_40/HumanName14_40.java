package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class HumanName14_40 {
  public static org.hl7.fhir.r4.model.HumanName convertHumanName(org.hl7.fhir.dstu2016may.model.HumanName src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.HumanName tgt = new org.hl7.fhir.r4.model.HumanName();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasText()) tgt.setTextElement(String14_40.convertString(src.getTextElement()));
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getFamily()) tgt.setFamilyElement(String14_40.convertString(t));
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getGiven()) tgt.getGiven().add(String14_40.convertString(t));
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getPrefix()) tgt.getPrefix().add(String14_40.convertString(t));
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSuffix()) tgt.getSuffix().add(String14_40.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period14_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.HumanName convertHumanName(org.hl7.fhir.r4.model.HumanName src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.HumanName tgt = new org.hl7.fhir.dstu2016may.model.HumanName();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasText()) tgt.setTextElement(String14_40.convertString(src.getTextElement()));
    if (src.hasFamily()) tgt.getFamily().add(String14_40.convertString(src.getFamilyElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getGiven()) tgt.getGiven().add(String14_40.convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getPrefix()) tgt.getPrefix().add(String14_40.convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getSuffix()) tgt.getSuffix().add(String14_40.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period14_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.HumanName.NameUseEnumFactory());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.HumanName.NameUseEnumFactory());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.NULL);
    } else {
      switch (src.getValue()) {
        case USUAL:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.USUAL);
          break;
        case OFFICIAL:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.OFFICIAL);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.TEMP);
          break;
        case NICKNAME:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.NICKNAME);
          break;
        case ANONYMOUS:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.ANONYMOUS);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.OLD);
          break;
        case MAIDEN:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.MAIDEN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
