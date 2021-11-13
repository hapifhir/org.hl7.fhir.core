package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension30_50 {
  public static org.hl7.fhir.r5.model.Extension convertExtension(org.hl7.fhir.dstu3.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    if (src.hasValue())
      if (VersionConvertor_30_50.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu3.model.Reference)
        tgt.setValue(Reference30_50.convertReferenceToCanonical((org.hl7.fhir.dstu3.model.Reference) src.getValue()));
      else tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Extension convertExtension(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Extension tgt = new org.hl7.fhir.dstu3.model.Extension();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    if (src.hasValue())
      if (VersionConvertor_30_50.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r5.model.CanonicalType)
        tgt.setValue(Reference30_50.convertCanonicalToReference((org.hl7.fhir.r5.model.CanonicalType) src.getValue()));
      else tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    return tgt;
  }

}
