package org.hl7.fhir.utilities.http;

import java.net.URL;
import java.util.Map;

/**
 * Provides necessary information for authenticating HTTP requests for specific URLs.
 */
public interface HTTPAuthProvider {
  /**
   *
   * @param url The URL to provide information for
   * @return An HTTPAuthenticationMode for the URL
   */
  HTTPAuthenticationMode getHTTPAuthenticationMode(URL url);

  /**
   * @param url The URL to provide information for
   * @return A username for use with HTTPAuthenticationMode.BASIC authentications
   */
  String getUsername(URL url);

  /**
   * @param url The URL to provide information for
   * @return A password for use with HTTPAuthenticationMode.BASIC authentications
   */
  String getPassword(URL url);

  /**
   * @param url The URL to provide information for
   * @return A token to use with HTTPAuthenticationMode.TOKEN
   */
  String getToken(URL url);

  /**
   * @param url The URL to provide information for
   * @return An API key to use with HTTPAuthenticationMode.APIKEY
   */
  String getAPIKey(URL url);

  /**
   * Any non-authorization headers intended for use with this server.
   * <p/>
   * IMPORTANT: These headers are not associated with any HTTPAuthenticationMode and are intended to always be added to
   * requests.
   * @param url The URL to provide information for
   * @return Headers associated with the URL
   */
  Map<String, String> getHeaders(URL url);
}
