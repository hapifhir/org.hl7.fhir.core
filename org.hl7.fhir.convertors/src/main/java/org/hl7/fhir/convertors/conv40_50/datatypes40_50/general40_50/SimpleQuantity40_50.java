package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.exceptions.FHIRException;

public class SimpleQuantity40_50 {
  public static org.hl7.fhir.r5.model.Quantity convertSimpleQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    return Quantity40_50.convertQuantity(src);
  }

  public static org.hl7.fhir.r4.model.Quantity convertSimpleQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    return Quantity40_50.convertQuantity(src);
  }
}
