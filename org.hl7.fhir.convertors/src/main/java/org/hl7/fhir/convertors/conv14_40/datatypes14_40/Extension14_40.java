package org.hl7.fhir.convertors.conv14_40.datatypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Uri14_40;
import org.hl7.fhir.dstu2016may.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CanonicalType;

public class Extension14_40 {
  public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.dstu2016may.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasUrlElement()) tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
    if (src.hasValue())
      if (VersionConvertor_14_40.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu2016may.model.Reference)
        tgt.setValue(Reference14_40.convertReferenceToCanonical((Reference) src.getValue()));
      else tgt.setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Extension tgt = new org.hl7.fhir.dstu2016may.model.Extension();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasUrlElement()) tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
    if (src.hasValue())
      if (VersionConvertor_14_40.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r4.model.CanonicalType)
        tgt.setValue(Reference14_40.convertCanonicalToReference((CanonicalType) src.getValue()));
      else tgt.setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getValue()));
    return tgt;
  }

  static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    boolean ok = false;
    for (String s : extensionsToIgnore) if (s.equals(url)) ok = true;
    return ok;
  }
}
