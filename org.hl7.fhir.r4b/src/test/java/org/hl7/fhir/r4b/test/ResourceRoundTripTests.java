package org.hl7.fhir.r4b.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.elementmodel.Element;
import org.hl7.fhir.r4b.elementmodel.Manager;
import org.hl7.fhir.r4b.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r4b.formats.IParser;
import org.hl7.fhir.r4b.formats.IParser.OutputStyle;
import org.hl7.fhir.r4b.formats.JsonParser;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.Bundle;
import org.hl7.fhir.r4b.model.DateTimeType;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.RendererFactory;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r4b.test.utils.TestingUtilities;
import org.hl7.fhir.r4b.utils.EOperationOutcome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResourceRoundTripTests {

  @Test
  public void test() throws IOException, FHIRException, EOperationOutcome {
    DomainResource res = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "unicode.xml"));
    RenderingContext rc = new RenderingContext(TestingUtilities.context(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER);
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
  
  @Test
  /**
   * verify that umlaut like äö etc are not encoded in UTF-8 in attributes
   */
  public void testSerializeUmlaut() throws IOException {
    Element xml = Manager.parseSingle(TestingUtilities.context(), TestingUtilities.loadTestResourceStream("r5", "unicode.xml"),
        FhirFormat.XML);
    List<Element> concept = xml.getChildrenByName("concept");
    assertTrue(concept!=null && concept.size()==1);
    List<Element> code = concept.get(0).getChildrenByName("code");
    assertTrue(code!=null && code.size()==1);
    code.get(0).setValue("ö");
    ByteArrayOutputStream baosXml = new  ByteArrayOutputStream();
    Manager.compose(TestingUtilities.context(), xml, baosXml, FhirFormat.XML, OutputStyle.PRETTY, null);
    String cdaSerialised = baosXml.toString("UTF-8");
    assertTrue(cdaSerialised.indexOf("ö")>0); 
  }

}