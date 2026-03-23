package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManagedWebAccessUtilsTests {
  static final ServerDetailsPOJO expectedServer =  new ServerDetailsPOJO(
     "https://packages.fhir.org",
      "basic",
      "fhir",
      "DUMMY_USERNAME",
      "DUMMY_PASSWORD",
      null, null, null, null);

  static final ServerDetailsPOJO someOtherServer =  new ServerDetailsPOJO(
    "https://example.org",
    "token",
    "web",
    null,
    null,
    "dummy_token", null, null, null);


  @Test
  public void getDetailsForServer()
  {
    ServerDetailsPOJO actual = ManagedWebAccessUtils.getServer("https://packages.fhir.org/packages", List.of(expectedServer, someOtherServer));
    assertThat(actual).isEqualTo(expectedServer);
  }

  @Test
  public void dontGetDetailsForMaliciousServer() {
    ServerDetailsPOJO actual = ManagedWebAccessUtils.getServer("https://packages.fhir.org.malicious.com", List.of(expectedServer, someOtherServer));
    assertThat(actual).isNull();
  }
}
