package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Base64Binary14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Binary14_30 {
  public static org.hl7.fhir.dstu3.model.Binary convertBinary(org.hl7.fhir.dstu2016may.model.Binary src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Binary tgt = new org.hl7.fhir.dstu3.model.Binary();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyResource(src, tgt);
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code14_30.convertCode(src.getContentTypeElement()));
    if (src.hasContentElement()) tgt.setContentElement(Base64Binary14_30.convertBase64Binary(src.getContentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Binary convertBinary(org.hl7.fhir.dstu3.model.Binary src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Binary tgt = new org.hl7.fhir.dstu2016may.model.Binary();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyResource(src, tgt);
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code14_30.convertCode(src.getContentTypeElement()));
    if (src.hasContentElement()) tgt.setContentElement(Base64Binary14_30.convertBase64Binary(src.getContentElement()));
    return tgt;
  }
}
