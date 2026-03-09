package org.hl7.fhir.utilities.http;

import java.net.URL;
import java.util.Map;

/**
 * Provides necessary information for authenticating HTTP requests for specific URLs.
 */
public interface HTTPAuthProvider {
  /**
   * @param url The URL to provide information for
   * @return An {@link HTTPAuthenticationMode} for the URL
   */
  HTTPAuthenticationMode getHTTPAuthenticationMode(URL url);

  /**
   * @param url The URL to provide information for
   * @return A username for use with {@link HTTPAuthenticationMode#BASIC} authentication
   */
  String getUsername(URL url);

  /**
   * @param url The URL to provide information for
   * @return A password for use with {@link HTTPAuthenticationMode#BASIC} authentication
   */
  String getPassword(URL url);

  /**
   * @param url The URL to provide information for
   * @return A token to use with {@link HTTPAuthenticationMode#TOKEN} authentication
   */
  String getToken(URL url);

  /**
   * @param url The URL to provide information for
   * @return An API key to use with {@link HTTPAuthenticationMode#APIKEY} authentication
   */
  String getAPIKey(URL url);

  /**
   * Any non-authorization headers intended for use with this server.
   * <p>
   * <b>Note:</b> These headers are not associated with any {@link HTTPAuthenticationMode} and are added to requests
   * when the {@link HTTPAuthProvider} path is active (i.e., when {@code authenticationMode} is null or a cross-host
   * redirect has occurred).
   * @param url The URL to provide information for
   * @return Headers associated with the URL
   */
  Map<String, String> getHeaders(URL url);
}
