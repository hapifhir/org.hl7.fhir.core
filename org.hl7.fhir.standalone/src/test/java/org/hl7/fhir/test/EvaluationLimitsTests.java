package org.hl7.fhir.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.services.liquid.LiquidEngine;
import org.hl7.fhir.services.liquid.LiquidEngine.LiquidDocument;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
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

  // these use an empty worker context: they need nothing from packages

  private static SimpleWorkerContext emptyContext() throws java.io.IOException {
    return new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
  }

  /** an app context that is the context of another run, with these limits (as Liquid's is, when it runs FHIRPath) */
  private static org.hl7.fhir.utilities.LimitedExecutionContext run(long maxMillis, int maxDepth, int maxItems, int maxStringLength) {
    return new org.hl7.fhir.utilities.LimitedExecutionContext(new org.hl7.fhir.utilities.ExecutionLimits(maxMillis, maxDepth, maxItems, maxStringLength)) {};
  }

  private static final String FIVE_HUNDRED = "(1).repeat(iif($this < 500, $this + 1, {}))";

  /** a huge time limit, or none, means no limit (a huge one used to overflow, and every evaluation timed out) */
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.ValueSource(longs = {Long.MAX_VALUE, 0, -1})
  void noTimeLimit(long maxMillis) throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    fp.setMaxExecutionMillis(maxMillis);
    assertEquals("2", fp.evaluate(new Patient(), "1 + 1").get(0).primitiveValue());
  }

  /** each round of this doubles the string: it would run out of memory long before 1000 rounds, or a minute */
  @Test
  void aStringThatDoublesIsStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "'aaaaaaaaaa'.repeat($this + $this)"));
    assertTrue(e.getMessage().contains("string of more than"), e.getMessage());
    e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "'aaaaaaaaaa'.repeat($this & $this)"));
    assertTrue(e.getMessage().contains("string of more than"), e.getMessage());
    e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "'aaaaaaaaaa'.repeat($this.replace('a', 'aa'))"));
    assertTrue(e.getMessage().contains("string of more than"), e.getMessage());
  }

  @Test
  void aCollectionThatIsTooBigIsStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(run(0, 0, 100, 0), new Patient(), new Patient(), new Patient(), fp.parse(FIVE_HUNDRED)));
    assertTrue(e.getMessage().contains("more than 100 items"), e.getMessage());
    assertEquals(499, fp.evaluate(run(0, 0, 1000, 0), new Patient(), new Patient(), new Patient(), fp.parse(FIVE_HUNDRED)).size());
  }

  /** distinct() and the like compare every item with every other, without evaluating anything: the time is checked in them too */
  @Test
  void slowFunctionsAreStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    org.hl7.fhir.utilities.LimitedExecutionContext ctxt = run(50, 0, 0, 0);
    ctxt.getExecutionLimits().isOutOfTime(); // start the clock
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    // out of time before it starts: refused at once
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(ctxt, new Patient(), new Patient(), new Patient(), fp.parse("(1 | 2 | 3).distinct()")));
    assertTrue(e.getMessage().contains("didn't finish"), e.getMessage());
  }

  /**
   * In a loop that compares each item with every item of another list, the clock is read by the comparisons done, not
   * the passes of the outer loop: here 20 passes each compare against 300,000 identifiers, which (as 20 calls) used to
   * be too few to ever read the clock, so it ran to the end, however long that took
   */
  @Test
  void aLongPairwiseComparisonIsStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
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

  /** when Liquid runs FHIRPath, the FHIRPath spends the template's budget, instead of getting one of its own */
  @Test
  void liquidsFHIRPathSharesTheTemplatesBudget() throws java.io.IOException {
    LiquidEngine engine = new LiquidEngine(emptyContext(), null);
    LiquidDocument doc = engine.parse("{{ " + FIVE_HUNDRED + ".count() }}", "test");
    assertEquals("499", engine.evaluate(doc, new Patient(), null));
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, new Patient(), run(0, 0, 100, 0)));
    assertTrue(e.getMessage().contains("more than 100 items"), e.getMessage());
  }

  @Test
  void liquidOutputThatIsTooLongIsStopped() throws java.io.IOException {
    LiquidEngine engine = new LiquidEngine(emptyContext(), null);
    LiquidDocument doc = engine.parse("{% for i in " + FIVE_HUNDRED + " %}xxxxx{% endfor %}", "test");
    assertEquals(2495, engine.evaluate(doc, new Patient(), null).length());
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, new Patient(), run(0, 0, 0, 1000)));
    assertTrue(e.getMessage().contains("more than 1000 characters"), e.getMessage());
    // a capture that doubles itself
    LiquidDocument dbl = engine.parse("{% assign x = 'xxxxxxxxxx' %}{% for i in " + FIVE_HUNDRED + " %}{% capture x %}{{x}}{{x}}{% endcapture %}{% endfor %}", "test");
    assertThrows(FHIRException.class, () -> engine.evaluate(dbl, new Patient(), null));
  }

  @Test
  void liquidNestingFollowsTheBudget() throws java.io.IOException {
    LiquidEngine engine = new LiquidEngine(emptyContext(), null);
    LiquidDocument doc = engine.parse(nestedIfs(5), "test");
    assertEquals("x", engine.evaluate(doc, new Patient(), null));
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, new Patient(), run(0, 3, 0, 0)));
    assertTrue(e.getMessage().contains("nested too deeply"), e.getMessage());
  }
  // review round: the functions and filters that make strings, the ones that compare collections, and split('')

  @Test
  void splitOnNothingGivesTheCharacters() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    // this used to go round for ever, making empty strings until memory ran out
    assertEquals("a|b|c", fp.evaluateToString(new Patient(), "'abc'.split('').join('|')"));
    assertEquals("1", fp.evaluateToString(new Patient(), "''.split('').count()"));
  }

  private static final String SEVENTY_FIVE = "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'";

  @Test
  void aJoinThatIsTooLongIsStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    String join = SEVENTY_FIVE + ".toChars().join('-')";
    assertEquals(149, fp.evaluate(run(0, 0, 0, 1000), new Patient(), new Patient(), new Patient(), fp.parse(join)).get(0).primitiveValue().length());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(run(0, 0, 0, 100), new Patient(), new Patient(), new Patient(), fp.parse(join)));
    assertTrue(e.getMessage().contains("string of more than 100"), e.getMessage());
  }

  /** evaluateToString() joins a collection: the run's limit on strings applies to that too */
  @Test
  void aCollectionMadeIntoAStringThatIsTooLongIsStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    org.hl7.fhir.services.fhirpath.ExpressionNode chars = fp.parse(SEVENTY_FIVE + ".toChars()");
    assertEquals(149, fp.evaluateToString(run(0, 0, 0, 1000), new Patient(), new Patient(), new Patient(), chars).length());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluateToString(run(0, 0, 0, 100), new Patient(), new Patient(), new Patient(), chars));
    assertTrue(e.getMessage().contains("string of more than 100"), e.getMessage());
  }

  /** encode() and escape() can make a string twice as long each time (hex, a \\ in json); in repeat() that would go on until memory ran out */
  @Test
  void encodingThatGrowsIsStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "'aaaaaaaaaa'.repeat($this.encode('hex'))"));
    assertTrue(e.getMessage().contains("string of more than"), e.getMessage());
    e = assertThrows(FHIRException.class, () -> fp.evaluate(new Patient(), "'\\\\'.repeat($this.escape('json'))"));
    assertTrue(e.getMessage().contains("string of more than"), e.getMessage());
    assertEquals("616263", fp.evaluateToString(new Patient(), "'abc'.encode('hex')"));
  }

  /** a regex that matches '' matches between every character: replaceMatches() can make a string any number of times longer */
  @Test
  void aReplaceMatchesThatIsTooLongIsStopped() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    String rm = "'aaaaaaaaaa'.replaceMatches('(?:)', 'bbbbbbbbbb')";
    assertEquals(120, fp.evaluate(run(0, 0, 0, 1000), new Patient(), new Patient(), new Patient(), fp.parse(rm)).get(0).primitiveValue().length());
    FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(run(0, 0, 0, 100), new Patient(), new Patient(), new Patient(), fp.parse(rm)));
    assertTrue(e.getMessage().contains("string of more than 100"), e.getMessage());
    assertEquals("axc", fp.evaluateToString(new Patient(), "'abc'.replaceMatches('b', 'x')"));
  }

  /** ~, !~ and contains compare every item with every other: the time is checked inside them, as in distinct() */
  @Test
  void comparingCollectionsIsTimed() throws java.io.IOException {
    FHIRPathEngine fp = new FHIRPathEngine(emptyContext());
    assertEquals("true", fp.evaluateToString(new Patient(), "(1 | 2 | 3) ~ (3 | 2 | 1)"));
    assertEquals("true", fp.evaluateToString(new Patient(), "(1 | 2 | 3) contains 2"));
    for (String expr : new String[] {"(1 | 2 | 3) ~ (3 | 2 | 1)", "(1 | 2 | 3) !~ (3 | 2 | 1)", "(1 | 2 | 3) contains 2"}) {
      org.hl7.fhir.services.fhirpath.ExpressionNode node = fp.parse(expr);
      org.hl7.fhir.utilities.LimitedExecutionContext ctxt = run(50, 0, 0, 0);
      ctxt.getExecutionLimits().isOutOfTime(); // start the clock
      try {
        Thread.sleep(100);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      FHIRException e = assertThrows(FHIRException.class, () -> fp.evaluate(ctxt, new Patient(), new Patient(), new Patient(), node));
      assertTrue(e.getMessage().contains("didn't finish"), e.getMessage());
    }
  }

  /** assign keeps a value, so a loop can double it each time round: each filter's value is checked as it's made */
  @Test
  void liquidValuesThatGrowAreStopped() throws java.io.IOException {
    LiquidEngine engine = new LiquidEngine(emptyContext(), null);
    LiquidDocument dbl = engine.parse("{% assign s = 'xxxxxxxxxx' %}{% for i in " + FIVE_HUNDRED + " %}{% assign s = s || append: s %}{% endfor %}{{ s.length() }}", "test");
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(dbl, new Patient(), null));
    assertTrue(e.getMessage().contains("more than"), e.getMessage());
    // replace can make a value far longer in one go; it's checked before it's made
    LiquidDocument rep = engine.parse("{{ 'aaaaaaaaaaaaaaaaaaaa' || replace: 'a', 'bbbbbbbbbb' }}", "test");
    assertEquals(200, engine.evaluate(rep, new Patient(), null).length());
    e = assertThrows(FHIRException.class, () -> engine.evaluate(rep, new Patient(), run(0, 100, 0, 100)));
    assertTrue(e.getMessage().contains("more than 100 characters"), e.getMessage());
    LiquidDocument join = engine.parse("{{ " + SEVENTY_FIVE + " || split: '' || join: '--' }}", "test");
    assertEquals(223, engine.evaluate(join, new Patient(), null).length());
    e = assertThrows(FHIRException.class, () -> engine.evaluate(join, new Patient(), run(0, 100, 0, 100)));
    assertTrue(e.getMessage().contains("more than 100 characters"), e.getMessage());
  }

  @Test
  void liquidUniqAndStripHtml() throws java.io.IOException {
    LiquidEngine engine = new LiquidEngine(emptyContext(), null);
    assertEquals("a-b-c", engine.evaluate(engine.parse("{{ 'a,b,a,c,b' || split: ',' || uniq || join: '-' }}", "test"), new Patient(), null));
    // as replaceAll("<[^>]*>", "") did: a < with no > after it stays
    assertEquals("x y <i", engine.evaluate(engine.parse("{{ '<b>x</b> <br/>y <i' || strip_html }}", "test"), new Patient(), null));
    // lots of <s and no >: this took as long as the square of the length
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < 200000; i++) {
      b.append('<');
    }
    engine.getVars().put("s", List.of(new org.hl7.fhir.model.core.StringType(b.toString())));
    long start = System.currentTimeMillis();
    assertEquals(200000, engine.evaluate(engine.parse("{{ s || strip_html }}", "test"), new Patient(), null).length());
    assertTrue(System.currentTimeMillis() - start < 5000);
  }

  /**
   * A template's output is limited (ExecutionLimits.DEFAULT_MAX_STRING_LENGTH), but a host that runs its own templates
   * over big values it built itself (the comparison pages) can lift the limit with setMaxStringLength
   */
  @Test
  void theOutputLimitCanBeLifted() {
    Patient p = new Patient();
    p.addName().setFamily("a".repeat(6000000));
    LiquidEngine engine = new LiquidEngine(TestingUtilities.getSharedWorkerContext(), null);
    LiquidDocument doc = engine.parse("{{ Patient.name.family }}{{ Patient.name.family }}", "test");
    FHIRException e = assertThrows(FHIRException.class, () -> engine.evaluate(doc, p, null));
    assertTrue(e.getMessage().contains("10000000"), e.getMessage());
    engine.setMaxStringLength(0);
    assertEquals(12000000, engine.evaluate(doc, p, null).length());
  }
}
