package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.http.HTTPAuthenticationMode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasePackageCacheManagerTests {

  @Test
  void testPackageBasicAuth() throws IOException {
    BasePackageCacheManager basePackageCacheManager = getFakeBasePackageCacheManager();

    MockPackageServer server = new MockPackageServer();
    String packageServerUrl = server.getPackageServerUrl();

    server.enqueueDummyPackageDescription();
    server.enqueueDummyPackage();

    PackageServer testServer = new PackageServer(packageServerUrl)
      .withAuthenticationMode(HTTPAuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM)
      .withUsername(MockPackageServer.DUMMY_USERNAME)
      .withPassword(MockPackageServer.DUMMY_PASSWORD)
      .withAllowHttp(true)
      .withAllowPrivateNetwork(true);

    basePackageCacheManager.addPackageServer(testServer);
    basePackageCacheManager.myPackageServers.addAll(PackageServer.defaultServers());

    BasePackageCacheManager.InputStreamWithSrc inputWithSrc = basePackageCacheManager.loadFromPackageServer("example.fhir.uv.myig", "0.2.0");

    assertCorrectPackageContent(inputWithSrc);
    server.shutdown();
  }

  @Test
  @DisplayName("Test that package management moves to next server after 404")
  void testPackageWithConfiguredServer404() throws IOException {
    BasePackageCacheManager basePackageCacheManager = getFakeBasePackageCacheManager();

    MockPackageServer serverA = new MockPackageServer();
    serverA.enqueueResponseCode(404);

    MockPackageServer serverB = new MockPackageServer();

    serverB.enqueueDummyPackageDescription();
    serverB.enqueueDummyPackage();

    String packageServerAUrl = serverA.getPackageServerUrl();
    String packageServerBUrl = serverB.getPackageServerUrl();

    PackageServer testServerA = new PackageServer(packageServerAUrl)
      .withAuthenticationMode(HTTPAuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM)
      .withAllowHttp(true)
      .withAllowPrivateNetwork(true);

    PackageServer testServerB = new PackageServer(packageServerBUrl)
      .withAuthenticationMode(HTTPAuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM)
      .withAllowHttp(true)
      .withAllowPrivateNetwork(true);

    basePackageCacheManager.addPackageServer(testServerA);
    basePackageCacheManager.addPackageServer(testServerB);
    basePackageCacheManager.myPackageServers.addAll(PackageServer.defaultServers());

    BasePackageCacheManager.InputStreamWithSrc inputWithSrc = basePackageCacheManager.loadFromPackageServer("example.fhir.uv.myig", "0.2.0");

    assertCorrectPackageContent(inputWithSrc);
    serverA.shutdown();
    serverB.shutdown();
  }

  // the catalog endpoint does partial matching on name and canonical, so a search for
  // hl7.terminology.r4 also returns hl7.terminology.r4b, and a search for the HL7 AU base
  // canonical also returns every package whose canonical starts with it. These responses
  // simulate that server behaviour; the lookups must not be misled by the near-misses.
  private static final String TERMINOLOGY_CATALOG_RESPONSE = "[" +
    "{\"name\":\"hl7.terminology.r4b\",\"version\":\"6.0.2\",\"fhirVersion\":\"4.3.0\",\"description\":\"terminology for r4b\"," +
    "\"url\":\"https://packages2.fhir.org/web/hl7.terminology.r4b-6.0.2.tgz\",\"canonical\":\"http://terminology.hl7.org\",\"date\":\"2024-01-01T00:00:00Z\"}," +
    "{\"name\":\"hl7.terminology.r4\",\"version\":\"6.0.2\",\"fhirVersion\":\"4.0.1\",\"description\":\"terminology for r4\"," +
    "\"url\":\"https://packages2.fhir.org/web/hl7.terminology.r4-6.0.2.tgz\",\"canonical\":\"http://terminology.hl7.org\",\"date\":\"2024-01-02T00:00:00Z\"}" +
    "]";

  private static final String AU_CATALOG_RESPONSE = "[" +
    "{\"name\":\"hl7.fhir.au.core\",\"version\":\"1.0.0\",\"fhirVersion\":\"4.0.1\",\"description\":\"AU core\"," +
    "\"url\":\"https://packages2.fhir.org/web/hl7.fhir.au.core-1.0.0.tgz\",\"canonical\":\"http://hl7.org.au/fhir/core\",\"date\":\"2024-01-01T00:00:00Z\"}," +
    "{\"name\":\"hl7.fhir.au.base\",\"version\":\"4.1.0\",\"fhirVersion\":\"4.0.1\",\"description\":\"AU base\"," +
    "\"url\":\"https://packages2.fhir.org/web/hl7.fhir.au.base-4.1.0.tgz\",\"canonical\":\"http://hl7.org.au/fhir\",\"date\":\"2024-01-02T00:00:00Z\"}" +
    "]";

  @Test
  @DisplayName("getPackageUrl returns the canonical of the exact id match, not the url of the first partial match")
  void testGetPackageUrlReturnsCanonicalOfExactMatch() throws IOException {
    BasePackageCacheManager basePackageCacheManager = getFakeBasePackageCacheManager();

    MockPackageServer server = new MockPackageServer();
    server.getMockWebServer().enqueue(new okhttp3.mockwebserver.MockResponse().setBody(TERMINOLOGY_CATALOG_RESPONSE));
    basePackageCacheManager.addPackageServer(
      new PackageServer(server.getPackageServerUrl())
        .withAllowHttp(true)
        .withAllowPrivateNetwork(true));

    assertEquals("http://terminology.hl7.org", basePackageCacheManager.getPackageUrl("hl7.terminology.r4"));
    server.shutdown();
  }

  @Test
  @DisplayName("getPackageUrl returns null when the only catalog matches are sibling packages")
  void testGetPackageUrlReturnsNullWhenNoExactMatch() throws IOException {
    BasePackageCacheManager basePackageCacheManager = getFakeBasePackageCacheManager();

    MockPackageServer server = new MockPackageServer();
    server.getMockWebServer().enqueue(new okhttp3.mockwebserver.MockResponse().setBody(TERMINOLOGY_CATALOG_RESPONSE));
    basePackageCacheManager.addPackageServer(new PackageServer(server.getPackageServerUrl()));

    assertNull(basePackageCacheManager.getPackageUrl("hl7.terminology"));
    server.shutdown();
  }

  @Test
  @DisplayName("getPackageId returns the exact canonical match, not the first partial match")
  void testGetPackageIdReturnsExactCanonicalMatch() throws IOException {
    BasePackageCacheManager basePackageCacheManager = getFakeBasePackageCacheManager();

    MockPackageServer server = new MockPackageServer();
    server.getMockWebServer().enqueue(new okhttp3.mockwebserver.MockResponse().setBody(AU_CATALOG_RESPONSE));
    basePackageCacheManager.addPackageServer(new PackageServer(server.getPackageServerUrl()).withAllowHttp(true)
      .withAllowPrivateNetwork(true));

    assertEquals("hl7.fhir.au.base", basePackageCacheManager.getPackageId("http://hl7.org.au/fhir"));
    server.shutdown();
  }

  @Test
  @DisplayName("getPackageId returns null when nothing matches the canonical exactly")
  void testGetPackageIdReturnsNullWhenNoExactMatch() throws IOException {
    BasePackageCacheManager basePackageCacheManager = getFakeBasePackageCacheManager();

    MockPackageServer server = new MockPackageServer();
    server.getMockWebServer().enqueue(new okhttp3.mockwebserver.MockResponse().setBody(AU_CATALOG_RESPONSE));
    basePackageCacheManager.addPackageServer(new PackageServer(server.getPackageServerUrl()));

    assertNull(basePackageCacheManager.getPackageId("http://hl7.org.au/fhir/other"));
    server.shutdown();
  }

  private static void assertCorrectPackageContent(BasePackageCacheManager.InputStreamWithSrc inputWithSrc) throws IOException {
    NpmPackage npmPackage = NpmPackage.fromPackage(inputWithSrc.stream, inputWithSrc.url, true);

    assertEquals("Dummy IG For Testing", npmPackage.title());
    assertEquals("Dummy IG description (built Thu, Jul 6, 2023 15:16-0400-04:00)", npmPackage.description());
  }

  @Nonnull
  private static BasePackageCacheManager getFakeBasePackageCacheManager() {
    return new BasePackageCacheManager() {
      @Override
      public NpmPackage loadPackageFromCacheOnly(String id, @Nullable String version) throws IOException {
        return null;
      }

      @Override
      public NpmPackage addPackageToCache(String id, String version, InputStream packageTgzInputStream, String sourceDesc) throws IOException {
        return null;
      }

      @Override
      public NpmPackage loadPackage(String id, String version) throws FHIRException, IOException {
        return null;
      }

      @Override
      public String getLatestVersion(String statedId, boolean milestonesOnly) throws IOException {
        return null;
      }

      @Override
      public String getLatestVersion(String statedId, String versionFilter) throws IOException {
        return null;
      }
    };
  }

}
