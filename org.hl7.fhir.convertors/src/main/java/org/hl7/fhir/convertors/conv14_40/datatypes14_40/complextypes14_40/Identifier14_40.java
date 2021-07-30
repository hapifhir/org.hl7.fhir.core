package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Uri14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Reference14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;

public class Identifier14_40 {
    public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.dstu2016may.model.Identifier src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
      if (src.hasType()) tgt.setType(CodeableConcept14_40.convertCodeableConcept(src.getType()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String14_40.convertString(src.getValueElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period14_40.convertPeriod(src.getPeriod()));
      if (src.hasAssigner()) tgt.setAssigner(Reference14_40.convertReference(src.getAssigner()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Identifier tgt = new org.hl7.fhir.dstu2016may.model.Identifier();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
      if (src.hasType()) tgt.setType(CodeableConcept14_40.convertCodeableConcept(src.getType()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String14_40.convertString(src.getValueElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period14_40.convertPeriod(src.getPeriod()));
      if (src.hasAssigner()) tgt.setAssigner(Reference14_40.convertReference(src.getAssigner()));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Identifier.IdentifierUseEnumFactory());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.NULL);
      } else {
        switch (src.getValue()) {
          case USUAL:
            tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.USUAL);
            break;
          case OFFICIAL:
            tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.OFFICIAL);
            break;
          case TEMP:
            tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.TEMP);
            break;
          case SECONDARY:
            tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.SECONDARY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUseEnumFactory());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.NULL);
      } else {
        switch (src.getValue()) {
          case USUAL:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.USUAL);
            break;
          case OFFICIAL:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.OFFICIAL);
            break;
          case TEMP:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.TEMP);
            break;
          case SECONDARY:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.SECONDARY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.NULL);
            break;
        }
      }
      return tgt;
    }
}
