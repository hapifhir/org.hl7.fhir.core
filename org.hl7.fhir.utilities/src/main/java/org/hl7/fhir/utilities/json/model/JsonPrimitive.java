package org.hl7.fhir.utilities.json.model;

public abstract class JsonPrimitive extends JsonElement {

  public abstract String getValue();
  
  public String toJson() {
    return getValue();
  }
}
