package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.PositiveInt14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;

public class ContactPoint14_40 {
    public static org.hl7.fhir.r4.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2016may.model.ContactPoint src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.ContactPoint tgt = new org.hl7.fhir.r4.model.ContactPoint();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String14_40.convertString(src.getValueElement()));
      if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
      if (src.hasRank()) tgt.setRankElement(PositiveInt14_40.convertPositiveInt(src.getRankElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period14_40.convertPeriod(src.getPeriod()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ContactPoint convertContactPoint(org.hl7.fhir.r4.model.ContactPoint src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.ContactPoint tgt = new org.hl7.fhir.dstu2016may.model.ContactPoint();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.hasSystem()) tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String14_40.convertString(src.getValueElement()));
      if (src.hasUse()) tgt.setUseElement(convertContactPointUse(src.getUseElement()));
      if (src.hasRank()) tgt.setRankElement(PositiveInt14_40.convertPositiveInt(src.getRankElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period14_40.convertPeriod(src.getPeriod()));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ContactPoint.ContactPointSystemEnumFactory());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.NULL);
      } else {
        switch (src.getValue()) {
          case PHONE:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PHONE);
            break;
          case FAX:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.FAX);
            break;
          case EMAIL:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.EMAIL);
            break;
          case PAGER:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PAGER);
            break;
          case OTHER:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.URL);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystemEnumFactory());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ContactPoint.ContactPointUseEnumFactory());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.NULL);
      } else {
        switch (src.getValue()) {
          case HOME:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.HOME);
            break;
          case WORK:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.WORK);
            break;
          case TEMP:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.TEMP);
            break;
          case OLD:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.OLD);
            break;
          case MOBILE:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.MOBILE);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUseEnumFactory());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
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
