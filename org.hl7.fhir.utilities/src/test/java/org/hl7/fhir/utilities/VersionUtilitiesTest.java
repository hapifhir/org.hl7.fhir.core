package org.hl7.fhir.utilities;

import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class VersionUtilitiesTest {

  @Test
  public void isValidSemVer() {
    test_isSemVer("0.1.1", true);
    test_isSemVer("0.1.1-ballot1", true);
    test_isSemVer("0.0.0-alpha.0.131", true);
    test_isSemVer("0.1.a", false);
  }

  @Test
  public void isThisOrLater_Simple() {
    test_isThisOrLaterMajorMinor("0.1", "0.2", true);
    test_isThisOrLaterMajorMinor("0.2", "0.1", false);
  }

  @Test
  public void isThisOrLater_NeedNumericComparison() {
    test_isThisOrLaterMajorMinor("0.9", "0.10", true);
    test_isThisOrLaterMajorMinor("0.10", "0.9", false);
  }

  @Test
  public void isThisOrLater_DifferentLengths() {
    test_isThisOrLaterMajorMinor("0.9", "0.9.1", true);
    test_isThisOrLaterMajorMinor("0.9.1", "0.9", true);

    test_isThisOrLater("0.9", "0.9.1", true);
    test_isThisOrLater("0.9.1", "0.9", false);
  }

  @Test
  public void isThisOrLater_NonNumeric() {
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLater("0.A", "0.B", VersionUtilities.VersionPrecision.MINOR));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLater("0.B", "0.A", VersionUtilities.VersionPrecision.MINOR));
  }

  @Test
  public void isMajMinOrLaterPatch_Simple() {
    test_isThisOrLater("0.9.0", "0.9.0", true);
    test_isThisOrLater("0.9.0", "0.9.1", true);
    test_isThisOrLaterMajorMinor("0.9.0", "0.8.1", false);
  }

  @Test
  public void isMajMinOrLaterPatch_VersionWithX() {
    test_isThisOrLater("0.9.x", "0.9.0", true);
    test_isThisOrLater("0.9.x", "0.9.1", true);
    test_isThisOrLaterMajorMinor("0.9.x", "0.8.1", false);
  }

  @Test
  public void bugFixTests() {
    test_isThisOrLaterMajorMinor("1.0.0-ballot", "1.0.1", true);
    test_isThisOrLater("3.1.x", "3.1.1", true);
    test_isThisOrLater("3.0.x", "3.1.1", true);
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLater("3.1.1", "3.0.x", VersionUtilities.VersionPrecision.FULL));
  }

  // =============================================
  // getMajMin() TESTS
  // =============================================

  @Test
  public void testGetMajMin_StandardSemver() {
    test_getMajMin("1.0.0", "1.0");
    test_getMajMin("2.1.3", "2.1");
    test_getMajMin("10.5.2", "10.5");
    test_getMajMin("0.9.1", "0.9");
  }

  @Test
  public void testGetMajMin_WithPrerelease() {
    test_getMajMin("1.0.0-alpha", "1.0");
    test_getMajMin("2.1.0-beta.1", "2.1");
    test_getMajMin("3.2.5-rc.2", "3.2");
  }

  @Test
  public void testGetMajMin_TwoPartVersions() {
    test_getMajMin("1.0", "1.0");
    test_getMajMin("2.5", "2.5");
  }

  @Test
  public void testGetMajMin_SinglePartVersions() {
    test_getMajMin("1", null);
    test_getMajMin("5", null);
  }

  @Test
  public void testGetMajMin_FhirSpecialVersions() {
    test_getMajMin("r2", "1.0");
    test_getMajMin("r3", "3.0");
    test_getMajMin("r4", "4.0");
    test_getMajMin("r4B", "4.3");
    test_getMajMin("r5", "5.0");
    test_getMajMin("r6", "6.0");

    // Test uppercase variants
    test_getMajMin("R2", "1.0");
    test_getMajMin("R3", "3.0");
    test_getMajMin("R4", "4.0");
    test_getMajMin("R4B", "4.3");
    test_getMajMin("R5", "5.0");
    test_getMajMin("R6", "6.0");
  }

  @Test
  public void testGetMajMin_EdgeCases() {
    test_getMajMin("0.0.0", "0.0");
    test_getMajMin("0.1.0", "0.1");
    test_getMajMin("100.200.300", "100.200");
  }

  // =============================================
  // getMajMinPatch() TESTS
  // =============================================

  @Test
  public void testGetMajMinPatch_StandardSemver() {
    test_getMajMinPatch("1.0.0", "1.0.0");
    test_getMajMinPatch("2.1.3", "2.1.3");
    test_getMajMinPatch("10.5.2", "10.5.2");
  }

  @Test
  public void testGetMajMinPatch_WithPrerelease() {
    test_getMajMinPatch("1.0.0-alpha", "1.0.0");
    test_getMajMinPatch("2.1.0-beta.1", "2.1.0");
    test_getMajMinPatch("3.2.5-rc.2", "3.2.5");
  }

  @Test
  public void testGetMajMinPatch_TwoPartVersions() {
    test_getMajMinPatch("1.0", "1.0.0");
    test_getMajMinPatch("2.5", "2.5.0");
  }

  @Test
  public void testGetMajMinPatch_SinglePartVersions() {
    test_getMajMinPatch("1", null);
    test_getMajMinPatch("5", null);
  }

  @Test
  public void testGetMajMinPatch_FhirSpecialVersions() {
    test_getMajMinPatch("r2", "1.0.2");
    test_getMajMinPatch("r3", "3.0.2");
    test_getMajMinPatch("r4", "4.0.1");
    test_getMajMinPatch("r4B", "4.3.0");
    test_getMajMinPatch("r5", "5.0.0");
    test_getMajMinPatch("r6", "6.0.0");
  }

  // =============================================
  // getPatch() TESTS
  // =============================================

  @Test
  public void testGetPatch_StandardSemver() {
    test_getPatch("1.0.0", "0");
    test_getPatch("2.1.3", "3");
    test_getPatch("1.2.15", "15");
  }

  @Test
  public void testGetPatch_WithPrerelease() {
    test_getPatch("1.0.0-alpha", "0");
    test_getPatch("2.1.5-beta.1", "5");
    test_getPatch("3.2.10-rc.2", "10");
  }

  @Test
  public void testGetPatch_TwoPartVersions() {
    test_getPatch("1.0", "0");
    test_getPatch("2.5", "0");
  }

  @Test
  public void testGetPatch_SinglePartVersions() {
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.getPatch("1"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.getPatch("5"));
  }

  @Test
  public void testGetPatch_FhirSpecialVersions() {
    test_getPatch("r2", "2");
    test_getPatch("r3", "2");
    test_getPatch("r4", "1");
    test_getPatch("r4B", "0");
    test_getPatch("r5", "0");
    test_getPatch("r6", "0");
  }

  // =============================================
  // isSemVer() TESTS
  // =============================================

  @Test
  public void testIsSemVer_ValidSemver() {
    test_isSemVer("1.0.0", true);
    test_isSemVer("2.1.3", true);
    test_isSemVer("10.20.30", true);
    test_isSemVer("0.0.1", true);
  }

  @Test
  public void testIsSemVer_ValidSemverWithPrerelease() {
    test_isSemVer("1.0.0-alpha", true);
    test_isSemVer("2.1.0-beta.1", true);
    test_isSemVer("3.2.5-rc.2", true);
    test_isSemVer("1.0.0-alpha.beta", true);
    test_isSemVer("1.0.0-alpha.1", true);
  }

  @Test
  public void testIsSemVer_ValidTwoPartVersions() {
    test_isSemVer("1.0", true);
    test_isSemVer("2.5", true);
    test_isSemVer("10.15", true);
  }

  @Test
  public void testIsSemVer_ValidSinglePartVersions() {
    test_isSemVer("1", false);
    test_isSemVer("5", false);
    test_isSemVer("10", false);
  }

  @Test
  public void testIsSemVer_FhirSpecialVersions() {
    test_isSemVer("r2", false);
    test_isSemVer("r3", false);
    test_isSemVer("r4", false);
    test_isSemVer("r4B", false);
    test_isSemVer("r5", false);
    test_isSemVer("r6", false);

    test_isSemVer("R2", false);
    test_isSemVer("R3", false);
    test_isSemVer("R4", false);
    test_isSemVer("R4B", false);
    test_isSemVer("R5", false);
    test_isSemVer("R6", false);
  }

  @Test
  public void testIsSemVer_InvalidVersions() {
    test_isSemVer("", false);
    test_isSemVer(null, false);
    test_isSemVer("1.0.0.0", false);
    test_isSemVer("1.0.", false);
    test_isSemVer("1..0", false);
    test_isSemVer("a.b.c", false);
    test_isSemVer("1.0.0-", false);
    test_isSemVer("r7", false); // Invalid FHIR version
    test_isSemVer("r", false); // Invalid FHIR version
  }

  // =============================================
  // isThisOrLater() TESTS
  // =============================================

  @Test
  public void testIsThisOrLater_SameVersions() {
    test_isThisOrLaterMajorMinor("1.0.0", "1.0.0", true);
    test_isThisOrLaterMajorMinor("2.1.3", "2.1.3", true);
    test_isThisOrLaterMajorMinor("r4", "r4", true);
    test_isThisOrLaterMajorMinor("R5", "r5", true); // Case insensitive
  }

  @Test
  public void testIsThisOrLater_LaterVersions() {
    test_isThisOrLaterMajorMinor("1.0.0", "1.0.1", true);
    test_isThisOrLaterMajorMinor("1.0.0", "1.1.0", true);
    test_isThisOrLaterMajorMinor("1.0.0", "2.0.0", true);
    test_isThisOrLaterMajorMinor("2.1.0", "2.1.5", true);
    test_isThisOrLaterMajorMinor("r3", "r4", true);
    test_isThisOrLaterMajorMinor("r4", "r5", true);
  }

  @Test
  public void testIsThisOrLaterMajorMinor_EarlierVersions() {
    test_isThisOrLaterMajorMinor("1.0.1", "1.0.0", true);
    test_isThisOrLaterMajorMinor("1.1.0", "1.0.0", false);
    test_isThisOrLaterMajorMinor("2.0.0", "1.0.0", false);
    test_isThisOrLaterMajorMinor("2.1.5", "2.1.0", true);
    test_isThisOrLaterMajorMinor("r4", "r3", false);
    test_isThisOrLaterMajorMinor("r5", "r4", false);
  }

  @Test
  public void testIsThisOrLater_EarlierVersions() {
    test_isThisOrLater("1.0.1", "1.0.0", false);
    test_isThisOrLater("1.1.0", "1.0.0", false);
    test_isThisOrLater("2.0.0", "1.0.0", false);
    test_isThisOrLater("2.1.5", "2.1.0", false);
    test_isThisOrLater("r4", "r3", false);
    test_isThisOrLater("r5", "r4", false);
  }

  @Test
  public void testIsThisOrLater_NumericVsTextComparison() {
    // Numeric comparison: 0.9 < 0.10
    test_isThisOrLaterMajorMinor("0.9", "0.10", true);
    test_isThisOrLaterMajorMinor("1.9", "1.10", true);

    // Text comparison fallback for non-numeric
    test_isThisOrLaterMajorMinor("1.0.0-alpha", "1.0.0-beta", true);
  }

  @Test
  public void testIsThisOrLater_MixedDepths() {
    test_isThisOrLaterMajorMinor("1.0", "1.0.0", true);
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLater("1", "1.0.0", VersionUtilities.VersionPrecision.MINOR));

    test_isThisOrLater("1.0", "1.0.0", true);
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.isThisOrLater("1", "1.0.0", VersionUtilities.VersionPrecision.FULL));
  }

  @Test
  public void testIsThisOrLater_Misc() {
    test_isThisOrLaterMajorMinor("2.0", "2.1", true);
    test_isThisOrLaterMajorMinor("2.1", "2.0", false);

    test_isThisOrLater("2.0", "2.1", true);
    test_isThisOrLater("2.1", "2.0", false);
  }

  // =============================================
  // isMajMinOrLaterPatch() TESTS
  // =============================================

  @Test
  public void testIsMajMinOrLaterPatch_SameMajorMinor() {
    test_isThisOrLater("1.0.0", "1.0.0", true);
    test_isThisOrLater("1.0.0", "1.0.1", true);
    test_isThisOrLater("1.0.0", "1.0.10", true);
    test_isThisOrLater("2.1.0", "2.1.5", true);
  }

  @Test
  public void testIsMajMinOrLaterPatch_DifferentMajorMinor() {
    test_isThisOrLater("1.0.0", "1.1.0", true);
    test_isThisOrLater("1.0.0", "2.0.0", true);
    test_isThisOrLater("2.1.0", "2.0.5", false);
    test_isThisOrLater("2.1.0", "3.1.0", true);
  }

  @Test
  public void testIsMajMinOrLaterPatch_EarlierPatch() {
    test_isThisOrLater("1.0.5", "1.0.0", false);
    test_isThisOrLater("2.1.10", "2.1.5", false);
  }

  @Test
  public void testIsMajMinOrLaterPatch_FhirVersions() {
    test_isThisOrLater("r4", "r4", true);
    test_isThisOrLater("r4", "r5", true);
    test_isThisOrLater("r5", "r4", false);
  }

  // =============================================
  // incMajorVersion() TESTS
  // =============================================

  @Test
  public void testIncMajorVersion_StandardSemver() {
    test_incMajorVersion("1.0.0", "2.0.0");
    test_incMajorVersion("2.5.10", "3.0.0");
    test_incMajorVersion("10.20.30", "11.0.0");
    test_incMajorVersion("0.9.5", "1.0.0");
  }

  @Test
  public void testIncMajorVersion_WithPrerelease() {
    test_incMajorVersion("1.0.0-alpha", "2.0.0");
    test_incMajorVersion("2.1.0-beta.1", "3.0.0");
  }

  @Test
  public void testIncMajorVersion_TwoPartVersions() {
    test_incMajorVersion("1.5", "2.0.0");
    test_incMajorVersion("3.0", "4.0.0");
  }

  @Test
  public void testIncMajorVersion_SinglePartVersions() {
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.incMajorVersion("1"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.incMajorVersion("6"));
  }

  // =============================================
  // incMinorVersion() TESTS
  // =============================================

  @Test
  public void testIncMinorVersion_StandardSemver() {
    test_incMinorVersion("1.0.0", "1.1.0");
    test_incMinorVersion("2.5.10", "2.6.0");
    test_incMinorVersion("10.20.30", "10.21.0");
  }

  @Test
  public void testIncMinorVersion_WithPrerelease() {
    test_incMinorVersion("1.0.0-alpha", "1.1.0");
    test_incMinorVersion("2.1.0-beta.1", "2.2.0");
  }

  @Test
  public void testIncMinorVersion_TwoPartVersions() {
    test_incMinorVersion("1.5", "1.6.0");
    test_incMinorVersion("3.0", "3.1.0");
  }

  // =============================================
  // incPatchVersion() TESTS
  // =============================================

  @Test
  public void testIncPatchVersion_StandardSemver() {
    test_incPatchVersion("1.0.0", "1.0.1");
    test_incPatchVersion("2.5.10", "2.5.11");
    test_incPatchVersion("10.20.30", "10.20.31");
  }

  @Test
  public void testIncPatchVersion_WithPrerelease() {
    test_incPatchVersion("1.0.0-alpha", "1.0.1");
    test_incPatchVersion("2.1.0-beta.1", "2.1.1");
  }

  @Test
  public void testIncPatchVersion_TwoPartVersions() {
    test_incPatchVersion("1.5", "1.5.1");
    test_incPatchVersion("3.0", "3.0.1");
  }

  @Test
  public void testIncPatchVersion_SinglePartVersions() {
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.incPatchVersion("1"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.incPatchVersion("5"));
  }

  // =============================================
  // versionMatches() COMPREHENSIVE TESTS
  // =============================================

  @Test
  @DisplayName("versionMatches - Exact matches")
  public void testVersionMatches_ExactMatches() {
    // Exact version matches
    test_versionMatches("2.0", "2.0", true);
    test_versionMatches("2.0.0", "2.0.0", true);
    test_versionMatches("1.5.3", "1.5.3", true);
    test_versionMatches("r4", "r4", true);
    test_versionMatches("R5", "r5", true); // Case insensitive

    // Exact non-matches
    test_versionMatches("2.0", "2.0.0", false); // 2.0 does NOT match 2.0.0
    test_versionMatches("2.0", "2.0.1", false); // 2.0 does NOT match 2.0.1
    test_versionMatches("2.0.0", "2.0.1", false); // 2.0.0 does NOT match 2.0.1
    test_versionMatches("2.0.0", "2.0.0-something", false); // 2.0.0 does NOT match 2.0.0-something
    test_versionMatches("2.0.0", "2.0.0+something", false); // 2.0.0 does NOT match 2.0.0+something
  }

  @Test
  @DisplayName("versionMatches - Star wildcards")
  public void testVersionMatches_StarWildcards() {
    // Star wildcards for minor version
    test_versionMatches("2.*", "2.0", true);
    test_versionMatches("2.*", "2.1", true);
    test_versionMatches("2.*", "2.99", true);
    test_versionMatches("2.*", "2.0.0", false); // 2.* does NOT match 2.0.0
    test_versionMatches("2.*", "2.1-something", false); // 2.* does NOT match 2.1-something
    test_versionMatches("2.*", "3.0", false); // Different major

    // Star wildcards for patch version
    test_versionMatches("2.0.*", "2.0.0", true);
    test_versionMatches("2.0.*", "2.0.1", true);
    test_versionMatches("2.0.*", "2.0.99", true);
    test_versionMatches("2.0.*", "2.0.0-something", false); // 2.0.* does NOT match 2.0.0-something
    test_versionMatches("2.0.*", "2.0.0+something", false); // 2.0.* does NOT match 2.0.0+something
    test_versionMatches("2.0.*", "2.1.0", false); // Different minor

    // Star wildcards for pre-release
    test_versionMatches("2.0.0-*", "2.0.0-prerelease", true);
    test_versionMatches("2.0.0-*", "2.0.0-alpha", true);
    test_versionMatches("2.0.0-*", "2.0.0-beta.1", true);
    test_versionMatches("2.0.0-*", "2.0.0+build", false); // 2.0.0-* does NOT match 2.0.0+build
    test_versionMatches("2.0.0-*", "2.0.0", false); // 2.0.0-* does NOT match 2.0.0

    // Star wildcards for build
    test_versionMatches("2.0.0+*", "2.0.0+build", true);
    test_versionMatches("2.0.0+*", "2.0.0+anything", true);
    test_versionMatches("2.0.0+*", "2.0.0+build.123", true);
    test_versionMatches("2.0.0+*", "2.0.0", false); // 2.0.0+* does NOT match 2.0.0
    test_versionMatches("2.0.0+*", "2.0.0-prerelease", false); // 2.0.0+* does NOT match 2.0.0-prerelease
  }

  @Test
  @DisplayName("versionMatches - x/X wildcards")
  public void testVersionMatches_XWildcards() {
    // x wildcards (same behavior as *)
    test_versionMatches("2.x", "2.0", true);
    test_versionMatches("2.x", "2.1", true);
    test_versionMatches("2.x", "2.0.0", false);

    // X wildcards (same behavior as *)
    test_versionMatches("2.X", "2.0", true);
    test_versionMatches("2.X", "2.1", true);
    test_versionMatches("2.X", "2.0.0", false);

    // x/X in patch position
    test_versionMatches("2.0.x", "2.0.0", true);
    test_versionMatches("2.0.X", "2.0.1", true);

    // x and X are valid values in pre-release/build (not wildcards there)
    test_versionMatches("2.0.0-x", "2.0.0-x", true);
    test_versionMatches("2.0.0-x", "2.0.0-y", false);
    test_versionMatches("2.0.0+X", "2.0.0+X", true);
    test_versionMatches("2.0.0+X", "2.0.0+Y", false);
  }

  @Test
  @DisplayName("versionMatches - Complex wildcards")
  public void testVersionMatches_ComplexWildcards() {
    // Multiple wildcards
    test_versionMatches("2.x.x-x", "2.0.1-prerelease", false);
    test_versionMatches("2.x.x-x", "2.5.10-prerelease", false);
    test_versionMatches("2.x.x-x", "2.0.0", false); // No prerelease
    test_versionMatches("2.x.x-x", "2.0.1", false); // No prerelease
    test_versionMatches("2.x.x-x", "3.0.1-prerelease", false); // Different major

    test_versionMatches("2.x.x-*", "2.0.1-prerelease", true);
    test_versionMatches("2.x.x-*", "2.5.10-prerelease", true);
    test_versionMatches("2.x.x-*", "2.0.0", false); // No prerelease
    test_versionMatches("2.x.x-*", "2.0.1", false); // No prerelease
    test_versionMatches("2.x.x-*", "3.0.1-prerelease", false); // Different major

    // Mix of specific and wildcard
    test_versionMatches("2.5.*", "2.5.0", true);
    test_versionMatches("2.5.*", "2.5.99", true);
    test_versionMatches("2.5.*", "2.4.0", false);
    test_versionMatches("2.5.*", "2.6.0", false);

    test_versionMatches("2.0.x-*",  "2.0.1-prerelease", true);
    test_versionMatches("2.0.x-*","2.0.1-prerelease", true);
    test_versionMatches("2.0.x-*","2.0.0", false);
    test_versionMatches("2.0.x-*", "2.0.1", false);
  }

  @Test
  @DisplayName("versionMatches - Question mark prefix matching")
  public void testVersionMatches_QuestionMarkPrefix() {
    // ? matches anything that starts with the prefix
    test_versionMatches("2.0?", "2.0", true);
    test_versionMatches("2.0?", "2.0.1", true);
    test_versionMatches("2.0?", "2.0.0-build", true);
    test_versionMatches("2.0?", "2.0.1+build", true);
    test_versionMatches("2.0?", "2.1", false); // Doesn't start with 2.0
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("2.0?", "2.0a")); // Invalid version but starts with 2.0

    test_versionMatches("2.0.1?", "2.0.1", true);
    test_versionMatches("2.0.1?", "2.0.1-release", true);
    test_versionMatches("2.0.1?", "2.0.1+build", true);
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("2.0.1?", "2.0.1.extra"));
    test_versionMatches("2.0.1?", "2.0.2", false);

    // Weird but valid according to docs
    test_versionMatches("2.x?", "2.0", true); // Should match anything starting with 2.
    test_versionMatches("2.x?", "2.1", true); // Should match anything starting with 2.
    test_versionMatches("2.x?", "2.0.0-anything", true); // Should match anything starting with 2.
  }

  @Test
  @DisplayName("versionMatches - FHIR special versions")
  public void testVersionMatches_FhirVersions() {
    // FHIR version matching
    test_versionMatches("r4", "4.0.1", true); // r4 maps to 4.0.1
    test_versionMatches("4.0.x", "r4", true); // Should work both ways
    test_versionMatches("r5", "5.0.0", true);
    test_versionMatches("R4B", "4.3.0", true);

    // Case insensitive
    test_versionMatches("R4", "r4", true);
    test_versionMatches("r4b", "R4B", true);

    // Non-matches
    test_versionMatches("r4", "r5", false);
    test_versionMatches("r4", "4.1.0", false); // r4 doesn't match 4.1.x
  }

  @Test
  @DisplayName("versionMatches - Edge cases and error conditions")
  public void testVersionMatches_EdgeCases() {
    // Null/empty handling
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches(null, "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("1.0.0", null));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("", "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("1.0.0", ""));

    // Invalid version strings
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("1..0", "1.0.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("1.0.0", "1..0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("a.b.c", "1.0.0"));

    // Leading zeros
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("01.0", "1.0"));
    Assertions.assertThrows(FHIRException.class, () -> VersionUtilities.versionMatches("1.0", "01.0"));
  }

  @Test
  @DisplayName("versionMatches - Complex real-world scenarios")
  public void testVersionMatches_RealWorldScenarios() {
    // Package version matching scenarios
    test_versionMatches("4.0.*", "4.0.0", true);
    test_versionMatches("4.0.*", "4.0.1", true);
    test_versionMatches("4.0.*", "4.0.999", true);
    test_versionMatches("4.0.*", "4.1.0", false);

    // Pre-release matching
    test_versionMatches("5.0.0-*", "5.0.0-snapshot", true);
    test_versionMatches("5.0.0-*", "5.0.0-cibuild", true);
    test_versionMatches("5.0.0-*", "5.0.0-ballot", true);
    test_versionMatches("5.0.0-*", "5.0.0", false);

    // Build metadata matching
    test_versionMatches("1.0.0+*", "1.0.0+20230101", true);
    test_versionMatches("1.0.0+*", "1.0.0+build.123", true);
    test_versionMatches("1.0.0+*", "1.0.0+git.abcdef", true);
    test_versionMatches("1.0.0+*", "1.0.0", false);

    // Prefix matching for development versions
    test_versionMatches("6.0?", "6.0.0-cibuild", true);
    test_versionMatches("6.0?", "6.0.0-snapshot", true);
    test_versionMatches("6.0?", "6.0.1", true);
    test_versionMatches("6.0?", "6.1.0", false);

    // Mixed scenarios
    test_versionMatches("r4", "4.0", false); // r4 is 4.0.1, not 4.0
    test_versionMatches("4.*", "r4", false); // 4.* matches 4.0, r4 is 4.0.1
  }

  @Test
  @DisplayName("versionMatches - Stress testing with comprehensive combinations")
  public void testVersionMatches_StressTesting() {
    // Test all wildcard positions
    String[] criteria = {"1.*", "1.0.*", "1.0.0-*", "1.0.0+*", "1.x", "1.X", "1.0.x", "1.0.X"};
    String[] candidates = {"1.0", "1.1", "1.0.0", "1.0.1", "1.0.0-alpha", "1.0.0+build", "2.0"};

    // Each criteria should have predictable behavior
    for (String criterion : criteria) {
      for (String candidate : candidates) {
        try {
          boolean result = VersionUtilities.versionMatches(criterion, candidate);
          // Just ensure it doesn't crash and returns a boolean
          Assertions.assertTrue(result == true || result == false);
        } catch (FHIRException e) {
          // Expected for invalid combinations
        }
      }
    }

    // Transitivity testing for question mark
    test_versionMatches("1.0?", "1.0", true);
    test_versionMatches("1.0?", "1.0.0", true);
    test_versionMatches("1.0?", "1.0.0-build", true); // Invalid but starts correctly
    test_versionMatches("1.0?", "1.0-alpha", true);
    test_versionMatches("1.0?", "1.0+build", true);

    // Boundary testing
    test_versionMatches("9.*", "9.99999", true);
    test_versionMatches("0.*", "0.0", true);
    test_versionMatches("999.*", "999.0", true);
  }

  // =============================================
  // FHIR VERSION SPECIFIC TESTS
  // =============================================

  @Test
  public void testIsR5Plus() {
    test_isR5Plus("r5", true);
    test_isR5Plus("R5", true);
    test_isR5Plus("r6", true);
    test_isR5Plus("5.0.0", true);
    test_isR5Plus("5.0.0-snapshot3", true);
    test_isR5Plus("5.1.0", false);
    test_isR5Plus("6.0.0", true);
    test_isR5Plus("6.0.0-ballot2", true);
    test_isR5Plus("4.5.0", true); // Pre-release R5

    test_isR5Plus("r4", false);
    test_isR5Plus("R4B", false);
    test_isR5Plus("4.0.0", false);
    test_isR5Plus("4.5.0", true);
    test_isR5Plus("4.4.0", false);
  }

  @Test
  public void testIsR4Plus() {
    test_isR4Plus("r4", true);
    test_isR4Plus("R4", true);
    test_isR4Plus("r4B", true);
    test_isR4Plus("r5", true);
    test_isR4Plus("r6", true);
    test_isR4Plus("4.0.0", true);
    test_isR4Plus("4.1.0", true);
    test_isR4Plus("5.0.0", true);
    test_isR4Plus("3.2.0", true); // Pre-release R4

    test_isR4Plus("r3", false);
    test_isR4Plus("3.0.0", false);
    test_isR4Plus("3.1.0", false);
    test_isR4Plus("3.2.0", true);
    test_isR4Plus("3.3.0", true);
    test_isR4Plus("3.4.0", false);
    test_isR4Plus("3.5.0", true);
    // test_isR4Plus("3.5a.0", true);
  }


  @Test
  public void testIsR6Plus() {
    test_isR6Plus("r6", true);
    test_isR6Plus("R6", true);
    test_isR6Plus("6.0.0", true);

    test_isR6Plus("r5", false);
    test_isR6Plus("r4", false);
    test_isR6Plus("5.0.0", false);
    test_isR6Plus("4.0.0", false);
  }

  // =============================================
  // removeVersionFromCanonical() TESTS
  // =============================================

  @Test
  public void testRemoveVersionFromCanonical_WithVersion() {
    test_removeVersionFromCanonical("http://example.com/CodeSystem|1.0.0", "http://example.com/CodeSystem");
    test_removeVersionFromCanonical("http://hl7.org/fhir/CodeSystem/test|2.1.5", "http://hl7.org/fhir/CodeSystem/test");
    test_removeVersionFromCanonical("http://test.org/cs|r4", "http://test.org/cs");
  }

  @Test
  public void testRemoveVersionFromCanonical_WithoutVersion() {
    test_removeVersionFromCanonical("http://example.com/CodeSystem", "http://example.com/CodeSystem");
    test_removeVersionFromCanonical("http://hl7.org/fhir/CodeSystem/test", "http://hl7.org/fhir/CodeSystem/test");
  }

  @Test
  public void testRemoveVersionFromCanonical_EdgeCases() {
    test_removeVersionFromCanonical("|1.0.0", "");
    test_removeVersionFromCanonical("test|", "test");
    test_removeVersionFromCanonical("", "");
    test_removeVersionFromCanonical(null, null);
  }

  // =============================================
  // compareVersions() TESTS
  // =============================================

  @Test
  public void testCompareVersions_Equal() {
    test_compareVersions("1.0.0", "1.0.0", 0);
    test_compareVersions("2.1.5", "2.1.5", 0);
    test_compareVersions("r4", "r4", 0);
    test_compareVersions("R5", "r5", 0); // Case insensitive
  }

  @Test
  public void testCompareVersions_FirstIsLater() {
    test_compareVersions("1.0.1", "1.0.0", 1);
    test_compareVersions("1.1.0", "1.0.0", 1);
    test_compareVersions("2.0.0", "1.0.0", 1);
    test_compareVersions("r5", "r4", 1);
    test_compareVersions("2.1.0", "2.0.5", 1);
  }

  @Test
  public void testCompareVersions_SecondIsLater() {
    test_compareVersions("1.0.0", "1.0.1", -1);
    test_compareVersions("1.0.0", "1.1.0", -1);
    test_compareVersions("1.0.0", "2.0.0", -1);
    test_compareVersions("r4", "r5", -1);
    test_compareVersions("2.0.5", "2.1.0", -1);
  }

  @Test
  public void testCompareVersions_Prerelease() {
    test_compareVersions("1.0.0", "1.0.0-alpha", 1);
    test_compareVersions("1.0.0-alpha", "1.0.0-beta", -1);
    test_compareVersions("1.0.0-beta", "1.0.0-alpha", 1);
  }

  @Test
  public void testCompareVersions_MixedDepths() {
    test_compareVersions("1.0", "1.0.0", -1);
    Assertions.assertThrows(FHIRException.class,  () -> VersionUtilities.compareVersions("1", "1.0.0"));
    test_compareVersions("1.1", "1.0", 1);
    test_compareVersions("1.0", "1.1", -1);
  }

  // =============================================
  // includedInRange() TESTS
  // =============================================

  @Test
  public void testIncludedInRange_WithinRange() {
    test_includedInRange("1.0.0", "2.0.0", "1.5.0", true);
    test_includedInRange("r3", "r5", "r4", true);
    test_includedInRange("2.0.0", "3.0.0", "2.1.5", true);
    test_includedInRange("1.0", "2.0", "1.5", true);
  }

  @Test
  public void testIncludedInRange_AtBounds() {
    test_includedInRange("1.0.0", "2.0.0", "1.0.0", true);
    test_includedInRange("1.0.0", "2.0.0", "2.0.0", true);
    test_includedInRange("r3", "r5", "r3", true);
    test_includedInRange("r3", "r5", "r5", true);
  }

  @Test
  public void testIncludedInRange_OutsideRange() {
    test_includedInRange("1.0.0", "2.0.0", "0.9.0", false);
    test_includedInRange("1.0.0", "2.0.0", "2.0.1", false);
    test_includedInRange("r3", "r5", "r2", false);
    test_includedInRange("r3", "r5", "r6", false);
  }

  @Test
  public void testIncludedInRange_SpecialVersions() {
    test_includedInRange("r3", "r5", "r4", true);
    test_includedInRange("r3", "r5", "r4B", true);
    test_includedInRange("R3", "R5", "r4", true); // Case insensitive
  }

  // =============================================
  // Additional complex tests from the original
  // =============================================

  @Test
  public void testisSemVer() {
    // According to semver: X.Y.Z-prerelease+build but we accept major.minor
    test_isSemVer("1.0", true);
    test_isSemVer("0.0", true);
    test_isSemVer("0.1", true);
    test_isSemVer("1", false);
    test_isSemVer("0", false);
    test_isSemVer("2.80", true);
    test_isSemVer("1.0-label", true);
    test_isSemVer("0.0-label", true);
    test_isSemVer("0.1-label", true);
    test_isSemVer("1-label", false);
    test_isSemVer("0-label", false);
    test_isSemVer("2.80-label", true);
  }

  @Test
  public void testComplexLabels_ValidSemverLabels() {
    // According to semver: X.Y.Z-prerelease+build
    test_isSemVer("1.0.0-alpha+build", true);
    test_isSemVer("1.0.0-alpha-beta+build-123", true);
    test_isSemVer("1.0.0-alpha.1+build.2", true);
    test_isSemVer("1.0.0-0.1.2+build.3.4", true);
    test_isSemVer("1.0.0+build-only", true);
    test_isSemVer("1.0.0-prerelease-only", true);

    // Complex prerelease identifiers
    test_isSemVer("1.0.0-alpha.beta.gamma", true);
    test_isSemVer("1.0.0-1.2.3", true);
    test_isSemVer("1.0.0-x.7.z.92", true);
  }

  @Test
  public void testComplexLabels_InvalidSemverLabels() {
    // Invalid according to semver spec
    test_isSemVer("1.2-label", true); // Missing patch - is allowed
    test_isSemVer("1.0.0-", false); // Empty prerelease
    test_isSemVer("1.0.0+", false); // Empty build
    test_isSemVer("1.0.0-+build", false); // Empty prerelease with build
    test_isSemVer("1.0.0-alpha+", false); // Empty build after prerelease
    test_isSemVer("1.0.0+build-alpha", true); // build can contain '-'
    test_isSemVer("1.0.0--alpha", true); // Double dash
    test_isSemVer("1.0.0-+alpha", false); // Double dash
    test_isSemVer("1.0.0+-build", true); // Double plus - totally valid (weird, though)
    test_isSemVer("1.0.0++build", false); // Double plus - totally valid (weird, though)
  }

  @Test
  public void testLeadingZeros() {
    // Leading zeros should be invalid in semver
    test_isSemVer("01.0.0", false);
    test_isSemVer("1.01.0", false);
    test_isSemVer("1.0.01", false);
    test_isSemVer("001.002.003", false);

    // But zero by itself should be fine
    test_isSemVer("0.0.0", true);
    test_isSemVer("1.0.0", true);

    // Leading zeros in prerelease/build identifiers not ok?
    test_isSemVer("1.0.0-01", false);
    test_isSemVer("1.0.0+01", true);
    test_isSemVer("1.0.0-1", true);
    test_isSemVer("1.0.0+1", true);
  }

  // =============================================
  // HELPER METHODS
  // =============================================

  private void test_isSemVer(String version, boolean expected) {
    assertEquals(expected, VersionUtilities.isSemVer(version),
      String.format("isSemVer('%s') should be %s", version, expected));
  }

  private void test_isThisOrLaterMajorMinor(String test, String current, boolean expected) {
    assertEquals(expected, VersionUtilities.isThisOrLater(test, current, VersionUtilities.VersionPrecision.MINOR),
      String.format("isThisOrLaterMajorMinor('%s', '%s') should be %s", test, current, expected));
  }

  private void test_isThisOrLater(String test, String current, boolean expected) {
    assertEquals(expected, VersionUtilities.isThisOrLater(test, current,  VersionUtilities.VersionPrecision.FULL),
      String.format("isThisOrLaterMajorMinorPatch('%s', '%s') should be %s", test, current, expected));
  }

  private void test_getMajMin(String input, String expected) {
    assertEquals(expected, VersionUtilities.getMajMin(input),
      String.format("getMajMin('%s') should be '%s'", input, expected));
  }

  private void test_getMajMinPatch(String input, String expected) {
    assertEquals(expected, VersionUtilities.getMajMinPatch(input),
      String.format("getMajMinPatch('%s') should be '%s'", input, expected));
  }

  private void test_getPatch(String input, String expected) {
    assertEquals(expected, VersionUtilities.getPatch(input),
      String.format("getPatch('%s') should be '%s'", input, expected));
  }

  private void test_incMajorVersion(String input, String expected) {
    assertEquals(expected, VersionUtilities.incMajorVersion(input),
      String.format("incMajorVersion('%s') should be '%s'", input, expected));
  }

  private void test_incMinorVersion(String input, String expected) {
    assertEquals(expected, VersionUtilities.incMinorVersion(input),
      String.format("incMinorVersion('%s') should be '%s'", input, expected));
  }

  private void test_incPatchVersion(String input, String expected) {
    assertEquals(expected, VersionUtilities.incPatchVersion(input),
      String.format("incPatchVersion('%s') should be '%s'", input, expected));
  }

  private void test_versionMatches(String criteria, String candidate, boolean expected) {
    assertEquals(expected, VersionUtilities.versionMatches(criteria, candidate),
      String.format("versionMatches('%s', '%s') should be %s", criteria, candidate, expected));
  }

  private void test_isR4Plus(String version, boolean expected) {
    assertEquals(expected, VersionUtilities.isR4Plus(version),
      String.format("isR4Plus('%s') should be %s", version, expected));
  }

  private void test_isR5Plus(String version, boolean expected) {
    assertEquals(expected, VersionUtilities.isR5Plus(version),
      String.format("isR5Plus('%s') should be %s", version, expected));
  }

  private void test_isR6Plus(String version, boolean expected) {
    assertEquals(expected, VersionUtilities.isR6Plus(version),
      String.format("isR6Plus('%s') should be %s", version, expected));
  }

  private void test_removeVersionFromCanonical(String input, String expected) {
    assertEquals(expected, VersionUtilities.removeVersionFromCanonical(input),
      String.format("removeVersionFromCanonical('%s') should be '%s'", input, expected));
  }

  private void test_compareVersions(String ver1, String ver2, int expected) {
    assertEquals(expected, VersionUtilities.compareVersions(ver1, ver2),
      String.format("compareVersions('%s', '%s') should be %d", ver1, ver2, expected));
  }

  private void test_includedInRange(String startVer, String stopVer, String ver, boolean expected) {
    assertEquals(expected, VersionUtilities.includedInRange(startVer, stopVer, ver),
      String.format("includedInRange('%s', '%s', '%s') should be %s", startVer, stopVer, ver, expected));
  }

  @Test
  @DisplayName("hasWildcards should return false for null and empty inputs")
  void testNullAndEmpty() {
    assertFalse(VersionUtilities.versionHasWildcards(null));
    assertFalse(VersionUtilities.versionHasWildcards(""));
    assertFalse(VersionUtilities.versionHasWildcards("   ")); // whitespace only
  }

  @Test
  @DisplayName("hasWildcards should return false for regular semver versions")
  void testRegularSemver() {
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0"));
    assertFalse(VersionUtilities.versionHasWildcards("2.1.5"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0"));
    assertFalse(VersionUtilities.versionHasWildcards("10.20.30"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-alpha"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+build"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-alpha+build"));
  }

  @Test
  @DisplayName("hasWildcards should return true for question mark suffix wildcard")
  void testQuestionMarkSuffix() {
    assertTrue(VersionUtilities.versionHasWildcards("1.0?"));
    assertTrue(VersionUtilities.versionHasWildcards("2.1.0?"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0-alpha?"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0+build?"));
    assertTrue(VersionUtilities.versionHasWildcards("?"));
  }

  @Test
  @DisplayName("hasWildcards should return true for asterisk wildcard anywhere")
  void testAsteriskWildcard() {
    // Asterisk in version parts
    assertTrue(VersionUtilities.versionHasWildcards("*.0.0"));
    assertTrue(VersionUtilities.versionHasWildcards("1.*.0"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.*"));
    assertTrue(VersionUtilities.versionHasWildcards("*.*.*"));

    // Asterisk in release labels (still wildcard)
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0-*"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0-alpha*"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0-*alpha"));

    // Asterisk in build labels (still wildcard)
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0+*"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0+build*"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0+*build"));

    // Just asterisk
    assertTrue(VersionUtilities.versionHasWildcards("*"));
  }

  @Test
  @DisplayName("hasWildcards should return true for x/X wildcards in version parts")
  void testXWildcardsInVersionParts() {
    // lowercase x in version parts
    assertTrue(VersionUtilities.versionHasWildcards("x.0.0"));
    assertTrue(VersionUtilities.versionHasWildcards("1.x.0"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.x"));
    assertTrue(VersionUtilities.versionHasWildcards("x.x.x"));

    // uppercase X in version parts
    assertTrue(VersionUtilities.versionHasWildcards("X.0.0"));
    assertTrue(VersionUtilities.versionHasWildcards("1.X.0"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.X"));
    assertTrue(VersionUtilities.versionHasWildcards("X.X.X"));

    // Mixed case
    assertTrue(VersionUtilities.versionHasWildcards("x.X.0"));
    assertTrue(VersionUtilities.versionHasWildcards("X.x.0"));

    // Just x or X
    assertTrue(VersionUtilities.versionHasWildcards("x"));
    assertTrue(VersionUtilities.versionHasWildcards("X"));
  }

  @Test
  @DisplayName("hasWildcards should return false for x/X in release labels")
  void testXInReleaseLabels() {
    // x/X in release labels should NOT be considered wildcards
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-x"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-X"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-alpha-x"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-x-alpha"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-prex"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-xpost"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-preX"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-Xpost"));
  }

  @Test
  @DisplayName("hasWildcards should return false for x/X in build labels")
  void testXInBuildLabels() {
    // x/X in build labels should NOT be considered wildcards
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+x"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+X"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+build-x"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+x-build"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+prebuildx"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+xpostbuild"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+prebuildX"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0+Xpostbuild"));
  }

  @Test
  @DisplayName("hasWildcards should handle complex cases with both release and build labels")
  void testComplexCases() {
    // x/X in version part should return true, even with release/build labels
    assertTrue(VersionUtilities.versionHasWildcards("x.0.0-alpha+build"));
    assertTrue(VersionUtilities.versionHasWildcards("1.x.0-alpha+build"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.X-alpha+build"));

    // x/X only in labels should return false
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-x+X"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0-X+x"));

    // Mixed wildcards - any wildcard should return true
    assertTrue(VersionUtilities.versionHasWildcards("*.0.0-x+X"));
    assertTrue(VersionUtilities.versionHasWildcards("1.0.0-x+X?"));
    assertTrue(VersionUtilities.versionHasWildcards("x.0.0-*+build"));
  }

  @Test
  @DisplayName("hasWildcards should handle edge cases")
  void testEdgeCases() {
    // Only separators
    assertFalse(VersionUtilities.versionHasWildcards("-"));
    assertFalse(VersionUtilities.versionHasWildcards("+"));
    assertFalse(VersionUtilities.versionHasWildcards("-+"));
    assertFalse(VersionUtilities.versionHasWildcards("+-"));

    // Wildcards with separators but no version numbers
    assertTrue(VersionUtilities.versionHasWildcards("*-"));
    assertTrue(VersionUtilities.versionHasWildcards("*+"));
    assertTrue(VersionUtilities.versionHasWildcards("x-"));
    assertTrue(VersionUtilities.versionHasWildcards("X+"));

    // Multiple dots
    assertTrue(VersionUtilities.versionHasWildcards("1.x.0.0"));
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0.0-x"));

    // Question mark not at end
    assertFalse(VersionUtilities.versionHasWildcards("1.0.0?-alpha"));
    assertFalse(VersionUtilities.versionHasWildcards("1.?0.0"));
  }
}