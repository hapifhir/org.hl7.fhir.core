package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonUtilities;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

/**
 * Manages OAuth 2.0 access tokens for the client_credentials grant type.
 * <p>
 * When a FHIR server (or other endpoint) is configured with authenticationType
 * "client_credentials" in fhir-settings.json, this class handles fetching bearer
 * tokens from the configured token endpoint and caching them until they expire.
 * <p>
 * Token lifecycle:
 * <ul>
 *   <li>{@link #getToken} returns a cached token if it is still valid, or
 *       fetches a new one from the token endpoint using a standard OAuth 2.0
 *       client_credentials POST request.</li>
 *   <li>Tokens are treated as expired {@value #EXPIRY_BUFFER_SECONDS} seconds before their
 *       actual expiry, so an about-to-expire token is re-fetched on the next {@link #getToken}
 *       call (rather than handed out and failing mid-request) — there is no background refresh.</li>
 *   <li>{@link #invalidateToken} removes a cached token, forcing the next call to
 *       re-fetch. This is used by the retry logic in
 *       {@link ManagedWebAccessorBase#executeWithClientCredentialsRetry} (invoked via
 *       {@link IHTTPAuthenticationProvider#invalidateCachedCredentials}) when a server
 *       returns 401/403; it applies to any server, not only FHIR.</li>
 * </ul>
 * <p>
 * Thread safety: concurrent callers requesting a token for the same server will
 * block on a per-cache-key lock so that only one thread performs the HTTP request.
 */
@Slf4j
public class HTTPTokenManager {

  private static final int DEFAULT_EXPIRES_IN = 3600;

  /** Tokens are considered expired this many seconds before their actual expiry. */
  private static final int EXPIRY_BUFFER_SECONDS = 30;

  /** Cached tokens keyed by "tokenEndpoint|clientId". */
  private static final ConcurrentHashMap<String, CachedToken> cache = new ConcurrentHashMap<>();

  /** Per-cache-key lock objects to prevent concurrent token fetches for the same server. */
  private static final ConcurrentHashMap<String, Object> locks = new ConcurrentHashMap<>();

  private static final class CachedToken {
    final String accessToken;
    final long expiresAtMillis;
    /**
     * Buffer actually applied to this token. Clamped to half the token's lifetime so that a
     * short-lived token (an IdP issuing {@code expires_in} at or below the buffer) is still
     * usable from cache - otherwise every single call would miss and re-fetch, doubling the
     * request count against both the IdP and the server indefinitely.
     */
    final long bufferMillis;

    CachedToken(String accessToken, long expiresAtMillis, int expiresInSeconds) {
      this.accessToken = accessToken;
      this.expiresAtMillis = expiresAtMillis;
      this.bufferMillis = Math.min(EXPIRY_BUFFER_SECONDS, expiresInSeconds / 2) * 1000L;
    }

    boolean isExpiringSoon() {
      return System.currentTimeMillis() >= (expiresAtMillis - bufferMillis);
    }
  }

  private HTTPTokenManager() {}

  /**
   * Returns a valid access token for the given server, fetching a new one if
   * the cached token is missing or expiring soon.
   *
   * @param server the server configuration containing clientId, clientSecret, and tokenEndpoint
   * @return a bearer access token string
   * @throws IOException if the token endpoint request fails
   */
  public static String getToken(ServerDetailsPOJO server) throws IOException {
    String cacheKey = getCacheKey(server);
    CachedToken cached = cache.get(cacheKey);

    // Fast path: return cached token if still valid
    if (cached != null && !cached.isExpiringSoon()) {
      return cached.accessToken;
    }

    // Slow path: acquire per-key lock and fetch a new token.
    // Double-check after locking in case another thread already refreshed it.
    Object lock = locks.computeIfAbsent(cacheKey, k -> new Object());
    synchronized (lock) {
      cached = cache.get(cacheKey);
      if (cached != null && !cached.isExpiringSoon()) {
        return cached.accessToken;
      }

      CachedToken newToken = requestTokenWithClientCredentials(server);
      cache.put(cacheKey, newToken);
      return newToken.accessToken;
    }
  }

