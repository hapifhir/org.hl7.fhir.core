package org.hl7.fhir.r5.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.fhirpath.BaseHostServices;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.liquid.BaseJsonWrapper;
import org.hl7.fhir.r5.liquid.LiquidEngine;
import org.hl7.fhir.r5.liquid.LiquidEngine.LiquidDocument;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LiquidJsonTest extends BaseHostServices {

  private ContextUtilities cu;
  private ProfileUtilities pu;

  public LiquidJsonTest() {
    super(TestingUtilities.getSharedWorkerContext());
  }

  @Test
  void testHistory() throws JsonException, IOException {
    init();

    JsonObject json = JsonParser.parseObject(TestingUtilities.loadTestResource("r5", "liquid-json", "history.json"));
    LiquidEngine liquid = new LiquidEngine(context, this);
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
    LiquidEngine liquid = new LiquidEngine(context, this);
    LiquidDocument template = liquid.parse(TestingUtilities.loadTestResource("r5", "liquid-json", "test-cases.liquid"), null);
    BaseJsonWrapper base = new BaseJsonWrapper(json);
    String s = liquid.evaluate(template, base, this).trim();
    String expected = TestingUtilities.loadTestResource("r5", "liquid-json", "test-cases.html").trim();
    System.out.println(s);
    Assertions.assertEquals(expected, s);
  }

  public void init() {
    if (pu == null) {
      cu = new ContextUtilities(context);
      pu = new ProfileUtilities(context, null, cu);
    }
  }

  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    return new ArrayList<Base>();
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name,
                                         FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    return null;
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    // TODO Auto-generated method stub
    return false;
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


  public Base findContainingResource(Object appContext, Base item) {
    return null;
  }
}
