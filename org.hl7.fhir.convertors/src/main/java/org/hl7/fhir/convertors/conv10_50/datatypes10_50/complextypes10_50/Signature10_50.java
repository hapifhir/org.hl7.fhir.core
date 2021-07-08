package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Type10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Base64Binary10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Instant10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Signature10_50 {
    public static org.hl7.fhir.r5.model.Signature convertSignature(org.hl7.fhir.dstu2.model.Signature src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Signature tgt = new org.hl7.fhir.r5.model.Signature();
      Element10_50.copyElement(src, tgt);
      for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(Coding10_50.convertCoding(t));
      if (src.hasWhenElement()) tgt.setWhenElement(Instant10_50.convertInstant(src.getWhenElement()));
      if (src.hasWhoUriType()) tgt.setWho(new org.hl7.fhir.r5.model.Reference(src.getWhoUriType().getValue()));
      else tgt.setWho(Reference10_50.convertReference(src.getWhoReference()));
      if (src.hasContentTypeElement()) tgt.setSigFormatElement(Code10_50.convertCode(src.getContentTypeElement()));
      if (src.hasBlobElement()) tgt.setDataElement(Base64Binary10_50.convertBase64Binary(src.getBlobElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Signature convertSignature(org.hl7.fhir.r5.model.Signature src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Signature tgt = new org.hl7.fhir.dstu2.model.Signature();
      Element10_50.copyElement(src, tgt);
      for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(Coding10_50.convertCoding(t));
      if (src.hasWhenElement()) tgt.setWhenElement(Instant10_50.convertInstant(src.getWhenElement()));
      if (src.hasWho()) tgt.setWho(Type10_50.convertType(src.getWho()));
      if (src.hasSigFormatElement()) tgt.setContentTypeElement(Code10_50.convertCode(src.getSigFormatElement()));
      if (src.hasDataElement()) tgt.setBlobElement(Base64Binary10_50.convertBase64Binary(src.getDataElement()));
      return tgt;
    }
}
