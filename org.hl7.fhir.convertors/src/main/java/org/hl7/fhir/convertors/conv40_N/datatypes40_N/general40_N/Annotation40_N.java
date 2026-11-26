package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation40_N {
  public static org.hl7.fhir.model.core.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Annotation tgt = new org.hl7.fhir.model.core.Annotation();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "author", tgt, tgt.getExtension());
    if (src.hasTime()) tgt.setTimeElement(DateTime40_N.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setTextElement(MarkDown40_N.convertMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.model.core.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "author", tgt, tgt.getExtension());
    if (src.hasTime()) tgt.setTimeElement(DateTime40_N.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setTextElement(MarkDown40_N.convertMarkdown(src.getTextElement()));
    return tgt;
  }
}
