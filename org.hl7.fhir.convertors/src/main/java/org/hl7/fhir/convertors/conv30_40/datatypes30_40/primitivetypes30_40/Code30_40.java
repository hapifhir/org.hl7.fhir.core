package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Code30_40 {
  public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValue()) : new org.hl7.fhir.r4.model.CodeType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu3.model.CodeType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }
}
