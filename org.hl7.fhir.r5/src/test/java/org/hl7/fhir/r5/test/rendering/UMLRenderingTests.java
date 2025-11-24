package org.hl7.fhir.r5.test.rendering;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.ClassDiagramRenderer;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.StructureDefinitionRendererMode;
import org.hl7.fhir.r5.test.NarrativeGenerationTests.TestProfileKnowledgeProvider;
import org.hl7.fhir.r5.test.NarrativeGenerationTests.TestTypeParser;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.tools.TestCases;
import org.hl7.fhir.r5.tools.TestCases.TestCasesSuiteComponent;
import org.hl7.fhir.r5.tools.TestCases.TestCasesSuiteResourceComponent;
import org.hl7.fhir.r5.tools.TestCases.TestCasesSuiteTestComponent;
import org.hl7.fhir.r5.tools.ToolsRegistration;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.TerminologyServiceOptions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

public class UMLRenderingTests {

  public static Stream<Arguments> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {
    ToolsRegistration.register();
    TestCases tests = (TestCases) new JsonParser().parse(TestingUtilities.loadTestResource("r5", "uml", "manifest.json"));
    List<Arguments> objects = new ArrayList<>();
    for (TestCasesSuiteComponent suite : tests.getSuiteList()) {
      for (TestCasesSuiteTestComponent test : suite.getTestList()) {
        objects.add(Arguments.of(suite.getName()+"/"+test.getName(), test));
      }
    }
    return objects.stream();
  }

  private static IWorkerContext context;
  private static String source;
  private static String dest;
  private static RenderingContext rc;


  @BeforeAll
  public static void setUp() throws IOException {
    context = TestingUtilities.getSharedWorkerContext("5.0.0");
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setShowSummaryTable(true);
    rc.setDefinitionsTarget("test.html");
    rc.setTerminologyServiceOptions(TerminologyServiceOptions.defaults());
    rc.setParser(new TestTypeParser());
    
    // getting timezones correct (well, at least consistent, so tests pass on any computer)
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setDateTimeFormatString("yyyy-MM-dd'T'HH:mm:ssZZZZZ"); 
    rc.setDateFormatString("yyyy-MM-dd"); 
    rc.setMode(ResourceRendererMode.TECHNICAL);
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new TestProfileKnowledgeProvider(rc.getContext())));    
    rc.setStructureMode(StructureDefinitionRendererMode.SUMMARY);
    
    source = Utilities.path("[tmp]", "uml", "source");
    FileUtilities.createDirectory(source);
    dest = Utilities.path("[tmp]", "uml", "dest");
    FileUtilities.createDirectory(dest);
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String id, TestCasesSuiteTestComponent test) throws Exception {
    
    String mode = test.getParameterStr("operation");
    String actual;
    switch (mode) {
    case "class":
      actual = makeClassSvg(test);
      break;
    case "profile":
      actual = makeProfileSvg(test);
      break;
    case "summary":
      actual = makeSummarySvg(test);
      break;
    default:
      throw new FHIRException("unknown operation "+mode);    
    }
    
    String expected = FileUtilities.streamToString(TestingUtilities.loadTestResourceStream("r5", "uml", test.getInput("expected").getFile())); 
    
    String basename = new File(test.getInput("expected").getFile()).getName();
    
    String actualFilename = Utilities.path("[tmp]", "uml", basename);  
    String expectedFilename = Utilities.path("[tmp]", "uml", FileUtilities.changeFileExt(basename, ".expected.svg"));
    FileUtilities.stringToFile(actual, actualFilename);
    FileUtilities.stringToFile(expected, expectedFilename);
    Assertions.assertEquals(expected, actual);
  }

  private String makeClassSvg(TestCasesSuiteTestComponent test) throws FHIRException, IOException {
    StructureDefinition sd = null;
    for (TestCasesSuiteResourceComponent input : test.getInputList()) {
      if ("source".equals(input.getName())) {
        sd = (StructureDefinition) new JsonParser().parse(TestingUtilities.loadTestResource("r5", "uml", input.getFile()));
      } else if ("template".equals(input.getName())) {
        String name = new File(input.getFile()).getName();
        FileUtilities.streamToFile(TestingUtilities.loadTestResourceStream("r5", "uml", input.getFile()), Utilities.path(source, name));
      } else if (!"expected".equals(input.getName())) {
        throw new FHIRException("Unknown input name '"+input.getName()+"'");
      }
    }
    sd.setWebPath("http://test/path/"+sd.getId());
    ClassDiagramRenderer cdr = new ClassDiagramRenderer(source, dest, sd.getId(), null, rc, null);
    return cdr.buildClassDiagram(sd, null);
  }

  private String makeProfileSvg(TestCasesSuiteTestComponent test) throws FHIRFormatError, IOException {
    StructureDefinition sd = null;
    for (TestCasesSuiteResourceComponent input : test.getInputList()) {
      if ("source".equals(input.getName())) {
        sd = (StructureDefinition) new JsonParser().parse(TestingUtilities.loadTestResource("r5", "uml", input.getFile()));
      } else if ("template".equals(input.getName())) {
        String name = new File(input.getFile()).getName();
        FileUtilities.streamToFile(TestingUtilities.loadTestResourceStream("r5", "uml", input.getFile()), Utilities.path(source, name));
      } else if (!"expected".equals(input.getName())) {
        throw new FHIRException("Unknown input name '"+input.getName()+"'");
      }
    }
    sd.setWebPath("http://test/path/"+sd.getId());
    StructureDefinition sdBase = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());

    rc.getProfileUtilities().generateSnapshot(sdBase, sd, sd.getUrl(), "http://hl7.org/fhir/test", sd.getName());
    
    ClassDiagramRenderer cdr = new ClassDiagramRenderer(source, dest, sd.getId(), null, rc, null);
    return cdr.buildConstraintDiagram(sd, null);
  }

  private String makeSummarySvg(TestCasesSuiteTestComponent test) throws Exception {
    JsonObject ctl = null;
    for (TestCasesSuiteResourceComponent input : test.getInputList()) {
      if ("source".equals(input.getName())) {
        StructureDefinition sd = (StructureDefinition) new JsonParser().parse(TestingUtilities.loadTestResource("r5", "uml", input.getFile()));
        sd.setWebPath("http://test/path/"+sd.getId());
        context.getManager().cacheResource(sd);
      } else if ("template".equals(input.getName())) {
        String name = new File(input.getFile()).getName();
        FileUtilities.streamToFile(TestingUtilities.loadTestResourceStream("r5", "uml", input.getFile()), Utilities.path(source, name));
      } else if ("control".equals(input.getName())) {
        ctl = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(TestingUtilities.loadTestResource("r5", "uml", input.getFile()));
      } else if (!"expected".equals(input.getName())) {
        throw new FHIRException("Unknown input name '"+input.getName()+"'");
      }
    }
    ClassDiagramRenderer cdr = new ClassDiagramRenderer(source, dest, ctl.asString("id"), null, rc, null);
    return cdr.buildClassDiagram(ctl);
  }
 
  
}
