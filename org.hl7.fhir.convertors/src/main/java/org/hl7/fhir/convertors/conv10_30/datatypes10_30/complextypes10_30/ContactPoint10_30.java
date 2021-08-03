package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.PositiveInt10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactPoint10_30 {
  public static org.hl7.fhir.dstu3.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.ContactPoint tgt = new org.hl7.fhir.dstu3.model.ContactPoint();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValueElement()) tgt.setValueElement(String10_30.convertString(src.getValueElement()));
    if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRank()) tgt.setRankElement(PositiveInt10_30.convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu3.model.ContactPoint src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ContactPoint tgt = new org.hl7.fhir.dstu2.model.ContactPoint();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValueElement()) tgt.setValueElement(String10_30.convertString(src.getValueElement()));
    if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRankElement()) tgt.setRankElement(PositiveInt10_30.convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystemEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.NULL);
    } else {
      switch (src.getValue()) {
        case PHONE:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.PHONE);
          break;
        case FAX:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.FAX);
          break;
        case EMAIL:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.EMAIL);
          break;
        case PAGER:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.PAGER);
          break;
        case OTHER:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.OTHER);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystemEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.NULL);
    } else {
      switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUseEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.NULL);
    } else {
      switch (src.getValue()) {
        case HOME:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.HOME);
          break;
        case WORK:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.WORK);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.TEMP);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.OLD);
          break;
        case MOBILE:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.MOBILE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUseEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.NULL);
    } else {
      switch (src.getValue()) {
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
