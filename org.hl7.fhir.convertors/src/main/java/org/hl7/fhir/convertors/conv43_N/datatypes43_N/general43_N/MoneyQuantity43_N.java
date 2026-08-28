package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.exceptions.FHIRException;

public class MoneyQuantity43_N {
  public static org.hl7.fhir.model.core.Quantity convertMoneyQuantity(org.hl7.fhir.r4b.model.Quantity src) throws FHIRException {
    return Quantity43_N.convertQuantity(src);
  }

  public static org.hl7.fhir.r4b.model.Quantity convertMoneyQuantity(org.hl7.fhir.model.core.Quantity src) throws FHIRException {
    return Quantity43_N.convertQuantity(src);
  }
}
