package org.hl7.fhir.utilities.json.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;


public class JsonObject extends JsonElement {
  
  private List<JsonProperty> properties = new ArrayList<>();
  private Map<String, JsonProperty> propMap = new HashMap<>();
  private boolean extraComma; // json5 support
  
  public JsonElementType type() {
    return JsonElementType.OBJECT;
  }

  public JsonObject add(String name, JsonElement value) throws JsonException {
    check(name != null, "Json Property Name is null");
    check(value != null, "Json Property Value is null");
    if (get(name) != null) {
      check(false, "Name '"+name+"' already exists (value = "+get(name).toString()+")");
    }
    JsonProperty p = new JsonProperty(name, value);
    properties.add(p);
    propMap.put(name, p);
    return this;
  }
  
  public JsonObject add(int index, String name, JsonElement value) throws JsonException {
    check(name != null, "Json Property Name is null");
    check(value != null, "Json Property Value is null");
    if (get(name) != null) {
      check(false, "Name '"+name+"' already exists (value = "+get(name).toString()+")");
    }
    JsonProperty p = new JsonProperty(name, value);
    properties.add(index, p);
    propMap.put(name, p);
    return this;
  }

  public JsonObject addIfNotNull(String name, JsonElement value) throws JsonException {
    if (value != null) {
      check(name != null, "Name is null");
      if (get(name) != null) {
        check(false, "Name '"+name+"' already exists (value = "+get(name).toString()+")");
      }
      JsonProperty p = new JsonProperty(name, value);
      properties.add(p);
      propMap.put(name, p);
    }
    return this;
  }

  
  // this is used by the parser which can allow duplicates = true (for the validator). You should not otherwise use it
  public JsonObject addForParser(String name, JsonElement value, boolean noComma, boolean nameUnquoted, boolean valueUnquoted) throws JsonException {
    check(name != null, "Name is null");
    check(value != null, "Value is null");
    JsonProperty p = new JsonProperty(name, value);
    p.setNoComma(noComma);
    p.setUnquotedName(nameUnquoted);
    p.setUnquotedValue(valueUnquoted);
    properties.add(p);
    propMap.put(name, p); // last duplicate wins
    return this;
  }

  public JsonObject add(String name, String value) throws JsonException {
    check(name != null, "Name is null");
    return add(name, value == null ? new JsonNull() : new JsonString(value));
  }

  public JsonObject add(String name, List<String> values) throws JsonException {
    check(name != null, "Name is null");
    JsonArray arr = new JsonArray();
    add(name, arr);
    for (String v : values) {
      arr.add(v);
    }
    return this;
  }

  public JsonObject addIfNotNull(String name, String value) throws JsonException {
    check(name != null, "Name is null");
    if (value == null) { 
      return this;
    } else {
      return add(name, value == null ? new JsonNull() : new JsonString(value));
    }
  }

  public JsonObject add(String name, boolean value) throws JsonException {
    check(name != null, "Name is null");
    return add(name, new JsonBoolean(value));
  }

  public JsonObject add(String name, int value) throws JsonException {
    check(name != null, "Name is null");
    return add(name, new JsonNumber(value));
  }


  public JsonObject add(String name, long value) throws JsonException {
    check(name != null, "Name is null");
    return add(name, new JsonNumber(value));
  }

  
  public JsonObject set(String name, JsonElement value) throws JsonException {
    check(name != null, "Name is null");
    check(value != null, "Value is null");
    JsonProperty p = propMap.get(name);
    if (p != null) {
      p.setValue(value);
      return this;
    } else {
      return add(name, value);
    }
  }

  public JsonObject set(String name, Instant value) throws JsonException {
    String v = value == null ? null : value.toString();
    return set(name, v);
  }
    

  public JsonObject set(String name, String value) throws JsonException {
    check(name != null, "Name is null");
    JsonProperty p = propMap.get(name);
    if (p != null) {
      p.setValue(value == null ? new JsonNull() : new JsonString(value));
      return this;
    } else {
      return add(name, value == null ? new JsonNull() : new JsonString(value));
    }
  }

  public JsonObject set(String name, boolean value) throws JsonException {
    check(name != null, "Name is null");
    JsonProperty p = propMap.get(name);
    if (p != null) {
      p.setValue(new JsonBoolean(value));
      return this;
    } else {
      return add(name, new JsonBoolean(value));
    }
  }

  public JsonObject set(String name, int value) throws JsonException {
    check(name != null, "Name is null");
    JsonProperty p = propMap.get(name);
    if (p != null) {
      p.setValue(new JsonNumber(value));
      return this;
    } else {
      return add(name, new JsonNumber(value));
    }
  }

