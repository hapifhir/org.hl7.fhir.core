package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary10_50 {
  public static org.hl7.fhir.r5.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu2.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r5.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r5.model.Base64BinaryType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r5.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.dstu2.model.Base64BinaryType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
}
