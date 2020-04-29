package org.hl7.fhir.dstu3.test;

import org.hl7.fhir.dstu3.context.SimpleWorkerContext;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.Base;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.ExpressionNode;
import org.hl7.fhir.dstu3.model.PrimitiveType;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.test.support.TestingUtilities;
import org.hl7.fhir.dstu3.utils.FHIRPathEngine;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Disabled // TODO Need to find and fix files referenced here
public class FluentPathTests {

  private FHIRPathEngine fp;

  @BeforeAll
  public void setup() throws IOException {
    TestingUtilities.context = SimpleWorkerContext.fromPack("C:\\work\\org.hl7.fhir\\build\\publish\\definitions.xml.zip");
    this.fp = new FHIRPathEngine(TestingUtilities.context);
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String name, Element element) throws IOException, FHIRException {
    String input = element.getAttribute("inputfile");
    String expression = XMLUtil.getNamedChild(element, "expression").getTextContent();
    boolean fail = "true".equals(XMLUtil.getNamedChild(element, "expression").getAttribute("invalid"));
    Resource res = null;

    List<Base> outcome = new ArrayList<Base>();

    ExpressionNode node = fp.parse(expression);
    try {
      if (Utilities.noString(input))
        fp.check(null, null, node);
      else {
        res = new XmlParser().parse(new FileInputStream(Utilities.path("C:\\work\\org.hl7.fhir\\build\\publish", input)));
        fp.check(res, res.getResourceType().toString(), res.getResourceType().toString(), node);
      }
      outcome = fp.evaluate(res, node);
      Assertions.assertTrue(!fail, String.format("Expected exception parsing %s", expression));
    } catch (Exception e) {
      Assertions.assertTrue(fail, String.format("Unexpected exception parsing %s: " + e.getMessage(), expression));
    }

    if ("true".equals(element.getAttribute("predicate"))) {
      boolean ok = fp.convertToBoolean(outcome);
      outcome.clear();
      outcome.add(new BooleanType(ok));
    }
    if (fp.hasLog())
      System.out.println(fp.takeLog());

    List<Element> expected = new ArrayList<Element>();
    XMLUtil.getNamedChildren(element, "output", expected);
    Assertions.assertTrue(outcome.size() == expected.size(), String.format("Expected %d objects but found %d", expected.size(), outcome.size()));
    for (int i = 0; i < Math.min(outcome.size(), expected.size()); i++) {
      String tn = expected.get(i).getAttribute("type");
      if (!Utilities.noString(tn)) {
        Assertions.assertTrue(tn.equals(outcome.get(i).fhirType()), String.format("Outcome %d: Type should be %s but was %s", i, tn, outcome.get(i).fhirType()));
      }
      String v = expected.get(i).getTextContent();
      if (!Utilities.noString(v)) {
        Assertions.assertTrue(outcome.get(i) instanceof PrimitiveType, String.format("Outcome %d: Value should be a primitive type but was %s", i, outcome.get(i).fhirType()));
        Assertions.assertTrue(v.equals(((PrimitiveType) outcome.get(i)).asStringValue()), String.format("Outcome %d: Value should be %s but was %s", i, v, outcome.get(i).toString()));
      }
    }
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, SAXException, IOException {
    Document dom = XMLUtil.parseFileToDom("C:\\work\\fluentpath\\tests\\stu3\\tests-fhir-r3.xml");

    List<Element> list = new ArrayList<Element>();
    List<Element> groups = new ArrayList<Element>();
    XMLUtil.getNamedChildren(dom.getDocumentElement(), "group", groups);
    for (Element g : groups) {
      XMLUtil.getNamedChildren(g, "test", list);
    }

    List<Arguments> objects = new ArrayList<>();
    for (Element e : list) {
      objects.add(Arguments.of(getName(e), e));
    }
    return objects.stream();
  }

  private static Object getName(Element e) {
    String s = e.getAttribute("name");
    if (Utilities.noString(s)) {
      Element p = (Element) e.getParentNode();
      int ndx = 0;
      for (int i = 0; i < p.getChildNodes().getLength(); i++) {
        Node c = p.getChildNodes().item(i);
        if (c == e)
          break;
        else if (c instanceof Element)
          ndx++;
      }
      s = p.getAttribute("name") + " - " + Integer.toString(ndx + 1);
    }
    return s;
  }
}
