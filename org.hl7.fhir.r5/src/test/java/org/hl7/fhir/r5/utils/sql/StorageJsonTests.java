package org.hl7.fhir.r5.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.json.model.JsonNumber;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.junit.jupiter.api.Test;

/**
 * Tests for the JSON text {@link StorageJson} writes for decimal cells. A JSON number carries no
 * precision, so the scale a BigDecimal happens to have must not leak into the output: the same
 * numeric value has to serialise identically however it was computed (for example, the eight
 * decimal places highBoundary() pads out to).
 *
 * @author John Grimes
 */
class StorageJsonTests {

  private static final Column DECIMAL = new Column("v", false, "decimal", ColumnKind.Decimal);

  /** Writes one decimal cell and returns the JSON text of its number. */
  private static String decimalText(String literal) {
    StorageJson storage = new StorageJson();
    Store store = storage.createStore("t", List.of(DECIMAL));
    List<Cell> cells = new ArrayList<>();
    cells.add(new Cell(DECIMAL, Value.makeDecimal(literal, new BigDecimal(literal))));
    storage.addRow(store, cells);
    JsonObject row = (JsonObject) storage.getRows().get(0);
    return ((JsonNumber) row.get("v")).getValue();
  }

  // Padding from a high-precision computation is dropped: 1.05000000 and 1.05 are the same number.
  @Test
  void trailingZerosAreStripped() {
    assertEquals("1.05", decimalText("1.05000000"));
  }

  // An integral decimal loses its fractional zeros rather than printing as 1.0.
  @Test
  void integralDecimalHasNoFraction() {
    assertEquals("1", decimalText("1.0"));
  }

  // Zeros before the decimal point are significant and stay in plain (not exponent) form.
  @Test
  void integralZerosAreKeptInPlainForm() {
    assertEquals("100", decimalText("100"));
  }

  // A value with no redundant scale is written as-is.
  @Test
  void significantDigitsAreUnchanged() {
    assertEquals("0.125", decimalText("0.125"));
  }
}
