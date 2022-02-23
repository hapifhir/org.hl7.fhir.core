package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Reference30_50 {
  public static org.hl7.fhir.r5.model.Reference convertReference(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Reference tgt = new org.hl7.fhir.r5.model.Reference();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReference(src.getReference());
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Reference convertReference(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Reference tgt = new org.hl7.fhir.dstu3.model.Reference();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReference(src.getReference());
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  static public CodeableReference convertReferenceToCodableReference(org.hl7.fhir.dstu3.model.Reference src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setReference(convertReference(src));
    return tgt;
  }

  static public CodeableReference convertCodeableConceptToCodableReference(org.hl7.fhir.dstu3.model.CodeableConcept src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setConcept(CodeableConcept30_50.convertCodeableConcept(src));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CanonicalType convertReferenceToCanonical(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
    org.hl7.fhir.r5.model.CanonicalType dst = new org.hl7.fhir.r5.model.CanonicalType(src.getReference());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, dst);
    return dst;
  }

  static public org.hl7.fhir.dstu3.model.Reference convertCanonicalToReference(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.Reference dst = new org.hl7.fhir.dstu3.model.Reference(src.getValue());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, dst);
    return dst;
  }
}
