package org.hl7.fhir.r4b.model;

import org.hl7.fhir.r4b.model.PositiveIntType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveIntTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    PositiveIntType nullPositiveInt = new PositiveIntType();
    System.out.println("Value -> " + nullPositiveInt);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    PositiveIntType nullPositiveInt = new PositiveIntType();
    PositiveIntType validPositiveInt = new PositiveIntType("42");
    Assertions.assertFalse(nullPositiveInt.equalsDeep(validPositiveInt));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    PositiveIntType nullPositiveInt = new PositiveIntType();
    PositiveIntType validPositiveInt = new PositiveIntType("42");
    Assertions.assertFalse(nullPositiveInt.equalsShallow(validPositiveInt));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    PositiveIntType nullPositiveInt = new PositiveIntType();
    PositiveIntType copyPositiveInt = nullPositiveInt.copy();
    Assertions.assertNull(copyPositiveInt.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    PositiveIntType nullPositiveInt = new PositiveIntType();
    PositiveIntType copyPositiveInt = (PositiveIntType) nullPositiveInt.typedCopy();
    Assertions.assertNull(copyPositiveInt.getValue());
  }
}