package org.hl7.fhir.dstu3.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.dstu3.context.SimpleWorkerContext;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.DomainResource;
import org.hl7.fhir.dstu3.utils.EOperationOutcome;
import org.hl7.fhir.dstu3.utils.NarrativeGenerator;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.xmlpull.v1.XmlPullParserException;

@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NarrativeGeneratorTests {

  private NarrativeGenerator gen;

  @BeforeAll
  public void setUp() throws IOException, FHIRException {
    gen = new NarrativeGenerator("", null, SimpleWorkerContext.fromPack("C:\\work\\org.hl7.fhir\\build\\publish\\definitions.xml.zip"));
  }

  @AfterAll
  public void tearDown() {
  }

  @Test
  public void test() throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    process("C:\\work\\org.hl7.fhir\\build\\source\\questionnaireresponse\\questionnaireresponse-example-f201-lifelines.xml");
  }

  private void process(String path) throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    XmlParser p = new XmlParser();
    DomainResource r = (DomainResource) p.parse(new FileInputStream(path));
    gen.generate(r);
    FileOutputStream s = new FileOutputStream(Utilities.path("[tmp]", "gen.xml"));
    new XmlParser().compose(s, r, true);
    s.close();

  }

}