package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Type10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation10_40 {
    public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.dstu2.model.Annotation src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
      Element10_40.copyElement(src, tgt);
      if (src.hasAuthor()) tgt.setAuthor(Type10_40.convertType(src.getAuthor()));
      if (src.hasTimeElement()) tgt.setTimeElement(DateTime10_40.convertDateTime(src.getTimeElement()));
      tgt.setText(src.getText());
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Annotation tgt = new org.hl7.fhir.dstu2.model.Annotation();
      Element10_40.copyElement(src, tgt);
      if (src.hasAuthor()) tgt.setAuthor(Type10_40.convertType(src.getAuthor()));
      if (src.hasTimeElement()) tgt.setTimeElement(DateTime10_40.convertDateTime(src.getTimeElement()));
      tgt.setText(src.getText());
      return tgt;
    }
}
