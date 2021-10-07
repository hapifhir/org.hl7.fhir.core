package org.hl7.fhir.dstu2.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Base64BinaryTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    Base64BinaryType nullBase64 = new Base64BinaryType();
    System.out.println("Value -> " + nullBase64);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    Base64BinaryType nullBase64 = new Base64BinaryType();
    Base64BinaryType validBase64 = new Base64BinaryType("theValue");
    Assertions.assertFalse(nullBase64.equalsDeep(validBase64));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    Base64BinaryType nullBase64 = new Base64BinaryType();
    Base64BinaryType validBase64 = new Base64BinaryType("theValue");
    Assertions.assertFalse(nullBase64.equalsShallow(validBase64));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    Base64BinaryType nullBase64 = new Base64BinaryType();
    Base64BinaryType copyBase64 = nullBase64.copy();
    Assertions.assertNull(copyBase64.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    Base64BinaryType nullBase64 = new Base64BinaryType();
    Base64BinaryType copyBase64 = (Base64BinaryType) nullBase64.typedCopy();
    Assertions.assertNull(copyBase64.getValue());
  }
}