package org.hl7.fhir.convertors;

public abstract class BaseLoader {

  private String[] types;

  public BaseLoader(String[] types) {
    super();
    this.types = types;
  }
  
  public String[] getTypes() {
    return types;
  }



}