package org.hl7.fhir.utilities;

// JUnit Test Cases
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class SemverParserTest {

  @Test
  @DisplayName("Valid basic semver versions")
  void testValidBasicVersions() {
    assertValidParse("1.2.3", Arrays.asList("1", ".", "2", ".", "3"));
    assertValidParse("10.20.30", Arrays.asList("10", ".", "20", ".", "30"));
    assertValidParse("0.0.0", Arrays.asList("0", ".", "0", ".", "0"));
  }

  @Test
  @DisplayName("Valid semver with pre-release")
  void testValidPreReleaseVersions() {
    assertValidParse("1.2.3-prerelease", Arrays.asList("1", ".", "2", ".", "3", "-", "prerelease"));
    assertValidParse("1.1.2-prerelease.1", Arrays.asList("1", ".", "1", ".", "2", "-", "prerelease", ".", "1"));
    assertValidParse("1.1.2-alpha.beta", Arrays.asList("1", ".", "1", ".", "2", "-", "alpha", ".", "beta"));
    assertValidParse("1.1.2-alpha.1", Arrays.asList("1", ".", "1", ".", "2", "-", "alpha", ".", "1"));
    assertValidParse("1.1.2-alpha0.beta", Arrays.asList("1", ".", "1", ".", "2", "-", "alpha0", ".", "beta"));
    assertValidParse("1.1.2-alpha.0beta", Arrays.asList("1", ".", "1", ".", "2", "-", "alpha", ".", "0beta"));
    assertValidParse("1.1.2-alpha-beta", Arrays.asList("1", ".", "1", ".", "2", "-", "alpha-beta"));
    assertValidParse("1.1.2-0", Arrays.asList("1", ".", "1", ".", "2", "-", "0"));
    assertValidParse("1.0.0-0A.is.legal", Arrays.asList("1", ".", "0", ".", "0", "-", "0A", ".", "is", ".", "legal"));
  }

  @Test
  @DisplayName("Valid semver with build metadata")
  void testValidBuildVersions() {
    assertValidParse("1.1.2+meta", Arrays.asList("1", ".", "1", ".", "2", "+", "meta"));
    assertValidParse("1.1.2+123", Arrays.asList("1", ".", "1", ".", "2", "+", "123"));
    assertValidParse("1.1.2+123.456", Arrays.asList("1", ".", "1", ".", "2", "+", "123", ".", "456"));
    assertValidParse("1.1.2+01.02.03", Arrays.asList("1", ".", "1", ".", "2", "+", "01", ".", "02", ".", "03"));
  }

  @Test
  @DisplayName("Valid semver with pre-release and build")
  void testValidPreReleaseAndBuildVersions() {
    assertValidParse("1.1.2-prerelease.1+meta",
      Arrays.asList("1", ".", "1", ".", "2", "-", "prerelease", ".", "1", "+", "meta"));
    assertValidParse("1.1.2-alpha+beta",
      Arrays.asList("1", ".", "1", ".", "2", "-", "alpha", "+", "beta"));
  }

  @Test
  @DisplayName("Invalid semver - incomplete versions")
  void testInvalidIncompleteVersions() {
    assertInvalidParse("1");
    assertInvalidParse("1.2");
    assertInvalidParse("1.2.3-");
    assertInvalidParse("1.2.3+");
    assertInvalidParse("1.2.3-+");
  }

  @Test
  @DisplayName("Invalid semver - leading zeros")
  void testInvalidLeadingZeros() {
    assertInvalidParse("01.1.1");
    assertInvalidParse("1.01.1");
    assertInvalidParse("1.1.01");
    assertInvalidParse("1.2.3-01"); // Leading zero in numeric pre-release
  }

  @Test
  @DisplayName("Invalid semver - empty components")
  void testInvalidEmptyComponents() {
    assertInvalidParse("1..3");
    assertInvalidParse("1.2.");
    assertInvalidParse("1.2.3-.");
    assertInvalidParse("1.2.3+.");
  }

  @Test
  @DisplayName("Edge cases - numeric vs alphanumeric identifiers")
  void testEdgeCases() {
    // Pure numeric pre-release identifiers should work (no leading zeros except "0")
    assertValidParse("1.2.3-123", Arrays.asList("1", ".", "2", ".", "3", "-", "123"));

    // Build identifiers can have leading zeros
    assertValidParse("1.2.3+01", Arrays.asList("1", ".", "2", ".", "3", "+", "01"));

    // Alphanumeric must contain non-digits
    assertValidParse("1.2.3-a1", Arrays.asList("1", ".", "2", ".", "3", "-", "a1"));
    assertValidParse("1.2.3-1a", Arrays.asList("1", ".", "2", ".", "3", "-", "1a"));
  }

  @Test
  @DisplayName("Complex valid cases")
  void testComplexValidCases() {
    assertValidParse("1.1.2-test.1.2.3.4.5",
      Arrays.asList("1", ".", "1", ".", "2", "-", "test", ".", "1", ".", "2", ".", "3", ".", "4", ".", "5"));
  }

  @Test
  @DisplayName("Valid wildcard versions")
  void testValidWildcardVersions() {
    assertValidParseWithWildcards("1.*", Arrays.asList("1", ".", "*"));
    assertValidParseWithWildcards("1.x", Arrays.asList("1", ".", "x"));
    assertValidParseWithWildcards("1.X", Arrays.asList("1", ".", "X"));
    assertValidParseWithWildcards("1.2.*", Arrays.asList("1", ".", "2", ".", "*"));
    assertValidParseWithWildcards("1.2.x", Arrays.asList("1", ".", "2", ".", "x"));
    assertValidParseWithWildcards("1.2.3-*", Arrays.asList("1", ".", "2", ".", "3", "-", "*"));
    assertValidParseWithWildcards("1.2.3-x", Arrays.asList("1", ".", "2", ".", "3", "-", "x"));

    // Build metadata wildcards
    assertValidParseWithWildcards("1.2.3+*", Arrays.asList("1", ".", "2", ".", "3", "+", "*"));
    assertValidParseWithWildcards("1.2.3+x", Arrays.asList("1", ".", "2", ".", "3", "+", "x"));
    assertValidParseWithWildcards("1.2.3+build.*", Arrays.asList("1", ".", "2", ".", "3", "+", "build", ".", "*"));

    // Multiple wildcards in same version (the problematic case)
    assertValidParseWithWildcards("2.x.x-x", Arrays.asList("2", ".", "x", ".", "x", "-", "x"));
    assertValidParseWithWildcards("1.*.X+*", Arrays.asList("1", ".", "*", ".", "X", "+", "*"));

    // Multiple wildcard characters
    assertValidParseWithWildcards("1.xxx", Arrays.asList("1", ".", "xxx"));
    assertValidParseWithWildcards("1.**", Arrays.asList("1", ".", "**"));
    assertValidParseWithWildcards("1.x*X", Arrays.asList("1", ".", "x*X"));
  }

  @Test
  @DisplayName("Invalid wildcard versions - illogical mixing")
  void testInvalidWildcardVersionsIllogicalMixing() {
    // These should fail because they mix wildcards with concrete values illogically
    assertInvalidParseWithWildcards("1.x.3"); // wildcard minor with concrete patch doesn't make sense
    assertInvalidParseWithWildcards("1.*.3"); // wildcard minor with concrete patch doesn't make sense

    // These are logical and should work
    assertValidParseWithWildcards("1.*", Arrays.asList("1", ".", "*")); // wildcard minor, no patch
    assertValidParseWithWildcards("1.x.x", Arrays.asList("1", ".", "x", ".", "x")); // wildcard minor, wildcard patch
    assertValidParseWithWildcards("1.2.*", Arrays.asList("1", ".", "2", ".", "*")); // concrete minor, wildcard patch
  }

  @Test
  @DisplayName("Wildcard versions without flag should be invalid")
  void testWildcardVersionsWithoutFlag() {
    // These should fail when wildcard flag is false
    assertInvalidParse("1.*");
    assertInvalidParse("1.x");
    assertInvalidParse("1.2.*");
    assertInvalidParse("1.2.3-*");
    assertInvalidParse("2.x.x-x");
  }

  @Test
  @DisplayName("Wildcard edge cases")
  void testWildcardEdgeCases() {
    // Wildcards only in allowed positions
    assertValidParseWithWildcards("1.*", Arrays.asList("1", ".", "*"));
    assertValidParseWithWildcards("1.2.*", Arrays.asList("1", ".", "2", ".", "*"));

    // Should terminate immediately after wildcard
    assertValidParseWithWildcards("1.2.3-*", Arrays.asList("1", ".", "2", ".", "3", "-", "*"));
    assertValidParseWithWildcards("1.2.3+*", Arrays.asList("1", ".", "2", ".", "3", "+", "*"));

    // Mixed wildcard characters
    assertValidParseWithWildcards("1.2.xX*", Arrays.asList("1", ".", "2", ".", "xX*"));
    assertValidParseWithWildcards("1.2.3+x*X", Arrays.asList("1", ".", "2", ".", "3", "+", "x*X"));
  }

  private void assertValidParseWithWildcards(String input, java.util.List<String> expectedParts) {
    SemverParser.ParseResult result = SemverParser.parseSemver(input, true);
    assertTrue(result.isSuccess(),
      String.format("Expected '%s' to be valid with wildcards, but got error: %s", input, result.getError()));
    assertEquals(expectedParts, result.getParts(),
      String.format("Parts mismatch for wildcard input '%s'", input));
  }

  private void assertInvalidParseWithWildcards(String input) {
    SemverParser.ParseResult result = SemverParser.parseSemver(input, true);
    assertFalse(result.isSuccess(),
      String.format("Expected '%s' to be invalid with wildcards, but it was parsed successfully with parts: %s",
        input, result.isSuccess() ? result.getParts() : "N/A"));
  }

  @Test
  @DisplayName("Semantic accessor methods - basic versions")
  void testSemanticAccessorsBasic() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3");
    assertTrue(result.isSuccess());
    assertEquals("1", result.getMajor());
    assertEquals("2", result.getMinor());
    assertEquals("3", result.getPatch());
    assertNull(result.getReleaseLabel());
    assertNull(result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - with pre-release")
  void testSemanticAccessorsPreRelease() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3-alpha.1");
    assertTrue(result.isSuccess());
    assertEquals("1", result.getMajor());
    assertEquals("2", result.getMinor());
    assertEquals("3", result.getPatch());
    assertEquals("alpha.1", result.getReleaseLabel());
    assertNull(result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - with build")
  void testSemanticAccessorsBuild() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3+build.456");
    assertTrue(result.isSuccess());
    assertEquals("1", result.getMajor());
    assertEquals("2", result.getMinor());
    assertEquals("3", result.getPatch());
    assertNull(result.getReleaseLabel());
    assertEquals("build.456", result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - with both pre-release and build")
  void testSemanticAccessorsBoth() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3-alpha.1+build.456");
    assertTrue(result.isSuccess());
    assertEquals("1", result.getMajor());
    assertEquals("2", result.getMinor());
    assertEquals("3", result.getPatch());
    assertEquals("alpha.1", result.getReleaseLabel());
    assertEquals("build.456", result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - with wildcards")
  void testSemanticAccessorsWildcards() {
    SemverParser.ParseResult result1 = SemverParser.parseSemver("1.*", true);
    assertTrue(result1.isSuccess());
    assertEquals("1", result1.getMajor());
    assertEquals("*", result1.getMinor());
    assertNull(result1.getPatch());
    assertNull(result1.getReleaseLabel());
    assertNull(result1.getBuild());

    SemverParser.ParseResult result2 = SemverParser.parseSemver("1.2.x", true);
    assertTrue(result2.isSuccess());
    assertEquals("1", result2.getMajor());
    assertEquals("2", result2.getMinor());
    assertEquals("x", result2.getPatch());
    assertNull(result2.getReleaseLabel());
    assertNull(result2.getBuild());

    SemverParser.ParseResult result3 = SemverParser.parseSemver("1.2.3-*", true);
    assertTrue(result3.isSuccess());
    assertEquals("1", result3.getMajor());
    assertEquals("2", result3.getMinor());
    assertEquals("3", result3.getPatch());
    assertEquals("*", result3.getReleaseLabel());
    assertNull(result3.getBuild());

    SemverParser.ParseResult result4 = SemverParser.parseSemver("1.2.3+*", true);
    assertTrue(result4.isSuccess());
    assertEquals("1", result4.getMajor());
    assertEquals("2", result4.getMinor());
    assertEquals("3", result4.getPatch());
    assertNull(result4.getReleaseLabel());
    assertEquals("*", result4.getBuild());

    SemverParser.ParseResult result5 = SemverParser.parseSemver("1.2.3+build.x", true);
    assertTrue(result5.isSuccess());
    assertEquals("1", result5.getMajor());
    assertEquals("2", result5.getMinor());
    assertEquals("3", result5.getPatch());
    assertNull(result5.getReleaseLabel());
    assertEquals("build.x", result5.getBuild());

    // Test the complex case that was failing
    SemverParser.ParseResult result6 = SemverParser.parseSemver("2.x.x-x", true);
    assertTrue(result6.isSuccess());
    assertEquals("2", result6.getMajor());
    assertEquals("x", result6.getMinor());
    assertEquals("x", result6.getPatch());
    assertEquals("x", result6.getReleaseLabel());
    assertNull(result6.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - complex pre-release and build")
  void testSemanticAccessorsComplex() {
    SemverParser.ParseResult result = SemverParser.parseSemver("1.2.3-alpha-beta.1.2.3+build.meta.data.123");
    assertTrue(result.isSuccess());
    assertEquals("1", result.getMajor());
    assertEquals("2", result.getMinor());
    assertEquals("3", result.getPatch());
    assertEquals("alpha-beta.1.2.3", result.getReleaseLabel());
    assertEquals("build.meta.data.123", result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - error cases")
  void testSemanticAccessorsErrors() {
    SemverParser.ParseResult result = SemverParser.parseSemver("invalid");
    assertFalse(result.isSuccess());
    assertNull(result.getMajor());
    assertNull(result.getMinor());
    assertNull(result.getPatch());
    assertNull(result.getReleaseLabel());
    assertNull(result.getBuild());
  }

  @Test
  @DisplayName("Semantic accessor methods - edge cases")
  void testSemanticAccessorsEdgeCases() {
    // Single component pre-release and build
    SemverParser.ParseResult result1 = SemverParser.parseSemver("1.2.3-alpha+build");
    assertTrue(result1.isSuccess());
    assertEquals("alpha", result1.getReleaseLabel());
    assertEquals("build", result1.getBuild());

    // Numeric pre-release
    SemverParser.ParseResult result2 = SemverParser.parseSemver("1.2.3-123");
    assertTrue(result2.isSuccess());
    assertEquals("123", result2.getReleaseLabel());

    // Build with leading zeros
    SemverParser.ParseResult result3 = SemverParser.parseSemver("1.2.3+001.002");
    assertTrue(result3.isSuccess());
    assertEquals("001.002", result3.getBuild());
  }

  @Test
  @DisplayName("Optional patch - valid cases")
  void testOptionalPatchValid() {
    assertValidParseOptionalPatch("1.2", Arrays.asList("1", ".", "2"));
    assertValidParseOptionalPatch("10.20", Arrays.asList("10", ".", "20"));
    assertValidParseOptionalPatch("0.0", Arrays.asList("0", ".", "0"));

    // With pre-release
    assertValidParseOptionalPatch("1.2-alpha", Arrays.asList("1", ".", "2", "-", "alpha"));
    assertValidParseOptionalPatch("1.2-alpha.1", Arrays.asList("1", ".", "2", "-", "alpha", ".", "1"));

    // With build
    assertValidParseOptionalPatch("1.2+build", Arrays.asList("1", ".", "2", "+", "build"));
    assertValidParseOptionalPatch("1.2+build.123", Arrays.asList("1", ".", "2", "+", "build", ".", "123"));

    // With both
    assertValidParseOptionalPatch("1.2-alpha+build", Arrays.asList("1", ".", "2", "-", "alpha", "+", "build"));

    // Full version still works
    assertValidParseOptionalPatch("1.2.3", Arrays.asList("1", ".", "2", ".", "3"));
    assertValidParseOptionalPatch("1.2.3-alpha+build", Arrays.asList("1", ".", "2", ".", "3", "-", "alpha", "+", "build"));
  }

  @Test
  @DisplayName("Optional patch - invalid when required")
  void testOptionalPatchInvalidWhenRequired() {
    // These should fail when patch is required (default behavior)
    assertInvalidParse("1.2");
    assertInvalidParse("1.2-alpha");
    assertInvalidParse("1.2+build");
    assertInvalidParse("1.2-alpha+build");
  }

  @Test
  @DisplayName("Optional patch - with wildcards")
  void testOptionalPatchWithWildcards() {
    assertValidParseOptionalPatchWithWildcards("1.x", Arrays.asList("1", ".", "x"));
    assertValidParseOptionalPatchWithWildcards("1.*", Arrays.asList("1", ".", "*"));
    assertValidParseOptionalPatchWithWildcards("1.X", Arrays.asList("1", ".", "X"));

    // These should now be invalid (mixing wildcard with concrete)
    assertInvalidParseOptionalPatchWithWildcards("1.x.3");
    assertInvalidParseOptionalPatchWithWildcards("1.*.beta");
  }

  @Test
  @DisplayName("Optional patch - semantic accessors")
  void testOptionalPatchSemanticAccessors() {
    SemverParser.ParseResult result1 = SemverParser.parseSemver("1.2", false, false);
    assertTrue(result1.isSuccess());
    assertEquals("1", result1.getMajor());
    assertEquals("2", result1.getMinor());
    assertNull(result1.getPatch());
    assertNull(result1.getReleaseLabel());
    assertNull(result1.getBuild());

    SemverParser.ParseResult result2 = SemverParser.parseSemver("1.2-alpha", false, false);
    assertTrue(result2.isSuccess());
    assertEquals("1", result2.getMajor());
    assertEquals("2", result2.getMinor());
    assertNull(result2.getPatch());
    assertEquals("alpha", result2.getReleaseLabel());
    assertNull(result2.getBuild());

    SemverParser.ParseResult result3 = SemverParser.parseSemver("1.2+build", false, false);
    assertTrue(result3.isSuccess());
    assertEquals("1", result3.getMajor());
    assertEquals("2", result3.getMinor());
    assertNull(result3.getPatch());
    assertNull(result3.getReleaseLabel());
    assertEquals("build", result3.getBuild());

    SemverParser.ParseResult result4 = SemverParser.parseSemver("1.2-alpha+build", false, false);
    assertTrue(result4.isSuccess());
    assertEquals("1", result4.getMajor());
    assertEquals("2", result4.getMinor());
    assertNull(result4.getPatch());
    assertEquals("alpha", result4.getReleaseLabel());
    assertEquals("build", result4.getBuild());
  }

  @Test
  @DisplayName("Optional patch - edge cases")
  void testOptionalPatchEdgeCases() {
    // Leading zeros still not allowed
    assertInvalidParseOptionalPatch("01.2");
    assertInvalidParseOptionalPatch("1.02");

    // Empty components still not allowed
    assertInvalidParseOptionalPatch("1.");
    assertInvalidParseOptionalPatch(".2");
    assertInvalidParseOptionalPatch("1.2.");

    // Single component still invalid
    assertInvalidParseOptionalPatch("1");
  }

  private void assertValidParseOptionalPatch(String input, java.util.List<String> expectedParts) {
    SemverParser.ParseResult result = SemverParser.parseSemver(input, false, false);
    assertTrue(result.isSuccess(),
      String.format("Expected '%s' to be valid with optional patch, but got error: %s", input, result.getError()));
    assertEquals(expectedParts, result.getParts(),
      String.format("Parts mismatch for optional patch input '%s'", input));
  }

  private void assertInvalidParseOptionalPatch(String input) {
    SemverParser.ParseResult result = SemverParser.parseSemver(input, false, false);
    assertFalse(result.isSuccess(),
      String.format("Expected '%s' to be invalid with optional patch, but it was parsed successfully with parts: %s",
        input, result.isSuccess() ? result.getParts() : "N/A"));
  }

  private void assertValidParseOptionalPatchWithWildcards(String input, java.util.List<String> expectedParts) {
    SemverParser.ParseResult result = SemverParser.parseSemver(input, true, false);
    assertTrue(result.isSuccess(),
      String.format("Expected '%s' to be valid with optional patch and wildcards, but got error: %s", input, result.getError()));
    assertEquals(expectedParts, result.getParts(),
      String.format("Parts mismatch for optional patch with wildcards input '%s'", input));
  }

  private void assertInvalidParseOptionalPatchWithWildcards(String input) {
    SemverParser.ParseResult result = SemverParser.parseSemver(input, true, false);
    assertFalse(result.isSuccess(),
      String.format("Expected '%s' to be invalid with optional patch and wildcards, but it was parsed successfully with parts: %s",
        input, result.isSuccess() ? result.getParts() : "N/A"));
  }

  private void assertValidParse(String input, java.util.List<String> expectedParts) {
    SemverParser.ParseResult result = SemverParser.parseSemver(input);
    assertTrue(result.isSuccess(),
      String.format("Expected '%s' to be valid, but got error: %s", input, result.getError()));
    assertEquals(expectedParts, result.getParts(),
      String.format("Parts mismatch for input '%s'", input));
  }

  private void assertInvalidParse(String input) {
    SemverParser.ParseResult result = SemverParser.parseSemver(input);
    assertFalse(result.isSuccess(),
      String.format("Expected '%s' to be invalid, but it was parsed successfully with parts: %s",
        input, result.isSuccess() ? result.getParts() : "N/A"));
  }

}