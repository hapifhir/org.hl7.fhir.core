package org.hl7.fhir.validation.cli;

import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;

import org.hl7.fhir.validation.cli.ValidatorCli;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CDAValidationTest {

  private SimpleWorkerContext context;

  @Test
  public void test() {
    assertDoesNotThrow(() -> {
      String fn = TestingUtilities.tempFile("cda", "cda.xml");
      FileUtilities.stringToFile(TestingUtilities.loadTestResource("cda/cda-original.xml"), fn);
      SystemExitManager.setNoExit(true);
      ValidatorCli.main(new String[] {fn, "-ig", "hl7.cda.uv.core#current", "-tx", FhirSettings.getTxFhirDevelopment()});
    });
  }

}