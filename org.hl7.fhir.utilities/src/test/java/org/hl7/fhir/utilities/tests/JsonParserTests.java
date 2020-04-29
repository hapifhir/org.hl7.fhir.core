package org.hl7.fhir.utilities.tests;

import java.io.IOException;

import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.junit.jupiter.api.Test;

public class JsonParserTests {

  @Test
  public void test() throws IOException {
    JsonTrackingParser.parseJson("{\r\n  \"index-version\": 1,\r\n  \"files\": []\r\n}");
  }
  
}
