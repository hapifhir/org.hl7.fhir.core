package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Code10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Uri10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding10_30 {
  public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.dstu2.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
    Element10_30.copyElement(src, tgt);
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_30.convertUri(src.getSystemElement()));
    if (src.hasVersionElement()) tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_30.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement()) tgt.setDisplayElement(String10_30.convertString(src.getDisplayElement()));
    if (src.hasUserSelectedElement()) tgt.setUserSelectedElement(Boolean10_30.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Coding convertCoding(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Coding tgt = new org.hl7.fhir.dstu2.model.Coding();
    Element10_30.copyElement(src, tgt);
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_30.convertUri(src.getSystemElement()));
    if (src.hasVersionElement()) tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_30.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement()) tgt.setDisplayElement(String10_30.convertString(src.getDisplayElement()));
    if (src.hasUserSelectedElement()) tgt.setUserSelectedElement(Boolean10_30.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }
}
