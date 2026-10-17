package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.LongSupplier;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonUtilities;
import org.hl7.fhir.utilities.settings.OAuthClientCredentialsPOJO;

/**
 * Manages OAuth 2.0 access tokens for the client_credentials grant type (RFC 6749 §4.4).
 * <p>
 * When a server is configured with authenticationType "oauth_client_credentials" in
 * fhir-settings.json, this class handles fetching bearer tokens from the configured token
 * endpoint and caching them until they expire.
 * <p>
 * Token lifecycle:
 * <ul>
 *   <li>{@link #getToken} returns a cached token if it is still valid, or
 *       fetches a new one from the token endpoint using a standard OAuth 2.0
 *       client_credentials POST request.</li>
 *   <li>Tokens are treated as expired {@value #EXPIRY_BUFFER_SECONDS} seconds before their
 *       actual expiry, so an about-to-expire token is re-fetched on the next {@link #getToken}
 *       call (rather than handed out and failing mid-request) — there is no background refresh.
 *       A token is never cached for longer than {@value #MAX_EXPIRES_IN_SECONDS} seconds,
 *       whatever {@code expires_in} the token endpoint returns.</li>
 *   <li>{@link #invalidateToken} removes a cached token, forcing the next call to
 *       re-fetch. {@link ManagedHTTPClient} calls it (via
 *       {@link IHTTPAuthenticationProvider#invalidateCachedCredentials}) when a server
 *       returns 401, then retries the request once; it applies to any server, not only FHIR.</li>
 * </ul>
 * <p>
 * Thread safety: concurrent callers requesting a token for the same credentials will
 * block on a per-cache-key lock so that only one thread performs the HTTP request.
 */
@Slf4j
public class HTTPTokenManager {

  private static final int DEFAULT_EXPIRES_IN = 3600;

  /** Upper bound on how long a token is cached, so that a rotated or revoked secret eventually takes effect. */
  static final int MAX_EXPIRES_IN_SECONDS = 24 * 3600;

  /** Tokens are considered expired this many seconds before their actual expiry. */
  private static final int EXPIRY_BUFFER_SECONDS = 30;

  /** Cached tokens keyed by {@link #getCacheKey}. */
  private static final ConcurrentHashMap<String, CachedToken> cache = new ConcurrentHashMap<>();

  /** Per-cache-key lock objects to prevent concurrent token fetches for the same credentials. */
  private static final ConcurrentHashMap<String, Object> locks = new ConcurrentHashMap<>();

  /**
   * Monotonic clock for token expiry, so a wall-clock adjustment cannot make an expired token
   * look valid or a valid one expire early. Replaceable by tests.
   */
  static LongSupplier nanoClock = System::nanoTime;

  private static final class CachedToken {
    final String accessToken;
    final long expiresAtNanos;
    /**
     * Buffer actually applied to this token. Clamped to half the token's lifetime so that a
     * short-lived token (an IdP issuing {@code expires_in} at or below the buffer) is still
     * usable from cache - otherwise every single call would miss and re-fetch, doubling the
     * request count against both the IdP and the server indefinitely.
     */
    final long bufferNanos;

    CachedToken(String accessToken, int expiresInSeconds) {
      this.accessToken = accessToken;
      this.expiresAtNanos = nanoClock.getAsLong() + TimeUnit.SECONDS.toNanos(expiresInSeconds);
      this.bufferNanos = TimeUnit.SECONDS.toNanos(Math.min(EXPIRY_BUFFER_SECONDS, expiresInSeconds / 2));
    }

    boolean isExpiringSoon() {
      // Compared by difference, as System.nanoTime() values may be negative or wrap.
      return nanoClock.getAsLong() - (expiresAtNanos - bufferNanos) >= 0;
    }
  }

  private HTTPTokenManager() {}

