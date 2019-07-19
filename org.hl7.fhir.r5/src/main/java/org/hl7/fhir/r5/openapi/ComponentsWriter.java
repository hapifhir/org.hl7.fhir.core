package org.hl7.fhir.r5.openapi;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


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
    ensureObject("parameters").add(name, po);
    return new ParameterWriter(po);
  }
}
