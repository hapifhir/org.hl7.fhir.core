package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

public class ManagedWebAccessUtils {

  public static ServerDetailsPOJO getServer(String url, Iterable<ServerDetailsPOJO> serverAuthDetails) {
    if (serverAuthDetails != null) {
      for (ServerDetailsPOJO t : serverAuthDetails) {
        if (url.startsWith(t.getUrl())) {
          return t;
        }
      }
    }
    return null;
  }
}
