package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class Period10_40 {
  public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.dstu2.model.Period src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasStartElement()) tgt.setStartElement(DateTime10_40.convertDateTime(src.getStartElement()));
    if (src.hasEndElement()) tgt.setEndElement(DateTime10_40.convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Period tgt = new org.hl7.fhir.dstu2.model.Period();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasStartElement()) tgt.setStartElement(DateTime10_40.convertDateTime(src.getStartElement()));
    if (src.hasEndElement()) tgt.setEndElement(DateTime10_40.convertDateTime(src.getEndElement()));
    return tgt;
  }
}
