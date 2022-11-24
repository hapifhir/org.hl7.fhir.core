package org.hl7.fhir.utilities.json.model;

public class JsonNull extends JsonPrimitive {
  
  public JsonElementType elementType() {
    return JsonElementType.NULL;
  }

  @Override
  public String getValue() {
    return "null";
  }
  
  @Override
  public String toString() {
    return getValue();
  }
    
  @Override
  protected JsonElement copy(JsonElement other) {
    return this;
  }
  
  @Override
  protected JsonElement make() {
    return new JsonNull();
  }
}