  /**
   * Removes the cached token for the given server, forcing the next
   * {@link #getToken} call to fetch a fresh token from the endpoint.
   *
   * @return true if a token was actually cached and has now been removed. False means the 401/403
   *   that prompted this cannot have been caused by a stale cached token, so retrying would just
   *   repeat the same failure - see {@link IHTTPAuthenticationProvider#invalidateCachedCredentials}.
   */
  public static boolean invalidateToken(ServerDetailsPOJO server) {
    return cache.remove(getCacheKey(server)) != null;
  }

  public static void clearCache() {
    cache.clear();
    locks.clear();
  }

  private static String getCacheKey(ServerDetailsPOJO server) {
    // Assumes (tokenEndpoint, clientId) fully identifies the issued token. If scope/audience are ever added to the token request, they MUST be folded into this key to avoid serving a token minted for a different scope.
    return server.getTokenEndpoint() + "|" + server.getClientId();
  }

  /**
   * Builds and sends an OAuth 2.0 client_credentials token request.
   * The client authenticates via form-encoded client_id and client_secret
   * (as per RFC 6749 Section 4.4).
   */
  private static CachedToken requestTokenWithClientCredentials(ServerDetailsPOJO server) throws IOException {
    requireClientCredentialsFields(server);
    String body = "grant_type=client_credentials"
      + "&client_id=" + Utilities.URLEncode(server.getClientId())
      + "&client_secret=" + Utilities.URLEncode(server.getClientSecret());
    return executeTokenRequest(server, server.getTokenEndpoint(), body);
  }

  /**
   * Validates the fields a client_credentials grant needs, at the point of use.
   * <p>
   * The settings-file loader validates too, but entries also arrive via
   * {@link ManagedWebAccess#loadFromSettings(org.hl7.fhir.utilities.settings.FhirSettingsPOJO)} and
   * {@link ManagedWebAccess#loadFromFHIRSettings(org.hl7.fhir.utilities.settings.FhirSettingsPOJO)},
   * which do not go through it - without this an incomplete entry surfaced as a
   * {@link NullPointerException} out of {@code URI.create(null)} or {@code URLEncode(null)}.
   */
  static void requireClientCredentialsFields(ServerDetailsPOJO server) throws IOException {
    if (isBlank(server.getTokenEndpoint())) {
      throw new IOException("Server " + server.getUrl() + " uses client_credentials but has no tokenEndpoint");
    }
    if (isBlank(server.getClientId())) {
      throw new IOException("Server " + server.getUrl() + " uses client_credentials but has no clientId");
    }
    if (isBlank(server.getClientSecret())) {
      throw new IOException("Server " + server.getUrl() + " uses client_credentials but has no clientSecret");
    }
  }

  private static boolean isBlank(String s) {
    return s == null || s.isBlank();
  }

  /**
   * Grants the token endpoint exactly the trust configured for the server whose tokens it issues.
   * <p>
   * Headers are never supplied: the client_credentials grant authenticates in the request body,
   * and delegating to the real authentication provider could route straight back into this class.
   * {@link #canProvideHeaders} still returns true so that {@link #isProtocolAllowed} is consulted
   * instead of the blanket https-only check - a token endpoint may use plain http only when its
   * server is configured with {@code allowHttp}, and may sit on a private network only when that
   * server sets {@code allowPrivateNetwork}.
   */
  private static final class TokenEndpointPolicy implements IHTTPAuthenticationProvider {
    private final ServerDetailsPOJO server;

    TokenEndpointPolicy(ServerDetailsPOJO server) {
      this.server = server;
    }

    @Override
    public boolean isProtocolAllowed(java.net.URL url) {
      return "https".equals(url.getProtocol())
        || ("http".equals(url.getProtocol()) && Boolean.TRUE.equals(server.getAllowHttp()));
    }

    @Override
    public boolean canProvideHeaders(java.net.URL url) {
      return true;
    }

    @Override
    public java.util.Map<String, String> getHeaders(java.net.URL url) throws IOException {
      return java.util.Map.of();
    }

