package org.hl7.fhir.r4b.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerTypeTest {

  @Test
  @DisplayName("Test that non-initialized Integer value doesn't cause crash on copy()")
  public void testNullIntegerType() {
    IntegerType intType = new IntegerType();
    IntegerType intType2 = intType.copy();
    Assertions.assertNull(intType2.getValue());
  }

  @Test
  @DisplayName("Test that initialized with null Integer value doesn't cause crash on copy()")
  public void testNullIntegerTypeString() {
    IntegerType intType = new IntegerType((String) null);
    IntegerType intType2 = intType.copy();
    Assertions.assertNull(intType2.getValue());
  }
}