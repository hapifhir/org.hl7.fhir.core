package org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class Reference43_N {
  public static org.hl7.fhir.model.core.Reference convertReference(org.hl7.fhir.r4b.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Reference tgt = new org.hl7.fhir.model.core.Reference();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String43_N.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri43_N.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Reference convertReference(org.hl7.fhir.model.core.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Reference tgt = new org.hl7.fhir.r4b.model.Reference();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String43_N.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri43_N.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static CodeableReference convertReferenceToCodeableReference(org.hl7.fhir.r4b.model.Reference src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setReference(convertReference(src));
    return tgt;
  }
  

  public static org.hl7.fhir.model.core.CanonicalType convertReferenceToCanonical(org.hl7.fhir.r4b.model.Reference src) {
    if (src == null) return null;
    org.hl7.fhir.model.core.CanonicalType tgt = new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setValue(src.getReference());
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Reference convertReferenceToCanonical(org.hl7.fhir.model.core.CanonicalType src) {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Reference tgt = new org.hl7.fhir.r4b.model.Reference();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setReference(src.getValue());
    return tgt;
  }
  

  static public org.hl7.fhir.r4b.model.Reference convertCodeableReferenceToReference(org.hl7.fhir.model.core.CodeableReference src) {
    org.hl7.fhir.r4b.model.Reference tgt = new org.hl7.fhir.r4b.model.Reference();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    tgt.setReference(src.getReference().getReference());
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Reference convertCanonicalToReference(org.hl7.fhir.model.core.CanonicalType src) {
    org.hl7.fhir.r4b.model.Reference dst = new org.hl7.fhir.r4b.model.Reference(src.getValue());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, dst);
    return dst;

  }

  public static org.hl7.fhir.model.core.Reference convertReferenceFromString(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Reference tgt = new org.hl7.fhir.model.core.Reference();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setReference(src.primitiveValue());
    return tgt;
  }



}
