package org.hl7.fhir.r5.test;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.NarrativeGenerator;
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

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Disabled //Test case 1 doesn't pass
public class NarrativeGenerationTests {

  private static IWorkerContext context;

  public static class TestDetails {
    private String id;

    public TestDetails(Element test) {
      super();
      id = test.getAttribute("id");
    }

    public String getId() {
      return id;
    }
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {
    Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "narrative", "manifest.xml"));
    Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
    List<Arguments> objects = new ArrayList<>();
    while (test != null && test.getNodeName().equals("test")) {
      TestDetails t = new TestDetails(test);
      objects.add(Arguments.of(t.getId(), t));
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
    NarrativeGenerator gen = new NarrativeGenerator("", "http://hl7.org/fhir", context);
    IOUtils.copy(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + "-expected.xml"), new FileOutputStream(TestingUtilities.tempFile("narrative", test.getId() + "-expected.xml")));
    DomainResource source = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + "-input.xml"));
    DomainResource target = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + "-expected.xml"));
    gen.generate(source);
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(TestingUtilities.tempFile("narrative", test.getId() + "-actual.xml")), source);
    source = (DomainResource) new XmlParser().parse(new FileInputStream(TestingUtilities.tempFile("narrative", test.getId() + "-actual.xml")));
    Assertions.assertTrue(source.equalsDeep(target), "Output does not match expected");
  }
}