package org.hl7.fhir.test;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.services.conformance.profile.BindingResolution;
import org.hl7.fhir.services.conformance.profile.ProfileKnowledgeProvider;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.*;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.services.fml.StructureMapTools;
import org.hl7.fhir.services.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.services.renderers.RendererFactory;
import org.hl7.fhir.services.renderers.StructureDefinitionRenderer;
import org.hl7.fhir.services.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.services.renderers.utils.RenderingContext.ITypeParser;
import org.hl7.fhir.services.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.services.renderers.utils.RenderingContext.StructureDefinitionRendererMode;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.services.client.TerminologyClientR6;
import org.hl7.fhir.standalone.testing.TestPackageLoader;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.TerminologyServiceOptions;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class NarrativeGenerationTests {

  public static class TestProfileKnowledgeProvider implements ProfileKnowledgeProvider {

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
      return false;
    }

    @Override
    public String getLinkFor(String corePath, String typeSimple) {
      return "http://test/link";     
    }

    @Override
    public BindingResolution resolveBinding(StructureDefinition def, ElementDefinitionBindingComponent binding, String path) throws FHIRException {
      return new BindingResolution("test", "http://test");      
    }

    @Override
    public BindingResolution resolveBinding(StructureDefinition def, String url, String path, org.hl7.fhir.model.core.Element ctxt) throws FHIRException {
      ValueSet vs = context.fetchResource(ValueSet.class, url, ExtensionUtilities.getVersionResolutionRules(ctxt));
      if (vs != null) {
        if (vs.hasWebPath()) {
          return new BindingResolution(vs.present(), vs.getWebPath());
        } else {
          return new BindingResolution(vs.present(), "valueset-"+vs.getIdBase()+".html");
        }
      }
      return new BindingResolution("test", "http://test/ns");    
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
      return "http://test/link/url";    
    }

    @Override
    public String getCanonicalForDefaultContext() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public String getDefinitionsName(Resource r) {
      // TODO Auto-generated method stub
      return null;
    }

  }

  public static class TestTypeParser implements ITypeParser {

    @Override
    public Base parseType(String xml, String type) throws FHIRFormatError, IOException, FHIRException {
      return new org.hl7.fhir.model.core.formats.XmlParser(TestingUtilities.getSharedWorkerContext().getModelContext()).parseType(xml, type);
    }
    @Override
    public Base parseType(org.hl7.fhir.services.elementmodel.Element e) throws FHIRFormatError, IOException, FHIRException {
      throw new NotImplementedException(); 
    }
  }

  public static final String WINDOWS = "WINDOWS";

  private static final String HEADER = "<html lang=\"en\"><head>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/fhir.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/dist/css/bootstrap.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/assets/css/bootstrap-fhir.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/assets/css/project.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/assets/css/pygments-manni.css\"/>"+
     "<link rel=\"stylesheet\" href=\"http://hl7.org/fhir/fhir.css\"/>"+
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
    private boolean track;
    private String register;
    private String prefix;
    private List<String> sdViews = new ArrayList<>();

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
      prefix = test.getAttribute("prefix");
      if ("".equals(prefix)) {
        prefix = null;
      }
      header = "true".equals(test.getAttribute("header"));
      track = "true".equals(test.getAttribute("track"));
      pretty = !"false".equals(test.getAttribute("pretty"));
      meta = "true".equals(test.getAttribute("meta"));
      technical = "technical".equals(test.getAttribute("mode"));
      String views = test.getAttribute("sdviews");
      if (!Utilities.noString(views)) {
        for (String v : views.split(",")) {
          sdViews.add(v.trim());
        }
      }
    }

    public List<String> getSdViews() {
      return sdViews;
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

    public boolean isTrack() {
      return track;
    } 
    
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {
    Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r6", "narrative", "manifest.xml"));
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
  static void setUp() throws IOException {
    var simpleContext = TestingUtilities.getSharedWorkerContext("6.0.0-snapshot1");
    simpleContext.connectToTSServer(new TerminologyClientR6.TerminologyClientR6Factory(), "https://tx-dev.fhir.org", "Instance-Generator", Utilities.path("[tmp]", "tx-log.html"), true);
    context = simpleContext;
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    NpmPackage ips = pcm.loadPackage("hl7.fhir.uv.ips#1.1.0");
    context.getManager().loadFromPackage(ips,  new TestPackageLoader(Utilities.stringSet("StructureDefinition", "ValueSet" ), TestingUtilities.getSharedWorkerContext()));
  }
  @AfterAll
  static void tearDown() {
    context = null;
  }


  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String id, TestDetails test) throws Exception {
    XhtmlNode.setCheckParaGeneral(true);
    if (test.getRegister() != null) {
      if (test.getRegister().endsWith(".json")) {
        context.getManager().cacheResource(new JsonParser(TestingUtilities.getSharedWorkerContext().getModelContext()).parse(TestingUtilities.loadTestResourceStream("r6", "narrative", test.getRegister())));
      } else {
        context.getManager().cacheResource(new XmlParser(TestingUtilities.getSharedWorkerContext().getModelContext()).parse(TestingUtilities.loadTestResourceStream("r6", "narrative", test.getRegister())));
      }
    }
    RenderingContext rc = new RenderingContext(context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative6"));
    rc.setShowSummaryTable(test.isHeader());
    rc.setTrackNarrativeSource(test.isTrack());
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
        
    rc.setTesting(true);
    
    if (test.getSDMode() != null) {
      rc.setStructureMode(StructureDefinitionRendererMode.valueOf(test.getSDMode().toUpperCase()));
    }
    if (test.prefix != null) {
      rc.setUniqueLocalPrefix(test.prefix);
    }
    
    Resource source;
    if (TestingUtilities.findTestResource("r6", "narrative", test.getId() + ".json")) {
      source = (Resource) new JsonParser(TestingUtilities.getSharedWorkerContext().getModelContext()).parse(TestingUtilities.loadTestResourceStream("r6", "narrative", test.getId() + ".json"));
    } else  if (TestingUtilities.findTestResource("r6", "narrative", test.getId() + ".fml")) {
      source = (Resource) new StructureMapTools(context).parse(FileUtilities.streamToString(TestingUtilities.loadTestResourceStream("r6", "narrative", test.getId() + ".fml")), "source");
    } else {
      source = (Resource) new XmlParser(TestingUtilities.getSharedWorkerContext().getModelContext()).parse(TestingUtilities.loadTestResourceStream("r6", "narrative", test.getId() + ".xml"));
    }
    
    XhtmlNode x = new RendererFactory().factory(source, rc).buildNarrative(ResourceWrapper.forResource(rc.getContextUtilities(), source));
    String expected = FileUtilities.streamToString(TestingUtilities.loadTestResourceStream("r6", "narrative", "output", test.getId() + ".html"));
    String actual = HEADER+new XhtmlComposer(true, test.pretty).compose(x)+FOOTER;
    String expectedFileName = CompareUtilities.tempFile("narrative6", test.getId() + ".expected.html");
    String actualFileName = CompareUtilities.tempFile("narrative6", test.getId() + ".html");
    FileUtilities.stringToFile(expected, expectedFileName);
    FileUtilities.stringToFile(actual, actualFileName);
    String msg = new CompareUtilities().checkXMLIsSame(id, expectedFileName, actualFileName);
    Assertions.assertTrue(msg == null, "Output does not match expected: "+msg);

    String disp = new RendererFactory().factory(source, rc).buildSummary(ResourceWrapper.forResource(rc.getContextUtilities(), source));
    expected = FileUtilities.streamToString(TestingUtilities.loadTestResourceStream("r6", "narrative", "output", test.getId() + ".txt"));
    actual = disp;
    expectedFileName = CompareUtilities.tempFile("narrative6", test.getId() + ".expected.txt");
    actualFileName = CompareUtilities.tempFile("narrative6", test.getId() + ".txt");
    FileUtilities.stringToFile(expected, expectedFileName);
    FileUtilities.stringToFile(actual, actualFileName);
    msg = new CompareUtilities().checkTextIsSame(id, expected, actual);
    Assertions.assertTrue(msg == null, "Summary Output does not match expected: "+msg);

    for (String view : test.getSdViews()) {
      checkStructureDefinitionView(id, test, (StructureDefinition) source, view, rc);
    }
    
    //    
//    if (test.isMeta()) {
//      org.hl7.fhir.services.elementmodel.Element e = Manager.parseSingle(context, TestingUtilities.loadTestResourceStream("r6", "narrative", test.getId() + ".xml"), FhirFormat.XML); 
//      x = RendererFactory.factory(source, rc).build(ResourceElement.forResource(rc.getContextUtilities(), rc.getProfileUtilities(), e));
//
//      expected = FileUtilities.streamToString(TestingUtilities.loadTestResourceStream("r6", "narrative", "output", test.getId() + "-meta.html"));
//      actual = HEADER+new XhtmlComposer(true, true).compose(x)+FOOTER;
//      actualFileName = CompareUtilities.tempFile("narrative6", test.getId() + "-meta.actual.html");
//      FileUtilities.stringToFile(actual, actualFileName);
//      msg = CompareUtilities.checkXMLIsSame(id, expectedFileName, actualFileName);
//      Assertions.assertTrue(msg == null, "Meta output does not match expected: "+msg);
//    }
  }

  @ParameterizedTest(name = "{0}, regenerate snapshot: {1}")
  @CsvSource({"SUMMARY, false", "DATA_DICT, false", "SUMMARY, true", "DATA_DICT, true"})
  void rendersContentReferenceProfileOnSparseDifferential(StructureDefinitionRendererMode mode, boolean regenerateSnapshot, @TempDir Path outputDirectory) throws Exception {
    RenderingContext rc = new RenderingContext(context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(outputDirectory.toString());
    rc.setDefinitionsTarget("test.html");
    rc.setProfileUtilities(new ProfileUtilities(context, null, new TestProfileKnowledgeProvider(context)));
    rc.setLocale(java.util.Locale.ENGLISH);
    rc.setStructureMode(mode);
    rc.setTesting(true);

    StructureDefinition sd = (StructureDefinition) new JsonParser(context.getModelContext()).parse(
      TestingUtilities.loadTestResourceStream("r6", "narrative", "sd-content-ref-profile.json"));
    ElementDefinition differentialElement = sd.getDifferential().getElementList().stream()
      .filter(e -> "Composition.section.section".equals(e.getId())).findFirst().orElseThrow();
    // The differential inherits its type; a loaded snapshot also lacks in-memory derivation pointers.
    differentialElement.getTypeList().clear();
    if (regenerateSnapshot) {
      sd.setSnapshot(null);
      rc.getProfileUtilities().generateSnapshot(context.fetchTypeDefinition("Composition"), sd, sd.getUrl(), "http://example.org/fhir", sd.getName());
    }
    Assertions.assertFalse(differentialElement.hasType());
    Assertions.assertTrue(sd.getSnapshot().getElementById("Composition.section.section").hasType());

    String html = new XhtmlComposer(true).compose(new StructureDefinitionRenderer(rc).buildNarrative(
      ResourceWrapper.forResource(rc.getContextUtilities(), sd)));
    Assertions.assertTrue(html.contains("profiled by"), "The sparse differential must display the additional profile constraints");
    Assertions.assertTrue(html.contains("href=\"#Composition.section\""), "The annotation must link to the referenced element");
    Assertions.assertTrue(html.contains("title=\"" + sd.getUrl() + "#Composition.section\""));
  }

  /**
   * The narrative for a StructureDefinition only contains the differential table. The IG publisher
   * also renders the snapshot and must-support views, which go down different paths (snapshot = true,
   * mustSupportOnly = true, a filtered element list), and the detailed view (data dictionary) of the snapshot.
   * sdviews="snapshot,ms,dict" renders those too, each
   * compared against output/[id]-[view].html
   */
  private void checkStructureDefinitionView(String id, TestDetails test, StructureDefinition sd, String view, RenderingContext rc) throws Exception {
    StructureDefinitionRenderer sdr = new StructureDefinitionRenderer(rc);
    ResourceWrapper res = ResourceWrapper.forResource(rc.getContextUtilities(), sd);
    String corePath = rc.getLink(KnownLinkType.SPEC, false);
    boolean logical = sd.getKind() == StructureDefinition.StructureDefinitionKind.LOGICAL;
    XhtmlNode x;
    switch (view) {
    case "snapshot":
      x = sdr.generateTable(new RenderingStatus(), rc.getDefinitionsTarget(), sd, false, rc.getDestDir(), false, sd.getId(), true, corePath, "", logical, true, null, false, rc.withUniqueLocalPrefix("s"), "s", res, "S");
      break;
    case "ms":
      StructureDefinition msd = sd.copy(Base.COPY_DATA);
      msd.getSnapshot().setElementList(new MustSupportFilter(sd).getMustSupportElements());
      x = sdr.generateTable(new RenderingStatus(), rc.getDefinitionsTarget(), msd, false, rc.getDestDir(), false, msd.getId(), true, corePath, "", logical, false, null, true, rc.withUniqueLocalPrefix("m"), "m", res, "M");
      break;
    case "dict":
      x = new XhtmlNode(NodeType.Element, "div");
      sdr.renderDict(new RenderingStatus(), sd, sd.getSnapshot().getElementList(), x.table("dict", false), false, StructureDefinitionRenderer.GEN_MODE_SNAP, "", res);
      break;
    default:
      throw new Error("Unknown sdview '"+view+"' in test "+id);
    }
    String expected = FileUtilities.streamToString(TestingUtilities.loadTestResourceStream("r6", "narrative", "output", test.getId() + "-" + view + ".html"));
    String actual = HEADER+new XhtmlComposer(true, test.pretty).compose(x)+FOOTER;
    String expectedFileName = CompareUtilities.tempFile("narrative6", test.getId() + "-" + view + ".expected.html");
    String actualFileName = CompareUtilities.tempFile("narrative6", test.getId() + "-" + view + ".html");
    FileUtilities.stringToFile(expected, expectedFileName);
    FileUtilities.stringToFile(actual, actualFileName);
    String msg = new CompareUtilities().checkXMLIsSame(id, expectedFileName, actualFileName);
    Assertions.assertTrue(msg == null, "Output for view '"+view+"' does not match expected: "+msg);
  }

  /**
   * Builds the element list for the must-support view the same way the IG publisher does
   * (igtools StructureDefinitionRenderer.getMustSupportElements): must-support elements plus
   * their ancestors, with must-support inherited from the slicer, ancestors made opaque.
   */
  private static class MustSupportFilter {
    private final StructureDefinition sd;
    private final Map<String, ElementDefinition> snapshotById = new HashMap<>();

    MustSupportFilter(StructureDefinition sd) {
      this.sd = sd;
      for (ElementDefinition t : sd.getSnapshot().getElementList()) {
        if (t.hasId()) {
          snapshotById.put(t.getId(), t);
        }
      }
    }

    List<ElementDefinition> getMustSupportElements() {
      Map<String, ElementDefinition> mustSupport = new HashMap<>();
      scan(mustSupport, sd.getSnapshot().getElementList(), sd.getSnapshot().getElementFirstRep(), new ArrayList<>());
      List<ElementDefinition> res = new ArrayList<>();
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
        if (mustSupport.containsKey(ed.getId())) {
          ElementDefinition edCopy = ed.copy(Base.COPY_DATA);
          edCopy.copyUserData(ed);
          if (edCopy.hasExample()) {
            edCopy.getExampleList().clear();
          }
          if (!isMustSupport(ed)) {
            if (edCopy.getPath().contains(".")) {
              edCopy.setUserData(UserDataNames.render_opaque, true);
            }
            edCopy.setBinding(null);
            edCopy.getConstraintList().clear();
          }
          edCopy.setMustSupport(false);
          res.add(edCopy);
        }
      }
      return res;
    }

    private boolean isMustSupport(ElementDefinition ed) {
      if (ed.hasMustSupport() && ed.getMustSupport()) {
        return true;
      }
      if (!ed.hasId() || !ed.getId().contains(":")) {
        return false;
      }
      String[] parts = ed.getId().split("\\.");
      for (int i = parts.length - 1; i >= 0; i--) {
        if (parts[i].contains(":")) {
          String[] np = parts.clone();
          np[i] = np[i].substring(0, np[i].indexOf(":"));
          ElementDefinition sed = snapshotById.get(String.join(".", np));
          if (sed != null && sed != ed && isMustSupport(sed)) {
            return true;
          }
        }
      }
      return false;
    }

    private void scan(Map<String, ElementDefinition> mustSupport, List<ElementDefinition> elements, ElementDefinition element, List<ElementDefinition> parents) {
      if (parents.isEmpty() || isMustSupport(element)) {
        mustSupport.put(element.getId(), element);
        for (ElementDefinition parent : parents) {
          mustSupport.put(parent.getId(), parent);
        }
      }
      for (ElementDefinition child : getChildren(elements, element)) {
        List<ElementDefinition> np = new ArrayList<>(parents);
        np.add(element);
        scan(mustSupport, elements, child, np);
      }
    }

    private List<ElementDefinition> getChildren(List<ElementDefinition> elements, ElementDefinition elem) {
      List<ElementDefinition> res = new ArrayList<>();
      for (int i = elements.indexOf(elem) + 1; i < elements.size(); i++) {
        String tgt = elements.get(i).getPath();
        if (!tgt.startsWith(elem.getPath() + ".")) {
          break;
        }
        if (!tgt.substring(elem.getPath().length() + 1).contains(".")) {
          res.add(elements.get(i));
        }
      }
      return res;
    }
  }
  
}