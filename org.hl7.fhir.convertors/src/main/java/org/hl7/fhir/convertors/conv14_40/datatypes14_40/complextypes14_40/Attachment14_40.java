package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.*;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment14_40 {
  public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.dstu2016may.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code14_40.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_40.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary14_40.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrl(src.getUrl());
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt14_40.convertUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary14_40.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String14_40.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime14_40.convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Attachment tgt = new org.hl7.fhir.dstu2016may.model.Attachment();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code14_40.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_40.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary14_40.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrl(src.getUrl());
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt14_40.convertUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary14_40.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String14_40.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime14_40.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
