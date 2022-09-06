package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding43_50 {
  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.r4b.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri43_50.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean43_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Coding convertCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Coding tgt = new org.hl7.fhir.r4b.model.Coding();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri43_50.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean43_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }
  

  public static org.hl7.fhir.r5.model.CodeableConcept convertCodingToCodeableConcept(org.hl7.fhir.r4b.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.getCodingFirstRep().setSystem(src.getSystem());
    if (src.hasVersion()) tgt.getCodingFirstRep().setVersion(src.getVersion());
    if (src.hasCode()) tgt.getCodingFirstRep().setCode(src.getCode());
    if (src.hasDisplay()) tgt.getCodingFirstRep().setDisplay(src.getDisplay());
    if (src.hasUserSelected()) tgt.getCodingFirstRep().setUserSelected(src.getUserSelected());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.r4b.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasCoding()) {
      if (src.getCodingFirstRep().hasSystem()) tgt.setSystem(src.getCodingFirstRep().getSystem());
      if (src.getCodingFirstRep().hasVersion()) tgt.setVersion(src.getCodingFirstRep().getVersion());
      if (src.getCodingFirstRep().hasCode()) tgt.setCode(src.getCodingFirstRep().getCode());
      if (src.getCodingFirstRep().hasDisplay()) tgt.setDisplay(src.getCodingFirstRep().getDisplay());
      if (src.getCodingFirstRep().hasUserSelected()) tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
    }
    return tgt;
  }
  

  public static org.hl7.fhir.r4b.model.Coding convertCoding(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Coding tgt = new org.hl7.fhir.r4b.model.Coding();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
