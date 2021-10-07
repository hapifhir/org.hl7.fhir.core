package org.hl7.fhir.dstu2.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UnsignedIntTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    UnsignedIntType nullUnsignedInt = new UnsignedIntType();
    System.out.println("Value -> " + nullUnsignedInt);
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
    UnsignedIntType copyUnsignedInt = nullUnsignedInt.copy();
    Assertions.assertNull(copyUnsignedInt.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    UnsignedIntType nullUnsignedInt = new UnsignedIntType();
    UnsignedIntType copyUnsignedInt = (UnsignedIntType) nullUnsignedInt.typedCopy();
    Assertions.assertNull(copyUnsignedInt.getValue());
  }
}