package org.hl7.fhir.services.terminology;

import org.hl7.fhir.services.client.ITerminologyClientN;

public interface ITerminologyClientManager {
  public ITerminologyClientN getMasterClient();
}
