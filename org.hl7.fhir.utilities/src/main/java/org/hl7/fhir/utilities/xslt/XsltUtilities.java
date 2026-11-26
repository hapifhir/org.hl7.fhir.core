package org.hl7.fhir.utilities.xslt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.XMLConstants;

import net.sf.saxon.Configuration;
import net.sf.saxon.jaxp.SaxonTransformerFactory;
import net.sf.saxon.jaxp.TransformerImpl;
import net.sf.saxon.lib.EnvironmentVariableResolver;
import net.sf.saxon.lib.Feature;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.SaxonApiUncheckedException;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */

/**
 * Utilities for working with XML
 * <p>
 * This is separate from {@link Utilities} in order to avoid introducing a mandatory
 * dependency on Saxon for anyone using just the structures
 * </p>
 */
public class XsltUtilities {

  public static byte[] saxonTransform(Map<String, byte[]> files, byte[] source, byte[] xslt) throws TransformerException {
    TransformerFactory f = newXXEProtectedSaxonTransformerFactory();
    f.setAttribute("http://saxon.sf.net/feature/version-warning", Boolean.FALSE);
    StreamSource xsrc = new StreamSource(new ByteArrayInputStream(xslt));
    f.setURIResolver(new XsltZipURIResolver(files));
    Transformer t = f.newTransformer(xsrc);
    forbidResultDocuments(t);

    t.setURIResolver(new XsltZipURIResolver(files));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    t.transform(newXXEProtectedSource(new ByteArrayInputStream(source)), new StreamResult(out));
    return out.toByteArray();
  }

  public static byte[] transform(Map<String, byte[]> files, byte[] source, byte[] xslt) throws TransformerException {
    TransformerFactory f = org.hl7.fhir.utilities.xml.XMLUtil.newXXEProtectedTransformerFactory();
    restrictEnvironment(f);
    f.setAttribute("http://saxon.sf.net/feature/version-warning", Boolean.FALSE);
    StreamSource xsrc = new StreamSource(new ByteArrayInputStream(xslt));
    f.setURIResolver(new XsltZipURIResolver(files));
    Transformer t = f.newTransformer(xsrc);
    forbidResultDocuments(t);

    t.setURIResolver(new XsltZipURIResolver(files));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    t.transform(newXXEProtectedSource(new ByteArrayInputStream(source)), new StreamResult(out));
    return out.toByteArray();
  }

  public static String saxonTransform(String source, String xslt) throws TransformerException, IOException {
    TransformerFactory f = newXXEProtectedSaxonTransformerFactory();
    f.setAttribute("http://saxon.sf.net/feature/version-warning", Boolean.FALSE);
    try (FileInputStream fxs = ManagedFileAccess.inStream(xslt);
         FileInputStream fso = ManagedFileAccess.inStream(source)) {
      Transformer t = f.newTransformer(new StreamSource(fxs));
      forbidResultDocuments(t);
      StreamResult res = new StreamResult(new ByteArrayOutputStream());
      t.transform(newXXEProtectedSource(fso), res);
      return res.getOutputStream().toString();
    }
  }

  public static void saxonTransform(String xsltDir, String source, String xslt, String dest, URIResolver alt) throws TransformerException, IOException {
    saxonTransform(xsltDir, source, xslt, dest, alt, null);
  }

  public static void saxonTransform(String xsltDir, String source, String xslt, String dest, URIResolver alt, Map<String, String> params) throws TransformerException, IOException {
    TransformerFactory f = newXXEProtectedSaxonTransformerFactory();
    f.setAttribute("http://saxon.sf.net/feature/version-warning", Boolean.FALSE);
    StreamSource xsrc = new StreamSource(ManagedFileAccess.inStream(xslt));
    f.setURIResolver(new XsltURIResolver(xsltDir, alt));
    Transformer t = f.newTransformer(xsrc);
    forbidResultDocuments(t);
    if (params != null) {
      for (Map.Entry<String, String> entry : params.entrySet()) {
        t.setParameter(entry.getKey(), entry.getValue());
      }
    }

    t.setURIResolver(new XsltURIResolver(xsltDir, alt));
    try (FileInputStream fso = ManagedFileAccess.inStream(source);
         FileOutputStream fsr = ManagedFileAccess.outStream(dest)) {
      t.transform(newXXEProtectedSource(fso), new StreamResult(fsr));
    }
  }

