package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.PrimitiveType;

public class Variable {
  private VariableMode mode;
  private String name;
  private Base object;

  public Variable(VariableMode mode, String name, Base object) {
    super();
    this.mode = mode;
    this.name = name;
    this.object = object;
  }

  public VariableMode getMode() {
    return mode;
  }

  public String getName() {
    return name;
  }

  public Base getObject() {
    return object;
  }

  public String summary() {
    if (object == null)
      return null;
    else if (object instanceof PrimitiveType)
      return name + ": \"" + ((PrimitiveType) object).asStringValue() + '"';
    else
      return name + ": (" + object.fhirType() + ")";
  }
}
