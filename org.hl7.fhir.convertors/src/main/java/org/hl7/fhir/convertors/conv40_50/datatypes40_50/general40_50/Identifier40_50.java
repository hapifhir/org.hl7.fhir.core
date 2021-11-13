package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Identifier40_50 {
  public static org.hl7.fhir.r5.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Identifier tgt = new org.hl7.fhir.r5.model.Identifier();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasSystem()) tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference40_50.convertReference(src.getAssigner()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.r5.model.Identifier src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasSystem()) tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference40_50.convertReference(src.getAssigner()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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
        case OLD:
          tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.OLD);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
