package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.exceptions.FHIRException;

public class MoneyQuantity40_N {
  public static org.hl7.fhir.model.core.Quantity convertMoneyQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    return Quantity40_N.convertQuantity(src);
  }

  public static org.hl7.fhir.r4.model.Quantity convertMoneyQuantity(org.hl7.fhir.model.core.Quantity src) throws FHIRException {
    return Quantity40_N.convertQuantity(src);
  }
}
