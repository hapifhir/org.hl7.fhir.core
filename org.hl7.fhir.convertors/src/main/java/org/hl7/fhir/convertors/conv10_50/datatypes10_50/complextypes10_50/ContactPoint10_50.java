package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.PositiveInt10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ContactPoint;

public class ContactPoint10_50 {
  public static org.hl7.fhir.r5.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.ContactPoint tgt = new org.hl7.fhir.r5.model.ContactPoint();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValueElement()) tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRankElement()) tgt.setRankElement(PositiveInt10_50.convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ContactPoint convertContactPoint(org.hl7.fhir.r5.model.ContactPoint src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ContactPoint tgt = new org.hl7.fhir.dstu2.model.ContactPoint();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValueElement()) tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRankElement()) tgt.setRankElement(PositiveInt10_50.convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointSystemEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case PHONE:
                    tgt.setValue(ContactPoint.ContactPointSystem.PHONE);
                    break;
                case FAX:
                    tgt.setValue(ContactPoint.ContactPointSystem.FAX);
                    break;
                case EMAIL:
                    tgt.setValue(ContactPoint.ContactPointSystem.EMAIL);
                    break;
                case PAGER:
                    tgt.setValue(ContactPoint.ContactPointSystem.PAGER);
                    break;
                case OTHER:
                    tgt.setValue(ContactPoint.ContactPointSystem.OTHER);
                    break;
                default:
                    tgt.setValue(ContactPoint.ContactPointSystem.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystemEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case PHONE:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PHONE);
                    break;
                case FAX:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.FAX);
                    break;
                case EMAIL:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.EMAIL);
                    break;
                case PAGER:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PAGER);
                    break;
                case OTHER:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER);
                    break;
                case URL:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointUseEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case HOME:
                    tgt.setValue(ContactPoint.ContactPointUse.HOME);
                    break;
                case WORK:
                    tgt.setValue(ContactPoint.ContactPointUse.WORK);
                    break;
                case TEMP:
                    tgt.setValue(ContactPoint.ContactPointUse.TEMP);
                    break;
                case OLD:
                    tgt.setValue(ContactPoint.ContactPointUse.OLD);
                    break;
                case MOBILE:
                    tgt.setValue(ContactPoint.ContactPointUse.MOBILE);
                    break;
                default:
                    tgt.setValue(ContactPoint.ContactPointUse.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUseEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case HOME:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.HOME);
                    break;
                case WORK:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.WORK);
                    break;
                case TEMP:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.TEMP);
                    break;
                case OLD:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.OLD);
                    break;
                case MOBILE:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.MOBILE);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.NULL);
                    break;
       }
}
    return tgt;
  }
}
