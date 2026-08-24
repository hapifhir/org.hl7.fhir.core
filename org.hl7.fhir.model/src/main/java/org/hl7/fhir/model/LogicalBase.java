package org.hl7.fhir.model;


public abstract class LogicalBase extends Base {

  private static final long serialVersionUID = 1L;

  @Override
  public String getIdBase() {
    return null;
  }

  @Override
  public void setIdBase(String value) {
    // nothing    
  }

}
