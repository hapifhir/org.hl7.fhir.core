package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.HumanName;

public class HumanName43_N {
  public static org.hl7.fhir.model.core.HumanName convertHumanName(org.hl7.fhir.r4b.model.HumanName src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.HumanName tgt = new org.hl7.fhir.model.core.HumanName();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasText()) tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    if (src.hasFamily()) tgt.setFamilyElement(String43_N.convertString(src.getFamilyElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getGiven()) tgt.getGivenList().add(String43_N.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPrefix()) tgt.getPrefixList().add(String43_N.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getSuffix()) tgt.getSuffixList().add(String43_N.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.HumanName convertHumanName(org.hl7.fhir.model.core.HumanName src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.HumanName tgt = new org.hl7.fhir.r4b.model.HumanName();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasText()) tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    if (src.hasFamily()) tgt.setFamilyElement(String43_N.convertString(src.getFamilyElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getGivenList()) tgt.getGiven().add(String43_N.convertString(t));
    for (org.hl7.fhir.model.core.StringType t : src.getPrefixList()) tgt.getPrefix().add(String43_N.convertString(t));
    for (org.hl7.fhir.model.core.StringType t : src.getSuffixList()) tgt.getSuffix().add(String43_N.convertString(t));
    if (src.hasPeriod()) tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.HumanName.NameUse> convertNameUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.HumanName.NameUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.HumanName.NameUseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case USUAL:
                    tgt.setValue(HumanName.NameUse.USUAL);
                    break;
                case OFFICIAL:
                    tgt.setValue(HumanName.NameUse.OFFICIAL);
                    break;
                case TEMP:
                    tgt.setValue(HumanName.NameUse.TEMP);
                    break;
                case NICKNAME:
                    tgt.setValue(HumanName.NameUse.NICKNAME);
                    break;
                case ANONYMOUS:
                    tgt.setValue(HumanName.NameUse.ANONYMOUS);
                    break;
                case OLD:
                    tgt.setValue(HumanName.NameUse.OLD);
                    break;
                case MAIDEN:
                    tgt.setValue(HumanName.NameUse.MAIDEN);
                    break;
                default:
                    tgt.setValue(HumanName.NameUse.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.HumanName.NameUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.HumanName.NameUseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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
