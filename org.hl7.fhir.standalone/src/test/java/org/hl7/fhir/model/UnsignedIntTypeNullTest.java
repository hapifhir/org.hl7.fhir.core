package org.hl7.fhir.model;

import org.hl7.fhir.model.core.UnsignedIntType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UnsignedIntTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      UnsignedIntType nullUnsignedInt = new UnsignedIntType();
      System.out.println("Value -> " + nullUnsignedInt);
    });
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    UnsignedIntType nullUnsignedInt = new UnsignedIntType();
    UnsignedIntType validUnsignedInt = new UnsignedIntType("42");
    Assertions.assertFalse(nullUnsignedInt.equalsDeep(validUnsignedInt));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    UnsignedIntType nullUnsignedInt = new UnsignedIntType();
    UnsignedIntType validUnsignedInt = new UnsignedIntType("42");
    Assertions.assertFalse(nullUnsignedInt.equalsShallow(validUnsignedInt));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    UnsignedIntType nullUnsignedInt = new UnsignedIntType();
    UnsignedIntType copyUnsignedInt = nullUnsignedInt.copy(Base.COPY_DATA);
    Assertions.assertNull(copyUnsignedInt.getValue());
  }

}