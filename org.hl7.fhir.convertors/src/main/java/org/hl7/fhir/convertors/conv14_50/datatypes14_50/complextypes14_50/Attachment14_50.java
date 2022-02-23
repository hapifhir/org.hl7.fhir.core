package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Base64Binary14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.DateTime14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment14_50 {
  public static org.hl7.fhir.r5.model.Attachment convertAttachment(org.hl7.fhir.dstu2016may.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Attachment tgt = new org.hl7.fhir.r5.model.Attachment();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code14_50.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_50.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary14_50.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrl(src.getUrl());
    if (src.hasSize()) tgt.setSize(Long.valueOf(src.getSize()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary14_50.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String14_50.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime14_50.convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Attachment convertAttachment(org.hl7.fhir.r5.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Attachment tgt = new org.hl7.fhir.dstu2016may.model.Attachment();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code14_50.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_50.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary14_50.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrl(src.getUrl());
    if (src.hasSize()) tgt.setSize(Math.toIntExact(src.getSize()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary14_50.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String14_50.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime14_50.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
