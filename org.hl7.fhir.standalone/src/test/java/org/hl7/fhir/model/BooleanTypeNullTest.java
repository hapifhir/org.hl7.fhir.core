package org.hl7.fhir.model;

import org.hl7.fhir.model.core.BooleanType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BooleanTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      BooleanType nullBoolean = new BooleanType();
      System.out.println("Value -> " + nullBoolean);
    });
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
    BooleanType copyBoolean = nullBoolean.copy(Base.COPY_DATA);
    Assertions.assertNull(copyBoolean.getValue());
  }

}