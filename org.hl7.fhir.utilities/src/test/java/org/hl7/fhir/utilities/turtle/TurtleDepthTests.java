package org.hl7.fhir.utilities.turtle;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TurtleDepthTests {

  // [ <p1> [ <p1> [ <p1> ... <o> ... ] ] ] . - each "[ <p1> " opens one more level of recursion
  // into parseComplex (Turtle.java:1234); the innermost predicate's object is a plain URI so the
  // document stays syntactically valid at every depth. Shape matches the proven-good
  // nested_blankNodePropertyLists.ttl fixture elsewhere in this package.
  private static String nestedBlankNodes(int depth) {
    StringBuilder b = new StringBuilder();
    b.append("[ <http://a.example/p1> ".repeat(Math.max(0, depth)));
    b.append("<http://a.example/o>");
    b.append("]".repeat(Math.max(0, depth)));
    b.append(" .");
    return b.toString();
  }

  // A Turtle document nested far beyond any reasonable limit must fail with a FHIRFormatError,
  // never a StackOverflowError from the parseComplex self-recursion.
  @ParameterizedTest
  @ValueSource(ints = {600, 5000, 50000})
  void testDeeplyNestedBlankNodesFailCleanly(int depth) {
    Assertions.assertThrowsExactly(FHIRFormatError.class, () -> new Turtle().parse(nestedBlankNodes(depth)));
  }

  // Nesting comfortably below any reasonable limit must still parse, guarding against a future
  // cap being too tight.
  @Test
  void testModeratelyNestedBlankNodesStillParse() throws FHIRFormatError {
    Turtle ttl = new Turtle();
    ttl.parse(nestedBlankNodes(100));
    Assertions.assertEquals(1, ttl.getObjects().size());
  }
}
