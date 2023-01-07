package org.hl7.fhir.r5.conformance.profile;

import org.hl7.fhir.r5.model.ElementDefinition;

public class BaseTypeSlice {
  private ElementDefinition defn;
  private String type;
  private int start;
  private int end;
  private boolean handled;

  public BaseTypeSlice(ElementDefinition defn, String type, int start, int end) {
    super();
    this.defn = defn;
    this.type = type;
    this.start = start;
    this.end = end;
  }

  public ElementDefinition getDefn() {
    return defn;
  }

  public String getType() {
    return type;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public boolean isHandled() {
    return handled;
  }

  public void setHandled(boolean handled) {
    this.handled = handled;
  }
}
