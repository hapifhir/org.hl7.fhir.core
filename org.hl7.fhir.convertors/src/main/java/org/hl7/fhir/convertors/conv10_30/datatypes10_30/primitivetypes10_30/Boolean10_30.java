package org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean10_30 {
  public static org.hl7.fhir.dstu3.model.BooleanType convertBoolean(org.hl7.fhir.dstu2.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.BooleanType(src.getValue()) : new org.hl7.fhir.dstu3.model.BooleanType();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.BooleanType convertBoolean(org.hl7.fhir.dstu3.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.BooleanType(src.getValue()) : new org.hl7.fhir.dstu2.model.BooleanType();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    return tgt;
  }
}
