package org.hl7.fhir.utilities.settings;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
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

    Map<String, String> headers;
}
