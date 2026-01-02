package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.openapi.OpenApiGenerator;
import org.hl7.fhir.r5.openapi.Writer;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class OpenApiGeneratorTest {

  @Test
  void testBase1() {
    assertDoesNotThrow(() -> {
      InputStream sfn = TestingUtilities.loadTestResourceStream("r5", "openapi", "cs-base.json");
      String dfn = TestingUtilities.tempFile("openapi", "swagger-base.json");
      run(sfn, dfn);
    });
  }

  @Test
  void testBase2() {
    assertDoesNotThrow(() -> {
      InputStream sfn = TestingUtilities.loadTestResourceStream("r5", "openapi", "cs-base2.json");
      String dfn = TestingUtilities.tempFile("openapi", "swagger-base2.json");
      run(sfn, dfn);
    });
  }

  public void run(InputStream sfn, String dfn) throws IOException, FHIRFormatError, FileNotFoundException {
    CapabilityStatement cs = (CapabilityStatement) new JsonParser().parse(sfn);
    Writer oa = new Writer(ManagedFileAccess.outStream(dfn));
    OpenApiGenerator gen = new OpenApiGenerator(TestingUtilities.getSharedWorkerContext(), cs, oa);
    gen.generate("test-lic", "http://spdx.org/licenses/test-lic.html");
    oa.commit();
  }
}