package org.hl7.fhir.utilities.json.model;

import org.hl7.fhir.utilities.Utilities;

public class JsonNumber extends JsonPrimitive {

  private String value;

  public JsonNumber(String value) {
    this.value = value;
  }

  public JsonNumber(int value) {
    this.value = Integer.toString(value);
  }

  public JsonNumber(long value) {
    this.value = Long.toString(value);
  }

  private JsonNumber() {
  }

  public JsonElementType type() {
    return JsonElementType.NUMBER;
  }

  @Override
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

  public Long getLong() {
    if (Utilities.isLong(value)) {
      return Long.parseLong(value);
    } else {
      return null;
    }
  }

  public Double getDouble() {
    if (Utilities.isDecimal(value, false)) {
      return Double.parseDouble(value); 
    } else {
      return null; 
    }
  }
  
  @Override
  protected JsonElement copy(JsonElement other) {
    value = ((JsonNumber) other).value;
    return this;
  }
  
  @Override
  protected JsonElement make() {
    return new JsonNumber();
  }
}
