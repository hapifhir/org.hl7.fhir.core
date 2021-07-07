package org.hl7.fhir.convertors.conv14_50.datatypes14_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.dstu2016may.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;

public class Extension14_50 {
    public static org.hl7.fhir.r5.model.Extension convertExtension(org.hl7.fhir.dstu2016may.model.Extension src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
      Element14_50.copyElement(src, tgt);
      if (src.hasUrlElement()) tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
      if (src.hasValue())
        if (VersionConvertor_14_50.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu2016may.model.Reference)
          tgt.setValue(Reference14_50.convertReferenceToCanonical((Reference) src.getValue()));
        else tgt.setValue(Type14_50.convertType(src.getValue()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Extension convertExtension(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Extension tgt = new org.hl7.fhir.dstu2016may.model.Extension();
      Element14_50.copyElement(src, tgt);
      if (src.hasUrlElement()) tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
      if (src.hasValue())
        if (VersionConvertor_14_50.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r5.model.CanonicalType)
          tgt.setValue(Reference14_50.convertCanonicalToReference((CanonicalType) src.getValue()));
        else tgt.setValue(Type14_50.convertType(src.getValue()));
      return tgt;
    }

  static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    boolean ok = false;
    for (String s : extensionsToIgnore) if (s.equals(url)) ok = true;
    return ok;
  }

  static public boolean mappedExtension(String url) {
    if (url.equals(VersionConvertorConstants.PROFILE_EXTENSION) || url.equals(VersionConvertorConstants.IG_DEPENDSON_PACKAGE_EXTENSION) || url.equals(VersionConvertorConstants.IG_DEPENDSON_VERSION_EXTENSION) || url.equals(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT))
      return true;
    return false;
  }
}
