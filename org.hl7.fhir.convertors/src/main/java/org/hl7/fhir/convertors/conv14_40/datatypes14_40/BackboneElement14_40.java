package org.hl7.fhir.convertors.conv14_40.datatypes14_40;

import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement14_40 {
    static public void copyBackboneElement(org.hl7.fhir.dstu2016may.model.BackboneElement src, org.hl7.fhir.r4.model.BackboneElement tgt) throws FHIRException {
      Element14_40.copyElement(src, tgt);
      for (org.hl7.fhir.dstu2016may.model.Extension e : src.getModifierExtension()) {
        tgt.addModifierExtension(Extension14_40.convertExtension(e));
      }
    }

    static public void copyBackboneElement(org.hl7.fhir.r4.model.BackboneElement src, org.hl7.fhir.dstu2016may.model.BackboneElement tgt) throws FHIRException {
      Element14_40.copyElement(src, tgt);
      for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
        tgt.addModifierExtension(Extension14_40.convertExtension(e));
      }
    }
}
