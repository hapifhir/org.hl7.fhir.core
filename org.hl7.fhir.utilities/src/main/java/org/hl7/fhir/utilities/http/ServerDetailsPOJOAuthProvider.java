package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import java.net.URL;
import java.util.Map;

public class ServerDetailsPOJOAuthProvider implements AuthProvider {

  private final Iterable<ServerDetailsPOJO> servers;
  private final Iterable<String> serverTypes;

  public ServerDetailsPOJOAuthProvider(final Iterable<String> serverTypes, final Iterable<ServerDetailsPOJO> servers) {
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
   * Get server details matching a specific URL.
   * <p/>
   * Note: this is not particularly efficient, but intended for the niche case of managing 30x HTTP redirects.
   * If efficiency becomes an issue here, this may need refactoring or a cache to speed things up.
   * @param url The URL to find in the servers list
   * @return the associated details for that server
   */
  private ServerDetailsPOJO getServerDetails(URL url) {
    return ManagedWebAccessUtils.getServer(serverTypes, url.toString(), servers);
  }
}
