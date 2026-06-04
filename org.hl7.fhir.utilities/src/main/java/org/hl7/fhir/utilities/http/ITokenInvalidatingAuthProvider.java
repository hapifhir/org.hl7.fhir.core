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
   * Invalidate any cached credentials this provider holds for the URL (e.g. an OAuth client_credentials
   * token), so the next request fetches fresh.
   * <p>
   * Delegating implementations (e.g. a provider chain) consult the first provider that can serve the URL
   * and need not scan past it.
   * @return true if something was invalidated (a retry is worthwhile)
   */
  boolean invalidateCachedCredentials(URL url);
}
