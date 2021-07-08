package org.hl7.fhir.convertors.conv10_50.datatypes10_50;

import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;

public class Extension10_50 {
    public static org.hl7.fhir.r5.model.Extension convertExtension(org.hl7.fhir.dstu2.model.Extension src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
      Element10_50.copyElement(src, tgt);
      if (src.hasUrlElement()) tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
      if (src.hasValue())
        if (VersionConvertor_10_50.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu2.model.Reference)
          tgt.setValue(Reference10_50.convertReferenceToCanonical((Reference) src.getValue()));
        else tgt.setValue(Type10_50.convertType(src.getValue()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Extension convertExtension(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Extension tgt = new org.hl7.fhir.dstu2.model.Extension();
      Element10_50.copyElement(src, tgt);
      if (src.hasUrlElement()) tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
      if (src.hasValue())
        if (VersionConvertor_10_50.CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r5.model.CanonicalType)
          tgt.setValue(Reference10_50.convertCanonicalToReference((CanonicalType) src.getValue()));
        else if (src.hasValue()) tgt.setValue(Type10_50.convertType(src.getValue()));
      if (src.hasValue()) tgt.setValue(Type10_50.convertType(src.getValue()));
      return tgt;
    }
}
