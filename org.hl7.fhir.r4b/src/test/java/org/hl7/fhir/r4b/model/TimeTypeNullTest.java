package org.hl7.fhir.r4b.model;

import org.hl7.fhir.r4b.model.TimeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TimeTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    TimeType nullTime = new TimeType();
    System.out.println("Value -> " + nullTime);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    TimeType nullTime = new TimeType();
    TimeType validTime = new TimeType("42");
    Assertions.assertFalse(nullTime.equalsDeep(validTime));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    TimeType nullTime = new TimeType();
    TimeType validTime = new TimeType("42");
    Assertions.assertFalse(nullTime.equalsShallow(validTime));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    TimeType nullTime = new TimeType();
    TimeType copyTime = nullTime.copy();
    Assertions.assertNull(copyTime.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    TimeType nullTime = new TimeType();
    TimeType copyTime = (TimeType) nullTime.typedCopy();
    Assertions.assertNull(copyTime.getValue());
  }
}