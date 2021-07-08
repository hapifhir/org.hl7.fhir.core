package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Uri10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Identifier10_30 {
    public static org.hl7.fhir.dstu3.model.Identifier convertIdentifier(org.hl7.fhir.dstu2.model.Identifier src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Identifier tgt = new org.hl7.fhir.dstu3.model.Identifier();
      Element10_30.copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
      if (src.hasType()) tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
      if (src.hasSystemElement()) tgt.setSystemElement(Uri10_30.convertUri(src.getSystemElement()));
      if (src.hasValueElement()) tgt.setValueElement(String10_30.convertString(src.getValueElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
      if (src.hasAssigner()) tgt.setAssigner(Reference10_30.convertReference(src.getAssigner()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Identifier convertIdentifier(org.hl7.fhir.dstu3.model.Identifier src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Identifier tgt = new org.hl7.fhir.dstu2.model.Identifier();
      Element10_30.copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
      if (src.hasType()) tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
      if (src.hasSystem()) tgt.setSystemElement(Uri10_30.convertUri(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String10_30.convertString(src.getValueElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
      if (src.hasAssigner()) tgt.setAssigner(Reference10_30.convertReference(src.getAssigner()));
      return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Identifier.IdentifierUseEnumFactory());
      Element10_30.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.NULL);
      } else {
        switch (src.getValue()) {
          case USUAL:
            tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.USUAL);
            break;
          case OFFICIAL:
            tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.OFFICIAL);
            break;
          case TEMP:
            tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.TEMP);
            break;
          case SECONDARY:
            tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.SECONDARY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Identifier.IdentifierUseEnumFactory());
      Element10_30.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.NULL);
      } else {
        switch (src.getValue()) {
          case USUAL:
            tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.USUAL);
            break;
          case OFFICIAL:
            tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.OFFICIAL);
            break;
          case TEMP:
            tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.TEMP);
            break;
          case SECONDARY:
            tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.SECONDARY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.NULL);
            break;
        }
      }
      return tgt;
    }

}
