package org.hl7.fhir.utilities.tests;

import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JsonTrackingParserTests {

  @Test
  public void test() {
    assertDoesNotThrow(() -> {
      JsonTrackingParser.parseJson("{\r\n  \"index-version\": 1,\r\n  \"files\": []\r\n}");
    });
  }
  

  
}