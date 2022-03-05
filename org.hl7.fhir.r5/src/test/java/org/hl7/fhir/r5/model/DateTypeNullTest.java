package org.hl7.fhir.r5.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    DateType nullDate = new DateType();
    System.out.println("Value -> " + nullDate);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    DateType nullDate = new DateType();
    DateType validDate = new DateType("1969-07-20");
    Assertions.assertFalse(nullDate.equalsDeep(validDate));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    DateType nullDate = new DateType();
    DateType validDate = new DateType("1969-07-20");
    Assertions.assertFalse(nullDate.equalsShallow(validDate));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    DateType nullDate = new DateType();
    DateType copyDate = nullDate.copy();
    Assertions.assertNull(copyDate.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    DateType nullDate = new DateType();
    DateType copyDate = (DateType) nullDate.typedCopy();
    Assertions.assertNull(copyDate.getValue());
  }
}