package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Instant40_N {
  public static org.hl7.fhir.model.core.InstantType convertInstant(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
    org.hl7.fhir.model.core.InstantType tgt = src.hasValue() ? new org.hl7.fhir.model.core.InstantType(src.getValueAsString()) : new org.hl7.fhir.model.core.InstantType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.InstantType convertInstant(org.hl7.fhir.model.core.InstantType src) throws FHIRException {
    org.hl7.fhir.r4.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r4.model.InstantType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  public static org.hl7.fhir.model.core.DateTimeType convertInstantToDateTime(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
    org.hl7.fhir.model.core.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateTimeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.InstantType convertInstantFromDateTime(org.hl7.fhir.model.core.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r4.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r4.model.InstantType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
