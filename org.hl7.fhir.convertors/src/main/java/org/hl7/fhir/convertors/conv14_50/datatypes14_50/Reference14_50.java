package org.hl7.fhir.convertors.conv14_50.datatypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.dstu2016may.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;

public class Reference14_50 {
    public static org.hl7.fhir.r5.model.Reference convertReference(org.hl7.fhir.dstu2016may.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Reference tgt = new org.hl7.fhir.r5.model.Reference();
      Element14_50.copyElement(src, tgt);
      if (src.hasReference()) tgt.setReference(src.getReference());
      if (src.hasDisplay()) tgt.setDisplayElement(String14_50.convertString(src.getDisplayElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Reference convertReference(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Reference tgt = new org.hl7.fhir.dstu2016may.model.Reference();
      Element14_50.copyElement(src, tgt);
      if (src.hasReference()) tgt.setReference(src.getReference());
      if (src.hasDisplay()) tgt.setDisplayElement(String14_50.convertString(src.getDisplayElement()));
      return tgt;
    }

  static public CanonicalType convertReferenceToCanonical(Reference src) throws FHIRException {
    CanonicalType dst = new CanonicalType(src.getReference());
    Element14_50.copyElement(src, dst);
    return dst;
  }

  static public Reference convertCanonicalToReference(CanonicalType src) throws FHIRException {
    Reference dst = new Reference(src.getValue());
    Element14_50.copyElement(src, dst);
    return dst;
  }
}
