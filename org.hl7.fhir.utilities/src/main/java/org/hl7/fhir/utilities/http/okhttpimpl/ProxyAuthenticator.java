package org.hl7.fhir.utilities.http.okhttpimpl;

import okhttp3.*;

import java.io.IOException;

public class ProxyAuthenticator implements Authenticator {
  protected static final String HTTP_PROXY_USER = "http.proxyUser";
  protected static final String HTTP_PROXY_PASS = "http.proxyPassword";
  protected static final String HEADER_PROXY_AUTH = "Proxy-Authorization";

  @Override
  public Request authenticate(Route route, Response response) throws IOException {
    final String httpProxyUser = System.getProperty(HTTP_PROXY_USER);
    final String httpProxyPass = System.getProperty(HTTP_PROXY_PASS);
    if (httpProxyUser != null && httpProxyPass != null) {
      String credential = Credentials.basic(httpProxyUser, httpProxyPass);
      return response.request().newBuilder()
        .header(HEADER_PROXY_AUTH, credential)
        .build();
    }
    return response.request().newBuilder().build();
  }
}
