package org.hl7.fhir.r5.terminologies;

import org.hl7.fhir.utilities.Utilities;

public class ValueSetWorker {

  public boolean isServerSide(String url) {
    return Utilities.existsInList(url, "http://hl7.org/fhir/sid/cvx");
  }
  
  
}
