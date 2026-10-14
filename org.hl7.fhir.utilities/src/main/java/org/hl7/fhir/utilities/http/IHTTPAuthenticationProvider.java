package org.hl7.fhir.utilities.http;

import java.net.URL;
import java.util.Map;

/**
 * Provides necessary information for authenticating HTTP requests for specific URLs.
 */
public interface IHTTPAuthenticationProvider {

  /**
   *
   * @param url the url
   * @return true if the protocol for the url is permitted
   */
  public boolean isProtocolAllowed(URL url);

  /**
   *
   * @param url the url
   * @return true if this provider can provide headers (generally used for authentication) for the url
   */
  public boolean canProvideHeaders(URL url);

  /**
   *
   * @param url the url
   * @return the appropriate headers to be passed to the url
   */
  public Map<String, String> getHeaders(URL url);

  /**
   * @return true if the {@code url} is explicitly trusted to access non-public urls (this skips private-address,
   * DNS-rebinding, and metadata-host checks). It is independent of {@link #isProtocolAllowed(URL)}.
   */
  public boolean isPrivateNetworkAllowed(URL url);

}
