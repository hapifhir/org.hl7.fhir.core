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
}
