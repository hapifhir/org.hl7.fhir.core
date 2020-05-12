package org.hl7.fhir.r5.openapi;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
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