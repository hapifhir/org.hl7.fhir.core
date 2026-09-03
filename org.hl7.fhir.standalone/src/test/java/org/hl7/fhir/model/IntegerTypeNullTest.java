package org.hl7.fhir.model;

import org.hl7.fhir.model.core.IntegerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class IntegerTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      IntegerType nullInteger = new IntegerType();
      System.out.println("Value -> " + nullInteger);
    });
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
    IntegerType copyInteger = nullInteger.copy(Base.COPY_DATA);
    Assertions.assertNull(copyInteger.getValue());
  }

}