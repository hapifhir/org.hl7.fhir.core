package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri14_40 {
    public static org.hl7.fhir.r4.model.UriType convertUri(org.hl7.fhir.dstu2016may.model.UriType src) throws FHIRException {
      org.hl7.fhir.r4.model.UriType tgt = new org.hl7.fhir.r4.model.UriType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UriType convertUri(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.UriType tgt = new org.hl7.fhir.dstu2016may.model.UriType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_40.copyElement(src, tgt);
      return tgt;
    }
}
