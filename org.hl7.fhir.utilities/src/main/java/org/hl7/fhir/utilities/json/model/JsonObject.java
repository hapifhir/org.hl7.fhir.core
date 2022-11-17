package org.hl7.fhir.utilities.json.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.Utilities;
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

  public void drop(String name) {
    if (propMap.containsKey(name)) {
      propMap.remove(name);
      properties.removeIf((JsonProperty item) -> name.equals(item.getName()));
    }
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

  public boolean hasObject(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().elementType() == JsonElementType.OBJECT;
  }

  public boolean hasArray(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().elementType() == JsonElementType.ARRAY;
  }

  public boolean hasPrimitive(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue() instanceof JsonPrimitive;
  }

  public boolean hasString(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().elementType() == JsonElementType.STRING;
  }

  public boolean hasNumber(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().elementType() == JsonElementType.NUMBER;
  }

  public boolean hasBoolean(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().elementType() == JsonElementType.BOOLEAN;
  }

  public boolean hasNull(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().elementType() == JsonElementType.NULL;
  }


  public JsonObject getObject(String name) {
    return hasObject(name) ?  (JsonObject) get(name) : null;
  }

  public JsonString getString(String name) {
    return hasString(name) ? (JsonString) get(name) : null;
  }

  public JsonBoolean getBoolean(String name) {
    return hasBoolean(name) ? (JsonBoolean) get(name) : null;
  }
  
  public JsonNumber getNumber(String name) {
    return hasNumber(name) ? (JsonNumber) get(name) : null;
  }
  
  public JsonNull getNull(String name) {
    return hasNull(name) ?(JsonNull) get(name) : null;
  }
  
  public JsonArray getArray(String name) {
    return hasArray(name) ? (JsonArray) get(name) : null;
  }

  public Integer asInteger(String name) {
    if (hasNumber(name)) {
      return ((JsonNumber) get(name)).getInteger();
    }
    if (hasPrimitive(name)) {
      String s = asString(name);
      if (Utilities.isInteger(s)) {
        return Integer.parseInt(s);
      }
    }
    return null;
  }

  public String asString(String name) {
    return hasPrimitive(name) ? ((JsonPrimitive) get(name)).toString() : null;
  }

  public boolean asBoolean(String name) {
    if (hasBoolean(name)) {
      return ((JsonBoolean) get(name)).isValue();
    }
    if (hasPrimitive(name)) {
      String s = asString(name);
      if ("true".equals(s)) {
        return true;
      }
      if ("false".equals(s)) {
        return false;
      }
    }
    return false;
  }

  public JsonObject forceObject(String name) throws JsonException {
    if (has(name) && !hasObject(name)) {
      drop(name);
    }
    if (!has(name)) {
      add(name, new JsonObject());
    }
    return getObject(name);
  }

  public JsonArray forceArray(String name) throws JsonException {
    if (has(name) && !hasArray(name)) {
      drop(name);
    }
    if (!has(name)) {
      add(name, new JsonArray());
    }
    return getArray(name);
  }
  

}
