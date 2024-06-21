package org.hl7.fhir.validation.instance.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Base64UtilTest {

  @ParameterizedTest
  @ValueSource(strings = {
    "AAAA",
    "AAAABBBB",
    "AA AA BB BB ",
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz 0123456789 /+===="
  })
  public void testValidBase64(String base64) {
    assertTrue(Base64Util.isValidBase64(base64));
  }

  @ParameterizedTest
  @ValueSource(strings = {
    "A==", // Improperly padded
    "A(B=", // Invalid character in the defualt encoding
  })
  public void testInvalidBase64(String base64) {
    assertFalse(Base64Util.isValidBase64(base64));
  }

  @ParameterizedTest
  @ValueSource(strings = {
    "AA AA",
    "AA  AA",
    "AAAA ",
    "AA\nAA",
  })
  public void testBase64WithWhitespace(String base64) {
    assertTrue(Base64Util.base64HasWhitespace(base64));
  }

  public void testBase64WithoutWhitespace(String base64) {
    assertFalse(Base64Util.base64HasWhitespace("AAAA"));
  }

  @ParameterizedTest
  @CsvSource({
    "AAAA,     3",
    "AAAABBBB, 6",
    "AAA=,     2",
  })
  public void testValidBase64(String base64, int length) {
    assertEquals(Base64Util.countBase64DecodedBytes(base64), length);
  }

}
