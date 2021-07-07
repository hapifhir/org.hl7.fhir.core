package org.hl7.fhir.convertors.conv10_50.datatypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complexTypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Immunization;

import java.util.List;

public class Reference10_50 {
    public static org.hl7.fhir.r5.model.Reference convertReference(org.hl7.fhir.dstu2.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Reference tgt = new org.hl7.fhir.r5.model.Reference();
      Element10_50.copyElement(src, tgt);
      tgt.setReference(src.getReference());
      if (src.hasDisplayElement()) tgt.setDisplayElement(String10_50.convertString(src.getDisplayElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Reference convertReference(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Reference tgt = new org.hl7.fhir.dstu2.model.Reference();
      Element10_50.copyElement(src, tgt);
      tgt.setReference(src.getReference());
      if (src.hasDisplayElement()) tgt.setDisplayElement(String10_50.convertString(src.getDisplayElement()));
      return tgt;
    }

  static public CanonicalType convertReferenceToCanonical(Reference src) throws FHIRException {
    CanonicalType dst = new CanonicalType(src.getReference());
    Element10_50.copyElement(src, dst);
    return dst;
  }

  static public Reference convertCanonicalToReference(CanonicalType src) throws FHIRException {
    Reference dst = new Reference(src.getValue());
    Element10_50.copyElement(src, dst);
    return dst;
  }

  static public org.hl7.fhir.r5.model.Reference getPerformer(List<Immunization.ImmunizationPerformerComponent> practitioner) {
    for (Immunization.ImmunizationPerformerComponent p : practitioner) {
      if (CodeableConcept10_50.hasConcept(p.getFunction(), "http://hl7.org/fhir/v2/0443", "AP")) return p.getActor();
    }
    return null;
  }

  static public org.hl7.fhir.r5.model.Reference getRequester(List<Immunization.ImmunizationPerformerComponent> practitioner) {
    for (Immunization.ImmunizationPerformerComponent p : practitioner) {
      if (CodeableConcept10_50.hasConcept(p.getFunction(), "http://hl7.org/fhir/v2/0443", "OP")) return p.getActor();
    }
    return null;
  }
}
