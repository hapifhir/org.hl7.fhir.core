package org.hl7.fhir.utilities.tests;

import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static org.junit.Assert.assertEquals;

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
    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">®</div>", node.getValueAsString());

    // Entity that appears in both
    node = new XhtmlNode();
    node.setValueAsString("<div>&lt;</div>");
    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">&lt;</div>", node.getValueAsString());
  }

  /**
   * See https://github.com/jamesagnew/hapi-fhir/issues/1658
   */
  @Test
  public void testLangAttributePreserved() {
    XhtmlNode dt = new XhtmlNode();
    dt.setValueAsString("<div xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en-US\">help i'm a bug</div>");
    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en-US\">help i'm a bug</div>", dt.getValueAsString());
    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en-US\">help i'm a bug</div>", new XhtmlNode().setValue(dt.getValue()).getValueAsString());
  }

  @Test
  public void testParseRsquo() {
    XhtmlNode dt = new XhtmlNode();
    dt.setValueAsString("It&rsquo;s January again");
    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">It’s January again</div>", dt.getValueAsString());
    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">It’s January again</div>", new XhtmlNode().setValue(dt.getValue()).getValueAsString());
  }

  @Test
  public void testProcessingInstructionNotPreserved() {
    XhtmlNode dt = new XhtmlNode();
    dt.setValueAsString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><div xmlns=\"http://www.w3.org/1999/xhtml\">help i'm a bug</div>");
    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">help i'm a bug</div>", dt.getValueAsString());
    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\">help i'm a bug</div>", new XhtmlNode().setValue(dt.getValue()).getValueAsString());
  }

  @Test
  public void testParseXhtmlQualified() {

    XhtmlNode node = new XhtmlNode();
    node.setValueAsString("<xhtml:div xmlns:xhtml=\"http://www.w3.org/1999/xhtml\">" +
      "<xhtml:img src=\"http://pbs.twimg.com/profile_images/544507893991485440/r_vo3uj2_bigger.png\" alt=\"Twitter Avatar\"/>" +
      "@fhirabend" +
      "</xhtml:div>");

    String output = node.getValueAsString();
    ourLog.info(output);

    assertEquals("<div xmlns=\"http://www.w3.org/1999/xhtml\"><img src=\"http://pbs.twimg.com/profile_images/544507893991485440/r_vo3uj2_bigger.png\" alt=\"Twitter Avatar\"/>@fhirabend</div>", output);
  }

  @Test
  public void testSerializable() throws IOException {
    XhtmlNode node = new XhtmlNode();
    node.setValueAsString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><div xmlns=\"http://www.w3.org/1999/xhtml\">Test</div>");

    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    ObjectOutputStream oout = new ObjectOutputStream(bout);
    oout.writeObject(node);
  }
}