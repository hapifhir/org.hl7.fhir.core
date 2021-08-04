package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class UsageContext30_50 {
  public static org.hl7.fhir.r5.model.UsageContext convertUsageContext(org.hl7.fhir.dstu3.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.UsageContext tgt = new org.hl7.fhir.r5.model.UsageContext();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding30_50.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UsageContext convertUsageContext(org.hl7.fhir.r5.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.UsageContext tgt = new org.hl7.fhir.dstu3.model.UsageContext();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding30_50.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    return tgt;
  }
}
