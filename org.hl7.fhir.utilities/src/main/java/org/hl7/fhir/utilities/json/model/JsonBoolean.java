package org.hl7.fhir.utilities.json.model;

public class JsonBoolean extends JsonPrimitive {
  private boolean value;

  public JsonBoolean(boolean value) {
    super();
    this.value = value;
  }

  private JsonBoolean() {
  }

  public JsonElementType type() {
    return JsonElementType.BOOLEAN;
  }

  public boolean isValue() {
    return value;
  }

  public void setValue(boolean value) {
    this.value = value;
  }
  
  @Override
  public String getValue() {
    return value ? "true" : "false";
  }
  
  @Override
  public String toString() {
    return getValue();
  }
  
  @Override
  protected JsonElement copy(JsonElement other) {
    value = ((JsonBoolean) other).value;
    return this;
  }
  
  @Override
  protected JsonElement make() {
    return new JsonBoolean();
  }
}
