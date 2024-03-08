package org.hl7.fhir.r5.utils.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CanonicalResource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public interface IValidatorResourceFetcher {

  Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRException, IOException;

  boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type, boolean canonical) throws IOException, FHIRException;

  byte[] fetchRaw(IResourceValidator validator, String url) throws IOException; // for attachment checking

  IValidatorResourceFetcher setLocale(Locale locale);

  /**
   * this is used when the validator encounters a reference to a structure definition, value set or code system at some random URL reference
   * while validating.
   * <p>
   * Added in v5.2.2. return null to leave functionality as it was before then.
   *
   * @return an R5 version of the resource
   * @throws URISyntaxException
   */
  CanonicalResource fetchCanonicalResource(IResourceValidator validator, Object appContext, String url) throws URISyntaxException;

  /**
   * Whether to try calling fetchCanonicalResource for this reference (not whether it will succeed - just throw an exception from fetchCanonicalResource if it doesn't resolve. This is a policy thing.
   * <p>
   * Added in v5.2.2. return false to leave functionality as it was before then.
   *
   * @param url
   * @return
   */
  boolean fetchesCanonicalResource(IResourceValidator validator, String url);

  Set<String> fetchCanonicalResourceVersions(IResourceValidator validator, Object appContext, String url);
}
