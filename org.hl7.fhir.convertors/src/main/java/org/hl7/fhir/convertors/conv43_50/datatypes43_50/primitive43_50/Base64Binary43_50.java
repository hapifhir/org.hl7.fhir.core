package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary43_50 {
  public static org.hl7.fhir.r5.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4b.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r5.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r5.model.Base64BinaryType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r5.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r4b.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r4b.model.Base64BinaryType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
