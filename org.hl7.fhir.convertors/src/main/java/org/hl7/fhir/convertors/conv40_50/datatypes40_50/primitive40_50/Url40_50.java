package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Url40_50 {
    public static org.hl7.fhir.r5.model.UrlType convertUrl(org.hl7.fhir.r4.model.UrlType src) throws FHIRException {
      org.hl7.fhir.r5.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UrlType(src.getValue()) : new org.hl7.fhir.r5.model.UrlType();
      Element40_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.r4.model.UrlType convertUrl(org.hl7.fhir.r5.model.UrlType src) throws FHIRException {
      org.hl7.fhir.r4.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UrlType(src.getValue()) : new org.hl7.fhir.r4.model.UrlType();
      Element40_50.copyElement(src, tgt);
      return tgt;
    }
}
