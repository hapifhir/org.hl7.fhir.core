package org.hl7.fhir.r5.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;

import org.hl7.fhir.r5.conformance.profile.BindingResolution;
import org.hl7.fhir.r5.conformance.profile.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.AllowUnknownProfile;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.test.utils.TestPackageLoader;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class SnapShotGenerationTests {
  
  public enum TestFetchMode {
    INPUT,
    OUTPUT,
    INCLUDE
  }

  public static class Rule {
    private String description;
    private String expression;

    public Rule(String description, String expression) {
      super();
      this.description = description;
      this.expression = expression;
    }

    public Rule(Element rule) {
      super();
      this.description = rule.getAttribute("text");
      this.expression = rule.getAttribute("fhirpath");
    }

    public String getDescription() {
      return description;
    }

    public String getExpression() {
      return expression;
    }

  }

  public static class TestDetails {
    private String id;
    private String include;
    private String register;
    private String regex;
    private boolean gen;
    private boolean sort;
    private boolean fail;
    private boolean newSliceProcessing;
    private boolean debug;

    private List<Rule> rules = new ArrayList<>();
    private StructureDefinition source;
    private List<StructureDefinition> included = new ArrayList<>();
    private StructureDefinition expected;
    private StructureDefinition output;
    public AllowUnknownProfile allow;

    public TestDetails(Element test) {
      super();
      gen = "true".equals(test.getAttribute("gen"));
      sort = "true".equals(test.getAttribute("sort"));
      fail = "true".equals(test.getAttribute("fail"));
      newSliceProcessing = !"false".equals(test.getAttribute("new-slice-processing"));
      debug = "true".equals(test.getAttribute("debug"));

      id = test.getAttribute("id");
      include = test.getAttribute("include");
      register = test.getAttribute("register");
      regex = test.getAttribute("regex");
      Element rule = XMLUtil.getFirstChild(test);
      while (rule != null && rule.getNodeName().equals("rule")) {
        rules.add(new Rule(rule));
        rule = XMLUtil.getNextSibling(rule);
      }
      String aa = test.getAttribute("allow");
      if (Utilities.noString(aa)) {
        allow = AllowUnknownProfile.ALL_TYPES;
      } else if ("no-extensions".equals(aa)) {
        allow = AllowUnknownProfile.NON_EXTNEIONS;
      } else if ("none".equals(aa)) {
        allow = AllowUnknownProfile.NONE;
      } else {
        allow = AllowUnknownProfile.ALL_TYPES;
      }
    }

    public String getId() {
      return id;
    }

    public boolean isSort() {
      return sort;
    }

    public boolean isGen() {
      return gen;
    }

    public String getInclude() {
      return include;
    }

    public boolean isFail() {
      return fail;
    }

    public List<StructureDefinition> getIncluded() {
      return included;
    }

    public List<Rule> getRules() {
      return rules;
    }

    public StructureDefinition getSource() {
      return source;
    }

    public void setSource(StructureDefinition source) {
      this.source = source;
    }

    public StructureDefinition getExpected() {
      return expected;
    }

    public void setExpected(StructureDefinition expected) {
      this.expected = expected;
    }

    public StructureDefinition getOutput() {
      return output;
    }

    public void setOutput(StructureDefinition output) {
      this.output = output;
    }

    public void load() throws FHIRFormatError, FileNotFoundException, IOException {
      if (TestingUtilities.findTestResource("r5", "snapshot-generation", id + "-input.json"))
        source = (StructureDefinition) new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "snapshot-generation", id + "-input.json"));
      else
        source = (StructureDefinition) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "snapshot-generation", id + "-input.xml"));
      if (!fail)
        expected = (StructureDefinition) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "snapshot-generation", id + "-expected.xml"));
      if (!Utilities.noString(include))
        included.add((StructureDefinition) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "snapshot-generation", include + ".xml")));
      if (!Utilities.noString(register)) {
        for (String s : register.split("\\,")) {
          if (TestingUtilities.findTestResource("r5", "snapshot-generation", s + ".xml")) {
            included.add((StructureDefinition) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "snapshot-generation", s + ".xml")));
          } else {
            included.add((StructureDefinition) new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "snapshot-generation", s + ".json")));
          }
        }
      }
    }

    public boolean isNewSliceProcessing() {
      return newSliceProcessing;
    }

    public boolean isDebug() {
      return debug;
    }
  }

  public class TestPKP implements ProfileKnowledgeProvider {

    @Override
    public boolean isDatatype(String name) {
      StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchTypeDefinition(name);
      return (sd != null) && (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) && (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE || sd.getKind() == StructureDefinitionKind.COMPLEXTYPE);
    }


    @Override
    public boolean isPrimitiveType(String name) {
      StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchTypeDefinition(name);
      return (sd != null) && (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) && (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE);
    }

    @Override
    public boolean isResource(String typeSimple) {
      StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchTypeDefinition(typeSimple);
      return (sd != null) && (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) && (sd.getKind() == StructureDefinitionKind.RESOURCE);
    }

    @Override
    public boolean hasLinkFor(String typeSimple) {
      return isDatatype(typeSimple);
    }

    @Override
    public String getLinkFor(String corePath, String typeSimple) {
      return Utilities.pathURL(corePath, "datatypes.html#" + typeSimple);
    }

    @Override
    public BindingResolution resolveBinding(StructureDefinition def, ElementDefinitionBindingComponent binding, String path) throws FHIRException {
      BindingResolution br = new BindingResolution();
      br.url = path + "/something.html";
      br.display = "something";
      return br;
    }

    @Override
    public BindingResolution resolveBinding(StructureDefinition def, String url, String path) throws FHIRException {
      BindingResolution br = new BindingResolution();
      br.url = path + "/something.html";
      br.display = "something";
      return br;
    }

    @Override
    public String getLinkForProfile(StructureDefinition profile, String url) {
      StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, url);
      if (sd == null)
        return url + "|" + url;
      else
        return sd.getId() + ".html|" + sd.present();
    }

    @Override
    public boolean prependLinks() {
      return false;
    }

    @Override
    public String getLinkForUrl(String corePath, String s) {
      // TODO Auto-generated method stub
      return null;
    }

  }

  private static class SnapShotGenerationTestsContext implements IEvaluationContext {
    public List<TestDetails> tests = new ArrayList<>();

    public Resource fetchFixture(String id) {
      TestFetchMode mode = TestFetchMode.INPUT;
      if (id.equals("patient"))
        return TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient");
      if (id.equals("valueset"))
        return TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/ValueSet");
      if (id.equals("organization"))
        return TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Organization");
      if (id.equals("operationoutcome"))
        return TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/OperationOutcome");
      if (id.equals("parameters"))
        return TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Parameters");

      if (id.contains("-")) {
        String[] p = id.split("\\-");
        id = p[0];
        if (p[1].equals("output"))
          mode = TestFetchMode.OUTPUT;
        else if (p[1].equals("include"))
          mode = TestFetchMode.INCLUDE;
      }
      for (TestDetails td : tests) {
        if (td.getId().equals(id))
          switch (mode) {
            case INPUT:
              return td.getSource();
            case OUTPUT:
              if (td.getOutput() == null)
                throw new FHIRException("Not generated yet");
              else
                return td.getOutput();
            case INCLUDE:
              return td.getIncluded().get(0);
            default:
              throw new FHIRException("Not done yet");
          }
      }
      return null;
    }

    // FHIRPath methods
    @Override
    public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, boolean beforeContext, boolean explicitConstant) throws PathEngineException {
      throw new Error("Not implemented yet");
    }

    @Override
    public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, boolean explicitConstant) throws PathEngineException {
      throw new Error("Not implemented yet");
    }

    @Override
    public boolean log(String argument, List<Base> focus) {
      System.out.println(argument + ": " + fp.convertToString(focus));
      return true;
    }

    @Override
    public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
      if ("fixture".equals(functionName))
        return new FunctionDetails("Access a fixture defined in the testing context", 0, 1);
      return null;
    }

    @Override
    public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
      if ("fixture".equals(functionName))
        return new TypeDetails(CollectionStatus.SINGLETON, TestingUtilities.getSharedWorkerContext().getResourceNamesAsSet());
      return null;
    }

    @Override
    public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
      if ("fixture".equals(functionName)) {
        String id = fp.convertToString(parameters.get(0));
        Resource res = fetchFixture(id);
        if (res != null) {
          List<Base> list = new ArrayList<Base>();
          list.add(res);
          return list;
        }
        throw new Error("Could not resolve " + id);
      }
      throw new Error("Not implemented yet");
    }

    @Override
    public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException {
      IResourceValidator val = TestingUtilities.getSharedWorkerContext().newValidator();
      List<ValidationMessage> valerrors = new ArrayList<ValidationMessage>();
      if (item instanceof Resource) {
        val.validate(appContext, valerrors, (Resource) item, url);
        boolean ok = true;
        for (ValidationMessage v : valerrors)
          ok = ok && v.getLevel().isError();
        return ok;
      }
      throw new NotImplementedException("Not done yet (IGPublisherHostServices.SnapShotGenerationTestsContext), when item is element");
    }

    public StructureDefinition getByUrl(String url) {
      if (url == null)
        return null;
      for (TestDetails t : tests) {
        if (t.expected != null && url.equals(t.expected.getUrl()))
          return t.expected;
        for (StructureDefinition sd : t.included) {
          if (url.equals(sd.getUrl()))
            return sd;
        }
      }
      return null;
    }

    @Override
    public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
      throw new Error("Not implemented yet");
    }

    @Override
    public boolean paramIsType(String name, int index) {
      return false;
    }
  }

  private static FHIRPathEngine fp;
  private List<ValidationMessage> messages;

  @BeforeAll
  public static void setUp() {
    fp = new FHIRPathEngine(TestingUtilities.getSharedWorkerContext());
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {
    SnapShotGenerationTestsContext context = new SnapShotGenerationTestsContext();
    Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "snapshot-generation", "manifest.xml"));
    Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
    List<Arguments> objects = new ArrayList<>();
    while (test != null && test.getNodeName().equals("test")) {
      TestDetails t = new TestDetails(test);
      context.tests.add(t);
      t.load();
      objects.add(Arguments.of(t.getId(), t, context));
      test = XMLUtil.getNextSibling(test);
    }
    return objects.stream();
  }

  @SuppressWarnings("deprecation")
  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String id, TestDetails test, SnapShotGenerationTestsContext context) throws Exception {
    fp.setHostServices(context);
    messages = new ArrayList<ValidationMessage>();

    System.out.println("---- "+id+" -----------------------------------------");
    if (test.isFail()) {
      boolean failed = true;
      try {
        if (test.isGen())
          testGen(true, test, context);
        else
          testSort(test, context);
        failed = false;
      } catch (Throwable e) {
        System.out.println("Error running test: " + e.getMessage());
        if (!Utilities.noString(test.regex)) {
          Assertions.assertTrue(e.getMessage().matches(test.regex), "correct error message");
        } else if ("Should have failed".equals(e.getMessage())) {
          throw e;
        } else {
        }
      }
      Assertions.assertTrue(failed, "Should have failed");
    } else if (test.isGen())
      testGen(false, test, context);
    else
      testSort(test, context);
    for (Rule r : test.getRules()) {
      StructureDefinition sdn = new StructureDefinition();
      boolean ok = fp.evaluateToBoolean(sdn, sdn, sdn, r.expression);
      Assertions.assertTrue(ok, r.description);
    }
  }

  private void testSort(TestDetails test, SnapShotGenerationTestsContext context) throws DefinitionException, FHIRException, IOException {
    StructureDefinition base = getSD(test.getSource().getBaseDefinition(), context);
    test.setOutput(test.getSource().copy());
    ProfileUtilities pu = new ProfileUtilities(TestingUtilities.getSharedWorkerContext(), null, null);
    pu.setIds(test.getSource(), false);
    List<String> errors = new ArrayList<String>();
    pu.sortDifferential(base, test.getOutput(), test.getOutput().getUrl(), errors, false);
    if (!errors.isEmpty())
      throw new FHIRException(errors.get(0));
//    IOUtils.copy(TestingUtilities.loadTestResourceStream("r5", "snapshot-generation", test.getId() + "-expected.xml"), new FileOutputStream(TestingUtilities.tempFile("snapshot", test.getId() + "-expected.xml")));
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(TestingUtilities.tempFile("snapshot", test.getId() + "-expected.xml")), test.getOutput());
    Assertions.assertTrue(test.expected.equalsDeep(test.output), "Output does not match expected");
  }

  private void testGen(boolean fail, TestDetails test, SnapShotGenerationTestsContext context) throws Exception {
    if (!Utilities.noString(test.register)) {
      List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
      ProfileUtilities pu = new ProfileUtilities(TestingUtilities.getSharedWorkerContext(), messages, null);
      pu.setNewSlicingProcessing(true);
      pu.setAllowUnknownProfile(test.allow);
      for (StructureDefinition sd : test.included) {
        pu.setIds(sd, false);
      }
      for (StructureDefinition sd : test.included) {
        if (!TestingUtilities.getSharedWorkerContext().hasResource(StructureDefinition.class, sd.getUrl())) {
          TestingUtilities.getSharedWorkerContext().cacheResource(sd);
        }
      }
      StructureDefinition base = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, test.included.get(0).getBaseDefinition());
      if (base != null) {
        pu.generateSnapshot(base, test.included.get(0), test.included.get(0).getUrl(), "http://test.org/profile", test.included.get(0).getName());
      }
      int ec = 0;
      for (ValidationMessage vm : messages) {
        if (vm.getLevel() == IssueSeverity.ERROR) {
          System.out.println(vm.summary());
          ec++;
        }
      }
      if (ec > 0)
        throw new FHIRException("register gen failed: " + messages.toString());
    }
    StructureDefinition base = getSD(test.getSource().getBaseDefinition(), context);
    if (!base.getUrl().equals(test.getSource().getBaseDefinition()))
      throw new Exception("URL mismatch on base: " + base.getUrl() + " wanting " + test.getSource().getBaseDefinition());

    StructureDefinition output = test.getSource().copy();
    ProfileUtilities pu = new ProfileUtilities(TestingUtilities.getSharedWorkerContext(), messages, new TestPKP());
    pu.setNewSlicingProcessing(test.isNewSliceProcessing());
    pu.setThrowException(false);
    pu.setDebug(test.isDebug());
    pu.setIds(test.getSource(), false);
    pu.setAllowUnknownProfile(test.allow);
    if (!TestingUtilities.getSharedWorkerContext().hasPackage(CommonPackages.ID_XVER, CommonPackages.VER_XVER)) {
      NpmPackage npm = new FilesystemPackageCacheManager.Builder().build().loadPackage(CommonPackages.ID_XVER, CommonPackages.VER_XVER);
      TestingUtilities.getSharedWorkerContext().loadFromPackage(npm, new TestPackageLoader(Utilities.strings("StructureDefinition")), Utilities.strings("StructureDefinition"));
    }
    pu.setXver(new XVerExtensionManager(TestingUtilities.getSharedWorkerContext()));
    if (test.isSort()) {
      List<String> errors = new ArrayList<String>();
      int lastCount = output.getDifferential().getElement().size();
      pu.sortDifferential(base, output, test.getSource().getName(), errors, false);
      if (errors.size() > 0)
        throw new FHIRException("Sort failed: " + errors.toString());
    }
    try {
      messages.clear();
      pu.generateSnapshot(base, output, test.getSource().getUrl(), "http://test.org/profile", test.getSource().getName());
      List<ValidationMessage> ml = new ArrayList<>();
      for (ValidationMessage vm : messages) {
        if (vm.getLevel() == IssueSeverity.ERROR) {
          ml.add(vm);
        }
      }
      if (ml.size() > 0) {
        throw new FHIRException("Snapshot Generation failed: " + ml.toString());
      }
    } catch (Throwable e) {
      System.out.println("\r\nException: " + e.getMessage());
      throw e;
    }
    if (output.getDifferential().hasElement()) {
      RenderingContext rc = new RenderingContext(TestingUtilities.getSharedWorkerContext(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
      rc.setDestDir(Utilities.path("[tmp]", "snapshot"));
      rc.setProfileUtilities(new ProfileUtilities(TestingUtilities.getSharedWorkerContext(), null, new TestPKP()));
      RendererFactory.factory(output, rc).render(output);
    }
    if (!fail) {
      test.output = output;
      TestingUtilities.getSharedWorkerContext().cacheResource(output);
      File dst = new File(TestingUtilities.tempFile("snapshot", test.getId() + "-expected.xml"));
      if (dst.exists())
        dst.delete();
//      IOUtils.copy(TestingUtilities.loadTestResourceStream("r5", "snapshot-generation", test.getId() + "-expected.xml"), new FileOutputStream(dst));
      String actualFilePath = TestingUtilities.tempFile("snapshot", test.getId() + "-expected.xml");
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(actualFilePath), output);
      StructureDefinition t1 = test.expected.copy();
      t1.setText(null);
      StructureDefinition t2 = test.output.copy();
      t2.setText(null);

      boolean structureDefinitionEquality = t1.equalsDeep(t2);
      if (!structureDefinitionEquality) {
        System.out.println("Encountered unexpected change in diff in structure definition");
//        DiffUtils.testDiff(dst.getAbsolutePath(), actualFilePath);
      }
      Assertions.assertTrue(structureDefinitionEquality, "Output does not match expected");
    }
  }

  private StructureDefinition getSD(String url, SnapShotGenerationTestsContext context) throws DefinitionException, FHIRException, IOException {
    StructureDefinition sd = context.getByUrl(url);
    if (sd == null) {
      sd = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, url);
    } 
    if (sd == null) {
      throw new DefinitionException("Unable to find profile "+url);
    }
    if (!sd.hasSnapshot()) {
      StructureDefinition base = getSD(sd.getBaseDefinition(), context);
      ProfileUtilities pu = new ProfileUtilities(TestingUtilities.getSharedWorkerContext(), messages, new TestPKP());
      pu.setNewSlicingProcessing(true);
      List<String> errors = new ArrayList<String>();
      pu.sortDifferential(base, sd, url, errors, false);
      if (!errors.isEmpty())
        throw new FHIRException(errors.get(0));
      pu.setIds(sd, false);
      pu.generateSnapshot(base, sd, sd.getUrl(), "http://test.org/profile", sd.getName());
    }
    return sd;
  }
}