package org.hl7.fhir.utilities.http;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class ManagedWebAccessorBase<B extends ManagedWebAccessorBase<B>> {
  @Getter
  private final Iterable<String> serverTypes;

  @Getter
  private final String userAgent;
  @Getter
  private HTTPAuthenticationMode authenticationMode;
  @Getter
  private String username;
  @Getter
  private String password;
  @Getter
  private String token;

  @Getter
  private ServerDetailsPOJO clientCredentialsServer;

  @Getter
  private final List<ServerDetailsPOJO> serverAuthDetails;
  @Getter
  private final Map<String, String> headers = new HashMap<>();

  public ManagedWebAccessorBase(Iterable<String> serverTypes, String userAgent, List<ServerDetailsPOJO> serverAuthDetails) {
    this.serverTypes = serverTypes;
    this.userAgent = userAgent;
    this.serverAuthDetails = serverAuthDetails;
  }

  @SuppressWarnings("unchecked")
  final B self() {
    return (B) this;
  }

  public B withHeader(String name, String value) {
    headers.put(name, value);
    return self();
  }

  public B withBasicAuth(String username, String password) {
    this.authenticationMode = HTTPAuthenticationMode.BASIC;
    this.username = username;
    this.password = password;
    return self();
  }

  public B withToken(String token) {
    this.authenticationMode = HTTPAuthenticationMode.TOKEN;
    this.token = token;
    return self();
  }

  public B withApiKey(String apiKey) {
    this.authenticationMode = HTTPAuthenticationMode.APIKEY;
    this.token = apiKey;
    return self();
  }

  public B withClientCredentials(ServerDetailsPOJO server) {
    this.authenticationMode = HTTPAuthenticationMode.CLIENT_CREDENTIALS;
    this.clientCredentialsServer = server;
    return self();
  }

  public B withNoneAuth() {
    this.authenticationMode = HTTPAuthenticationMode.NONE;
    setAllAuthHeadersToNull();
    return self();
  }

  public B withServerSpecificAuth() {
    this.authenticationMode = null;
    setAllAuthHeadersToNull();
    return self();
  }

  protected static class ResolvedAuth {
    private final Map<String, String> headers;
    private final ServerDetailsPOJO clientCredentialsServer;

    ResolvedAuth(Map<String, String> headers, ServerDetailsPOJO clientCredentialsServer) {
      this.headers = headers;
      this.clientCredentialsServer = clientCredentialsServer;
    }

    public Map<String, String> getHeaders() { return headers; }
    public ServerDetailsPOJO getClientCredentialsServer() { return clientCredentialsServer; }
  }

  @FunctionalInterface
  protected interface IOSupplier<T> {
    T get() throws IOException;
  }

  protected ResolvedAuth resolveAuth(String url) throws IOException {
    Map<String, String> authHeaders = new HashMap<>();
    ServerDetailsPOJO resolvedCcServer = null;

    if (authenticationMode != null) {
      switch (authenticationMode) {
        case NONE:
          break;
        case BASIC:
          String auth = username + ":" + password;
          byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
          authHeaders.put("Authorization", "Basic " + new String(encodedAuth));
          break;
        case TOKEN:
          authHeaders.put("Authorization", "Bearer " + token);
          break;
        case APIKEY:
          authHeaders.put("Api-Key", token);
          break;
        case CLIENT_CREDENTIALS:
          resolvedCcServer = clientCredentialsServer;
          String ccToken = HTTPTokenManager.getToken(clientCredentialsServer);
          authHeaders.put("Authorization", "Bearer " + ccToken);
          break;
      }
    } else {
      ServerDetailsPOJO settings = ManagedWebAccessUtils.getServer(serverTypes, url, serverAuthDetails);
      if (settings != null) {
        switch (settings.getAuthenticationType()) {
          case "basic":
            String sAuth = settings.getUsername() + ":" + settings.getPassword();
            byte[] sEncodedAuth = Base64.getEncoder().encode(sAuth.getBytes(StandardCharsets.UTF_8));
            authHeaders.put("Authorization", "Basic " + new String(sEncodedAuth));
            break;
          case "token":
            authHeaders.put("Authorization", "Bearer " + settings.getToken());
            break;
          case "apikey":
            authHeaders.put("Api-Key", settings.getApikey());
            break;
          case "client_credentials":
            resolvedCcServer = settings;
            String oauthToken = HTTPTokenManager.getToken(settings);
            authHeaders.put("Authorization", "Bearer " + oauthToken);
            break;
        }
        if (settings.getHeaders() != null) {
          authHeaders.putAll(settings.getHeaders());
        }
      }
    }
    return new ResolvedAuth(authHeaders, resolvedCcServer);
  }

  protected HTTPResult executeWithTokenRetry(String url, IOSupplier<HTTPResult> action) throws IOException {
    HTTPResult result = action.get();
    if (result.getCode() == 401 || result.getCode() == 403) {
      ServerDetailsPOJO ccServer = findClientCredentialsServer(url);
      if (ccServer != null) {
        log.debug("Received HTTP {} ; invalidating OAuth token and retrying", result.getCode());
        HTTPTokenManager.invalidateToken(ccServer);
        result = action.get();
        if (result.getCode() == 401 || result.getCode() == 403) {
          log.warn("Retry after OAuth token refresh still returned HTTP {}", result.getCode());
        }
      }
    }
    return result;
  }

  private ServerDetailsPOJO findClientCredentialsServer(String url) {
    if (authenticationMode == HTTPAuthenticationMode.CLIENT_CREDENTIALS) {
      return clientCredentialsServer;
    }
    if (authenticationMode == null) {
      ServerDetailsPOJO server = ManagedWebAccessUtils.getServer(serverTypes, url, serverAuthDetails);
      if (server != null && "client_credentials".equals(server.getAuthenticationType())) {
        return server;
      }
    }
    return null;
  }

  private void setAllAuthHeadersToNull() {
    this.token = null;
    this.username = null;
    this.password = null;
    this.clientCredentialsServer = null;
  }
}
