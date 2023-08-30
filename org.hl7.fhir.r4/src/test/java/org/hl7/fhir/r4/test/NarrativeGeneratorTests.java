package org.hl7.fhir.r4.test;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.EOperationOutcome;
import org.hl7.fhir.r4.utils.NarrativeGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.xmlpull.v1.XmlPullParserException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NarrativeGeneratorTests {

  private NarrativeGenerator gen;

  @BeforeAll
  public void setUp() throws FHIRException {
    gen = new NarrativeGenerator("", null, TestingUtilities.context());
  }

  @Test
  public void test() throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    process(TestingUtilities.resourceNameToFile("questionnaireresponse-example-f201-lifelines.xml"));
  }

  private void process(String path) throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    XmlParser p = new XmlParser();
    DomainResource r = (DomainResource) p.parse(new FileInputStream(path));
    gen.generate(r, null);
    FileOutputStream s = new FileOutputStream(TestingUtilities.resourceNameToFile("gen", "gen.xml"));
    new XmlParser().compose(s, r, true);
    s.close();

  }

}