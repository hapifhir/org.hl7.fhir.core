package org.hl7.fhir.r4b.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.TimeZone;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.DateTimeType;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.renderers.DataRenderer;
import org.hl7.fhir.r4b.renderers.RendererFactory;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r4b.test.utils.TestingUtilities;
import org.hl7.fhir.r4b.utils.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xmlpull.v1.XmlPullParserException;

public class NarrativeGeneratorTests {

  private static RenderingContext rc;

  @BeforeAll
  public static void setUp() throws FHIRException {
    rc = new RenderingContext(TestingUtilities.context(), null, null, "http://hl7.org/fhir", "", null,
        ResourceRendererMode.END_USER);
  }

  @Test
  public void test()
      throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    process(TestingUtilities.loadTestResourceStream("r5", "questionnaireresponse-example-f201-lifelines.xml"));
  }

  private void process(InputStream stream)
      throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
    XmlParser p = new XmlParser();
    DomainResource r = (DomainResource) p.parse(stream);
    RendererFactory.factory(r, rc).render(r);
    FileOutputStream s = new FileOutputStream(TestingUtilities.tempFile("gen", "gen.xml"));
    new XmlParser().compose(s, r, true);
    s.close();
  }

  private void checkDateTimeRendering(String src, String lang, String country, ZoneId tz, String fmt,
      ResourceRendererMode mode, String... expected) throws FHIRFormatError, DefinitionException, IOException {
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
    String actual = new DataRenderer(rc).display(dt);

    assertTrue(Utilities.existsInList(actual, expected),
        "Actual = " + actual + ", expected one of " + Utilities.toString(expected));
    XhtmlNode node = new XhtmlNode(NodeType.Element, "p");
    new DataRenderer(rc).render(node, dt);
    actual = new XhtmlComposer(true, false).compose(node);
    assertTrue(actual.startsWith("<p>"));
    assertTrue(actual.endsWith("</p>"));
    assertTrue(Utilities.existsInList(actual.substring(0, actual.length() - 4).substring(3), expected),
        "Actual = " + actual + ", expected one of " + Utilities.toString(expected));
  }

  @Test
  public void testDateTimeRendering1() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19T14:13:12Z", "en", "AU", ZoneId.of("UTC"), null, ResourceRendererMode.TECHNICAL,
        "2021-11-19T14:13:12Z");
  }

  @Test
  public void testDateTimeRendering2() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19T14:13:12Z", "en", "AU", ZoneId.of("Australia/Sydney"), null,
        ResourceRendererMode.TECHNICAL, "2021-11-20T01:13:12+11:00");
  }

  @Test
  public void testDateTimeRendering3() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19T14:13:12Z", "en", "AU", ZoneId.of("UTC"), "yyyy/MM/dd hh:mm:ss",
        ResourceRendererMode.TECHNICAL, "2021/11/19 02:13:12");
  }

  @Test // varies between versions, so multiple possible expected
  public void testDateTimeRendering4() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19T14:13:12Z", "en", "AU", ZoneId.of("UTC"), null, ResourceRendererMode.END_USER,
        "19/11/21, 2:13 pm", "19/11/21 2:13 PM");
  }

  @Test
  public void testDateTimeRendering5() throws FHIRFormatError, DefinitionException, IOException {
    checkDateTimeRendering("2021-11-19", "en", "AU", ZoneId.of("UTC"), null, ResourceRendererMode.END_USER, "19/11/21");
  }

}