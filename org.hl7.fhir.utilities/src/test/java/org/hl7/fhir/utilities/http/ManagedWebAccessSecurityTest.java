package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManagedWebAccessSecurityTest {

  @AfterEach
  void cleanup() {
    // Reset to default state after each test
    ManagedWebAccess.loadFromFHIRSettings();
  }

  /**
   * Helper method to set server auth details in ManagedWebAccess using reflection
   * since serverAuthDetails is private and only settable via loadFromFHIRSettings()
   */
  private void setServerAuthDetails(List<ServerDetailsPOJO> servers) throws Exception {
    Field field = ManagedWebAccess.class.getDeclaredField("serverAuthDetails");
    field.setAccessible(true);
    field.set(null, servers);
  }

  @Test
  public void testMakeSecureRef_withAllowHttp_keepsHttp() throws Exception {
    // Setup: Configure a server with allowHttp: true
    List<ServerDetailsPOJO> servers = new ArrayList<>();
    servers.add(ServerDetailsPOJO.builder()
      .url("http://my-term-server:8080/fhir")
      .type("fhir")
      .authenticationType("none")
      .allowHttp(true)
      .build());

    setServerAuthDetails(servers);
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    ManagedWebAccess.setUserAgent("test-agent");

    // Test: HTTP URL matching the configured server should remain HTTP
    String httpUrl = "http://my-term-server:8080/fhir/ValueSet/$validate-code";
    String result = ManagedWebAccess.makeSecureRef(httpUrl);
    
    assertThat(result).isEqualTo(httpUrl);
  }

  @Test
  public void testMakeSecureRef_withoutAllowHttp_upgradesHttps() throws Exception {
    // Setup: Configure a server without allowHttp
    List<ServerDetailsPOJO> servers = new ArrayList<>();
    servers.add(ServerDetailsPOJO.builder()
      .url("http://external-server.com/fhir")
      .type("fhir")
      .authenticationType("none")
      .allowHttp(false)
      .build());

    setServerAuthDetails(servers);
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    ManagedWebAccess.setUserAgent("test-agent");

    // Test: HTTP URL should be upgraded to HTTPS when allowHttp is false
    String httpUrl = "http://external-server.com/fhir/metadata";
    String result = ManagedWebAccess.makeSecureRef(httpUrl);
    
    assertThat(result).isEqualTo("https://external-server.com/fhir/metadata");
  }

  @Test
  public void testMakeSecureRef_withNullAllowHttp_upgradesHttps() throws Exception {
    // Setup: Configure a server with null allowHttp (default behavior)
    List<ServerDetailsPOJO> servers = new ArrayList<>();
    servers.add(ServerDetailsPOJO.builder()
      .url("http://some-server.com/fhir")
      .type("fhir")
      .authenticationType("none")
      .allowHttp(null)
      .build());

    setServerAuthDetails(servers);
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    ManagedWebAccess.setUserAgent("test-agent");

    // Test: HTTP URL should be upgraded to HTTPS when allowHttp is null
    String httpUrl = "http://some-server.com/fhir/metadata";
    String result = ManagedWebAccess.makeSecureRef(httpUrl);
    
    assertThat(result).isEqualTo("https://some-server.com/fhir/metadata");
  }

  @Test
  public void testMakeSecureRef_emptyUrlConfig_doesNotMatchAll() throws Exception {
    // Setup: Configure a server with empty URL (security vulnerability test)
    List<ServerDetailsPOJO> servers = new ArrayList<>();
    servers.add(ServerDetailsPOJO.builder()
      .url("")
      .type("fhir")
      .authenticationType("none")
      .allowHttp(true)
      .build());

    setServerAuthDetails(servers);
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    ManagedWebAccess.setUserAgent("test-agent");

    // Test: Empty URL config should NOT allow HTTP for all URLs
    String httpUrl = "http://malicious-site.com/data";
    String result = ManagedWebAccess.makeSecureRef(httpUrl);
    
    // Should be upgraded to HTTPS because empty URL shouldn't match
    assertThat(result).isEqualTo("https://malicious-site.com/data");
  }

  @Test
  public void testMakeSecureRef_localhost_alwaysAllowsHttp() {
    // Test: Hardcoded localhost addresses should remain HTTP
    assertThat(ManagedWebAccess.makeSecureRef("http://localhost:8080/fhir"))
      .isEqualTo("http://localhost:8080/fhir");
    
    assertThat(ManagedWebAccess.makeSecureRef("http://127.0.0.1:8080/fhir"))
      .isEqualTo("http://127.0.0.1:8080/fhir");
    
    assertThat(ManagedWebAccess.makeSecureRef("http://[::1]:8080/fhir"))
      .isEqualTo("http://[::1]:8080/fhir");
    
    assertThat(ManagedWebAccess.makeSecureRef("http://local.fhir.org/fhir"))
      .isEqualTo("http://local.fhir.org/fhir");
    
    assertThat(ManagedWebAccess.makeSecureRef("http://myapp.localhost/fhir"))
      .isEqualTo("http://myapp.localhost/fhir");
  }

  @Test
  public void testMakeSecureRef_httpsUrl_remainsHttps() {
    // Test: HTTPS URLs should never be downgraded
    String httpsUrl = "https://secure-server.com/fhir";
    String result = ManagedWebAccess.makeSecureRef(httpsUrl);
    
    assertThat(result).isEqualTo(httpsUrl);
  }

  @Test
  public void testMakeSecureRef_nullUrl_returnsNull() {
    // Test: Null URL should be handled gracefully
    String result = ManagedWebAccess.makeSecureRef(null);
    assertThat(result).isNull();
  }

  @Test
  public void testMakeSecureRef_partialUrlMatch_doesNotAllowHttp() throws Exception {
    // Setup: Configure a server with allowHttp for a specific base URL
    List<ServerDetailsPOJO> servers = new ArrayList<>();
    servers.add(ServerDetailsPOJO.builder()
      .url("http://my-term-server:8080/fhir")
      .type("fhir")
      .authenticationType("none")
      .allowHttp(true)
      .build());

    setServerAuthDetails(servers);
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    ManagedWebAccess.setUserAgent("test-agent");

    // Test: URL that doesn't start with configured URL should be upgraded
    String httpUrl = "http://different-server:8080/fhir/metadata";
    String result = ManagedWebAccess.makeSecureRef(httpUrl);
    
    assertThat(result).isEqualTo("https://different-server:8080/fhir/metadata");
  }

  @Test
  public void testMakeSecureRef_dockerServiceName_withAllowHttp() throws Exception {
    // Setup: Docker scenario with service names
    List<ServerDetailsPOJO> servers = new ArrayList<>();
    servers.add(ServerDetailsPOJO.builder()
      .url("http://blaze-terminology:8080/fhir")
      .type("fhir")
      .authenticationType("none")
      .allowHttp(true)
      .build());

    setServerAuthDetails(servers);
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    ManagedWebAccess.setUserAgent("test-agent");

    // Test: Docker service name URL should remain HTTP
    String dockerUrl = "http://blaze-terminology:8080/fhir/metadata";
    String result = ManagedWebAccess.makeSecureRef(dockerUrl);
    
    assertThat(result).isEqualTo(dockerUrl);
  }

  @Test
  public void testMakeSecureRef_multipleServers_correctMatching() throws Exception {
    // Setup: Multiple servers, some with allowHttp, some without
    List<ServerDetailsPOJO> servers = new ArrayList<>();
    servers.add(ServerDetailsPOJO.builder()
      .url("http://internal-server:8080/fhir")
      .type("fhir")
      .authenticationType("none")
      .allowHttp(true)
      .build());
    servers.add(ServerDetailsPOJO.builder()
      .url("http://external-server.com/fhir")
      .type("fhir")
      .authenticationType("none")
      .allowHttp(false)
      .build());

    setServerAuthDetails(servers);
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    ManagedWebAccess.setUserAgent("test-agent");

    // Test: Internal server URL should remain HTTP
    assertThat(ManagedWebAccess.makeSecureRef("http://internal-server:8080/fhir/metadata"))
      .isEqualTo("http://internal-server:8080/fhir/metadata");

    // Test: External server URL should be upgraded to HTTPS
    assertThat(ManagedWebAccess.makeSecureRef("http://external-server.com/fhir/metadata"))
      .isEqualTo("https://external-server.com/fhir/metadata");
  }
}
