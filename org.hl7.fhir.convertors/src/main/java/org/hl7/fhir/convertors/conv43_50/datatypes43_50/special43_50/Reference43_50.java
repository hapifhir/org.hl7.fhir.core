package org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Reference;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeableReference;

public class Reference43_50 {
  public static org.hl7.fhir.r5.model.Reference convertReference(org.hl7.fhir.r4b.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Reference tgt = new org.hl7.fhir.r5.model.Reference();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String43_50.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri43_50.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Reference convertReference(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Reference tgt = new org.hl7.fhir.r4b.model.Reference();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String43_50.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri43_50.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static CodeableReference convertReferenceToCodeableReference(org.hl7.fhir.r4b.model.Reference src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setReference(convertReference(src));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CanonicalType convertReferenceToCanonical(org.hl7.fhir.r4b.model.Reference src) {
    if (src == null) return null;
    org.hl7.fhir.r5.model.CanonicalType tgt = new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasReference()) tgt.setValue(src.getReference());
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Reference convertReferenceToCanonical(org.hl7.fhir.r5.model.CanonicalType src) {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Reference tgt = new org.hl7.fhir.r4b.model.Reference();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setReference(src.getValue());
    return tgt;
  }
  

  static public org.hl7.fhir.r4b.model.Reference convertCodeableReferenceToReference(org.hl7.fhir.r5.model.CodeableReference src) {
    org.hl7.fhir.r4b.model.Reference tgt = new org.hl7.fhir.r4b.model.Reference();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    tgt.setReference(src.getReference().getReference());
    return tgt;
  }

  public static Reference convertCanonicalToReference(CanonicalType src) {
    org.hl7.fhir.r4b.model.Reference dst = new org.hl7.fhir.r4b.model.Reference(src.getValue());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, dst);
    return dst;

  }

  
}
