package org.hl7.fhir.utilities.http;

import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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
   * invalidates that cached token and retries exactly once. No-op for all other auth types.
   */
  protected HTTPResult executeWithClientCredentialsRetry(URL url, IOSupplier<HTTPResult> action)
      throws IOException {
    HTTPResult result = action.get();
    int code = result.getCode();
    if ((code == 401 || code == 403)
        && getHttpAuthHeaderProvider() instanceof ITokenInvalidatingAuthProvider inv
        && inv.invalidateTokenIfClientCredentials(url)) {
      result = action.get();
    }
    return result;
  }
}
