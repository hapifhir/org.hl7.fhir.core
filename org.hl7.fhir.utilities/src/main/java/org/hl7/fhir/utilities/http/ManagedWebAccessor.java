package org.hl7.fhir.utilities.http;

import java.io.IOException;
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

  private Map<String, String> newHeaders(String url) throws IOException {
    Map<String, String> headers = new HashMap<>(this.getHeaders());
    ResolvedAuth auth = resolveAuth(url);
    headers.putAll(auth.getHeaders());
    if (getUserAgent() != null) {
      headers.put("User-Agent", getUserAgent());
    }
    return headers;
  }

  private SimpleHTTPClient setupClient(String url) throws IOException {
    if (!ManagedWebAccess.inAllowedPaths(url)) {
      throw new IOException("The pathname '" + url + "' cannot be accessed by policy");
    }
    SimpleHTTPClient client = new SimpleHTTPClient();

    for (Map.Entry<String, String> entry : this.getHeaders().entrySet()) {
      client.addHeader(entry.getKey(), entry.getValue());
    }
    if (getUserAgent() != null) {
      client.addHeader("User-Agent", getUserAgent());
    }
    ResolvedAuth auth = resolveAuth(url);
    for (Map.Entry<String, String> entry : auth.getHeaders().entrySet()) {
      client.addHeader(entry.getKey(), entry.getValue());
    }

    return client;
  }

  public HTTPResult get(String url) throws IOException {
    return get(url, null);
  }

  public HTTPResult get(String url, String accept) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      return executeWithTokenRetry(url, () -> {
        SimpleHTTPClient client = setupClient(url);
        return client.get(url, accept);
      });
    case MANAGED:
      return ManagedWebAccess.getAccessor().get(getServerTypes(), url, accept, newHeaders(url));
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
      return executeWithTokenRetry(url, () -> {
        SimpleHTTPClient client = setupClient(url);
        return client.post(url, contentType, content, accept);
      });
    case MANAGED:
      return ManagedWebAccess.getAccessor().post(getServerTypes(), url, content, contentType, accept, newHeaders(url));
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
      return executeWithTokenRetry(url, () -> {
        SimpleHTTPClient client = setupClient(url);
        return client.put(url, contentType, content, accept);
      });
    case MANAGED:
      return ManagedWebAccess.getAccessor().put(getServerTypes(), url, content, contentType, accept, newHeaders(url));
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }
}
