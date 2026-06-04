package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ManagedWebAccessUtils {

  public static ServerDetailsPOJO getServer(Iterable<String> serverTypes, String url, Iterable<ServerDetailsPOJO> serverAuthDetails) {
    if (serverAuthDetails != null) {
      for (ServerDetailsPOJO serverDetails : serverAuthDetails) {
        for (String serverType : serverTypes) {
          if (urlMatchesOrigin(url, serverDetails.getUrl()) && typesMatch(serverType, serverDetails.getType())) {
            return serverDetails;
          }
        }
      }
    }
    return null;
  }

  public static ServerDetailsPOJO getServer(String url, Iterable<ServerDetailsPOJO> serverAuthDetails) {
    if (serverAuthDetails != null) {
      for (ServerDetailsPOJO serverDetails : serverAuthDetails) {
          if (urlMatchesOrigin(url, serverDetails.getUrl())) {
            return serverDetails;
          }
      }
    }
    return null;
  }

  public static boolean urlMatchesOrigin(String requestUrlString, String serverUrlString) {
    try {
      URL requestUrl = new URL(requestUrlString);
      URL serverUrl = new URL(serverUrlString);
      return urlMatchesOrigin(requestUrl, serverUrl);
    } catch (MalformedURLException e) {
      return false;
    }
  }

  public static boolean urlMatchesOrigin(URL requestUrl, URL serverUrl) {
    return requestUrl.getProtocol().equals(serverUrl.getProtocol())
      && requestUrl.getHost().equals(serverUrl.getHost())
      && getExplicitOrInferredPort(requestUrl) == getExplicitOrInferredPort(serverUrl)
      && requestUrl.getPath().startsWith(serverUrl.getPath());
  }

  private static int getExplicitOrInferredPort(URL url) {
    int port = url.getPort();
    if (port != -1) {
      return port;
    }
    if (url.getProtocol().equals("https")) {
      return 443;
    }
    if (url.getProtocol().equals("http")) {
      return 80;
    }
    return port;
  }

  private static boolean typesMatch(String criteria, String value) {
    return criteria == null || value == null || criteria.equals(value);
  }

  public static byte[] getEncodedBasicAuth(String providedUsername, String providedPassword) {
    String auth = providedUsername + ":" + providedPassword;
    return Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
  }

}
