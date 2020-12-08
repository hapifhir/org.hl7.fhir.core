package org.hl7.fhir.r5.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.InstanceValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class FHIRMappingLanguageTests {

  private List<Resource> outputs = new ArrayList<Resource>();

  static private ValidationEngine validationEngine;

  static private SimpleWorkerContext context;

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
    validationEngine = new ValidationEngine("hl7.fhir.r4.core#4.0.1");
    context = validationEngine.getContext();
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "any.xml"), "any.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ii.xml"), "ii.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "cd.xml"), "cd.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ce.xml"), "ce.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ed.xml"), "ed.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "st.xml"), "st.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "cda.xml"), "cda.xml", null);
    for (StructureDefinition sd : context.getStructures()) {
      if (!sd.hasSnapshot()) {
        System.out.println("generate snapshot for " + sd.getUrl());
        context.generateSnapshot(sd, true);
      }
    }
    if (context.getValidatorFactory() == null) {
      context.setValidatorFactory(new InstanceValidatorFactory());
    }
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void test(String name, String source, String map, String output) throws Exception {

    byte[] byteSource = TestingUtilities.loadTestResourceBytes("r5", "fml", source);
    String stringMap = TestingUtilities.loadTestResource("r5", "fml", map);
    String outputJson = TestingUtilities.loadTestResource("r5", "fml", output);
    String fileOutputRes = TestingUtilities.tempFile("fml", output) + ".out";
    String fileOutputResOrig = TestingUtilities.tempFile("fml", output) + ".orig.out";
    ByteArrayOutputStream s = null;
    outputs.clear();

    String msg = null;
    try {
      StructureMap r = new StructureMapUtilities(context).parse(stringMap, map);
      context.cacheResource(r);
      org.hl7.fhir.r5.elementmodel.Element element = validationEngine.transform(byteSource, FhirFormat.JSON, r.getUrl());
      s = new ByteArrayOutputStream();
      if (output.endsWith(".json"))
        new org.hl7.fhir.r5.elementmodel.JsonParser(context).compose(element, s, IParser.OutputStyle.PRETTY, null);
      else
        new org.hl7.fhir.r5.elementmodel.XmlParser(context).compose(element, s, IParser.OutputStyle.PRETTY, null);
      context.dropResource(r);
    } catch (Exception e) {
      assertTrue(e.getMessage(), false);
    }
    if (output.endsWith("json")) {
      msg = TestingUtilities.checkJsonSrcIsSame(s.toString(), outputJson);
    } else {
      TextFile.bytesToFile(s.toByteArray(), fileOutputRes);
      TextFile.bytesToFile(outputJson.getBytes(), fileOutputResOrig);
      msg = TestingUtilities.checkXMLIsSame(new FileInputStream(fileOutputRes), new FileInputStream(fileOutputResOrig));
    }
    if (!Utilities.noString(msg)) {
      System.out.print(s.toString());
    }
    assertTrue(msg, Utilities.noString(msg));
  }
}