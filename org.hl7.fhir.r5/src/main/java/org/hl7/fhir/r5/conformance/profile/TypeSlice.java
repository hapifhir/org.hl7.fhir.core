package org.hl7.fhir.r5.conformance.profile;

import org.hl7.fhir.r5.model.ElementDefinition;

public class TypeSlice {
  protected ElementDefinition defn;
  protected String type;

  public TypeSlice(ElementDefinition defn, String type) {
    super();
    this.defn = defn;
    this.type = type;
  }

  public ElementDefinition getDefn() {
    return defn;
  }

  public String getType() {
    return type;
  }

}
