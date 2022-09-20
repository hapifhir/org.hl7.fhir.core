package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Base64Binary40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.UnsignedInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Url40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment40_50 {
  public static org.hl7.fhir.r5.model.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Attachment tgt = new org.hl7.fhir.r5.model.Attachment();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code40_50.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary40_50.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Url40_50.convertUrl(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt40_50.convertUnsignedIntToInteger64(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary40_50.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime40_50.convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.r5.model.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code40_50.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary40_50.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Url40_50.convertUrl(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt40_50.convertInteger64ToUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary40_50.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime40_50.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
