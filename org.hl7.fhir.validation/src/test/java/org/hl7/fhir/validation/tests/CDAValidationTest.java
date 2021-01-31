package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.validation.ValidatorCli;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class CDAValidationTest {

  private SimpleWorkerContext context;

  @Test
  public void test() throws Exception {
    ValidatorCli.main(new String[] {TestingUtilities.loadTestResource("ccda.xml"), "-ig", "hl7.fhir.cda"});
  }

}