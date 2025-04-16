package org.hl7.fhir.validation.service.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hl7.fhir.r5.model.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DisplayTests {


  final static String[][] PLACEHOLDERS = {
    { "XML_AND_JSON_FHIR_VERSIONS", "1.0, 1.4, 3.0, 4.0, " + Constants.VERSION_MM },
    { "TURTLE_FHIR_VERSIONS", "3.0, 4.0, " + Constants.VERSION_MM },
  };
  @Test
  @DisplayName("Check for placeholder replacement in help output")
  public void displayHelpDetails() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    PrintStream out = new PrintStream(outContent);
    PrintStream err  = new PrintStream(errContent);

      Display.displayHelpDetails(out, "help/validate.txt", PLACEHOLDERS);

      String output = outContent.toString();

      for (String[] placeHolder: PLACEHOLDERS) {
        assertTrue(output.contains(placeHolder[1]), placeHolder[1] + " is not contained in output:\n" + output);
        assertFalse(output.contains(placeHolder[0]), placeHolder[0] + " found in output:\n" + output);
      }

  }

  @Test
  @DisplayName("Test replacePlaceholder base case")
  public void testReplacePlaceholdersBaseCase() {

    final String myTestString = "The {{DUMMY_A}} jumps over the {{DUMMY_B}}.";
    final String[][] placeHolders = {
      { "DUMMY_A", "quick brown fox"},
      { "DUMMY_B", "lazy dog"},
    };

    final String expectedOutput = "The quick brown fox jumps over the lazy dog.";
    final String output = Display.replacePlaceholders(myTestString, placeHolders);

    assertEquals(expectedOutput, output);
  }

}
