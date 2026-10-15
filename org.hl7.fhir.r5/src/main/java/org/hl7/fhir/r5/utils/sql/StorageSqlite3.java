package org.hl7.fhir.r5.utils.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLType;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.r5.utils.sql.Validator.TrueFalseOrUnknown;
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
  
  public StorageSqlite3(Connection conn) {
    super();
    this.conn = conn;
  }

  @Override
  public Store createStore(String name, List<Column> columns) {
    try {
      CommaSeparatedStringBuilder fields = new CommaSeparatedStringBuilder(", ");
      CommaSeparatedStringBuilder values = new CommaSeparatedStringBuilder(", ");
      StringBuilder b = new StringBuilder();
      b.append("Create Table "+name+" ( ");
      b.append("ViewRowKey integer NOT NULL");
      for (Column column : columns) {
        b.append(", "+column.getName()+" "+sqliteType(column.getKind())+" NULL"); // index columns are always nullable
        fields.append(column.getName());
        values.append("?");
      }
      b.append(", PRIMARY KEY (ViewRowKey))\r\n");
      conn.createStatement().execute(b.toString());

      String isql = "Insert into "+name+" (ViewRowKey, "+fields.toString()+") values (?, "+values.toString()+")";
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
        int index = i+2;
        // An empty cell is SQL NULL whatever the column's kind (spec: empty binds to null).
        Value v = c.getValues().isEmpty() ? null : c.getValues().get(0);
        switch (c.getColumn().getKind()) {
        case Null: 
          p.setNull(index, java.sql.Types.NVARCHAR);
          break;
        case Binary:
          p.setBytes(index, v == null ? null : v.getValueBinary());
          break;
        case Boolean:
          if (v == null) {
            p.setNull(index, java.sql.Types.INTEGER);
          } else {
            p.setBoolean(index, v.getValueBoolean().booleanValue());
          }
          break;
        case DateTime:
          // Text column, FHIR string form: keeps precision, time of day and zone offset, which
          // java.sql.Date would drop (spec: date and dateTime map to CHARACTER VARYING).
          p.setString(index, v == null ? null : v.getValueString());
          break;
        case Decimal:
          p.setString(index, v == null ? null : v.getValueString());
          break;
        case Integer:
          if (v == null) {
            p.setNull(index, java.sql.Types.INTEGER);
          } else {
            p.setLong(index, v.getValueInt().longValue());
          }
          break;
        case String:
          p.setString(index, v == null ? null : v.getValueString());
          break;
        case Time:
          p.setString(index, v == null ? null : v.getValueString());
          break;    
        case Complex: throw new FHIRException("SQLite runner does not handle complexes");
        }
      }
      p.execute();
    } catch (Exception e) {
      throw new FHIRException(e);
    }
    
  }

  @Override
  public void finish(Store store) {
    // nothing
  }

  @Override
  public TrueFalseOrUnknown supportsArrays() {
    return TrueFalseOrUnknown.FALSE;
  }

  @Override
  public TrueFalseOrUnknown supportsComplexTypes() {
    return TrueFalseOrUnknown.FALSE;
  }

  @Override
  public TrueFalseOrUnknown needsName() {
    return TrueFalseOrUnknown.TRUE;
  }

  @Override
  public String getKeyForSourceResource(Base res) {
    return resolveKey(res);
  }

  @Override
  public String getKeyForTargetResource(Base res) {
    return resolveKey(res);
  }

  /**
   * Prefer the DBBuilder-supplied SQLite primary key (UserDataNames.db_key)
   * when present so view-result keys join against the Resources table. Falls
   * back to type/id for callers that have not pre-stamped a key.
   */
  private String resolveKey(Base res) {
    if (res == null) {
      return null;
    }
    if (res.hasUserData(UserDataNames.db_key)) {
      return res.getUserString(UserDataNames.db_key);
    }
    return res.fhirType() + "/" + res.getIdBase();
  }
}
