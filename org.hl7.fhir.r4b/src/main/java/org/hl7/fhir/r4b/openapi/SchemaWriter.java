package org.hl7.fhir.r4b.openapi;

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
      case dateTime: return "date-time";
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
    if (value != null) {
      if (value == SchemaType.dateTime) {
        object.addProperty("type", "string");
        object.addProperty("pattern", "([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)(-(0[1-9]|1[0-2])(-(0[1-9]|[1-2][0-9]|3[0-1])(T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]+)?(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00)))?)?)?");
        
      } else 
        object.addProperty("type", value.toCode());
    }
    return this;
  }

  public SchemaWriter items() {
    JsonObject items = new JsonObject();
    object.add("items", items);
    return new SchemaWriter(items);
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