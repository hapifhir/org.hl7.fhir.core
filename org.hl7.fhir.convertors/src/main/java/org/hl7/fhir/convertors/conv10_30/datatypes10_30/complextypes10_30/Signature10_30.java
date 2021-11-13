package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Base64Binary10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Code10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Instant10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Signature10_30 {
  public static org.hl7.fhir.dstu3.model.Signature convertSignature(org.hl7.fhir.dstu2.model.Signature src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Signature tgt = new org.hl7.fhir.dstu3.model.Signature();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(Coding10_30.convertCoding(t));
    if (src.hasWhenElement()) tgt.setWhenElement(Instant10_30.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getWho()));
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code10_30.convertCode(src.getContentTypeElement()));
    if (src.hasBlobElement()) tgt.setBlobElement(Base64Binary10_30.convertBase64Binary(src.getBlobElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Signature convertSignature(org.hl7.fhir.dstu3.model.Signature src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Signature tgt = new org.hl7.fhir.dstu2.model.Signature();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(Coding10_30.convertCoding(t));
    if (src.hasWhenElement()) tgt.setWhenElement(Instant10_30.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getWho()));
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code10_30.convertCode(src.getContentTypeElement()));
    if (src.hasBlobElement()) tgt.setBlobElement(Base64Binary10_30.convertBase64Binary(src.getBlobElement()));
    return tgt;
  }
}
