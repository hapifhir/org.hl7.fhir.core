package org.hl7.fhir.convertors.conv14_30.datatypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Uri14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension14_30 {
  public static org.hl7.fhir.dstu3.model.Extension convertExtension(org.hl7.fhir.dstu2016may.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Extension tgt = new org.hl7.fhir.dstu3.model.Extension();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasUrlElement()) tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Extension convertExtension(org.hl7.fhir.dstu3.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Extension tgt = new org.hl7.fhir.dstu2016may.model.Extension();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasUrlElement()) tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getValue()));
    return tgt;
  }
}
