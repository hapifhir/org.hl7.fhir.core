package org.hl7.fhir.utilities.json.model;

public enum JsonElementType {
  OBJECT, ARRAY, STRING, NUMBER, BOOLEAN, NULL;

  public String toName() {
    switch (this) {
    case ARRAY: return "Array";
    case BOOLEAN: return "Boolean";
    case NULL: return "Null";
    case NUMBER: return "Number";
    case OBJECT: return "Object";
    case STRING: return "String";
    default: return "??";
    }
  }
}
