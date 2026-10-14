package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Uuid40_N {
  public static org.hl7.fhir.model.core.UuidType convertUuid(org.hl7.fhir.r4.model.UuidType src) throws FHIRException {
    org.hl7.fhir.model.core.UuidType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UuidType(src.getValueAsString()) : new org.hl7.fhir.model.core.UuidType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UuidType convertUuid(org.hl7.fhir.model.core.UuidType src) throws FHIRException {
    org.hl7.fhir.r4.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UuidType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UuidType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
