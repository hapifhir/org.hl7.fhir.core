package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * What the tooling says it is to a terminology server: the tool, then this library's version.
 */
class VersionUtilUserAgentTest {

  private static final String CORE = "fhir-core/" + VersionUtil.getVersion();

  @Test
  void addsTheLibraryVersionToWhatTheToolSays() {
    assertEquals("fhir/publisher " + CORE, VersionUtil.toolingUserAgent("fhir/publisher"));
    assertEquals("fhir/validator/6.9.12 " + CORE, VersionUtil.toolingUserAgent("fhir/validator/6.9.12"));
    assertEquals("fhir/publisher " + CORE, VersionUtil.toolingUserAgent("  fhir/publisher  "));
  }

  @Test
  void aToolThatSaysNothingIsStillTheLibrary() {
    assertEquals(CORE, VersionUtil.toolingUserAgent(null));
    assertEquals(CORE, VersionUtil.toolingUserAgent(""));
    assertEquals(CORE, VersionUtil.toolingUserAgent("   "));
  }

  @Test
  void isNotAddedTwice() {
    String once = VersionUtil.toolingUserAgent("fhir/publisher");
    assertEquals(once, VersionUtil.toolingUserAgent(once));
  }
}
