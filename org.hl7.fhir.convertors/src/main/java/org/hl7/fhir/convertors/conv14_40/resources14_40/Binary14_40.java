package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Code14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;

public class Binary14_40 {
  public static org.hl7.fhir.r4.model.Binary convertBinary(org.hl7.fhir.dstu2016may.model.Binary src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Binary tgt = new org.hl7.fhir.r4.model.Binary();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyResource(src, tgt);
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code14_40.convertCode(src.getContentTypeElement()));
    tgt.setContent(src.getContent());
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Binary convertBinary(org.hl7.fhir.r4.model.Binary src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Binary tgt = new org.hl7.fhir.dstu2016may.model.Binary();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyResource(src, tgt);
    if (src.hasContentTypeElement()) tgt.setContentTypeElement(Code14_40.convertCode(src.getContentTypeElement()));
    tgt.setContent(src.getContent());
    return tgt;
  }
}
