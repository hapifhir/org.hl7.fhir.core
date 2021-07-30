package org.hl7.fhir.convertors.conv14_40.datatypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.dstu2016may.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.r4.model.CanonicalType;

public class Reference14_40 {
    public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.dstu2016may.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.hasReference()) tgt.setReference(src.getReference());
      if (src.hasDisplay()) tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Reference tgt = new org.hl7.fhir.dstu2016may.model.Reference();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.hasReference()) tgt.setReference(src.getReference());
      if (src.hasDisplay()) tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
      return tgt;
    }

  static public CanonicalType convertReferenceToCanonical(Reference src) throws FHIRException {
    CanonicalType dst = new CanonicalType(src.getReference());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, dst);
    return dst;
  }

  static public Reference convertCanonicalToReference(CanonicalType src) throws FHIRException {
    Reference dst = new Reference(src.getValue());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, dst);
    return dst;
  }
}
