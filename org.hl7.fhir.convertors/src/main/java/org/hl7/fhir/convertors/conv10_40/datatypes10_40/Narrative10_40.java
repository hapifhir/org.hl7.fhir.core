package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Narrative10_40 {
    public static org.hl7.fhir.r4.model.Narrative convertNarrative(org.hl7.fhir.dstu2.model.Narrative src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Narrative tgt = new org.hl7.fhir.r4.model.Narrative();
      Element10_40.copyElement(src, tgt);
      if (src.hasStatus()) tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
      tgt.setDiv(src.getDiv());
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Narrative convertNarrative(org.hl7.fhir.r4.model.Narrative src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Narrative tgt = new org.hl7.fhir.dstu2.model.Narrative();
      Element10_40.copyElement(src, tgt);
      if (src.hasStatus()) tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
      tgt.setDiv(src.getDiv());
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Narrative.NarrativeStatusEnumFactory());
      Element10_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.NULL);
      } else {
        switch (src.getValue()) {
          case GENERATED:
            tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.GENERATED);
            break;
          case EXTENSIONS:
            tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EXTENSIONS);
            break;
          case ADDITIONAL:
            tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.ADDITIONAL);
            break;
          case EMPTY:
            tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EMPTY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Narrative.NarrativeStatusEnumFactory());
      Element10_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.NULL);
      } else {
        switch (src.getValue()) {
          case GENERATED:
            tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.GENERATED);
            break;
          case EXTENSIONS:
            tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EXTENSIONS);
            break;
          case ADDITIONAL:
            tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.ADDITIONAL);
            break;
          case EMPTY:
            tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EMPTY);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.NULL);
            break;
        }
      }
      return tgt;
    }
}
