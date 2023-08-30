package org.hl7.fhir.r4b.utils;

import org.hl7.fhir.r4b.model.Observation;
import org.hl7.fhir.r4b.model.ObservationDefinition;
import org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType;

public class ObservationUtilities {

  public static Observation fromDefinition(ObservationDefinition def) {
    Observation obs = new Observation();
    obs.setCode(def.getCode());
    obs.getCategory().addAll(def.getCategory());
    if (def.hasMethod()) {
      obs.setMethod(def.getMethod());
    }
    if (def.hasPermittedDataType(ObservationDataType.QUANTITY) && def.getQuantitativeDetails().hasUnit() && def.getQuantitativeDetails().getUnit().hasCoding("http://unitsofmeasure.org")) {
      obs.getValueQuantity().setSystem("http://unitsofmeasure.org").setCode(def.getQuantitativeDetails().getUnit().getCode("http://unitsofmeasure.org"));
    }
    // todo: set up reference ranges 
    return obs;
  }

}
