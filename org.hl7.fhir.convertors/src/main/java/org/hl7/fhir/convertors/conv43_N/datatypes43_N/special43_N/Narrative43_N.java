package org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Narrative;

public class Narrative43_N {
  public static org.hl7.fhir.model.core.Narrative convertNarrative(org.hl7.fhir.r4b.model.Narrative src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Narrative tgt = new org.hl7.fhir.model.core.Narrative();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasStatus()) tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
    if (src.hasDiv()) tgt.setDiv(xhtml43_N.convertXhtml(src.getDiv()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Narrative convertNarrative(org.hl7.fhir.model.core.Narrative src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Narrative tgt = new org.hl7.fhir.r4b.model.Narrative();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasStatus()) tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
    if (src.hasDiv()) tgt.setDiv(xhtml43_N.convertXhtml(src.getDiv()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Narrative.NarrativeStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Narrative.NarrativeStatusEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case GENERATED:
                    tgt.setValue(Narrative.NarrativeStatus.GENERATED);
                    break;
                case EXTENSIONS:
                    tgt.setValue(Narrative.NarrativeStatus.EXTENSIONS);
                    break;
                case ADDITIONAL:
                    tgt.setValue(Narrative.NarrativeStatus.ADDITIONAL);
                    break;
                case EMPTY:
                    tgt.setValue(Narrative.NarrativeStatus.EMPTY);
                    break;
                default:
                    tgt.setValue(Narrative.NarrativeStatus.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Narrative.NarrativeStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Narrative.NarrativeStatusEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case GENERATED:
                    tgt.setValue(org.hl7.fhir.r4b.model.Narrative.NarrativeStatus.GENERATED);
                    break;
                case EXTENSIONS:
                    tgt.setValue(org.hl7.fhir.r4b.model.Narrative.NarrativeStatus.EXTENSIONS);
                    break;
                case ADDITIONAL:
                    tgt.setValue(org.hl7.fhir.r4b.model.Narrative.NarrativeStatus.ADDITIONAL);
                    break;
                case EMPTY:
                    tgt.setValue(org.hl7.fhir.r4b.model.Narrative.NarrativeStatus.EMPTY);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.Narrative.NarrativeStatus.NULL);
                    break;
       }
}
    return tgt;
  }
}
