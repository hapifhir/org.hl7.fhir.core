package org.hl7.fhir.r5.utils.sql;

public class Column {

  private String name;
  private int length;
  private String type;
  private ColumnKind kind;
  private boolean isColl;
  
  protected Column() {
    super();
  }

  protected Column(String name, boolean isColl, String type, ColumnKind kind) {
    super();
    this.name = name;
    this.isColl = isColl;
    this.type = type;
    this.kind = kind;
  }
  
  public String getName() {
    return name;
  }
  public int getLength() {
    return length;
  }
  public ColumnKind getKind() {
    return kind;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setKind(ColumnKind kind) {
    this.kind = kind;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isColl() {
    return isColl;
  }

  public void setColl(boolean isColl) {
    this.isColl = isColl;
  }
  
  
}
