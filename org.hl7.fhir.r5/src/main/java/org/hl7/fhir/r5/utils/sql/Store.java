package org.hl7.fhir.r5.utils.sql;

public class Store {

  private String name;

  protected Store(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }
  
}
