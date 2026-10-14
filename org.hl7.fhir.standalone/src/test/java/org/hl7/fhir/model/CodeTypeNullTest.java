package org.hl7.fhir.model;

import org.hl7.fhir.model.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CodeTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      CodeType nullCode = new CodeType();
      System.out.println("Value -> " + nullCode);
    });
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    CodeType nullCode = new CodeType();
    CodeType validCode = new CodeType("theValue");
    Assertions.assertFalse(nullCode.equalsDeep(validCode));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    CodeType nullCode = new CodeType();
    CodeType validCode = new CodeType("theValue");
    Assertions.assertFalse(nullCode.equalsShallow(validCode));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    CodeType nullCode = new CodeType();
    CodeType copyCode = nullCode.copy(Base.COPY_DATA);
    Assertions.assertNull(copyCode.getValue());
  }

}