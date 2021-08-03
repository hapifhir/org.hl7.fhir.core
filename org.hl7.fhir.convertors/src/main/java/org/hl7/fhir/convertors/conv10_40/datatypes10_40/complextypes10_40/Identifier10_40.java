package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Uri10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class Identifier10_40 {
  public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.dstu2.model.Identifier src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_40.convertUri(src.getSystemElement()));
    if (src.hasValueElement()) tgt.setValueElement(String10_40.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference10_40.convertReference(src.getAssigner()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Identifier tgt = new org.hl7.fhir.dstu2.model.Identifier();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    if (src.hasSystem()) tgt.setSystemElement(Uri10_40.convertUri(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String10_40.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference10_40.convertReference(src.getAssigner()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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
