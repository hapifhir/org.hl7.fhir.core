package org.hl7.fhir.model;

import org.hl7.fhir.model.core.DateTimeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DateTimeTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      DateTimeType nullDateTime = new DateTimeType();
      System.out.println("Value -> " + nullDateTime);
    });
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    DateTimeType nullDateTime = new DateTimeType();
    DateTimeType validDateTime = new DateTimeType("1969-07-20");
    Assertions.assertFalse(nullDateTime.equalsDeep(validDateTime));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    DateTimeType nullDateTime = new DateTimeType();
    DateTimeType validDateTime = new DateTimeType("1969-07-20");
    Assertions.assertFalse(nullDateTime.equalsShallow(validDateTime));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    DateTimeType nullDateTime = new DateTimeType();
    DateTimeType copyDateTime = nullDateTime.copy(Base.COPY_DATA);
    Assertions.assertNull(copyDateTime.getValue());
  }

}