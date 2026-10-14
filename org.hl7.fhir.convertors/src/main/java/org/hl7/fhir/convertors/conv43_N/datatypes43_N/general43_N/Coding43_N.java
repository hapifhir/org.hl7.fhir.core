package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding43_N {
  public static org.hl7.fhir.model.core.Coding convertCoding(org.hl7.fhir.r4b.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Coding tgt = new org.hl7.fhir.model.core.Coding();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean43_N.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Coding convertCoding(org.hl7.fhir.model.core.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Coding tgt = new org.hl7.fhir.r4b.model.Coding();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasSystem()) tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasVersion()) tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasCode()) tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean43_N.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.CodeableConcept convertCodingToCodeableConcept(org.hl7.fhir.r4b.model.Coding src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasSystem()) tgt.getCodingFirstRep().setSystem(src.getSystem());
    if (src.hasVersion()) tgt.getCodingFirstRep().setVersion(src.getVersion());
    if (src.hasCode()) tgt.getCodingFirstRep().setCode(src.getCode());
    if (src.hasDisplay()) tgt.getCodingFirstRep().setDisplay(src.getDisplay());
    if (src.hasUserSelected()) tgt.getCodingFirstRep().setUserSelected(src.getUserSelected());
    return tgt;
  }

  public static org.hl7.fhir.model.core.Coding convertCoding(org.hl7.fhir.r4b.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Coding tgt = new org.hl7.fhir.model.core.Coding();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasCoding()) {
      if (src.getCodingFirstRep().hasSystem()) tgt.setSystem(src.getCodingFirstRep().getSystem());
      if (src.getCodingFirstRep().hasVersion()) tgt.setVersion(src.getCodingFirstRep().getVersion());
      if (src.getCodingFirstRep().hasCode()) tgt.setCode(src.getCodingFirstRep().getCode());
      if (src.getCodingFirstRep().hasDisplay()) tgt.setDisplay(src.getCodingFirstRep().getDisplay());
      if (src.getCodingFirstRep().hasUserSelected()) tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
    }
    return tgt;
  }
  

  public static org.hl7.fhir.r4b.model.Coding convertCoding(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Coding tgt = new org.hl7.fhir.r4b.model.Coding();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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
