package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.VersionConvertor_40_50_Context;
import org.hl7.fhir.exceptions.FHIRException;

public class Code40_50 {
  public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValue()) : new org.hl7.fhir.r5.model.CodeType();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValue()) : new org.hl7.fhir.r4.model.CodeType();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeType convertResourceEnum(org.hl7.fhir.r4.model.CodeType src) {
    return Code40_50.convertCode(src);
  }

  public static org.hl7.fhir.r4.model.CodeType convertResourceEnum(org.hl7.fhir.r5.model.CodeType src) {
    return Code40_50.convertCode(src);
  }
}
