package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation30_40 {
    public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.dstu3.model.Annotation src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
      Element30_40.copyElement(src, tgt);
      if (src.hasAuthor()) tgt.setAuthor(Type30_40.convertType(src.getAuthor()));
      if (src.hasTime()) tgt.setTimeElement(DateTime30_40.convertDateTime(src.getTimeElement()));
      if (src.hasText()) tgt.setText(src.getText());
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Annotation tgt = new org.hl7.fhir.dstu3.model.Annotation();
      Element30_40.copyElement(src, tgt);
      if (src.hasAuthor()) tgt.setAuthor(Type30_40.convertType(src.getAuthor()));
      if (src.hasTime()) tgt.setTimeElement(DateTime30_40.convertDateTime(src.getTimeElement()));
      if (src.hasText()) tgt.setText(src.getText());
      return tgt;
    }
}
