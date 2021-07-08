package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Reference14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Identifier14_50 {
    public static org.hl7.fhir.r5.model.Identifier convertIdentifier(org.hl7.fhir.dstu2016may.model.Identifier src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Identifier tgt = new org.hl7.fhir.r5.model.Identifier();
      Element14_50.copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
      if (src.hasType()) tgt.setType(CodeableConcept14_50.convertCodeableConcept(src.getType()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_50.convertUri(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String14_50.convertString(src.getValueElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period14_50.convertPeriod(src.getPeriod()));
      if (src.hasAssigner()) tgt.setAssigner(Reference14_50.convertReference(src.getAssigner()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Identifier convertIdentifier(org.hl7.fhir.r5.model.Identifier src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Identifier tgt = new org.hl7.fhir.dstu2016may.model.Identifier();
      Element14_50.copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
      if (src.hasType()) tgt.setType(CodeableConcept14_50.convertCodeableConcept(src.getType()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_50.convertUri(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String14_50.convertString(src.getValueElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period14_50.convertPeriod(src.getPeriod()));
      if (src.hasAssigner()) tgt.setAssigner(Reference14_50.convertReference(src.getAssigner()));
      return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Identifier.IdentifierUseEnumFactory());
      Element14_50.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.NULL);
      } else {
        switch (src.getValue()) {
          case USUAL:
            tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.USUAL);
            break;
          case OFFICIAL:
            tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.OFFICIAL);
            break;
          case TEMP:
            tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.TEMP);
            break;
          case SECONDARY:
            tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.SECONDARY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUseEnumFactory());
      Element14_50.copyElement(src, tgt);
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
