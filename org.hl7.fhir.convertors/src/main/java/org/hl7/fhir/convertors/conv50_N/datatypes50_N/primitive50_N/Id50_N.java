package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Id50_N {
  public static org.hl7.fhir.model.core.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
    org.hl7.fhir.model.core.IdType tgt = src.hasValue() ? new org.hl7.fhir.model.core.IdType(src.getValueAsString()) : new org.hl7.fhir.model.core.IdType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.model.core.IdType src) throws FHIRException {
    org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IdType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.model.core.StringType convertIdToString(org.hl7.fhir.r5.model.IdType src) {
    org.hl7.fhir.model.core.StringType tgt = src.hasValue() ? new org.hl7.fhir.model.core.StringType(src.getValueAsString()) : new org.hl7.fhir.model.core.StringType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.model.core.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IdType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  public static org.hl7.fhir.model.core.IdType convertId(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.IdType tgt = src.hasValue() ? new org.hl7.fhir.model.core.IdType(src.getValueAsString()) : new org.hl7.fhir.model.core.IdType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.model.core.CodeType convertIdToCode(org.hl7.fhir.r5.model.IdType src) {
    org.hl7.fhir.model.core.CodeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CodeType(src.getValueAsString()) : new org.hl7.fhir.model.core.CodeType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.model.core.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IdType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

}
