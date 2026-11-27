package org.hl7.fhir.utilities;

import java.io.IOException;
import java.util.Map;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;

/**
 * Kept so that existing source and compiled clients continue to work. Every method delegates to
 * {@link org.hl7.fhir.utilities.xslt.XsltUtilities}.
 *
 * @deprecated use {@link org.hl7.fhir.utilities.xslt.XsltUtilities}
 */
@Deprecated(since = "2026-11-18", forRemoval = true)
public class XsltUtilities {

  /** @deprecated use {@link org.hl7.fhir.utilities.xslt.XsltUtilities#saxonTransform(Map, byte[], byte[])} */
  @Deprecated(since = "2026-11-18", forRemoval = true)
  public static byte[] saxonTransform(Map<String, byte[]> files, byte[] source, byte[] xslt) throws TransformerException {
    return org.hl7.fhir.utilities.xslt.XsltUtilities.saxonTransform(files, source, xslt);
  }

  /** @deprecated use {@link org.hl7.fhir.utilities.xslt.XsltUtilities#transform(Map, byte[], byte[])} */
  @Deprecated(since = "2026-11-18", forRemoval = true)
  public static byte[] transform(Map<String, byte[]> files, byte[] source, byte[] xslt) throws TransformerException {
    return org.hl7.fhir.utilities.xslt.XsltUtilities.transform(files, source, xslt);
  }

  /** @deprecated use {@link org.hl7.fhir.utilities.xslt.XsltUtilities#saxonTransform(String, String)} */
  @Deprecated(since = "2026-11-18", forRemoval = true)
  public static String saxonTransform(String source, String xslt) throws TransformerException, IOException {
    return org.hl7.fhir.utilities.xslt.XsltUtilities.saxonTransform(source, xslt);
  }

  /** @deprecated use {@link org.hl7.fhir.utilities.xslt.XsltUtilities#saxonTransform(String, String, String, String, URIResolver)} */
  @Deprecated(since = "2026-11-18", forRemoval = true)
  public static void saxonTransform(String xsltDir, String source, String xslt, String dest, URIResolver alt) throws TransformerException, IOException {
    org.hl7.fhir.utilities.xslt.XsltUtilities.saxonTransform(xsltDir, source, xslt, dest, alt);
  }

  /** @deprecated use {@link org.hl7.fhir.utilities.xslt.XsltUtilities#saxonTransform(String, String, String, String, URIResolver, Map)} */
  @Deprecated(since = "2026-11-18", forRemoval = true)
  public static void saxonTransform(String xsltDir, String source, String xslt, String dest, URIResolver alt, Map<String, String> params) throws TransformerException, IOException {
    org.hl7.fhir.utilities.xslt.XsltUtilities.saxonTransform(xsltDir, source, xslt, dest, alt, params);
  }

  /** @deprecated use {@link org.hl7.fhir.utilities.xslt.XsltUtilities#transform(String, String, String, String, URIResolver)} */
  @Deprecated(since = "2026-11-18", forRemoval = true)
  public static void transform(String xsltDir, String source, String xslt, String dest, URIResolver alt) throws TransformerException, IOException {
    org.hl7.fhir.utilities.xslt.XsltUtilities.transform(xsltDir, source, xslt, dest, alt);
  }

  /** @deprecated use {@link org.hl7.fhir.utilities.xslt.XsltUtilities#newXXEProtectedSaxonTransformerFactory()} */
  @Deprecated(since = "2026-11-18", forRemoval = true)
  public static TransformerFactory newXXEProtectedSaxonTransformerFactory() {
    return org.hl7.fhir.utilities.xslt.XsltUtilities.newXXEProtectedSaxonTransformerFactory();
  }
}
