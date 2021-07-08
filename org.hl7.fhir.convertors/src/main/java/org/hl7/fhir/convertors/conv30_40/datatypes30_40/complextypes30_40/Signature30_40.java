package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Base64Binary30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Instant30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Reference;

public class Signature30_40 {
    public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.dstu3.model.Signature src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
      Element30_40.copyElement(src, tgt);
      for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(Coding30_40.convertCoding(t));
      if (src.hasWhen()) tgt.setWhenElement(Instant30_40.convertInstant(src.getWhenElement()));
      if (src.hasWho()) {
        if (src.hasWhoUriType()) tgt.setWho(new org.hl7.fhir.r4.model.Reference(src.getWhoUriType().getValue()));
        else tgt.setWho(Reference30_40.convertReference(src.getWhoReference()));
      }
      if (src.hasOnBehalfOf()) {
        if (src.hasOnBehalfOfUriType()) tgt.setOnBehalfOf(new Reference(src.getOnBehalfOfUriType().primitiveValue()));
        else tgt.setOnBehalfOf(Reference30_40.convertReference(src.getOnBehalfOfReference()));
      }
      if (src.hasContentType()) tgt.setSigFormatElement(Code30_40.convertCode(src.getContentTypeElement()));
      if (src.hasBlob()) tgt.setDataElement(Base64Binary30_40.convertBase64Binary(src.getBlobElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Signature tgt = new org.hl7.fhir.dstu3.model.Signature();
      Element30_40.copyElement(src, tgt);
      for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(Coding30_40.convertCoding(t));
      if (src.hasWhen()) tgt.setWhenElement(Instant30_40.convertInstant(src.getWhenElement()));
      if (src.hasWho()) tgt.setWho(Type30_40.convertType(src.getWho()));
      if (src.hasOnBehalfOf()) tgt.setOnBehalfOf(Type30_40.convertType(src.getOnBehalfOf()));
      if (src.hasSigFormat()) tgt.setContentTypeElement(Code30_40.convertCode(src.getSigFormatElement()));
      if (src.hasData()) tgt.setBlobElement(Base64Binary30_40.convertBase64Binary(src.getDataElement()));
      return tgt;
    }
}
