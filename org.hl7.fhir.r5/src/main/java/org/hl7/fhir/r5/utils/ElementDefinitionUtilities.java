package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;

public class ElementDefinitionUtilities {

  public static boolean hasType(ElementDefinition ed, String name) {
    if (name == null)
      return false;
    
    for (TypeRefComponent tr : ed.getType()) {
      if (name.equals(tr.getCode()))
        return true;
    }
    return false;
  }

}
