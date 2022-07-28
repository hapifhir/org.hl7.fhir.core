package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactPoint43_50 {
  public static org.hl7.fhir.r5.model.ContactPoint convertContactPoint(org.hl7.fhir.r4b.model.ContactPoint src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ContactPoint tgt = new org.hl7.fhir.r5.model.ContactPoint();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRank()) tgt.setRankElement(PositiveInt43_50.convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ContactPoint convertContactPoint(org.hl7.fhir.r5.model.ContactPoint src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ContactPoint tgt = new org.hl7.fhir.r4b.model.ContactPoint();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRank()) tgt.setRankElement(PositiveInt43_50.convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointSystemEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.NULL);
    } else {
      switch (src.getValue()) {
        case PHONE:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PHONE);
          break;
        case FAX:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.FAX);
          break;
        case EMAIL:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.EMAIL);
          break;
        case PAGER:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PAGER);
          break;
        case URL:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.URL);
          break;
        case SMS:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.SMS);
          break;
        case OTHER:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.OTHER);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystemEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem.NULL);
    } else {
      switch (src.getValue()) {
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.NULL);
    } else {
      switch (src.getValue()) {
        case HOME:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.HOME);
          break;
        case WORK:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.WORK);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.TEMP);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.OLD);
          break;
        case MOBILE:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.MOBILE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ContactPoint.ContactPointUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.ContactPoint.ContactPointUse.NULL);
    } else {
      switch (src.getValue()) {
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
