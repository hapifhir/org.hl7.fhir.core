package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Decimal30_50 {
  public static org.hl7.fhir.r5.model.DecimalType convertDecimal(org.hl7.fhir.dstu3.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.r5.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DecimalType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DecimalType convertDecimal(org.hl7.fhir.r5.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DecimalType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DecimalType convertInteger64(org.hl7.fhir.r5.model.Integer64Type src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DecimalType tgt = new org.hl7.fhir.dstu3.model.DecimalType(src.getValueAsString());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }
}
