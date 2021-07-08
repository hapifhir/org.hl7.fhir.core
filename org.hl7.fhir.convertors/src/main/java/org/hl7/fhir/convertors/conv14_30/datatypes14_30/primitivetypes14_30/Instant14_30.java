package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Instant14_30 {
    public static org.hl7.fhir.dstu3.model.InstantType convertInstant(org.hl7.fhir.dstu2016may.model.InstantType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.InstantType tgt = new org.hl7.fhir.dstu3.model.InstantType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_30.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.InstantType convertInstant(org.hl7.fhir.dstu3.model.InstantType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.InstantType tgt = new org.hl7.fhir.dstu2016may.model.InstantType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_30.copyElement(src, tgt);
      return tgt;
    }
}
