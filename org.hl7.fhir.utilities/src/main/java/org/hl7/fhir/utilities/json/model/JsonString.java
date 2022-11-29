package org.hl7.fhir.utilities.json.model;

import org.hl7.fhir.utilities.Utilities;

public class JsonString extends JsonPrimitive {
  private String value;

  public JsonString(String value) {
    super();
    this.value = value;
  }

  private JsonString() {
  }

  public JsonElementType type() {
    return JsonElementType.STRING;
  }

  @Override
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "\""+ Utilities.escapeJson(value)+"\"";
  }

  @Override
  public String toJson() {
    return "\""+ Utilities.escapeJson(value)+"\"";
  }
  
  @Override
  protected JsonElement copy(JsonElement other) {
    value = ((JsonString) other).value;
    return this;
  }
  
  @Override
  protected JsonElement make() {
    return new JsonString();
  }
}
