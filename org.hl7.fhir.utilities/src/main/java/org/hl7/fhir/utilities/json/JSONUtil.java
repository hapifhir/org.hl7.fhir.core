package org.hl7.fhir.utilities.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

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
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

public class JSONUtil {

  public static JsonObject parse(String json) throws IOException {
    return JsonTrackingParser.parseJson(json);    
    
  }

  public static JsonObject forceObject(JsonObject obj, String name) {
    if (obj.has(name) && obj.get(name).isJsonObject())
      return obj.getAsJsonObject(name);
    if (obj.has(name))
      obj.remove(name);
    JsonObject res = new JsonObject();
    obj.add(name, res);
    return res;
  }

  public static JsonArray forceArray(JsonObject obj, String name) {
    if (obj.has(name) && obj.get(name).isJsonArray())
      return obj.getAsJsonArray(name);
    if (obj.has(name))
      obj.remove(name);
    JsonArray res = new JsonArray();
    obj.add(name, res);
    return res;  }

  public static JsonObject addObj(JsonArray arr) {
    JsonObject res = new JsonObject();
    arr.add(res);
    return res;
  }

  public static JsonObject findByStringProp(JsonArray arr, String prop, String value) {
    for (JsonElement e : arr) {
      JsonObject obj = (JsonObject) e;
      if (obj.has(prop) && obj.get(prop).getAsString().equals(value)) 
        return obj;
    }
    return null;
  }

  public static String str(JsonObject json, String name) {
    JsonElement e = json.get(name);
    return e == null || e instanceof JsonNull ? null : e.getAsString();
  }

  public static boolean bool(JsonObject json, String name) {
    JsonElement e = json.get(name);
    return e == null || e instanceof JsonNull ? false : e.getAsBoolean();
  }

  public static String str(JsonObject json, String name1, String name2) {
    JsonElement e = json.get(name1);
    if (e == null)
      e = json.get(name2);
    return e == null ? null : e instanceof JsonNull ? null :  e.getAsString();
  }

  public static boolean has(JsonObject json, String name1, String name2) {
    return json.has(name1) || json.has(name2);
  }

  public static List<JsonObject> objects(JsonObject json, String name) {
    List<JsonObject> res = new ArrayList<>();
    if (json.has(name))
      for (JsonElement e : json.getAsJsonArray(name))
        if (e instanceof JsonObject)
          res.add((JsonObject) e);
    return res;
  }

  public static void merge(JsonObject source, JsonObject target) {
    for (Entry<String, JsonElement> pp : source.entrySet()) {
      if (target.has(pp.getKey())) {
        JsonElement te = target.get(pp.getKey());
        if (te.isJsonObject() && pp.getValue().isJsonObject()) {
          merge(te.getAsJsonObject(), pp.getValue().getAsJsonObject());
        } else {
          target.remove(pp.getKey());
          target.add(pp.getKey(), pp.getValue());
        }
      } else {
        target.add(pp.getKey(), pp.getValue());
      }
    }
  }

}