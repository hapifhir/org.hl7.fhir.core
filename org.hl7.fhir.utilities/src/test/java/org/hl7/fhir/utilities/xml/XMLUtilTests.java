package org.hl7.fhir.utilities.xml;

import net.sf.saxon.trans.XPathException;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XMLUtilTests {
  @Test
  public void testDocumentBuilderThrowsExceptionForExternalEntity() throws ParserConfigurationException, IOException {
    DocumentBuilderFactory factory = XMLUtil.newXXEProtectedDocumentBuilderFactory();
    DocumentBuilder safeBuilder = factory.newDocumentBuilder();

    File file = ManagedFileAccess.file("src/test/resources/xml/evil-resource.xml");

    SAXParseException e = assertThrows(SAXParseException.class, ()-> safeBuilder.parse(file));
    assertThat(e.getMessage()).contains("DOCTYPE is disallowed");
  }

  @Test
  public void testTransformerFactoryThrowsExceptionForExternalEntity() throws ParserConfigurationException, IOException, SAXException, TransformerException {
    DocumentBuilderFactory factory = XMLUtil.newXXEProtectedDocumentBuilderFactory();
    DocumentBuilder safeBuilder = factory.newDocumentBuilder();

    File file = ManagedFileAccess.file("src/test/resources/xml/resource.xml");

    Document document = safeBuilder.parse(file);

    StringWriter sw = new StringWriter();
    TransformerFactory tf = XMLUtil.newXXEProtectedTransformerFactory();

    File templateFile = ManagedFileAccess.file("src/test/resources/xml/evil-transform.xslt");
    Source xsltSource = new StreamSource(templateFile);
    Transformer transformer = tf.newTransformer(xsltSource);
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

    XPathException e = assertThrows(XPathException.class, () -> transformer.transform(new DOMSource(document), new StreamResult(sw)));
    assertThat(e.getMessage()).contains("URIs using protocol file are not permitted");
  }

  @Test
  public void testSaxParserFactoryThrowsExceptionForExternalEntity() throws ParserConfigurationException, IOException, SAXException, TransformerException {

    SAXParserFactory spf = XMLUtil.newXXEProtectedSaxParserFactory();
    spf.setNamespaceAware(true);
    spf.setValidating(false);
    XMLReader xmlReader = XMLUtil.getXXEProtectedXMLReader(spf);

    File templateFile = ManagedFileAccess.file("src/test/resources/xml/evil-resource.xml");

    SAXParseException e = assertThrows(SAXParseException.class, () -> xmlReader.parse(new StreamSource(templateFile).getSystemId()));
    assertThat(e.getMessage()).contains("DOCTYPE is disallowed");
  }

  @SuppressWarnings("checkstyle:saxParserFactoryNewInstance")
  @Test
  public void testXMLReaderThrowsExceptionForExternalEntity() {
    SAXParserFactory spf = SAXParserFactory.newInstance();

    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> XMLUtil.getXXEProtectedXMLReader(spf));
    assertThat(e.getMessage()).contains("SAXParserFactory has insecure feature setting");
  }
}
