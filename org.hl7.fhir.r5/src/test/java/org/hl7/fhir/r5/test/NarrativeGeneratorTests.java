package org.hl7.fhir.r5.test;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.NarrativeGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xmlpull.v1.XmlPullParserException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NarrativeGeneratorTests {

  private static NarrativeGenerator gen;

  @BeforeAll
  public static void setUp() throws FHIRException {
    gen = new NarrativeGenerator("", null, TestingUtilities.context());
  }

  @Test
  public void test() throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    process(TestingUtilities.loadTestResourceStream("r5", "questionnaireresponse-example-f201-lifelines.xml"));
  }

  private void process(InputStream stream) throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    XmlParser p = new XmlParser();
    DomainResource r = (DomainResource) p.parse(stream);
    gen.generate(r, null);
    FileOutputStream s = new FileOutputStream(TestingUtilities.tempFile("gen", "gen.xml"));
    new XmlParser().compose(s, r, true);
    s.close();
  }
}