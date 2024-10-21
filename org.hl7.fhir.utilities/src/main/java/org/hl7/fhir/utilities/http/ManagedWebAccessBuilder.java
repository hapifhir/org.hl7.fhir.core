package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

/**
 * Simple HTTP client for making requests to a server.
 */
public class ManagedWebAccessBuilder extends ManagedWebAccessBuilderBase<ManagedWebAccessBuilder> {

  public ManagedWebAccessBuilder(String userAgent, List<ServerDetailsPOJO> serverAuthDetails) {
    super(userAgent, serverAuthDetails);
  }

  public ManagedWebAccessBuilder withAccept(String accept) {
    return super.withAccept(accept);
  }
  
  private Map<String, String> newHeaders() {
    Map<String, String> headers = new HashMap<String, String>();
    headers.putAll(this.getHeaders());
    if (getAuthenticationMode() == HTTPAuthenticationMode.TOKEN) {
      headers.put("Authorization", "Bearer " + getToken());
    } else if (getAuthenticationMode() == HTTPAuthenticationMode.BASIC) {
      String auth = getUsername() +":"+ getPassword();
      byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
      headers.put("Authorization", "Basic " + new String(encodedAuth));
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
    if (getUserAgent() != null) {
      client.addHeader("User-Agent", getUserAgent());
    }
    if (getAuthenticationMode() != null && getAuthenticationMode() != HTTPAuthenticationMode.NONE) {
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
    } else {
      ServerDetailsPOJO settings = getServer(url);
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
      }
    }
    if (getUsername() != null || getToken() != null) {
      client.setAuthenticationMode(getAuthenticationMode());
    }
    return client;
  }

  private ServerDetailsPOJO getServer(String url) {
    if (getServerAuthDetails() != null) {
      for (ServerDetailsPOJO t : getServerAuthDetails()) {
        if (url.startsWith(t.getUrl())) {
          return t;
        }
      }
    }
    return null;
  }

  public HTTPResult get(String url) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      SimpleHTTPClient client = setupClient(url);
      return client.get(url, getAccept());
    case MANAGED:
      return ManagedWebAccess.getAccessor().get(url, getAccept(), newHeaders());
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public HTTPResult post(String url, byte[] content, String contentType) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      SimpleHTTPClient client = setupClient(url);
      return client.post(url, contentType, content, getAccept());
    case MANAGED:
      return ManagedWebAccess.getAccessor().post(url, content, contentType, getAccept(), newHeaders());
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public HTTPResult put(String url, byte[] content, String contentType) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      SimpleHTTPClient client = setupClient(url);
      return client.put(url, contentType, content, getAccept());
    case MANAGED:
      return ManagedWebAccess.getAccessor().put(url, content, contentType, getAccept(), newHeaders());
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }
}
