package org.hl7.fhir.dstu3.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UuidTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    UuidType nullUuid = new UuidType();
    System.out.println("Value -> " + nullUuid);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    UuidType nullUuid = new UuidType();
    UuidType validUuid = new UuidType("d6db3614-4c1c-4753-b319-771383b034cf");
    Assertions.assertFalse(nullUuid.equalsDeep(validUuid));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    UuidType nullUuid = new UuidType();
    UuidType validUuid = new UuidType("d6db3614-4c1c-4753-b319-771383b034cf");
    Assertions.assertFalse(nullUuid.equalsShallow(validUuid));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    UuidType nullUuid = new UuidType();
    UuidType copyUuid = nullUuid.copy();
    Assertions.assertNull(copyUuid.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    UuidType nullUuid = new UuidType();
    UuidType copyUuid = (UuidType) nullUuid.typedCopy();
    Assertions.assertNull(copyUuid.getValue());
  }
}