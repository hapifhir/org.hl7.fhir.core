package org.hl7.fhir.r5.profilemodel.gen;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.profilemodel.PEInstance;

public class PEGeneratedBase {

  protected PEInstance instance;
  
  protected void removeChild(String name) {
    PEInstance child = instance.child(name);
    if (child != null) {
      instance.removeChild(child);
    }
  }

  protected void removeChildren(String name) {
    for (PEInstance child : instance.children(name)) {
      instance.removeChild(child);
    }
  }

  public PEInstance getInstance() {
    return instance;
  }
  
  public Base getData() {
    return instance.getBase();
  }
  
}

