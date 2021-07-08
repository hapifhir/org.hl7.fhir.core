package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension30_40 {
    public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.dstu3.model.Extension src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
      Element30_40.copyElement(src, tgt);
      if (src.hasUrl()) tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
      if (src.hasValue())
        if (VersionConvertor_30_40.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu3.model.Reference)
          tgt.setValue(Reference30_40.convertReferenceToCanonical((org.hl7.fhir.dstu3.model.Reference) src.getValue()));
        else tgt.setValue(Type30_40.convertType(src.getValue()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Extension tgt = new org.hl7.fhir.dstu3.model.Extension();
      Element30_40.copyElement(src, tgt);
      if (src.hasUrl()) tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
      if (src.hasValue())
        if (VersionConvertor_30_40.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r4.model.CanonicalType)
          tgt.setValue(Reference30_40.convertCanonicalToReference((org.hl7.fhir.r4.model.CanonicalType) src.getValue()));
        else tgt.setValue(Type30_40.convertType(src.getValue()));
      return tgt;
    }

  static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    boolean ok = false;
    for (String s : extensionsToIgnore) if (s.equals(url)) ok = true;
    return ok;
  }
}
