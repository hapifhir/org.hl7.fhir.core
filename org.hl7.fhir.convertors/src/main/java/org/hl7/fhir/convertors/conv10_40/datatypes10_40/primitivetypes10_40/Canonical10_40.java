package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CanonicalType;

public class Canonical10_40 {
  static public CanonicalType convertReferenceToCanonical(Reference src) throws FHIRException {
    CanonicalType dst = new CanonicalType(src.getReference());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, dst);
    return dst;
  }

  static public Reference convertCanonicalToReference(CanonicalType src) throws FHIRException {
    Reference dst = new Reference(src.getValueAsString());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, dst);
    return dst;
  }
}
