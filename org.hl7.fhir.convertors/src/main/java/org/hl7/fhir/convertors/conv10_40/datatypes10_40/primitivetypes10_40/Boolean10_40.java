package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean10_40 {
  public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.dstu2.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.r4.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.BooleanType(src.getValue()) : new org.hl7.fhir.r4.model.BooleanType();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.BooleanType(src.getValue()) : new org.hl7.fhir.dstu2.model.BooleanType();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    return tgt;
  }
}
