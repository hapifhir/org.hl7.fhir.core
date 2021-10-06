package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Id10_50 {
  public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.dstu2.model.IdType src) throws FHIRException {
    org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValue()) : new org.hl7.fhir.r5.model.IdType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.IdType(src.getValue()) : new org.hl7.fhir.dstu2.model.IdType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
}
