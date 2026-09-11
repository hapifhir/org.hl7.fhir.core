package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class HTTPAuthenticationProviderChain implements IHTTPAuthenticationProvider {

  private final Iterable<IHTTPAuthenticationProvider> providers;

  public HTTPAuthenticationProviderChain(Iterable<IHTTPAuthenticationProvider> providers) {
    this.providers = providers;
  }

  @Override
  public boolean isProtocolAllowed(URL url) {
    for (IHTTPAuthenticationProvider p : providers) {
      if (p.isProtocolAllowed(url)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isPrivateNetworkAllowed(URL url) {
    for (IHTTPAuthenticationProvider p : providers) {
      if (p.isPrivateNetworkAllowed(url)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean canProvideHeaders(URL url) {
    for (IHTTPAuthenticationProvider p : providers) {
      if (p.canProvideHeaders(url)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Map<String, String> getHeaders(URL url) throws IOException {
    for (IHTTPAuthenticationProvider p : providers) {
      if (p.canProvideHeaders(url)) {
        return p.getHeaders(url);
      }
    }
    return Map.of();
  }

  @Override
  public boolean invalidateCachedCredentials(URL url) {
    for (IHTTPAuthenticationProvider p : providers) {
      if (!p.canProvideHeaders(url)) {
        continue;
      }
      // Stop at the first provider that can serve this URL - that is the one getHeaders() used,
      // so it is the only one whose credentials could have caused the 401/403. Scanning past it
      // would invalidate a different provider's token and trigger a retry guaranteed to fail.
      return p.invalidateCachedCredentials(url);
    }
    return false;
  }
}
