package org.hl7.fhir.utilities.json.model;

public class JsonProperty {
  private String name;
  private JsonElement value;
  private int nameHash; // for faster name comparison
  
  boolean noComma; // parse in Json5 mode, but records this so the validator can complain
  boolean unquotedName;
  boolean unquotedValue;
   
  private int tag;
  
  public JsonProperty(String name, JsonElement value) {
    super();
    this.name = name;
    this.nameHash = name.hashCode();
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public JsonElement getValue() {
    return value;
  }

  public void setValue(JsonElement value) {
    this.value = value;
  }

  public boolean isNoComma() {
    return noComma;
  }

  public void setNoComma(boolean noComma) {
    this.noComma = noComma;
  }

  public boolean isUnquotedName() {
    return unquotedName;
  }

  public void setUnquotedName(boolean unquotedName) {
    this.unquotedName = unquotedName;
  }

  public boolean isUnquotedValue() {
    return unquotedValue;
  }

  public void setUnquotedValue(boolean unquotedValue) {
    this.unquotedValue = unquotedValue;
  }

  @Override
  public String toString() {
    return "\""+name+"\" : "+value.toString();
  }

  public int getTag() {
    return tag;
  }

  public void setTag(int tag) {
    this.tag = tag;
  }

  public int getNameHash() {
    return nameHash;
  }

}
