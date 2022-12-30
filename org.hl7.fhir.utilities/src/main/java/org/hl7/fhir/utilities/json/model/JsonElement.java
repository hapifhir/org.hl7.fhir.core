package org.hl7.fhir.utilities.json.model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.json.JsonException;

public abstract class JsonElement {

  private List<JsonComment> comments;
  private JsonLocationData start;
  private JsonLocationData end;
  
  public abstract JsonElementType type();

  public List<JsonComment> getComments() {
    if (comments == null ) {
      comments = new ArrayList<>();
    }
    return comments;
  }

  public JsonLocationData getStart() {
    return start;
  }

  public void setStart(JsonLocationData start) {
    this.start = start;
  }

  public JsonLocationData getEnd() {
    return end;
  }

  public void setEnd(JsonLocationData end) {
    this.end = end;
  }

  protected void check(boolean test, String msg) throws JsonException {
    if (!test) {
      throw new JsonException(msg);
    }    
  }

  public boolean hasComments() {
    return comments != null && !comments.isEmpty();
  }
  
  public JsonElement deepCopy() {
    return make().copy(this);
  }
  
  protected abstract JsonElement copy(JsonElement jsonElement);
  protected abstract JsonElement make();
  
  public boolean isJsonObject() {
    return type() == JsonElementType.OBJECT;
  }
  
  public boolean isJsonArray() {
    return type() == JsonElementType.ARRAY;
  }
  
  public boolean isJsonPrimitive() {
    return isJsonBoolean() || isJsonString() || isJsonNull() || isJsonNumber();
  }

  public boolean isJsonBoolean() {
    return type() == JsonElementType.BOOLEAN;
  }

  public boolean isJsonString() {
    return type() == JsonElementType.STRING;
  }

  public boolean isJsonNumber() {
    return type() == JsonElementType.NUMBER;
  }

  public boolean isJsonNull() {
    return type() == JsonElementType.NULL;
  }

  public JsonObject asJsonObject() {
    return isJsonObject() ? (JsonObject) this : null;
  }

  public JsonArray asJsonArray() {
    return isJsonArray() ? (JsonArray) this : null;
  }
  
  public JsonPrimitive asJsonPrimitive() {
    return isJsonPrimitive() ? (JsonPrimitive) this : null;
  }

  public JsonBoolean asJsonBoolean() {
    return isJsonBoolean() ? (JsonBoolean) this : null;
  }

  public JsonString asJsonString() {
    return isJsonString() ? (JsonString) this : null;
  }

  public JsonNumber asJsonNumber() {
    return isJsonNumber() ? (JsonNumber) this : null;
  }

  public JsonNull asJsonNull() {
    return isJsonNull() ? (JsonNull) this : null;
  }

  public String asString() {
    return isJsonPrimitive() ? ((JsonPrimitive) this).getValue() : null;
  }
}
