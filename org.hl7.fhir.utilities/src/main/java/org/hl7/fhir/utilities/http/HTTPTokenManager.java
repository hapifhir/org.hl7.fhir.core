package org.hl7.fhir.utilities.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

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
 *   <li>Tokens are proactively refreshed {@value #EXPIRY_BUFFER_SECONDS} seconds
 *       before they expire, so callers are unlikely to receive an expired token.</li>
 *   <li>{@link #invalidateToken} removes a cached token, forcing the next call to
 *       re-fetch. This is used by the retry logic in ManagedWebAccessor /
 *       ManagedFhirWebAccessor when a FHIR server returns 401/403.</li>
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

    CachedToken(String accessToken, long expiresAtMillis) {
      this.accessToken = accessToken;
      this.expiresAtMillis = expiresAtMillis;
    }

    boolean isExpiringSoon() {
      return System.currentTimeMillis() >= (expiresAtMillis - EXPIRY_BUFFER_SECONDS * 1000L);
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
   */
  public static void invalidateToken(ServerDetailsPOJO server) {
    cache.remove(getCacheKey(server));
  }

  public static void clearCache() {
    cache.clear();
    locks.clear();
  }

  private static String getCacheKey(ServerDetailsPOJO server) {
    return server.getTokenEndpoint() + "|" + server.getClientId();
  }

  /**
   * Builds and sends an OAuth 2.0 client_credentials token request.
   * The client authenticates via form-encoded client_id and client_secret
   * (as per RFC 6749 Section 4.4).
   */
  private static CachedToken requestTokenWithClientCredentials(ServerDetailsPOJO server) throws IOException {
    String body = "grant_type=client_credentials"
      + "&client_id=" + urlEncode(server.getClientId())
      + "&client_secret=" + urlEncode(server.getClientSecret());
    return executeTokenRequest(server.getTokenEndpoint(), body);
  }

  /**
   * POSTs the form body to the token endpoint and parses the JSON response
   * into a CachedToken with an expiry timestamp.
   */
  private static CachedToken executeTokenRequest(String tokenEndpoint, String formBody) throws IOException {
    HttpURLConnection conn = (HttpURLConnection) URI.create(tokenEndpoint).toURL().openConnection();
    try {
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      conn.setRequestProperty("Accept", "application/json");
      conn.setDoOutput(true);

      try (OutputStream os = conn.getOutputStream()) {
        os.write(formBody.getBytes(StandardCharsets.UTF_8));
      }

      int responseCode = conn.getResponseCode();
      if (responseCode < 200 || responseCode >= 300) {
        String errorBody = readErrorStream(conn);
        throw new IOException("Token endpoint returned HTTP " + responseCode + ": " + errorBody);
      }

      String responseBody = readResponseBody(conn);
      JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();

      if (!json.has("access_token") || json.get("access_token").isJsonNull()) {
        throw new IOException("Token endpoint response missing 'access_token' field");
      }

      String accessToken = json.get("access_token").getAsString();

      int expiresIn;
      if (json.has("expires_in") && !json.get("expires_in").isJsonNull()) {
        expiresIn = json.get("expires_in").getAsInt();
      } else {
        log.warn("Token endpoint response missing 'expires_in', defaulting to {}s", DEFAULT_EXPIRES_IN);
        expiresIn = DEFAULT_EXPIRES_IN;
      }

      long expiresAtMillis = System.currentTimeMillis() + (expiresIn * 1000L);
      return new CachedToken(accessToken, expiresAtMillis);
    } finally {
      conn.disconnect();
    }
  }

  private static String readResponseBody(HttpURLConnection conn) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
      return sb.toString();
    }
  }

  /** Reads the error stream for inclusion in error messages. Never throws. */
  private static String readErrorStream(HttpURLConnection conn) {
    try {
      java.io.InputStream es = conn.getErrorStream();
      if (es == null) return "(no error body)";
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(es, StandardCharsets.UTF_8))) {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
          sb.append(line);
        }
        return sb.toString();
      }
    } catch (Exception e) {
      return "(unable to read error body)";
    }
  }

  private static String urlEncode(String value) {
    try {
      return java.net.URLEncoder.encode(value, StandardCharsets.UTF_8.name());
    } catch (java.io.UnsupportedEncodingException e) {
      // UTF-8 is always supported
      throw new RuntimeException(e);
    }
  }
}
