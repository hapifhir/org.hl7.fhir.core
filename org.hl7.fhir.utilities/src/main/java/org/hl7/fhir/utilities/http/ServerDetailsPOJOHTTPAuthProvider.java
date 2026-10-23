package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * An {@link IHTTPAuthenticationProvider} implementation that provides authentication information for specific URLs by
 * performing a URL prefix match against an iterable collection of {@link ServerDetailsPOJO} objects. The information
 * for the first matching entry will be used.
 */
public class ServerDetailsPOJOHTTPAuthProvider implements IHTTPAuthenticationProvider {

  private static final String BEARER_PREFIX = "Bearer ";

  private final Iterable<ServerDetailsPOJO> servers;

  public ServerDetailsPOJOHTTPAuthProvider(final Iterable<ServerDetailsPOJO> servers) {
    this.servers = servers;
  }

  @Override
  public boolean isProtocolAllowed(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    if (serverDetails == null) {
      return false;
    }
    if (url.getProtocol().equals("http")) {
      return Boolean.TRUE.equals(serverDetails.getAllowHttp());
    } else {
      return url.getProtocol().equals("https");
    }
  }

  @Override
  public boolean isPrivateNetworkAllowed(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    return serverDetails != null && Boolean.TRUE.equals(serverDetails.getAllowPrivateNetwork());
  }

  @Override
  public boolean canProvideHeaders(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    return serverDetails != null;
  }

  @Override
  public Map<String, String> getHeaders(URL url) throws IOException {
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
      case OAUTH_CLIENT_CREDENTIALS -> {
        // A token-fetch failure - or incomplete configuration - propagates as IOException, so
        // callers that already handle a failed web request handle this too, and the request is
        // never sent without its credentials.
        String problem = FhirSettings.findClientCredentialsProblem(serverDetails);
        if (problem != null) {
          throw new IOException("Server " + serverDetails.getUrl() + " uses oauth_client_credentials but " + problem);
        }
        headers.put("Authorization", BEARER_PREFIX + HTTPTokenManager.getToken(serverDetails.getOauthClientCredentials(),
          Boolean.TRUE.equals(serverDetails.getAllowPrivateNetwork())));
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
      case "oauth_client_credentials" -> HTTPAuthenticationMode.OAUTH_CLIENT_CREDENTIALS;
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
  public boolean canRefreshCredentials(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    return serverDetails != null
      && getHTTPAuthenticationMode(serverDetails) == HTTPAuthenticationMode.OAUTH_CLIENT_CREDENTIALS;
  }

  @Override
  public boolean invalidateCachedCredentials(URL url, String rejectedAuthorization) {
    if (!canRefreshCredentials(url) || rejectedAuthorization == null || !rejectedAuthorization.startsWith(BEARER_PREFIX)) {
      return false;
    }
    return HTTPTokenManager.invalidateToken(getServerDetails(url).getOauthClientCredentials(),
      rejectedAuthorization.substring(BEARER_PREFIX.length()));
  }
}
