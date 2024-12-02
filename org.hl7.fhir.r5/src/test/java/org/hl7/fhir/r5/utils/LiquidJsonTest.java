package org.hl7.fhir.r5.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.LiquidEngine.LiquidDocument;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LiquidJsonTest implements IEvaluationContext {

  private IWorkerContext ctxt;
  private ContextUtilities cu;
  private ProfileUtilities pu;

  @Test
  void testHistory() throws JsonException, IOException {
    init();

    JsonObject json = JsonParser.parseObject(TestingUtilities.loadTestResource("r5", "liquid-json", "history.json"));
    LiquidEngine liquid = new LiquidEngine(ctxt, this);
    LiquidDocument template = liquid.parse(TestingUtilities.loadTestResource("r5", "liquid-json", "history.liquid"), null);
    BaseJsonWrapper base = new BaseJsonWrapper(json);
    String s = liquid.evaluate(template, base, this).trim();
    String expected = TestingUtilities.loadTestResource("r5", "liquid-json", "history.html").trim();
    System.out.println(s);
    Assertions.assertEquals(expected, s);
  }
  
  @Test
  void testTestCases() throws JsonException, IOException {
    init();

    JsonObject json = JsonParser.parseObject(TestingUtilities.loadTestResource("r5", "liquid-json", "test-cases.json"));
    LiquidEngine liquid = new LiquidEngine(ctxt, this);
    LiquidDocument template = liquid.parse(TestingUtilities.loadTestResource("r5", "liquid-json", "test-cases.liquid"), null);
    BaseJsonWrapper base = new BaseJsonWrapper(json);
    String s = liquid.evaluate(template, base, this).trim();
    String expected = TestingUtilities.loadTestResource("r5", "liquid-json", "test-cases.html").trim();
    System.out.println(s);
    Assertions.assertEquals(expected, s);
  }

  public void init() {
    if (pu == null) {
      ctxt = TestingUtilities.getSharedWorkerContext();
      cu = new ContextUtilities(ctxt);
      pu = new ProfileUtilities(ctxt, null, cu);
    }
  }

  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, boolean beforeContext, boolean explicitConstant) throws PathEngineException {
    return new ArrayList<Base>();
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name,
      boolean explicitConstant) throws PathEngineException {
    return null;
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus,
      List<TypeDetails> parameters) throws PathEngineException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName,
      List<List<Base>> parameters) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext)
      throws FHIRException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url)
      throws FHIRException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean paramIsType(String name, int index) {
    // TODO Auto-generated method stub
    return false;
  }
}
