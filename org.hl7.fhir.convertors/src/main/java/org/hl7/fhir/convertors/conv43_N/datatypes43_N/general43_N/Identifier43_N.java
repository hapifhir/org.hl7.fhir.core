package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Identifier;

public class Identifier43_N {
  public static org.hl7.fhir.model.core.Identifier convertIdentifier(org.hl7.fhir.r4b.model.Identifier src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Identifier tgt = new org.hl7.fhir.model.core.Identifier();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasSystem()) tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference43_N.convertReference(src.getAssigner()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Identifier convertIdentifier(org.hl7.fhir.model.core.Identifier src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Identifier tgt = new org.hl7.fhir.r4b.model.Identifier();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasUse()) tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType()) tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasSystem()) tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasValue()) tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    if (src.hasPeriod()) tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasAssigner()) tgt.setAssigner(Reference43_N.convertReference(src.getAssigner()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Identifier.IdentifierUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Identifier.IdentifierUseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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
                case OLD:
                    tgt.setValue(Identifier.IdentifierUse.OLD);
                    break;
                default:
                    tgt.setValue(Identifier.IdentifierUse.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Identifier.IdentifierUseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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
