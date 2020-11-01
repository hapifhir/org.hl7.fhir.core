package org.hl7.fhir.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VersionUtilitiesTest {

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


}