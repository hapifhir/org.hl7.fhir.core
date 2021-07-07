package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Base64Binary14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Binary14_50 {
  public static org.hl7.fhir.r5.model.Binary convertBinary(org.hl7.fhir.dstu2016may.model.Binary src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Binary tgt = new org.hl7.fhir.r5.model.Binary();
    VersionConvertor_14_50.copyResource(src, tgt);
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code14_50.convertCode(src.getContentTypeElement()));
    if (src.hasContent()) tgt.setContent(src.getContent());
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Binary convertBinary(org.hl7.fhir.r5.model.Binary src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Binary tgt = new org.hl7.fhir.dstu2016may.model.Binary();
    VersionConvertor_14_50.copyResource(src, tgt);
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code14_50.convertCode(src.getContentTypeElement()));
    tgt.setContentElement(Base64Binary14_50.convertBase64Binary(src.getContentElement()));
    return tgt;
  }
}
