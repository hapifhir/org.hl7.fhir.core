package org.hl7.fhir.utilities.http;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class ManagedWebAccessorBase<B extends ManagedWebAccessorBase<B>> {
  @Getter
  private final Iterable<String> serverTypes;
  
  @Getter
  private final String userAgent;

  @Getter
  private final IHTTPAuthenticationProvider httpAuthHeaderProvider;

  /**
   * A set of headers to be added to HTTP requests.
   * <p/>
   * Important: these headers should not contain any sensitive or private information, such as authentication. Such
   * headers should be managed by {@link IHTTPAuthenticationProvider} implementations.
   */
  @Getter
  private final Map<String, String> headers = new HashMap<>();

  ManagedWebAccessorBase(Iterable<String> serverTypes, String userAgent, IHTTPAuthenticationProvider httpAuthHeaderProvider) {
    this.serverTypes = serverTypes;
    this.userAgent = userAgent;
    this.httpAuthHeaderProvider = httpAuthHeaderProvider;
  }

  @FunctionalInterface
  protected interface IOSupplier<T> {
    T get() throws IOException;
  }

  /**
   * Runs {@code action}; on a 401/403 whose URL is served by a client_credentials provider,
   * invalidates that cached token and retries exactly once.
   * <p>
   * Does nothing (returns the original result) for non-401/403 responses, for auth providers that
   * don't implement {@link ITokenInvalidatingAuthProvider}, and for any auth type other than
   * client_credentials.
   */
  protected HTTPResult executeWithClientCredentialsRetry(URL url, IOSupplier<HTTPResult> action)
      throws IOException {
    HTTPResult result = action.get();
    int code = result.getCode();
    if ((code == 401 || code == 403)
        && getHttpAuthHeaderProvider() instanceof ITokenInvalidatingAuthProvider inv
        && inv.invalidateCachedCredentials(url)) {
      log.warn("Received HTTP {} for {}; invalidated client_credentials token and retrying once", code, url);
      result = action.get();
      if (result.getCode() == 401 || result.getCode() == 403) {
        log.warn("client_credentials retry for {} still returned HTTP {} after token refresh; check clientSecret/scope/server authorization", url, result.getCode());
      }
    }
    return result;
  }
}
