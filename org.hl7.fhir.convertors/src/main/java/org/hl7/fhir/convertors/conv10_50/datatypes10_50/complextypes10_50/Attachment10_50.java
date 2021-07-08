package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Base64Binary10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment10_50 {
    public static org.hl7.fhir.r5.model.Attachment convertAttachment(org.hl7.fhir.dstu2.model.Attachment src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Attachment tgt = new org.hl7.fhir.r5.model.Attachment();
      Element10_50.copyElement(src, tgt);
      if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code10_50.convertCode(src.getContentTypeElement()));
      if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_50.convertCode(src.getLanguageElement()));
      if (src.hasDataElement()) tgt.setDataElement(Base64Binary10_50.convertBase64Binary(src.getDataElement()));
      if (src.hasUrl()) tgt.setUrl(src.getUrl());
      if (src.hasSize()) tgt.setSize(Long.valueOf(src.getSize()));
      if (src.hasHashElement()) tgt.setHashElement(Base64Binary10_50.convertBase64Binary(src.getHashElement()));
      if (src.hasTitleElement()) tgt.setTitleElement(String10_50.convertString(src.getTitleElement()));
      if (src.hasCreationElement()) tgt.setCreationElement(DateTime10_50.convertDateTime(src.getCreationElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Attachment convertAttachment(org.hl7.fhir.r5.model.Attachment src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Attachment tgt = new org.hl7.fhir.dstu2.model.Attachment();
      Element10_50.copyElement(src, tgt);
      if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code10_50.convertCode(src.getContentTypeElement()));
      if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_50.convertCode(src.getLanguageElement()));
      if (src.hasDataElement()) tgt.setDataElement(Base64Binary10_50.convertBase64Binary(src.getDataElement()));
      if (src.hasUrl()) tgt.setUrl(src.getUrl());
      if (src.hasSize()) tgt.setSize(Math.toIntExact(src.getSize()));
      if (src.hasHashElement()) tgt.setHashElement(Base64Binary10_50.convertBase64Binary(src.getHashElement()));
      if (src.hasTitleElement()) tgt.setTitleElement(String10_50.convertString(src.getTitleElement()));
      if (src.hasCreationElement()) tgt.setCreationElement(DateTime10_50.convertDateTime(src.getCreationElement()));
      return tgt;
    }
}
