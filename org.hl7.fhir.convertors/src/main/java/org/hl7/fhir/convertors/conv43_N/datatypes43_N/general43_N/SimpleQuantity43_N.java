package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.exceptions.FHIRException;

public class SimpleQuantity43_N {
  public static org.hl7.fhir.model.core.Quantity convertSimpleQuantity(org.hl7.fhir.r4b.model.Quantity src) throws FHIRException {
    return Quantity43_N.convertQuantity(src);
  }

  public static org.hl7.fhir.r4b.model.Quantity convertSimpleQuantity(org.hl7.fhir.model.core.Quantity src) throws FHIRException {
    return Quantity43_N.convertQuantity(src);
  }
}
