package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class HumanName10_40 {
    public static org.hl7.fhir.r4.model.HumanName convertHumanName(org.hl7.fhir.dstu2.model.HumanName src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.HumanName tgt = new org.hl7.fhir.r4.model.HumanName();
      Element10_40.copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
      if (src.hasTextElement()) tgt.setTextElement(String10_40.convertString(src.getTextElement()));
      for (org.hl7.fhir.dstu2.model.StringType t : src.getFamily()) tgt.setFamily(t.getValue());
      for (org.hl7.fhir.dstu2.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
      for (org.hl7.fhir.dstu2.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
      for (org.hl7.fhir.dstu2.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
      if (src.hasPeriod()) tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HumanName convertHumanName(org.hl7.fhir.r4.model.HumanName src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.HumanName tgt = new org.hl7.fhir.dstu2.model.HumanName();
      Element10_40.copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
      if (src.hasTextElement()) tgt.setTextElement(String10_40.convertString(src.getTextElement()));
      if (src.hasFamily()) tgt.addFamily(src.getFamily());
      for (org.hl7.fhir.r4.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
      for (org.hl7.fhir.r4.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
      for (org.hl7.fhir.r4.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
      if (src.hasPeriod()) tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.HumanName.NameUseEnumFactory());
      Element10_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.HumanName.NameUseEnumFactory());
      Element10_40.copyElement(src, tgt);
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
