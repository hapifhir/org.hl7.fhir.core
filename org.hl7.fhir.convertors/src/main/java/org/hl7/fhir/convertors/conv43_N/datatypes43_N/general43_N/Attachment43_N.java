package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Base64Binary43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.UnsignedInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Url43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment43_N {
  public static org.hl7.fhir.model.core.Attachment convertAttachment(org.hl7.fhir.r4b.model.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Attachment tgt = new org.hl7.fhir.model.core.Attachment();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code43_N.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary43_N.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Url43_N.convertUrl(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt43_N.convertUnsignedIntToInteger64(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary43_N.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime43_N.convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Attachment convertAttachment(org.hl7.fhir.model.core.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Attachment tgt = new org.hl7.fhir.r4b.model.Attachment();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code43_N.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary43_N.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Url43_N.convertUrl(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt43_N.convertInteger64ToUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary43_N.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime43_N.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
