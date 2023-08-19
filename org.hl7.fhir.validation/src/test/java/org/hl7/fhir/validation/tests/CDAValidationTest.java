package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidatorCli;
import org.junit.jupiter.api.Test;

public class CDAValidationTest {

  private SimpleWorkerContext context;

  @Test
  public void test() throws Exception {
    String fn = TestingUtilities.tempFile("cda", "cda.xml");
    TextFile.stringToFile(TestingUtilities.loadTestResource("cda/cda-original.xml"), fn);
    SystemExitManager.setNoExit(true);
    ValidatorCli.main(new String[] {fn, "-ig", "hl7.cda.uv.core#current", "-tx", FhirSettings.getTxFhirDevelopment()});
  }

}