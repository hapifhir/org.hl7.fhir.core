package org.hl7.fhir.dstu3.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.dstu3.conformance.ProfileUtilities;
import org.hl7.fhir.dstu3.context.SimpleWorkerContext;
import org.hl7.fhir.dstu3.fhirpath.FHIRPathEngine;
import org.hl7.fhir.dstu3.fhirpath.TypeDetails;
import org.hl7.fhir.dstu3.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.dstu3.fhirpath.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.dstu3.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.dstu3.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.Base;
import org.hl7.fhir.dstu3.model.MetadataResource;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.model.StructureDefinition;
import org.hl7.fhir.dstu3.model.TestScript;
import org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent;
import org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent;
import org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent;
import org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent;
import org.hl7.fhir.dstu3.test.support.TestingUtilities;
import org.hl7.fhir.dstu3.utils.CodingUtilities;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
public class SnapShotGenerationTests {

  private static FHIRPathEngine fp;

  public static Stream<Arguments> data() throws IOException, FHIRFormatError {
    SnapShotGenerationTestsContext context = new SnapShotGenerationTestsContext();
    String contents = readFileFromClasspathAsString("snapshot-generation-tests.xml");
    context.tests = (TestScript) new XmlParser().parse(contents);

    context.checkTestsDetails();

    List<Arguments> objects = new ArrayList<>();

    for (TestScriptTestComponent e : context.tests.getTest()) {
      objects.add(Arguments.of(e.getName(), e, context));
    }
    return objects.stream();
  }

  private static String readFileFromClasspathAsString(String theClasspath) throws IOException {
    return IOUtils.toString(SnapShotGenerationTests.class.getResourceAsStream(theClasspath), Charsets.UTF_8);
  }

