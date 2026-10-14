package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Base64Binary43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Instant43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Signature43_N {
  public static org.hl7.fhir.model.core.Signature convertSignature(org.hl7.fhir.r4b.model.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Signature tgt = new org.hl7.fhir.model.core.Signature();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4b.model.Coding t : src.getType()) tgt.addType(Coding43_N.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant43_N.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(Reference43_N.convertReference(src.getWho()));
    if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Reference43_N.convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat()) tgt.setTargetFormatElement(Code43_N.convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat()) tgt.setSigFormatElement(Code43_N.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary43_N.convertBase64Binary(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Signature convertSignature(org.hl7.fhir.model.core.Signature src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Signature tgt = new org.hl7.fhir.r4b.model.Signature();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.Coding t : src.getTypeList()) tgt.addType(Coding43_N.convertCoding(t));
    if (src.hasWhen()) tgt.setWhenElement(Instant43_N.convertInstant(src.getWhenElement()));
    if (src.hasWho()) tgt.setWho(Reference43_N.convertReference(src.getWho()));
    if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Reference43_N.convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat()) tgt.setTargetFormatElement(Code43_N.convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat()) tgt.setSigFormatElement(Code43_N.convertCode(src.getSigFormatElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary43_N.convertBase64Binary(src.getDataElement()));
    return tgt;
  }
}
