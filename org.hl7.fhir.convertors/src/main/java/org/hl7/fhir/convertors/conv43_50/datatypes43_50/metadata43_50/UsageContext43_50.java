package org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class UsageContext43_50 {
  public static org.hl7.fhir.r5.model.UsageContext convertUsageContext(org.hl7.fhir.r4b.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.UsageContext tgt = new org.hl7.fhir.r5.model.UsageContext();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding43_50.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UsageContext convertUsageContext(org.hl7.fhir.r5.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.UsageContext tgt = new org.hl7.fhir.r4b.model.UsageContext();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding43_50.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }
}
