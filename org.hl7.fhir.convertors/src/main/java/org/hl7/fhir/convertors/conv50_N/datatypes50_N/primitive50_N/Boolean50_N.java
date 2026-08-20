package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean50_N {
  public static org.hl7.fhir.model.core.BooleanType convertBoolean(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.model.core.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.model.core.BooleanType(src.getValue()) : new org.hl7.fhir.model.core.BooleanType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.BooleanType convertBoolean(org.hl7.fhir.model.core.BooleanType src) throws FHIRException {
    org.hl7.fhir.r5.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.BooleanType(src.getValue()) : new org.hl7.fhir.r5.model.BooleanType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
