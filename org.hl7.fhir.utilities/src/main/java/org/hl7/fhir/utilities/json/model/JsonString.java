package org.hl7.fhir.utilities.json.model;

public class JsonString extends JsonPrimitive {
  private String value;

  public JsonString(String value) {
    super();
    this.value = value;
  }

  public JsonElementType elementType() {
    return JsonElementType.STRING;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

}
