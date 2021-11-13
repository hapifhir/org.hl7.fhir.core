package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class UnsignedInt30_40 {
  public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu3.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.r4.model.UnsignedIntType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.dstu3.model.UnsignedIntType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }
}
