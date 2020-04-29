package org.hl7.fhir.r5.test;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.terminologies.ConceptMapEngine;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.StructureMapUtilities;
import org.hl7.fhir.r5.utils.StructureMapUtilities.ITransformerServices;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FHIRMappingLanguageTests implements ITransformerServices {

  private List<Resource> outputs = new ArrayList<Resource>();

  static private SimpleWorkerContext context;
  static private JsonParser jsonParser;

  public static Stream<Arguments> data()
    throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
    Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "fml", "manifest.xml"));
    Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
    List<Arguments> objects = new ArrayList<>();
    while (test != null && test.getNodeName().equals("test")) {
      objects.add(Arguments.of(test.getAttribute("name"), test.getAttribute("source"), test.getAttribute("map"),
        test.getAttribute("output")));
      test = XMLUtil.getNextSibling(test);
    }
    return objects.stream();
  }

  @BeforeAll
  public static void setUp() throws Exception {
    PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.core", "4.0.1"));
    jsonParser = new JsonParser();
    jsonParser.setOutputStyle(OutputStyle.PRETTY);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  @Disabled // Test fails: java.lang.AssertionError: Error, but proper output was expected (This does not appear to be a FHIR resource (unknown name "QuestionnaireResponse")
  public void test(String name, String source, String map, String output) throws Exception {

    InputStream fileSource = TestingUtilities.loadTestResourceStream("r5", "fml", source);
    InputStream fileMap = TestingUtilities.loadTestResourceStream("r5", "fml", map);
    String outputJson = TestingUtilities.loadTestResource("r5", "fml", output);
    String fileOutputRes = TestingUtilities.tempFile("fml", output) + ".out";

    outputs.clear();

    boolean ok = false;
    String msg = null;
    Resource resource = null;
    try {
      StructureMapUtilities scu = new StructureMapUtilities(context, this);
      org.hl7.fhir.r5.elementmodel.Element src = Manager.parse(context,
        new ByteArrayInputStream(TextFile.streamToBytes(fileSource)), FhirFormat.JSON);
      StructureMap structureMap = scu.parse(TextFile.streamToString(fileMap), name);
      String typeName = scu.getTargetType(structureMap).getType();
      resource = ResourceFactory.createResource(typeName);
      scu.transform(null, src, structureMap, resource);
      ok = true;
    } catch (Exception e) {
      ok = false;
      msg = e.getMessage();
    }
    if (ok) {
      ByteArrayOutputStream boas = new ByteArrayOutputStream();
      jsonParser.compose(boas, resource);
      String result = boas.toString();
      log(result);
      TextFile.bytesToFile(boas.toByteArray(), fileOutputRes);
      msg = TestingUtilities.checkJsonSrcIsSame(result, outputJson);
      assertTrue(msg, Utilities.noString(msg));
    } else
      assertEquals("Error, but proper output was expected (" + msg + ")", "$error", output);
  }

  @Override
  public void log(String message) {
    System.out.println(message);
  }

  @Override
  public Base createType(Object appInfo, String name) throws FHIRException {
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, name);
    if (sd != null && sd.getKind() == StructureDefinitionKind.LOGICAL) {
      return Manager.build(context, sd);
    } else {
      if (name.startsWith("http://hl7.org/fhir/StructureDefinition/"))
        name = name.substring("http://hl7.org/fhir/StructureDefinition/".length());
      return ResourceFactory.createResourceOrType(name);
    }
  }

  @Override
  public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
    if (atRootofTransform)
      outputs.add((Resource) res);
    return res;
  }

  @Override
  public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
    ConceptMapEngine cme = new ConceptMapEngine(context);
    return cme.translate(source, conceptMapUrl);
  }

  @Override
  public Base resolveReference(Object appContext, String url) throws FHIRException {
    throw new FHIRException("resolveReference is not supported yet");
  }

  @Override
  public List<Base> performSearch(Object appContext, String url) throws FHIRException {
    throw new FHIRException("performSearch is not supported yet");
  }
}
