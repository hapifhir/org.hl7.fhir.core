package org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension43_50 {
  public static org.hl7.fhir.r5.model.Extension convertExtension(org.hl7.fhir.r4b.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Extension convertExtension(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Extension tgt = new org.hl7.fhir.r4b.model.Extension();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }
}
