package org.hl7.fhir.utilities.npm;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

/**
 * This is a _temporary_ fix to get around the fact that the build server's SSL certs have expired and people cannot
 * publish IGs or run tests that rely on that box. The intention is to overhaul much of the current networking code
 * to a more central, unified, HttpClient module.
 * <p>
 * If this is still in the code in 2021, contact markiantorno on github and yell at him.
 */
public class SSLCertTruster {

  // always verify the host - dont check for certificate
  final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
    public boolean verify(String hostname, SSLSession session) {
      return true;
    }
  };

  /**
   * Trust every server - don't check for any certificate
   */
  public static void trustAllHosts() {
    // Create a trust manager that does not validate certificate chains
    TrustManager[] trustAllCerts = new TrustManager[]{ new X509TrustManager() {
      @Override
      public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {}

      @Override
      public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {}

      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[]{};
      }
    }};

    // Install the all-trusting trust manager
    try {
      SSLContext sc = SSLContext.getInstance("TLS");
      sc.init(null, trustAllCerts, new java.security.SecureRandom());
      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
