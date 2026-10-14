package org.hl7.fhir.model;

import org.hl7.fhir.model.core.UrlType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UrlTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      UrlType nullUrl = new UrlType();
      System.out.println("Value -> " + nullUrl);
    });
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    UrlType nullUrl = new UrlType();
    UrlType validUrl = new UrlType("tinyurl.com/45mpbc5d");
    Assertions.assertFalse(nullUrl.equalsDeep(validUrl));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    UrlType nullUrl = new UrlType();
    UrlType validUrl = new UrlType("tinyurl.com/45mpbc5d");
    Assertions.assertFalse(nullUrl.equalsShallow(validUrl));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    UrlType nullUrl = new UrlType();
    UrlType copyUrl = nullUrl.copy(Base.COPY_DATA);
    Assertions.assertNull(copyUrl.getValue());
  }

}