package org.hl7.fhir.utilities.settings;

import java.net.MalformedURLException;
import java.net.URI;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.apache.commons.lang3.StringUtils;

/**
 * Credentials for the OAuth 2.0 client_credentials grant (RFC 6749 §4.4), used by a
 * {@link ServerDetailsPOJO} whose {@code authenticationType} is {@code oauth_client_credentials}.
 * <pre>
 * "oauthClientCredentials" : {
 *   "clientId" : "...",
 *   "clientSecret" : "...",
 *   "tokenEndpoint" : "https://..."
 * }
 * </pre>
 * The token endpoint must use https: the client secret is sent to it in the request body, and
 * RFC 6749 §2.3.1 and §3.2 require TLS for client authentication at the token endpoint.
 */
@Data
@Builder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
public class OAuthClientCredentialsPOJO {

  String clientId;

  @ToString.Exclude
  String clientSecret;

  String tokenEndpoint;

  /**
   * @return a description of the first missing or unusable field, or null if these credentials can be used
   */
  public String findProblem() {
    if (StringUtils.isBlank(clientId)) {
      return "is missing required field: clientId";
    }
    if (StringUtils.isBlank(clientSecret)) {
      return "is missing required field: clientSecret";
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
}
