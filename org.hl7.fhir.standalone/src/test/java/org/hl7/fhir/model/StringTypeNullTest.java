package org.hl7.fhir.model;

import org.hl7.fhir.model.core.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StringTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      StringType nullString = new StringType();
      System.out.println("Value -> " + nullString);
    });
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
    StringType copyString = nullString.copy(Base.COPY_DATA);
    Assertions.assertNull(copyString.getValue());
  }

}