package org.hl7.fhir.dstu3.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InstantTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    InstantType nullInstant = new InstantType();
    System.out.println("Value -> " + nullInstant);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    InstantType nullInstant = new InstantType();
    InstantType validInstant = new InstantType("2013-06-08T10:57:34+01:00");
    Assertions.assertFalse(nullInstant.equalsDeep(validInstant));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    InstantType nullInstant = new InstantType();
    InstantType validInstant = new InstantType("2013-06-08T10:57:34+01:00");
    Assertions.assertFalse(nullInstant.equalsShallow(validInstant));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    InstantType nullInstant = new InstantType();
    InstantType copyInstant = nullInstant.copy();
    Assertions.assertNull(copyInstant.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    InstantType nullInstant = new InstantType();
    InstantType copyInstant = (InstantType) nullInstant.typedCopy();
    Assertions.assertNull(copyInstant.getValue());
  }
}