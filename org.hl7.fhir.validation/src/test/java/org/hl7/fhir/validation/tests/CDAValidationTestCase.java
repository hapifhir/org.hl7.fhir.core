package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.validation.Validator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class CDAValidationTestCase {

  @Test
  public void test() throws Exception {
    Validator.main(new String[]{TestingUtilities.loadTestResource("ccda.xml"), "-ig", "hl7.fhir.cda"});
  }

}
