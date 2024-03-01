package org.hl7.fhir.utilities.tests;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XhtmlNodeTest {

  private static final Logger ourLog = LoggerFactory.getLogger(XhtmlNodeTest.class);

  /**
   * See https://github.com/jamesagnew/hapi-fhir/issues/1488
   */
  @Test
  public void testDontEncodeHtmlOnlyEntities() {

    // Entity that appears in XHTML not not in XML
    XhtmlNode node = new XhtmlNode();
    node.setValueAsString("<div>&reg;</div>");
    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">®</div>", node.getValueAsString());

    // Entity that appears in both
    node = new XhtmlNode();
    node.setValueAsString("<div>&lt;</div>");
    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">&lt;</div>", node.getValueAsString());
  }

  /**
   * See https://github.com/jamesagnew/hapi-fhir/issues/1658
   */
  @Test
  public void testLangAttributePreserved() {
    XhtmlNode dt = new XhtmlNode();
    dt.setValueAsString("<div xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en-US\">help i'm a bug</div>");
    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en-US\">help i'm a bug</div>", dt.getValueAsString());
    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en-US\">help i'm a bug</div>", new XhtmlNode().setValue(dt.getValue()).getValueAsString());
  }

  @Test
  public void testParseRsquo() {
    XhtmlNode dt = new XhtmlNode();
    dt.setValueAsString("It&rsquo;s January again");
    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">It’s January again</div>", dt.getValueAsString());
    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">It’s January again</div>", new XhtmlNode().setValue(dt.getValue()).getValueAsString());
  }

  @Test
  public void testProcessingInstructionNotPreserved() {
    XhtmlNode dt = new XhtmlNode();
    dt.setValueAsString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><div xmlns=\"http://www.w3.org/1999/xhtml\">help i'm a bug</div>");
    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">help i'm a bug</div>", dt.getValueAsString());
    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">help i'm a bug</div>", new XhtmlNode().setValue(dt.getValue()).getValueAsString());
  }

  @Test
  public void testParseXhtmlQualified() {

    XhtmlNode node = new XhtmlNode();
    node.setValueAsString("<xhtml:div xmlns:xhtml=\"http://www.w3.org/1999/xhtml\">" +
      "<xhtml:img src=\"http://pbs.twimg.com/profile_images/544507893991485440/r_vo3uj2_bigger.png\" alt=\"Twitter Avatar\"/>" +
      "@fhirabend" +
      "</xhtml:div>");

    String output = node.getValueAsString();
//    ourLog.info(output);

    Assertions.assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\"><img src=\"http://pbs.twimg.com/profile_images/544507893991485440/r_vo3uj2_bigger.png\" alt=\"Twitter Avatar\"/>@fhirabend</div>", output);
  }

  @Test
  public void testParseXXE() {
    XhtmlNode dt = new XhtmlNode();
    dt.setValueAsString("<div xmlns=\"http://www.w3.org/1999/xhtml\">\n      <!DOCTYPE foo [ <!ENTITY xxe SYSTEM \"file://xxe.txt\">]>\n <p>This is some narrative  &xxe;</p>\n    </div>");
  }
  
  @Test
  public void testSerializable() throws IOException {
    XhtmlNode node = new XhtmlNode();
    node.setValueAsString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><div xmlns=\"http://www.w3.org/1999/xhtml\">Test</div>");

    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    ObjectOutputStream oout = new ObjectOutputStream(bout);
    oout.writeObject(node);
  }
  
  @Test
  public void testParseBadChars() throws FHIRFormatError, IOException {
    XhtmlNode x = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "bad-chars.html"), "div");
  }  
  
  @Test
  public void testParseBadLink1() throws FHIRFormatError, IOException {
    XhtmlNode x = new XhtmlParser().setMustBeWellFormed(false).parse(BaseTestingUtilities.loadTestResource("xhtml", "bad-link.html"), "div");
  }
    
  @Test
  public void testParseBadLink2() throws FHIRFormatError, IOException {
    Assertions.assertThrows(FHIRException.class, () -> new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "bad-link.html"), "div"));
  }

  @Test
  public void testParseEntities() throws FHIRFormatError, IOException {
    XhtmlNode x = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "entities.html"), "div");

  }

  @Test
  public void testParseSvg() throws FHIRFormatError, IOException {
    XhtmlNode x = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "svg.html"), "svg");

    Assertions.assertEquals("http://www.w3.org/2000/svg", x.getChildNodes().get(1).getAttributes().get("xmlns"));
    Assertions.assertEquals("http://www.w3.org/1999/xlink", x.getChildNodes().get(1).getAttributes().get("xmlns:xlink"));
  }

  @Test
  public void testParseSvgNotRoot() throws FHIRFormatError, IOException {
    XhtmlNode x = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "non-root-svg.html"), "div");

    Assertions.assertEquals("http://www.w3.org/2000/svg", x.getChildNodes().get(0).getChildNodes().get(1).getAttributes().get("xmlns"));
    Assertions.assertEquals("http://www.w3.org/1999/xlink", x.getChildNodes().get(0).getChildNodes().get(1).getAttributes().get("xmlns:xlink"));
  }

  @Test
  public void testParseNamespacedSvgNotRoot() throws FHIRFormatError, IOException {
    XhtmlNode x = new XhtmlParser().parse(BaseTestingUtilities.loadTestResource("xhtml", "namespaced-non-root-svg.html"), "div");

    Assertions.assertEquals("http://www.w3.org/2000/svg", x.getChildNodes().get(0).getChildNodes().get(1).getAttributes().get("xmlns"));
    Assertions.assertEquals("http://www.w3.org/1999/xlink", x.getChildNodes().get(0).getChildNodes().get(1).getAttributes().get("xmlns:xlink"));
  }


  @Test
  public void testParseSvgElements() throws FHIRFormatError, IOException {
    String src = BaseTestingUtilities.loadTestResource("xhtml", "xhtml-empty-elements.xml");
    XhtmlNode x = new XhtmlParser().parse(src, "xml");
   
    
    String xml = new XhtmlComposer(false, false).compose(x);
    Assertions.assertEquals(src.trim(), xml.trim());
  }

  @Test
  public void testComposeScripted1() throws IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.para().tx("This is a paragraph");
    Assertions.assertEquals("<div><p>This is a paragraph</p></div>", new XhtmlComposer(true, false).compose(x));
  }
  
  @Test
  public void testComposeScripted2() throws IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode p = x.para();
    p.tx("This is ");
    p.tx("a paragraph");
    Assertions.assertEquals("<div><p>This is a paragraph</p></div>", new XhtmlComposer(true, false).compose(x));
  }

  @Test
  public void testComposeScripted3() throws IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode p = x.para();
    p.tx("This is a ");
    p.b().tx("long");
    p.tx(" paragraph");
    Assertions.assertEquals("<div><p>This is a <b>long</b> paragraph</p></div>", new XhtmlComposer(true, false).compose(x));
  }
  
  @Test
  public void testComposeScripted4() throws IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode p = x.para();
    p.param("long").b().tx("long");
    p.sentenceForParams("This <b>is</b> a <param name='long'/> paragraph");
    Assertions.assertEquals("<div><p>This <b>is</b> a <b>long</b> paragraph</p></div>", new XhtmlComposer(true, false).compose(x));
  }


  @Test
  public void testComposeScripted5() throws IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode p = x.para();
    p.param("long").b().tx("long");
    p.paramValue("count", "2");
    p.sentenceForParams("This <b>is</b> a <param name='long'/> paragraph<if test='count != 1'>s</if>");
    Assertions.assertEquals("<div><p>This <b>is</b> a <b>long</b> paragraphs</p></div>", new XhtmlComposer(true, false).compose(x));
  }


  @Test
  public void testComposeScripted6() throws IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode p = x.para();
    p.param("long").b().tx("long");
    p.paramValue("count", "1");
    p.sentenceForParams("This <b>is</b> a <param name='long'/> paragraph<if test='count != 1'>s</if>");
    Assertions.assertEquals("<div><p>This <b>is</b> a <b>long</b> paragraph</p></div>", new XhtmlComposer(true, false).compose(x));
  }

  @Test
  public void testEntityNumberGreaterThanFFFF_Decimal() throws IOException {
    XhtmlNode x = new XhtmlParser().parse("<div>&#128567;</div>", "div");
    Assertions.assertEquals("\uD83D\uDE37", x.getFirstElement().getChildNodes().get(0).getContent());
  }

  @Test
  public void testEntityNumberGreaterThanFFFF_Hex() throws IOException {
    XhtmlNode x = new XhtmlParser().parse("<div>&#x1F637;</div>", "div");
    Assertions.assertEquals("\uD83D\uDE37", x.getFirstElement().getChildNodes().get(0).getContent());
    String html = new XhtmlComposer(false).compose(x);
    Assertions.assertEquals("<div>&#x1F637;</div>", html);
  }


}