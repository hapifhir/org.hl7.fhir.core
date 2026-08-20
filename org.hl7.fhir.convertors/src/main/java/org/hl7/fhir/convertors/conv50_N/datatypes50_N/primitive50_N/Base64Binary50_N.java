package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary50_N {
  public static org.hl7.fhir.model.core.Base64BinaryType convertBase64Binary(org.hl7.fhir.r5.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.model.core.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.model.core.Base64BinaryType(src.getValue()) : new org.hl7.fhir.model.core.Base64BinaryType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.model.core.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r5.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r5.model.Base64BinaryType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
