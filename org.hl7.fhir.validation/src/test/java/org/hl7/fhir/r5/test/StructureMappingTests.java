package org.hl7.fhir.r5.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.InstanceValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class StructureMappingTests {

  private List<Resource> outputs = new ArrayList<Resource>();

  static private ValidationEngine validationEngine;

  static private SimpleWorkerContext context;

  public static Stream<Arguments> data()
    throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
    Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "structure-mapping", "manifest.xml"));
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
    validationEngine = new ValidationEngine.ValidationEngineBuilder().fromSource("hl7.fhir.r4.core#4.0.1");
    context = validationEngine.getContext();
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "any.xml"), "any.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ii.xml"), "ii.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "cd.xml"), "cd.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ce.xml"), "ce.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ed.xml"), "ed.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "st.xml"), "st.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "cda.xml"), "cda.xml", null);
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      if (!sd.hasSnapshot()) {
        System.out.println("generate snapshot for " + sd.getUrl());
        new ContextUtilities(context).generateSnapshot(sd, true);
      }
    }
    if (context.getValidatorFactory() == null) {
      context.setValidatorFactory(new InstanceValidatorFactory());
    }
  }
  private StructureMap loadStructureMap(String map) throws Exception {
    String stringMap = TestingUtilities.loadTestResource("r5", "structure-mapping", map);
    if (map.endsWith(".json")) {
      return (StructureMap) new org.hl7.fhir.r5.formats.JsonParser().parse(stringMap);
    } else if (map.endsWith(".map")) {
      return new StructureMapUtilities(context).parse(stringMap, map);
    }
    throw new Exception("File extension for StuctureMap is not a recognized type (should be one of: '.map', '.json')");
  }
  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void test(String name, String source, String map, String output) throws Exception {

    ByteProvider byteSource = ByteProvider.forBytes(TestingUtilities.loadTestResourceBytes("r5", "structure-mapping", source));

    String outputJson = TestingUtilities.loadTestResource("r5", "structure-mapping", output);
    String fileOutputRes = TestingUtilities.tempFile("structure-mapping", output) + ".out";
    String fileOutputResOrig = TestingUtilities.tempFile("structure-mapping", output) + ".orig.out";
    ByteArrayOutputStream s = null;
    outputs.clear();

    String msg = null;
    try {
      StructureMap r = loadStructureMap(map);
      context.cacheResource(r);
      org.hl7.fhir.r5.elementmodel.Element element = validationEngine.transform(byteSource, FhirFormat.JSON, r.getUrl());
      s = new ByteArrayOutputStream();
      if (output.endsWith(".json"))
        new org.hl7.fhir.r5.elementmodel.JsonParser(context).compose(element, s, IParser.OutputStyle.PRETTY, null);
      else
        new org.hl7.fhir.r5.elementmodel.XmlParser(context).compose(element, s, IParser.OutputStyle.PRETTY, null);
      context.dropResource(r);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getMessage());
    }
    if (output.endsWith("json")) {
      msg = CompareUtilities.checkJsonSrcIsSame(s.toString(), outputJson, null);
    } else {
      TextFile.bytesToFile(s.toByteArray(), fileOutputRes);
      TextFile.bytesToFile(outputJson.getBytes(), fileOutputResOrig);
      msg = CompareUtilities.checkXMLIsSame(new FileInputStream(fileOutputResOrig), new FileInputStream(fileOutputRes));
    }
    if (!Utilities.noString(msg)) {
      System.out.print(s.toString());
    }
    assertTrue(msg, Utilities.noString(msg));
  }
  @Test
  void testTransformLogicalSource() throws Exception {
    String map = "map \"http://github.com/hapifhir/org.hl7.fhir.core/org.hl7.fhir.r4.tests/cda2qr\" = \"cda2qr\"\n"
    		+ "\n"
    		+ "uses \"http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse\" alias QuestionnaireResponse as target\n"
    		+ "uses \"http://hl7.org/fhir/cdatest/StructureDefinition/ClinicalDocument\" alias ClinicalDocument as source\n"
    		+ "\n"
    		+ "group ClinicalDocument(source src : ClinicalDocument, target tgt : QuestionnaireResponse) {\n"
    		+ "  src -> tgt.status = 'in-progress' \"code\";\n"
    		+ "}";
    StructureMap r = null;   
	try {
	  r = new StructureMapUtilities(context).parse(map, "cda2qr");
	  context.cacheResource(r);	      
	  ByteProvider byteSource = ByteProvider.forBytes("{}".getBytes());
	  org.hl7.fhir.r5.elementmodel.Element element = validationEngine.transform(byteSource, FhirFormat.JSON, r.getUrl());
	  Assertions.assertNotNull(element);
	} finally {
	  context.dropResource(r);
	}      
  }  
  @Test
  void testGetSourceResourceFromStructureMapDefinitionException() {
    StructureMap r = new StructureMap().setUrl("testGetSourceResourceFromStructureMapDefinitionException");      
    StructureMap.StructureMapGroupComponent g = r.addGroup();
    g.addInput().setMode(StructureMap.StructureMapInputMode.SOURCE).setType("input");
    g.addInput().setMode(StructureMap.StructureMapInputMode.SOURCE).setType("input");
    r.addStructure()
      .setMode(StructureMap.StructureMapModelMode.TARGET)
      .setUrl("testGetSourceResourceFromStructureMapDefinitionExceptionTarget");
    context.cacheResource(r);
    StructureDefinition structureDefinition = new StructureDefinition().setUrl("testGetSourceResourceFromStructureMapDefinitionExceptionTarget");
    structureDefinition.getSnapshot().addElement().setPath("testGetSourceResourceFromStructureMapDefinitionExceptionTarget");
    context.cacheResource(structureDefinition);
    ByteProvider byteSource = ByteProvider.forBytes("testGetSourceResourceFromStructureMapDefinitionException".getBytes());
    DefinitionException thrown = assertThrows(
    		DefinitionException.class,
    		() -> validationEngine.transform(byteSource, FhirFormat.JSON, r.getUrl()),
    		"Expected transform() to throw DefinitionException"
    		);
    context.dropResource(r);
    context.dropResource(structureDefinition);
    assertTrue(thrown.getMessage().contentEquals("This engine does not support multiple source inputs"));
  }
}