package org.hl7.fhir.utilities.settings;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
public class ServerDetailsPOJO {
  
    String url;

    // possible values: none, basic, token, apikey
    String authenticationType;

  /**
   * This helps clients use appropriate API endpoints for each server type.
   * <p/>
   * It can be of the following types:
   *  <ul>
   *    <li>web</li>
   *    <li>fhir</li>
   *    <li>npm-package</li>
   *    <li>fhir-package</li>
   *  </ul>
   */

    String type;

    String username;

    String password;

    String token;

    String apikey;

    /**
     * When true, allows HTTP connections to this server without upgrading to HTTPS.
     * Use this for internal servers (e.g. Docker service names) that don't support HTTPS.
     */
    Boolean allowHttp;

    /**
     * When true, allows this server to be reached even if it resolves to a private/internal
     * address (RFC1918, loopback, link-local, cloud metadata, etc.), bypassing SSRF protection
     * for this server only. Use this for internal servers that legitimately live on a private
     * network - independent of whether they also require {@link #allowHttp}.
     */
    Boolean allowPrivateNetwork;

    Map<String, String> headers;

    /**
     * Returns a deep copy, with a new {@link #headers} map, so that mutating the copy cannot affect this instance.
     */
    public ServerDetailsPOJO copy() {
      return toBuilder()
        .headers(headers == null ? null : new HashMap<>(headers))
        .build();
    }
}
