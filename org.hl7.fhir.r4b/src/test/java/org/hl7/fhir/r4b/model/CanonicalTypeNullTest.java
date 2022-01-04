package org.hl7.fhir.r4b.model;

import org.hl7.fhir.r4b.model.CanonicalType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CanonicalTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    CanonicalType nullCanonical = new CanonicalType();
    System.out.println("Value -> " + nullCanonical);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    CanonicalType nullCanonical = new CanonicalType();
    CanonicalType validCanonical = new CanonicalType("theValue");
    Assertions.assertFalse(nullCanonical.equalsDeep(validCanonical));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    CanonicalType nullCanonical = new CanonicalType();
    CanonicalType validCanonical = new CanonicalType("theValue");
    Assertions.assertFalse(nullCanonical.equalsShallow(validCanonical));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    CanonicalType nullCanonical = new CanonicalType();
    CanonicalType copyCanonical = nullCanonical.copy();
    Assertions.assertNull(copyCanonical.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    CanonicalType nullCanonical = new CanonicalType();
    CanonicalType copyCanonical = (CanonicalType) nullCanonical.typedCopy();
    Assertions.assertNull(copyCanonical.getValue());
  }
}