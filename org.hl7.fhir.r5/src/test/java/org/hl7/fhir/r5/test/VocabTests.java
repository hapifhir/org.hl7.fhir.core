package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.TestPackageLoader;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ITypeParser;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class VocabTests {

  public enum TestType {
    Expansion;
  }

  public class TestTypeParser implements ITypeParser {

    @Override
    public Base parseType(String xml, String type) throws FHIRFormatError, IOException, FHIRException {
      return new org.hl7.fhir.r5.formats.XmlParser().parseType(xml, type); 
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
    context = TestingUtilities.getWorkerContext(VersionUtilities.getMajMin(TestingUtilities.DEFAULT_CONTEXT_VERSION));
    if (!context.hasPackage("hl7.terminology", null)) {
  
      NpmPackage utg = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION).loadPackage("hl7.terminology");
      System.out.println("Loading THO: "+utg.name()+"#"+utg.version());
      context.loadFromPackage(utg, new TestPackageLoader(new String[]{"CodeSystem", "ValueSet"}));
    }
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String id, TestDetails test) throws Exception {      
    
    Resource source;
    if (test.getSource().endsWith(".json")) {
      source = (Resource) new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "vocab", test.getSource()));
    } else {
      source = (Resource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "vocab", test.getSource()));      
    }
    
    Resource target;
    if (test.getTarget().endsWith(".json")) {
      target = (Resource) new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "vocab", test.getTarget()));
    } else {
      target = (Resource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "vocab", test.getTarget()));      
    }

    if (test.getType() == TestType.Expansion) {
      testExpansion(test, (ValueSet) source, (ValueSet) target);
    } else {
      Assertions.fail("not done yet");
    }


  }

  private void testExpansion(TestDetails test, ValueSet sourceVS, ValueSet targetVS) throws Exception {
    ValueSetExpansionOutcome outcome = context.expandVS(sourceVS, false, test.getParameters().containsKey("hierarchical"));  
    if (outcome.isOk()) {
      outcome.getValueset().getExpansion().setIdentifier(null);
      outcome.getValueset().getExpansion().setTimestamp(null);
      String target = new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeString(targetVS);
      String output = new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeString(outcome.getValueset());
      String tfn = TestingUtilities.tempFile("vocab", test.getId() + ".target.html");
      String ofn = TestingUtilities.tempFile("vocab", test.getId() + ".output.html");
      TextFile.stringToFile(target, tfn);
      TextFile.stringToFile(output, ofn);
      String msg = TestingUtilities.checkXMLIsSame(ofn, tfn);
      Assertions.assertTrue(msg == null, "Output does not match expected: "+msg);
    } else {
      Assertions.fail("Expansion Failed: "+outcome.getError());
    }
  }
  
}