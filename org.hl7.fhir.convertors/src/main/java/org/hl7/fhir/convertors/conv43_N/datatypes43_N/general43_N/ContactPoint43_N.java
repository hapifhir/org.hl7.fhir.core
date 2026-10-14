package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.ContactPoint;

public class ContactPoint43_N {
  public static org.hl7.fhir.model.core.ContactPoint convertContactPoint(org.hl7.fhir.r4b.model.ContactPoint src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ContactPoint tgt = new org.hl7.fhir.model.core.ContactPoint();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRank()) tgt.setRankElement(PositiveInt43_N.convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ContactPoint convertContactPoint(org.hl7.fhir.model.core.ContactPoint src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ContactPoint tgt = new org.hl7.fhir.r4b.model.ContactPoint();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRank()) tgt.setRankElement(PositiveInt43_N.convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ContactPoint.ContactPointSystemEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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
                case URL:
                    tgt.setValue(ContactPoint.ContactPointSystem.URL);
                    break;
                case SMS:
                    tgt.setValue(ContactPoint.ContactPointSystem.SMS);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystemEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case PHONE:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.PHONE);
                    break;
                case FAX:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.FAX);
                    break;
                case EMAIL:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.EMAIL);
                    break;
                case PAGER:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.PAGER);
                    break;
                case URL:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.URL);
                    break;
                case SMS:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.SMS);
                    break;
                case OTHER:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.OTHER);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ContactPoint.ContactPointUseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ContactPoint.ContactPointUseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case HOME:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse.HOME);
                    break;
                case WORK:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse.WORK);
                    break;
                case TEMP:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse.TEMP);
                    break;
                case OLD:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse.OLD);
                    break;
                case MOBILE:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse.MOBILE);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse.NULL);
                    break;
       }
}
    return tgt;
  }
}
