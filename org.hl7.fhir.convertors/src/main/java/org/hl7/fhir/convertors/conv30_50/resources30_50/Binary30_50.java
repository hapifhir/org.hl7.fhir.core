package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Base64Binary30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Binary30_50 {

  public static org.hl7.fhir.r5.model.Binary convertBinary(org.hl7.fhir.dstu3.model.Binary src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Binary tgt = new org.hl7.fhir.r5.model.Binary();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyResource(src, tgt);
    if (src.hasContentType())
      tgt.setContentTypeElement(Code30_50.convertCode(src.getContentTypeElement()));
    if (src.hasSecurityContext())
      tgt.setSecurityContext(Reference30_50.convertReference(src.getSecurityContext()));
    if (src.hasContent())
      tgt.setDataElement(Base64Binary30_50.convertBase64Binary(src.getContentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Binary convertBinary(org.hl7.fhir.r5.model.Binary src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Binary tgt = new org.hl7.fhir.dstu3.model.Binary();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyResource(src, tgt);
    if (src.hasContentType())
      tgt.setContentTypeElement(Code30_50.convertCode(src.getContentTypeElement()));
    if (src.hasSecurityContext())
      tgt.setSecurityContext(Reference30_50.convertReference(src.getSecurityContext()));
    if (src.hasData())
      tgt.setContentElement(Base64Binary30_50.convertBase64Binary(src.getDataElement()));
    return tgt;
  }
}