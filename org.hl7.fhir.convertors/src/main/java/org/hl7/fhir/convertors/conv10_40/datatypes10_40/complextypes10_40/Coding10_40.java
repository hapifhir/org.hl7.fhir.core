package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Code10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Uri10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class Coding10_40 {
  public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.dstu2.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_40.convertUri(src.getSystemElement()));
    if (src.hasVersionElement()) tgt.setVersionElement(String10_40.convertString(src.getVersionElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_40.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement()) tgt.setDisplayElement(String10_40.convertString(src.getDisplayElement()));
    if (src.hasUserSelectedElement())
      tgt.setUserSelectedElement(Boolean10_40.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Coding convertCoding(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Coding tgt = new org.hl7.fhir.dstu2.model.Coding();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_40.convertUri(src.getSystemElement()));
    if (src.hasVersionElement()) tgt.setVersionElement(String10_40.convertString(src.getVersionElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_40.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement()) tgt.setDisplayElement(String10_40.convertString(src.getDisplayElement()));
    if (src.hasUserSelectedElement())
      tgt.setUserSelectedElement(Boolean10_40.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }
}
