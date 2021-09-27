package org.hl7.fhir.r4.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IdTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    IdType nullId = new IdType();
    System.out.println("Value -> " + nullId);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    IdType nullId = new IdType();
    IdType validId = new IdType("12345");
    Assertions.assertFalse(nullId.equalsDeep(validId));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    IdType nullId = new IdType();
    IdType validId = new IdType("12345");
    Assertions.assertFalse(nullId.equalsShallow(validId));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    IdType nullId = new IdType();
    IdType copyId = nullId.copy();
    Assertions.assertNull(copyId.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    IdType nullId = new IdType();
    IdType copyId = (IdType) nullId.typedCopy();
    Assertions.assertNull(copyId.getValue());
  }
}