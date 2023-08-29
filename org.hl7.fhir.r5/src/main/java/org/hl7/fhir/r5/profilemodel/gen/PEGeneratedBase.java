package org.hl7.fhir.r5.profilemodel.gen;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.profilemodel.PEInstance;

public class PEGeneratedBase {
  
  protected IWorkerContext workerContext;

  @Deprecated
  protected PEInstance instance;
  
  @Deprecated
  protected void removeChild(String name) {
    PEInstance child = instance.child(name);
    if (child != null) {
      instance.removeChild(child);
    }
  }

  @Deprecated
  protected void removeChildren(String name) {
    for (PEInstance child : instance.children(name)) {
      instance.removeChild(child);
    }
  }

  @Deprecated
  public PEInstance getInstance() {
    return instance;
  }
  
  @Deprecated
  public Base getData() {
    return instance.getBase();
  }
  
}

