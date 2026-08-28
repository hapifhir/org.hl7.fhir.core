package org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class UsageContext43_N {
  public static org.hl7.fhir.model.core.UsageContext convertUsageContext(org.hl7.fhir.r4b.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.UsageContext tgt = new org.hl7.fhir.model.core.UsageContext();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding43_N.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UsageContext convertUsageContext(org.hl7.fhir.model.core.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.UsageContext tgt = new org.hl7.fhir.r4b.model.UsageContext();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding43_N.convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }
}
