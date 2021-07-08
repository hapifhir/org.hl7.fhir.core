package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.*;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment10_40 {
    public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.dstu2.model.Attachment src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
      Element10_40.copyElement(src, tgt);
      if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code10_40.convertCode(src.getContentTypeElement()));
      if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_40.convertCode(src.getLanguageElement()));
      if (src.hasDataElement()) tgt.setDataElement(Base64Binary10_40.convertBase64Binary(src.getDataElement()));
      tgt.setUrl(src.getUrl());
      if (src.hasSizeElement()) tgt.setSizeElement(UnsignedInt10_40.convertUnsignedInt(src.getSizeElement()));
      if (src.hasHashElement()) tgt.setHashElement(Base64Binary10_40.convertBase64Binary(src.getHashElement()));
      if (src.hasTitleElement()) tgt.setTitleElement(String10_40.convertString(src.getTitleElement()));
      if (src.hasCreationElement()) tgt.setCreationElement(DateTime10_40.convertDateTime(src.getCreationElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Attachment tgt = new org.hl7.fhir.dstu2.model.Attachment();
      Element10_40.copyElement(src, tgt);
      if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code10_40.convertCode(src.getContentTypeElement()));
      if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_40.convertCode(src.getLanguageElement()));
      if (src.hasDataElement()) tgt.setDataElement(Base64Binary10_40.convertBase64Binary(src.getDataElement()));
      tgt.setUrl(src.getUrl());
      if (src.hasSizeElement()) tgt.setSizeElement(UnsignedInt10_40.convertUnsignedInt(src.getSizeElement()));
      if (src.hasHashElement()) tgt.setHashElement(Base64Binary10_40.convertBase64Binary(src.getHashElement()));
      if (src.hasTitleElement()) tgt.setTitleElement(String10_40.convertString(src.getTitleElement()));
      if (src.hasCreationElement()) tgt.setCreationElement(DateTime10_40.convertDateTime(src.getCreationElement()));
      return tgt;
    }
}
