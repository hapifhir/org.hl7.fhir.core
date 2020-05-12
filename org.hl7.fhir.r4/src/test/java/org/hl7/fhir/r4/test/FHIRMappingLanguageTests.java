package org.hl7.fhir.r4.test;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.elementmodel.Manager;
import org.hl7.fhir.r4.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4.terminologies.ConceptMapEngine;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.StructureMapUtilities;
import org.hl7.fhir.r4.utils.StructureMapUtilities.ITransformerServices;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

@Disabled
public class FHIRMappingLanguageTests implements ITransformerServices {

  private List<Resource> outputs = new ArrayList<Resource>();

  static private SimpleWorkerContext context;
  static private JsonParser jsonParser;

  public static Stream<Arguments> data()
    throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
    Document tests = XMLUtil.parseFileToDom(TestingUtilities.resourceNameToFile("fml", "manifest.xml"));
    Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
    List<Arguments> objects = new ArrayList();
    while (test != null && test.getNodeName().equals("test")) {
      objects.add(Arguments.of(test.getAttribute("name"), test.getAttribute("source"), test.getAttribute("map"),
        test.getAttribute("output")));
      test = XMLUtil.getNextSibling(test);
    }
    return objects.stream();
  }

  @BeforeAll
  static public void setUp() throws Exception {
    if (context == null) {
      PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
      context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.core", "4.0.0"));
      jsonParser = new JsonParser();
      jsonParser.setOutputStyle(OutputStyle.PRETTY);
    }
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void test(String name, String source, String map, String output) throws Exception {

    String fileSource = TestingUtilities.resourceNameToFile("fml", source);
    String fileMap = TestingUtilities.resourceNameToFile("fml", map);
    String fileOutput = TestingUtilities.resourceNameToFile("fml", output);
    String fileOutputRes = TestingUtilities.resourceNameToFile("fml", output) + ".out";

    outputs.clear();

    boolean ok = false;
    String msg = null;
    Resource resource = null;
    try {
      StructureMapUtilities scu = new StructureMapUtilities(context, this);
      org.hl7.fhir.r4.elementmodel.Element src = Manager.parse(context,
        new ByteArrayInputStream(TextFile.fileToBytes(fileSource)), FhirFormat.JSON);
      StructureMap structureMap = scu.parse(TextFile.fileToString(fileMap), name);
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
      log(boas.toString());
      TextFile.bytesToFile(boas.toByteArray(), fileOutputRes);
      msg = TestingUtilities.checkJsonIsSame(fileOutputRes, fileOutput);
      assertTrue(msg, Utilities.noString(msg));
    } else
      assertTrue("Error, but proper output was expected (" + msg + ")", output.equals("$error"));
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