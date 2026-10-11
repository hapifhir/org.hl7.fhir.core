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
   * Discards the credentials a server just rejected, if this provider still holds them for
   * {@code url}, so that the next {@link #getHeaders} call obtains fresh ones.
   * <p/>
   * Called when a server rejects a request with 401 and {@link #canRefreshCredentials} is true:
   * an OAuth access token, say, may simply have gone stale, and repeating the request with a
   * fresh one will succeed.
   * <p/>
   * Implementations must only discard the credentials that were actually rejected. Under
   * concurrency another request may already have replaced them, and discarding the replacement
   * would cost an extra refresh for no benefit.
   *
   * @param url the url whose credentials were rejected
   * @param rejectedAuthorization the {@code Authorization} header value the server rejected, or
   *   null if none was sent
   * @return true if a retry has a reason to succeed: the rejected credentials have been
   *   discarded, here or by a concurrent request, so {@link #getHeaders} will not supply them again
   */
  default boolean invalidateCachedCredentials(URL url, String rejectedAuthorization) {
    return false;
  }

  /**
   * @return true if the {@code url} is explicitly trusted to access non-public urls (this skips private-address,
   * DNS-rebinding, and metadata-host checks). It is independent of {@link #isProtocolAllowed(URL)}.
   */
  public boolean isPrivateNetworkAllowed(URL url);

}
