package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Base64Binary30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment30_50 {
    public static org.hl7.fhir.r5.model.Attachment convertAttachment(org.hl7.fhir.dstu3.model.Attachment src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.Attachment tgt = new org.hl7.fhir.r5.model.Attachment();
      Element30_50.copyElement(src, tgt);
      if (src.hasContentType()) tgt.setContentTypeElement(Code30_50.convertCode(src.getContentTypeElement()));
      if (src.hasLanguage()) tgt.setLanguageElement(Code30_50.convertCode(src.getLanguageElement()));
      if (src.hasData()) tgt.setDataElement(Base64Binary30_50.convertBase64Binary(src.getDataElement()));
      if (src.hasUrl()) tgt.setUrl(src.getUrl());
      if (src.hasSize()) tgt.setSize(Long.valueOf(src.getSize()));
      if (src.hasHash()) tgt.setHashElement(Base64Binary30_50.convertBase64Binary(src.getHashElement()));
      if (src.hasTitle()) tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
      if (src.hasCreation()) tgt.setCreationElement(DateTime30_50.convertDateTime(src.getCreationElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Attachment convertAttachment(org.hl7.fhir.r5.model.Attachment src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Attachment tgt = new org.hl7.fhir.dstu3.model.Attachment();
      Element30_50.copyElement(src, tgt);
      if (src.hasContentType()) tgt.setContentTypeElement(Code30_50.convertCode(src.getContentTypeElement()));
      if (src.hasLanguage()) tgt.setLanguageElement(Code30_50.convertCode(src.getLanguageElement()));
      if (src.hasData()) tgt.setDataElement(Base64Binary30_50.convertBase64Binary(src.getDataElement()));
      if (src.hasUrl()) tgt.setUrl(src.getUrl());
      if (src.hasSize()) tgt.setSize(Math.toIntExact(src.getSize()));
      if (src.hasHash()) tgt.setHashElement(Base64Binary30_50.convertBase64Binary(src.getHashElement()));
      if (src.hasTitle()) tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
      if (src.hasCreation()) tgt.setCreationElement(DateTime30_50.convertDateTime(src.getCreationElement()));
      return tgt;
    }
}
