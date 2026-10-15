package org.hl7.fhir.utilities.xhtml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

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

  // parseNode(XmlPullParser) - reached from the XML formats parsers - has no depth counter at
  // all, unlike parseElement/parseElementInner above. A deeply nested narrative recurses until
  // the stack is exhausted instead of failing with a FHIRFormatError.
  @Test
  void testDeeplyNestedDivFailsCleanlyFromPullParser() throws Exception {
    XmlPullParserFactory factory =
        XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
    factory.setNamespaceAware(true);
    factory.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, false);
    XmlPullParser xpp = factory.newPullParser();
    xpp.setInput(new ByteArrayInputStream(nestedDiv(20000).getBytes(StandardCharsets.UTF_8)), "UTF-8");
    while (xpp.next() != XmlPullParser.START_TAG) {
      // skip to the root element
    }
    Assertions.assertThrows(FHIRFormatError.class, () -> new XhtmlParser().parseHtmlNode(xpp));
  }

  // parseNode(Element, String) - the DOM walker reached from the element-model XML parsers - has
  // the same gap. 600 is over MAX_XHTML_DEPTH but under the jdk.xml.maxElementDepth of 1000 that
  // XMLUtil.parseToDom imposes, so the DOM builder hands the tree over rather than rejecting it
  // first.
  @Test
  void testDeeplyNestedDivFailsCleanlyFromDom() throws Exception {
    Element root = XMLUtil.parseToDom(nestedDiv(600), true).getDocumentElement();
    Assertions.assertThrows(FHIRFormatError.class, () -> new XhtmlParser().parseHtmlNode(root));
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
