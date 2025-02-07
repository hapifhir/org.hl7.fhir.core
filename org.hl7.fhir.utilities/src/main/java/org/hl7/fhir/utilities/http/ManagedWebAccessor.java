package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

/**
 * Simple HTTP client for making requests to a server.
 */
public class ManagedWebAccessor extends ManagedWebAccessorBase<ManagedWebAccessor> {

  public ManagedWebAccessor(Iterable<String> serverTypes, String userAgent, List<ServerDetailsPOJO> serverAuthDetails) {
    super(serverTypes, userAgent, serverAuthDetails);
  }
  
  private Map<String, String> newHeaders() {
    Map<String, String> headers = new HashMap<String, String>(this.getHeaders());
    if (getAuthenticationMode() == HTTPAuthenticationMode.TOKEN) {
      headers.put("Authorization", "Bearer " + getToken());
    } else if (getAuthenticationMode() == HTTPAuthenticationMode.BASIC) {
      String auth = getUsername() +":"+ getPassword();
      byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
      headers.put("Authorization", "Basic " + new String(encodedAuth));
    } else if (getAuthenticationMode() == HTTPAuthenticationMode.APIKEY) {
      headers.put("Api-Key", getToken());
    }

    if (getUserAgent() != null) {
      headers.put("User-Agent", getUserAgent());
    }
    return headers;
  }

  private SimpleHTTPClient setupClient(String url) throws IOException {
    if (!ManagedWebAccess.inAllowedPaths(url)) {
      throw new IOException("The pathname '"+url+"' cannot be accessed by policy");
    }
    SimpleHTTPClient client = new SimpleHTTPClient();

    for (Map.Entry<String, String> entry : this.getHeaders().entrySet()) {
      client.addHeader(entry.getKey(), entry.getValue());
    }

    if (getUserAgent() != null) {
      client.addHeader("User-Agent", getUserAgent());
    }
    if (getAuthenticationMode() != null) {
      if (getAuthenticationMode() != HTTPAuthenticationMode.NONE) {
      client.setAuthenticationMode(getAuthenticationMode());
      switch (getAuthenticationMode()) {
      case BASIC :
        client.setUsername(getUsername());
        client.setPassword(getPassword());
        break;
      case TOKEN :
        client.setToken(getToken());
        break;
      case APIKEY :
        client.setApiKey(getToken());
        break;
      }
      }
    } else {
      ServerDetailsPOJO settings = ManagedWebAccessUtils.getServer(getServerTypes(), url, getServerAuthDetails());
      if (settings != null) {
        switch (settings.getAuthenticationType()) {
        case "basic" :
          client.setUsername(settings.getUsername()); 
          client.setPassword(settings.getPassword());
          client.setAuthenticationMode(HTTPAuthenticationMode.BASIC);
          break;
        case "token" :
          client.setToken(settings.getToken());
          client.setAuthenticationMode(HTTPAuthenticationMode.TOKEN);
          break;
        case "apikey" :
          client.setApiKey(settings.getApikey());
          client.setAuthenticationMode(HTTPAuthenticationMode.APIKEY);
          break;
        }
        if (settings.getHeaders() != null) {
          for (String n : settings.getHeaders().keySet()) {
            client.addHeader(n, settings.getHeaders().get(n));
          }
        }
      }
    }
    if (getUsername() != null || getToken() != null) {
      client.setAuthenticationMode(getAuthenticationMode());
    }
    return client;
  }

  public HTTPResult get(String url) throws IOException {
    return get(url, null);
  }

  public HTTPResult get(String url, String accept) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      SimpleHTTPClient client = setupClient(url);
      return client.get(url, accept);
    case MANAGED:
      return ManagedWebAccess.getAccessor().get(getServerTypes(), url, accept, newHeaders());
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public HTTPResult post(String url, byte[] content, String contentType) throws IOException {
    return post(url, content, contentType, null);
  }

  public HTTPResult post(String url, byte[] content, String contentType, String accept) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      SimpleHTTPClient client = setupClient(url);
      return client.post(url, contentType, content, accept);
    case MANAGED:
      return ManagedWebAccess.getAccessor().post(getServerTypes(), url, content, contentType, accept, newHeaders());
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public HTTPResult put(String url, byte[] content, String contentType) throws IOException {
    return put(url, content, contentType, null);
  }

  public HTTPResult put(String url, byte[] content, String contentType, String accept) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      SimpleHTTPClient client = setupClient(url);
      return client.put(url, contentType, content, accept);
    case MANAGED:
      return ManagedWebAccess.getAccessor().put(getServerTypes(), url, content, contentType, accept, newHeaders());
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }
}
