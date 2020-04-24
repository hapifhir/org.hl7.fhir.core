package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.Validator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

@Disabled
public class TransformationTests {

  @Test
  public void testCCDA() throws Exception {
    String mappings = Utilities.path(TestingUtilities.home(), "tests", "transform-examples", "ccda");
    String input = Utilities.path(TestingUtilities.home(), "tests", "transform-examples", "ccda.xml");
    String output = Utilities.path("[tmp]", "cda-bundle.txt");
    String log = Utilities.path("[tmp]", "transform-log.txt");

    Validator.main(new String[]{input, "-transform", "http://hl7.org/fhir/cda/mapping/ccdaDocumentToFhir", "-ig", "hl7.fhir.cda", "-ig", mappings, "-output", output, "-log", log});
    checkFile(output);
    checkFile(log);
  }

  private void checkFile(String fn) throws Exception {
    if (!(new File(fn).exists()))
      throw new Exception("Unable to find output file " + fn);

  }

}
