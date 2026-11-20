package org.hl7.fhir.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.services.liquid.LiquidEngine;
import org.hl7.fhir.services.liquid.LiquidEngine.LiquidDocument;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.Patient;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.Test;

/**
 * FHIRPath and Liquid come from content (invariants, narrative templates, pages), and can be written so they never
 * finish: repeat() stops after FHIRPathEngine.MAX_REPEAT_ROUNDS rounds, an evaluation stops after
 * FHIRPathEngine.MAX_EXECUTION_MILLIS, and Liquid can't nest more than LiquidEngine.MAX_DEPTH deep (includes
 * included), when it's parsed or when it's run
 */
class EvaluationLimitsTests {

  private static final String NESTED_REPEATS = "(1).repeat(iif($this < 1000, $this + 1, {})).select((1).repeat(iif($this < 1000, $this + 1, {})).count())";

  @Test
  void repeatThatNeverEndsIsStopped() {
    FHIRPathEngine fp = new FHIRPathEngine(TestingUtilities.getSharedWorkerContext());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "1.repeat($this + 1)"));
    assertTrue(e.getMessage().contains(Integer.toString(FHIRPathEngine.MAX_REPEAT_ROUNDS)), e.getMessage());
  }

  @Test
  void repeatThatEndsIsFine() {
    FHIRPathEngine fp = new FHIRPathEngine(TestingUtilities.getSharedWorkerContext());
    List<Base> res = fp.evaluate(new Patient(), "(1).repeat(iif($this < 5, $this + 1, {}))");
    assertEquals(4, res.size());
  }

  @Test
  void anEvaluationThatTakesTooLongIsStopped() {
    FHIRPathEngine fp = new FHIRPathEngine(TestingUtilities.getSharedWorkerContext());
    fp.setMaxExecutionMillis(200);
    long start = System.currentTimeMillis();
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), NESTED_REPEATS));
    assertTrue(e.getMessage().contains("didn't finish"), e.getMessage());
    assertTrue(System.currentTimeMillis() - start < 30000);
    // the time is for each evaluation: the next one starts again
    assertEquals("2", fp.evaluate(new Patient(), "1 + 1").get(0).primitiveValue());
  }

  @Test
  void anIncludeOfItselfIsStopped() {
    LiquidEngine engine = new LiquidEngine(TestingUtilities.getSharedWorkerContext(), null);
    engine.setIncludeResolver((eng, name) -> "x{% include self %}");
    LiquidDocument doc = engine.parse("{% include self %}", "test");
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, new Patient(), null));
    assertTrue(e.getMessage().contains("nested too deeply"), e.getMessage());
  }

  @Test
  void includesThatEndAreFine() {
    LiquidEngine engine = new LiquidEngine(TestingUtilities.getSharedWorkerContext(), null);
    engine.setIncludeResolver((eng, name) -> "a".equals(name) ? "[{% include b %}]" : "b");
    LiquidDocument doc = engine.parse("{% include a %}{% include a %}", "test");
    assertEquals("[b][b]", engine.evaluate(doc, new Patient(), null));
  }

  private static String nestedIfs(int depth) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      b.append("{% if true %}");
    }
    b.append("x");
    for (int i = 0; i < depth; i++) {
      b.append("{% endif %}");
    }
    return b.toString();
  }

  @Test
  void deepNestingIsStoppedWhenParsing() {
    LiquidEngine engine = new LiquidEngine(TestingUtilities.getSharedWorkerContext(), null);
    FHIRException e = assertThrows(FHIRException.class, () -> engine.parse(nestedIfs(LiquidEngine.MAX_DEPTH + 1), "test"));
    assertTrue(e.getMessage().contains("nested too deeply"), e.getMessage());
  }

  @Test
  void nestingUpToTheLimitIsFine() {
    LiquidEngine engine = new LiquidEngine(TestingUtilities.getSharedWorkerContext(), null);
    // the document itself is one level
    LiquidDocument doc = engine.parse(nestedIfs(LiquidEngine.MAX_DEPTH - 1), "test");
    assertEquals("x", engine.evaluate(doc, new Patient(), null));
  }
}
