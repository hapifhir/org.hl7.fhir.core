package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Code14_50 {
  public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.dstu2016may.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = new org.hl7.fhir.r5.model.CodeType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.CodeType tgt = new org.hl7.fhir.dstu2016may.model.CodeType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UriType convertCodeToUri(org.hl7.fhir.dstu2016may.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = new org.hl7.fhir.r5.model.UriType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.CodeType convertCode(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.CodeType tgt = new org.hl7.fhir.dstu2016may.model.CodeType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }
}
