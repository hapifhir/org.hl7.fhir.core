package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Immunization;

import java.util.List;

public class Reference10_40 {
    public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.dstu2.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
      Element10_40.copyElement(src, tgt);
      tgt.setReference(src.getReference());
      if (src.hasDisplayElement()) tgt.setDisplayElement(String10_40.convertString(src.getDisplayElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Reference tgt = new org.hl7.fhir.dstu2.model.Reference();
      Element10_40.copyElement(src, tgt);
      tgt.setReference(src.getReference());
      if (src.hasDisplayElement()) tgt.setDisplayElement(String10_40.convertString(src.getDisplayElement()));
      return tgt;
    }

  static public org.hl7.fhir.r4.model.Reference getPerformer(List<Immunization.ImmunizationPerformerComponent> practitioner) {
    for (Immunization.ImmunizationPerformerComponent p : practitioner) {
      if (CodeableConcept10_40.hasConcept(p.getFunction(), "http://hl7.org/fhir/v2/0443", "AP")) return p.getActor();
    }
    return null;
  }

  static public org.hl7.fhir.r4.model.Reference getRequester(List<Immunization.ImmunizationPerformerComponent> practitioner) {
    for (Immunization.ImmunizationPerformerComponent p : practitioner) {
      if (CodeableConcept10_40.hasConcept(p.getFunction(), "http://hl7.org/fhir/v2/0443", "OP")) return p.getActor();
    }
    return null;
  }
}
