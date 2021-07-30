package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Period30_40 {
  public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.dstu3.model.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime30_40.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime30_40.convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Period tgt = new org.hl7.fhir.dstu3.model.Period();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime30_40.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime30_40.convertDateTime(src.getEndElement()));
    return tgt;
  }
}
