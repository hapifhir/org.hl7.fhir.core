package org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension40_50 {
  public static org.hl7.fhir.r5.model.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }
}
