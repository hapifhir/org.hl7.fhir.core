package org.hl7.fhir.convertors.conv10_30.datatypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Uri10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension10_30 {
    public static org.hl7.fhir.dstu3.model.Extension convertExtension(org.hl7.fhir.dstu2.model.Extension src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Extension tgt = new org.hl7.fhir.dstu3.model.Extension();
      Element10_30.copyElement(src, tgt);
      if (src.hasUrlElement()) tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
      if (src.hasValue()) tgt.setValue(Type10_30.convertType(src.getValue()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Extension convertExtension(org.hl7.fhir.dstu3.model.Extension src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Extension tgt = new org.hl7.fhir.dstu2.model.Extension();
      Element10_30.copyElement(src, tgt);
      if (src.hasUrlElement()) tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
      if (src.hasValue()) tgt.setValue(Type10_30.convertType(src.getValue()));
      return tgt;
    }
}
