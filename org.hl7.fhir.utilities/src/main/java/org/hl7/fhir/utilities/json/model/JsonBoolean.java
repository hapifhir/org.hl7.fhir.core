package org.hl7.fhir.utilities.json.model;

public class JsonBoolean extends JsonPrimitive {
  private boolean value;

  public JsonBoolean(boolean value) {
    super();
    this.value = value;
  }

  public JsonElementType elementType() {
    return JsonElementType.BOOLEAN;
  }

  public boolean isValue() {
    return value;
  }

  public void setValue(boolean value) {
    this.value = value;
  }
  
  public String getValue() {
    return value ? "true" : "false";
  }
  
  @Override
  public String toString() {
    return getValue();
  }
}
