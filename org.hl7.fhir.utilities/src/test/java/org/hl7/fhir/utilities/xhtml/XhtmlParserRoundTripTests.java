package org.hl7.fhir.utilities.xhtml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * What the parser makes of input that exercises its look-ahead and error recovery (mis-matched end tags,
 * entities, comments, CDATA, attribute values), checked by composing the result again
 */
class XhtmlParserRoundTripTests {

  private static final String DIV = "<div xmlns=\"http://www.w3.org/1999/xhtml\">";

  private static Stream<Arguments> documents() {
    return Stream.of(
      Arguments.of(DIV + "<p>a <b>bold</b> c</p></div>",
        "<div xmlns=\"http://www.w3.org/1999/xhtml\"><p>a <b>bold</b> c</p></div>"),
      Arguments.of(DIV + "a &amp; b &lt; c &gt; &#169; &#x00A9; &nbsp;d</div>",
        "<div xmlns=\"http://www.w3.org/1999/xhtml\">a &amp; b &lt; c &gt; &copy; &copy; &nbsp;d</div>"),
      Arguments.of(DIV + "a<!-- a comment -->b<![CDATA[<x> & y]]>c</div>",
        "<div xmlns=\"http://www.w3.org/1999/xhtml\">a  <!-- a comment -->b  <![CDATA[<x> & y]]>c</div>"),
      Arguments.of(DIV + "<a href=\"x?a=1&amp;b=2\" title='say \"hi\"'>l</a><img src=\"i.png\" alt=\"pic\"/></div>",
        "<div xmlns=\"http://www.w3.org/1999/xhtml\"><a href=\"x?a=1&amp;b=2\" title=\"say &quot;hi&quot;\">l</a><img src=\"i.png\" alt=\"pic\"/></div>"),
      Arguments.of(DIV + "<table><tr><td>1</td><td>2</td></tr></table><br/><hr/></div>",
        "<div xmlns=\"http://www.w3.org/1999/xhtml\"><table><tr><td>1</td><td>2</td></tr></table><br/><hr/></div>")
    );
  }

  // when the xhtml doesn't have to be well formed, the parser recovers from end tags that don't match (these are
  // what it has always made of them, not necessarily the best reading)
  private static Stream<Arguments> malformedDocuments() {
    return Stream.of(
      // the <b> isn't closed before its parent is
      Arguments.of(DIV + "<p>a <b>bold</p><p>next</p></div>", "<div xmlns=\"http://www.w3.org/1999/xhtml\"><p>a <b></b>bold</p><p>next</p></div>"),
      // an end tag that matches nothing
      Arguments.of(DIV + "<p>a</span>b</p></div>", "<div xmlns=\"http://www.w3.org/1999/xhtml\"><p>ab</p></div>"),
      Arguments.of(DIV + "<ul><li>one<li>two</ul><p>after</div>", "<div xmlns=\"http://www.w3.org/1999/xhtml\"><ul><li></li>one<li></li>two</ul><p></p>after</div>")
    );
  }

  @ParameterizedTest
  @MethodSource("documents")
  void parseAndCompose(String source, String expected) throws IOException {
    Assertions.assertEquals(expected, new XhtmlComposer(false).compose(new XhtmlParser().parse(source, "div")));
  }

  @ParameterizedTest
  @MethodSource("malformedDocuments")
  void malformedIsRejectedWhenItMustBeWellFormed(String source, String expected) {
    Assertions.assertThrows(FHIRFormatError.class, () -> new XhtmlParser().parse(source, "div"));
  }

  @ParameterizedTest
  @MethodSource("malformedDocuments")
  void malformedIsRecoveredFrom(String source, String expected) throws IOException {
    Assertions.assertEquals(expected, new XhtmlComposer(false).compose(new XhtmlParser().setMustBeWellFormed(false).parse(source, "div")));
  }

  @Test
  void fragment() throws IOException {
    Assertions.assertEquals("<p>a <i>b</i> &amp; c<br/>d</p>",
      new XhtmlComposer(false).compose(new XhtmlParser().parseFragment("<p>a <i>b</i> &amp; c<br/>d</p>")));
  }

  @Test
  void utf8InputStream() throws IOException {
    byte[] bytes = (DIV + "Привет — ü</div>").getBytes(StandardCharsets.UTF_8);
    Assertions.assertEquals(DIV + "Привет — ü</div>",
      new XhtmlComposer(false).compose(new XhtmlParser().parse(new ByteArrayInputStream(bytes), "div")));
  }
}
