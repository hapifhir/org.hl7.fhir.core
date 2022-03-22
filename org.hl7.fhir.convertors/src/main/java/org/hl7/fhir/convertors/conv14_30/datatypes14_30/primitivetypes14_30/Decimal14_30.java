package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Decimal14_30 {
  public static org.hl7.fhir.dstu3.model.DecimalType convertDecimal(org.hl7.fhir.dstu2016may.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DecimalType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.DecimalType convertDecimal(org.hl7.fhir.dstu3.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.DecimalType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }
}
