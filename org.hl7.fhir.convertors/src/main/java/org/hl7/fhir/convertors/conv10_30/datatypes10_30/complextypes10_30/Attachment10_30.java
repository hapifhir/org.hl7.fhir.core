package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.*;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment10_30 {
    public static org.hl7.fhir.dstu3.model.Attachment convertAttachment(org.hl7.fhir.dstu2.model.Attachment src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Attachment tgt = new org.hl7.fhir.dstu3.model.Attachment();
      Element10_30.copyElement(src, tgt);
      if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code10_30.convertCode(src.getContentTypeElement()));
      if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_30.convertCode(src.getLanguageElement()));
      if (src.hasDataElement()) tgt.setDataElement(Base64Binary10_30.convertBase64Binary(src.getDataElement()));
      if (src.hasUrlElement()) tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
      if (src.hasSizeElement()) tgt.setSizeElement(UnsignedInt10_30.convertUnsignedInt(src.getSizeElement()));
      if (src.hasHashElement()) tgt.setHashElement(Base64Binary10_30.convertBase64Binary(src.getHashElement()));
      if (src.hasTitleElement()) tgt.setTitleElement(String10_30.convertString(src.getTitleElement()));
      if (src.hasCreationElement()) tgt.setCreationElement(DateTime10_30.convertDateTime(src.getCreationElement()));
      return tgt;
    }

  public static org.hl7.fhir.dstu2.model.Attachment convertAttachment(org.hl7.fhir.dstu3.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Attachment tgt = new org.hl7.fhir.dstu2.model.Attachment();
    Element10_30.copyElement(src, tgt);
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code10_30.convertCode(src.getContentTypeElement()));
    if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_30.convertCode(src.getLanguageElement()));
    if (src.hasDataElement()) tgt.setDataElement(Base64Binary10_30.convertBase64Binary(src.getDataElement()));
    if (src.hasUrlElement()) tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
    if (src.hasSizeElement()) tgt.setSizeElement(UnsignedInt10_30.convertUnsignedInt(src.getSizeElement()));
    if (src.hasHashElement()) tgt.setHashElement(Base64Binary10_30.convertBase64Binary(src.getHashElement()));
    if (src.hasTitleElement()) tgt.setTitleElement(String10_30.convertString(src.getTitleElement()));
    if (src.hasCreationElement()) tgt.setCreationElement(DateTime10_30.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
