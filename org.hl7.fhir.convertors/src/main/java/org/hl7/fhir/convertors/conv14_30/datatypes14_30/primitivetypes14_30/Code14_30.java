package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Code14_30 {
  public static org.hl7.fhir.dstu3.model.CodeType convertCode(org.hl7.fhir.dstu2016may.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.CodeType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.CodeType convertCode(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.CodeType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.dstu2016may.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean14_30.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Coding convertCoding(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Coding tgt = new org.hl7.fhir.dstu2016may.model.Coding();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean14_30.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }
}
