package org.hl7.fhir.utilities.xhtml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Checks the nodes, attribute values, content and source locations the parser produces for
 * text, attribute values (quoted, unquoted, and spanning lines) and names, around line breaks,
 * entities, comments and CDATA.
 * The expected values were captured from the parser before it read runs of plain characters
 * straight from the source.
 */
class XhtmlParserLocationTests {

  private static void describe(XhtmlNode n, StringBuilder b) {
    XhtmlNode.Location l = n.getLocation();
    b.append(n.getNodeType() == NodeType.Element ? n.getName() : n.getNodeType().toString().toLowerCase()).append('@').append(l == null ? "?" : l.getLine() + ":" + l.getColumn());
    if (n.getAttributes() != null) {
      for (java.util.Map.Entry<String, String> e : n.getAttributes().entrySet()) {
        b.append(' ').append(e.getKey()).append("=[").append(e.getValue()).append(']');
      }
    }
    if (n.getContent() != null) {
      b.append(" [").append(n.getContent()).append(']');
    }
    b.append(';');
    if (n.hasChildren()) {
      for (XhtmlNode c : n.getChildNodes()) {
        describe(c, b);
      }
    }
  }

  private static String parse(String src) {
    try {
      StringBuilder b = new StringBuilder();
      describe(new XhtmlParser().parse(src, null), b);
      return b.toString();
    } catch (Exception e) {
      return "ERR " + e.getMessage();
    }
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of("<div xmlns=\"http://www.w3.org/1999/xhtml\"><p class=\"a b\" id='x'>Some plain text &amp; more text</p></div>",
        "document@?;div@1:2 xmlns=[http://www.w3.org/1999/xhtml];p@1:44 id=[x] class=[a b];text@1:64 [Some plain text & more text];"),
      Arguments.of("<div>\r\n  <p>line one\r\nline two\nline three\r\n</p>\r\n  <a href=\"x.html#y\" title=\"a &lt; b\">link</a>\r\n</div>",
        "document@?;div@1:2;text@1:5 [\r\n  ];p@2:5;text@2:6 [line one\r\nline two\nline three\r\n];text@5:2 [\r\n  ];a@6:5 href=[x.html#y] title=[a < b];text@6:39 [link];text@6:44 [\r\n];"),
      Arguments.of("<div><img src=unquoted alt=x/><input checked value=v/></div>",
        "document@?;div@1:2;img@1:7 src=[unquoted alt=x];input@1:32 checked=[null] value=[v];"),
      Arguments.of("<div data-long-attribute-name.with:chars_and-dashes=\"v\"><span>&#x41;&#66;&nbsp;tail</span></div>",
        "document@?;div@1:2 data-long-attribute-name.with:chars_and-dashes=[v];span@1:58;text@1:62 [AB\u00a0tail];"),
      Arguments.of("<div><p>unterminated <b>bold</p> after</div>",
        "ERR Malformed XHTML: Found \"</p>\" expecting \"</b>\" at line 1 column 33"),
      Arguments.of("<div>text<!-- a comment --><![CDATA[ cdata <x> ]]>more</div>",
        "document@?;div@1:2;text@1:5 [text];comment@1:10 [ a comment ];cdata@1:29 [ cdata <x> ];text@1:52 [more];"),
      Arguments.of("<div><p title=\"line one\r\nline two\nline three\">x</p><span class=\"a\r\n b\">y</span></div>",
        "document@?;div@1:2;p@1:7 title=[line one\r\nline two\nline three];text@3:12 [x];span@3:19 class=[a\r\n b];text@4:5 [y];"),
      Arguments.of("<div><a href=x.html?a=1&amp;b=2>link</a><img alt=a&amp;b/><br/></div>",
        "document@?;div@1:2;a@1:7 href=[x.html?a=1&b=2];text@1:32 [link];img@1:42 alt=[a&b];br@1:60;")
    );
  }

  @ParameterizedTest
  @MethodSource("cases")
  void nodesAndLocations(String source, String expected) {
    assertEquals(expected, parse(source));
  }
}
