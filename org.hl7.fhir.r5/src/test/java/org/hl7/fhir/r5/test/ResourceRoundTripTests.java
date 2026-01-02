package org.hl7.fhir.r5.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ResourceRoundTripTests {

  @Test
  void test() {
    assertDoesNotThrow(() -> {
      DomainResource res = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "unicode.xml"));
      RenderingContext rc = new RenderingContext(TestingUtilities.getSharedWorkerContext(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
      RendererFactory.factory(res, rc).renderResource(ResourceWrapper.forResource(rc.getContextUtilities(), res));
      IOUtils.copy(TestingUtilities.loadTestResourceStream("r5", "unicode.xml"), ManagedFileAccess.outStream(TestingUtilities.tempFile("gen", "unicode.xml")));
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(TestingUtilities.tempFile("gen", "unicode.out.xml")), res);
    });
  }

  @Test
  void testBundle() {
    assertDoesNotThrow(() -> {
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
    });
  }
  
  @Test
  /**
   * verify that umlaut like äö etc are not encoded in UTF-8 in attributes
   */
  public void testSerializeUmlaut() throws IOException {
    Element xml = Manager.parseSingle(TestingUtilities.getSharedWorkerContext(), TestingUtilities.loadTestResourceStream("r5", "unicode.xml"),
        FhirFormat.XML);
    List<Element> concept = xml.getChildrenByName("concept");
    assertTrue(concept!=null && concept.size()==1);
    List<Element> code = concept.get(0).getChildrenByName("code");
    assertTrue(code!=null && code.size()==1);
    code.get(0).setValue("ö");
    ByteArrayOutputStream baosXml = new  ByteArrayOutputStream();
    Manager.compose(TestingUtilities.getSharedWorkerContext(), xml, baosXml, FhirFormat.XML, OutputStyle.PRETTY, null);
    String cdaSerialised = baosXml.toString("UTF-8");
    assertTrue(cdaSerialised.indexOf("ö")>0); 
  }

}