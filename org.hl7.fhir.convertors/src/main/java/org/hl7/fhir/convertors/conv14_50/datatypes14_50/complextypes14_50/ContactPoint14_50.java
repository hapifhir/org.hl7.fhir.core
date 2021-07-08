package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.PositiveInt14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ContactPoint14_50 {
    public static org.hl7.fhir.r5.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2016may.model.ContactPoint src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.ContactPoint tgt = new org.hl7.fhir.r5.model.ContactPoint();
      Element14_50.copyElement(src, tgt);
      if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String14_50.convertString(src.getValueElement()));
      if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
      if (src.hasRank()) tgt.setRankElement(PositiveInt14_50.convertPositiveInt(src.getRankElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period14_50.convertPeriod(src.getPeriod()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ContactPoint convertContactPoint(org.hl7.fhir.r5.model.ContactPoint src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.ContactPoint tgt = new org.hl7.fhir.dstu2016may.model.ContactPoint();
      Element14_50.copyElement(src, tgt);
      if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String14_50.convertString(src.getValueElement()));
      if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
      if (src.hasRank()) tgt.setRankElement(PositiveInt14_50.convertPositiveInt(src.getRankElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period14_50.convertPeriod(src.getPeriod()));
      return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointSystemEnumFactory());
      Element14_50.copyElement(src, tgt);
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
          case OTHER:
            tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.URL);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystemEnumFactory());
      Element14_50.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.NULL);
      } else {
        switch (src.getValue()) {
          case PHONE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.PHONE);
            break;
          case FAX:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.FAX);
            break;
          case EMAIL:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.EMAIL);
            break;
          case PAGER:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.PAGER);
            break;
          case URL:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.OTHER);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointUseEnumFactory());
      Element14_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUseEnumFactory());
      Element14_50.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.NULL);
      } else {
        switch (src.getValue()) {
          case HOME:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.HOME);
            break;
          case WORK:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.WORK);
            break;
          case TEMP:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.TEMP);
            break;
          case OLD:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.OLD);
            break;
          case MOBILE:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.MOBILE);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.NULL);
            break;
        }
      }
      return tgt;
    }
}
