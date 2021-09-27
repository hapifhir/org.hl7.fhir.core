package org.hl7.fhir.dstu3.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooleanTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    BooleanType nullBoolean = new BooleanType();
    System.out.println("Value -> " + nullBoolean);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    BooleanType nullBoolean = new BooleanType();
    BooleanType validBoolean = new BooleanType("false");
    Assertions.assertFalse(nullBoolean.equalsDeep(validBoolean));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    BooleanType nullBoolean = new BooleanType();
    BooleanType validBoolean = new BooleanType("false");
    Assertions.assertFalse(nullBoolean.equalsShallow(validBoolean));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    BooleanType nullBoolean = new BooleanType();
    BooleanType copyBoolean = nullBoolean.copy();
    Assertions.assertNull(copyBoolean.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    BooleanType nullBoolean = new BooleanType();
    BooleanType copyBoolean = (BooleanType) nullBoolean.typedCopy();
    Assertions.assertNull(copyBoolean.getValue());
  }
}