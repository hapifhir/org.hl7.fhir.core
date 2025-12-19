package org.hl7.fhir.validation.cli.picocli.options;

import picocli.CommandLine;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import static org.hl7.fhir.validation.cli.JavaSystemProxyParamSetter.*;

public class ProxyOptions {

  @CommandLine.Option(names = {"-proxy"}, description = "An http proxy address [address]:[port]", scope = CommandLine.ScopeType.INHERIT)

  private String proxy = null;
  public void setProxy(String proxy) {
    if (proxy != null) {
      setProxyHostSystemProperties(proxy, HTTP_PROXY_HOST, HTTP_PROXY_PORT);
    }
  }

  private String httpsProxy = null;
  @CommandLine.Option(names = {"-https-proxy"}, description = "An https proxy address [address]:[port]", scope = CommandLine.ScopeType.INHERIT)
  public void setHttpsProxy(String httpsProxy) {
    if (httpsProxy != null) {
      setProxyHostSystemProperties(httpsProxy, HTTPS_PROXY_HOST, HTTPS_PROXY_PORT);
    }
  }

  @CommandLine.Option(names = {"-auth"}, description = "Basic proxy authentication using [username]:[password]", scope = CommandLine.ScopeType.INHERIT)
  public void setProxyAuth(String proxyAuth) {
    if (proxyAuth != null) {
      String[] p = proxyAuth.split(":");
      String authUser = p[0];
      String authPass = p[1];

      /*
       * For authentication, use java.net.Authenticator to set proxy's configuration and set the system properties
       * http.proxyUser and http.proxyPassword
       */
      Authenticator.setDefault(
        new Authenticator() {
          @Override
          public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(authUser, authPass.toCharArray());
          }
        }
      );

      System.setProperty(HTTP_PROXY_USER, authUser);
      System.setProperty(HTTP_PROXY_PASS, authPass);
      System.setProperty(JAVA_USE_SYSTEM_PROXIES, "true");

      /*
       * For Java 1.8 and higher you must set
       * -Djdk.http.auth.tunneling.disabledSchemes=
       * to make proxies with Basic Authorization working with https along with Authenticator
       */
      System.setProperty(JAVA_DISABLED_TUNNELING_SCHEMES, "");
      System.setProperty(JAVA_DISABLED_PROXY_SCHEMES, "");
    }
  }
}
