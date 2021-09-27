package org.hl7.fhir.dstu3.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OidTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    OidType nullOid = new OidType();
    System.out.println("Value -> " + nullOid);
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    OidType nullOid = new OidType();
    OidType validOid = new OidType("urn:oid:2.16.840.1.113883.4.3.2");
    Assertions.assertFalse(nullOid.equalsDeep(validOid));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    OidType nullOid = new OidType();
    OidType validOid = new OidType("urn:oid:2.16.840.1.113883.4.3.2");
    Assertions.assertFalse(nullOid.equalsShallow(validOid));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    OidType nullOid = new OidType();
    OidType copyOid = nullOid.copy();
    Assertions.assertNull(copyOid.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    OidType nullOid = new OidType();
    OidType copyOid = (OidType) nullOid.typedCopy();
    Assertions.assertNull(copyOid.getValue());
  }
}