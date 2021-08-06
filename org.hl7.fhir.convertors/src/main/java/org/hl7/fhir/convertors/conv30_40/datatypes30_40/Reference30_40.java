package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Reference30_40 {
  public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReference(src.getReference());
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_40.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Reference tgt = new org.hl7.fhir.dstu3.model.Reference();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReference(src.getReference());
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_40.convertString(src.getDisplayElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.CanonicalType convertReferenceToCanonical(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
    org.hl7.fhir.r4.model.CanonicalType dst = new org.hl7.fhir.r4.model.CanonicalType(src.getReference());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, dst);
    return dst;
  }

  static public org.hl7.fhir.dstu3.model.Reference convertCanonicalToReference(org.hl7.fhir.r4.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.Reference dst = new org.hl7.fhir.dstu3.model.Reference(src.getValue());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, dst);
    return dst;
  }
}