    @Override
    public boolean isPrivateNetworkAllowed(java.net.URL url) {
      return Boolean.TRUE.equals(server.getAllowPrivateNetwork());
    }
  }

  /**
   * POSTs the form body to the token endpoint and parses the JSON response
   * into a CachedToken with an expiry timestamp.
   * <p>
   * The request goes through {@link ManagedWebAccessor} rather than a raw connection so that the
   * token endpoint is subject to the same controls as every other outbound request: the
   * {@link ManagedWebAccess.WebAccessPolicy} (so {@code prohibitNetworkAccess} actually prohibits
   * it), the allowed-paths policy, protocol allow-listing, and SSRF address-range blocking.
   */
  private static CachedToken executeTokenRequest(ServerDetailsPOJO server, String tokenEndpoint, String formBody)
      throws IOException {
    // No retries: a retry re-sends the client secret, and token-endpoint errors (invalid_client,
    // invalid_scope) are permanent - repeating them buys nothing and doubles the exposure.
    ManagedWebAccessor accessor = new ManagedWebAccessor(
      java.util.List.of("fhir"), ManagedWebAccess.getUserAgent(), new TokenEndpointPolicy(server))
      .withRetries(0);

    HTTPResult result = accessor.post(tokenEndpoint,
      formBody.getBytes(StandardCharsets.UTF_8),
      "application/x-www-form-urlencoded",
      "application/json");

    int responseCode = result.getCode();
    if (responseCode < 200 || responseCode >= 300) {
      throw new IOException("Token endpoint " + tokenEndpoint + " returned HTTP " + responseCode
        + ": " + safeOAuthError(result.getContentAsString()));
    }
    return parseTokenResponse(tokenEndpoint, result.getContentAsString());
  }

  private static CachedToken parseTokenResponse(String tokenEndpoint, String responseBody) throws IOException {
    JsonObject json;
    try {
      json = JsonParser.parseString(responseBody).getAsJsonObject();
    } catch (Exception e) {
      throw new IOException("Token endpoint " + tokenEndpoint + " returned a non-JSON response (body suppressed)", e);
    }

    String accessToken = JsonUtilities.str(json, "access_token");
    if (accessToken == null) {
      throw new IOException("Token endpoint " + tokenEndpoint + " response missing 'access_token' field");
    }

    int expiresIn;
    if (json.has("expires_in") && !json.get("expires_in").isJsonNull()) {
      try {
        expiresIn = json.get("expires_in").getAsInt();
      } catch (RuntimeException e) {
        log.warn("Token endpoint {} returned non-integer expires_in, defaulting to {}s", tokenEndpoint, DEFAULT_EXPIRES_IN);
        expiresIn = DEFAULT_EXPIRES_IN;
      }
    } else {
      log.warn("Token endpoint {} response missing 'expires_in', defaulting to {}s", tokenEndpoint, DEFAULT_EXPIRES_IN);
      expiresIn = DEFAULT_EXPIRES_IN;
    }

    if (expiresIn <= 0) {
      log.warn("Token endpoint {} returned non-positive expires_in={}, defaulting to {}s", tokenEndpoint, expiresIn, DEFAULT_EXPIRES_IN);
      expiresIn = DEFAULT_EXPIRES_IN;
    }

    long expiresAtMillis = System.currentTimeMillis() + (expiresIn * 1000L);
    return new CachedToken(accessToken, expiresAtMillis, expiresIn);
  }

  /** Extracts OAuth error/error_description if the body is JSON; never includes the raw body (may contain credentials). */
  private static String safeOAuthError(String body) {
    try {
      com.google.gson.JsonObject o = com.google.gson.JsonParser.parseString(body).getAsJsonObject();
      String err = org.hl7.fhir.utilities.json.JsonUtilities.str(o, "error");
      String desc = org.hl7.fhir.utilities.json.JsonUtilities.str(o, "error_description");
      if (err != null) return err + (desc != null ? ": " + desc : "");
    } catch (Exception ignore) { /* not JSON */ }
    return "(response body suppressed)";
  }

}
