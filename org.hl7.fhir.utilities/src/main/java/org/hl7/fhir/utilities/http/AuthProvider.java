package org.hl7.fhir.utilities.http;

import java.net.URL;
import java.util.Map;

interface AuthProvider {
  HTTPAuthenticationMode getHTTPAuthenticationMode(URL url);

  String getUsername(URL url);

  String getPassword(URL url);

  String getToken(URL url);

  String getAPIKey(URL url);

  Map<String, String> getHeaders(URL url);
}
