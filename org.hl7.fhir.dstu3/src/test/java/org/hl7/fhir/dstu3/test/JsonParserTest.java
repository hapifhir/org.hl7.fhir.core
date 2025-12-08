package org.hl7.fhir.dstu3.test;

import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.test.support.TestingUtilities;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class JsonParserTest {

  @Test
  void testParseJsonNull() throws FHIRFormatError {
    assertDoesNotThrow(() -> {
      Resource r = new JsonParser().parse(TestingUtilities.loadTestResourceStream("r3", "activitydefinition-referralprimarycarementalhealth.json"));
    });
  }

  @Test
  void testComposeAndParseWithOriginal() throws FHIRFormatError {
    assertDoesNotThrow(() -> {
      JsonParser jsonParser = new JsonParser();
      Resource resource = jsonParser.parse(TestingUtilities.loadTestResourceStream("r3",
          "activitydefinition-referralprimarycarementalhealth-original.json"));
      String composed = jsonParser.composeString(resource);
      jsonParser.parse(composed);
    });
  }

}
