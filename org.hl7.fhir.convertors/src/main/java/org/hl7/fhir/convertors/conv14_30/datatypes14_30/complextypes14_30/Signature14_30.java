package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Base64Binary14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Instant14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Signature14_30 {
  public static org.hl7.fhir.dstu3.model.Signature convertSignature(org.hl7.fhir.dstu2016may.model.Signature src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Signature tgt = new org.hl7.fhir.dstu3.model.Signature();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getType()) tgt.addType(Code14_30.convertCoding(t));
    if (src.hasWhenElement()) tgt.setWhenElement(Instant14_30.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getWho()));
    if (src.hasContentType()) tgt.setContentTypeElement(Code14_30.convertCode(src.getContentTypeElement()));
    if (src.hasBlob()) tgt.setBlobElement(Base64Binary14_30.convertBase64Binary(src.getBlobElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Signature convertSignature(org.hl7.fhir.dstu3.model.Signature src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Signature tgt = new org.hl7.fhir.dstu2016may.model.Signature();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(Code14_30.convertCoding(t));
    if (src.hasWhenElement()) tgt.setWhenElement(Instant14_30.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getWho()));
    if (src.hasContentType()) tgt.setContentTypeElement(Code14_30.convertCode(src.getContentTypeElement()));
    if (src.hasBlob()) tgt.setBlobElement(Base64Binary14_30.convertBase64Binary(src.getBlobElement()));
    return tgt;
  }
}
