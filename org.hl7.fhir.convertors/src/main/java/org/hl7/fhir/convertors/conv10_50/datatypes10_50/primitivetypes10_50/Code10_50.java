package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Code10_50 {
  public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValue()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu2.model.CodeType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UriType convertCodeToUri(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValue()) : new org.hl7.fhir.r5.model.UriType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CodeType convertUriToCode(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu2.model.CodeType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
}
