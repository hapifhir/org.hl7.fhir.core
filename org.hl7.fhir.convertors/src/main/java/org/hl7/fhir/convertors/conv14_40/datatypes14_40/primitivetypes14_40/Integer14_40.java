package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer14_40 {
  public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.dstu2016may.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r4.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IntegerType();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.IntegerType();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    return tgt;
  }
}
