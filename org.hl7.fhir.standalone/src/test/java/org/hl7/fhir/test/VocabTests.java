package org.hl7.fhir.test;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.*;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.services.renderers.utils.RenderingContext.ITypeParser;
import org.hl7.fhir.services.terminology.ExpansionOptions;
import org.hl7.fhir.services.terminology.ValueSetExpansionOutcome;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class VocabTests {

  public enum TestType {
    Expansion;
  }

  public class TestTypeParser implements ITypeParser {

    @Override
    public Base parseType(String xml, String type) throws FHIRFormatError, IOException, FHIRException {
      return new org.hl7.fhir.model.core.formats.XmlParser(TestingUtilities.getSharedWorkerContext()).parseType(xml, type);
    }

    @Override
    public Base parseType(org.hl7.fhir.services.elementmodel.Element e) throws FHIRFormatError, IOException, FHIRException {
      throw new NotImplementedException(); 
    }
  }

  private static IWorkerContext context;

  public static class TestDetails {
    private String id;
    private Map<String, String> parameters = new HashMap<>();
    private String source;
    private String target;
    private TestType type;


    public TestDetails(Element test) {
      super();
      id = test.getAttribute("id");
      source = XMLUtil.getNamedChildValue(test, "source");
      target = XMLUtil.getNamedChildValue(test, "target");
      type = TestType.Expansion;
    }

    public String getId() {
      return id;
    }

    public Map<String, String> getParameters() {
      return parameters;
    }

    public String getSource() {
      return source;
    }

    public String getTarget() {
      return target;
    }

    public TestType getType() {
      return type;
    }

  }

  public static Stream<Arguments> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {
    Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "vocab", "manifest.xml"));
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
  public static void setUp() throws FHIRException, IOException {
    /* Do NOT get a shared worker context from Testing Utilities or else the terminology package loaded below
       will appear in tests where it causes failures.
     */
    context = TestingUtilities.getSharedWorkerContext(TestingUtilities.DEFAULT_CONTEXT_VERSION);

  }

  @AfterAll
  public static void tearDown() {
    context = null;
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String id, TestDetails test) throws Exception {      
    
    Resource source;
    if (test.getSource().endsWith(".json")) {
      source = (Resource) new JsonParser(TestingUtilities.getSharedWorkerContext()).parse(TestingUtilities.loadTestResourceStream("r5", "vocab", test.getSource()));
    } else {
      source = (Resource) new XmlParser(TestingUtilities.getSharedWorkerContext()).parse(TestingUtilities.loadTestResourceStream("r5", "vocab", test.getSource()));
    }
    
    Resource target;
    if (test.getTarget().endsWith(".json")) {
      target = (Resource) new JsonParser(TestingUtilities.getSharedWorkerContext()).parse(TestingUtilities.loadTestResourceStream("r5", "vocab", test.getTarget()));
    } else {
      target = (Resource) new XmlParser(TestingUtilities.getSharedWorkerContext()).parse(TestingUtilities.loadTestResourceStream("r5", "vocab", test.getTarget()));
    }

    if (test.getType() == TestType.Expansion) {
      testExpansion(test, (ValueSet) source, (ValueSet) target);
    } else {
      Assertions.fail("not done yet");
    }


  }

  private void testExpansion(TestDetails test, ValueSet sourceVS, ValueSet targetVS) throws Exception {
    ValueSetExpansionOutcome outcome = context.expandVS(new ExpansionOptions().withCacheOk(false).withHierarchical(test.getParameters().containsKey("hierarchical")).withIncompleteOk(true), sourceVS);
    if (outcome.isOk()) {
      outcome.getValueset().getExpansion().setIdentifier(null);
      outcome.getValueset().getExpansion().setTimestamp(null);
      String expected = new XmlParser(TestingUtilities.getSharedWorkerContext()).setOutputStyle(OutputStyle.PRETTY).composeString(targetVS);
      String actual = new XmlParser(TestingUtilities.getSharedWorkerContext()).setOutputStyle(OutputStyle.PRETTY).composeString(outcome.getValueset());
      String expectedFileName = CompareUtilities.tempFile("vocab", test.getId() + ".expected.html");
      String actualFileName = CompareUtilities.tempFile("vocab", test.getId() + ".actual.html");
      FileUtilities.stringToFile(expected, expectedFileName);
      FileUtilities.stringToFile(actual, actualFileName);
      String msg = new CompareUtilities().checkXMLIsSame(test.id, expectedFileName, actualFileName);
      Assertions.assertTrue(msg == null, "Output does not match expected: "+msg);
    } else {
      Assertions.fail("Expansion Failed: "+outcome.getError());
    }
  }
  
}