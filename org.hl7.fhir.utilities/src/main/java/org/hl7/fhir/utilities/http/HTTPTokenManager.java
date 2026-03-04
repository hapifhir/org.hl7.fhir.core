package org.hl7.fhir.utilities.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

@Slf4j
public class HTTPTokenManager {

  private static final int DEFAULT_EXPIRES_IN = 3600;
  private static final int EXPIRY_BUFFER_SECONDS = 30;

  private static final ConcurrentHashMap<String, CachedToken> cache = new ConcurrentHashMap<>();

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

  public static String getToken(ServerDetailsPOJO server) throws IOException {
    String cacheKey = getCacheKey(server);
    CachedToken cached = cache.get(cacheKey);

    if (cached != null && !cached.isExpiringSoon()) {
      return cached.accessToken;
    }

    synchronized (cacheKey.intern()) {
      // double-check after acquiring lock
      cached = cache.get(cacheKey);
      if (cached != null && !cached.isExpiringSoon()) {
        return cached.accessToken;
      }

      CachedToken newToken = requestTokenWithClientCredentials(server);
      cache.put(cacheKey, newToken);
      return newToken.accessToken;
    }
  }

  public static void invalidateToken(ServerDetailsPOJO server) {
    cache.remove(getCacheKey(server));
  }

  public static void clearCache() {
    cache.clear();
  }

  private static String getCacheKey(ServerDetailsPOJO server) {
    return server.getTokenEndpoint() + "|" + server.getClientId();
  }

  private static CachedToken requestTokenWithClientCredentials(ServerDetailsPOJO server) throws IOException {
    String body = "grant_type=client_credentials"
      + "&client_id=" + urlEncode(server.getClientId())
      + "&client_secret=" + urlEncode(server.getClientSecret());
    return executeTokenRequest(server.getTokenEndpoint(), body);
  }

  private static CachedToken executeTokenRequest(String tokenEndpoint, String formBody) throws IOException {
    URL url = new URL(tokenEndpoint);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
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
        String errorBody = readStream(conn);
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

  private static String readStream(HttpURLConnection conn) {
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
