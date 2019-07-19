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

public class OperationWriter extends BaseWriter {

  public OperationWriter(JsonObject object) {
    super(object);
  }
  
  public OperationWriter summary(String value) {
    object.addProperty("summary", value);
    return this;            
  }
  
  public OperationWriter description(String value) {
    object.addProperty("description", value);
    return this;            
  }
  

  public ExternalDocsWriter variable(String name) {
    return new ExternalDocsWriter(ensureObject("externalDocs"));            
  }
  
  public OperationWriter operationId(String value) {
    object.addProperty("operationId", value);
    return this;            
  }
  
  public OperationWriter deprecated(boolean value) {
    object.addProperty("deprecated", value);
    return this;            
  }
  

  public ServerWriter server(String url) {
    return new ServerWriter(ensureArrayObject("servers", "url", url)); 
  }
  
  public ParameterWriter parameter(String name) {
    JsonObject obj = forceArrayObject("parameters");
    obj.addProperty("name", name);
    return new ParameterWriter(obj);
  }

  public OperationWriter paramRef(String url) {
    forceArrayObject("parameters").addProperty("$ref", url);
    return this;
  }
  

  public RequestBodyWriter request() {
    return new RequestBodyWriter(ensureObject("requestBody"));
  }

  public ResponsesWriter responses() {
    return new ResponsesWriter(ensureObject("responses"));
  }

}
