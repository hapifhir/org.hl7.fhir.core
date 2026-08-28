package org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class UsageContext40_N {
  public static org.hl7.fhir.model.core.UsageContext convertUsageContext(org.hl7.fhir.r4.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.UsageContext tgt = new org.hl7.fhir.model.core.UsageContext();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding40_N.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UsageContext convertUsageContext(org.hl7.fhir.model.core.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.UsageContext tgt = new org.hl7.fhir.r4.model.UsageContext();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding40_N.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }
}
