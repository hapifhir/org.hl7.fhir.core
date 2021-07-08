package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.DateTime14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Period14_30 {
    public static org.hl7.fhir.dstu3.model.Period convertPeriod(org.hl7.fhir.dstu2016may.model.Period src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Period tgt = new org.hl7.fhir.dstu3.model.Period();
      Element14_30.copyElement(src, tgt);
      if (src.hasStart()) tgt.setStartElement(DateTime14_30.convertDateTime(src.getStartElement()));
      if (src.hasEnd()) tgt.setEndElement(DateTime14_30.convertDateTime(src.getEndElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Period convertPeriod(org.hl7.fhir.dstu3.model.Period src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Period tgt = new org.hl7.fhir.dstu2016may.model.Period();
      Element14_30.copyElement(src, tgt);
      if (src.hasStart()) tgt.setStartElement(DateTime14_30.convertDateTime(src.getStartElement()));
      if (src.hasEnd()) tgt.setEndElement(DateTime14_30.convertDateTime(src.getEndElement()));
      return tgt;
    }
}
