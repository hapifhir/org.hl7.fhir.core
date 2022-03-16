package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary30_40 {
  public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu3.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r4.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.Base64BinaryType(src.getValueAsString()) : new org.hl7.fhir.r4.model.Base64BinaryType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.Base64BinaryType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.Base64BinaryType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }
}
