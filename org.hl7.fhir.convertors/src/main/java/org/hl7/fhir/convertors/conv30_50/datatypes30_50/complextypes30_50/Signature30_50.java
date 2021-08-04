package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Base64Binary30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Instant30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Reference;

public class Signature30_50 {
  public static org.hl7.fhir.r5.model.Signature convertSignature(org.hl7.fhir.dstu3.model.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Signature tgt = new org.hl7.fhir.r5.model.Signature();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(Coding30_50.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant30_50.convertInstant(src.getWhenElement()));
    if (src.hasWho()) {
      if (src.hasWhoUriType()) tgt.setWho(new org.hl7.fhir.r5.model.Reference(src.getWhoUriType().getValue()));
      else tgt.setWho(Reference30_50.convertReference(src.getWhoReference()));
    }
    if (src.hasOnBehalfOf()) {
      if (src.hasOnBehalfOfUriType()) tgt.setOnBehalfOf(new Reference(src.getOnBehalfOfUriType().primitiveValue()));
      else tgt.setOnBehalfOf(Reference30_50.convertReference(src.getOnBehalfOfReference()));
    }
    if (src.hasContentType()) tgt.setSigFormatElement(Code30_50.convertCode(src.getContentTypeElement()));
    if (src.hasBlob()) tgt.setDataElement(Base64Binary30_50.convertBase64Binary(src.getBlobElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Signature convertSignature(org.hl7.fhir.r5.model.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Signature tgt = new org.hl7.fhir.dstu3.model.Signature();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(Coding30_50.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant30_50.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getOnBehalfOf()));
    if (src.hasSigFormat()) tgt.setContentTypeElement(Code30_50.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setBlobElement(Base64Binary30_50.convertBase64Binary(src.getDataElement()));
    return tgt;
  }
}
