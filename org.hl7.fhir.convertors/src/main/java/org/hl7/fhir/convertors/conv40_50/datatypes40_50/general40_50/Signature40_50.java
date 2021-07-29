package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Base64Binary40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Signature40_50 {
  public static org.hl7.fhir.r5.model.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Signature tgt = new org.hl7.fhir.r5.model.Signature();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(Coding40_50.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant40_50.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(Reference40_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Reference40_50.convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat()) tgt.setTargetFormatElement(Code40_50.convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat()) tgt.setSigFormatElement(Code40_50.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary40_50.convertBase64Binary(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.r5.model.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(Coding40_50.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant40_50.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(Reference40_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Reference40_50.convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat()) tgt.setTargetFormatElement(Code40_50.convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat()) tgt.setSigFormatElement(Code40_50.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary40_50.convertBase64Binary(src.getDataElement()));
    return tgt;
  }
}
