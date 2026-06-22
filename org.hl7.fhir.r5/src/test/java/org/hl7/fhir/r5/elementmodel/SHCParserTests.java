package org.hl7.fhir.r5.elementmodel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class SHCParserTests {

  @Test
  void testEmptyInput() throws DataFormatException, IOException {
    SHCParser.inflate(new byte[0]);
  }
}
