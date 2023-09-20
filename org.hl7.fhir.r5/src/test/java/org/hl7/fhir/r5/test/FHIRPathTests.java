package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.NotImplementedException;
import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ValidatedFragment;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.utils.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FHIRPathTests {

  public enum TestResultType {OK, SYNTAX, SEMANTICS, EXECUTION}

  public class FHIRPathTestEvaluationServices implements IEvaluationContext {

    @Override
    public List<Base> resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveConstant), when item is element");
    }

    @Override
    public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveConstantType), when item is element");
    }

    @Override
    public boolean log(String argument, List<Base> focus) {
      return false;
    }

    @Override
    public FunctionDetails resolveFunction(String functionName) {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveFunction), when item is element (for " + functionName + ")");
    }

    @Override
    public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.checkFunction), when item is element");
    }

    @Override
    public List<Base> executeFunction(Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.executeFunction), when item is element");
    }

    @Override
    public Base resolveReference(Object appContext, String url, Base refContext) throws FHIRException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveReference), when item is element");
    }

    @Override
    public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
      if (url.equals("http://hl7.org/fhir/StructureDefinition/Patient"))
        return true;
      if (url.equals("http://hl7.org/fhir/StructureDefinition/Person"))
        return false;
      throw new FHIRException("unknown profile " + url);

    }

    @Override
    public ValueSet resolveValueSet(Object appContext, String url) {
      return TestingUtilities.getSharedWorkerContext().fetchResource(ValueSet.class, url);
    }

  }

  private static FHIRPathEngine fp;
  private final Map<String, Resource> resources = new HashMap<String, Resource>();

  @BeforeAll
  public static void setUp() {
    fp = new FHIRPathEngine(TestingUtilities.getSharedWorkerContext());
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, SAXException, IOException {
    Document dom = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "fhirpath", "tests-fhir-r5.xml"));

    List<Element> list = new ArrayList<Element>();
    List<Element> groups = new ArrayList<Element>();
    XMLUtil.getNamedChildren(dom.getDocumentElement(), "group", groups);
    for (Element g : groups) {
      XMLUtil.getNamedChildren(g, "test", list);
      XMLUtil.getNamedChildren(g, "modeTest", list);
    }

    List<Arguments> objects = new ArrayList<>();
    for (Element e : list) {
      objects.add(Arguments.of(getName(e), e));
    }

    return objects.stream();
  }

  private static Object getName(Element e) {
    String s = e.getAttribute("name");
    Element p = (Element) e.getParentNode();
    int ndx = 0;
    for (int i = 0; i < p.getChildNodes().getLength(); i++) {
      Node c = p.getChildNodes().item(i);
      if (c == e) {
        break;
      } else if (c instanceof Element) {
        ndx++;
      }
    }
    if (Utilities.noString(s)) {
      s = "?? - G " + p.getAttribute("name") + "[" + Integer.toString(ndx + 1) + "]";
    } else {
      s = s + " - G " + p.getAttribute("name") + "[" + Integer.toString(ndx + 1) + "]";
    }
    return s;
  }

  @SuppressWarnings("deprecation")
  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String name, Element test) throws FileNotFoundException, IOException, FHIRException, org.hl7.fhir.exceptions.FHIRException, UcumException {
    // Setting timezone for this test. Grahame is in UTC+11, Travis is in GMT, and I'm here in Toronto, Canada with
    // all my time based tests failing locally...
    TimeZone.setDefault(TimeZone.getTimeZone("UTC+1100"));

    fp.setHostServices(new FHIRPathTestEvaluationServices());
    String input = test.getAttribute("inputfile");
    String expression = XMLUtil.getNamedChild(test, "expression").getTextContent();
    TestResultType fail = TestResultType.OK;
    if ("syntax".equals(XMLUtil.getNamedChild(test, "expression").getAttribute("invalid"))) {
      fail = TestResultType.SYNTAX;
    } else if ("semantic".equals(XMLUtil.getNamedChild(test, "expression").getAttribute("invalid"))) {
      fail = TestResultType.SEMANTICS;      
    } else if ("execution".equals(XMLUtil.getNamedChild(test, "expression").getAttribute("invalid"))) {
      fail = TestResultType.EXECUTION;      
    };
    fp.setAllowPolymorphicNames("lenient/polymorphics".equals(test.getAttribute("mode")));
    Resource res = null;

    List<Base> outcome = new ArrayList<Base>();

    System.out.println(name);

    ExpressionNode node = null;
    try {
      node = fp.parse(expression);
      Assertions.assertTrue(fail != TestResultType.SYNTAX, String.format("Expected exception didn't occur parsing %s", expression));
    } catch (Exception e) {
      System.out.println("Parsing Error: "+e.getMessage());
      Assertions.assertTrue(fail == TestResultType.SYNTAX, String.format("Unexpected exception parsing %s: " + e.getMessage(), expression));
    }
    
    if (node != null) {
      if (!Utilities.noString(input)) {
        res = resources.get(input);
        if (res == null) {
          if (input.endsWith(".json")) {
            res = new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", input));              
          } else {
            res = new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", input));
          }
          resources.put(input, res);
        }        
      }
      
      try {
        if (Utilities.noString(input)) {
          fp.check(null, null, node);
        } else {
          fp.check(res, res.getResourceType().toString(), res.getResourceType().toString(), node);
        }
        Assertions.assertTrue(fail != TestResultType.SEMANTICS, String.format("Expected exception didn't occur checking %s", expression));
      } catch (Exception e) {
        System.out.println("Checking Error: "+e.getMessage());
        Assertions.assertTrue(fail == TestResultType.SEMANTICS, String.format("Unexpected exception checking %s: " + e.getMessage(), expression));
        node = null;
      }
    }
    
    if (node != null) {
      try {
        if ("element".equals(test.getAttribute("mode"))) {
          List<ValidatedFragment> e = Manager.parse(fp.getWorker(), TestingUtilities.loadTestResourceStream("r5", input), input.endsWith(".json") ? FhirFormat.JSON : FhirFormat.XML);                        
          outcome = fp.evaluate(e.get(0).getElement(), node);
        } else {
          outcome = fp.evaluate(res, node);
        }
        Assertions.assertTrue(fail == TestResultType.OK, String.format("Expected exception didn't occur executing %s", expression));
      } catch (Exception e) {
        System.out.println("Execution Error: "+e.getMessage());
        Assertions.assertTrue(fail == TestResultType.EXECUTION, String.format("Unexpected exception executing %s: " + e.getMessage(), expression));
        node = null;
      }
    }

    if (fp.hasLog()) {
      System.out.println(name);
      System.out.println(fp.takeLog());
    }

    if (node != null) {
      if ("true".equals(test.getAttribute("predicate"))) {
        boolean ok = fp.convertToBoolean(outcome);
        outcome.clear();
        outcome.add(new BooleanType(ok));
      }

      List<Element> expected = new ArrayList<Element>();
      XMLUtil.getNamedChildren(test, "output", expected);
      assertEquals(outcome.size(), expected.size(), String.format("Expected %d objects but found %d for expression %s", expected.size(), outcome.size(), expression));
      if ("false".equals(test.getAttribute("ordered"))) {
        for (int i = 0; i < Math.min(outcome.size(), expected.size()); i++) {
          String tn = outcome.get(i).fhirType();
          String s;
          if (outcome.get(i) instanceof Quantity) {
            s = fp.convertToString(outcome.get(i));
          } else {
            s = ((PrimitiveType) outcome.get(i)).asStringValue();
          }
          boolean found = false;
          for (Element e : expected) {
            if ((Utilities.noString(e.getAttribute("type")) || e.getAttribute("type").equals(tn)) &&
                (Utilities.noString(e.getTextContent()) || e.getTextContent().equals(s))) {
              found = true;
            }
          }
          Assertions.assertTrue(found, String.format("Outcome %d: Value %s of type %s not expected for %s", i, s, tn, expression));
        }
      } else {
        for (int i = 0; i < Math.min(outcome.size(), expected.size()); i++) {
          String tn = expected.get(i).getAttribute("type");
          if (!Utilities.noString(tn)) {
            assertEquals(tn, outcome.get(i).fhirType(), String.format("Outcome %d: Type should be %s but was %s", i, tn, outcome.get(i).fhirType()));
          }
          String v = expected.get(i).getTextContent();
          if (!Utilities.noString(v)) {
            if (outcome.get(i) instanceof Quantity) {
              Quantity q = fp.parseQuantityString(v);
              Assertions.assertTrue(outcome.get(i).equalsDeep(q), String.format("Outcome %d: Value should be %s but was %s", i, v, outcome.get(i).toString()));
            } else {
              Assertions.assertTrue(outcome.get(i) instanceof PrimitiveType, String.format("Outcome %d: Value should be a primitive type but was %s", i, outcome.get(i).fhirType()));
              if (!(v.equals(((PrimitiveType) outcome.get(i)).fpValue()))) {
                System.out.println(name);
                System.out.println(String.format("Outcome %d: Value should be %s but was %s for expression %s", i, v, ((PrimitiveType) outcome.get(i)).fpValue(), expression));
              }
              assertEquals(v, ((PrimitiveType) outcome.get(i)).fpValue(), String.format("Outcome %d: Value should be %s but was %s for expression %s", i, v, ((PrimitiveType) outcome.get(i)).fpValue(), expression));
            }
          }
        }
      }
    }
  }

  @Test
  @DisplayName("resolveConstant returns a list of Base")
  public void resolveConstantReturnsList() {
    final String DUMMY_CONSTANT_1 = "dummyConstant1";
    final String DUMMY_CONSTANT_2 = "dummyConstant2";
    fp.setHostServices(new FHIRPathTestEvaluationServices() {
      @Override
      public List<Base> resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {

        return Arrays.asList(
          new StringType(DUMMY_CONSTANT_1).noExtensions(),
          new StringType(DUMMY_CONSTANT_2).noExtensions());
      }
    });

    ExpressionNode expressionNode = fp.parse("%dummyConstant");

    List<Base> result = fp.evaluate(null, expressionNode);
    assertEquals(2, result.size());
    assertEquals(DUMMY_CONSTANT_1, result.get(0).primitiveValue());
    assertEquals(DUMMY_CONSTANT_2, result.get(1).primitiveValue());
  }

  @Test
  public void testEvaluate_Id() {
    Patient input = new Patient();
    input.setId(new IdType("http://base/Patient/123/_history/222"));
    List<Base> results = fp.evaluate(input, "Patient.id");
    assertEquals(1, results.size());
    assertEquals("123", results.get(0).toString());
  }
}