package org.hl7.fhir.r4.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4.model.DateTimeType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for how {@link StorageSqlite3#addRow} writes cell values. The spec binds a column with no
 * value to null; SQLite must see SQL NULL for every kind, and 64-bit integers and FHIR date/time
 * strings must round-trip without loss.
 *
 * @author John Grimes
 */
class StorageSqlite3RowTests {

  private static final Column INT = new Column("i", false, "integer", ColumnKind.Integer);
  private static final Column BOOL = new Column("b", false, "boolean", ColumnKind.Boolean);
  private static final Column DT = new Column("d", false, "dateTime", ColumnKind.DateTime);
  private static final Column STR = new Column("s", false, "string", ColumnKind.String);

  private Connection conn;
  private StorageSqlite3 storage;
  private Store store;

  @BeforeEach
  void setUp() throws Exception {
    conn = DriverManager.getConnection("jdbc:sqlite::memory:");
    storage = new StorageSqlite3(conn);
    store = storage.createStore("t", List.of(INT, BOOL, DT, STR));
  }

  @AfterEach
  void tearDown() throws Exception {
    conn.close();
  }

  /** Writes one row from the given cells and returns a cursor positioned on it. */
  private ResultSet writeAndRead(Cell... cells) throws Exception {
    List<Cell> row = new ArrayList<>();
    for (Cell c : cells) {
      row.add(c);
    }
    storage.addRow(store, row);
    Statement s = conn.createStatement();
    ResultSet rs = s.executeQuery("select i, b, d, s from t");
    assertTrue(rs.next(), "expected one row");
    return rs;
  }

  // Empty cells must be NULL, not the Java default of the column's primitive type.
  @Test
  void emptyCellsAreStoredAsNull() throws Exception {
    ResultSet rs = writeAndRead(new Cell(INT), new Cell(BOOL), new Cell(DT), new Cell(STR));
    assertNull(rs.getObject("i"), "empty integer must be NULL, not 0");
    assertNull(rs.getObject("b"), "empty boolean must be NULL, not false");
    assertNull(rs.getObject("d"));
    assertNull(rs.getObject("s"));
  }

  @Test
  void populatedCellsKeepTheirValues() throws Exception {
    ResultSet rs = writeAndRead(
        new Cell(INT, Value.makeInteger("7", 7L)),
        new Cell(BOOL, Value.makeBoolean("true", true)),
        new Cell(DT), new Cell(STR, Value.makeString("x")));
    assertEquals(7, rs.getInt("i"));
    assertTrue(rs.getBoolean("b"));
    assertEquals("x", rs.getString("s"));
  }

  // integer64 values do not fit an int; SQLite integers are 64-bit, so the full value must be kept.
  @Test
  void integerBeyondIntRangeIsStored() throws Exception {
    ResultSet rs = writeAndRead(new Cell(INT, Value.makeInteger("9999999999", 9999999999L)),
        new Cell(BOOL), new Cell(DT), new Cell(STR));
    assertEquals(9999999999L, rs.getLong("i"));
  }

  // The spec maps date/dateTime to CHARACTER VARYING in FHIR string form. Time of day, precision
  // and zone offset are part of that form and must survive storage.
  @Test
  void dateTimeCellKeepsFhirStringForm() throws Exception {
    DateTimeType d = new DateTimeType("2020-01-02T03:04:05+10:00");
    ResultSet rs = writeAndRead(new Cell(INT), new Cell(BOOL),
        new Cell(DT, Value.makeDate(d.primitiveValue(), d.getValue())), new Cell(STR));
    assertEquals("2020-01-02T03:04:05+10:00", rs.getString("d"));
  }
}
