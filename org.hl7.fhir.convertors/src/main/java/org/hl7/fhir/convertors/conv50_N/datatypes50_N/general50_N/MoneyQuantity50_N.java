package org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N;

import org.hl7.fhir.exceptions.FHIRException;

public class MoneyQuantity50_N {
  public static org.hl7.fhir.model.core.Quantity convertMoneyQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    return Quantity50_N.convertQuantity(src);
  }

  public static org.hl7.fhir.r5.model.Quantity convertMoneyQuantity(org.hl7.fhir.model.core.Quantity src) throws FHIRException {
    return Quantity50_N.convertQuantity(src);
  }
}