  public JsonObject set(String name, long value) throws JsonException {
    check(name != null, "Name is null");
    JsonProperty p = propMap.get(name);
    if (p != null) {
      p.setValue(new JsonNumber(value));
      return this;
    } else {
      return add(name, new JsonNumber(value));
    }
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

  public boolean has(String... names) {
    for (String n : names) {
      if (propMap.containsKey(n)) {
        return true;
      }
    }
    return false;
  }

  public void remove(String name) {
    if (propMap.containsKey(name)) {
      propMap.remove(name);
      properties.removeIf((JsonProperty item) -> name.equals(item.getName()));
    }
  }
  
  public List<JsonProperty> getProperties() {
    return properties;
  }

  public List<String> getNames() {
    return Utilities.sorted(propMap.keySet());
  }

  public String str(String name) {
    if (hasPrimitive(name)) {
      return get(name).asJsonPrimitive().getValue();
    } else {
      return null;
    }
  }

  public boolean hasObject(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().type() == JsonElementType.OBJECT;
  }

  public boolean hasArray(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().type() == JsonElementType.ARRAY;
  }

  public boolean hasPrimitive(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue() instanceof JsonPrimitive;
  }

  public boolean hasString(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().type() == JsonElementType.STRING;
  }

  public boolean hasNumber(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().type() == JsonElementType.NUMBER;
  }

  public boolean hasBoolean(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().type() == JsonElementType.BOOLEAN;
  }

  public boolean hasNull(String name) {
    return propMap.containsKey(name) && propMap.get(name).getValue().type() == JsonElementType.NULL;
  }


  public JsonObject getJsonObject(String name) {
    return hasObject(name) ?  (JsonObject) get(name) : null;
  }

  public JsonString getJsonString(String name) {
    return hasString(name) ? (JsonString) get(name) : null;
  }

  public JsonBoolean getJsonBoolean(String name) {
    return hasBoolean(name) ? (JsonBoolean) get(name) : null;
  }
  
  public JsonNumber getJsonNumber(String name) {
    return hasNumber(name) ? (JsonNumber) get(name) : null;
  }
  
  public JsonNull getJsonNull(String name) {
    return hasNull(name) ?(JsonNull) get(name) : null;
  }
  
  public JsonArray getJsonArray(String name) {
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
  
  public Double asDouble(String name) {
    if (hasNumber(name)) {
      return ((JsonNumber) get(name)).getDouble();
    }
    if (hasPrimitive(name)) {
      String s = asString(name);
      if (Utilities.isDecimal(s, false)) {
        return Double.parseDouble(s);
      }
    }
    return null;
  }


  public String asString(String name) {
    return hasPrimitive(name) ? ((JsonPrimitive) get(name)).getValue() : null;
  }

  public String asString(String... names) {
    for (String n : names) {
      if (hasPrimitive(n)) {
        return asString(n);
      }
    }
    return null;
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

  public Instant asDate(String name) {
    String source = asString(name);
    if (Utilities.noString(source)) {
      return null;
    } else {
      OffsetDateTime odt = OffsetDateTime.parse(source);
      return odt.toInstant();
    }
  }
  
  public Instant asInstant(String name) throws ParseException {
    String source = asString(name);
    if (Utilities.noString(source) || "null".equals(source)) {
      return null;
    } else if (source.length() <= 10) {
      Date d = new SimpleDateFormat("yyyy-mm-dd").parse(source);
      return d.toInstant();
    } else {
      OffsetDateTime odt = OffsetDateTime.parse(source);
      return odt.toInstant();
    }
  }
  
  public JsonObject forceObject(String name) throws JsonException {
    if (has(name) && !hasObject(name)) {
      remove(name);
    }
    if (!has(name)) {
      add(name, new JsonObject());
    }
    return getJsonObject(name);
  }

  public JsonArray forceArray(String name) throws JsonException {
    if (has(name) && !hasArray(name)) {
      remove(name);
    }
    if (!has(name)) {
      add(name, new JsonArray());
    }
    return getJsonArray(name);
  }
  
  public JsonArray forceArray(int index, String name) throws JsonException {
    if (has(name) && !hasArray(name)) {
      remove(name);
    }
    if (!has(name)) {
      add(index, name, new JsonArray());
    }
    return getJsonArray(name);
  }

  public List<JsonObject> getJsonObjects(String name) {
    List<JsonObject> res = new ArrayList<>();
    if (hasArray(name)) {
      res.addAll(getJsonArray(name).asJsonObjects());
    } else if (hasObject(name)) {
      res.add(getJsonObject(name));
    } 
    return res;
  }
  
  public List<String> getStrings(String name) {
    List<String> res = new ArrayList<>();
    if (hasArray(name)) {
      res.addAll(getJsonArray(name).asStrings());
    } else if (hasPrimitive(name)) {
      res.add(asString(name));
    } 
    return res;
  }
  
  public JsonObject deepCopy() {
    return (JsonObject) make().copy(this);
  }

  @Override
  protected JsonElement copy(JsonElement other) {
    JsonObject o = (JsonObject) other;
    for (JsonProperty p : o.getProperties()) {
      add(p.getName(), p.getValue().deepCopy());
    }
    return this;
  }
  
  @Override
  protected JsonElement make() {
    return new JsonObject();
  }
  
  public JsonObject findByStringProp(String arrName, String prop, String value) {
    for (JsonObject obj : getJsonObjects(arrName)) {
      if (obj.has(prop) && value.equals(obj.asString(prop))) 
        return obj;
    }
    return null;
  }
  
  public void merge(JsonObject source) {
    for (JsonProperty pp : source.getProperties()) {
      if (has(pp.getName())) {
        JsonElement te = get(pp.getName());
        if (te.isJsonObject() && pp.getValue().isJsonObject()) {
          ((JsonObject) te).merge((JsonObject) pp.getValue());
        } else {
          set(pp.getName(), pp.getValue());
        }
      } else {
        add(pp.getName(), pp.getValue());
      }
    }
  }


  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append("{ ");
    boolean first = true;
    for (JsonProperty p : properties) {
      if (first) first = false; else b.append(", ");
      b.append(p.toString());
    }
    b.append(" }");
    return b.toString();
  }

  public boolean isExtraComma() {
    return extraComma;
  }

  public void setExtraComma(boolean extraComma) {
    this.extraComma = extraComma;
  }
  
  public void clear() {
    properties.clear();
    propMap.clear();
  }

  public boolean isJsonString(String name) {
    return has(name) && get(name).type() == JsonElementType.STRING;
  }
  
  public boolean isJsonBoolean(String name) {
    return has(name) && get(name).type() == JsonElementType.BOOLEAN;
  }

  public String compareTo(JsonObject j2) {
    String path = "$";
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    compare(path, b, this, j2);
    return b.length() == 0 ? null : b.toString();
  }

  private void compare(String path, CommaSeparatedStringBuilder b, JsonObject j1, JsonObject j2) {
    for (JsonProperty p : j1.getProperties()) {
      String np = path+"."+p.getName();
      JsonElement p2 = j2.get(p.getName());
      if (p2 == null) {
        b.append("Missing at "+np);
      } else if (p.getValue().type() != p2.type()) {
        b.append("Wrong type at "+np+": "+p2.type().toName()+" instead of "+p.getValue().type().toName());        
      } else if (p2.isJsonPrimitive()) {
        String s2 = p2.asString();
        String s1 = p.getValue().asString();
        if (!s2.equals(s1)) {
          b.append("Value Mismatch at "+np+": '"+s2+"' instead of '"+s1+"'");                  
        }
      } else if (p2.isJsonArray()) {
        compare(np, b, p.getValue().asJsonArray(), p2.asJsonArray());
      } else {
        compare(np, b, p.getValue().asJsonObject(), p2.asJsonObject());        
      }
    }
    for (JsonProperty p : j2.getProperties()) {
      String np = path+"."+p.getName();
      if (!j1.has(p.getName())) {
        b.append("Unexpected "+p.getValue().type().toName()+" at "+np);        
      }
    }
  }
  
  private void compare(String path, CommaSeparatedStringBuilder b, JsonArray j1, JsonArray j2) {
    for (int i = 0; i < Integer.min(j1.size(), j2.size()); i++) {
      String np = path+"["+i+"]";
      JsonElement i1 = j1.get(i);
      JsonElement i2 = j2.get(i);
      if (i1.type() != i2.type()) {
        b.append("Wrong type at "+np+": "+i2.type().toName()+" instead of "+i1.type().toName());        
      } else if (i2.isJsonPrimitive()) {
        if (!i2.toString().equals(i1.asString())) {
          b.append("Value Mismatch at "+np+": '"+i1.toString()+"' instead of '"+i1.toString()+"'");                  
        }
      } else if (i2.isJsonArray()) {
        compare(np, b, i1.asJsonArray(), i2.asJsonArray());
      } else {
        compare(np, b, i1.asJsonObject(), i2.asJsonObject());        
      }
    }
    if (j1.size() > j2.size()) {
      b.append("Missing Element "+j2.size()+" at "+path);  
    } else if (j1.size() < j2.size()) {
      b.append("Unexpected Element "+j1.size()+" at "+path);  
    }
  }
}
