package org.hl7.fhir.r5.openapi;

import org.hl7.fhir.r5.openapi.SchemaWriter.SchemaType;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SchemaWriter extends BaseWriter {

  public enum SchemaType {
    array,
    bool,
    dateTime,
    number,
    string;

    public String toCode() {
      switch (this) {
      case array: return "array";
      case bool: return "boolean";
      case dateTime: return "dateTime";
      case number: return "number";
      case string: return "string";
      }
      return "??";
    }
  }

  public SchemaWriter(JsonObject object) {
    super(object);
  }

  public SchemaWriter type(SchemaType value) {
    if (value != null)
      object.addProperty("type", value.toCode());
    return this;
  }

  public SchemaWriter enums(String... values) {
    JsonArray arr = forceArray("enum");
    for (String s : values)
      arr.add(s);    
    return this;
  }

  public SchemaWriter format(String value) {
    if (value != null)
      object.addProperty("format", value);
    return this;    
  }

}
