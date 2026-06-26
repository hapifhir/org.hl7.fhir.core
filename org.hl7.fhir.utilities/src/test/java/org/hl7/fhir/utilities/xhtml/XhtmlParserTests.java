package org.hl7.fhir.utilities.xhtml;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class XhtmlParserTests {

  private static String nestedDiv(int depth) {
    StringBuilder b = new StringBuilder("<div xmlns=\"http://www.w3.org/1999/xhtml\">");
    for (int i = 0; i < depth; i++) b.append("<div>");
    b.append("x");
    for (int i = 0; i < depth; i++) b.append("</div>");
    b.append("</div>");
    return b.toString();
  }

  // A narrative nested far beyond MAX_XHTML_DEPTH must fail with a FHIRFormatError, never a
  // StackOverflowError from the parseElement/parseElementInner mutual recursion.
  @ParameterizedTest
  @ValueSource(ints = {600, 5000, 20000})
  void testDeeplyNestedDivFailsCleanly(int depth) {
    Assertions.assertThrows(FHIRFormatError.class, () -> new XhtmlParser().parse(nestedDiv(depth), "div"));
  }

  // Nesting comfortably below the limit must still parse, guarding against the cap being too tight.
  @Test
  void testModeratelyNestedDivStillParses() throws FHIRFormatError, IOException {
    Assertions.assertNotNull(new XhtmlParser().parse(nestedDiv(100), "div"));
  }
}
