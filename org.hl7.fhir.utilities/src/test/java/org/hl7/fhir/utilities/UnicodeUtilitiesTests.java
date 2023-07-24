package org.hl7.fhir.utilities;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UnicodeUtilitiesTests {
  @Test
  @DisplayName("Test Unicode bidi-detection working")
  public void testUnicodeBiDiDetection() throws IOException {
    Assertions.assertFalse(UnicodeUtilities.hasBiDiChars("abc"));
    Assertions.assertTrue(UnicodeUtilities.hasBiDiChars(UnicodeUtilities.RLI + "abc" + UnicodeUtilities.PDI));
  }

  @Test
  @DisplayName("Test Unicode match checking working")
  public void testUnicodeMatchChecking() throws IOException {
    Assertions.assertNull(UnicodeUtilities.checkUnicodeWellFormed("abc"));
    Assertions.assertNull(UnicodeUtilities.checkUnicodeWellFormed(UnicodeUtilities.RLI + "abc" + UnicodeUtilities.PDI));
    Assertions.assertNull(UnicodeUtilities.checkUnicodeWellFormed(UnicodeUtilities.RLI + " "+ UnicodeUtilities.LRI + "a b c "+ 
       UnicodeUtilities.PDI+" "+UnicodeUtilities.LRI+" d e f "+UnicodeUtilities.PDI+" "+UnicodeUtilities.PDI));
    Assertions.assertEquals(UnicodeUtilities.checkUnicodeWellFormed("'''subject funds from back account then "+UnicodeUtilities.RLI + "''' ;return"),
        "Unicode Character RLI at index 40 has no terminating match (preceding text = 'then ')");
  }
    
}
