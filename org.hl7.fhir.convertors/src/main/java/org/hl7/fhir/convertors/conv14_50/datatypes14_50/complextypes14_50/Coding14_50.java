package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Boolean14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding14_50 {
  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu2016may.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri14_50.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String14_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean14_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Coding convertCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Coding tgt = new org.hl7.fhir.dstu2016may.model.Coding();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri14_50.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String14_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean14_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }
}
