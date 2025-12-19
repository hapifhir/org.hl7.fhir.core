package org.hl7.fhir.validation.cli;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class JavaSystemProxyParamSetter {

  public static final String HTTP_PROXY_HOST = "http.proxyHost";
  public static final String HTTP_PROXY_PORT = "http.proxyPort";

  public static final String HTTPS_PROXY_HOST = "https.proxyHost";

  public static final String HTTPS_PROXY_PORT = "https.proxyPort";
  public static final String HTTP_PROXY_USER = "http.proxyUser";
  public static final String HTTP_PROXY_PASS = "http.proxyPassword";
  public static final String JAVA_DISABLED_TUNNELING_SCHEMES = "jdk.http.auth.tunneling.disabledSchemes";
  public static final String JAVA_DISABLED_PROXY_SCHEMES = "jdk.http.auth.proxying.disabledSchemes";
  public static final String JAVA_USE_SYSTEM_PROXIES = "java.net.useSystemProxies";

  @Deprecated(since = "2025-12-19")
  public static void setJavaSystemProxyParams(String proxy, String httpsProxy, String proxyAuth) {
    if (proxy != null) {
      setProxyHostSystemProperties(proxy, HTTP_PROXY_HOST, HTTP_PROXY_PORT);
    }
    if  (httpsProxy != null) {
      setProxyHostSystemProperties(httpsProxy, HTTPS_PROXY_HOST, HTTPS_PROXY_PORT);
    }
    if (proxyAuth != null) {
      assert proxy != null || httpsProxy != null: "Cannot set PROXY_AUTH without setting PROXY...";
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

  public static void setProxyHostSystemProperties(String proxy, String httpProxyHostProperty, String httpProxyPortProperty) {
    if (proxy != null) {
      String[] p2 = proxy.split(":");
      System.setProperty(httpProxyHostProperty, p2[0]);
      System.setProperty(httpProxyPortProperty, p2[1]);
    }
  }

  public static void verifyProxySystemProperties() throws IllegalArgumentException {
    String httpProxyHost = System.getProperty(HTTP_PROXY_HOST);
    String httpsProxyHost = System.getProperty(HTTPS_PROXY_HOST);

    String proxyUser = System.getProperty(HTTP_PROXY_USER);
    String proxyPass = System.getProperty(HTTP_PROXY_PASS);

    if (proxyUser != null || proxyPass != null) {
      if (proxyUser == null || proxyPass == null) {
        throw new IllegalArgumentException("Proxy User and Password must both be set");
      }
      if (httpsProxyHost == null && httpProxyHost == null) {
        throw new IllegalArgumentException("Proxy User and Password have been set with no http or https proxy specified.");
      }
    }

  }
}
