package org.hl7.fhir.utilities.http;

import java.net.URL;
import java.util.Map;

public class HTTPAuthenticationProviderChain implements IHTTPAuthenticationProvider {

  private final Iterable<IHTTPAuthenticationProvider> providers;

  public HTTPAuthenticationProviderChain(Iterable<IHTTPAuthenticationProvider> providers) {
    this.providers = providers;
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
  public Map<String, String> getHeaders(URL url) {
    for (IHTTPAuthenticationProvider p : providers) {
      if (p.canProvideHeaders(url)) {
        return p.getHeaders(url);
      }
    }
    return Map.of();
  }
}
