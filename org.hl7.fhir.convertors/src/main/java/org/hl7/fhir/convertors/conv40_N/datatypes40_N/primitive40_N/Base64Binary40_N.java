package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary40_N {
  public static org.hl7.fhir.model.core.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.model.core.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.model.core.Base64BinaryType(src.getValue()) : new org.hl7.fhir.model.core.Base64BinaryType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.model.core.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r4.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r4.model.Base64BinaryType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
