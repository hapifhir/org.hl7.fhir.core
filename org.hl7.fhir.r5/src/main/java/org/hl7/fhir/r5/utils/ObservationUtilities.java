package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.model.Observation;
import org.hl7.fhir.r5.model.ObservationDefinition;
import org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType;

public class ObservationUtilities {

  public static Observation fromDefinition(ObservationDefinition def) {
    Observation obs = new Observation();
    obs.setCode(def.getCode());
    obs.getCategory().addAll(def.getCategory());
    if (def.hasBodySite()) {
      obs.setBodySite(def.getBodySite());
    }
    if (def.hasMethod()) {
      obs.setMethod(def.getMethod());
    }
    if (def.hasPermittedDataType(ObservationDataType.QUANTITY) && def.getPermittedUnit().size() == 1 && def.getPermittedUnitFirstRep().getSystem().equals("http://unitsofmeasure.org")) {
      obs.getValueQuantity().setSystem("http://unitsofmeasure.org").setCode(def.getPermittedUnitFirstRep().getCode());
    }
    // todo: set up reference ranges 
    return obs;
  }

}
