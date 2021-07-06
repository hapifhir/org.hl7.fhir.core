package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.exceptions.FHIRException;

public class Element10_40 {
    public static void copyElement(org.hl7.fhir.dstu2.model.Element src, org.hl7.fhir.r4.model.Element tgt) throws FHIRException {
      tgt.setId(src.getId());
      for (org.hl7.fhir.dstu2.model.Extension e : src.getExtension()) {
        tgt.addExtension(Extension10_40.convertExtension(e));
      }
    }

    public static void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
      tgt.setId(src.getId());
      for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
        tgt.addExtension(Extension10_40.convertExtension(e));
      }
    }

    public static void copyElement(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
      tgt.setId(src.getId());
      for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
        tgt.addExtension(Extension10_40.convertExtension(e));
      }
    }
}
