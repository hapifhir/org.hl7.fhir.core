package org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension43_N {
  public static org.hl7.fhir.model.core.Extension convertExtension(org.hl7.fhir.r4b.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Extension tgt = new org.hl7.fhir.model.core.Extension();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Extension convertExtension(org.hl7.fhir.model.core.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Extension tgt = new org.hl7.fhir.r4b.model.Extension();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }
}
