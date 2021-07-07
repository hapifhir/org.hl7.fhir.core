package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid14_40 {
    public static org.hl7.fhir.r4.model.OidType convertOid(org.hl7.fhir.dstu2016may.model.OidType src) throws FHIRException {
      org.hl7.fhir.r4.model.OidType tgt = new org.hl7.fhir.r4.model.OidType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OidType convertOid(org.hl7.fhir.r4.model.OidType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.OidType tgt = new org.hl7.fhir.dstu2016may.model.OidType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_40.copyElement(src, tgt);
      return tgt;
    }
}