  @SuppressWarnings("deprecation")
  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String name, TestScriptTestComponent test, SnapShotGenerationTestsContext context) throws IOException, FHIRException {
    if (TestingUtilities.context == null)
      TestingUtilities.context = SimpleWorkerContext.fromPack(Utilities.path(TestingUtilities.home(), "publish", "definitions.xml.zip"));
    if (fp == null)
      fp = new FHIRPathEngine(TestingUtilities.context);
    fp.setHostServices(context);

    resolveFixtures(context);

    SetupActionOperationComponent op = test.getActionFirstRep().getOperation();
    StructureDefinition source = (StructureDefinition) context.fetchFixture(op.getSourceId());
    StructureDefinition base = getSD(source.getBaseDefinition(), context);
    StructureDefinition output = source.copy();
    ProfileUtilities pu = new ProfileUtilities(TestingUtilities.context, null, null);
    pu.setIds(source, false);
    pu.generateSnapshot(base, output, source.getUrl(), source.getName());
    context.fixtures.put(op.getResponseId(), output);
    context.snapshots.put(output.getUrl(), output);

    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(Utilities.path("[tmp]"), op.getResponseId() + ".xml")), output);
    //ok, now the asserts:
    for (int i = 1; i < test.getAction().size(); i++) {
      SetupActionAssertComponent a = test.getAction().get(i).getAssert();
      Assertions.assertTrue(fp.evaluateToBoolean(source, source, a.getExpression()), a.getLabel() + ": " + a.getDescription());
    }
  }

  private StructureDefinition getSD(String url, SnapShotGenerationTestsContext context) throws DefinitionException, FHIRException {
    StructureDefinition sd = TestingUtilities.context.fetchResource(StructureDefinition.class, url);
    if (sd == null)
      sd = context.snapshots.get(url);
    if (sd == null)
      sd = findContainedProfile(url, context);
    return sd;
  }

  private StructureDefinition findContainedProfile(String url, SnapShotGenerationTestsContext context) throws DefinitionException, FHIRException {
    for (Resource r : context.tests.getContained()) {
      if (r instanceof StructureDefinition) {
        StructureDefinition sd = (StructureDefinition) r;
        if (sd.getUrl().equals(url)) {
          StructureDefinition p = sd.copy();
          ProfileUtilities pu = new ProfileUtilities(TestingUtilities.context, null, null);
          pu.setIds(p, false);
          pu.generateSnapshot(getSD(p.getBaseDefinition(), context), p, p.getUrl(), p.getName());
          return p;
        }
      }
    }
    return null;
  }

  private void resolveFixtures(SnapShotGenerationTestsContext context) {
    if (context.fixtures == null) {
      context.fixtures = new HashMap<>();
      for (TestScriptFixtureComponent fd : context.tests.getFixture()) {
        Resource r = TestingUtilities.context.fetchResource(Resource.class, fd.getResource().getReference());
        context.fixtures.put(fd.getId(), r);
      }
    }
  }

  private static class SnapShotGenerationTestsContext implements IEvaluationContext {
    private Map<String, Resource> fixtures;
    private Map<String, StructureDefinition> snapshots = new HashMap<String, StructureDefinition>();
    public TestScript tests;

    public void checkTestsDetails() {
      if (!"http://hl7.org/fhir/tests/snapshotgeneration".equals(tests.getUrl()))
        throw new Error("Wrong URL on test script");
      if (!tests.getSetup().isEmpty())
        throw new Error("Setup is not supported");
      if (!tests.getTeardown().isEmpty())
        throw new Error("Teardown is not supported");
      Set<String> ids = new HashSet<String>();
      Set<String> urls = new HashSet<String>();
      for (Resource r : tests.getContained()) {
        if (ids.contains(r.getId()))
          throw new Error("Unsupported: duplicate contained resource on fixture id  " + r.getId());
        ids.add(r.getId());
        if (r instanceof MetadataResource) {
          MetadataResource md = (MetadataResource) r;
          if (urls.contains(md.getUrl()))
            throw new Error("Unsupported: duplicate canonical url " + md.getUrl() + " on fixture id  " + r.getId());
          urls.add(md.getUrl());
        }
      }
      for (TestScriptFixtureComponent r : tests.getFixture()) {
        if (ids.contains(r.getId()))
          throw new Error("Unsupported: duplicate contained resource or fixture id  " + r.getId());
        ids.add(r.getId());
      }
      Set<String> names = new HashSet<String>();
      for (TestScriptTestComponent test : tests.getTest()) {
        if (names.contains(test.getName()))
          throw new Error("Unsupported: duplicate name " + test.getName());
        names.add(test.getName());
        if (test.getAction().size() < 2)
          throw new Error("Unsupported: multiple actions required");
        if (!test.getActionFirstRep().hasOperation())
          throw new Error("Unsupported: first action must be an operation");
        SetupActionOperationComponent op = test.getActionFirstRep().getOperation();
        if (!CodingUtilities.matches(op.getType(), "http://hl7.org/fhir/testscript-operation-codes", "snapshot"))
          throw new Error("Unsupported action operation type " + CodingUtilities.present(op.getType()));
        if (!"StructureDefinition".equals(op.getResource()))
          throw new Error("Unsupported action operation resource " + op.getResource());
        if (!op.hasResponseId())
          throw new Error("Unsupported action operation: no response id");
        if (!op.hasSourceId())
          throw new Error("Unsupported action operation: no source id");
        if (!hasSource(op.getSourceId()))
          throw new Error("Unsupported action operation: source id could not be resolved");
        for (int i = 1; i < test.getAction().size(); i++) {
          if (!test.getAction().get(i).hasAssert())
            throw new Error("Unsupported: following actions must be an asserts");
          SetupActionAssertComponent a = test.getAction().get(i).getAssert();
          if (!a.hasLabel())
            throw new Error("Unsupported: actions must have a label");
          if (!a.hasDescription())
            throw new Error("Unsupported: actions must have a description");
          if (!a.hasExpression())
            throw new Error("Unsupported: actions must have an expression");
        }
      }
    }

    private boolean hasSource(String sourceId) {
      for (TestScriptFixtureComponent ds : tests.getFixture()) {
        if (sourceId.equals(ds.getId()))
          return true;
      }
      for (Resource r : tests.getContained()) {
        if (sourceId.equals(r.getId()))
          return true;
      }
      return false;
    }

    public Resource fetchFixture(String id) {
      if (fixtures.containsKey(id))
        return fixtures.get(id);

      for (TestScriptFixtureComponent ds : tests.getFixture()) {
        if (id.equals(ds.getId()))
          throw new Error("not done yet");
      }
      for (Resource r : tests.getContained()) {
        if (id.equals(r.getId()))
          return r;
      }
      return null;
    }

    // FHIRPath methods
    @Override
    public Base resolveConstant(Object appContext, String name) throws PathEngineException {
      return null;
    }

    @Override
    public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {
      return null;
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
        return new TypeDetails(CollectionStatus.SINGLETON, TestingUtilities.context.getResourceNamesAsSet());
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
      }
      return null;
    }

    @Override
    public Base resolveReference(Object appContext, String url) {
      // TODO Auto-generated method stub
      return null;
    }
  }
}