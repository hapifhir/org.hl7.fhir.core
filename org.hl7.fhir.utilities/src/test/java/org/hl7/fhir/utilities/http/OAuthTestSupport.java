package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.tls.HandshakeCertificates;
import okhttp3.tls.HeldCertificate;
import org.hl7.fhir.utilities.settings.OAuthClientCredentialsPOJO;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

/**
 * Shared scaffolding for OAuth client_credentials tests.
 * <p>
 * Token endpoints must use https, so tests run them on a {@link MockWebServer} serving a
 * self-signed certificate, and make {@link ManagedHTTPClient} trust it via
 * {@link #trustTestCertificate()}. Call {@link #resetTrust()} afterwards.
 */
final class OAuthTestSupport {

  private static final HeldCertificate LOCALHOST_CERTIFICATE = buildLocalhostCertificate();

  private static final HandshakeCertificates SERVER_CERTIFICATES = new HandshakeCertificates.Builder()
    .heldCertificate(LOCALHOST_CERTIFICATE)
    .build();

  private static final HandshakeCertificates CLIENT_CERTIFICATES = new HandshakeCertificates.Builder()
    .addTrustedCertificate(LOCALHOST_CERTIFICATE.certificate())
    .addPlatformTrustedCertificates()
    .build();

  private OAuthTestSupport() {}

  private static HeldCertificate buildLocalhostCertificate() {
    try {
      // MockWebServer.url() uses the canonical name of the loopback address it binds to
      String canonical = InetAddress.getByName("localhost").getCanonicalHostName();
      return new HeldCertificate.Builder()
        .addSubjectAlternativeName("localhost")
        .addSubjectAlternativeName(canonical)
        .addSubjectAlternativeName("127.0.0.1")
        .build();
    } catch (UnknownHostException e) {
      throw new IllegalStateException(e);
    }
  }

  static MockWebServer startHttpsServer() throws IOException {
    MockWebServer server = new MockWebServer();
    server.useHttps(SERVER_CERTIFICATES.sslSocketFactory(), false);
    server.start();
    return server;
  }

  static void trustTestCertificate() {
    ManagedHTTPClient.setTestTrust(CLIENT_CERTIFICATES.sslSocketFactory(), CLIENT_CERTIFICATES.trustManager());
  }

  static void resetTrust() {
    ManagedHTTPClient.setTestTrust(null, null);
  }

  static OAuthClientCredentialsPOJO credentials(MockWebServer tokenServer, String clientId, String clientSecret) {
    return OAuthClientCredentialsPOJO.builder()
      .clientId(clientId)
      .clientSecret(clientSecret)
      .tokenEndpoint(tokenServer.url("/token").toString())
      .build();
  }

  /**
   * A server entry for {@code serverUrl} authenticated by the token endpoint on {@code tokenServer}.
   * The MockWebServers are plain http (the resource server) on a loopback address, so this sets
   * the same opt-ins any internal server would need.
   */
  static ServerDetailsPOJO clientCredentialsServer(String serverUrl, MockWebServer tokenServer,
                                                   String clientId, String clientSecret) {
    return ServerDetailsPOJO.builder()
      .url(serverUrl)
      .authenticationType("oauth_client_credentials")
      .type("fhir")
      .oauthClientCredentials(credentials(tokenServer, clientId, clientSecret))
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();
  }

  static MockResponse tokenResponse(String accessToken, int expiresIn) {
    return new MockResponse()
      .setBody("{\"access_token\":\"" + accessToken + "\",\"token_type\":\"Bearer\",\"expires_in\":" + expiresIn + "}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200);
  }
}
