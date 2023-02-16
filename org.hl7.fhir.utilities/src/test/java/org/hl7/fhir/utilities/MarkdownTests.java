package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MarkdownTests {

  @Test
  void testStringToMarkdown() {
    Assertions.assertEquals("This is \\*a test\\*", MarkDownProcessor.makeStringSafeAsMarkdown("This is *a test*"));
    Assertions.assertEquals("This is *a test*", MarkDownProcessor.makeMarkdownForString("This is \\*a test\\*"));
  }

}
