package org.hl7.fhir.convertors.conv10_30.datatypes10_30;

import org.hl7.fhir.exceptions.FHIRException;

public class Element10_30 {
  public static void copyElement(org.hl7.fhir.dstu2.model.Element src, org.hl7.fhir.dstu3.model.Element tgt) throws FHIRException {
    tgt.setId(src.getId());
    for (org.hl7.fhir.dstu2.model.Extension e : src.getExtension()) {
      tgt.addExtension(Extension10_30.convertExtension(e));
    }
  }

  public static void copyElement(org.hl7.fhir.dstu3.model.Element src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
    tgt.setId(src.getId());
    for (org.hl7.fhir.dstu3.model.Extension e : src.getExtension()) {
      tgt.addExtension(Extension10_30.convertExtension(e));
    }
  }

  public static void copyElement(org.hl7.fhir.dstu3.model.DomainResource src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
    tgt.setId(src.getId());
    for (org.hl7.fhir.dstu3.model.Extension e : src.getExtension()) {
      tgt.addExtension(Extension10_30.convertExtension(e));
    }
  }
}
