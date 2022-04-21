package org.hl7.fhir.r5.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    IntegerType nullInteger = new IntegerType();
    System.out.println("Value -> " + nullInteger);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    IntegerType nullInteger = new IntegerType();
    IntegerType validInteger = new IntegerType("42");
    Assertions.assertFalse(nullInteger.equalsDeep(validInteger));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    IntegerType nullInteger = new IntegerType();
    IntegerType validInteger = new IntegerType("42");
    Assertions.assertFalse(nullInteger.equalsShallow(validInteger));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    IntegerType nullInteger = new IntegerType();
    IntegerType copyInteger = nullInteger.copy();
    Assertions.assertNull(copyInteger.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    IntegerType nullInteger = new IntegerType();
    IntegerType copyInteger = (IntegerType) nullInteger.typedCopy();
    Assertions.assertNull(copyInteger.getValue());
  }
}