package org.hl7.fhir.utilities.turtle;

import java.util.Map;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TurtleLongLiteralTests {

  // the quotes of the opening """ or ''' must not also count towards the closing delimiter
  @ParameterizedTest
  @ValueSource(strings = {"\"", "'"})
  void testLongLiteralStartingWithQuotes(String quote) throws FHIRFormatError {
    String delimiter = quote + quote + quote;
    Turtle ttl = new Turtle();
    ttl.parse("<http://a.example/s> <http://a.example/p1> " + delimiter + delimiter
      + " ; <http://a.example/p2> " + delimiter + quote + "x" + delimiter + " .");

    Assertions.assertEquals(1, ttl.getObjects().size());
    Map<String, Turtle.TTLObject> predicates = ttl.getObjects().values().iterator().next().getPredicates();
    Assertions.assertEquals("", ((Turtle.TTLLiteral) predicates.get("http://a.example/p1")).getValue());
    Assertions.assertEquals(quote + "x", ((Turtle.TTLLiteral) predicates.get("http://a.example/p2")).getValue());
  }
}
