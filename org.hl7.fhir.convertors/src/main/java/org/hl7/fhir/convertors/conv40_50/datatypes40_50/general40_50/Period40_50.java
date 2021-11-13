package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Period40_50 {
  public static org.hl7.fhir.r5.model.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Period tgt = new org.hl7.fhir.r5.model.Period();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime40_50.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime40_50.convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.r5.model.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime40_50.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime40_50.convertDateTime(src.getEndElement()));
    return tgt;
  }
}
