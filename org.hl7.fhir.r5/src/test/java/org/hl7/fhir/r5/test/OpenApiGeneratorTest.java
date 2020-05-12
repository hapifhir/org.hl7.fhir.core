package org.hl7.fhir.r5.test;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.openapi.OpenApiGenerator;
import org.hl7.fhir.r5.openapi.Writer;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class OpenApiGeneratorTest {

  @Test
  public void testBase1() throws IOException, FHIRFormatError {
    InputStream sfn = TestingUtilities.loadTestResourceStream("r5", "openapi", "cs-base.json");
    String dfn = TestingUtilities.tempFile("openapi", "swagger-base.json");
    run(sfn, dfn);
  }

  @Test
  public void testBase2() throws FHIRFormatError, FileNotFoundException, IOException {
    InputStream sfn = TestingUtilities.loadTestResourceStream("r5", "openapi", "cs-base2.json");
    String dfn = TestingUtilities.tempFile("openapi", "swagger-base2.json");
    run(sfn, dfn);
  }

  public void run(InputStream sfn, String dfn) throws IOException, FHIRFormatError, FileNotFoundException {
    CapabilityStatement cs = (CapabilityStatement) new JsonParser().parse(sfn);
    Writer oa = new Writer(new FileOutputStream(dfn));
    OpenApiGenerator gen = new OpenApiGenerator(TestingUtilities.context(), cs, oa);
    gen.generate("test-lic", "http://spdx.org/licenses/test-lic.html");
    oa.commit();
  }
}