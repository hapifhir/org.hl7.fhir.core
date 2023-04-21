package org.hl7.fhir.validation.special;

import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;

public class TxTesterScrubbers {

  public static void scrub(DomainResource dr) {
    dr.setText(null);
    dr.setMeta(null);
    
  }

  public static void scrub(Parameters po) {
    po.setMeta(null);
    
  }

}
