package org.hl7.fhir.r5.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.NotImplementedException;
import org.fhir.ucum.UcumEssenceService;
import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.ExpressionNode;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import junit.framework.Assert;

@RunWith(Parameterized.class)
public class FHIRPathTests {

  public class FHIRPathTestEvaluationServices implements IEvaluationContext {

    @Override
    public Base resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
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
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveFunction), when item is element (for "+functionName+")");
    }

    @Override
    public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.checkFunction), when item is element");
    }

    @Override
    public List<Base> executeFunction(Object appContext, String functionName, List<List<Base>> parameters) {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.executeFunction), when item is element");
    }

    @Override
    public Base resolveReference(Object appContext, String url) throws FHIRException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveReference), when item is element");
    }

    @Override
    public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
      if (url.equals("http://hl7.org/fhir/StructureDefinition/Patient"))
        return true;
      if (url.equals("http://hl7.org/fhir/StructureDefinition/Person"))
        return false;
      throw new FHIRException("unknown profile "+url);
      
    }

  }

  private static FHIRPathEngine fp;

  @Parameters(name = "{index}: file {0}")
  public static Iterable<Object[]> data() throws ParserConfigurationException, SAXException, IOException {
    Document dom = XMLUtil.parseFileToDom(TestingUtilities.resourceNameToFile("fhirpath", "tests-fhir-r4.xml"));

    List<Element> list = new ArrayList<Element>();
    List<Element> groups = new ArrayList<Element>();
    XMLUtil.getNamedChildren(dom.getDocumentElement(), "group", groups);
    for (Element g : groups) {
      XMLUtil.getNamedChildren(g, "test", list);      
    }

    List<Object[]> objects = new ArrayList<Object[]>(list.size());

    for (Element e : list) {
      objects.add(new Object[] { getName(e), e });
    }

    return objects;
  }

  private static Object getName(Element e) {
    String s = e.getAttribute("name");
    Element p = (Element) e.getParentNode();
    int ndx = 0;
    for (int i = 0; i < p.getChildNodes().getLength(); i++) {
      Node c = p.getChildNodes().item(i);
      if (c == e)
        break;
      else if (c instanceof Element)
        ndx++;
    }
    if (Utilities.noString(s)) 
      s = "?? - G "+p.getAttribute("name")+"["+Integer.toString(ndx+1)+"]";
    else
      s = s + " - G "+p.getAttribute("name")+"["+Integer.toString(ndx+1)+"]";
    return s;
  }

  private final Element test;
  private final String name;
  private Map<String, Resource> resources = new HashMap<String, Resource>();

  public FHIRPathTests(String name, Element e) {
    this.name = name;
    this.test = e;
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws FileNotFoundException, IOException, FHIRException, org.hl7.fhir.exceptions.FHIRException, UcumException {
    if (fp == null)
      fp = new FHIRPathEngine(TestingUtilities.context());
    fp.setHostServices(new FHIRPathTestEvaluationServices());
    String input = test.getAttribute("inputfile");
    String expression = XMLUtil.getNamedChild(test, "expression").getTextContent();
    boolean fail = Utilities.existsInList(XMLUtil.getNamedChild(test, "expression").getAttribute("invalid"), "true", "semantic");
    Resource res = null;

    List<Base> outcome = new ArrayList<Base>();

    ExpressionNode node = fp.parse(expression);
    try {
      if (Utilities.noString(input))
        fp.check(null, null, node);
      else {
        res = resources.get(input);
        if (res == null) {
          res = new XmlParser().parse(new FileInputStream(TestingUtilities.resourceNameToFile(input)));
          resources.put(input, res);
        }
        fp.check(res, res.getResourceType().toString(), res.getResourceType().toString(), node);
      }
      outcome = fp.evaluate(res, node);
      Assert.assertTrue(String.format("Expected exception parsing %s", expression), !fail);
    } catch (Exception e) {
      Assert.assertTrue(String.format("Unexpected exception parsing %s: "+e.getMessage(), expression), fail);
    }

    if ("true".equals(test.getAttribute("predicate"))) {
      boolean ok = fp.convertToBoolean(outcome);
      outcome.clear();
      outcome.add(new BooleanType(ok));
    }
    if (fp.hasLog())
      System.out.println(fp.takeLog());

    List<Element> expected = new ArrayList<Element>();
    XMLUtil.getNamedChildren(test, "output", expected);
    Assert.assertTrue(String.format("Expected %d objects but found %d for expression %s", expected.size(), outcome.size(), expression), outcome.size() == expected.size());
    if ("false".equals(test.getAttribute("ordered"))) {
      for (int i = 0; i < Math.min(outcome.size(), expected.size()); i++) {
        String tn = outcome.get(i).fhirType();
        String s;
        if (outcome.get(i) instanceof Quantity)
          s = fp.convertToString(outcome.get(i));
        else
          s = ((PrimitiveType) outcome.get(i)).asStringValue();
        boolean found = false;
        for (Element e : expected) {
          if ((Utilities.noString(e.getAttribute("type")) || e.getAttribute("type").equals(tn)) &&
              (Utilities.noString(e.getTextContent()) || e.getTextContent().equals(s)))
            found = true;
        }
        Assert.assertTrue(String.format("Outcome %d: Value %s of type %s not expected for %s", i, s, tn, expression), found);
      }
    } else {
      for (int i = 0; i < Math.min(outcome.size(), expected.size()); i++) {
        String tn = expected.get(i).getAttribute("type");
        if (!Utilities.noString(tn)) {
          Assert.assertTrue(String.format("Outcome %d: Type should be %s but was %s", i, tn, outcome.get(i).fhirType()), tn.equals(outcome.get(i).fhirType()));
        }
        String v = expected.get(i).getTextContent();
        if (!Utilities.noString(v)) {
          if (outcome.get(i) instanceof Quantity) {
            Quantity q = fp.parseQuantityString(v);
            Assert.assertTrue(String.format("Outcome %d: Value should be %s but was %s", i, v, outcome.get(i).toString()), outcome.get(i).equalsDeep(q));
          } else {
            Assert.assertTrue(String.format("Outcome %d: Value should be a primitive type but was %s", i, outcome.get(i).fhirType()), outcome.get(i) instanceof PrimitiveType);
            Assert.assertTrue(String.format("Outcome %d: Value should be %s but was %s for expression %s", i, v, outcome.get(i).toString(), expression), v.equals(((PrimitiveType)outcome.get(i)).asStringValue()));
          }
        }
      }
    }
  }
}
