package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.renderers.DataRenderer;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xmlpull.v1.XmlPullParserException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NarrativeGeneratorTests {

  private static RenderingContext rc;

  @BeforeAll
  public static void setUp() throws FHIRException, IOException {
    rc = new RenderingContext(TestingUtilities.getSharedWorkerContext(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]"));
  }

  @Test
  void test() {
    assertDoesNotThrow(() -> {
      process(TestingUtilities.loadTestResourceStream("r5", "questionnaireresponse-example-f201-lifelines.xml"));
    });
  }

  private void process(InputStream stream) throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    XmlParser p = new XmlParser();
    DomainResource r = (DomainResource) p.parse(stream);
    RendererFactory.factory(r, rc).renderResource(ResourceWrapper.forResource(rc.getContextUtilities(), r));
    FileOutputStream s = ManagedFileAccess.outStream(TestingUtilities.tempFile("gen", "gen.xml"));
    new XmlParser().compose(s, r, true);
    s.close();
  }
  

  private void checkDateTimeRendering(String src, String lang, String country, ZoneId tz, String fmt, ResourceRendererMode mode, 
      String... expected) throws FHIRFormatError, DefinitionException, IOException {
    rc.setLocale(new java.util.Locale(lang, country));
    rc.setTimeZoneId(tz);
    if (fmt == null) {
      rc.setDateTimeFormat(null);
      rc.setDateFormat(null);
    } else {
      // really, it would be better to test patterns based on FormatStyle here, since 
      // that's what will be used in the real world, but 
      rc.setDateTimeFormat(DateTimeFormatter.ofPattern(fmt));
      rc.setDateFormat(DateTimeFormatter.ofPattern(fmt));
    }
    rc.setMode(mode);
    
    DateTimeType dt = new DateTimeType(src);
    String actual = new DataRenderer(rc).displayDataType(ResourceWrapper.forType(rc.getContextUtilities(), dt));
    
    Assert.assertTrue("Actual = "+actual+", expected one of "+Utilities.toString(expected), Utilities.existsInList(Utilities.normalize(actual, false), expected));
    XhtmlNode node = new XhtmlNode(NodeType.Element, "p");
    new DataRenderer(rc).renderDataType(new RenderingStatus(), node, ResourceWrapper.forType(rc.getContextUtilities(), dt));
    actual = new XhtmlComposer(true, false).compose(node); 
    Assert.assertTrue(actual.startsWith("<p>"));
    Assert.assertTrue(actual.endsWith("</p>"));
    Assert.assertTrue("Actual = "+actual+", expected one of "+Utilities.toString(expected), Utilities.existsInList(Utilities.normalize(actual.substring(0, actual.length()-4), false).substring(3), expected));
}
  
  @Test
  public void testDateTimeRendering1() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19T14:13:12Z", "en", "AU", ZoneId.of("UTC"), null, ResourceRendererMode.TECHNICAL, "2021-11-19T14:13:12Z");   
  }
  

  @Test
  public void testDateTimeRendering2() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19T14:13:12Z", "en", "AU", ZoneId.of("Australia/Sydney"), null, ResourceRendererMode.TECHNICAL, "2021-11-20T01:13:12+11:00");   
  }
  
  @Test
  public void testDateTimeRendering3() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19T14:13:12Z", "en", "AU", ZoneId.of("UTC"), "yyyy/MM/dd hh:mm:ss", ResourceRendererMode.TECHNICAL, "2021/11/19 02:13:12");
  }
  
  @Test // varies between versions, so multiple possible expected
  public void testDateTimeRendering4() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19T14:13:12Z", "en", "AU", ZoneId.of("UTC"), null, ResourceRendererMode.END_USER, "19/11/21, 2:13 pm", "19/11/21 2:13 PM");
  }
  

  @Test
  public void testDateTimeRendering5() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19", "en", "AU", ZoneId.of("UTC"), null, ResourceRendererMode.END_USER, "19/11/21");
  }
    

}