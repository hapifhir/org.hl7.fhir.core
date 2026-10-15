package org.hl7.fhir.utilities.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CacheVerificationLoggerTest {

  @Test
  void testCredentialsAreRedacted() {
    assertEquals("Api-Key: [redacted]", CacheVerificationLogger.redact("Api-Key: 1950c95d9a3e"));
    assertEquals("Authorization: [redacted]", CacheVerificationLogger.redact("Authorization: Bearer abc"));
    assertEquals("X-Auth-Token: [redacted]", CacheVerificationLogger.redact("X-Auth-Token: abc"));
  }

  @Test
  void testOtherHeadersAreUnchanged() {
    assertEquals("Accept: application/fhir+json; fhirVersion=4.0", CacheVerificationLogger.redact("Accept: application/fhir+json; fhirVersion=4.0"));
    assertEquals("no colon here", CacheVerificationLogger.redact("no colon here"));
  }
}
