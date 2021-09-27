package org.hl7.fhir.r4.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecimalTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    DecimalType nullDecimal = new DecimalType();
    System.out.println("Value -> " + nullDecimal);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    DecimalType nullDecimal = new DecimalType();
    DecimalType validDecimal = new DecimalType("3.14");
    Assertions.assertFalse(nullDecimal.equalsDeep(validDecimal));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    DecimalType nullDecimal = new DecimalType();
    DecimalType validDecimal = new DecimalType("3.14");
    Assertions.assertFalse(nullDecimal.equalsShallow(validDecimal));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    DecimalType nullDecimal = new DecimalType();
    DecimalType copyDecimal = nullDecimal.copy();
    Assertions.assertNull(copyDecimal.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    DecimalType nullDecimal = new DecimalType();
    DecimalType copyDecimal = (DecimalType) nullDecimal.typedCopy();
    Assertions.assertNull(copyDecimal.getValue());
  }
}