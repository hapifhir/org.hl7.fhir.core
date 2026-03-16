package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * An {@link IHTTPAuthenticationProvider} implementation that provides authentication information for specific URLs by performing a
 * URL prefix match against an iterable collection of {@link ServerDetailsPOJO} objects. The information for the first
 * matching entry will be used.
 */
public class ServerDetailsPOJOHTTPAuthProvider implements IHTTPAuthenticationProvider {

  private final Iterable<ServerDetailsPOJO> servers;

  public ServerDetailsPOJOHTTPAuthProvider(final Iterable<ServerDetailsPOJO> servers) {
    this.servers = servers;
  }

  @Override
  public boolean canProvideHeaders(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    return serverDetails != null;
  }

  @Override
  public Map<String, String> getHeaders(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    HTTPAuthenticationMode authenticationMode = getHTTPAuthenticationMode(serverDetails);

    if (authenticationMode == null) {
      return Collections.emptyMap();
    }

    Map<String, String> headers = new HashMap<>();
    switch (authenticationMode) {
      case TOKEN -> {
        String providedToken = serverDetails.getToken();
        headers.put("Authorization", "Bearer " + providedToken);
      }
      case BASIC -> {
        byte[] encodedAuth = ManagedWebAccessUtils.getEncodedBasicAuth(serverDetails.getUsername(), serverDetails.getPassword());
        headers.put("Authorization", "Basic " + new String(encodedAuth));
      }
      case APIKEY -> {
        String providedAPIKey = serverDetails.getApikey();
        headers.put("Api-Key", providedAPIKey);
      }
      default -> { /* do nothing */ }

  }
  if (serverDetails.getHeaders() != null) {
    headers.putAll(serverDetails.getHeaders());
  }
    return headers;
  }

  public static HTTPAuthenticationMode getHTTPAuthenticationMode(ServerDetailsPOJO serverDetails) {

    if (serverDetails == null) {
      return HTTPAuthenticationMode.NONE;
    }

    return switch (serverDetails.getAuthenticationType()) {
      case "basic" -> HTTPAuthenticationMode.BASIC;
      case "token" -> HTTPAuthenticationMode.TOKEN;
      case "apikey" -> HTTPAuthenticationMode.APIKEY;
      default -> HTTPAuthenticationMode.NONE;
    };
  }

  /**
   * Returns the first {@link ServerDetailsPOJO} whose URL is a prefix of the given URL, or {@code null} if none match.
   * <p>
   * Note: this performs a linear scan on every call and is not optimized for frequent lookups. If performance
   * becomes a concern, consider caching the result or using a more efficient data structure.
   * @param url The URL to match against the servers list
   * @return the associated server details, or {@code null} if no match is found
   */
  private ServerDetailsPOJO getServerDetails(URL url) {
    return ManagedWebAccessUtils.getServer(url.toString(), servers);
  }
}
