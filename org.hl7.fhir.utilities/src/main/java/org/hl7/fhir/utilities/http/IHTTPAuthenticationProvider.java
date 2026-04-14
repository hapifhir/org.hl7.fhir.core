package org.hl7.fhir.utilities.http;

import java.net.URL;
import java.util.Map;

/**
 * Provides necessary information for authenticating HTTP requests for specific URLs.
 */
public interface IHTTPAuthenticationProvider {

  public boolean canProvideHeaders(URL url);

  public Map<String, String> getHeaders(URL url);

}
