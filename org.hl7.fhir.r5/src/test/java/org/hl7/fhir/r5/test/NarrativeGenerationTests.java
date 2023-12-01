package org.hl7.fhir.r5.test;

import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.profile.BindingResolution;
import org.hl7.fhir.r5.conformance.profile.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.ElementWrappers;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ITypeParser;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.StructureDefinitionRendererMode;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestPackageLoader;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.TerminologyServiceOptions;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class NarrativeGenerationTests {

  public class TestProfileKnowledgeProvider implements ProfileKnowledgeProvider {

    private IWorkerContext context;

    public TestProfileKnowledgeProvider(IWorkerContext context) {
      this.context = context;
    }

    @Override
    public boolean isDatatype(String typeSimple) {
      throw new NotImplementedException();      
    }
    @Override
    public boolean isPrimitiveType(String typeSimple) {
      throw new NotImplementedException();      
    }

    @Override
    public boolean isResource(String typeSimple) {
      throw new NotImplementedException();      
    }

    @Override
    public boolean hasLinkFor(String typeSimple) {
      throw new NotImplementedException();      
    }

    @Override
    public String getLinkFor(String corePath, String typeSimple) {
      throw new NotImplementedException();      
    }

    @Override
    public BindingResolution resolveBinding(StructureDefinition def, ElementDefinitionBindingComponent binding, String path) throws FHIRException {
      throw new NotImplementedException();      
    }

    @Override
    public BindingResolution resolveBinding(StructureDefinition def, String url, String path) throws FHIRException {
      ValueSet vs = context.fetchResource(ValueSet.class, url);
      if (vs != null) {
        if (vs.hasWebPath()) {
          return new BindingResolution(vs.present(), vs.getWebPath());
        } else {
          return new BindingResolution(vs.present(), "valueset-"+vs.getIdBase()+".html");
        }
      }
      throw new NotImplementedException();      
    }

    @Override
    public String getLinkForProfile(StructureDefinition profile, String url) {
      if ("http://hl7.org/fhir/StructureDefinition/Composition".equals(url)) {
        return "http://hl7.org/fhir/composition.html|TestComposition";
      }
      throw new NotImplementedException();      
    }

    @Override
    public boolean prependLinks() {
      return false;      
    }

    @Override
    public String getLinkForUrl(String corePath, String s) {
      throw new NotImplementedException();      
    }

  }

  public class TestTypeParser implements ITypeParser {

    @Override
    public Base parseType(String xml, String type) throws FHIRFormatError, IOException, FHIRException {
      return new org.hl7.fhir.r5.formats.XmlParser().parseType(xml, type); 
    }
    @Override
    public Base parseType(org.hl7.fhir.r5.elementmodel.Element e) throws FHIRFormatError, IOException, FHIRException {
      throw new NotImplementedException(); 
    }
  }

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
    private String sdmode;
    private boolean header;
    private boolean pretty;
    private boolean meta;
    private boolean technical;
    private String register;

    public TestDetails(Element test) {
      super();
      id = test.getAttribute("id");
      sdmode = test.getAttribute("sdmode");
      if ("".equals(sdmode)) {
        sdmode = null;
      }
      register = test.getAttribute("register");
      if ("".equals(register)) {
        register = null;
      }
      header = "true".equals(test.getAttribute("header"));
      pretty = !"false".equals(test.getAttribute("pretty"));
      meta = "true".equals(test.getAttribute("meta"));
      technical = "technical".equals(test.getAttribute("mode"));
    }

    public String getId() {
      return id;
    }

    public String getSDMode() {
      return sdmode;
    }

    public boolean isHeader() {
      return header;
    }

    public boolean isMeta() {
      return meta;
    }

    public String getRegister() {
      return register;
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
  public static void setUp() throws IOException {
    context = TestingUtilities.getSharedWorkerContext("5.0.0");
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.FilesystemPackageCacheManagerBuilder().build();
    NpmPackage ips = pcm.loadPackage("hl7.fhir.uv.ips#1.1.0");
    context.loadFromPackage(ips,  new TestPackageLoader(Utilities.strings("StructureDefinition", "ValueSet" )));
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String id, TestDetails test) throws Exception {
    if (test.getRegister() != null) {
      if (test.getRegister().endsWith(".json")) {
        context.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getRegister())));
      } else {
        context.cacheResource(new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getRegister())));
      }
    }
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setHeader(test.isHeader());
    rc.setDefinitionsTarget("test.html");
    rc.setTerminologyServiceOptions(TerminologyServiceOptions.defaults());
    rc.setParser(new TestTypeParser());
    
    // getting timezones correct (well, at least consistent, so tests pass on any computer)
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setDateTimeFormatString("yyyy-MM-dd'T'HH:mm:ssZZZZZ"); 
    rc.setDateFormatString("yyyy-MM-dd"); 
    rc.setMode(test.technical ? ResourceRendererMode.TECHNICAL : ResourceRendererMode.END_USER);
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new TestProfileKnowledgeProvider(rc.getContext())));
        
    if (test.getSDMode() != null) {
      rc.setStructureMode(StructureDefinitionRendererMode.valueOf(test.getSDMode().toUpperCase()));
    }
    
    Resource source;
    if (TestingUtilities.findTestResource("r5", "narrative", test.getId() + ".json")) {
      source = (Resource) new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + ".json"));
    } else  if (TestingUtilities.findTestResource("r5", "narrative", test.getId() + ".fml")) {
      source = (Resource) new StructureMapUtilities(context).parse(TextFile.streamToString(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + ".fml")), "source");
    } else {
      source = (Resource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + ".xml"));      
    }
    
    XhtmlNode x = RendererFactory.factory(source, rc).build(source);
    String expected = TextFile.streamToString(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + ".html"));
    String actual = HEADER+new XhtmlComposer(true, test.pretty).compose(x)+FOOTER;
    String expectedFileName = CompareUtilities.tempFile("narrative", test.getId() + ".expected.html");
    String actualFileName = CompareUtilities.tempFile("narrative", test.getId() + ".actual.html");
    TextFile.stringToFile(expected, expectedFileName);
    TextFile.stringToFile(actual, actualFileName);
    String msg = CompareUtilities.checkXMLIsSame(expectedFileName, actualFileName);
    Assertions.assertTrue(msg == null, "Output does not match expected: "+msg);
    
    if (test.isMeta()) {
      org.hl7.fhir.r5.elementmodel.Element e = Manager.parseSingle(context, TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + ".xml"), FhirFormat.XML); 
      x = RendererFactory.factory(source, rc).render(new ElementWrappers.ResourceWrapperMetaElement(rc, e));

      expected = TextFile.streamToString(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId() + "-meta.html"));
      actual = HEADER+new XhtmlComposer(true, true).compose(x)+FOOTER;
      actualFileName = CompareUtilities.tempFile("narrative", test.getId() + "-meta.actual.html");
      TextFile.stringToFile(actual, actualFileName);
      msg = CompareUtilities.checkXMLIsSame(expectedFileName, actualFileName);
      Assertions.assertTrue(msg == null, "Meta output does not match expected: "+msg);
    }
  }
  
}