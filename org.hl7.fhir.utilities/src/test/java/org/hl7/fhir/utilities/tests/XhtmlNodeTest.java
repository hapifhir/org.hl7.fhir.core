package org.hl7.fhir.utilities.tests;

import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XhtmlNodeTest {

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



}