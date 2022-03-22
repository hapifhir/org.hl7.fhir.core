package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri14_30 {
  public static org.hl7.fhir.dstu3.model.UriType convertUri(org.hl7.fhir.dstu2016may.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UriType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.UriType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.UriType convertUri(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.UriType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.UriType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }
}
