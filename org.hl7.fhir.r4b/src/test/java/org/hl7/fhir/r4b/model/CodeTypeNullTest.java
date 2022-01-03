package org.hl7.fhir.r4b.model;

import org.hl7.fhir.r4b.model.CodeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CodeTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    CodeType nullCode = new CodeType();
    System.out.println("Value -> " + nullCode);
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
    CodeType copyCode = nullCode.copy();
    Assertions.assertNull(copyCode.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    CodeType nullCode = new CodeType();
    CodeType copyCode = (CodeType) nullCode.typedCopy();
    Assertions.assertNull(copyCode.getValue());
  }
}