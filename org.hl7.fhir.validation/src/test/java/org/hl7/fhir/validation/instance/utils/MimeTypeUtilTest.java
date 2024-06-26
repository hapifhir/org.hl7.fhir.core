package org.hl7.fhir.validation.instance.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MimeTypeUtilTest {

  @ParameterizedTest
  @ValueSource(strings = {
    "application/fhir",
    "text/plain",
    "text/plain;charset=UTF-8",
    "application/octet-stream",
    "application/xhtml+xml",
  })
  public void testValidMimeTypes(String mimeType) {
    testMimeType(mimeType, true);
  }

  @ParameterizedTest
  @ValueSource(strings = {
    "application/fhir;anything", // semicolon and everything after shouldn't work if it's not a parameter=value pair
    "application/fhir;parameter=", // parameter without value shouldn't work.
  })
  public void testInvalidMimeTypes(String mimeType) {
    testMimeType(mimeType, false);
  }

  private static void testMimeType(String mimeType, boolean valid) {
    String result = MimeTypeUtil.checkValidMimeType(mimeType);
    if (valid) {
      assertNull(result);
    } else {
      assertNotNull(result);
    }
  }
}
