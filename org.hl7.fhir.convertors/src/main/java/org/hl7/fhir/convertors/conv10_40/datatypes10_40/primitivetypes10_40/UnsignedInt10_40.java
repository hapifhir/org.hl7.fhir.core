package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.dstu2.model.PositiveIntType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.UnsignedIntType;

public class UnsignedInt10_40 {
  public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu2.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.r4.model.UnsignedIntType();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.dstu2.model.UnsignedIntType();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    return tgt;
  }

  public static UnsignedIntType convertUnsignedIntToPositive(PositiveIntType src) {
    UnsignedIntType tgt = src.hasValue() ? new UnsignedIntType(src.getValue()) : new UnsignedIntType();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    return tgt;
  }
}
