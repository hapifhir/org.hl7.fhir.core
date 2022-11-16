package org.hl7.fhir.utilities.json.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.json.JsonException;


public class JsonObject extends JsonElement {
  
  private List<JsonProperty> properties = new ArrayList<>();
  private Map<String, JsonProperty> propMap = new HashMap<>();
  
  public JsonElementType elementType() {
    return JsonElementType.OBJECT;
  }

  public JsonObject add(String name, JsonElement value) throws JsonException {
    check(name != null, "Numm is null");
    check(value != null, "Numm is null");
    check(get(name) == null, "Name '"+name+"' already exists");
    JsonProperty p = new JsonProperty(name, value);
    properties.add(p);
    propMap.put(name, p);
    return this;
  }

  // this is used by the parser which can allow duplicates = true (for the validator). You should not otherwise use it
  public JsonObject addForParser(String name, JsonElement value, boolean noComma, boolean nameUnquoted, boolean valueUnquoted) throws JsonException {
    check(name != null, "Numm is null");
    check(value != null, "Numm is null");
    JsonProperty p = new JsonProperty(name, value);
    p.setNoComma(noComma);
    p.setUnquotedName(nameUnquoted);
    p.setUnquotedValue(valueUnquoted);
    properties.add(p);
    propMap.put(name, p); // last duplicate wins
    return this;
  }

  public JsonObject add(String name, String value) throws JsonException {
    return add(name, new JsonString(value));
  }

  public JsonObject add(String name, boolean value) throws JsonException {
    return add(name, new JsonBoolean(value));
  }


  public JsonElement get(String name) {
    if (propMap.containsKey(name)) {
      return propMap.get(name).getValue();
    } else {
      return null;
    }
  }

  public boolean has(String name) {
    return propMap.containsKey(name);
  }

  public List<JsonProperty> getProperties() {
    return properties;
  }

  public String str(String name) {
    if (has(name)) {
      return get(name).toString();
    } else {
      return null;
    }
  }

  public JsonObject getObj(String name) {
    return (JsonObject) get(name);
  }

  public JsonString getStr(String name) {
    return (JsonString) get(name);
  }

  public JsonBoolean getBool(String name) {
    return (JsonBoolean) get(name);
  }
  
  public JsonNumber getNum(String name) {
    return (JsonNumber) get(name);
  }
  
  public JsonNull getNull(String name) {
    return (JsonNull) get(name);
  }
  
  public JsonArray getArr(String name) {
    return (JsonArray) get(name);
  }

  public Integer getInteger(String name) {
    return ((JsonNumber) get(name)).getInteger();
  }

  public String getString(String name) {
    return ((JsonPrimitive) get(name)).toString();
  }

  public Boolean getBoolean(String name) {
    return has(name) ?  ((JsonBoolean) get(name)).isValue() : false;
  }

  public JsonObject forceObj(String name) throws JsonException {
    if (!has(name)) {
      add(name, new JsonObject());
    }
    return getObj(name);
  }

  public JsonArray forceArr(String name) throws JsonException {
    if (!has(name)) {
      add(name, new JsonArray());
    }
    return getArr(name);
  }
  

}
