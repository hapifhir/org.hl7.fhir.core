package org.hl7.fhir.r5.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UriTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    UriType nullUri = new UriType();
    System.out.println("Value -> " + nullUri);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    UriType nullUri = new UriType();
    UriType validUri = new UriType("urn:uuid:53fefa32-fcbb-4ff8-8a92-55ee120877b7");
    Assertions.assertFalse(nullUri.equalsDeep(validUri));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    UriType nullUri = new UriType();
    UriType validUri = new UriType("urn:uuid:53fefa32-fcbb-4ff8-8a92-55ee120877b7");
    Assertions.assertFalse(nullUri.equalsShallow(validUri));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    UriType nullUri = new UriType();
    UriType copyUri = nullUri.copy();
    Assertions.assertNull(copyUri.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    UriType nullUri = new UriType();
    UriType copyUri = (UriType) nullUri.typedCopy();
    Assertions.assertNull(copyUri.getValue());
  }
}