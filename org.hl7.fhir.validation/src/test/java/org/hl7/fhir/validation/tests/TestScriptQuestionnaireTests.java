package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidatorCli;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class TestScriptQuestionnaireTests {
  private SimpleWorkerContext context;

  @Test
  public void test() throws Exception {
    String fn = TestingUtilities.tempFile("testScriptQuestionnaire", "questionnaire.json");
    SystemExitManager.setNoExit(true);
    ValidatorCli.main(new String[] {"-ig", "hl7.fhir.us.physical-activity#dev", "-script-questionnaire", "-outputCanonical",
      "http://hl7.org/fhir/uv/physical-activity/Questionnaire/script-generation", "-version", "4.0", "-output", fn});
    // Todo: Compare against known good file
    fn = fn;
  }
}