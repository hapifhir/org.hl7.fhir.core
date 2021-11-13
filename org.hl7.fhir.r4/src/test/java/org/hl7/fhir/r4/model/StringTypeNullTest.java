package org.hl7.fhir.r4.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    StringType nullString = new StringType();
    System.out.println("Value -> " + nullString);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    StringType nullString = new StringType();
    StringType validString = new StringType("theValue");
    Assertions.assertFalse(nullString.equalsDeep(validString));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    StringType nullString = new StringType();
    StringType validString = new StringType("theValue");
    Assertions.assertFalse(nullString.equalsShallow(validString));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    StringType nullString = new StringType();
    StringType copyString = nullString.copy();
    Assertions.assertNull(copyString.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    StringType nullString = new StringType();
    StringType copyString = (StringType) nullString.typedCopy();
    Assertions.assertNull(copyString.getValue());
  }
}