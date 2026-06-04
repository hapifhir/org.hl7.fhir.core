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
public class ServerDetailsPOJOHTTPAuthProvider implements IHTTPAuthenticationProvider, ITokenInvalidatingAuthProvider {

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
    if (serverDetails == null) {
      return Collections.emptyMap();
    }
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
      case CLIENT_CREDENTIALS -> {
        // A token-fetch failure surfaces as an unchecked FHIRException (the IHTTPAuthenticationProvider contract has no checked throws); callers catching IOException will not catch it. The 401/403 retry only triggers on HTTP status, not on this exception.
        try {
          String ccToken = HTTPTokenManager.getToken(serverDetails);
          headers.put("Authorization", "Bearer " + ccToken);
        } catch (java.io.IOException e) {
          throw new org.hl7.fhir.exceptions.FHIRException(
            "Failed to obtain client_credentials token for " + serverDetails.getUrl(), e);
        }
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

    String type = serverDetails.getAuthenticationType();
    if (type == null) {
      return HTTPAuthenticationMode.NONE;
    }

    return switch (type) {
      case "basic" -> HTTPAuthenticationMode.BASIC;
      case "token" -> HTTPAuthenticationMode.TOKEN;
      case "apikey" -> HTTPAuthenticationMode.APIKEY;
      case "client_credentials" -> HTTPAuthenticationMode.CLIENT_CREDENTIALS;
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

  @Override
  public boolean invalidateCachedCredentials(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    if (serverDetails != null
        && getHTTPAuthenticationMode(serverDetails) == HTTPAuthenticationMode.CLIENT_CREDENTIALS) {
      HTTPTokenManager.invalidateToken(serverDetails);
      return true;
    }
    return false;
  }
}
