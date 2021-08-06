package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding30_50 {
  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri30_50.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean30_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    tgt.setCode(src.getValue());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeableConcept convertCodingToCodeableConcept(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.getCodingFirstRep().setSystem(src.getSystem());
    if (src.hasVersion()) tgt.getCodingFirstRep().setVersion(src.getVersion());
    if (src.hasCode()) tgt.getCodingFirstRep().setCode(src.getCode());
    if (src.hasDisplay()) tgt.getCodingFirstRep().setDisplay(src.getDisplay());
    if (src.hasUserSelected()) tgt.getCodingFirstRep().setUserSelected(src.getUserSelected());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasCoding()) {
      if (src.getCodingFirstRep().hasSystem()) tgt.setSystem(src.getCodingFirstRep().getSystem());
      if (src.getCodingFirstRep().hasVersion()) tgt.setVersion(src.getCodingFirstRep().getVersion());
      if (src.getCodingFirstRep().hasCode()) tgt.setCode(src.getCodingFirstRep().getCode());
      if (src.getCodingFirstRep().hasDisplay()) tgt.setDisplay(src.getCodingFirstRep().getDisplay());
      if (src.getCodingFirstRep().hasUserSelected()) tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasCoding()) {
      if (src.getCodingFirstRep().hasSystem()) tgt.setSystem(src.getCodingFirstRep().getSystem());
      if (src.getCodingFirstRep().hasVersion()) tgt.setVersion(src.getCodingFirstRep().getVersion());
      if (src.getCodingFirstRep().hasCode()) tgt.setCode(src.getCodingFirstRep().getCode());
      if (src.getCodingFirstRep().hasDisplay()) tgt.setDisplay(src.getCodingFirstRep().getDisplay());
      if (src.getCodingFirstRep().hasUserSelected()) tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri30_50.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean30_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static String convertCoding2Uri(org.hl7.fhir.dstu3.model.Coding code) {
    return code.getSystem() + "/" + code.getCode();
  }

  public static org.hl7.fhir.dstu3.model.Coding convertUri2Coding(String uri) {
    int i = uri.lastIndexOf("/");
    return new org.hl7.fhir.dstu3.model.Coding().setSystem(uri.substring(0, i)).setCode(uri.substring(i + 1));
  }
}
