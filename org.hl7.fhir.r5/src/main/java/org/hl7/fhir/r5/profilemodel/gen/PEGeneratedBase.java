package org.hl7.fhir.r5.profilemodel.gen;

import org.hl7.fhir.r5.profilemodel.PEInstance;

public class PEGeneratedBase {

  protected PEInstance instance;
  
  protected void removeChild(String string) {
    PEInstance child = instance.child("simple");
    if (child != null) {
      instance.removeChild(child);
    }
  }
  
}

