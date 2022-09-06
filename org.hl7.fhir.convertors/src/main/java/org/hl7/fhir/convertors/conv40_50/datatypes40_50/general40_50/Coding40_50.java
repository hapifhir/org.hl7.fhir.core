package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding40_50 {
  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean40_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean40_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.CodeableConcept convertCodingToCodeableConcept(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.getCodingFirstRep().setSystem(src.getSystem());
    if (src.hasVersion()) tgt.getCodingFirstRep().setVersion(src.getVersion());
    if (src.hasCode()) tgt.getCodingFirstRep().setCode(src.getCode());
    if (src.hasDisplay()) tgt.getCodingFirstRep().setDisplay(src.getDisplay());
    if (src.hasUserSelected()) tgt.getCodingFirstRep().setUserSelected(src.getUserSelected());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCoding()) {
      if (src.getCodingFirstRep().hasSystem()) tgt.setSystem(src.getCodingFirstRep().getSystem());
      if (src.getCodingFirstRep().hasVersion()) tgt.setVersion(src.getCodingFirstRep().getVersion());
      if (src.getCodingFirstRep().hasCode()) tgt.setCode(src.getCodingFirstRep().getCode());
      if (src.getCodingFirstRep().hasDisplay()) tgt.setDisplay(src.getCodingFirstRep().getDisplay());
      if (src.getCodingFirstRep().hasUserSelected()) tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
    }
    return tgt;
  }
  

  public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCoding()) {
      if (src.getCodingFirstRep().hasSystem()) tgt.setSystem(src.getCodingFirstRep().getSystem());
      if (src.getCodingFirstRep().hasVersion()) tgt.setVersion(src.getCodingFirstRep().getVersion());
      if (src.getCodingFirstRep().hasCode()) tgt.setCode(src.getCodingFirstRep().getCode());
      if (src.getCodingFirstRep().hasDisplay()) tgt.setDisplay(src.getCodingFirstRep().getDisplay());
      if (src.getCodingFirstRep().hasUserSelected()) tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
    }
    return tgt;
  }

  
}
