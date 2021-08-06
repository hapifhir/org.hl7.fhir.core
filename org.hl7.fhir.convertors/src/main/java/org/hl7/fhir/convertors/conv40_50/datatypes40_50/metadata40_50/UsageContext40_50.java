package org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class UsageContext40_50 {
  public static org.hl7.fhir.r5.model.UsageContext convertUsageContext(org.hl7.fhir.r4.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.UsageContext tgt = new org.hl7.fhir.r5.model.UsageContext();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding40_50.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UsageContext convertUsageContext(org.hl7.fhir.r5.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.UsageContext tgt = new org.hl7.fhir.r4.model.UsageContext();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding40_50.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }
}
