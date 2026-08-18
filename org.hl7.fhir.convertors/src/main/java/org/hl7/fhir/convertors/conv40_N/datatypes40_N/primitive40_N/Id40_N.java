package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Id40_N {
  public static org.hl7.fhir.model.core.IdType convertId(org.hl7.fhir.r4.model.IdType src) throws FHIRException {
    org.hl7.fhir.model.core.IdType tgt = src.hasValue() ? new org.hl7.fhir.model.core.IdType(src.getValueAsString()) : new org.hl7.fhir.model.core.IdType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.model.core.IdType src) throws FHIRException {
    org.hl7.fhir.r4.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IdType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.model.core.StringType convertIdToString(org.hl7.fhir.r4.model.IdType src) {
    org.hl7.fhir.model.core.StringType tgt = src.hasValue() ? new org.hl7.fhir.model.core.StringType(src.getValueAsString()) : new org.hl7.fhir.model.core.StringType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.model.core.StringType src) throws FHIRException {
    org.hl7.fhir.r4.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IdType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  public static org.hl7.fhir.model.core.IdType convertId(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.IdType tgt = src.hasValue() ? new org.hl7.fhir.model.core.IdType(src.getValueAsString()) : new org.hl7.fhir.model.core.IdType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.model.core.CodeType convertIdToCode(org.hl7.fhir.r4.model.IdType src) {
    org.hl7.fhir.model.core.CodeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CodeType(src.getValueAsString()) : new org.hl7.fhir.model.core.CodeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.model.core.CodeType src) throws FHIRException {
    org.hl7.fhir.r4.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IdType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

}
