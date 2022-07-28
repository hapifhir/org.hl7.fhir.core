package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Base64Binary43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Signature43_50 {
  public static org.hl7.fhir.r5.model.Signature convertSignature(org.hl7.fhir.r4b.model.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Signature tgt = new org.hl7.fhir.r5.model.Signature();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    for (org.hl7.fhir.r4b.model.Coding t : src.getType()) tgt.addType(Coding43_50.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant43_50.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(Reference43_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Reference43_50.convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat()) tgt.setTargetFormatElement(Code43_50.convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat()) tgt.setSigFormatElement(Code43_50.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary43_50.convertBase64Binary(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Signature convertSignature(org.hl7.fhir.r5.model.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Signature tgt = new org.hl7.fhir.r4b.model.Signature();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(Coding43_50.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant43_50.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(Reference43_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Reference43_50.convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat()) tgt.setTargetFormatElement(Code43_50.convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat()) tgt.setSigFormatElement(Code43_50.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary43_50.convertBase64Binary(src.getDataElement()));
    return tgt;
  }
}
