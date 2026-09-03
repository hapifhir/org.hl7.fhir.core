package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri40_N {
  public static org.hl7.fhir.model.core.UriType convertUri(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UriType convertUri(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.model.core.UriType convertUriFromCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeType convertUriToCode(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.CodeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
