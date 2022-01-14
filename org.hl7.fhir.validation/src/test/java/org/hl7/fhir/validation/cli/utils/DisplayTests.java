package org.hl7.fhir.validation.cli.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayTests {

  @Test
  public void displayHelpDetails() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    final PrintStream originalOut = System.out;
    final PrintStream originalErr = System.err;

    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));

    try {
      Display.displayHelpDetails();

      String output = outContent.toString();

      for (String[] placeHolder:  Display.PLACEHOLDERS) {
        assertTrue(output.contains(placeHolder[1]), placeHolder[1] + " is not contained in output:\n" + output);
        assertFalse(output.contains(placeHolder[0]), placeHolder[0] + " found in output:\n" + output);
      }
    }
    finally {
      System.setOut(originalOut);
      System.setErr(originalErr);
    }
  }

  @Test
  public void testReplacePlaceholdersBaseCase() {

    final String myTestString = "The {{DUMMY_A}} jumps over the {{DUMMY_B}}.";
    final String[][] placeHolders = {
      { "\\{\\{DUMMY_A\\}\\}", "quick brown fox"},
      { "\\{\\{DUMMY_B\\}\\}", "lazy dog"},
    };

    final String expectedOutput = "The quick brown fox jumps over the lazy dog.";
    final String output = Display.replacePlaceholders(myTestString, placeHolders);

    assertEquals(expectedOutput, output);
  }

}
