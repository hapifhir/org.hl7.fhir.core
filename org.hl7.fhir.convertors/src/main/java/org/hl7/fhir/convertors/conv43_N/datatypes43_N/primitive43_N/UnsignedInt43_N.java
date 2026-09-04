package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class UnsignedInt43_N {
  public static org.hl7.fhir.model.core.Integer64Type convertUnsignedIntToInteger64(org.hl7.fhir.r4b.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.model.core.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.model.core.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.model.core.Integer64Type();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UnsignedIntType convertInteger64ToUnsignedInt(org.hl7.fhir.model.core.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4b.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UnsignedIntType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4b.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.model.core.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.UnsignedIntType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.model.core.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UnsignedIntType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
