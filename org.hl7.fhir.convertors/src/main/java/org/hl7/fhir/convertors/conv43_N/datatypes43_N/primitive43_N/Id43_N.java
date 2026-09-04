package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Id43_N {
  public static org.hl7.fhir.model.core.IdType convertId(org.hl7.fhir.r4b.model.IdType src) throws FHIRException {
    org.hl7.fhir.model.core.IdType tgt = src.hasValue() ? new org.hl7.fhir.model.core.IdType(src.getValueAsString()) : new org.hl7.fhir.model.core.IdType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.IdType convertId(org.hl7.fhir.model.core.IdType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IdType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.model.core.StringType convertIdToString(org.hl7.fhir.r4b.model.IdType src) {
    org.hl7.fhir.model.core.StringType tgt = src.hasValue() ? new org.hl7.fhir.model.core.StringType(src.getValueAsString()) : new org.hl7.fhir.model.core.StringType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.r4b.model.IdType convertId(org.hl7.fhir.model.core.StringType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IdType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  public static org.hl7.fhir.model.core.IdType convertId(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.IdType tgt = src.hasValue() ? new org.hl7.fhir.model.core.IdType(src.getValueAsString()) : new org.hl7.fhir.model.core.IdType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.model.core.CodeType convertIdToCode(org.hl7.fhir.r4b.model.IdType src) {
    org.hl7.fhir.model.core.CodeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CodeType(src.getValueAsString()) : new org.hl7.fhir.model.core.CodeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.r4b.model.IdType convertId(org.hl7.fhir.model.core.CodeType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IdType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

}
