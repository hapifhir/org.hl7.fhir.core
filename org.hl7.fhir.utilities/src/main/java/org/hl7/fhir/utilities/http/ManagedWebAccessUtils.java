package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

public class ManagedWebAccessUtils {

  public static ServerDetailsPOJO getServer(String mode, String url, Iterable<ServerDetailsPOJO> serverAuthDetails) {
    if (serverAuthDetails != null) {
      for (ServerDetailsPOJO t : serverAuthDetails) {
        if (url.startsWith(t.getUrl()) && modesMatch(mode, t.getMode())) {
          return t;
        }
      }
    }
    return null;
  }

  private static boolean modesMatch(String criteria, String value) {
    return criteria == null || value == null || criteria.equals(value);
  }

}
