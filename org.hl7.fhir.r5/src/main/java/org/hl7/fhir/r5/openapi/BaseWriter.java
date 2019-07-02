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
