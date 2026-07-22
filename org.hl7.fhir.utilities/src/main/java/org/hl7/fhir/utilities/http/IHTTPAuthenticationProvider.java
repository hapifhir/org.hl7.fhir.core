package org.hl7.fhir.utilities.http;

import java.net.URL;
import java.util.Map;

/**
 * Provides necessary information for authenticating HTTP requests for specific URLs.
 */
public interface IHTTPAuthenticationProvider {

  public boolean isProtocolAllowed(URL url);

  public boolean canProvideHeaders(URL url);

  public Map<String, String> getHeaders(URL url);

  /**
   * Whether {@code url} is explicitly trusted to bypass SSRF protection (private-address,
   * DNS-rebinding, and metadata-host checks), independent of {@link #isProtocolAllowed(URL)}.
   */
  public boolean isPrivateNetworkAllowed(URL url);

}
