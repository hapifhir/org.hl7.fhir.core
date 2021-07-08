package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown14_40 {
    public static org.hl7.fhir.r4.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2016may.model.MarkdownType src) throws FHIRException {
      org.hl7.fhir.r4.model.MarkdownType tgt = new org.hl7.fhir.r4.model.MarkdownType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.MarkdownType convertMarkdown(org.hl7.fhir.r4.model.MarkdownType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.MarkdownType tgt = new org.hl7.fhir.dstu2016may.model.MarkdownType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      Element14_40.copyElement(src, tgt);
      return tgt;
    }
}
