package org.hl7.fhir.utilities.http;

import java.io.IOException;
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
   * Returns the appropriate headers to be passed to the url.
   * <p/>
   * Implementations may perform I/O to obtain credentials (e.g. an OAuth client_credentials
   * token fetch), so this is allowed to fail the same way any other network operation does.
   * Callers already handle {@link IOException} from the surrounding request and can degrade
   * gracefully; an unchecked exception here would instead escape those handlers.
   *
   * @param url the url
   * @return the appropriate headers to be passed to the url
   * @throws IOException if the credentials could not be obtained
   */
  public Map<String, String> getHeaders(URL url) throws IOException;

  /**
   * Whether the credentials this provider supplies for {@code url} have a lifetime, and so can
   * go stale and be refreshed by {@link #invalidateCachedCredentials}.
   * <p/>
   * Static credentials (basic, token, api key) never go stale, so a server rejecting them will
   * reject them again - the default is false, and only then is a 401 worth retrying at all.
   *
   * @param url the url
   * @return true if this provider can refresh the credentials it supplies for {@code url}
   */
  default boolean canRefreshCredentials(URL url) {
    return false;
  }

  /**
   * Discards any cached credentials this provider holds for {@code url}, so that the next
   * {@link #getHeaders} call obtains fresh ones.
   * <p/>
   * Called when a server rejects a request with 401 and {@link #canRefreshCredentials} is true:
   * an OAuth access token, say, may simply have gone stale, and repeating the request with a
   * fresh one will succeed.
   *
   * @param url the url whose credentials were rejected
   * @return true if something was actually discarded, i.e. a retry has a reason to succeed.
   *   False means the rejected credentials were not cached ones - they were just minted - so a
   *   retry would only repeat the same failure.
   */
  default boolean invalidateCachedCredentials(URL url) {
    return false;
  }

  /**
   * @return true if the {@code url} is explicitly trusted to access non-public urls (this skips private-address,
   * DNS-rebinding, and metadata-host checks). It is independent of {@link #isProtocolAllowed(URL)}.
   */
  public boolean isPrivateNetworkAllowed(URL url);

}