  public static void transform(String xsltDir, String source, String xslt, String dest, URIResolver alt) throws TransformerException, IOException {

    TransformerFactory f = org.hl7.fhir.utilities.xml.XMLUtil.newXXEProtectedTransformerFactory();
    restrictEnvironment(f);
    StreamSource xsrc = new StreamSource(ManagedFileAccess.inStream(xslt));
    f.setURIResolver(new XsltURIResolver(xsltDir, alt));
    Transformer t = f.newTransformer(xsrc);
    forbidResultDocuments(t);

    t.setURIResolver(new XsltURIResolver(xsltDir, alt));
    try (FileInputStream fss = ManagedFileAccess.inStream(source);
         FileOutputStream fsr = ManagedFileAccess.outStream(dest)) {
      t.transform(newXXEProtectedSource(fss), new StreamResult(fsr));
    }
  }

  /**
   * Wraps a source document in a SAXSource backed by an XXE-protected XMLReader, so that DOCTYPE
   * declarations (and therefore external entities) are rejected by the parser before any
   * URIResolver can be consulted.
   */
  private static SAXSource newXXEProtectedSource(InputStream in) throws TransformerException {
    try {
      XMLReader reader = XMLUtil.getXXEProtectedXMLReader(XMLUtil.newXXEProtectedSaxParserFactory());
      return new SAXSource(reader, new InputSource(in));
    } catch (ParserConfigurationException | SAXException e) {
      throw new TransformerException(e);
    }
  }

  /**
   * Stops the stylesheet writing secondary outputs with xsl:result-document. Without this, a
   * stylesheet can write any file the process can write. None of the transforms run here need
   * anything but the principal output.
   * <p>
   * The handler belongs to the transformer, not the factory, so this has to be called on each
   * transformer. If the transformer isn't Saxon's, it can't be restricted, so the transform is
   * refused.
   */
  private static void forbidResultDocuments(Transformer t) throws TransformerException {
    if (t instanceof TransformerImpl) {
      ((TransformerImpl) t).getUnderlyingXsltTransformer().setResultDocumentHandler(uri -> {
        throw new SaxonApiUncheckedException(new SaxonApiException("xsl:result-document is not allowed in this transform (it tried to write to " + uri + ")"));
      });
    } else {
      throw new TransformerException("Unable to run the transform: the XSLT processor is " + t.getClass().getName() + ", not Saxon, so it can't be stopped from writing files");
    }
  }

  /**
   * Stops the stylesheet reading the process environment:
   * <ul>
   *   <li>environment-variable() and available-environment-variables() see no variables.</li>
   *   <li>system-property() for names in no namespace no longer returns Java system properties.
   *   Saxon only returns them when external functions are allowed. Properties in the xsl
   *   namespace (xsl:version, xsl:vendor, ...) still work.</li>
   * </ul>
   * Non-Saxon factories are left alone. The transforms that use them are refused by
   * {@link #forbidResultDocuments(Transformer)}.
   */
  private static void restrictEnvironment(TransformerFactory f) {
    if (f instanceof SaxonTransformerFactory) {
      Configuration config = ((SaxonTransformerFactory) f).getConfiguration();
      config.setConfigurationProperty(Feature.ENVIRONMENT_VARIABLE_RESOLVER, NO_ENVIRONMENT_VARIABLES);
      config.setConfigurationProperty(Feature.ALLOW_EXTERNAL_FUNCTIONS, Boolean.FALSE);
    }
  }

  private static final EnvironmentVariableResolver NO_ENVIRONMENT_VARIABLES = new EnvironmentVariableResolver() {
    @Override
    public Set<String> getAvailableEnvironmentVariables() {
      return Collections.emptySet();
    }

    @Override
    public String getEnvironmentVariable(String name) {
      return null;
    }
  };

  /**
   * This method is used to create a new net.sf.saxon.TransformerFactoryImpl instance with external processing features
   * configured securely. Stylesheets run by transformers from this factory can't read environment variables or Java
   * system properties.
   * <p/>
   * The factory does <b>not</b> stop xsl:result-document writing files: that has to be set on each transformer (see
   * how the transforms in this class do it).
   * <p/>
   * <b>IMPORTANT</b> This method should be the only place where TransformerFactory is instantiated in this project.
   *
   * @return A TransformerFactoryImpl instance external processing features configured securely.
   */
  @SuppressWarnings("checkstyle:transformerFactoryImplInstantiation")
  public static TransformerFactory newXXEProtectedSaxonTransformerFactory() {
    final TransformerFactory f = new net.sf.saxon.TransformerFactoryImpl();
    f.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
    f.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
    restrictEnvironment(f);
    return f;
  }

}
