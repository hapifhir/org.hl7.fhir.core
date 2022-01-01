package org.hl7.fhir.r4b.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ca.uhn.fhir.parser.DataFormatException;

class Base64BinaryTypeTest {

  @Test
  @DisplayName("Passing a non Base64 encoded String to constructor causes exception.")
  public void testNonBase64String() {
    String nonBase64 = "Picard was the best starship captain.";
    assertThrows(DataFormatException.class, () -> new Base64BinaryType(nonBase64));
  }

  @Test
  @DisplayName("Null String value creates non-null instance with null value.")
  public void testNullInstance() throws DataFormatException {
    String v = null;
    Base64BinaryType b64 = new Base64BinaryType(v);
    Assertions.assertNotNull(b64);
    Assertions.assertNull(b64.getValue());
    Assertions.assertNull(b64.getValueAsString());
  }

  @Test
  @DisplayName("Valid Base64 String creates non-null instance with non-null values.")
  public void testValid() {
    String v = "dGhpcyBpcyB2YWxpZCBiYXNlNjQ=";
    Base64BinaryType b64 = new Base64BinaryType(v);
    Assertions.assertNotNull(b64);
    Assertions.assertNotNull(b64.getValue());
    Assertions.assertEquals(v, b64.asStringValue());
  }

}