package org.hl7.fhir.test;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.services.openapi.OpenApiGenerator;
import org.hl7.fhir.services.openapi.Writer;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OpenApiGeneratorTest {

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

  @Test
  void testExtendedOperations() {
    assertDoesNotThrow(() -> {
      InputStream sfn = TestingUtilities.loadTestResourceStream("r5", "openapi", "cs-r5-extended.json");
      String dfn = TestingUtilities.tempFile("openapi", "swagger-extended.json");
      run(sfn, dfn);
    });
  }

  public void run(InputStream sfn, String dfn) throws IOException, FHIRFormatError {
    CapabilityStatement cs = (CapabilityStatement) new JsonParser(TestingUtilities.getSharedWorkerContext()).parse(sfn);
    Writer oa = new Writer(ManagedFileAccess.outStream(dfn));
    OpenApiGenerator gen = new OpenApiGenerator(TestingUtilities.getSharedWorkerContext(), cs, oa);
    gen.generate("test-lic", "http://spdx.org/licenses/test-lic.html");
    oa.commit();
  }
}
