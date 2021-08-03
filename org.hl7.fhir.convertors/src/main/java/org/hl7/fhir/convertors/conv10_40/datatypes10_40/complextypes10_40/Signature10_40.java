package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Type10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Base64Binary10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Code10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Instant10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class Signature10_40 {
  public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.dstu2.model.Signature src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(Coding10_40.convertCoding(t));
    if (src.hasWhenElement()) tgt.setWhenElement(Instant10_40.convertInstant(src.getWhenElement()));
    if (src.hasWhoUriType()) tgt.setWho(new org.hl7.fhir.r4.model.Reference(src.getWhoUriType().getValue()));
    else tgt.setWho(Reference10_40.convertReference(src.getWhoReference()));
    if (src.hasContentTypeElement()) tgt.setSigFormatElement(Code10_40.convertCode(src.getContentTypeElement()));
    if (src.hasBlobElement()) tgt.setDataElement(Base64Binary10_40.convertBase64Binary(src.getBlobElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Signature tgt = new org.hl7.fhir.dstu2.model.Signature();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(Coding10_40.convertCoding(t));
    if (src.hasWhenElement()) tgt.setWhenElement(Instant10_40.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getWho()));
    if (src.hasSigFormatElement()) tgt.setContentTypeElement(Code10_40.convertCode(src.getSigFormatElement()));
    if (src.hasDataElement()) tgt.setBlobElement(Base64Binary10_40.convertBase64Binary(src.getDataElement()));
    return tgt;
  }
}
