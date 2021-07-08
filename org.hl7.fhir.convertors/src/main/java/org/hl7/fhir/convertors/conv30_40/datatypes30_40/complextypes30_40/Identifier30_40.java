package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Identifier30_40 {
    public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.dstu3.model.Identifier src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
      Element30_40.copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
      if (src.hasType()) tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
      if (src.hasSystem()) tgt.setSystemElement(Uri30_40.convertUri(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String30_40.convertString(src.getValueElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
      if (src.hasAssigner()) tgt.setAssigner(Reference30_40.convertReference(src.getAssigner()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Identifier tgt = new org.hl7.fhir.dstu3.model.Identifier();
      Element30_40.copyElement(src, tgt);
      if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
      if (src.hasType()) tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
      if (src.hasSystem()) tgt.setSystemElement(Uri30_40.convertUri(src.getSystemElement()));
      if (src.hasValue()) tgt.setValueElement(String30_40.convertString(src.getValueElement()));
      if (src.hasPeriod()) tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
      if (src.hasAssigner()) tgt.setAssigner(Reference30_40.convertReference(src.getAssigner()));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Identifier.IdentifierUseEnumFactory());
      Element30_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Identifier.IdentifierUseEnumFactory());
      Element30_40.copyElement(src, tgt);
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
}
