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

public class ParameterWriter extends BaseWriter {

  public enum ParameterLocation {
    query, header, path, cookie;
  }
  public enum ParameterStyle {
    matrix, label, form, simple, spaceDelimited, pipeDelimited, deepObject;
  }

  public ParameterWriter(JsonObject object) {
    super(object);
  }

  public ParameterWriter in(ParameterLocation value) {
    object.addProperty("in", value.toString());
    return this;            
  }
  
  public ParameterWriter name(String value) {
    object.addProperty("name", value);
    return this;            
  }
  
  public ParameterWriter allowEmptyValue() {
    object.addProperty("allowEmptyValue", true);
    return this;            
  }
  
  public ParameterWriter description(String value) {
    if (value != null)
      object.addProperty("description", value);
    return this;            
  }
  
  public ParameterWriter required(boolean value) {
    object.addProperty("required", value);
    return this;            
  }
  
  public ParameterWriter deprecated(boolean value) {
    object.addProperty("deprecated", value);
    return this;            
  }
  
  public ParameterWriter allowEmptyValue(boolean value) {
    object.addProperty("allowEmptyValue", value);
    return this;            
  }
  

  public ParameterWriter style(ParameterStyle value) {
    object.addProperty("style", value.toString());
    return this;            
  }
  
  
  public ParameterWriter explode(boolean value) {
    object.addProperty("explode", value);
    return this;            
  }
  
  public ParameterWriter allowReserved(boolean value) {
    object.addProperty("allowReserved", value);
    return this;            
  }
    

  public ParameterWriter schema(JsonObject jsonSchema) {
    object.add("schema", jsonSchema);
    return this;
  }
  
  public SchemaWriter schema() {
    JsonObject so = new JsonObject();
    object.add("schema", so);
    return new SchemaWriter(so);
  }
  
  public ParameterWriter schemaRef(String name, String uri) {
    JsonObject schema = new JsonObject();
    schema.addProperty("$ref", uri);
    object.add("schema", schema);
    return this;
  }
  

  public ParameterWriter example(JsonObject example) {
    object.add("example", example);
    return this;
  }
  
}
