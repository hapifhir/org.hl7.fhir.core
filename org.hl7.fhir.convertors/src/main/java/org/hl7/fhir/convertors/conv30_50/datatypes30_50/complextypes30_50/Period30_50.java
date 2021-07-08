package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Period30_50 {
    public static org.hl7.fhir.r5.model.Period convertPeriod(org.hl7.fhir.dstu3.model.Period src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.Period tgt = new org.hl7.fhir.r5.model.Period();
      Element30_50.copyElement(src, tgt);
      if (src.hasStart()) tgt.setStartElement(DateTime30_50.convertDateTime(src.getStartElement()));
      if (src.hasEnd()) tgt.setEndElement(DateTime30_50.convertDateTime(src.getEndElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Period convertPeriod(org.hl7.fhir.r5.model.Period src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Period tgt = new org.hl7.fhir.dstu3.model.Period();
      Element30_50.copyElement(src, tgt);
      if (src.hasStart()) tgt.setStartElement(DateTime30_50.convertDateTime(src.getStartElement()));
      if (src.hasEnd()) tgt.setEndElement(DateTime30_50.convertDateTime(src.getEndElement()));
      return tgt;
    }
}
