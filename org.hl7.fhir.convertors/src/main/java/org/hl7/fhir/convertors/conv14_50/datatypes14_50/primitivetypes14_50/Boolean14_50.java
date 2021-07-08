package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean14_50 {
    public static org.hl7.fhir.r5.model.BooleanType convertBoolean(org.hl7.fhir.dstu2016may.model.BooleanType src) throws FHIRException {
      org.hl7.fhir.r5.model.BooleanType tgt = new org.hl7.fhir.r5.model.BooleanType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.BooleanType convertBoolean(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.BooleanType tgt = new org.hl7.fhir.dstu2016may.model.BooleanType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_50.copyElement(src, tgt);
      return tgt;
    }
}
