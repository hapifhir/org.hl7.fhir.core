package org.hl7.fhir.dstu3.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.test.support.TestingUtilities;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Test;

class JsonParserTestCase {

  @Test
  void test() throws FHIRFormatError, IOException {
    Resource r = new JsonParser().parse(TestingUtilities.loadTestResourceStream("r3", "ActivityDefinition-referralPrimaryCareMentalHealth.json"));
  }

}
