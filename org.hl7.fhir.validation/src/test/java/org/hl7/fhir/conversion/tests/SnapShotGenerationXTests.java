package org.hl7.fhir.conversion.tests;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ProfileUtilities.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SnapShotGenerationXTests {

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
    private String version;

    private List<Rule> rules = new ArrayList<>();
    private StructureDefinition source;
    private StructureDefinition included;
    private StructureDefinition expected;
    private StructureDefinition output;

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
      version = test.getAttribute("version");
      Element rule = XMLUtil.getFirstChild(test);
      while (rule != null && rule.getNodeName().equals("rule")) {
        rules.add(new Rule(rule));
        rule = XMLUtil.getNextSibling(rule);
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

    public StructureDefinition getIncluded() {
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
      if (UtilitiesXTests.findTestResource("rX", "snapshot-generation", id + "-input.json"))
        source = (StructureDefinition) new JsonParser().parse(UtilitiesXTests.loadTestResourceStream("rX", "snapshot-generation", id + "-input.json"));
      else
        source = (StructureDefinition) new XmlParser().parse(UtilitiesXTests.loadTestResourceStream("rX", "snapshot-generation", id + "-input.xml"));
      if (!fail)
        expected = (StructureDefinition) new XmlParser().parse(UtilitiesXTests.loadTestResourceStream("rX", "snapshot-generation", id + "-expected.xml"));
      if (!Utilities.noString(include))
        included = (StructureDefinition) new XmlParser().parse(UtilitiesXTests.loadTestResourceStream("rX", "snapshot-generation", include + ".xml"));
      if (!Utilities.noString(register)) {
        if (UtilitiesXTests.findTestResource("rX", "snapshot-generation", register + ".xml")) {
          included = (StructureDefinition) new XmlParser().parse(UtilitiesXTests.loadTestResourceStream("rX", "snapshot-generation", register + ".xml"));
        } else {
          included = (StructureDefinition) new JsonParser().parse(UtilitiesXTests.loadTestResourceStream("rX", "snapshot-generation", register + ".json"));
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
      StructureDefinition sd = UtilitiesXTests.context(version).fetchTypeDefinition(name);
      return (sd != null) && (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) && (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE || sd.getKind() == StructureDefinitionKind.COMPLEXTYPE);
    }

    @Override
    public boolean isResource(String typeSimple) {
      StructureDefinition sd = UtilitiesXTests.context(version).fetchTypeDefinition(typeSimple);
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
      StructureDefinition sd = UtilitiesXTests.context(version).fetchResource(StructureDefinition.class, url);
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
        return UtilitiesXTests.context(version).fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient");
      if (id.equals("valueset"))
        return UtilitiesXTests.context(version).fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/ValueSet");
      if (id.equals("organization"))
        return UtilitiesXTests.context(version).fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Organization");
      if (id.equals("operationoutcome"))
        return UtilitiesXTests.context(version).fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/OperationOutcome");
      if (id.equals("parameters"))
        return UtilitiesXTests.context(version).fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Parameters");

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
              return td.getIncluded();
            default:
              throw new FHIRException("Not done yet");
          }
      }
      return null;
    }

    // FHIRPath methods
    @Override
    public Base resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
      throw new Error("Not implemented yet");
    }

    @Override
    public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {
      throw new Error("Not implemented yet");
    }

    @Override
    public boolean log(String argument, List<Base> focus) {
      System.out.println(argument + ": " + fp.convertToString(focus));
      return true;
    }

    @Override
    public FunctionDetails resolveFunction(String functionName) {
      if ("fixture".equals(functionName))
        return new FunctionDetails("Access a fixture defined in the testing context", 0, 1);
      return null;
    }

    @Override
    public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
      if ("fixture".equals(functionName))
        return new TypeDetails(CollectionStatus.SINGLETON, UtilitiesXTests.context(version).getResourceNamesAsSet());
      return null;
    }

    @Override
    public List<Base> executeFunction(Object appContext, String functionName, List<List<Base>> parameters) {
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
    public Base resolveReference(Object appContext, String url, Base refContext) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
      IResourceValidator val = UtilitiesXTests.context(version).newValidator();
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
        if (t.included != null && url.equals(t.included.getUrl()))
          return t.included;
      }
      return null;
    }

    @Override
    public ValueSet resolveValueSet(Object appContext, String url) {
      throw new Error("Not implemented yet");
    }

  }

  private static FHIRPathEngine fp;

  public static Iterable<Object[]> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {

    SnapShotGenerationTestsContext context = new SnapShotGenerationTestsContext();
    Document tests = XMLUtil.parseToDom(UtilitiesXTests.loadTestResource("rX", "snapshot-generation", "manifest.xml"));
    Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
    List<Object[]> objects = new ArrayList<Object[]>();
    while (test != null && test.getNodeName().equals("test")) {
      TestDetails t = new TestDetails(test);
      context.tests.add(t);
      t.load();
      objects.add(new Object[]{t.getId(), t, context});
      test = XMLUtil.getNextSibling(test);
    }
    return objects;

  }

  private SnapShotGenerationTestsContext context;
  private List<ValidationMessage> messages;
  private static String version;

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String id, TestDetails test, SnapShotGenerationTestsContext context) throws Exception {
    version = test.version;
    this.context = context;
    if (fp == null)
      fp = new FHIRPathEngine(UtilitiesXTests.context(version));
    fp.setHostServices(context);
    messages = new ArrayList<ValidationMessage>();

    if (test.isFail()) {
      try {
        if (test.isGen())
          testGen(true, test);
        else
          testSort(test);
        Assertions.assertTrue(false, "Should have failed");
      } catch (Throwable e) {
        System.out.println("Error running test: " + e.getMessage());
        if (!Utilities.noString(test.regex)) {
          Assertions.assertTrue(e.getMessage().matches(test.regex), "correct error message");
        } else if ("Should have failed".equals(e.getMessage())) {
          throw e;
        } else {
          Assertions.assertTrue(true, "all ok");
        }

      }
    } else if (test.isGen())
      testGen(false, test);
    else
      testSort(test);
    for (Rule r : test.getRules()) {
      StructureDefinition sdn = new StructureDefinition();
      boolean ok = fp.evaluateToBoolean(sdn, sdn, sdn, r.expression);
      Assertions.assertTrue(ok, r.description);
    }
  }


  private void testSort(TestDetails test) throws DefinitionException, FHIRException, IOException {
    StructureDefinition base = getSD(test.getSource().getBaseDefinition());
    test.setOutput(test.getSource().copy());
    ProfileUtilities pu = new ProfileUtilities(UtilitiesXTests.context(version), null, null);
    pu.setIds(test.getSource(), false);
    List<String> errors = new ArrayList<String>();
    pu.sortDifferential(base, test.getOutput(), test.getOutput().getUrl(), errors, false);
    if (!errors.isEmpty())
      throw new FHIRException(errors.get(0));
    IOUtils.copy(UtilitiesXTests.loadTestResourceStream("rX", "snapshot-generation", test.getId() + "-expected.xml"), new FileOutputStream(UtilitiesXTests.tempFile("snapshot", test.getId() + "-expected.xml")));
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(UtilitiesXTests.tempFile("snapshot", test.getId() + "-actual.xml")), test.getOutput());
    Assertions.assertTrue(test.expected.equalsDeep(test.output), "Output does not match expected");
  }

  private void testGen(boolean fail, TestDetails test) throws Exception {
    if (!Utilities.noString(test.register)) {
      List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
      ProfileUtilities pu = new ProfileUtilities(UtilitiesXTests.context(version), messages, null);
      pu.setNewSlicingProcessing(true);
      pu.setIds(test.included, false);
      StructureDefinition base = UtilitiesXTests.context(version).fetchResource(StructureDefinition.class, test.included.getBaseDefinition());
      if (base != null) {
        pu.generateSnapshot(base, test.included, test.included.getUrl(), "http://test.org/profile", test.included.getName());
      }
      if (!UtilitiesXTests.context(version).hasResource(StructureDefinition.class, test.included.getUrl()))
        UtilitiesXTests.context(version).cacheResource(test.included);
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
    StructureDefinition base = getSD(test.getSource().getBaseDefinition());
    if (!base.getUrl().equals(test.getSource().getBaseDefinition()))
      throw new Exception("URL mismatch on base: " + base.getUrl() + " wanting " + test.getSource().getBaseDefinition());

    StructureDefinition output = test.getSource().copy();
    ProfileUtilities pu = new ProfileUtilities(UtilitiesXTests.context(version), messages, new TestPKP());
    pu.setNewSlicingProcessing(test.isNewSliceProcessing());
    pu.setThrowException(false);
    pu.setDebug(test.isDebug());
    pu.setIds(test.getSource(), false);
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
      RenderingContext rc = new RenderingContext(TestingUtilities.context(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.RESOURCE);
      rc.setDestDir(makeTempDir());
      rc.setProfileUtilities(new ProfileUtilities(TestingUtilities.context(), null, new TestPKP()));
      RendererFactory.factory(output, rc).render(output);
    }
    if (!fail) {
      test.output = output;
      UtilitiesXTests.context(version).cacheResource(output);
      File dst = new File(UtilitiesXTests.tempFile("snapshot", test.getId() + "-expected.xml"));
      if (dst.exists())
        dst.delete();
      IOUtils.copy(UtilitiesXTests.loadTestResourceStream("rX", "snapshot-generation", test.getId() + "-expected.xml"), new FileOutputStream(dst));
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(UtilitiesXTests.tempFile("snapshot", test.getId() + "-actual.xml")), output);
      StructureDefinition t1 = test.expected.copy();
      t1.setText(null);
      StructureDefinition t2 = test.output.copy();
      t2.setText(null);
      Assertions.assertTrue(t1.equalsDeep(t2), "Output does not match expected");
    }
  }

  private String makeTempDir() throws IOException {
    String path = Utilities.path("[tmp]", "snapshot");
    Utilities.createDirectory(path);
    return path;
  }


  private StructureDefinition getSD(String url) throws DefinitionException, FHIRException, IOException {
    StructureDefinition sd = context.getByUrl(url);
    if (sd == null)
      sd = UtilitiesXTests.context(version).fetchResource(StructureDefinition.class, url);
    if (!sd.hasSnapshot()) {
      StructureDefinition base = getSD(sd.getBaseDefinition());
      ProfileUtilities pu = new ProfileUtilities(UtilitiesXTests.context(version), messages, new TestPKP());
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