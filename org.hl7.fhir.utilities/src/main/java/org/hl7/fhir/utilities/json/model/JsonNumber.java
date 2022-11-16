package org.hl7.fhir.utilities.json.model;

import org.hl7.fhir.utilities.Utilities;

public class JsonNumber extends JsonPrimitive {

  private String value;

  public JsonNumber(String value) {
    this.value = value;
  }

  public JsonElementType elementType() {
    return JsonElementType.NUMBER;
  }

  public String getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return value;
  }

  public Integer getInteger() {
    if (Utilities.isInteger(value)) {
      return Integer.parseInt(value); 
    } else {
      return null; 
    }
  }
}
