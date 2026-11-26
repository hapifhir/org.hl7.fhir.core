package org.hl7.fhir.utilities.turtle;

import java.util.Map;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TurtleEmptyLiteralTests {

  // an empty literal ("" or '') must end at its second quote, not run on to the next quote in the document
  @ParameterizedTest
  @ValueSource(strings = {"\"", "'"})
  void testEmptyStringLiteral(String quote) throws FHIRFormatError {
    Turtle ttl = new Turtle();
    ttl.parse("<http://a.example/s> <http://a.example/p1> " + quote + quote
      + " ; <http://a.example/p2> " + quote + "x" + quote + " .");

    Assertions.assertEquals(1, ttl.getObjects().size());
    Map<String, Turtle.TTLObject> predicates = ttl.getObjects().values().iterator().next().getPredicates();
    Assertions.assertEquals("", ((Turtle.TTLLiteral) predicates.get("http://a.example/p1")).getValue());
    Assertions.assertEquals("x", ((Turtle.TTLLiteral) predicates.get("http://a.example/p2")).getValue());
  }
}
