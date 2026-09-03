package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Base64Binary40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Signature40_N {
  public static org.hl7.fhir.model.core.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Signature tgt = new org.hl7.fhir.model.core.Signature();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(Coding40_N.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant40_N.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(Reference40_N.convertReference(src.getWho()));
    if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Reference40_N.convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat()) tgt.setTargetFormatElement(Code40_N.convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat()) tgt.setSigFormatElement(Code40_N.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary40_N.convertBase64Binary(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.model.core.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.Coding t : src.getTypeList()) tgt.addType(Coding40_N.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant40_N.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(Reference40_N.convertReference(src.getWho()));
    if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Reference40_N.convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat()) tgt.setTargetFormatElement(Code40_N.convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat()) tgt.setSigFormatElement(Code40_N.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary40_N.convertBase64Binary(src.getDataElement()));
    return tgt;
  }
}
