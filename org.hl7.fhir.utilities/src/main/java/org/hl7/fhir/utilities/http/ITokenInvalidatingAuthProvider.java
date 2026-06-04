package org.hl7.fhir.utilities.http;

import java.net.URL;

/**
 * Optional capability for {@link IHTTPAuthenticationProvider} implementations that cache short-lived
 * tokens (e.g. OAuth 2.0 client_credentials). Lets the request layer ask the provider to discard a
 * cached token after an authentication failure so the next request fetches a fresh one.
 * <p>
 * This is intentionally <em>not</em> part of {@link IHTTPAuthenticationProvider}: providers that do
 * not cache tokens need no such hook, and header generation stays the sole responsibility of
 * {@link IHTTPAuthenticationProvider}.
 */
public interface ITokenInvalidatingAuthProvider {
  /**
   * If the given URL is served by a client_credentials configuration, invalidate its cached token.
   * @return {@code true} if a client_credentials token was invalidated (so a retry is worthwhile)
   */
  boolean invalidateTokenIfClientCredentials(URL url);
}
