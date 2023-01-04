package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Base64Binary43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.UnsignedInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Url43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment43_50 {
  public static org.hl7.fhir.r5.model.Attachment convertAttachment(org.hl7.fhir.r4b.model.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Attachment tgt = new org.hl7.fhir.r5.model.Attachment();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code43_50.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_50.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary43_50.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Url43_50.convertUrl(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt43_50.convertUnsignedIntToInteger64(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary43_50.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime43_50.convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Attachment convertAttachment(org.hl7.fhir.r5.model.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Attachment tgt = new org.hl7.fhir.r4b.model.Attachment();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code43_50.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_50.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary43_50.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Url43_50.convertUrl(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt43_50.convertInteger64ToUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary43_50.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime43_50.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
