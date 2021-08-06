package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Period10_30 {
  public static org.hl7.fhir.dstu3.model.Period convertPeriod(org.hl7.fhir.dstu2.model.Period src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Period tgt = new org.hl7.fhir.dstu3.model.Period();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasStartElement()) tgt.setStartElement(DateTime10_30.convertDateTime(src.getStartElement()));
    if (src.hasEndElement()) tgt.setEndElement(DateTime10_30.convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Period convertPeriod(org.hl7.fhir.dstu3.model.Period src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Period tgt = new org.hl7.fhir.dstu2.model.Period();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasStartElement()) tgt.setStartElement(DateTime10_30.convertDateTime(src.getStartElement()));
    if (src.hasEndElement()) tgt.setEndElement(DateTime10_30.convertDateTime(src.getEndElement()));
    return tgt;
  }
}
