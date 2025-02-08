package org.hl7.fhir.r4.utils.sql;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public class Store {

  private String name;

  protected Store(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }
  
  public void flush() {
    
  }
}
