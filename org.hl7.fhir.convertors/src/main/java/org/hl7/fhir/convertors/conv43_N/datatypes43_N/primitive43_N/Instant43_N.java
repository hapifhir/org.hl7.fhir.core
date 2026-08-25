package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Instant43_N {
  public static org.hl7.fhir.model.core.InstantType convertInstant(org.hl7.fhir.r4b.model.InstantType src) throws FHIRException {
    org.hl7.fhir.model.core.InstantType tgt = src.hasValue() ? new org.hl7.fhir.model.core.InstantType(src.getValueAsString()) : new org.hl7.fhir.model.core.InstantType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.InstantType convertInstant(org.hl7.fhir.model.core.InstantType src) throws FHIRException {
    org.hl7.fhir.r4b.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.InstantType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  public static org.hl7.fhir.model.core.DateTimeType convertInstantToDateTime(org.hl7.fhir.r4b.model.InstantType src) throws FHIRException {
    org.hl7.fhir.model.core.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateTimeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.InstantType convertInstantFromDateTime(org.hl7.fhir.model.core.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r4b.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.InstantType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
