package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r5.validation.Validator;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.Test;

public class CDAValidationTestCase {

  private SimpleWorkerContext context;

  @Test
  public void test() throws Exception {
    Validator.main(new String[] {TestUtilities.resourceNameToFile("ccda.xml"), "-ig", "hl7.fhir.cda"});
  }

}
