package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Uuid43_N {
  public static org.hl7.fhir.model.core.UuidType convertUuid(org.hl7.fhir.r4b.model.UuidType src) throws FHIRException {
    org.hl7.fhir.model.core.UuidType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UuidType(src.getValueAsString()) : new org.hl7.fhir.model.core.UuidType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UuidType convertUuid(org.hl7.fhir.model.core.UuidType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UuidType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UuidType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
