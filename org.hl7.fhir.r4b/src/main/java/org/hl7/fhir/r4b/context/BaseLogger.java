package org.hl7.fhir.r4b.context;

public class BaseLogger {

  private int id = 0;
  private String lastId;

  public String getLastId() {
    return lastId;
  }

  protected String nextId() {
    id++;
    lastId = Integer.toString(id);
    return lastId;
  }

  public void clearLastId() {
    lastId = null;
  }

}
