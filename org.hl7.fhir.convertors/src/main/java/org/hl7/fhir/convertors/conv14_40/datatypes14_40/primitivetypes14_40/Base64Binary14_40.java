package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary14_40 {
  public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu2016may.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r4.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.Base64BinaryType(src.getValueAsString()) : new org.hl7.fhir.r4.model.Base64BinaryType();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.Base64BinaryType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.Base64BinaryType();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    return tgt;
  }
}
