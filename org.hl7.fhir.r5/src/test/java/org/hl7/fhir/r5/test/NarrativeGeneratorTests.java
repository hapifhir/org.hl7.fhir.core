package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xmlpull.v1.XmlPullParserException;

public class NarrativeGeneratorTests {


  private static RenderingContext rc;

  @BeforeAll
  public static void setUp() throws FHIRException {
    rc = new RenderingContext(TestingUtilities.context(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER);
  }

  @Test
  public void test() throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    process(TestingUtilities.loadTestResourceStream("r5", "questionnaireresponse-example-f201-lifelines.xml"));
  }

  private void process(InputStream stream) throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    XmlParser p = new XmlParser();
    DomainResource r = (DomainResource) p.parse(stream);
    RendererFactory.factory(r, rc).render(r);
    FileOutputStream s = new FileOutputStream(TestingUtilities.tempFile("gen", "gen.xml"));
    new XmlParser().compose(s, r, true);
    s.close();
  }
}