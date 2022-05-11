package org.hl7.fhir.utilities.tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.xls.XLSXmlNormaliser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class XLSXmlNormaliserTests {

  @Test
  public void testConvert() throws FHIRException, TransformerException, ParserConfigurationException, SAXException, IOException {
    String path = XLSXmlNormaliserTests.class.getClassLoader().getResource("observation-spreadsheet.xml").getPath();

    XLSXmlNormaliser n = new XLSXmlNormaliser(path, "target/observation-spreadsheet.out.xml", true);
    n.go();
//    n = new XLSXmlNormaliser("C:\\work\\org.hl7.fhir\\build\\source\\observation\\observation-spreadsheet.before.xml", "C:\\\\work\\\\org.hl7.fhir\\\\build\\\\source\\\\observation\\\\observation-spreadsheet.before.out.xml", true);
//    n.go();
    Assertions.assertTrue(true);
  }
}