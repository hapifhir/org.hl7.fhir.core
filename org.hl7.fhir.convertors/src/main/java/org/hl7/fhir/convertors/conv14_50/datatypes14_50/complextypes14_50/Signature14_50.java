package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Type14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Base64Binary14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Instant14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Reference14_50;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext14_50; 

public class Signature14_50 {
    public static org.hl7.fhir.r5.model.Signature convertSignature(org.hl7.fhir.dstu2016may.model.Signature src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Signature tgt = new org.hl7.fhir.r5.model.Signature();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      for (org.hl7.fhir.dstu2016may.model.Coding t : src.getType()) tgt.addType(Coding14_50.convertCoding(t));
      if (src.hasWhenElement()) tgt.setWhenElement(Instant14_50.convertInstant(src.getWhenElement()));
      if (src.hasWhoUriType()) tgt.setWho(new org.hl7.fhir.r5.model.Reference(src.getWhoUriType().getValue()));
      else tgt.setWho(Reference14_50.convertReference(src.getWhoReference()));
      if (src.hasContentType()) tgt.setSigFormatElement(Code14_50.convertCode(src.getContentTypeElement()));
      if (src.hasBlob()) tgt.setDataElement(Base64Binary14_50.convertBase64Binary(src.getBlobElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Signature convertSignature(org.hl7.fhir.r5.model.Signature src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Signature tgt = new org.hl7.fhir.dstu2016may.model.Signature();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(Coding14_50.convertCoding(t));
      if (src.hasWhenElement()) tgt.setWhenElement(Instant14_50.convertInstant(src.getWhenElement()));
      if (src.hasWho()) tgt.setWho(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getWho()));
      if (src.hasSigFormat()) tgt.setContentTypeElement(Code14_50.convertCode(src.getSigFormatElement()));
      if (src.hasData()) tgt.setBlobElement(Base64Binary14_50.convertBase64Binary(src.getDataElement()));
      return tgt;
    }
}
