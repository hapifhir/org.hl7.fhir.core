package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean14_40 {
    public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.dstu2016may.model.BooleanType src) throws FHIRException {
      org.hl7.fhir.r4.model.BooleanType tgt = new org.hl7.fhir.r4.model.BooleanType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.BooleanType tgt = new org.hl7.fhir.dstu2016may.model.BooleanType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_40.copyElement(src, tgt);
      return tgt;
    }
}
