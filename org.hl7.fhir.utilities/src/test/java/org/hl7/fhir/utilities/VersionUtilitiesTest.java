package org.hl7.fhir.utilities;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.security.sasl.SaslServer;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VersionUtilitiesTest {

  @Test
  public void isValidSemVer() {
    assertTrue(VersionUtilities.isSemVer("0.1.1"));
    assertTrue(VersionUtilities.isSemVer("0.1.1-ballot1"));
    assertTrue(VersionUtilities.isSemVer("0.0.0-alpha.0.131"));
    assertFalse(VersionUtilities.isSemVer("0.1.a"));
  }

  @Test
  public void isThisOrLater_Simple() {
    assertTrue(VersionUtilities.isThisOrLaterMajorMinor("0.1", "0.2"));
    assertFalse(VersionUtilities.isThisOrLaterMajorMinor("0.2", "0.1"));
  }

  @Test
  public void isThisOrLater_NeedNumericComparison() {
    assertTrue(VersionUtilities.isThisOrLaterMajorMinor("0.9", "0.10"));
    assertFalse(VersionUtilities.isThisOrLaterMajorMinor("0.10", "0.9"));
  }

  @Test
  public void isThisOrLater_DifferentLengths() {
    assertTrue(VersionUtilities.isThisOrLaterMajorMinor("0.9", "0.9.1"));
    assertTrue(VersionUtilities.isThisOrLaterMajorMinor("0.9.1", "0.9"));

    assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("0.9", "0.9.1"));
    assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("0.9.1", "0.9"));
  }

  @Test
  public void isThisOrLater_NonNumeric() {
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLaterMajorMinor("0.A", "0.B"));
    Assertions.assertThrows(FHIRException.class, () ->VersionUtilities.isThisOrLaterMajorMinor("0.B", "0.A"));
  }


  @Test
  public void isMajMinOrLaterPatch_Simple() {
    assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("0.9.0", "0.9.0"));
    assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("0.9.0", "0.9.1"));
    assertFalse(VersionUtilities.isThisOrLaterMajorMinor("0.9.0", "0.8.1"));
  }

  @Test
  public void isMajMinOrLaterPatch_VersionWithX() {
    assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("0.9.x", "0.9.0"));
    assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("0.9.x", "0.9.1"));
    assertFalse(VersionUtilities.isThisOrLaterMajorMinor("0.9.x", "0.8.1"));
  }

  @Test 
  public void bugFixTests() {
    assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.0.0-ballot", "1.0.1"));
    assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("3.1.x", "3.1.1"));
    assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("3.0.x", "3.1.1"));
    assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("3.1.1", "3.0.x"));

    assertFalse(VersionUtilities.versionsMatch("3.1.1", "3.0.x"));
  }

  // I asked Claude to break this thing, to really torture it (Claude's words!) and this is
  // what I got:

  // =============================================
  // getMajMin() TESTS
  // =============================================

  @Test
  public void testGetMajMin_StandardSemver() {
    Assertions.assertEquals("1.0", VersionUtilities.getMajMin("1.0.0"));
    Assertions.assertEquals("2.1", VersionUtilities.getMajMin("2.1.3"));
    Assertions.assertEquals("10.5", VersionUtilities.getMajMin("10.5.2"));
    Assertions.assertEquals("0.9", VersionUtilities.getMajMin("0.9.1"));
  }

  @Test
  public void testGetMajMin_WithPrerelease() {
    Assertions.assertEquals("1.0", VersionUtilities.getMajMin("1.0.0-alpha"));
    Assertions.assertEquals("2.1", VersionUtilities.getMajMin("2.1.0-beta.1"));
    Assertions.assertEquals("3.2", VersionUtilities.getMajMin("3.2.5-rc.2"));
  }

  @Test
  public void testGetMajMin_TwoPartVersions() {
    Assertions.assertEquals("1.0", VersionUtilities.getMajMin("1.0"));
    Assertions.assertEquals("2.5", VersionUtilities.getMajMin("2.5"));
  }

  @Test
  public void testGetMajMin_SinglePartVersions() {
    Assertions.assertNull(VersionUtilities.getMajMin("1"));
    Assertions.assertNull(VersionUtilities.getMajMin("5"));
  }

  @Test
  public void testGetMajMin_FhirSpecialVersions() {
    Assertions.assertEquals("1.0", VersionUtilities.getMajMin("r2"));
    Assertions.assertEquals("3.0", VersionUtilities.getMajMin("r3"));
    Assertions.assertEquals("4.0", VersionUtilities.getMajMin("r4"));
    Assertions.assertEquals("4.3", VersionUtilities.getMajMin("r4B"));
    Assertions.assertEquals("5.0", VersionUtilities.getMajMin("r5"));
    Assertions.assertEquals("6.0", VersionUtilities.getMajMin("r6"));

    // Test uppercase variants
    Assertions.assertEquals("1.0", VersionUtilities.getMajMin("R2"));
    Assertions.assertEquals("3.0", VersionUtilities.getMajMin("R3"));
    Assertions.assertEquals("4.0", VersionUtilities.getMajMin("R4"));
    Assertions.assertEquals("4.3", VersionUtilities.getMajMin("R4B"));
    Assertions.assertEquals("5.0", VersionUtilities.getMajMin("R5"));
    Assertions.assertEquals("6.0", VersionUtilities.getMajMin("R6"));
  }

  @Test
  public void testGetMajMin_EdgeCases() {
    Assertions.assertEquals("0.0", VersionUtilities.getMajMin("0.0.0"));
    Assertions.assertEquals("0.1", VersionUtilities.getMajMin("0.1.0"));
    Assertions.assertEquals("100.200", VersionUtilities.getMajMin("100.200.300"));
  }

  // =============================================
  // getMajMinPatch() TESTS
  // =============================================

  @Test
  public void testGetMajMinPatch_StandardSemver() {
    Assertions.assertEquals("1.0.0", VersionUtilities.getMajMinPatch("1.0.0"));
    Assertions.assertEquals("2.1.3", VersionUtilities.getMajMinPatch("2.1.3"));
    Assertions.assertEquals("10.5.2", VersionUtilities.getMajMinPatch("10.5.2"));
  }

  @Test
  public void testGetMajMinPatch_WithPrerelease() {
    Assertions.assertEquals("1.0.0", VersionUtilities.getMajMinPatch("1.0.0-alpha"));
    Assertions.assertEquals("2.1.0", VersionUtilities.getMajMinPatch("2.1.0-beta.1"));
    Assertions.assertEquals("3.2.5", VersionUtilities.getMajMinPatch("3.2.5-rc.2"));
  }

  @Test
  public void testGetMajMinPatch_TwoPartVersions() {
    Assertions.assertEquals("1.0.0", VersionUtilities.getMajMinPatch("1.0"));
    Assertions.assertEquals("2.5.0", VersionUtilities.getMajMinPatch("2.5"));
  }

  @Test
  public void testGetMajMinPatch_SinglePartVersions() {
    Assertions.assertNull(VersionUtilities.getMajMinPatch("1"));
    Assertions.assertNull(VersionUtilities.getMajMinPatch("5"));
  }

  @Test
  public void testGetMajMinPatch_FhirSpecialVersions() {
    Assertions.assertEquals("1.0.2", VersionUtilities.getMajMinPatch("r2"));
    Assertions.assertEquals("3.0.2", VersionUtilities.getMajMinPatch("r3"));
    Assertions.assertEquals("4.0.1", VersionUtilities.getMajMinPatch("r4"));
    Assertions.assertEquals("4.3.0", VersionUtilities.getMajMinPatch("r4B"));
    Assertions.assertEquals("5.0.0", VersionUtilities.getMajMinPatch("r5"));
    Assertions.assertEquals("6.0.0", VersionUtilities.getMajMinPatch("r6"));
  }

  // =============================================
  // getPatch() TESTS
  // =============================================

  @Test
  public void testGetPatch_StandardSemver() {
    Assertions.assertEquals("0", VersionUtilities.getPatch("1.0.0"));
    Assertions.assertEquals("3", VersionUtilities.getPatch("2.1.3"));
    Assertions.assertEquals("15", VersionUtilities.getPatch("1.2.15"));
  }

  @Test
  public void testGetPatch_WithPrerelease() {
    Assertions.assertEquals("0", VersionUtilities.getPatch("1.0.0-alpha"));
    Assertions.assertEquals("5", VersionUtilities.getPatch("2.1.5-beta.1"));
    Assertions.assertEquals("10", VersionUtilities.getPatch("3.2.10-rc.2"));
  }

  @Test
  public void testGetPatch_TwoPartVersions() {
    Assertions.assertEquals("0", VersionUtilities.getPatch("1.0"));
    Assertions.assertEquals("0", VersionUtilities.getPatch("2.5"));
  }

  @Test
  public void testGetPatch_SinglePartVersions() {
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.getPatch("1"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.getPatch("5"));
  }

  @Test
  public void testGetPatch_FhirSpecialVersions() {
    Assertions.assertEquals("2", VersionUtilities.getPatch("r2"));
    Assertions.assertEquals("2", VersionUtilities.getPatch("r3"));
    Assertions.assertEquals("1", VersionUtilities.getPatch("r4"));
    Assertions.assertEquals("0", VersionUtilities.getPatch("r4B"));
    Assertions.assertEquals("0", VersionUtilities.getPatch("r5"));
    Assertions.assertEquals("0", VersionUtilities.getPatch("r6"));
  }

  // =============================================
  // isSemVer() TESTS
  // =============================================

  @Test
  public void testIsSemVer_ValidSemver() {
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0"));
    Assertions.assertTrue(VersionUtilities.isSemVer("2.1.3"));
    Assertions.assertTrue(VersionUtilities.isSemVer("10.20.30"));
    Assertions.assertTrue(VersionUtilities.isSemVer("0.0.1"));
  }

  @Test
  public void testIsSemVer_ValidSemverWithPrerelease() {
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-alpha"));
    Assertions.assertTrue(VersionUtilities.isSemVer("2.1.0-beta.1"));
    Assertions.assertTrue(VersionUtilities.isSemVer("3.2.5-rc.2"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-alpha.beta"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-alpha.1"));
  }

  @Test
  public void testIsSemVer_ValidTwoPartVersions() {
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0"));
    Assertions.assertTrue(VersionUtilities.isSemVer("2.5"));
    Assertions.assertTrue(VersionUtilities.isSemVer("10.15"));
  }

  @Test
  public void testIsSemVer_ValidSinglePartVersions() {
    Assertions.assertFalse(VersionUtilities.isSemVer("1"));
    Assertions.assertFalse(VersionUtilities.isSemVer("5"));
    Assertions.assertFalse(VersionUtilities.isSemVer("10"));
  }

  @Test
  public void testIsSemVer_FhirSpecialVersions() {
    Assertions.assertFalse(VersionUtilities.isSemVer("r2"));
    Assertions.assertFalse(VersionUtilities.isSemVer("r3"));
    Assertions.assertFalse(VersionUtilities.isSemVer("r4"));
    Assertions.assertFalse(VersionUtilities.isSemVer("r4B"));
    Assertions.assertFalse(VersionUtilities.isSemVer("r5"));
    Assertions.assertFalse(VersionUtilities.isSemVer("r6"));

    Assertions.assertFalse(VersionUtilities.isSemVer("R2"));
    Assertions.assertFalse(VersionUtilities.isSemVer("R3"));
    Assertions.assertFalse(VersionUtilities.isSemVer("R4"));
    Assertions.assertFalse(VersionUtilities.isSemVer("R4B"));
    Assertions.assertFalse(VersionUtilities.isSemVer("R5"));
    Assertions.assertFalse(VersionUtilities.isSemVer("R6"));
  }

  @Test
  public void testIsSemVer_InvalidVersions() {
    Assertions.assertFalse(VersionUtilities.isSemVer(""));
    Assertions.assertFalse(VersionUtilities.isSemVer(null));
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0.0"));
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0."));
    Assertions.assertFalse(VersionUtilities.isSemVer("1..0"));
    Assertions.assertFalse(VersionUtilities.isSemVer("a.b.c"));
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-"));
    Assertions.assertFalse(VersionUtilities.isSemVer("r7")); // Invalid FHIR version
    Assertions.assertFalse(VersionUtilities.isSemVer("r")); // Invalid FHIR version
  }

  // =============================================
  // isThisOrLater() TESTS
  // =============================================

  @Test
  public void testIsThisOrLater_SameVersions() {
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.0.0", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("2.1.3", "2.1.3"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("r4", "r4"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("R5", "r5")); // Case insensitive
  }

  @Test
  public void testIsThisOrLater_LaterVersions() {
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.0.0", "1.0.1"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.0.0", "1.1.0"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.0.0", "2.0.0"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("2.1.0", "2.1.5"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("r3", "r4"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("r4", "r5"));
  }

  @Test
  public void testIsThisOrLater_EarlierVersions() {
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.0.1", "1.0.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinor("1.1.0", "1.0.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinor("2.0.0", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("2.1.5", "2.1.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinor("r4", "r3"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinor("r5", "r4"));

    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("1.0.1", "1.0.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("1.1.0", "1.0.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("2.0.0", "1.0.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("2.1.5", "2.1.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("r4", "r3"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("r5", "r4"));
  }

  @Test
  public void testIsThisOrLater_NumericVsTextComparison() {
    // Numeric comparison: 0.9 < 0.10
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("0.9", "0.10"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.9", "1.10"));

    // Text comparison fallback for non-numeric
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.0.0-alpha", "1.0.0-beta"));
  }

  @Test
  public void testIsThisOrLater_MixedDepths() {
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("1.0", "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLaterMajorMinor("1", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinor("2.0", "2.1"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinor("2.1", "2.0"));

    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("1.0", "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLaterMajorMinorPatch("1", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("2.0", "2.1"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("2.1", "2.0"));
  }

  // =============================================
  // isMajMinOrLaterPatch() TESTS
  // =============================================

  @Test
  public void testIsMajMinOrLaterPatch_SameMajorMinor() {
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("1.0.0", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("1.0.0", "1.0.1"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("1.0.0", "1.0.10"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("2.1.0", "2.1.5"));
  }

  @Test
  public void testIsMajMinOrLaterPatch_DifferentMajorMinor() {
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("1.0.0", "1.1.0"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("1.0.0", "2.0.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("2.1.0", "2.0.5"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("2.1.0", "3.1.0"));
  }

  @Test
  public void testIsMajMinOrLaterPatch_EarlierPatch() {
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("1.0.5", "1.0.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("2.1.10", "2.1.5"));
  }

  @Test
  public void testIsMajMinOrLaterPatch_FhirVersions() {
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("r4", "r4"));
    Assertions.assertTrue(VersionUtilities.isThisOrLaterMajorMinorPatch("r4", "r5"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinorPatch("r5", "r4"));
  }

  // =============================================
  // incMajorVersion() TESTS
  // =============================================

  @Test
  public void testIncMajorVersion_StandardSemver() {
    Assertions.assertEquals("2.0.0", VersionUtilities.incMajorVersion("1.0.0"));
    Assertions.assertEquals("3.0.0", VersionUtilities.incMajorVersion("2.5.10"));
    Assertions.assertEquals("11.0.0", VersionUtilities.incMajorVersion("10.20.30"));
    Assertions.assertEquals("1.0.0", VersionUtilities.incMajorVersion("0.9.5"));
  }

  @Test
  public void testIncMajorVersion_WithPrerelease() {
    Assertions.assertEquals("2.0.0", VersionUtilities.incMajorVersion("1.0.0-alpha"));
    Assertions.assertEquals("3.0.0", VersionUtilities.incMajorVersion("2.1.0-beta.1"));
  }

  @Test
  public void testIncMajorVersion_TwoPartVersions() {
    Assertions.assertEquals("2.0.0", VersionUtilities.incMajorVersion("1.5"));
    Assertions.assertEquals("4.0.0", VersionUtilities.incMajorVersion("3.0"));
  }

  @Test
  public void testIncMajorVersion_SinglePartVersions() {
    Assertions.assertThrows(FHIRException.class, () ->VersionUtilities.incMajorVersion("1"));
    Assertions.assertThrows(FHIRException.class, () ->VersionUtilities.incMajorVersion("6"));
  }

  // =============================================
  // incMinorVersion() TESTS (this one has implementation)
  // =============================================

  @Test
  public void testIncMinorVersion_StandardSemver() {
    Assertions.assertEquals("1.1.0", VersionUtilities.incMinorVersion("1.0.0"));
    Assertions.assertEquals("2.6.0", VersionUtilities.incMinorVersion("2.5.10"));
    Assertions.assertEquals("10.21.0", VersionUtilities.incMinorVersion("10.20.30"));
  }

  @Test
  public void testIncMinorVersion_WithPrerelease() {
    Assertions.assertEquals("1.1.0", VersionUtilities.incMinorVersion("1.0.0-alpha"));
    Assertions.assertEquals("2.2.0", VersionUtilities.incMinorVersion("2.1.0-beta.1"));
  }

  @Test
  public void testIncMinorVersion_TwoPartVersions() {
    Assertions.assertEquals("1.6.0", VersionUtilities.incMinorVersion("1.5"));
    Assertions.assertEquals("3.1.0", VersionUtilities.incMinorVersion("3.0"));
  }

  // =============================================
  // incPatchVersion() TESTS
  // =============================================

  @Test
  public void testIncPatchVersion_StandardSemver() {
    Assertions.assertEquals("1.0.1", VersionUtilities.incPatchVersion("1.0.0"));
    Assertions.assertEquals("2.5.11", VersionUtilities.incPatchVersion("2.5.10"));
    Assertions.assertEquals("10.20.31", VersionUtilities.incPatchVersion("10.20.30"));
  }

  @Test
  public void testIncPatchVersion_WithPrerelease() {
    Assertions.assertEquals("1.0.1", VersionUtilities.incPatchVersion("1.0.0-alpha"));
    Assertions.assertEquals("2.1.1", VersionUtilities.incPatchVersion("2.1.0-beta.1"));
  }

  @Test
  public void testIncPatchVersion_TwoPartVersions() {
    Assertions.assertEquals("1.5.1", VersionUtilities.incPatchVersion("1.5"));
    Assertions.assertEquals("3.0.1", VersionUtilities.incPatchVersion("3.0"));
  }

  @Test
  public void testIncPatchVersion_SinglePartVersions() {
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.incPatchVersion("1"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.incPatchVersion("5"));
  }

  // =============================================
  // versionsMatch() TESTS
  // =============================================

  @Test
  public void testVersionsMatch_ExactMatches() {
    Assertions.assertTrue(VersionUtilities.versionsMatch("1.0.0", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("2.1.5", "2.1.5"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("r4", "r4"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("R5", "r5")); // Case insensitive
  }

  @Test
  public void testVersionsMatch_MajorMinorMatches() {
    Assertions.assertTrue(VersionUtilities.versionsMatch("1.0.0", "1.0.5"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("2.1.0", "2.1.10"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("1.0", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("1.0.0", "1.0"));
  }

  @Test
  public void testVersionsMatch_NoMatches() {
    Assertions.assertFalse(VersionUtilities.versionsMatch("1.0.0", "1.1.0"));
    Assertions.assertFalse(VersionUtilities.versionsMatch("1.0.0", "2.0.0"));
    Assertions.assertFalse(VersionUtilities.versionsMatch("r4", "r5"));
    Assertions.assertFalse(VersionUtilities.versionsMatch("2.1.0", "2.0.5"));
  }

  @Test
  public void testVersionsMatch_WithPrerelease() {
    Assertions.assertTrue(VersionUtilities.versionsMatch("1.0.0-alpha", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("2.1.0", "2.1.0-beta"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("1.0.0-alpha", "1.0.0-beta"));
  }

  @Test
  public void testVersionsMatch_List() {
    List<String> versions = Arrays.asList("1.0.0", "2.1.0", "3.0.0", "r4", "r5");

    Assertions.assertTrue(VersionUtilities.versionsMatchList("1.0.5", versions)); // Matches 1.0.0
    Assertions.assertTrue(VersionUtilities.versionsMatchList("2.1.10", versions)); // Matches 2.1.0
    Assertions.assertTrue(VersionUtilities.versionsMatchList("r4", versions));
    Assertions.assertTrue(VersionUtilities.versionsMatchList("R5", versions)); // Case insensitive

    Assertions.assertFalse(VersionUtilities.versionsMatchList("1.1.0", versions));
    Assertions.assertTrue(VersionUtilities.versionsMatchList("4.0.1", versions));
    Assertions.assertFalse(VersionUtilities.versionsMatchList("r6", versions));
  }

  // =============================================
  // FHIR VERSION SPECIFIC TESTS
  // =============================================

  @Test
  public void testIsR5VerOrLater() {
    Assertions.assertTrue(VersionUtilities.isR5Plus("r5"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("R5"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("r6"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("5.0.0"));
    Assertions.assertFalse(VersionUtilities.isR5Plus("5.1.0"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("6.0.0"));

    Assertions.assertFalse(VersionUtilities.isR5Plus("r4"));
    Assertions.assertFalse(VersionUtilities.isR5Plus("r4B"));
    Assertions.assertFalse(VersionUtilities.isR5Plus("4.0.0"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("4.5.0"));
  }

  @Test
  public void testIsR4Plus() {
    Assertions.assertTrue(VersionUtilities.isR4Plus("r4"));
    Assertions.assertTrue(VersionUtilities.isR4Plus("R4"));
    Assertions.assertTrue(VersionUtilities.isR4Plus("r4B"));
    Assertions.assertTrue(VersionUtilities.isR4Plus("r5"));
    Assertions.assertTrue(VersionUtilities.isR4Plus("r6"));
    Assertions.assertTrue(VersionUtilities.isR4Plus("4.0.0"));
    Assertions.assertTrue(VersionUtilities.isR4Plus("4.1.0"));
    Assertions.assertTrue(VersionUtilities.isR4Plus("5.0.0"));
    Assertions.assertTrue(VersionUtilities.isR4Plus("3.2.0")); // Pre-release R4

    Assertions.assertFalse(VersionUtilities.isR4Plus("r3"));
    Assertions.assertFalse(VersionUtilities.isR4Plus("3.0.0"));
    Assertions.assertFalse(VersionUtilities.isR4Plus("3.1.0"));
  }

  @Test
  public void testIsR5Plus() {
    Assertions.assertTrue(VersionUtilities.isR5Plus("r5"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("R5"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("r6"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("5.0.0"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("6.0.0"));
    Assertions.assertTrue(VersionUtilities.isR5Plus("4.5.0")); // Pre-release R5

    Assertions.assertFalse(VersionUtilities.isR5Plus("r4"));
    Assertions.assertFalse(VersionUtilities.isR5Plus("r4B"));
    Assertions.assertFalse(VersionUtilities.isR5Plus("4.0.0"));
    Assertions.assertFalse(VersionUtilities.isR5Plus("4.4.0"));
  }

  @Test
  public void testIsR6Plus() {
    Assertions.assertTrue(VersionUtilities.isR6Plus("r6"));
    Assertions.assertTrue(VersionUtilities.isR6Plus("R6"));
    Assertions.assertTrue(VersionUtilities.isR6Plus("6.0.0"));

    Assertions.assertFalse(VersionUtilities.isR6Plus("r5"));
    Assertions.assertFalse(VersionUtilities.isR6Plus("r4"));
    Assertions.assertFalse(VersionUtilities.isR6Plus("5.0.0"));
    Assertions.assertFalse(VersionUtilities.isR6Plus("4.0.0"));
  }

  // =============================================
  // removeVersionFromCanonical() TESTS
  // =============================================

  @Test
  public void testRemoveVersionFromCanonical_WithVersion() {
    Assertions.assertEquals("http://example.com/CodeSystem",
      VersionUtilities.removeVersionFromCanonical("http://example.com/CodeSystem|1.0.0"));
    Assertions.assertEquals("http://hl7.org/fhir/CodeSystem/test",
      VersionUtilities.removeVersionFromCanonical("http://hl7.org/fhir/CodeSystem/test|2.1.5"));
    Assertions.assertEquals("http://test.org/cs",
      VersionUtilities.removeVersionFromCanonical("http://test.org/cs|r4"));
  }

  @Test
  public void testRemoveVersionFromCanonical_WithoutVersion() {
    Assertions.assertEquals("http://example.com/CodeSystem",
      VersionUtilities.removeVersionFromCanonical("http://example.com/CodeSystem"));
    Assertions.assertEquals("http://hl7.org/fhir/CodeSystem/test",
      VersionUtilities.removeVersionFromCanonical("http://hl7.org/fhir/CodeSystem/test"));
  }

  @Test
  public void testRemoveVersionFromCanonical_EdgeCases() {
    Assertions.assertEquals("", VersionUtilities.removeVersionFromCanonical("|1.0.0"));
    Assertions.assertEquals("test", VersionUtilities.removeVersionFromCanonical("test|"));
    Assertions.assertEquals("", VersionUtilities.removeVersionFromCanonical(""));
    Assertions.assertNull(VersionUtilities.removeVersionFromCanonical(null));
  }

  // =============================================
  // compareVersions() TESTS
  // =============================================

  @Test
  public void testCompareVersions_Equal() {
    Assertions.assertEquals(0, VersionUtilities.compareVersions("1.0.0", "1.0.0"));
    Assertions.assertEquals(0, VersionUtilities.compareVersions("2.1.5", "2.1.5"));
    Assertions.assertEquals(0, VersionUtilities.compareVersions("r4", "r4"));
    Assertions.assertEquals(0, VersionUtilities.compareVersions("R5", "r5")); // Case insensitive
  }

  @Test
  public void testCompareVersions_FirstIsLater() {
    Assertions.assertEquals(1, VersionUtilities.compareVersions("1.0.1", "1.0.0"));
    Assertions.assertEquals(1, VersionUtilities.compareVersions("1.1.0", "1.0.0"));
    Assertions.assertEquals(1, VersionUtilities.compareVersions("2.0.0", "1.0.0"));
    Assertions.assertEquals(1, VersionUtilities.compareVersions("r5", "r4"));
    Assertions.assertEquals(1, VersionUtilities.compareVersions("2.1.0", "2.0.5"));
  }

  @Test
  public void testCompareVersions_SecondIsLater() {
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0", "1.0.1"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0", "1.1.0"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0", "2.0.0"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("r4", "r5"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("2.0.5", "2.1.0"));
  }

  @Test
  public void testCompareVersions_Prerelease() {
    Assertions.assertEquals(1, VersionUtilities.compareVersions("1.0.0", "1.0.0-alpha"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-alpha", "1.0.0-beta"));
    Assertions.assertEquals(1, VersionUtilities.compareVersions("1.0.0-beta", "1.0.0-alpha"));
  }

  @Test
  public void testCompareVersions_MixedDepths() {
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0", "1.0.0"));
    Assertions.assertThrows(FHIRException.class,  () -> VersionUtilities.compareVersions("1", "1.0.0"));
    Assertions.assertEquals(1, VersionUtilities.compareVersions("1.1", "1.0"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0", "1.1"));
  }

  // =============================================
  // includedInRange() TESTS
  // =============================================

  @Test
  public void testIncludedInRange_WithinRange() {
    Assertions.assertTrue(VersionUtilities.includedInRange("1.0.0", "2.0.0", "1.5.0"));
    Assertions.assertTrue(VersionUtilities.includedInRange("r3", "r5", "r4"));
    Assertions.assertTrue(VersionUtilities.includedInRange("2.0.0", "3.0.0", "2.1.5"));
    Assertions.assertTrue(VersionUtilities.includedInRange("1.0", "2.0", "1.5"));
  }

  @Test
  public void testIncludedInRange_AtBounds() {
    Assertions.assertTrue(VersionUtilities.includedInRange("1.0.0", "2.0.0", "1.0.0"));
    Assertions.assertTrue(VersionUtilities.includedInRange("1.0.0", "2.0.0", "2.0.0"));
    Assertions.assertTrue(VersionUtilities.includedInRange("r3", "r5", "r3"));
    Assertions.assertTrue(VersionUtilities.includedInRange("r3", "r5", "r5"));
  }

  @Test
  public void testIncludedInRange_OutsideRange() {
    Assertions.assertFalse(VersionUtilities.includedInRange("1.0.0", "2.0.0", "0.9.0"));
    Assertions.assertFalse(VersionUtilities.includedInRange("1.0.0", "2.0.0", "2.0.1"));
    Assertions.assertFalse(VersionUtilities.includedInRange("r3", "r5", "r2"));
    Assertions.assertFalse(VersionUtilities.includedInRange("r3", "r5", "r6"));
  }

  @Test
  public void testIncludedInRange_SpecialVersions() {
    Assertions.assertTrue(VersionUtilities.includedInRange("r3", "r5", "r4"));
    Assertions.assertTrue(VersionUtilities.includedInRange("r3", "r5", "r4B"));
    Assertions.assertTrue(VersionUtilities.includedInRange("R3", "R5", "r4")); // Case insensitive
  }

  // =============================================
  // iterateCoreVersions() TESTS
  // =============================================

  @Test
  public void testIterateCoreVersions_FhirRange() {
    List<String> versions = VersionUtilities.iterateCoreVersions("r3", "r5");
    Assertions.assertTrue(versions.contains("3.0"));
    Assertions.assertTrue(versions.contains("4.0"));
    Assertions.assertTrue(versions.contains("5.0"));
    Assertions.assertFalse(versions.contains("1.0"));
    Assertions.assertFalse(versions.contains("6.0"));
  }

  @Test
  public void testIterateCoreVersions_SemverRange() {
    List<String> versions = VersionUtilities.iterateCoreVersions("3.0.0", "5.0.0");
    Assertions.assertTrue(versions.contains("3.0"));
    Assertions.assertTrue(versions.contains("4.0"));
    Assertions.assertTrue(versions.contains("5.0"));
    Assertions.assertFalse(versions.contains("2.0"));
    Assertions.assertFalse(versions.contains("6.0"));
  }

  @Test
  public void testIterateCoreVersions_SingleVersion() {
    List<String> versions = VersionUtilities.iterateCoreVersions("r4", "r4");
    Assertions.assertEquals(1, versions.size());
    Assertions.assertTrue(versions.contains("4.0"));
  }

  @Test
  public void testIterateCoreVersions_IncludesR4B() {
    List<String> versions = VersionUtilities.iterateCoreVersions("r4", "r5");
    Assertions.assertTrue(versions.contains("4.0"));
    Assertions.assertTrue(versions.contains("4.3")); // r4B
    Assertions.assertTrue(versions.contains("5.0"));
  }

  // =============================================
  // EDGE CASE AND ERROR HANDLING TESTS
  // =============================================

  @Test
  public void testNullHandling() {
    Assertions.assertNull(VersionUtilities.getMajMin(null));
    Assertions.assertNull(VersionUtilities.getMajMinPatch(null));
    Assertions.assertNull(VersionUtilities.getPatch(null));
    Assertions.assertFalse(VersionUtilities.isSemVer(null));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinor(null, "1.0.0"));
    Assertions.assertFalse(VersionUtilities.isThisOrLaterMajorMinor("1.0.0", null));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionsMatch(null, "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionsMatch("1.0.0", null));
  }

  @Test
  public void testEmptyStringHandling() {
    Assertions.assertEquals(null, VersionUtilities.getMajMin(""));
    Assertions.assertEquals(null, VersionUtilities.getMajMinPatch(""));
    Assertions.assertEquals(null, VersionUtilities.getPatch(""));
    Assertions.assertFalse(VersionUtilities.isSemVer(""));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLaterMajorMinor("", "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLaterMajorMinor("1.0.0", ""));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionsMatch("", "1.0.0"));
  }

  @Test
  public void testMalformedVersions() {
    String[] malformed = {"1.0.0.0", "1.0.", "1..0", "a.b.c", "1.0.0-", ".1.0", "1.0.-1"};

    for (String version : malformed) {
      Assertions.assertFalse(VersionUtilities.isSemVer(version), "Should be invalid: " + version);
    }
  }

  @Test
  public void testLargeVersionNumbers() {
    Assertions.assertEquals("999.888", VersionUtilities.getMajMin("999.888.777"));
    Assertions.assertEquals("999.888.777", VersionUtilities.getMajMinPatch("999.888.777"));
    Assertions.assertEquals("777", VersionUtilities.getPatch("999.888.777"));
    Assertions.assertTrue(VersionUtilities.isSemVer("999.888.777"));
  }

  @Test
  public void testVersionsWithBuildMetadata() {
    Assertions.assertEquals("1.0", VersionUtilities.getMajMin("1.0.0+build.1"));
    Assertions.assertEquals("1.0.0", VersionUtilities.getMajMinPatch("1.0.0+build.1"));
    Assertions.assertEquals("0", VersionUtilities.getPatch("1.0.0+build.1"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0+build.1"));
  }

   // Then I asked Claude for even more!

  // =============================================
  // COMPLEX LABEL COMBINATIONS
  // =============================================

  @Test
  public void testisSemVer() {
    // According to semver: X.Y.Z-prerelease+build but we accept major.minor
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0"));
    Assertions.assertTrue(VersionUtilities.isSemVer("0.0"));
    Assertions.assertTrue(VersionUtilities.isSemVer("0.1"));
    Assertions.assertFalse(VersionUtilities.isSemVer("1"));
    Assertions.assertFalse(VersionUtilities.isSemVer("0"));
    Assertions.assertTrue(VersionUtilities.isSemVer("2.80"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0-label"));
    Assertions.assertTrue(VersionUtilities.isSemVer("0.0-label"));
    Assertions.assertTrue(VersionUtilities.isSemVer("0.1-label"));
    Assertions.assertFalse(VersionUtilities.isSemVer("1-label"));
    Assertions.assertFalse(VersionUtilities.isSemVer("0-label"));
    Assertions.assertTrue(VersionUtilities.isSemVer("2.80-label"));
  }

  @Test
  public void testComplexLabels_ValidSemverLabels() {
    // According to semver: X.Y.Z-prerelease+build
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-alpha+build"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-alpha-beta+build-123"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-alpha.1+build.2"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-0.1.2+build.3.4"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0+build-only"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-prerelease-only"));

    // Complex prerelease identifiers
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-alpha.beta.gamma"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-1.2.3"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-x.7.z.92"));
  }

  @Test
  public void testComplexLabels_InvalidSemverLabels() {
    // Invalid according to semver spec
    Assertions.assertTrue(VersionUtilities.isSemVer("1.2-label")); // Missing patch - is allowed
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-")); // Empty prerelease
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0+")); // Empty build
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-+build")); // Empty prerelease with build
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-alpha+")); // Empty build after prerelease
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0+build-alpha")); // build can contain '-'
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0--alpha")); // Double dash
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-+alpha")); // Double dash
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0+-build")); // Double plus - totally valid (weird, though)
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0++build")); // Double plus - totally valid (weird, though)
  }

  @Test
  public void testMalformedVersions_DotsAndStructure() {
    // Various malformed structures
    Assertions.assertFalse(VersionUtilities.isSemVer("1..3")); // Empty minor
    Assertions.assertFalse(VersionUtilities.isSemVer("1.2.")); // Trailing dot
    Assertions.assertFalse(VersionUtilities.isSemVer(".1.2")); // Leading dot
    Assertions.assertFalse(VersionUtilities.isSemVer("1.2.3.")); // Trailing dot after patch
    Assertions.assertFalse(VersionUtilities.isSemVer("1...3")); // Multiple dots
    Assertions.assertFalse(VersionUtilities.isSemVer("1.2.3.4.5")); // Too many parts
    Assertions.assertFalse(VersionUtilities.isSemVer("")); // Empty
    Assertions.assertFalse(VersionUtilities.isSemVer(".")); // Just dot
    Assertions.assertFalse(VersionUtilities.isSemVer("..")); // Just dots
  }

  @Test
  public void testLeadingZeros() {
    // Leading zeros should be invalid in semver
    Assertions.assertFalse(VersionUtilities.isSemVer("01.0.0"));
    Assertions.assertFalse(VersionUtilities.isSemVer("1.01.0"));
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.01"));
    Assertions.assertFalse(VersionUtilities.isSemVer("001.002.003"));

    // But zero by itself should be fine
    Assertions.assertTrue(VersionUtilities.isSemVer("0.0.0"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0"));

    // Leading zeros in prerelease/build identifiers not ok?
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-01"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0+01"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0-1"));
    Assertions.assertTrue(VersionUtilities.isSemVer("1.0.0+1"));
  }

  // =============================================
  // UNICODE AND SPECIAL CHARACTERS
  // =============================================

  @Test
  public void testUnicodeCharacters() {
    // Unicode in prerelease
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-α")); // Greek alpha
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-测试")); // Chinese characters
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-🚀")); // Emoji
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0-café")); // Accented characters

    // Unicode in version numbers themselves
    Assertions.assertFalse(VersionUtilities.isSemVer("１.０.０")); // Full-width numbers
    Assertions.assertFalse(VersionUtilities.isSemVer("1.０.0")); // Mixed full-width

    // Zero-width characters
    Assertions.assertFalse(VersionUtilities.isSemVer("1\u200B.0.0")); // Zero-width space
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0\uFEFF.0")); // BOM
  }

  @Test
  public void testControlCharacters() {
    // Control characters
    Assertions.assertFalse(VersionUtilities.isSemVer("1\n.0.0")); // Newline
    Assertions.assertFalse(VersionUtilities.isSemVer("1\t.0.0")); // Tab
    Assertions.assertFalse(VersionUtilities.isSemVer("1\r.0.0")); // Carriage return
    Assertions.assertFalse(VersionUtilities.isSemVer("1\0.0.0")); // Null byte
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0\u0007")); // Bell character
  }

  @Test
  public void testWhitespaceEdgeCases() {
    // Various whitespace scenarios
    Assertions.assertFalse(VersionUtilities.isSemVer(" 1.0.0")); // Leading space
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0 ")); // Trailing space
    Assertions.assertFalse(VersionUtilities.isSemVer("1 .0.0")); // Space in middle
    Assertions.assertFalse(VersionUtilities.isSemVer("1. 0.0")); // Space after dot
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0 .0")); // Space before dot
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0\u00A0")); // Non-breaking space
    Assertions.assertFalse(VersionUtilities.isSemVer("1.0.0\u2009")); // Thin space
  }

  // =============================================
  // EXTREME VALUES AND OVERFLOW ATTEMPTS
  // =============================================

  @Test
  public void testVeryLargeNumbers() {
    // Test with very large numbers that might cause overflow
    String maxInt = String.valueOf(Integer.MAX_VALUE);
    String beyondMaxInt = "2147483648"; // Integer.MAX_VALUE + 1
    String veryLarge = "999999999999999999999999999999";

    Assertions.assertTrue(VersionUtilities.isSemVer(maxInt + ".0.0"));
    Assertions.assertTrue(VersionUtilities.isSemVer("0." + maxInt + ".0"));
    Assertions.assertTrue(VersionUtilities.isSemVer("0.0." + maxInt));

    // Beyond max int
    Assertions.assertFalse(VersionUtilities.isSemVer(beyondMaxInt + ".0.0"));
    Assertions.assertFalse(VersionUtilities.isSemVer(veryLarge + ".0.0"));

    // Test version comparison with large numbers
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.compareVersions(maxInt + ".0.0", beyondMaxInt + ".0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.compareVersions("999999999999999999999999999998", "999999999999999999999999999999"));
  }

  @Test
  public void testVeryLongStrings() {
    // Very long version strings
    StringBuilder longVersion = new StringBuilder("1.0.0-");
    for (int i = 0; i < 10000; i++) {
      longVersion.append("a");
    }

    // Should handle gracefully, not crash
    try {
      boolean result = VersionUtilities.isSemVer(longVersion.toString());
      // Don't care about the result, just that it doesn't crash
    } catch (OutOfMemoryError | StackOverflowError e) {
      Assertions.fail("Should handle long strings gracefully");
    }
  }

  // =============================================
  // COMPARISON EDGE CASES - DESIGNED TO BREAK
  // =============================================

  @Test
  public void testCompareVersions_LeadingZeroTricks() {
    Assertions.assertFalse(VersionUtilities.isSemVer("1.01.0"));
    Assertions.assertFalse(VersionUtilities.isSemVer("01.1.0"));
    Assertions.assertFalse(VersionUtilities.isSemVer("1.1.00"));

    // Leading zeros in different comparison paths
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.compareVersions("1.01.0", "1.1.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.compareVersions("1.1.0", "1.01.0"));
  }

  @Test
  public void testCompareVersions_MixedTypes() {
    // Mix regular versions with FHIR special versions
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("3.0.0", "r4")); // 3.0.0 < 4.0.0 (r4)
    Assertions.assertEquals(1, VersionUtilities.compareVersions("5.0.0", "r4")); // 5.0.0 > 4.0.0 (r4)
    Assertions.assertEquals(0, VersionUtilities.compareVersions("4.0.1", "r4")); // Should be equal
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("4.0", "r4")); // Should be equal

    // Case sensitivity tricks
    Assertions.assertEquals(0, VersionUtilities.compareVersions("R4", "r4"));
    Assertions.assertEquals(0, VersionUtilities.compareVersions("R4B", "r4b"));
  }

  @Test
  public void testCompareVersions_PrereleaseEdgeCases() {
    // Prerelease vs release
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-alpha", "1.0.0"));

    // Empty-looking prerelease vs actual empty
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.compareVersions("1.0.0-", "1.0.0"));

    // Complex prerelease ordering
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-alpha", "1.0.0-beta"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-alpha.1", "1.0.0-alpha.2"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-alpha.1", "1.0.0-alpha.beta"));

    // Numeric vs string in prerelease
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-1", "1.0.0-2"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-1", "1.0.0-10")); // Numeric: 1 < 10
  }

  @Test
  public void testCompareVersions_NumberStringBoundary() {
    // Test the boundary between numeric and string comparison
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("0.9", "0.10")); // Numeric: 9 < 10

    // But what about with non-numeric characters?
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.compareVersions("0.9a", "0.10a"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.compareVersions("0.9", "0.10a"));
  }

  @Test
  public void testCompareVersions_EdgeCaseConsistency() {
    // Transitivity test: if A < B and B < C, then A < C
    String[] versions = {"0.9.0", "0.10.0", "1.0.0", "1.0.0-alpha", "1.0.0-beta", "1.1.0"};

    for (int i = 0; i < versions.length; i++) {
      for (int j = i + 1; j < versions.length; j++) {
        for (int k = j + 1; k < versions.length; k++) {
          String a = versions[i], b = versions[j], c = versions[k];
          int ab = VersionUtilities.compareVersions(a, b);
          int bc = VersionUtilities.compareVersions(b, c);
          int ac = VersionUtilities.compareVersions(a, c);

          // If a < b and b < c, then a should < c
          if (ab >= 0 && bc >= 0) { // a <= b <= c
            Assertions.assertTrue(ac >= 0,
              String.format("Transitivity failed: %s vs %s vs %s (%d, %d, %d)", a, b, c, ab, bc, ac));
          }
        }
      }
    }
  }

  @Test
  public void testCompareVersions_Reflexivity() {
    // Every version should equal itself
    String[] testVersions = {
      "1.0.0", "2.1.5", "0.0.1", "10.20.30",
      "1.0.0-alpha", "2.1.0-beta.1",
      "r2", "r3", "r4", "r4B", "r5", "r6",
      "R2", "R4B"
    };

    for (String version : testVersions) {
      Assertions.assertEquals(0, VersionUtilities.compareVersions(version, version),
        "Version should equal itself: " + version);
    }
  }

  @Test
  public void testCompareVersions_Symmetry() {
    // If A < B, then B > A (and vice versa)
    String[][] pairs = {
      {"1.0.0", "1.0.1"},
      {"1.0.0", "1.1.0"},
      {"1.0.0-alpha", "1.0.0"},
      {"r3", "r4"},
      {"0.9", "0.10"},
      {"1.0.0-alpha", "1.0.0-beta"}
    };

    for (String[] pair : pairs) {
      int ab = VersionUtilities.compareVersions(pair[0], pair[1]);
      int ba = VersionUtilities.compareVersions(pair[1], pair[0]);

      Assertions.assertEquals(-ab, ba,
        String.format("Symmetry failed: %s vs %s (%d vs %d)", pair[0], pair[1], ab, ba));
    }
  }

  // =============================================
  // VERSION MATCHING STRESS TESTS
  // =============================================

  @Test
  public void testVersionsMatch_EdgeCases() {
    // Should these match on major.minor?
    Assertions.assertTrue(VersionUtilities.versionsMatch("1.0.0-alpha", "1.0.5"));
    Assertions.assertTrue(VersionUtilities.versionsMatch("1.0", "1.0.0-beta"));

    // Case sensitivity
    Assertions.assertTrue(VersionUtilities.versionsMatch("R4", "r4"));

    // Leading zeros (if they somehow get through)
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionsMatch("1.01.0", "1.1.5"));
    // Should handle gracefully
  }

  @Test
  public void testVersionsMatch_WithMalformedInputs() {
    // How does versionsMatch handle malformed inputs?
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionsMatch("1..0", "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionsMatch("1.0.0", "1..0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionsMatch("", "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionsMatch("1.0.0", ""));
  }

  // =============================================
  // SPECIAL CHARACTER INJECTION
  // =============================================

  @Test
  public void testSpecialCharacterInjection() {
    // Try to inject special characters that might break parsing
    String[] malicious = {
      "1.0.0\"; DROP TABLE versions; --",
      "1.0.0<script>alert('xss')</script>",
      "1.0.0\u0000null",
      "1.0.0\u001F", // Unit separator
      "1.0.0\u007F", // DEL character
      "1.0.0%00",
      "1.0.0\\n",
      "1.0.0\\0",
    };

    for (String version : malicious) {
      Assertions.assertFalse(VersionUtilities.isSemVer(version));
      Assertions.assertNull(VersionUtilities.getMajMin(version));
      assertThrows(FHIRException.class, () -> VersionUtilities.compareVersions("1.0.0", version));
    }
  }

  // =============================================
  // BOUNDARY VALUE ANALYSIS
  // =============================================

  @Test
  public void testBoundaryValues() {
    // Test exact boundaries between major FHIR versions
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("3.9.9", "4.0.0"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("4.9.9", "5.0.0"));

    // Test R4B boundary (4.1.0)
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("4.0.9", "4.1.0"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("4.1.0", "4.1.1"));

    // Test version just before and after special version equivalents
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("3.9.9", "r4")); // 3.9.9 < 4.0.0
    Assertions.assertEquals(1, VersionUtilities.compareVersions("4.0.2", "r4")); // 4.0.1 > 4.0.0
    Assertions.assertEquals(1, VersionUtilities.compareVersions("4.0.1", null)); // 4.0.1 > 4.0.0
    Assertions.assertEquals(-1, VersionUtilities.compareVersions(null, "r4")); // 4.0.1 > 4.0.0
    Assertions.assertEquals(0, VersionUtilities.compareVersions(null, null)); // 4.0.1 > 4.0.0
  }

  @Test
  public void testPrereleaseBoundaries() {
    // Boundary between prerelease and release
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-rc.999", "1.0.0"));
    Assertions.assertEquals(1, VersionUtilities.compareVersions("1.0.0", "1.0.0-alpha"));

    // Prerelease ordering boundaries
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-alpha.999", "1.0.0-beta"));
    Assertions.assertEquals(-1, VersionUtilities.compareVersions("1.0.0-rc.999", "1.0.0"));
  }

  // =============================================
  // PERFORMANCE STRESS TEST
  // =============================================

  @Test
  public void testPerformanceWithManyComparisons() {
    // Generate many versions to compare
    String[] versions = new String[1000];
    for (int i = 0; i < 1000; i++) {
      versions[i] = String.format("%d.%d.%d", i / 100, (i / 10) % 10, i % 10);
    }

    // Time the comparisons - should complete in reasonable time
    long start = System.currentTimeMillis();

    for (int i = 0; i < versions.length; i++) {
      for (int j = i + 1; j < Math.min(i + 10, versions.length); j++) {
        VersionUtilities.compareVersions(versions[i], versions[j]);
        VersionUtilities.versionsMatch(versions[i], versions[j]);
      }
    }

    long elapsed = System.currentTimeMillis() - start;
    Assertions.assertTrue(elapsed < 10000, "Performance test should complete in under 10 seconds, took: " + elapsed + "ms");
  }


  @Test
  @DisplayName("Semantic accessor methods - basic versions")
  void testSemanticAccessorsBasic() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3");
    assertTrue(result.isSuccess());
    Assertions.assertEquals("1", result.getMajor());
    Assertions.assertEquals("2", result.getMinor());
    Assertions.assertEquals("3", result.getPatch());
    Assertions.assertNull(result.getReleaseLabel());
    Assertions.assertNull(result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - with pre-release")
  void testSemanticAccessorsPreRelease() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3-alpha.1");
    assertTrue(result.isSuccess());
    Assertions.assertEquals("1", result.getMajor());
    Assertions.assertEquals("2", result.getMinor());
    Assertions.assertEquals("3", result.getPatch());
    Assertions.assertEquals("alpha.1", result.getReleaseLabel());
    Assertions.assertNull(result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - with build")
  void testSemanticAccessorsBuild() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3+build.456");
    assertTrue(result.isSuccess());
    Assertions.assertEquals("1", result.getMajor());
    Assertions.assertEquals("2", result.getMinor());
    Assertions.assertEquals("3", result.getPatch());
    Assertions.assertNull(result.getReleaseLabel());
    Assertions.assertEquals("build.456", result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - with both pre-release and build")
  void testSemanticAccessorsBoth() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3-alpha.1+build.456");
    assertTrue(result.isSuccess());
    Assertions.assertEquals("1", result.getMajor());
    Assertions.assertEquals("2", result.getMinor());
    Assertions.assertEquals("3", result.getPatch());
    Assertions.assertEquals("alpha.1", result.getReleaseLabel());
    Assertions.assertEquals("build.456", result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - with wildcards")
  void testSemanticAccessorsWildcards() {
    SemverParser.ParseResult result1 = SemverParser.parseSemver("1.*", true);
    assertTrue(result1.isSuccess());
    Assertions.assertEquals("1", result1.getMajor());
    Assertions.assertEquals("*", result1.getMinor());
    Assertions.assertNull(result1.getPatch());
    Assertions.assertNull(result1.getReleaseLabel());
    Assertions.assertNull(result1.getBuild());

    SemverParser.ParseResult result2 = SemverParser.parseSemver("1.2.x", true);
    assertTrue(result2.isSuccess());
    Assertions.assertEquals("1", result2.getMajor());
    Assertions.assertEquals("2", result2.getMinor());
    Assertions.assertEquals("x", result2.getPatch());
    Assertions.assertNull(result2.getReleaseLabel());
    Assertions.assertNull(result2.getBuild());

    SemverParser.ParseResult result3 = SemverParser.parseSemver("1.2.3-*", true);
    assertTrue(result3.isSuccess());
    Assertions.assertEquals("1", result3.getMajor());
    Assertions.assertEquals("2", result3.getMinor());
    Assertions.assertEquals("3", result3.getPatch());
    Assertions.assertEquals("*", result3.getReleaseLabel());
    Assertions.assertNull(result3.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - complex pre-release and build")
  void testSemanticAccessorsComplex() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3-alpha-beta.1.2.3+build.meta.data.123");
    assertTrue(result.isSuccess());
    Assertions.assertEquals("1", result.getMajor());
    Assertions.assertEquals("2", result.getMinor());
    Assertions.assertEquals("3", result.getPatch());
    Assertions.assertEquals("alpha-beta.1.2.3", result.getReleaseLabel());
    Assertions.assertEquals("build.meta.data.123", result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - error cases")
  void testSemanticAccessorsErrors() {
    SemverParser.ParseResult result = SemverParser.parseSemver("invalid");
    assertFalse(result.isSuccess());
    Assertions.assertNull(result.getMajor());
    Assertions.assertNull(result.getMinor());
    Assertions.assertNull(result.getPatch());
    Assertions.assertNull(result.getReleaseLabel());
    Assertions.assertNull(result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - edge cases")
  void testSemanticAccessorsEdgeCases() {
    // Single component pre-release and build
    SemverParser.ParseResult result1 = SemverParser.parseSemver("1.2.3-alpha+build");
    assertTrue(result1.isSuccess());
    Assertions.assertEquals("alpha", result1.getReleaseLabel());
    Assertions.assertEquals("build", result1.getBuild());

    // Numeric pre-release
    SemverParser.ParseResult result2 = SemverParser.parseSemver("1.2.3-123");
    assertTrue(result2.isSuccess());
    Assertions.assertEquals("123", result2.getReleaseLabel());

    // Build with leading zeros
    SemverParser.ParseResult result3 = SemverParser.parseSemver("1.2.3+001.002");
    assertTrue(result3.isSuccess());
    Assertions.assertEquals("001.002", result3.getBuild());
  }

  
}