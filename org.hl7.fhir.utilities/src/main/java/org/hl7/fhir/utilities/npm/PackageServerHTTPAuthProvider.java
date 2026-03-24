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
    return ManagedWebAccessUtils.urlMatchesOrigin( url, this.url);
  }

  @Override
  public Map<String, String> getHeaders(URL url) {
    if (!ManagedWebAccessUtils.urlMatchesOrigin( url, this.url)) {
      // We should not get here unless there is an error in the client using this provider
      throw new IllegalArgumentException(("Unexpected request for access headers for " + this.url + " with a request for " + url));
    }
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
      default -> {
        // DO NOTHING. No headers to add.
      }
    }
    return headers;
  }
}
