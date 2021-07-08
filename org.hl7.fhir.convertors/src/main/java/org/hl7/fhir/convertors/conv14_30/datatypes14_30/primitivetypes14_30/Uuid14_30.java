package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Uuid14_30 {
    public static org.hl7.fhir.dstu3.model.UuidType convertUuid(org.hl7.fhir.dstu2016may.model.UuidType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.UuidType tgt = new org.hl7.fhir.dstu3.model.UuidType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_30.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UuidType convertUuid(org.hl7.fhir.dstu3.model.UuidType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.UuidType tgt = new org.hl7.fhir.dstu2016may.model.UuidType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_30.copyElement(src, tgt);
      return tgt;
    }
}
