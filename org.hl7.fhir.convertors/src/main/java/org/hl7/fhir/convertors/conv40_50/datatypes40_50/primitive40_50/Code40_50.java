package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Code40_50 {
  public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.CodeType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeType convertResourceEnum(org.hl7.fhir.r4.model.CodeType src) {
    return Code40_50.convertCode(src);
  }

  public static org.hl7.fhir.r4.model.CodeType convertResourceEnum(org.hl7.fhir.r5.model.CodeType src) {
    return Code40_50.convertCode(src);
  }
}
