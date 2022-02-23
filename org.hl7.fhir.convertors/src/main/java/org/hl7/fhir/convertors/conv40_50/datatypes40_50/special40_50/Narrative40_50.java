package org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Narrative40_50 {
  public static org.hl7.fhir.r5.model.Narrative convertNarrative(org.hl7.fhir.r4.model.Narrative src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Narrative tgt = new org.hl7.fhir.r5.model.Narrative();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasStatus()) tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
    if (src.hasDiv()) tgt.setDiv(xhtml40_50.convertXhtml(src.getDiv()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Narrative convertNarrative(org.hl7.fhir.r5.model.Narrative src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Narrative tgt = new org.hl7.fhir.r4.model.Narrative();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasStatus()) tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
    if (src.hasDiv()) tgt.setDiv(xhtml40_50.convertXhtml(src.getDiv()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Narrative.NarrativeStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Narrative.NarrativeStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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
}
