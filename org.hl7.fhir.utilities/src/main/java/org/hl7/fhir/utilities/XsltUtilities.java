package org.hl7.fhir.utilities;

/*-
 * #%L
 * org.hl7.fhir.utilities
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

import net.sf.saxon.TransformerFactoryImpl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Map;

/**
 * Utilities for working with XML
 * <p>
 * This is separate from {@link Utilities} in order to avoid introducing a mandatory
 * dependency on Saxon for anyone using just the structures
 * </p>
 */
public class XsltUtilities {

  public static byte[] saxonTransform(Map<String, byte[]> files, byte[] source, byte[] xslt) throws TransformerException {
    TransformerFactory f = new net.sf.saxon.TransformerFactoryImpl();
    f.setAttribute("http://saxon.sf.net/feature/version-warning", Boolean.FALSE);
    StreamSource xsrc = new StreamSource(new ByteArrayInputStream(xslt));
    f.setURIResolver(new ZipURIResolver(files));
    Transformer t = f.newTransformer(xsrc);

    t.setURIResolver(new ZipURIResolver(files));
    StreamSource src = new StreamSource(new ByteArrayInputStream(source));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    StreamResult res = new StreamResult(out);
    t.transform(src, res);
    return out.toByteArray();
  }

  public static byte[] transform(Map<String, byte[]> files, byte[] source, byte[] xslt) throws TransformerException {
    TransformerFactory f = TransformerFactory.newInstance();
    f.setAttribute("http://saxon.sf.net/feature/version-warning", Boolean.FALSE);
    StreamSource xsrc = new StreamSource(new ByteArrayInputStream(xslt));
    f.setURIResolver(new ZipURIResolver(files));
    Transformer t = f.newTransformer(xsrc);

    t.setURIResolver(new ZipURIResolver(files));
    StreamSource src = new StreamSource(new ByteArrayInputStream(source));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    StreamResult res = new StreamResult(out);
    t.transform(src, res);
    return out.toByteArray();
  }

  public static String saxonTransform(String source, String xslt) throws TransformerException, FileNotFoundException {
    TransformerFactoryImpl f = new net.sf.saxon.TransformerFactoryImpl();
    f.setAttribute("http://saxon.sf.net/feature/version-warning", Boolean.FALSE);
    StreamSource xsrc = new StreamSource(new FileInputStream(xslt));
    Transformer t = f.newTransformer(xsrc);
    StreamSource src = new StreamSource(new FileInputStream(source));
    StreamResult res = new StreamResult(new ByteArrayOutputStream());
    t.transform(src, res);
    return res.getOutputStream().toString();
  }

  public static void saxonTransform(String xsltDir, String source, String xslt, String dest, URIResolver alt) throws FileNotFoundException, TransformerException {
    saxonTransform(xsltDir, source, xslt, dest, alt, null);
  }

  public static void saxonTransform(String xsltDir, String source, String xslt, String dest, URIResolver alt, Map<String, String> params) throws FileNotFoundException, TransformerException {
    TransformerFactoryImpl f = new net.sf.saxon.TransformerFactoryImpl();
    f.setAttribute("http://saxon.sf.net/feature/version-warning", Boolean.FALSE);
    StreamSource xsrc = new StreamSource(new FileInputStream(xslt));
    f.setURIResolver(new MyURIResolver(xsltDir, alt));
    Transformer t = f.newTransformer(xsrc);
    if (params != null) {
      for (Map.Entry<String, String> entry : params.entrySet()) {
        t.setParameter(entry.getKey(), entry.getValue());
      }
    }

    t.setURIResolver(new MyURIResolver(xsltDir, alt));
    StreamSource src = new StreamSource(new FileInputStream(source));
    StreamResult res = new StreamResult(new FileOutputStream(dest));
    t.transform(src, res);
  }

  public static void transform(String xsltDir, String source, String xslt, String dest, URIResolver alt) throws FileNotFoundException, TransformerException {

    TransformerFactory f = TransformerFactory.newInstance();
    StreamSource xsrc = new StreamSource(new FileInputStream(xslt));
    f.setURIResolver(new MyURIResolver(xsltDir, alt));
    Transformer t = f.newTransformer(xsrc);

    t.setURIResolver(new MyURIResolver(xsltDir, alt));
    StreamSource src = new StreamSource(new FileInputStream(source));
    StreamResult res = new StreamResult(new FileOutputStream(dest));
    t.transform(src, res);

  }

}
