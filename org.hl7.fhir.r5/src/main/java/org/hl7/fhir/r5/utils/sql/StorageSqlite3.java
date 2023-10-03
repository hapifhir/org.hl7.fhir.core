package org.hl7.fhir.r5.utils.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

public class StorageSqlite3 implements Storage {
  
  public static class SQLiteStore extends Store {
    private PreparedStatement p;

    protected SQLiteStore(String name, PreparedStatement p) {
      super(name);
      this.p = p;
    }

    public PreparedStatement getP() {
      return p;
    }
    
  }
  
  private Connection conn;
  private int nextKey = 0;
  
  protected StorageSqlite3(Connection conn) {
    super();
    this.conn = conn;
  }

  @Override
  public Store createStore(String name, List<Column> columns) {
    try {
      CommaSeparatedStringBuilder fields = new CommaSeparatedStringBuilder(", ");
      CommaSeparatedStringBuilder values = new CommaSeparatedStringBuilder(", ");
      StringBuilder b = new StringBuilder();
      b.append("Create Table "+name+" { ");
      b.append("ViewRowKey integer NOT NULL");
      for (Column column : columns) {
        b.append(", "+column.getName()+" "+sqliteType(column.getKind())+" NULL"); // index columns are always nullable
        fields.append(column.getName());
        values.append("?");
      }
      b.append(", PRIMARY KEY (ViewRowKey))\r\n");
      conn.createStatement().execute(b.toString());

      String isql = "Insert into "+name+" ("+fields.toString()+") values ("+values.toString()+")";
      PreparedStatement psql = conn.prepareStatement(isql);
      return new SQLiteStore(name, psql);
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }

  private String sqliteType(ColumnKind type) {
    switch (type) {
    case DateTime: return "Text";
    case Decimal: return "Real";
    case Integer: return "Integer";
    case String: return "Text";
    case Time: return "Text";
    case Binary: return "Text";
    case Boolean: return "Integer";
    case Complex: throw new FHIRException("SQLite runner does not handle complexes");
    }
    return null;
  }

  @Override
  public void addRow(Store store, List<Cell> cells) {
    try {
      SQLiteStore sqls = (SQLiteStore) store;
      PreparedStatement p = sqls.getP();
      p.setInt(1, ++nextKey);
      for (int i = 0; i < cells.size(); i++) {
        Cell c = cells.get(i);
        switch (c.getColumn().getKind()) {
        case Binary:
          p.setBytes(i+2, c.getValues().size() == 0 ? null : c.getValues().get(0).getValueBinary());
          break;
        case Boolean:
          p.setBoolean(i+2, c.getValues().size() == 0 ? false : c.getValues().get(0).getValueBoolean().booleanValue());
          break;
        case DateTime:
          p.setDate(i+2, c.getValues().size() == 0 ? null : new java.sql.Date(c.getValues().get(0).getValueDate().getTime()));
          break;
        case Decimal:
          p.setString(i+2, c.getValues().size() == 0 ? null : c.getValues().get(0).getValueString());
          break;
        case Integer:
          p.setInt(i+2, c.getValues().size() == 0 ? 0 : c.getValues().get(0).getValueInt().intValue());
          break;
        case String:
          p.setString(i+2, c.getValues().size() == 0 ? null : c.getValues().get(0).getValueString());
          break;
        case Time:
          p.setString(i+2, c.getValues().size() == 0 ? null : c.getValues().get(0).getValueString());
          break;    
        case Complex: throw new FHIRException("SQLite runner does not handle complexes");
        }
      }
    } catch (Exception e) {
      throw new FHIRException(e);
    }
    
  }

  @Override
  public void finish(Store store) {
    // nothing
  }

  @Override
  public boolean supportsArrays() {
    return false;
  }

  @Override
  public boolean supportsComplexTypes() {
    return false;
  }

  @Override
  public boolean needsName() {
    return true;
  }

  @Override
  public String getKeyForSourceResource(Base res) {
    throw new Error("Key management for resources isn't decided yet");
  }

  @Override
  public String getKeyForTargetResource(Base res) {
    throw new Error("Key management for resources isn't decided yet");
  }
}
