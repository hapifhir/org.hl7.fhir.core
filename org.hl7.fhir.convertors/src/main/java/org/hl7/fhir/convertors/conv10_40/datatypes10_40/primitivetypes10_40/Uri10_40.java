package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class Uri10_40 {
  public static org.hl7.fhir.r4.model.UriType convertUri(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValue()) : new org.hl7.fhir.r4.model.UriType();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.UriType convertUri(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UriType(src.getValue()) : new org.hl7.fhir.dstu2.model.UriType();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    return tgt;
  }
}
