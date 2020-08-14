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



import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class BaseWriter {

  protected JsonObject object;

  public BaseWriter(JsonObject object) {
    super();
    this.object = object;
  }

  protected JsonObject ensureObject(String name) {
    JsonObject child = object.getAsJsonObject(name);
    if (child == null) {
      child = new JsonObject();
      object.add(name, child);
    }
    return child;
  }
  
  protected JsonObject ensureArrayObject(String arrayName, String propertyName, String value) {
    JsonArray arr = forceArray(arrayName);
    for (JsonElement e : arr) {
      String s = e.getAsJsonObject().get(propertyName).getAsString();
      if (value.equals(s))
        return e.getAsJsonObject();
    }
    JsonObject e = new JsonObject();
    arr.add(e);
    e.addProperty(propertyName, value);
    return e;
  }

  protected JsonArray forceArray(String arrayName) {
    JsonArray arr = object.getAsJsonArray(arrayName);
    if (arr == null) {
      arr = new JsonArray();
      object.add(arrayName, arr);
    }
    return arr;
  }
  
  protected JsonObject forceArrayObject(String arrayName) {
    JsonArray arr = object.getAsJsonArray(arrayName);
    if (arr == null) {
      arr = new JsonArray();
      object.add(arrayName, arr);
    }
    JsonObject obj = new JsonObject();
    arr.add(obj);
    return obj;
  }
  

  protected JsonObject ensureMapObject(String mapName, String value) {
    JsonObject map = object.getAsJsonObject(mapName);
    if (map == null) {
      map = new JsonObject();
      object.add(mapName, map);
    }
    if (map.has(value))
      return map.getAsJsonObject(value);
    JsonObject e = new JsonObject();
    map.add(value, e);
    return e;
  }
  

  protected JsonObject ensureMapObject(String value) {
    if (object.has(value))
      return object.getAsJsonObject(value);
    JsonObject e = new JsonObject();
    object.add(value, e);
    return e;
  }
  
}