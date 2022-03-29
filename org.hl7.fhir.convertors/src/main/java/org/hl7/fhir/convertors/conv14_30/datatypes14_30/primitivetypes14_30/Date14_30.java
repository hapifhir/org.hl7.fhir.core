package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Date14_30 {
  public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.dstu2016may.model.DateType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.DateType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }
}
