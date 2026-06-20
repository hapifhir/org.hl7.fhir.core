package org.hl7.fhir.utilities.json.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hl7.fhir.utilities.json.JsonException;


public class JsonArray extends JsonElement implements Iterable<JsonElement> {
  private List<JsonElement> items = new ArrayList<>();
  private List<Boolean> noCommas; // validator use
  private List<Boolean> unQuoted; // validator use
  private boolean extraComma; // json5 support
  
  public List<String> asStrings() {
    List<String> list = new ArrayList<>();
    for (JsonElement n : items) {
      if (n instanceof JsonPrimitive) {
        list.add(n.asJsonPrimitive().getValue());
      }
    }
    return list;
  }
  
  public List<JsonElement> getItems() {
    return items;
  }

  public List<JsonObject> asJsonObjects() {
    List<JsonObject> list = new ArrayList<>();
    for (JsonElement n : items) {
      if (n instanceof JsonObject) {
        list.add((JsonObject) n);
      }
    }
    return list;    
  }
  
  public JsonElementType type() {
    return JsonElementType.ARRAY;
  }
  
  public JsonArray add(JsonElement node) throws JsonException {
    check(node != null, "null object in JsonArray.add()");
    items.add(node);
    return this;
  }
  
  public JsonArray add(int i, JsonElement node) throws JsonException {
    check(node != null, "null object in JsonArray.add()");
    items.add(i, node);
    return this;
  }

  public JsonArray add(String value) throws JsonException {
    check(value != null, "null value in JsonArray.add()");
    items.add(new JsonString(value));
    return this;
  }

  public JsonArray add(int value) throws JsonException {
    items.add(new JsonNumber(value));
    return this;
  }

  public JsonObject addObject() {
    JsonObject res = new JsonObject();
    add(res);
    return res;
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


  public JsonObject findByStringProp(String prop, String value) {
    for (JsonObject obj : asJsonObjects()) {
      if (obj.has(prop) && value.equals(obj.asString(prop))) 
        return obj;
    }
    return null;
  }
  
  public Iterator<JsonElement> iterator() {
    return items.iterator();
  }

  public JsonElement get(int i) {
    return items.get(i);
  }

  public JsonArray deepCopy() {
    return (JsonArray) make().copy(this);
  }

  @Override
  protected JsonElement copy(JsonElement other) {
    JsonArray o = (JsonArray) other;
    for (JsonElement p : o.getItems()) {
      add(p.deepCopy());
    }
    return this;
  }
  
  @Override
  protected JsonElement make() {
    return new JsonArray();
  }
  
  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append("[ ");
    boolean first = true;
    for (JsonElement p : items) {
      if (first) first = false; else b.append(", ");
      b.append(p.toString());
    }
    b.append(" ]");
    return b.toString();
  }

  public boolean isExtraComma() {
    return extraComma;
  }

  public void setExtraComma(boolean extraComma) {
    this.extraComma = extraComma;
  }

  public void remove(JsonElement e) {
    items.remove(e);
    
  }

  public boolean has(String key) {
    for (JsonElement e : items) {
      if (e.isJsonString() && key.equals(e.asString())) {
        return true;
      }
    }
    return false;
  }

  public void addAll(JsonArray src) {
    for (JsonElement e : src) {
      add(e);
    }
    
  }
  
}
