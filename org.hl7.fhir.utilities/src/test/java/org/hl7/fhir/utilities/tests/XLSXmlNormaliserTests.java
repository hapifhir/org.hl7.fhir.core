package org.hl7.fhir.utilities.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.xls.XLSXmlNormaliser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class XLSXmlNormaliserTests implements ResourceLoaderTests {

  @Test
  public void testConvert() throws FHIRException, TransformerException, ParserConfigurationException, SAXException, IOException {
    final String inputFileName = "observation-spreadsheet.xml";
    Path inputPath = Paths.get("target", inputFileName);

    copyResourceToFile(inputPath, inputFileName);

    XLSXmlNormaliser n = new XLSXmlNormaliser(inputPath.toString(), "target/observation-spreadsheet.out.xml", true);
    n.go();

    Assertions.assertTrue(true);
  }
}