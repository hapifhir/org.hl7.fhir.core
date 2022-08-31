package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Period43_50 {
  public static org.hl7.fhir.r5.model.Period convertPeriod(org.hl7.fhir.r4b.model.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Period tgt = new org.hl7.fhir.r5.model.Period();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime43_50.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime43_50.convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Period convertPeriod(org.hl7.fhir.r5.model.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Period tgt = new org.hl7.fhir.r4b.model.Period();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime43_50.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime43_50.convertDateTime(src.getEndElement()));
    return tgt;
  }
}
