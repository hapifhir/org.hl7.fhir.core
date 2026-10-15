package org.hl7.fhir.validation.cli;

import org.hl7.fhir.services.renderers.RendererFactory;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;

import org.hl7.fhir.validation.cli.picocli.CLI;
import org.hl7.fhir.validation.service.ValidationService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CDAValidationTest {

  @Test
  void test() {
    assertDoesNotThrow(() -> {
      String fn = TestingUtilities.tempFile("cda", "cda.xml");
      FileUtilities.stringToFile(TestingUtilities.loadTestResource("cda/cda-original.xml"), fn);

      CLI cli = new CLI(new ValidationService(new RendererFactory()));
      cli.parseArgsAndExecuteCommand(new String[]{fn, "-ig", "hl7.cda.uv.core#current", "-tx", FhirSettings.getTxFhirDevelopment()});
    });
  }

}