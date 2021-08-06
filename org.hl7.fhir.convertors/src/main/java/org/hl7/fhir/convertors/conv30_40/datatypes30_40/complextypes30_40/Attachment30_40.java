package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment30_40 {
  public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.dstu3.model.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code30_40.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code30_40.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary30_40.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrl(src.getUrl());
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt30_40.convertUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary30_40.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime30_40.convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Attachment tgt = new org.hl7.fhir.dstu3.model.Attachment();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code30_40.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code30_40.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary30_40.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrl(src.getUrl());
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt30_40.convertUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary30_40.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime30_40.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
