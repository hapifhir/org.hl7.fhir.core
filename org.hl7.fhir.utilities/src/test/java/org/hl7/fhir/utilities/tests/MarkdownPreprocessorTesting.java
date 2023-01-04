package org.hl7.fhir.utilities.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.hl7.fhir.utilities.MarkDownProcessor;
import org.junit.jupiter.api.Test;

public class MarkdownPreprocessorTesting {

  @Test
  public void testSimple() throws IOException {
    assertEquals(MarkDownProcessor.preProcess("1 < 2"), "1 < 2");
  }
  
  @Test
  public void testHTML() throws IOException {
    assertEquals(MarkDownProcessor.preProcess("<type>"), "\\<type>");
    assertEquals(MarkDownProcessor.preProcess("\\<type>"), "\\<type>");
  }


  @Test
  public void testBorder() throws IOException {
    assertEquals(MarkDownProcessor.preProcess("<>"), "<>");
    assertEquals(MarkDownProcessor.preProcess("><"), "><");
  }

}
