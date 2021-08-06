package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.DateTime14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Period14_50 {
  public static org.hl7.fhir.r5.model.Period convertPeriod(org.hl7.fhir.dstu2016may.model.Period src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Period tgt = new org.hl7.fhir.r5.model.Period();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime14_50.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime14_50.convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Period convertPeriod(org.hl7.fhir.r5.model.Period src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Period tgt = new org.hl7.fhir.dstu2016may.model.Period();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime14_50.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime14_50.convertDateTime(src.getEndElement()));
    return tgt;
  }
}
