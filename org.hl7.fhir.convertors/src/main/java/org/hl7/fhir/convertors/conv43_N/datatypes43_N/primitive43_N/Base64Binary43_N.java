package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary43_N {
  public static org.hl7.fhir.model.core.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4b.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.model.core.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.model.core.Base64BinaryType(src.getValue()) : new org.hl7.fhir.model.core.Base64BinaryType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.model.core.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r4b.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r4b.model.Base64BinaryType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
