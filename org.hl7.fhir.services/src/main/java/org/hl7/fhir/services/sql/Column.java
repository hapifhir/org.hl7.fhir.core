package org.hl7.fhir.services.sql;

import java.util.Objects;

public class Column {

  private String name;
  private int length;
  private String type;
  private ColumnKind kind;
  private Boolean isColl;
  private boolean duplicateReported;
  private String notes;
  
  protected Column() {
    super();
  }

  public Column(String name, Boolean isColl, String type, ColumnKind kind) {
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

  public Boolean isColl() {
    return isColl;
  }

  public void setColl(Boolean isColl) {
    this.isColl = isColl;
  }

  /**
   * Describes the first difference between this column and another that would stop them being
   * the same column of a unionAll, or returns null when they match. The spec requires the branches
   * to agree on name, order and FHIR type - not merely on storage family. A column whose path is
   * the empty collection has no type of its own and takes on the other column's.
   */
  public String diff(Column other) {
    if (!name.equals(other.name)) {
      return "Names differ: '"+name+"' vs '"+other.name+"'"; 
    }
    if (kind != ColumnKind.Null && other.kind != ColumnKind.Null) {
      if (length != other.length) {
        return "Lengths differ: '"+length+"' vs '"+other.length+"'"; 
      }
      if (!Objects.equals(type, other.type)) {
        return "Types differ: '"+type+"' vs '"+other.type+"'"; 
      }
      if (!Objects.equals(isColl, other.isColl)) {
        return "Collection status differs: '"+isColl+"' vs '"+other.isColl+"'"; 
      }
    } else if (kind == ColumnKind.Null) {
      kind = other.kind;
      type = other.type;
      length = other.length;
      isColl = other.isColl;
    }
    return null;
  }

  public boolean isDuplicateReported() {
    return duplicateReported;
  }

  public void setDuplicateReported(boolean duplicateReported) {
    this.duplicateReported = duplicateReported;
  }

  @Override
  public String toString() {
    return "Column [name=" + name + ", length=" + length + ", type=" + type + ", kind=" + kind + ", isColl=" + isColl
        + "]";
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
  

  public void addNote(String note) {
    this.notes = notes == null ? note : notes+"; "+note;
  }
  
}
