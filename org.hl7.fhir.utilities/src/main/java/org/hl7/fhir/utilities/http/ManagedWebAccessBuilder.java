package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;


public class ManagedWebAccessBuilder {

  private String userAgent;
  private HTTPAuthenticationMode authenticationMode;
  private String username;
  private String password;
  private String token;
  private String accept;
  private List<ServerDetailsPOJO> serverAuthDetails;
  private Map<String, String> headers = new HashMap<String, String>();
  
  public ManagedWebAccessBuilder(String userAgent, List<ServerDetailsPOJO> serverAuthDetails) {
    this.userAgent = userAgent;
    this.serverAuthDetails = serverAuthDetails;
  }

  public ManagedWebAccessBuilder withAccept(String accept) {
    this.accept = accept;
    return this;
  }

  public ManagedWebAccessBuilder withHeader(String name, String value) {
    headers.put(name, value);
    return this;
  }

  public ManagedWebAccessBuilder withBasicAuth(String username, String password) {
    this.authenticationMode = HTTPAuthenticationMode.BASIC;
    this.username = username;
    this.password = password;
    return this;
  }
  
  public ManagedWebAccessBuilder withToken(String token) {
    this.authenticationMode = HTTPAuthenticationMode.TOKEN;
    this.token = token;
    return this;
  }
  
  private Map<String, String> headers() {
    Map<String, String> headers = new HashMap<String, String>();
    headers.putAll(this.headers);
    if (authenticationMode == HTTPAuthenticationMode.TOKEN) {
      headers.put("Authorization", "Bearer " + token);
    } else if (authenticationMode == HTTPAuthenticationMode.BASIC) {
      String auth = username+":"+password;
      byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
      headers.put("Authorization", "Basic " + new String(encodedAuth));
    }

    if (userAgent != null) {
      headers.put("User-Agent", userAgent);
    }

    return headers;
  }

  private SimpleHTTPClient setupClient(String url) throws IOException {
    if (!ManagedWebAccess.inAllowedPaths(url)) {
      throw new IOException("The pathname '"+url+"' cannot be accessed by policy");
    }
    SimpleHTTPClient client = new SimpleHTTPClient();
    if (userAgent != null) {
      client.addHeader("User-Agent", userAgent);
    }
    if (authenticationMode != null && authenticationMode != HTTPAuthenticationMode.NONE) {
      client.setAuthenticationMode(authenticationMode);
      switch (authenticationMode) {
      case BASIC :
        client.setUsername(username); 
        client.setPassword(password);
        break;
      case TOKEN :
        client.setToken(token);
        break;
      case APIKEY :
        client.setApiKey(token);
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
    if (username != null || token != null) {
      
      client.setAuthenticationMode(authenticationMode);
    }
    return client;
  }


  private ServerDetailsPOJO getServer(String url) {
    for (ServerDetailsPOJO t : serverAuthDetails) {
      if (url.startsWith(t.getUrl())) {
        return t;
      }
    }
    return null;
  }

  public HTTPResult get(String url) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      SimpleHTTPClient client = setupClient(url);
      return client.get(url, accept);
    case MANAGED:
      return ManagedWebAccess.getAccessor().get(url, accept, headers());
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
      return client.post(url, contentType, content, accept);
    case MANAGED:
      return ManagedWebAccess.getAccessor().post(url, content, contentType, accept, headers());
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
      return client.put(url, contentType, content, accept);
    case MANAGED:
      return ManagedWebAccess.getAccessor().put(url, content, contentType, accept, headers());
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

}
