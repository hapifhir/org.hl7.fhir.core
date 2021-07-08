package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.PositiveInt30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactPoint30_50 {
    public static org.hl7.fhir.r5.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu3.model.ContactPoint src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.ContactPoint tgt = new org.hl7.fhir.r5.model.ContactPoint();
      Element30_50.copyElement(src, tgt);
      if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String30_50.convertString(src.getValueElement()));
      if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
      if (src.hasRank()) tgt.setRankElement(PositiveInt30_50.convertPositiveInt(src.getRankElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactPoint convertContactPoint(org.hl7.fhir.r5.model.ContactPoint src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.ContactPoint tgt = new org.hl7.fhir.dstu3.model.ContactPoint();
      Element30_50.copyElement(src, tgt);
      if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String30_50.convertString(src.getValueElement()));
      if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
      if (src.hasRank()) tgt.setRankElement(PositiveInt30_50.convertPositiveInt(src.getRankElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
      return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointSystemEnumFactory());
      Element30_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystemEnumFactory());
      Element30_50.copyElement(src, tgt);
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
          case URL:
            tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.URL);
            break;
          case SMS:
            tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.SMS);
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointUseEnumFactory());
      Element30_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUseEnumFactory());
      Element30_50.copyElement(src, tgt);
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
}
