package org.hl7.fhir.validation.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Composition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
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
        new ContextUtilities(context).generateSnapshot(sd);
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
      msg = new CompareUtilities().checkJsonSrcIsSame(name, s.toString(), outputJson);
    } else {
      FileUtilities.bytesToFile(s.toByteArray(), fileOutputRes);
      FileUtilities.bytesToFile(outputJson.getBytes(), fileOutputResOrig);
      msg = new CompareUtilities().checkXMLIsSame(name, ManagedFileAccess.inStream(fileOutputResOrig), ManagedFileAccess.inStream(fileOutputRes));
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
  
  @Test
  public void testResolveBundle() throws FHIRException, IOException {
    // TODO: move to https://github.com/FHIR/fhir-test-cases/tree/master/r5/structure-mapping
    String map = "map \"http://example.org/StructureMap/Bundle2Composition\" = \"Bundle2Composition\"\r\n"
        + "\r\n"
        + "uses \"http://hl7.org/fhir/StructureDefinition/Bundle\" alias Bundle as source\r\n"
        + "uses \"http://hl7.org/fhir/StructureDefinition/DiagnosticReport\" alias DiagnosticReport as source\r\n"
        + "uses \"http://hl7.org/fhir/StructureDefinition/Observation\" alias Observation as source\r\n"
        + "\r\n"
        + "uses \"http://hl7.org/fhir/StructureDefinition/Composition\" alias Composition as target\r\n"
        + "uses \"http://hl7.org/fhir/StructureDefinition/Section\" alias Section as target\r\n"
        + "\r\n"
        + "\r\n"
        + "group bundle(source bundle : Bundle, target composition: Composition) {\r\n"
        + "  bundle.entry as entry where $this.resource.ofType(FHIR.DiagnosticReport) -> composition.section as section then {\r\n"
        + "    entry.resource as report -> section.title = ('lab report ' & %report.id) then {\r\n"
        + "      report.result as result then {\r\n"
        + "        result log('Reference: ' & %result.reference) -> evaluate(result, resolve()) as observation, section.section as subsection then labResult(observation, subsection) \"result\";\r\n"
        + "      };\r\n"
        + "    };\r\n"
        + "  };\r\n"
        + "}\r\n"
        + "\r\n"
        + "group labResult(source observation : Observation, target section: Section) {\r\n"
        + "  observation.id as id -> section.title = ('lab result ' & %id);\r\n"
        + "  observation.code as code -> section.code = code;\r\n"
        + "}";
    
    String bundle = "{\r\n"
        + "    \"resourceType\": \"Bundle\",\r\n"
        + "    \"id\": \"bundle-1\",\r\n"
        + "    \"type\": \"searchset\",\r\n"
        + "    \"entry\": [{\r\n"
        + "        \"fullUrl\": \"http://localhost:8000/Patient/1\",\r\n"
        + "        \"resource\": {\r\n"
        + "          \"resourceType\": \"Patient\",\r\n"
        + "          \"id\": \"1\"\r\n"
        + "        }\r\n"
        + "    },\r\n"
        + "    {\r\n"
        + "        \"fullUrl\": \"http://localhost:8000/DiagnosticReport/2\",\r\n"
        + "        \"resource\": {\r\n"
        + "            \"resourceType\": \"DiagnosticReport\",\r\n"
        + "            \"id\": \"2\",\r\n"
        + "            \"status\": \"final\",\r\n"
        + "            \"code\": {\r\n"
        + "                \"coding\": [{\r\n"
        + "                    \"system\": \"http://snomed.info/sct\",\r\n"
        + "                    \"code\": \"15220000\"\r\n"
        + "                }]\r\n"
        + "            },\r\n"
        + "            \"subject\": {\r\n"
        + "                \"reference\": \"Patient/1\"\r\n"
        + "            },\r\n"
        + "            \"result\": [\r\n"
        + "                {\r\n"
        + "                    \"reference\": \"Observation/3\"\r\n"
        + "                },\r\n"
        + "                {\r\n"
        + "                    \"reference\": \"Observation/4\"\r\n"
        + "                }\r\n"
        + "            ]\r\n"
        + "        }\r\n"
        + "    },\r\n"
        + "    {\r\n"
        + "        \"fullUrl\": \"http://localhost:8000/Observation/3\",\r\n"
        + "        \"resource\": {\r\n"
        + "            \"resourceType\": \"Observation\",\r\n"
        + "            \"id\": \"3\",\r\n"
        + "            \"status\": \"final\",\r\n"
        + "            \"code\": {\r\n"
        + "                \"coding\": [\r\n"
        + "                    {\r\n"
        + "                        \"system\": \"https://loinc.org\",\r\n"
        + "                        \"code\": \"11502-2\"\r\n"
        + "                    }\r\n"
        + "                ]\r\n"
        + "            },\r\n"
        + "            \"subject\": {\r\n"
        + "                \"reference\": \"Patient/1\"\r\n"
        + "            }\r\n"
        + "        }\r\n"
        + "    },\r\n"
        + "    {\r\n"
        + "        \"fullUrl\": \"http://localhost:8000/Observation/4\",\r\n"
        + "        \"resource\": {\r\n"
        + "            \"resourceType\": \"Observation\",\r\n"
        + "            \"id\": \"4\",\r\n"
        + "            \"status\": \"final\",\r\n"
        + "            \"code\": {\r\n"
        + "                \"coding\": [\r\n"
        + "                    {\r\n"
        + "                        \"system\": \"https://loinc.org\",\r\n"
        + "                        \"code\": \"6298-4\"\r\n"
        + "                    }\r\n"
        + "                ]\r\n"
        + "            },\r\n"
        + "            \"subject\": {\r\n"
        + "                \"reference\": \"Patient/1\"\r\n"
        + "            }\r\n"
        + "        }\r\n"
        + "    },\r\n"
        + "    {\r\n"
        + "        \"fullUrl\": \"http://localhost:8000/DiagnosticReport/5\",\r\n"
        + "        \"resource\": {\r\n"
        + "            \"resourceType\": \"DiagnosticReport\",\r\n"
        + "            \"id\": \"5\",\r\n"
        + "            \"status\": \"final\",\r\n"
        + "            \"code\": {\r\n"
        + "                \"coding\": [{\r\n"
        + "                    \"system\": \"http://snomed.info/sct\",\r\n"
        + "                    \"code\": \"15220000\"\r\n"
        + "                }]\r\n"
        + "            },\r\n"
        + "            \"subject\": {\r\n"
        + "                \"reference\": \"Patient/1\"\r\n"
        + "            },\r\n"
        + "            \"result\": [\r\n"
        + "                {\r\n"
        + "                    \"reference\": \"urn:uuid:9d1714da-b7e6-455b-bfd2-69ce0ff5fb12\"\r\n"
        + "                }\r\n"
        + "            ]\r\n"
        + "        }\r\n"
        + "    },\r\n"
        + "    {\r\n"
        + "        \"fullUrl\": \"urn:uuid:9d1714da-b7e6-455b-bfd2-69ce0ff5fb12\",\r\n"
        + "        \"resource\": {\r\n"
        + "            \"resourceType\": \"Observation\",\r\n"
        + "            \"status\": \"final\",\r\n"
        + "            \"code\": {\r\n"
        + "                \"coding\": [\r\n"
        + "                    {\r\n"
        + "                        \"system\": \"https://loinc.org\",\r\n"
        + "                        \"code\": \"41656-0\"\r\n"
        + "                    }\r\n"
        + "                ]\r\n"
        + "            },\r\n"
        + "            \"subject\": {\r\n"
        + "                \"reference\": \"Patient/1\"\r\n"
        + "            }\r\n"
        + "        }\r\n"
        + "    }]\r\n"
        + "}";
    
    StructureMap r = new StructureMapUtilities(context).parse(map, "Bundle2Composition");
    context.cacheResource(r);       
    ByteProvider byteSource = ByteProvider.forBytes(bundle.getBytes());
    org.hl7.fhir.r5.elementmodel.Element element = validationEngine.transform(byteSource, FhirFormat.JSON, r.getUrl());
    
    ByteArrayOutputStream s = new ByteArrayOutputStream();
    new org.hl7.fhir.r5.elementmodel.JsonParser(context).compose(element, s, IParser.OutputStyle.PRETTY, null);
    Composition comp = (Composition) new JsonParser().parse(s.toString());
    //System.out.println(s.toString());
    assertEquals(2,  comp.getSection().get(0).getSection().size());
    assertEquals(1,  comp.getSection().get(1).getSection().size());
  }
}