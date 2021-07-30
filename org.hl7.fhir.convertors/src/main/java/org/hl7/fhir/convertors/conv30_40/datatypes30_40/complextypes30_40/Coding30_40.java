package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding30_40 {
  public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri30_40.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_40.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean30_40.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    tgt.setCode(src.getValue());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCoding()) {
      if (src.getCodingFirstRep().hasSystem()) tgt.setSystem(src.getCodingFirstRep().getSystem());
      if (src.getCodingFirstRep().hasVersion()) tgt.setVersion(src.getCodingFirstRep().getVersion());
      if (src.getCodingFirstRep().hasCode()) tgt.setCode(src.getCodingFirstRep().getCode());
      if (src.getCodingFirstRep().hasDisplay()) tgt.setDisplay(src.getCodingFirstRep().getDisplay());
      if (src.getCodingFirstRep().hasUserSelected()) tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCoding()) {
      if (src.getCodingFirstRep().hasSystem()) tgt.setSystem(src.getCodingFirstRep().getSystem());
      if (src.getCodingFirstRep().hasVersion()) tgt.setVersion(src.getCodingFirstRep().getVersion());
      if (src.getCodingFirstRep().hasCode()) tgt.setCode(src.getCodingFirstRep().getCode());
      if (src.getCodingFirstRep().hasDisplay()) tgt.setDisplay(src.getCodingFirstRep().getDisplay());
      if (src.getCodingFirstRep().hasUserSelected()) tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri30_40.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_40.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean30_40.convertBoolean(src.getUserSelectedElement()));
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
