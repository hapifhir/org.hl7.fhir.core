package org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Id43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Expression43_50 {
  public static org.hl7.fhir.r5.model.Expression convertExpression(org.hl7.fhir.r4b.model.Expression src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Expression tgt = new org.hl7.fhir.r5.model.Expression();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasDescription()) tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasName()) tgt.setNameElement(Id43_50.convertIdToCode(src.getNameElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_50.convertCode(src.getLanguageElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String43_50.convertString(src.getExpressionElement()));
    if (src.hasReference()) tgt.setReferenceElement(Uri43_50.convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Expression convertExpression(org.hl7.fhir.r5.model.Expression src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Expression tgt = new org.hl7.fhir.r4b.model.Expression();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasDescription()) tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasName()) tgt.setNameElement(Id43_50.convertId(src.getNameElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_50.convertCode(src.getLanguageElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String43_50.convertString(src.getExpressionElement()));
    if (src.hasReference()) tgt.setReferenceElement(Uri43_50.convertUri(src.getReferenceElement()));
    return tgt;
  }
}
