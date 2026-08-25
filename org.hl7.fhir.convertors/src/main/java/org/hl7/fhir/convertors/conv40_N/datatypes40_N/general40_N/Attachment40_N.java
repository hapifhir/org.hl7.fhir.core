package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Base64Binary40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.UnsignedInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Url40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Attachment40_N {
  public static org.hl7.fhir.model.core.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Attachment tgt = new org.hl7.fhir.model.core.Attachment();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_N.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary40_N.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Url40_N.convertUrl(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt40_N.convertUnsignedIntToInteger64(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary40_N.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime40_N.convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.model.core.Attachment src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasContentType()) tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_N.convertCode(src.getLanguageElement()));
    if (src.hasData()) tgt.setDataElement(Base64Binary40_N.convertBase64Binary(src.getDataElement()));
    if (src.hasUrl()) tgt.setUrlElement(Url40_N.convertUrl(src.getUrlElement()));
    if (src.hasSize()) tgt.setSizeElement(UnsignedInt40_N.convertInteger64ToUnsignedInt(src.getSizeElement()));
    if (src.hasHash()) tgt.setHashElement(Base64Binary40_N.convertBase64Binary(src.getHashElement()));
    if (src.hasTitle()) tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasCreation()) tgt.setCreationElement(DateTime40_N.convertDateTime(src.getCreationElement()));
    return tgt;
  }
}
