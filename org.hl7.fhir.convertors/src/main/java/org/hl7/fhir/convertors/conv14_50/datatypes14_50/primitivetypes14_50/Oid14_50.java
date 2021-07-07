package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid14_50 {
    public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.dstu2016may.model.OidType src) throws FHIRException {
      org.hl7.fhir.r5.model.OidType tgt = new org.hl7.fhir.r5.model.OidType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.OidType tgt = new org.hl7.fhir.dstu2016may.model.OidType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_50.copyElement(src, tgt);
      return tgt;
    }
}
