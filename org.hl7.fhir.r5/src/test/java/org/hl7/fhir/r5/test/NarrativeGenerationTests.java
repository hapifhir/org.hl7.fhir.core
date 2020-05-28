package org.hl7.fhir.r5.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.QuestionnaireRendererMode;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TerminologyServiceOptions;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class NarrativeGenerationTests {

  public static final String WINDOWS = "WINDOWS";

  private static final String HEADER = "<html><head>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/fhir.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/dist/css/bootstrap.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/assets/css/bootstrap-fhir.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/assets/css/project.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/assets/css/pygments-manni.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/jquery-ui.css\"/>"+
     "</head><body>\r\n<div id=\"segment-content\" class=\"segment\"><div class=\"container\"><div class=\"row\"><div class=\"inner-wrapper\"><div class=\"col-12\">\r\n<p>Narrative</p>";
  private static final String FOOTER = "\r\n</div></div></div></div></div></body></html>";
  
  private static IWorkerContext context;

  public static class TestDetails {
    private String id;
    private boolean header;

    public TestDetails(Element test) {
      super();
      id = test.getAttribute("id");
      header = "true".equals(test.getAttribute("header"));
    }

    public String getId() {
      return id;
    }

    public boolean isHeader() {
      return header;
    } 
    
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {
    Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "narrative", "manifest.xml"));
    Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
    List<Arguments> objects = new ArrayList<>();
    while (test != null && test.getNodeName().equals("test")) {
      TestDetails t = new TestDetails(test);
      if (t.getId().equals("sdc")) {
        if (SystemUtils.OS_NAME.contains(WINDOWS)) {
          objects.add(Arguments.of(t.getId(), t));
        } else {
          System.out.println("sdc test not being adding because the current OS will not pass the test...");
        }
      } else {
        objects.add(Arguments.of(t.getId(), t));
      }
      test = XMLUtil.getNextSibling(test);
    }
    return objects.stream();
  }

  @BeforeAll
  public static void setUp() {
    context = TestingUtilities.context();
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String id, TestDetails test) throws Exception {
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", null, ResourceRendererMode.RESOURCE);
    rc.setDestDir("C:\\work\\org.hl7.fhir\\packages\\packages\\hl7.fhir.pubpack\\package\\other\\");
    rc.setHeader(test.isHeader());
    rc.setDefinitionsTarget("test.html");
    rc.setTerminologyServiceOptions(TerminologyServiceOptions.defaults());
    IOUtils.copy(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + "-expected.xml"), new FileOutputStream(TestingUtilities.tempFile("narrative", test.getId() + "-expected.xml")));
    DomainResource source = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + "-input.xml"));
    DomainResource target = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + "-expected.xml"));
    RendererFactory.factory(source, rc).render(source);
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(TestingUtilities.tempFile("narrative", test.getId() + "-actual.xml")), source);
    source = (DomainResource) new XmlParser().parse(new FileInputStream(TestingUtilities.tempFile("narrative", test.getId() + "-actual.xml")));
    String html = HEADER+new XhtmlComposer(true).compose(source.getText().getDiv())+FOOTER;
    TextFile.stringToFile(html, TestingUtilities.tempFile("narrative", test.getId() + ".html"));
    Assertions.assertTrue(source.equalsDeep(target), "Output does not match expected");
  }
}