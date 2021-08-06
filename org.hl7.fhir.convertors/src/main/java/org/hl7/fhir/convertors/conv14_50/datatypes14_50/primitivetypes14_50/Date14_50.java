package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Date14_50 {
  public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.dstu2016may.model.DateType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateType tgt = new org.hl7.fhir.r5.model.DateType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.DateType tgt = new org.hl7.fhir.dstu2016may.model.DateType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }
}
