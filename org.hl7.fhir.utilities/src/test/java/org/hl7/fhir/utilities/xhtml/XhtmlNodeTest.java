package org.hl7.fhir.utilities.xhtml;

import org.junit.Test;

import static org.junit.Assert.*;

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


}