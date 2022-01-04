package org.hl7.fhir.r4b.model;

import org.hl7.fhir.r4b.model.UrlType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UrlTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    UrlType nullUrl = new UrlType();
    System.out.println("Value -> " + nullUrl);
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
    UrlType copyUrl = nullUrl.copy();
    Assertions.assertNull(copyUrl.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    UrlType nullUrl = new UrlType();
    UrlType copyUrl = (UrlType) nullUrl.typedCopy();
    Assertions.assertNull(copyUrl.getValue());
  }
}