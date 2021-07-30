package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer10_40 {
  public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.dstu2.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r4.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IntegerType(src.getValue()) : new org.hl7.fhir.r4.model.IntegerType();
    Element10_40.copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.IntegerType(src.getValue()) : new org.hl7.fhir.dstu2.model.IntegerType();
    Element10_40.copyElement(src, tgt);
    return tgt;
  }
}
