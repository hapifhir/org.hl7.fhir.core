package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VersionUtilitiesTest {

  @Test
  public void isValidSemVer() {
    assertTrue(VersionUtilities.isSemVer("0.1.1"));
    assertTrue(VersionUtilities.isSemVer("0.1.1-ballot1"));
    assertFalse(VersionUtilities.isSemVer("0.1.a"));
  }

  @Test
  public void isThisOrLater_Simple() {
    assertTrue(VersionUtilities.isThisOrLater("0.1", "0.2"));
    assertFalse(VersionUtilities.isThisOrLater("0.2", "0.1"));
  }

  @Test
  public void isThisOrLater_NeedNumericComparison() {
    assertTrue(VersionUtilities.isThisOrLater("0.9", "0.10"));
    assertFalse(VersionUtilities.isThisOrLater("0.10", "0.9"));
  }

  @Test
  public void isThisOrLater_DifferentLengths() {
    assertTrue(VersionUtilities.isThisOrLater("0.9", "0.9.1"));
    assertFalse(VersionUtilities.isThisOrLater("0.9.1", "0.9"));
  }

  @Test
  public void isThisOrLater_NonNumeric() {
    assertTrue(VersionUtilities.isThisOrLater("0.A", "0.B"));
    assertFalse(VersionUtilities.isThisOrLater("0.B", "0.A"));
  }


  @Test
  public void isMajMinOrLaterPatch_Simple() {
    assertTrue(VersionUtilities.isMajMinOrLaterPatch("0.9.0", "0.9.0"));
    assertTrue(VersionUtilities.isMajMinOrLaterPatch("0.9.0", "0.9.1"));
    assertFalse(VersionUtilities.isThisOrLater("0.9.0", "0.8.1"));
  }

  @Test
  public void isMajMinOrLaterPatch_VersionWithX() {
    assertTrue(VersionUtilities.isMajMinOrLaterPatch("0.9.x", "0.9.0"));
    assertTrue(VersionUtilities.isMajMinOrLaterPatch("0.9.x", "0.9.1"));
    assertFalse(VersionUtilities.isThisOrLater("0.9.x", "0.8.1"));
  }

  @Test 
  public void bugFixTests() {
    assertTrue(VersionUtilities.isThisOrLater("1.0.0-ballot", "1.0.1"));
  }
}