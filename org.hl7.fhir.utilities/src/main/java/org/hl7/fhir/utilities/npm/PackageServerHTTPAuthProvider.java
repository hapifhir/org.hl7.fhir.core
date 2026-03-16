package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.http.IHTTPAuthenticationProvider;
import org.hl7.fhir.utilities.http.ManagedWebAccessUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PackageServerHTTPAuthProvider implements IHTTPAuthenticationProvider {
  private final PackageServer server;
  private final URL url;

  public PackageServerHTTPAuthProvider(PackageServer server) throws MalformedURLException {
    this.server = server;
    this.url = new URL(server.getUrl());
  }

  @Override
  public boolean canProvideHeaders(URL url) {
    return this.url.getProtocol().equals(url.getProtocol())
      && this.url.getHost().equals(url.getHost());
  }

  @Override
  public Map<String, String> getHeaders(URL url) {
    Map<String, String> headers = new HashMap<>();
    switch (server.getAuthenticationMode()) {
      case TOKEN -> {
        String providedToken = server.getToken();
        headers.put("Authorization", "Bearer " + providedToken);
      }
      case BASIC -> {
        byte[] encodedAuth = ManagedWebAccessUtils.getEncodedBasicAuth(server.getUsername(), server.getPassword());
        headers.put("Authorization", "Basic " + new String(encodedAuth));
      }
      case APIKEY -> {
        String providedAPIKey = server.getApiKey();
        headers.put("Api-Key", providedAPIKey);
      }
    }
    return headers;
  }
}
