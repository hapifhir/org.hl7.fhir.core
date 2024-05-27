package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CanonicalPairTest {

  @Test
  void testCanonicalNull() {
    var canonical = new CanonicalPair(null);
    assertNull(canonical.getUrl());
    assertNull(canonical.getVersion());
    assertFalse(canonical.hasVersion());
    assertFalse(canonical.hasNonEmptyVersion());
    String expectedVer = "1.0";
    String actualVer = canonical.getVersionOr(expectedVer);
    assertEquals(expectedVer, actualVer);
  }
  
  @Test
  void testCanonicalEmpty() {
    var url = "";
    var canonical = new CanonicalPair(url);
    assertEquals(url, canonical.getUrl());
    assertFalse(canonical.hasVersion());
    assertFalse(canonical.hasNonEmptyVersion());
    String expectedVer = "1.0";
    String actualVer = canonical.getVersionOr(expectedVer);
    assertEquals(expectedVer, actualVer);
  }
  
  @Test
  void testCanonicalWithoutVersion() {
    var url = "https://www.test.org";
    var canonical = new CanonicalPair(url);
    assertEquals(url, canonical.getUrl());
    assertNull(canonical.getVersion());
    assertFalse(canonical.hasVersion());
    assertFalse(canonical.hasNonEmptyVersion());
    String expectedVer = "1.0";
    String actualVer = canonical.getVersionOr(expectedVer);
    assertEquals(expectedVer, actualVer);
  }
  
  @Test
  void testCanonicalWithEmptyVersion() {
    var expectedUrl = "https://www.test.org";
    var url = expectedUrl + "|";
    var canonical = new CanonicalPair(url);
    assertEquals(expectedUrl, canonical.getUrl());
    assertEquals("", canonical.getVersion());
    assertTrue(canonical.hasVersion());
    assertFalse(canonical.hasNonEmptyVersion());
    String alternativeVer = "1.0";
    String actualVer = canonical.getVersionOr(alternativeVer);
    assertEquals("", actualVer);
  }

  @Test
  void testCanonicalWithVersion() {
    var expectedUrl = "https://www.test.org";
    var expectedVersion = "2.6";
    var url = expectedUrl + "|" + expectedVersion;
    var canonical = new CanonicalPair(url);
    assertEquals(expectedUrl, canonical.getUrl());
    assertEquals(expectedVersion, canonical.getVersion());
    assertTrue(canonical.hasVersion());
    assertTrue(canonical.hasNonEmptyVersion());
    String alternativeVer = "1.0";
    String actualVer = canonical.getVersionOr(alternativeVer);
    assertEquals(expectedVersion, actualVer);
  }

  @Test
  void testCanonicalWithVersionIncludingPipe() {
    var expectedUrl = "https://www.test.org";
    var expectedVersion = "2024|05";
    var url = expectedUrl + "|" + expectedVersion;
    var canonical = new CanonicalPair(url);
    assertEquals(expectedUrl, canonical.getUrl());
    assertEquals(expectedVersion, canonical.getVersion());
    assertTrue(canonical.hasVersion());
    assertTrue(canonical.hasNonEmptyVersion());
    String alternativeVer = "1.0";
    String actualVer = canonical.getVersionOr(alternativeVer);
    assertEquals(expectedVersion, actualVer);
  }
  
}
