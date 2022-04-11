package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.parser.DataFormatException;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base64BinaryTypeTest {

  static final String NON_BASE_64 = "Picard was the best starship captain.";
  static final String VALID_BASE_64 = "dGhpcyBpcyB2YWxpZCBiYXNlNjQ=";
  static final byte[] VALID_BASE_64_BYTES = Base64.decodeBase64(VALID_BASE_64.getBytes(ca.uhn.fhir.rest.api.Constants.CHARSET_UTF8));

  @Test
  @DisplayName("Passing a non Base64 encoded String to constructor causes exception.")
  public void testNonBase64String() {
    assertThrows(DataFormatException.class, () -> new Base64BinaryType(NON_BASE_64));
  }

  @Test
  @DisplayName("Passing a non Base64 encoded String to setValueAsString causes exception.")
  public void testNonBase64StringValueSet() {
    Base64BinaryType instance = new Base64BinaryType();
    assertThrows(DataFormatException.class, () -> instance.setValueAsString(NON_BASE_64));
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
  @DisplayName("setValueAsString with null argument value sets instance value as null.")
  public void testNullSetValueAsString() throws DataFormatException {
    String v = null;
    Base64BinaryType b64 = new Base64BinaryType();
    b64.setValueAsString(v);
    Assertions.assertNotNull(b64);
    Assertions.assertNull(b64.getValue());
    Assertions.assertNull(b64.getValueAsString());
  }

  @Test
  @DisplayName("Valid Base64 String creates non-null instance with non-null values.")
  public void testValid() {
    Base64BinaryType b64 = new Base64BinaryType(VALID_BASE_64);
    Assertions.assertNotNull(b64);
    Assertions.assertNotNull(b64.getValue());
    Assertions.assertEquals(VALID_BASE_64, b64.asStringValue());
  }

  @Test
  @DisplayName("Valid Base64 String creates non-null instance with non-null bytes.")
  public void testValidBytes() {
    Base64BinaryType b64 = new Base64BinaryType(VALID_BASE_64_BYTES);
    Assertions.assertNotNull(b64);
    Assertions.assertNotNull(b64.getValue());
    Assertions.assertEquals(VALID_BASE_64, b64.asStringValue());
  }

  @Test
  @DisplayName("Valid Base64 String creates non-null instance with non-null values.")
  public void testValidSetValueAsString() {
    Base64BinaryType b64 = new Base64BinaryType();
    b64.setValueAsString(VALID_BASE_64);
    Assertions.assertNotNull(b64);
    Assertions.assertNotNull(b64.getValue());
    Assertions.assertEquals(VALID_BASE_64, b64.asStringValue());
  }
}