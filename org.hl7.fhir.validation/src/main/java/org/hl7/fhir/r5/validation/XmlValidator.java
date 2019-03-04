package org.hl7.fhir.r5.validation;

/*-
 * #%L
 * org.hl7.fhir.validation
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.CSFileInputStream;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.Logger.LogMessageType;
import org.hl7.fhir.utilities.SchemaInputSource;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlValidator {
  
  private Schema schema;
  private Map<String, byte[]> schemas;
  private Map<String, byte[]> transforms;
  private List<ValidationMessage> errors;
  private Logger logger;

  public class MyErrorHandler implements ErrorHandler {

    private List<String> errors = new ArrayList<String>();
    private List<ValidationMessage> list;
    private String path;

    public MyErrorHandler(List<ValidationMessage> list, String path) {
      this.list = list;
      this.path = path;
    }

    @Override
    public void error(SAXParseException arg0) throws SAXException {
      if (list != null)
        list.add(new ValidationMessage(Source.InstanceValidator, IssueType.STRUCTURE, arg0.getLineNumber(), arg0.getColumnNumber(), path == null ? arg0.getSystemId() : path, arg0.getMessage(), IssueSeverity.ERROR));
      if (logger != null)
        logger.log("error: " + arg0.toString(), LogMessageType.Error);
      errors.add(arg0.toString());
    }

    @Override
    public void fatalError(SAXParseException arg0) throws SAXException {
      if (list != null)
        list.add(new ValidationMessage(Source.InstanceValidator, IssueType.STRUCTURE, arg0.getLineNumber(), arg0.getColumnNumber(), path == null ? arg0.getSystemId() : path, arg0.getMessage(), IssueSeverity.FATAL));
      if (logger != null)
        logger.log("fatal error: " + arg0.toString(), LogMessageType.Error);
    }

    @Override
    public void warning(SAXParseException arg0) throws SAXException {
      if (list != null)
        list.add(new ValidationMessage(Source.InstanceValidator, IssueType.STRUCTURE, arg0.getLineNumber(), arg0.getColumnNumber(), path == null ? arg0.getSystemId() : path, arg0.getMessage(), IssueSeverity.WARNING));
    }

    public List<String> getErrors() {
      return errors;
    }

    public String getPath() {
      return path;
    }

    public void setPath(String path) {
      this.path = path;
    }
  }  
  
  public class MyResourceResolver implements LSResourceResolver {
    
    @Override
    public LSInput resolveResource(final String type, final String namespaceURI, final String publicId, String systemId, final String baseURI) {
      try {
        if (!schemas.containsKey(systemId))
          return null;
        return new SchemaInputSource(new ByteArrayInputStream(schemas.get(systemId)), publicId, systemId, namespaceURI);
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }
  }

  public XmlValidator(List<ValidationMessage> errors, Map<String, byte[]> schemas, Map<String, byte[]> transforms) throws FileNotFoundException, IOException, SAXException {
    this.errors = errors;
    this.schemas = schemas;
    this.transforms = transforms;
    load();
  }

  private void load() throws SAXException {
    int c = 0;
    for (String s : schemas.keySet())
      if (s.endsWith(".xsd")) 
        c++;
    StreamSource[] sources = new StreamSource[c];
    int i = 0;
    for (String s : schemas.keySet()) {
      if (s.endsWith(".xsd")) {
        sources[i] = new StreamSource(new ByteArrayInputStream(schemas.get(s)), s);
      i++;
    }
    }
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    schemaFactory.setErrorHandler(new MyErrorHandler(errors, null));
    schemaFactory.setResourceResolver(new MyResourceResolver());
    schema = schemaFactory.newSchema(sources);
  }

  public XmlValidator(List<ValidationMessage> validationErrors, String srcDir, String xsltDir, String[] schemaNames) throws FileNotFoundException, IOException, SAXException {
    loadTransforms(xsltDir);
    loadSchemas(srcDir, schemaNames);
    load();
  }
  
  private void loadTransforms(String xsltDir) throws FileNotFoundException, IOException {
    Map<String, byte[]> res = new HashMap<String, byte[]>();
    for (String s : new File(xsltDir).list()) {
      if (s.endsWith(".xslt"))
        res.put(s, TextFile.fileToBytes(Utilities.path(xsltDir, s)));
    }
    this.transforms = res;
  }

  private void loadSchemas(String dir, String[] names) throws FileNotFoundException, IOException {
    Map<String, byte[]> res = new HashMap<String, byte[]>();
    for (String s : new File(dir).list()) {
      if (s.endsWith(".sch"))
        res.put(s, TextFile.fileToBytes(Utilities.path(dir, s)));
      boolean ok = false;
      for (String b : names)
        ok = ok || b.equals(s);
      if (ok)
        res.put(s, TextFile.fileToBytes(Utilities.path(dir, s)));
    }
    this.schemas = res;
  }

  public Element checkBySchema(String fileToCheck, boolean wantThrow) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, FHIRException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    factory.setValidating(false);
    factory.setSchema(schema);
    DocumentBuilder builder = factory.newDocumentBuilder();
    MyErrorHandler err = new MyErrorHandler(errors, fileToCheck);
    builder.setErrorHandler(err);
    CSFileInputStream f = new CSFileInputStream(new CSFile(fileToCheck));
    Document doc = builder.parse(f);
    if (wantThrow && err.getErrors().size() > 0)
      throw new FHIRException("File " + fileToCheck + " failed schema validation");
    return doc.getDocumentElement();
  }

  public void checkBySchematron(String filename, String sch, boolean wantThrow) throws IOException, ParserConfigurationException, SAXException, FileNotFoundException, FHIRException {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document doc;
    byte[] out = null;
    try {
      out = Utilities.saxonTransform(transforms, schemas.get(sch), transforms.get("iso_svrl_for_xslt2.xsl"));
      out = Utilities.saxonTransform(transforms, TextFile.fileToBytes(filename), out);
    } catch (Throwable e) {
      errors.add(new ValidationMessage(Source.InstanceValidator, IssueType.STRUCTURE, -1, -1, filename+":"+sch, e.getMessage(), IssueSeverity.ERROR));
      if (wantThrow)
        throw new FHIRException("Error validating " + filename + " with schematrons", e);
    }

    factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    builder = factory.newDocumentBuilder();
    doc = builder.parse(new ByteArrayInputStream(out));
    NodeList nl = doc.getDocumentElement().getElementsByTagNameNS("http://purl.oclc.org/dsdl/svrl", "failed-assert");
    if (nl.getLength() > 0) {
      logger.log("Schematron Validation Failed for " + filename, LogMessageType.Error);
      for (int i = 0; i < nl.getLength(); i++) {
        Element e = (Element) nl.item(i);
        logger.log("  @" + e.getAttribute("location") + ": " + e.getTextContent(), LogMessageType.Error);
        errors.add(new ValidationMessage(Source.InstanceValidator, IssueType.STRUCTURE, -1, -1, filename+":"+e.getAttribute("location"), e.getTextContent(), IssueSeverity.ERROR));
      }
      if (wantThrow)
        throw new FHIRException("Schematron Validation Failed for " + filename);
    }
  }

  
}
