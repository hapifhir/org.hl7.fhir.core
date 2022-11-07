package org.hl7.fhir.r5.terminology;

import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JurisdictionUtilitiesTests {

  @ParameterizedTest
  @CsvSource({
    "uv,Global (Whole world)",
    "world,Global (Whole world)",
    "global,Global (Whole world)",
    "ar,Argentina",
    "bf,Burkina Faso"
  })
  void testDisplayJurisdiction(String cliString, String expectedDisplayString) {
    final String jurisdiction = JurisdictionUtilities.getJurisdictionFromLocale(cliString);

    assertEquals(expectedDisplayString, JurisdictionUtilities.displayJurisdiction(jurisdiction));
  }
}
