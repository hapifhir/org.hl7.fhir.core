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