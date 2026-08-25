package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri43_N {
  public static org.hl7.fhir.model.core.UriType convertUri(org.hl7.fhir.r4b.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UriType convertUri(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.model.core.UriType convertUriFromCode(org.hl7.fhir.r4b.model.CodeType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeType convertUriToCode(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4b.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.CodeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
