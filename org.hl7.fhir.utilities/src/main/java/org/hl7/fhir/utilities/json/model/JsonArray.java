package org.hl7.fhir.utilities.json.model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.json.JsonException;


public class JsonArray extends JsonElement {
  private List<JsonElement> items = new ArrayList<>();
  private List<Boolean> noCommas; // validator use
  private List<Boolean> unQuoted; // validator use
  
  public List<String> asStrings() {
    List<String> list = new ArrayList<>();
    for (JsonElement n : items) {
      if (n instanceof JsonPrimitive) {
        list.add(n.toString());
      }
    }
    return list;
  }
  
  public List<JsonElement> getItems() {
    return items;
  }

  public List<JsonObject> asObjects() {
    List<JsonObject> list = new ArrayList<>();
    for (JsonElement n : items) {
      if (n instanceof JsonObject) {
        list.add((JsonObject) n);
      }
    }
    return list;    
  }
  
  public JsonElementType elementType() {
    return JsonElementType.ARRAY;
  }
  
  public JsonArray add(JsonElement node) throws JsonException {
    check(node != null, "null object in JsonArray.add()");
    items.add(node);
    return this;
  }
  
  public JsonArray add(String value) throws JsonException {
    check(value != null, "null value in JsonArray.add()");
    items.add(new JsonString(value));
    return this;
  }

  public Integer size() {
    return items.size();
  }

  public boolean isNoComma(int i) {
    return noCommas == null ? false : noCommas.get(i);
  }

  public boolean isUnquoted(int i) {
    return unQuoted == null ? false : unQuoted.get(i);
  }
  
  // for the parser only
  public void addForParser(JsonElement e, boolean itemNoComma, boolean unquoted) throws JsonException {
    check(e != null, "null object in JsonArray.add()");
    items.add(e);
    if (noCommas == null) {
      noCommas = new ArrayList<>();
    }
    noCommas.add(itemNoComma);    
    if (unQuoted == null) {
      unQuoted = new ArrayList<>();
    }
    unQuoted.add(unquoted);    
  }


  public JsonObject findByStringProp(JsonArray arr, String prop, String value) {
    for (JsonObject obj : asObjects()) {
      if (obj.has(prop) && value.equals(obj.getString(prop))) 
        return obj;
    }
    return null;
  }
  
}
