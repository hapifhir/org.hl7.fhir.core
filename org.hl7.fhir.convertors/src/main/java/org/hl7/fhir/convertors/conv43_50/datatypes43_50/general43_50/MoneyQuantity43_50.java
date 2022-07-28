package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.exceptions.FHIRException;

public class MoneyQuantity43_50 {
  public static org.hl7.fhir.r5.model.Quantity convertMoneyQuantity(org.hl7.fhir.r4b.model.Quantity src) throws FHIRException {
    return Quantity43_50.convertQuantity(src);
  }

  public static org.hl7.fhir.r4b.model.Quantity convertMoneyQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    return Quantity43_50.convertQuantity(src);
  }
}
