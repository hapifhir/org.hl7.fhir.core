package org.hl7.fhir.r5.openapi;

import com.google.gson.JsonObject;

public class ComponentsWriter extends BaseWriter {

  public ComponentsWriter(JsonObject object) {
    super(object);
  }

  public ComponentsWriter schema(String name, JsonObject jsonSchema) {
    ensureMapObject("schemas", name).add("$ref", jsonSchema);
    return this;
  }
  
  public ComponentsWriter schemaRef(String name, String uri) {
    ensureMapObject("schemas", name).addProperty("$ref", uri);
    return this;
  }

  public ParameterWriter parameter(String name) {
    JsonObject po = new JsonObject();
    ensureMapObject("parameters", name).add(name, po);
    return new ParameterWriter(po);
  }
}
