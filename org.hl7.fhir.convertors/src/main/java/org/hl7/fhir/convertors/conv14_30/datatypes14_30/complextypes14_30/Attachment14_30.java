package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Base64Binary14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.DateTime14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.UnsignedInt14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Uri14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment14_30 {
  public static org.hl7.fhir.dstu3.model.Attachment convertAttachment(org.hl7.fhir.dstu2016may.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Attachment tgt = new org.hl7.fhir.dstu3.model.Attachment();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code14_30.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_30.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary14_30.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt14_30.convertUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary14_30.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String14_30.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime14_30.convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Attachment convertAttachment(org.hl7.fhir.dstu3.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Attachment tgt = new org.hl7.fhir.dstu2016may.model.Attachment();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code14_30.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_30.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary14_30.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt14_30.convertUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary14_30.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String14_30.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime14_30.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
