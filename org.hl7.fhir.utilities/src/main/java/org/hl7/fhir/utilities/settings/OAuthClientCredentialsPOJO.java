package org.hl7.fhir.utilities.settings;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.apache.commons.lang3.StringUtils;

/**
 * Credentials for the OAuth 2.0 client_credentials grant (RFC 6749 §4.4), used by a
 * {@link ServerDetailsPOJO} whose {@code authenticationType} is {@code oauth_client_credentials}.
 * <p>
 * The client authenticates to the token endpoint in one of two ways, chosen by {@code clientAuthMethod}:
 * <ul>
 *   <li>{@code client_secret_post} (the default): a shared secret, sent in the request body.
 * <pre>
 * "oauthClientCredentials" : {
 *   "clientId" : "...",
 *   "clientSecret" : "...",
 *   "tokenEndpoint" : "https://..."
 * }
 * </pre></li>
 *   <li>{@code private_key_jwt} (RFC 7523 §2.2, as used by SMART Backend Services): a short-lived
 *       JWT signed with the client's private key, so no secret is ever sent.
 *       {@code privateKeyFile} is a PKCS#8 PEM file ({@code -----BEGIN PRIVATE KEY-----}) or a JWK
 *       or JWK Set holding an RSA or EC private key. {@code keyId} is sent as the JWT's {@code kid},
 *       and selects the key from a JWK Set; it defaults to the JWK's own {@code kid}.
 *       {@code signingAlgorithm} is one of {@link #SIGNING_ALGORITHMS}; it defaults to the JWK's
 *       {@code alg}, then to RS384 for an RSA key, or for an EC key the algorithm its curve requires
 *       (ES384 for P-384).
 * <pre>
 * "oauthClientCredentials" : {
 *   "clientId" : "...",
 *   "clientAuthMethod" : "private_key_jwt",
 *   "privateKeyFile" : "/path/to/key.pem",
 *   "keyId" : "...",
 *   "scope" : "system/*.rs",
 *   "tokenEndpoint" : "https://..."
 * }
 * </pre></li>
 * </ul>
 * {@code scope}, if set, is sent with the token request (RFC 6749 §4.4.2) with either method. SMART
 * Backend Services requires it, with {@code system/} scopes such as {@code system/*.rs}.
 * The token endpoint must use https: the client authenticates to it in the request body, and
 * RFC 6749 §2.3.1 and §3.2 require TLS for client authentication at the token endpoint.
 */
@Data
@Builder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
public class OAuthClientCredentialsPOJO {

  public static final String CLIENT_SECRET_POST = "client_secret_post";
  public static final String PRIVATE_KEY_JWT = "private_key_jwt";

  /** JWS algorithms accepted for {@code private_key_jwt} client assertions. */
  public static final List<String> SIGNING_ALGORITHMS = List.of(
    "RS256", "RS384", "RS512", "PS256", "PS384", "PS512", "ES256", "ES384", "ES512");

  String clientId;

  /** {@value #CLIENT_SECRET_POST} or {@value #PRIVATE_KEY_JWT}; {@value #CLIENT_SECRET_POST} if not set. */
  String clientAuthMethod;

  @ToString.Exclude
  String clientSecret;

  String privateKeyFile;

  String keyId;

  String signingAlgorithm;

  /** Space-separated scopes to request; none are requested if not set. */
  String scope;

  String tokenEndpoint;

  /**
   * @return {@link #clientAuthMethod}, or {@value #CLIENT_SECRET_POST} if it is not set
   */
  public String resolvedClientAuthMethod() {
    return StringUtils.isBlank(clientAuthMethod) ? CLIENT_SECRET_POST : clientAuthMethod;
  }

  /**
   * @return a description of the first missing or unusable field, or null if these credentials can be used
   */
  public String findProblem() {
    if (StringUtils.isBlank(clientId)) {
      return "is missing required field: clientId";
    }
    String problem = switch (resolvedClientAuthMethod()) {
      case CLIENT_SECRET_POST -> findClientSecretProblem();
      case PRIVATE_KEY_JWT -> findPrivateKeyJwtProblem();
      default -> "has an unsupported clientAuthMethod '" + clientAuthMethod + "' (use "
        + CLIENT_SECRET_POST + " or " + PRIVATE_KEY_JWT + ")";
    };
    if (problem != null) {
      return problem;
    }
    if (StringUtils.isBlank(tokenEndpoint)) {
      return "is missing required field: tokenEndpoint";
    }
    if (!StringUtils.startsWithIgnoreCase(tokenEndpoint, "https://")) {
      return "has a tokenEndpoint that does not use https";
    }
    try {
      URI.create(tokenEndpoint).toURL();
    } catch (IllegalArgumentException | MalformedURLException e) {
      return "has a malformed tokenEndpoint";
    }
    return null;
  }

  private String findClientSecretProblem() {
    if (StringUtils.isBlank(clientSecret)) {
      return "is missing required field: clientSecret";
    }
    // Most likely a forgotten clientAuthMethod - better reported than silently sending the secret
    if (privateKeyFile != null || keyId != null || signingAlgorithm != null) {
      return "sets privateKeyFile, keyId or signingAlgorithm, which are only used when clientAuthMethod is "
        + PRIVATE_KEY_JWT;
    }
    return null;
  }

  private String findPrivateKeyJwtProblem() {
    if (StringUtils.isBlank(privateKeyFile)) {
      return "is missing required field: privateKeyFile";
    }
    if (clientSecret != null) {
      return "sets clientSecret, which is not used when clientAuthMethod is " + PRIVATE_KEY_JWT;
    }
    if (signingAlgorithm != null && !SIGNING_ALGORITHMS.contains(signingAlgorithm)) {
      return "has an unsupported signingAlgorithm '" + signingAlgorithm + "' (use one of "
        + String.join(", ", SIGNING_ALGORITHMS) + ")";
    }
    return null;
  }
}
