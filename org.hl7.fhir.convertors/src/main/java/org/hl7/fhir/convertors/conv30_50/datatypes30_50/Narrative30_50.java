package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Narrative30_50 {
    public static org.hl7.fhir.r5.model.Narrative convertNarrative(org.hl7.fhir.dstu3.model.Narrative src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.Narrative tgt = new org.hl7.fhir.r5.model.Narrative();
      Element30_50.copyElement(src, tgt);
      if (src.hasStatus()) tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
      if (src.hasDiv()) tgt.setDiv(src.getDiv());
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Narrative convertNarrative(org.hl7.fhir.r5.model.Narrative src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Narrative tgt = new org.hl7.fhir.dstu3.model.Narrative();
      Element30_50.copyElement(src, tgt);
      if (src.hasStatus()) tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
      if (src.hasDiv()) tgt.setDiv(src.getDiv());
      return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Narrative.NarrativeStatusEnumFactory());
      Element30_50.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.NULL);
      } else {
        switch (src.getValue()) {
          case GENERATED:
            tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.GENERATED);
            break;
          case EXTENSIONS:
            tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.EXTENSIONS);
            break;
          case ADDITIONAL:
            tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.ADDITIONAL);
            break;
          case EMPTY:
            tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.EMPTY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Narrative.NarrativeStatusEnumFactory());
      Element30_50.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.NULL);
      } else {
        switch (src.getValue()) {
          case GENERATED:
            tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.GENERATED);
            break;
          case EXTENSIONS:
            tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.EXTENSIONS);
            break;
          case ADDITIONAL:
            tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.ADDITIONAL);
            break;
          case EMPTY:
            tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.EMPTY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.NULL);
            break;
        }
      }
      return tgt;
    }
}
