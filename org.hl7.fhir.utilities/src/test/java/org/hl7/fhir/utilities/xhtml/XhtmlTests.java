package org.hl7.fhir.utilities.xhtml;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XhtmlTests {

  private static final String SOURCE_SCRIPT = 
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"+
          "<!DOCTYPE HTML>\r\n"+
          "<html xml:lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\">\r\n"+
          "  <head>\r\n"+
          "   <title>This</title>\r\n"+
          "    <script type=\"text/javascript\" src=\"fhir-table-scripts.js\"> </script>\r\n"+
          "  </head>\r\n"+
          "  <body onload=\"document.body.style.opacity='1'\">\r\n"+
          "   <script src=\"assets/js/prism.js\"></script>\r\n"+
          "<script>\r\n"+
          "    var statements = document.getElementById(\"statements\");\r\n"+
          "    var requirements = statements.getElementsByClassName(\"requirement\");\r\n"+
          "    for(var req of requirements) {\r\n"+
          "        req.innerHTML = req.innerHTML.replace(/\\[\\[([^\\]]+)\\]\\]/g, '<a href=\"Requirements-EHRSFMR2.1-\\$1.html\">\\$1</a>')\r\n"+
          "    }\r\n"+
          "    var description = document.getElementById(\"description\");\r\n"+
          "    description.innerHTML = description.innerHTML.replace(/&lt;/g,'<').replace(/&gt;/g,'>');\r\n"+
          "</script>\r\n"+
          "  </body>\r\n"+
          "</html>\r\n";
  private static final String CDATA_SOURCE = "\n" +
    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    "<!DOCTYPE HTML>\n" +
    "\n" +
    "<html xml:lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" dir=\"ltr\">\n" +
    "  <head>\n" +
    "    <title>IG Parameter Codes - FHIR Tooling Extensions IG v0.8.0</title>\n" +
    "  </head>\n" +
    "  <body onload=\"document.body.style.opacity='1'\">\n" +
    "\n" +
    "    <div class=\"col-12\">\n" +
    "    \n" +
    "<![CDATA[\n" +
    "  {\"resourceType\":\"CodeSystem\"}\n" +
    "]]>\n" +
    "  \n" +
    "\n" +
    "\n" +
    "</div>\n" +
    "  </body>\n" +
    "</html>\n" +
    "\n";

  @Test
  public void testToStringOnNullType()
  {
      XhtmlNode node = new XhtmlNode(null, "Blah");
      String actual = node.toString();
      assertTrue(actual.startsWith("org.hl7.fhir.utilities.xhtml.XhtmlNode@"), "toString() should return java the toString default method for objects, which starts with the full class name");
  }
  
  @Test
  public void testParseScript() throws FHIRFormatError, IOException {
    XhtmlNode x = new XhtmlParser().setMustBeWellFormed(true).parse(SOURCE_SCRIPT, "html"); 
    Assertions.assertTrue(x != null);
  }


  @Test
  public void testParseCData() throws FHIRFormatError, IOException {
    // test out handling of CData includes, and doctype comments
    XhtmlNode x = new XhtmlParser().setMustBeWellFormed(true).parse(CDATA_SOURCE, "html");
    Assertions.assertTrue(x != null);
    XhtmlNode body = x.firstNamedDescendent("body");
    Assertions.assertTrue(body != null);
    XhtmlNode div = body.firstNamedDescendent("div");
    Assertions.assertTrue(div != null);
    XhtmlNode cdata = null;
    for (XhtmlNode c : div.getChildNodes()) {
      if (c.getNodeType() == NodeType.CData) {
        cdata = c;
      }
    }
    Assertions.assertTrue(cdata != null);
    Assertions.assertEquals("\n  {\"resourceType\":\"CodeSystem\"}\n", cdata.getContent());
  }

}
