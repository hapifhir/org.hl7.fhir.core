package org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer10_30 {
  public static org.hl7.fhir.dstu3.model.IntegerType convertInteger(org.hl7.fhir.dstu2.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.IntegerType(src.getValue()) : new org.hl7.fhir.dstu3.model.IntegerType();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.IntegerType convertInteger(org.hl7.fhir.dstu3.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.IntegerType(src.getValue()) : new org.hl7.fhir.dstu2.model.IntegerType();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    return tgt;
  }
}
