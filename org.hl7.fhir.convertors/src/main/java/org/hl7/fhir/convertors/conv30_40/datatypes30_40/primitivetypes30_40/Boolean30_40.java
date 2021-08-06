package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean30_40 {
  public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.dstu3.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.r4.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.BooleanType(src.getValue()) : new org.hl7.fhir.r4.model.BooleanType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.BooleanType(src.getValue()) : new org.hl7.fhir.dstu3.model.BooleanType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }
}
