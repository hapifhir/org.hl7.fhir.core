package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Identifier43_50 {
  public static org.hl7.fhir.r5.model.Identifier convertIdentifier(org.hl7.fhir.r4b.model.Identifier src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Identifier tgt = new org.hl7.fhir.r5.model.Identifier();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSystem()) tgt.setSystemElement(Uri43_50.convertUri(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference43_50.convertReference(src.getAssigner()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Identifier convertIdentifier(org.hl7.fhir.r5.model.Identifier src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Identifier tgt = new org.hl7.fhir.r4b.model.Identifier();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSystem()) tgt.setSystemElement(Uri43_50.convertUri(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference43_50.convertReference(src.getAssigner()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
        case OLD:
          tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.OLD);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.Identifier.IdentifierUse.NULL);
    } else {
      switch (src.getValue()) {
        case USUAL:
          tgt.setValue(org.hl7.fhir.r4b.model.Identifier.IdentifierUse.USUAL);
          break;
        case OFFICIAL:
          tgt.setValue(org.hl7.fhir.r4b.model.Identifier.IdentifierUse.OFFICIAL);
          break;
        case TEMP:
          tgt.setValue(org.hl7.fhir.r4b.model.Identifier.IdentifierUse.TEMP);
          break;
        case SECONDARY:
          tgt.setValue(org.hl7.fhir.r4b.model.Identifier.IdentifierUse.SECONDARY);
          break;
        case OLD:
          tgt.setValue(org.hl7.fhir.r4b.model.Identifier.IdentifierUse.OLD);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.Identifier.IdentifierUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
