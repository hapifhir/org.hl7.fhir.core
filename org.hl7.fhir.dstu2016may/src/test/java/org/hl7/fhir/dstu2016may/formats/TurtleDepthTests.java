package org.hl7.fhir.dstu2016may.formats;

import java.io.ByteArrayOutputStream;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TurtleDepthTests {

  // "[ p1 [ p1 [ p1 ... o ] ] ] ." - each "[ p1 " opens one more level of recursion into
  // RdfGenerator.Section.importComplex (RdfGenerator.java), which is self-recursive on nested
  // "[ ... ]" blank-node objects and had no depth limit at all.
  private static String nestedBlankNodes(int depth) {
    StringBuilder b = new StringBuilder("s p ");
    b.append("[ p1 ".repeat(Math.max(0, depth)));
    b.append("o");
    b.append(" ]".repeat(Math.max(0, depth)));
    b.append(" .");
    return b.toString();
  }

  private static void importTtl(String ttl) throws Exception {
    RdfGenerator.Section section = new RdfGenerator(new ByteArrayOutputStream()).section("s");
    section.importTtl(ttl);
  }

  // A Turtle document nested far beyond any reasonable limit must fail with a FHIRFormatError,
  // never a StackOverflowError from the importComplex self-recursion.
  @ParameterizedTest
  @ValueSource(ints = {600, 5000, 50000})
  void testDeeplyNestedBlankNodesFailCleanly(int depth) {
    Assertions.assertThrowsExactly(FHIRFormatError.class, () -> importTtl(nestedBlankNodes(depth)));
  }

  // Nesting comfortably below any reasonable limit must still parse, guarding against a future
  // cap being too tight.
  @Test
  void testModeratelyNestedBlankNodesStillParse() throws Exception {
    importTtl(nestedBlankNodes(100));
  }
}
