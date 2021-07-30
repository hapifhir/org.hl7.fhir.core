package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Canonical10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Uri10_40;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CanonicalType;

public class Extension10_40 {
  public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.dstu2.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
    Element10_40.copyElement(src, tgt);
    if (src.hasUrlElement()) tgt.setUrlElement(Uri10_40.convertUri(src.getUrlElement()));
    if (src.hasValue())
      if (VersionConvertor_10_40.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu2.model.Reference)
        tgt.setValue(Canonical10_40.convertReferenceToCanonical((Reference) src.getValue()));
      else tgt.setValue(Type10_40.convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Extension tgt = new org.hl7.fhir.dstu2.model.Extension();
    Element10_40.copyElement(src, tgt);
    if (src.hasUrlElement()) tgt.setUrlElement(Uri10_40.convertUri(src.getUrlElement()));
    if (src.hasValue())
      if (VersionConvertor_10_40.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r4.model.CanonicalType)
        tgt.setValue(Canonical10_40.convertCanonicalToReference((CanonicalType) src.getValue()));
      else if (src.hasValue()) tgt.setValue(Type10_40.convertType(src.getValue()));
    if (src.hasValue()) tgt.setValue(Type10_40.convertType(src.getValue()));
    return tgt;
  }
}
