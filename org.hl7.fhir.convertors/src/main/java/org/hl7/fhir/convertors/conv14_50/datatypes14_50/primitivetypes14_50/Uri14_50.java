package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri14_50 {
    public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.dstu2016may.model.UriType src) throws FHIRException {
      org.hl7.fhir.r5.model.UriType tgt = new org.hl7.fhir.r5.model.UriType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.UriType tgt = new org.hl7.fhir.dstu2016may.model.UriType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_50.copyElement(src, tgt);
      return tgt;
    }
}
