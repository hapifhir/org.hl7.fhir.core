package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests for the evaluate()/evaluateToBoolean() overloads that take a map of variables to put in
 * scope before evaluation - the ones the Questionnaire 'variable' extension uses (see #2404).
 */
public class FHIRPathVariablesTests {

  private static FHIRPathEngine fp;
  private static SimpleWorkerContext context;

  @BeforeAll
  public static void setUp() throws FileNotFoundException, FHIRException, IOException {
    context = new SimpleWorkerContext((SimpleWorkerContext) TestingUtilities.getSharedWorkerContext());
    if (fp == null) {
      fp = new FHIRPathEngine(context);
    }
  }

  @AfterAll
  static void tearDown() {
    fp = null;
    context = null;
  }

  private Patient patient() {
    Patient p = new Patient();
    p.addName().setFamily("Grieve").addGiven("Grahame");
    p.addName().setFamily("Smith").addGiven("Jane");
    return p;
  }

  private Map<String, List<Base>> vars(String name, Base value) {
    Map<String, List<Base>> map = new HashMap<>();
    map.put(name, new ArrayList<>(Arrays.asList(value)));
    return map;
  }

  @Test
  void testVariableIsInScope() {
    ExpressionNode node = fp.parse("%greeting");
    List<Base> res = fp.evaluate(null, null, null, patient(), node, vars("greeting", new StringType("hello")));
    Assertions.assertEquals(1, res.size());
    Assertions.assertEquals("hello", res.get(0).primitiveValue());
  }

  @Test
  void testVariableHoldsACollection() {
    Map<String, List<Base>> map = new HashMap<>();
    map.put("nums", new ArrayList<>(Arrays.asList(new IntegerType(1), new IntegerType(2), new IntegerType(3))));
    ExpressionNode node = fp.parse("%nums.count()");
    List<Base> res = fp.evaluate(null, null, null, patient(), node, map);
    Assertions.assertEquals(1, res.size());
    Assertions.assertEquals("3", res.get(0).primitiveValue());
  }

  @Test
  void testEmptyVariableIsEmptyNotAnError() {
    Map<String, List<Base>> map = new HashMap<>();
    map.put("nothing", new ArrayList<>());
    ExpressionNode node = fp.parse("%nothing.exists()");
    Assertions.assertFalse(fp.evaluateToBoolean(null, null, null, patient(), node, map));
  }

  @Test
  void testVariableUsedInAPredicate() {
    // the shape the Questionnaire variable extension actually gets used in: a value pulled out of
    // the resource, then used to select within it
    ExpressionNode node = fp.parse("Patient.name.where(family = %fam).given");
    List<Base> res = fp.evaluate(null, null, null, patient(), node, vars("fam", new StringType("Smith")));
    Assertions.assertEquals(1, res.size());
    Assertions.assertEquals("Jane", res.get(0).primitiveValue());
  }

  @Test
  void testEvaluateToBooleanSeesTheVariable() {
    ExpressionNode node = fp.parse("%age.exists()");
    Assertions.assertTrue(fp.evaluateToBoolean(null, null, null, patient(), node, vars("age", new IntegerType(57))));
  }

  @Test
  void testNullMapBehavesLikeTheOldOverload() {
    ExpressionNode node = fp.parse("Patient.name.family");
    List<Base> withNull = fp.evaluate(null, null, null, patient(), node, null);
    List<Base> without = fp.evaluate(null, (Base) null, (Base) null, patient(), node);
    Assertions.assertEquals(2, withNull.size());
    Assertions.assertEquals(without.size(), withNull.size());
  }

  @Test
  void testUnknownVariableStillFails() {
    // a variable that wasn't supplied must not quietly evaluate to empty - the caller needs to know
    ExpressionNode node = fp.parse("%notSupplied.exists()");
    Assertions.assertThrows(PathEngineException.class,
        () -> fp.evaluateToBoolean(null, null, null, patient(), node, vars("supplied", new StringType("x"))));
  }

  @Test
  void testCannotShadowASystemVariable() {
    ExpressionNode node = fp.parse("%resource.exists()");
    Assertions.assertThrows(PathEngineException.class,
        () -> fp.evaluateToBoolean(null, null, null, patient(), node, vars("resource", new StringType("nope"))));
  }
}
