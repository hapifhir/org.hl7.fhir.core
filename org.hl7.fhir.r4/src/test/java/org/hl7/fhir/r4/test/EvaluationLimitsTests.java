package org.hl7.fhir.r4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.utils.LiquidEngine;
import org.hl7.fhir.r4.utils.LiquidEngine.LiquidDocument;
import org.hl7.fhir.utilities.ExecutionLimits;
import org.hl7.fhir.utilities.LimitedExecutionContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * FHIRPath and Liquid come from content, and can be written so they never finish, or run out of memory. The same
 * limits as R5 (see ExecutionLimits): these need nothing from packages
 */
class EvaluationLimitsTests {

  private static final String FIVE_HUNDRED = "(1).repeat(iif($this < 500, $this + 1, {}))";

  private static LimitedExecutionContext run(long maxMillis, int maxDepth, int maxItems, int maxStringLength) {
    return new LimitedExecutionContext(new ExecutionLimits(maxMillis, maxDepth, maxItems, maxStringLength)) {};
  }

  @Test
  void repeatThatNeverEndsIsStopped() throws IOException {
    FHIRPathEngine fp = new FHIRPathEngine(SimpleWorkerContext.fromNothing());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "(1).repeat($this + 1)"));
    assertTrue(e.getMessage().contains(Integer.toString(FHIRPathEngine.MAX_REPEAT_ROUNDS)), e.getMessage());
    assertEquals(499, fp.evaluate(new Patient(), FIVE_HUNDRED).size());
  }

  @Test
  void aStringThatDoublesIsStopped() throws IOException {
    FHIRPathEngine fp = new FHIRPathEngine(SimpleWorkerContext.fromNothing());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "'aaaaaaaaaa'.repeat($this + $this)"));
    assertTrue(e.getMessage().contains("string of more than"), e.getMessage());
  }

  @ParameterizedTest
  @ValueSource(longs = {Long.MAX_VALUE, 0, -1})
  void noTimeLimit(long maxMillis) throws IOException {
    FHIRPathEngine fp = new FHIRPathEngine(SimpleWorkerContext.fromNothing());
    fp.setMaxExecutionMillis(maxMillis);
    assertEquals("2", fp.evaluate(new Patient(), "1 + 1").get(0).primitiveValue());
  }

  @Test
  void anIncludeOfItselfIsStopped() throws IOException {
    LiquidEngine engine = new LiquidEngine(SimpleWorkerContext.fromNothing(), null);
    engine.setIncludeResolver((eng, name) -> "x{% include self a=1 %}");
    LiquidDocument doc = engine.parse("{% include self a=1 %}", "test");
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, new Patient(), null));
    assertTrue(e.getMessage().contains("nested too deeply"), e.getMessage());
  }

  /** the template's FHIRPath spends the template's budget */
  @Test
  void liquidsFHIRPathSharesTheTemplatesBudget() throws IOException {
    LiquidEngine engine = new LiquidEngine(SimpleWorkerContext.fromNothing(), null);
    LiquidDocument doc = engine.parse("{% loop i in " + FIVE_HUNDRED + " %}x{% endloop %}", "test");
    assertEquals(499, engine.evaluate(doc, new Patient(), null).length());
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, new Patient(), run(0, 0, 100, 0)));
    assertTrue(e.getMessage().contains("more than 100 items"), e.getMessage());
    e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, new Patient(), run(0, 0, 0, 100)));
    assertTrue(e.getMessage().contains("more than 100 characters"), e.getMessage());
  }
  // review round: the functions that make strings, the operators that compare collections, and split('')

  private static final String SEVENTY_FIVE = "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'";

  private static String eval(FHIRPathEngine fp, LimitedExecutionContext ctxt, String expr) {
    return fp.evaluate(ctxt, new Patient(), new Patient(), new Patient(), fp.parse(expr)).get(0).primitiveValue();
  }

  @Test
  void splitOnNothingGivesTheCharacters() throws IOException {
    FHIRPathEngine fp = new FHIRPathEngine(SimpleWorkerContext.fromNothing());
    // this used to go round for ever, making empty strings until memory ran out
    assertEquals("a|b|c", fp.evaluateToString(new Patient(), "'abc'.split('').join('|')"));
  }

  @Test
  void stringsThatAreTooLongAreStopped() throws IOException {
    FHIRPathEngine fp = new FHIRPathEngine(SimpleWorkerContext.fromNothing());
    // join()
    String join = SEVENTY_FIVE + ".toChars().join('-')";
    assertEquals(149, eval(fp, run(0, 0, 0, 1000), join).length());
    FHIRException e = assertThrows(FHIRException.class, () -> eval(fp, run(0, 0, 0, 100), join));
    assertTrue(e.getMessage().contains("string of more than 100"), e.getMessage());
    // a collection made into one string
    assertEquals(149, fp.evaluateToString(run(0, 0, 0, 1000), new Patient(), new Patient(), new Patient(), fp.parse(SEVENTY_FIVE + ".toChars()")).length());
    e = assertThrows(FHIRException.class, () -> fp.evaluateToString(run(0, 0, 0, 100), new Patient(), new Patient(), new Patient(), fp.parse(SEVENTY_FIVE + ".toChars()")));
    assertTrue(e.getMessage().contains("string of more than 100"), e.getMessage());
    // replaceMatches() with a regex that matches between every character
    String rm = "'aaaaaaaaaa'.replaceMatches('(?:)', 'bbbbbbbbbb')";
    assertEquals(120, eval(fp, run(0, 0, 0, 1000), rm).length());
    e = assertThrows(FHIRException.class, () -> eval(fp, run(0, 0, 0, 100), rm));
    assertTrue(e.getMessage().contains("string of more than 100"), e.getMessage());
    // encode() and escape() in repeat()
    e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "'aaaaaaaaaa'.repeat($this.encode('hex'))"));
    assertTrue(e.getMessage().contains("string of more than"), e.getMessage());
    e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "'\\\\'.repeat($this.escape('json'))"));
    assertTrue(e.getMessage().contains("string of more than"), e.getMessage());
  }

  /** ~, !~ and contains compare every item with every other: the time is checked inside them */
  @Test
  void comparingCollectionsIsTimed() throws IOException {
    FHIRPathEngine fp = new FHIRPathEngine(SimpleWorkerContext.fromNothing());
    assertEquals("true", fp.evaluateToString(new Patient(), "(1 | 2 | 3) ~ (3 | 2 | 1)"));
    for (String expr : new String[] {"(1 | 2 | 3) ~ (3 | 2 | 1)", "(1 | 2 | 3) !~ (3 | 2 | 1)", "(1 | 2 | 3) contains 2"}) {
      LimitedExecutionContext ctxt = run(50, 0, 0, 0);
      ctxt.getExecutionLimits().isOutOfTime(); // start the clock
      try {
        Thread.sleep(100);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      FHIRException e = assertThrows(FHIRException.class, () -> eval(fp, ctxt, expr));
      assertTrue(e.getMessage().contains("didn't finish"), e.getMessage());
    }
  }

  /**
   * In a loop that compares each item with every item of another list, the clock is read by the comparisons done, not
   * the passes of the outer loop: here 20 passes each compare against 300,000 identifiers, which (as 20 calls) used to
   * be too few to ever read the clock, so it ran to the end, however long that took
   */
  @Test
  void aLongPairwiseComparisonIsStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(SimpleWorkerContext.fromNothing());
    Patient big = new Patient();
    for (int i = 0; i < 300000; i++) {
      big.addIdentifier().setSystem("http://example.org/ids").setValue("id" + i);
    }
    Patient small = new Patient();
    for (int i = 0; i < 20; i++) {
      // each is the last of big's, so each pass of subsetOf() compares it with all of them
      small.addIdentifier().setSystem("http://example.org/ids").setValue("id299999");
    }
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(run(20, 0, 0, 0), small, big, small, fp.parse("identifier.subsetOf(%rootResource.identifier)")));
    assertTrue(e.getMessage().contains("didn't finish"), e.getMessage());
  }

  /** a statement whose value is a collection: its strings are added up as it's made */
  @Test
  void liquidStatementsThatAreTooLongAreStopped() throws IOException {
    LiquidEngine engine = new LiquidEngine(SimpleWorkerContext.fromNothing(), null);
    LiquidDocument doc = engine.parse("{{ " + SEVENTY_FIVE + ".toChars() }}", "test");
    assertTrue(engine.evaluate(doc, new Patient(), null).length() > 100);
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, new Patient(), run(0, 0, 0, 100)));
    assertTrue(e.getMessage().contains("more than 100"), e.getMessage());
  }
}
