package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import java.net.URL;
import java.util.Map;

/**
 * An {@link HTTPAuthProvider} implementation that provides authentication information for specific URLs by performing a
 * URL prefix match against an iterable collection of {@link ServerDetailsPOJO} objects. The information for the first
 * matching entry will be used.
 */
public class ServerDetailsPOJOHTTPAuthProvider implements HTTPAuthProvider {

  private final Iterable<ServerDetailsPOJO> servers;
  private final Iterable<String> serverTypes;

  public ServerDetailsPOJOHTTPAuthProvider(final Iterable<String> serverTypes, final Iterable<ServerDetailsPOJO> servers) {
    this.serverTypes = serverTypes;
    this.servers = servers;
  }

  @Override
  public HTTPAuthenticationMode getHTTPAuthenticationMode(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
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


  @Override
  public String getUsername(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    if (serverDetails == null) {
      return null;
    }
    return serverDetails.getUsername();
  }

  @Override
  public String getPassword(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    if (serverDetails == null) {
      return null;
    }
    return serverDetails.getPassword();
  }

  @Override
  public String getToken(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    if (serverDetails == null) {
      return null;
    }
    return serverDetails.getToken();
  }

  @Override
  public String getAPIKey(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    if (serverDetails == null) {
      return null;
    }
    return serverDetails.getApikey();
  }

  @Override
  public Map<String, String> getHeaders(URL url) {
    ServerDetailsPOJO serverDetails = getServerDetails(url);
    if (serverDetails == null) {
      return null;
    }
    return serverDetails.getHeaders();
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
    return ManagedWebAccessUtils.getServer(serverTypes, url.toString(), servers);
  }
}