  /**
   * Returns a valid access token for the given credentials, fetching a new one if
   * the cached token is missing or expiring soon.
   *
   * @param credentials the clientId, clientSecret, and tokenEndpoint to use
   * @param allowPrivateNetwork whether the token endpoint may be on a private network - the
   *   {@code allowPrivateNetwork} setting of the server the token is for
   * @return a bearer access token string
   * @throws IOException if the credentials are incomplete or the token endpoint request fails
   */
  public static String getToken(OAuthClientCredentialsPOJO credentials, boolean allowPrivateNetwork) throws IOException {
    requireUsable(credentials);
    String cacheKey = getCacheKey(credentials);
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

      CachedToken newToken = requestTokenWithClientCredentials(credentials, allowPrivateNetwork);
      cache.put(cacheKey, newToken);
      return newToken.accessToken;
    }
  }

  /**
   * Discards {@code rejectedToken} if it is still the cached token for these credentials, so the
   * next {@link #getToken} call fetches a fresh one.
   * <p>
   * A newer cached token is left alone: when concurrent requests are all rejected with the same
   * stale token, the first to get here discards it and fetches a replacement, and the rest must
   * neither discard that replacement nor give up - they retry with it.
   *
   * @return true if {@code rejectedToken} is no longer cached - it was discarded here or already
   *   replaced - so a retry will use a different token; see
   *   {@link IHTTPAuthenticationProvider#invalidateCachedCredentials}.
   */
  public static boolean invalidateToken(OAuthClientCredentialsPOJO credentials, String rejectedToken) {
    if (credentials == null || credentials.findProblem() != null || rejectedToken == null) {
      return false;
    }
    String cacheKey = getCacheKey(credentials);
    CachedToken cached = cache.get(cacheKey);
    if (cached != null && cached.accessToken.equals(rejectedToken)) {
      cache.remove(cacheKey, cached);
    }
    return true;
  }

  /** Discards every cached token - called whenever settings are (re)loaded. */
  static void clearCache() {
    cache.clear();
    locks.clear();
  }

  /**
   * Includes a digest of the secret, so that two configurations differing only in their secret
   * (or a secret rotated without a settings reload) never share a token.
   * <p>
   * Assumes (tokenEndpoint, clientId, clientSecret) fully identifies the issued token. If
   * scope/audience are ever added to the token request, they MUST be folded into this key to
   * avoid serving a token minted for a different scope.
   */
  private static String getCacheKey(OAuthClientCredentialsPOJO credentials) {
    return credentials.getTokenEndpoint() + "|" + credentials.getClientId() + "|" + sha256(credentials.getClientSecret());
  }

  private static String sha256(String value) {
    try {
      byte[] digest = MessageDigest.getInstance("SHA-256").digest(value.getBytes(StandardCharsets.UTF_8));
      return HexFormat.of().formatHex(digest);
    } catch (NoSuchAlgorithmException e) {
      // Every Java platform is required to support SHA-256
      throw new IllegalStateException(e);
    }
  }

  /**
   * Builds and sends an OAuth 2.0 client_credentials token request (RFC 6749 §4.4.2).
   * <p>
   * The client authenticates with client_id and client_secret in the form body
   * ({@code client_secret_post}). RFC 6749 §2.3.1 allows this but recommends HTTP Basic
   * ({@code client_secret_basic}), which is not currently supported: a token endpoint that only
   * accepts Basic will answer {@code invalid_client}.
   */
  private static CachedToken requestTokenWithClientCredentials(OAuthClientCredentialsPOJO credentials,
                                                               boolean allowPrivateNetwork) throws IOException {
    String body = "grant_type=client_credentials"
      + "&client_id=" + Utilities.URLEncode(credentials.getClientId())
      + "&client_secret=" + Utilities.URLEncode(credentials.getClientSecret());
    return executeTokenRequest(credentials.getTokenEndpoint(), allowPrivateNetwork, body);
  }

  /**
   * Validates the credentials at the point of use.
   * <p>
   * The settings-file loader reports problems too, but deliberately does not reject the entry
   * (see {@code FhirSettings.normalizeSettings}), and entries also arrive via
   * {@link ManagedWebAccess#loadFromSettings(org.hl7.fhir.utilities.settings.FhirSettingsPOJO)} and
   * {@link ManagedWebAccess#loadFromFHIRSettings(org.hl7.fhir.utilities.settings.FhirSettingsPOJO)},
   * which do not go through it. Failing here means a misconfigured server is never sent a request
   * without its credentials.
   */
  private static void requireUsable(OAuthClientCredentialsPOJO credentials) throws IOException {
    String problem = credentials == null ? "is missing" : credentials.findProblem();
    if (problem != null) {
      throw new IOException("OAuth client credentials configuration " + problem);
    }
  }

  /**
   * The network policy for the token request: the configured token endpoint (matched by origin
   * and path prefix, as for configured servers), over https only, and on a private network only
   * if the server whose tokens it issues sets {@code allowPrivateNetwork}.
   * <p>
   * Headers are never supplied: the client_credentials grant authenticates in the request body,
   * and delegating to the real authentication provider could route straight back into this class.
   * {@link #canProvideHeaders} still returns true for the token endpoint so that
   * {@link #isProtocolAllowed} and {@link #isPrivateNetworkAllowed} are consulted for it; any
   * other URL gets the default policy.
   */
  static final class TokenEndpointPolicy implements IHTTPAuthenticationProvider {
    private final String tokenEndpoint;
    private final boolean allowPrivateNetwork;

    TokenEndpointPolicy(String tokenEndpoint, boolean allowPrivateNetwork) {
      this.tokenEndpoint = tokenEndpoint;
      this.allowPrivateNetwork = allowPrivateNetwork;
    }

    private boolean isTokenEndpoint(URL url) {
      return ManagedWebAccessUtils.urlMatchesOrigin(url.toString(), tokenEndpoint);
    }

    @Override
    public boolean isProtocolAllowed(URL url) {
      return "https".equals(url.getProtocol()) && isTokenEndpoint(url);
    }

    @Override
    public boolean canProvideHeaders(URL url) {
      return isTokenEndpoint(url);
    }

    @Override
    public Map<String, String> getHeaders(URL url) {
      return Map.of();
    }

    @Override
    public boolean isPrivateNetworkAllowed(URL url) {
      return allowPrivateNetwork && isTokenEndpoint(url);
    }
  }

  /**
   * POSTs the form body to the token endpoint and parses the JSON response
   * into a CachedToken with an expiry timestamp.
   * <p>
   * Under {@link ManagedWebAccess.WebAccessPolicy#DIRECT} the request goes through
   * {@link ManagedHTTPClient}, so it is subject to the same controls as every other outbound
   * request: the allowed-paths policy, protocol allow-listing, the blocked-host list, and SSRF
   * address-range blocking. It is sent exactly once and redirects are not followed, as either
   * would re-send the client secret. Under {@link ManagedWebAccess.WebAccessPolicy#MANAGED} the
   * request - client secret included - is handed to the host application's
   * {@link IWebAccessor}, and enforcing any of this is up to that accessor.
   */
  private static CachedToken executeTokenRequest(String tokenEndpoint, boolean allowPrivateNetwork, String formBody)
      throws IOException {
    ManagedWebAccessor accessor = new ManagedWebAccessor(
      List.of("fhir"), ManagedWebAccess.getUserAgent(), new TokenEndpointPolicy(tokenEndpoint, allowPrivateNetwork))
      .withRetries(0)
      .withoutRedirects();

    HTTPResult result = accessor.post(tokenEndpoint,
      formBody.getBytes(StandardCharsets.UTF_8),
      "application/x-www-form-urlencoded",
      "application/json");

    int responseCode = result.getCode();
    if (responseCode >= 300 && responseCode < 400) {
      // RFC 6749 §4.4.3 answers a token request with a token response or an error response
      // (§5.1, §5.2) - a redirect is neither, and following one would hand the secret to its target.
      throw new IOException("Token endpoint " + tokenEndpoint + " returned a redirect (HTTP " + responseCode
        + "), which is not followed for token requests");
    }
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
    } catch (RuntimeException e) {
      // The cause is deliberately not chained: Gson includes the offending content in its
      // exception messages, which would defeat suppressing the body here.
      throw new IOException("Token endpoint " + tokenEndpoint + " did not return a JSON object (body suppressed)");
    }

    JsonElement accessTokenElement = json.get("access_token");
    if (accessTokenElement == null || accessTokenElement.isJsonNull()) {
      throw new IOException("Token endpoint " + tokenEndpoint + " response missing 'access_token' field");
    }
    if (!accessTokenElement.isJsonPrimitive() || !accessTokenElement.getAsJsonPrimitive().isString()) {
      throw new IOException("Token endpoint " + tokenEndpoint + " response has a non-string 'access_token' field");
    }
    String accessToken = accessTokenElement.getAsString();

    long expiresIn;
    if (json.has("expires_in") && !json.get("expires_in").isJsonNull()) {
      try {
        // As a long: getAsInt() silently wraps values beyond int range, e.g. 4294967297 to 1
        expiresIn = json.get("expires_in").getAsLong();
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
    if (expiresIn > MAX_EXPIRES_IN_SECONDS) {
      log.warn("Token endpoint {} returned expires_in={}, caching for at most {}s", tokenEndpoint, expiresIn, MAX_EXPIRES_IN_SECONDS);
      expiresIn = MAX_EXPIRES_IN_SECONDS;
    }

    return new CachedToken(accessToken, (int) expiresIn);
  }

  /** Extracts OAuth error/error_description if the body is JSON; never includes the raw body (may contain credentials). */
  private static String safeOAuthError(String body) {
    try {
      JsonObject o = JsonParser.parseString(body).getAsJsonObject();
      String err = JsonUtilities.str(o, "error");
      String desc = JsonUtilities.str(o, "error_description");
      if (err != null) return err + (desc != null ? ": " + desc : "");
    } catch (Exception ignore) { /* not JSON, or error/error_description not strings */ }
    return "(response body suppressed)";
  }

}
