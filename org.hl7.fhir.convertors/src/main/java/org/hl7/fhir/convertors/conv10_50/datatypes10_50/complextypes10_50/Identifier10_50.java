package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Identifier;

public class Identifier10_50 {
  public static org.hl7.fhir.r5.model.Identifier convertIdentifier(org.hl7.fhir.dstu2.model.Identifier src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Identifier tgt = new org.hl7.fhir.r5.model.Identifier();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasValueElement()) tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference10_50.convertReference(src.getAssigner()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Identifier convertIdentifier(org.hl7.fhir.r5.model.Identifier src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Identifier tgt = new org.hl7.fhir.dstu2.model.Identifier();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasSystem()) tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference10_50.convertReference(src.getAssigner()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case USUAL:
                    tgt.setValue(Identifier.IdentifierUse.USUAL);
                    break;
                case OFFICIAL:
                    tgt.setValue(Identifier.IdentifierUse.OFFICIAL);
                    break;
                case TEMP:
                    tgt.setValue(Identifier.IdentifierUse.TEMP);
                    break;
                case SECONDARY:
                    tgt.setValue(Identifier.IdentifierUse.SECONDARY);
                    break;
                default:
                    tgt.setValue(Identifier.IdentifierUse.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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
