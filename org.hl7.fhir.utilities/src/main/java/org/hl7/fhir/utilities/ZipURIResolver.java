package org.hl7.fhir.utilities;

import java.util.Map;

import org.hl7.fhir.utilities.xslt.XsltZipURIResolver;

/**
 * Kept so that existing source and compiled clients continue to work. Behaves exactly like
 * {@link XsltZipURIResolver}.
 *
 * @deprecated use {@link XsltZipURIResolver}
 */
@Deprecated(since = "2026-11-18", forRemoval = true)
public class ZipURIResolver extends XsltZipURIResolver {

  public ZipURIResolver(Map<String, byte[]> files) {
    super(files);
  }
}
