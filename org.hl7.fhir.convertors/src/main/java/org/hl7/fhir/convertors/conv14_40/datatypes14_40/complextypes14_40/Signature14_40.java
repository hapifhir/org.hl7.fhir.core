package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Type14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Base64Binary14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Code14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Instant14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Reference14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Signature14_40 {
    public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.dstu2016may.model.Signature src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
      Element14_40.copyElement(src, tgt);
      for (org.hl7.fhir.dstu2016may.model.Coding t : src.getType()) tgt.addType(Coding14_40.convertCoding(t));
      if (src.hasWhenElement()) tgt.setWhenElement(Instant14_40.convertInstant(src.getWhenElement()));
      if (src.hasWhoUriType()) tgt.setWho(new org.hl7.fhir.r4.model.Reference(src.getWhoUriType().getValue()));
      else tgt.setWho(Reference14_40.convertReference(src.getWhoReference()));
      if (src.hasContentType()) tgt.setSigFormatElement(Code14_40.convertCode(src.getContentTypeElement()));
      if (src.hasBlob()) tgt.setDataElement(Base64Binary14_40.convertBase64Binary(src.getBlobElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Signature tgt = new org.hl7.fhir.dstu2016may.model.Signature();
      Element14_40.copyElement(src, tgt);
      for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(Coding14_40.convertCoding(t));
      if (src.hasWhenElement()) tgt.setWhenElement(Instant14_40.convertInstant(src.getWhenElement()));
      if (src.hasWho()) tgt.setWho(Type14_40.convertType(src.getWho()));
      if (src.hasSigFormat()) tgt.setContentTypeElement(Code14_40.convertCode(src.getSigFormatElement()));
      if (src.hasData()) tgt.setBlobElement(Base64Binary14_40.convertBase64Binary(src.getDataElement()));
      return tgt;
    }
}
