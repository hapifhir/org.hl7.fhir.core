package org.hl7.fhir.utilities.xhtml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XhtmlTests {

  @Test
  public void testToStringOnNullType()
  {
      XhtmlNode node = new XhtmlNode(null, "Blah");
      String actual = node.toString();
      assertTrue(actual.startsWith("org.hl7.fhir.utilities.xhtml.XhtmlNode@"), "toString() should return java the toString default method for objects, which starts with the full class name");
  }
}
