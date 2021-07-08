package org.hl7.fhir.convertors.conv14_30.datatypes14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Reference14_30 {
    public static org.hl7.fhir.dstu3.model.Reference convertReference(org.hl7.fhir.dstu2016may.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Reference tgt = new org.hl7.fhir.dstu3.model.Reference();
      Element14_30.copyElement(src, tgt);
      if (src.hasReference()) tgt.setReference(src.getReference());
      if (src.hasDisplay()) tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Reference convertReference(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Reference tgt = new org.hl7.fhir.dstu2016may.model.Reference();
      Element14_30.copyElement(src, tgt);
      if (src.hasReference()) tgt.setReference(src.getReference());
      if (src.hasDisplay()) tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
      return tgt;
    }
}
