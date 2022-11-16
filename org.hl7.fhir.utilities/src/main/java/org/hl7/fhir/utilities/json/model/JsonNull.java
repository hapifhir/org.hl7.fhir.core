package org.hl7.fhir.utilities.json.model;

public class JsonNull extends JsonPrimitive {
  
  public JsonElementType elementType() {
    return JsonElementType.NULL;
  }


  public String getValue() {
    return "null";
  }
  
  @Override
  public String toString() {
    return getValue();
  }
}
