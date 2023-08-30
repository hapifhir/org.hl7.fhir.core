package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Id14_50 {
  public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.dstu2016may.model.IdType src) throws FHIRException {
    org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IdType();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.IdType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.IdType();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.StringType convertIdToString(org.hl7.fhir.dstu2016may.model.IdType src) {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.dstu2016may.model.IdType convertId(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.IdType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.IdType();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  
}
