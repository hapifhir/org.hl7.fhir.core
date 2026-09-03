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

  private static final String DIV = "<div xmlns=\"http://www.w3.org/1999/xhtml\">";

  // An entity reference that runs into end-of-input must fail with a FHIRFormatError. Both
  // readUntil overloads used to test peekChar() != 0, but peekChar() returns END_OF_CHARS
  // ((char) -1) at EOF and does not consume, so the loop never terminated and appended
  // (char) -1 to the StringBuilder until the heap was exhausted. A few bytes were enough.
  @ParameterizedTest
  @ValueSource(strings = {
      DIV + "&",
      "<div xmlns=\"http://www.w3.org/1999/xhtml\" title=\"&",
  })
  void testTruncatedEntityFailsCleanly(String src) {
    Assertions.assertThrows(FHIRFormatError.class, () -> new XhtmlParser().parse(src, "div"));
  }

  // The same EOF path, reached where the partial entity is still resolvable, must simply
  // terminate. These parse leniently rather than throwing; the point is that they return.
  @ParameterizedTest
  @ValueSource(strings = {
      DIV + "text &amp",
      DIV + "<p>&#3",
  })
  void testTruncatedEntityTerminates(String src) throws FHIRFormatError, IOException {
    Assertions.assertNotNull(new XhtmlParser().parse(src, "div"));
  }

  // Guard the ordinary paths against an over-tight EOF check.
  @Test
  void testWellFormedEntitiesStillParse() throws FHIRFormatError, IOException {
    Assertions.assertNotNull(new XhtmlParser().parse(DIV + "a &amp; b</div>", "div"));
  }
}
