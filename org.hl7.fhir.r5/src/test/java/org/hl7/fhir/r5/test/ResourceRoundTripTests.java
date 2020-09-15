package org.hl7.fhir.r5.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResourceRoundTripTests {

  @Test
  public void test() throws IOException, FHIRException, EOperationOutcome {
    DomainResource res = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "unicode.xml"));
    RenderingContext rc = new RenderingContext(TestingUtilities.context(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.RESOURCE);
    RendererFactory.factory(res, rc).render(res);
    IOUtils.copy(TestingUtilities.loadTestResourceStream("r5", "unicode.xml"), new FileOutputStream(TestingUtilities.tempFile("gen", "unicode.xml")));
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(TestingUtilities.tempFile("gen", "unicode.out.xml")), res);
  }

  @Test
  public void testBundle() throws FHIRException, IOException {
    // Create new Atom Feed
    Bundle feed = new Bundle();

    // Serialize Atom Feed
    IParser comp = new JsonParser();
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    comp.compose(os, feed);
    os.close();
    String json = os.toString();

    // Deserialize Atom Feed
    JsonParser parser = new JsonParser();
    InputStream is = new ByteArrayInputStream(json.getBytes("UTF-8"));
    Resource result = parser.parse(is);
    if (result == null)
      throw new FHIRException("Bundle was null");
  }
  
}