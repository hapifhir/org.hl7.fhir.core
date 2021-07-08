package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Period10_50 {
    public static org.hl7.fhir.r5.model.Period convertPeriod(org.hl7.fhir.dstu2.model.Period src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Period tgt = new org.hl7.fhir.r5.model.Period();
      Element10_50.copyElement(src, tgt);
      if (src.hasStartElement()) tgt.setStartElement(DateTime10_50.convertDateTime(src.getStartElement()));
      if (src.hasEndElement()) tgt.setEndElement(DateTime10_50.convertDateTime(src.getEndElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Period convertPeriod(org.hl7.fhir.r5.model.Period src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Period tgt = new org.hl7.fhir.dstu2.model.Period();
      Element10_50.copyElement(src, tgt);
      if (src.hasStartElement()) tgt.setStartElement(DateTime10_50.convertDateTime(src.getStartElement()));
      if (src.hasEndElement()) tgt.setEndElement(DateTime10_50.convertDateTime(src.getEndElement()));
      return tgt;
    }
}
