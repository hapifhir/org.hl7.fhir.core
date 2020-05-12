package org.hl7.fhir.core.generator.analysis;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ValueSet;

public class EnumInfo {

  private String name;
  private ValueSet valueSet;
  private boolean shared;
  
  public EnumInfo(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public ValueSet getValueSet() {
    return valueSet;
  }
  public void setValueSet(ValueSet valueSet) {
    this.valueSet = valueSet;
  }
  public boolean isShared() {
    return shared;
  }
  public void setShared(boolean shared) {
    this.shared = shared;
  }
  
  
}