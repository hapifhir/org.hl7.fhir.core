package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding10_50 {
  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu2.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasVersionElement()) tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement()) tgt.setDisplayElement(String10_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelectedElement())
      tgt.setUserSelectedElement(Boolean10_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Coding convertCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Coding tgt = new org.hl7.fhir.dstu2.model.Coding();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasVersionElement()) tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement()) tgt.setDisplayElement(String10_50.convertString(src.getDisplayElement()));
    if (src.hasUserSelectedElement())
      tgt.setUserSelectedElement(Boolean10_50.convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }
}
