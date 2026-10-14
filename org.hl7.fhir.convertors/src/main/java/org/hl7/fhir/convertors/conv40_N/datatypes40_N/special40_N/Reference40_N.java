package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class Reference40_N {
  public static org.hl7.fhir.model.core.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Reference tgt = new org.hl7.fhir.model.core.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String40_N.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri40_N.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.model.core.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String40_N.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri40_N.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static CodeableReference convertReferenceToCodeableReference(org.hl7.fhir.r4.model.Reference src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setReference(convertReference(src));
    return tgt;
  }
  

  public static org.hl7.fhir.model.core.CanonicalType convertReferenceToCanonical(org.hl7.fhir.r4.model.Reference src) {
    if (src == null) return null;
    org.hl7.fhir.model.core.CanonicalType tgt = new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setValue(src.getReference());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Reference convertReferenceToCanonical(org.hl7.fhir.model.core.CanonicalType src) {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setReference(src.getValue());
    return tgt;
  }
  

  static public org.hl7.fhir.r4.model.Reference convertCodeableReferenceToReference(org.hl7.fhir.model.core.CodeableReference src) {
    org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    tgt.setReference(src.getReference().getReference());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Reference convertCanonicalToReference(org.hl7.fhir.model.core.CanonicalType src) {
    org.hl7.fhir.r4.model.Reference dst = new org.hl7.fhir.r4.model.Reference(src.getValue());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, dst);
    return dst;

  }

  public static org.hl7.fhir.model.core.Reference convertReferenceFromString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Reference tgt = new org.hl7.fhir.model.core.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setReference(src.primitiveValue());
    return tgt;
  }



}
