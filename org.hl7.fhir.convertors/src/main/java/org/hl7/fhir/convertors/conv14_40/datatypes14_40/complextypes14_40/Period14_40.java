package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.DateTime14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Period14_40 {
    public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.dstu2016may.model.Period src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
      Element14_40.copyElement(src, tgt);
      if (src.hasStart()) tgt.setStartElement(DateTime14_40.convertDateTime(src.getStartElement()));
      if (src.hasEnd()) tgt.setEndElement(DateTime14_40.convertDateTime(src.getEndElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Period tgt = new org.hl7.fhir.dstu2016may.model.Period();
      Element14_40.copyElement(src, tgt);
      if (src.hasStart()) tgt.setStartElement(DateTime14_40.convertDateTime(src.getStartElement()));
      if (src.hasEnd()) tgt.setEndElement(DateTime14_40.convertDateTime(src.getEndElement()));
      return tgt;
    }
}
