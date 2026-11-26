package org.hl7.fhir.utilities;

import javax.xml.transform.URIResolver;

import org.hl7.fhir.utilities.xslt.XsltURIResolver;

/**
 * Kept so that existing source and compiled clients continue to work. Behaves exactly like
 * {@link XsltURIResolver}.
 *
 * @deprecated use {@link XsltURIResolver}
 */
@Deprecated(since = "2026-11-18", forRemoval = true)
public class MyURIResolver extends XsltURIResolver {

  public MyURIResolver(String path, URIResolver alt) {
    super(path, alt);
  }
}
