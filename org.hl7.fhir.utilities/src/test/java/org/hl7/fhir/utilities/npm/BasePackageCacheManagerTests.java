package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasePackageCacheManagerTests {

  @Test
  public void testPackageBasicAuth() throws IOException {
    BasePackageCacheManager basePackageCacheManager = getFakeBasePackageCacheManager();

    MockPackageServer server = new MockPackageServer();
    String packageServerUrl = server.getPackageServerUrl();

    server.enqueueDummyPackageDescription();
    server.enqueueDummyPackage();

    PackageServer testServer = new PackageServer(packageServerUrl)
      .withAuthenticationMode(SimpleHTTPClient.AuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM)
      .withUsername(MockPackageServer.DUMMY_USERNAME)
      .withPassword(MockPackageServer.DUMMY_PASSWORD);

    basePackageCacheManager.addPackageServer(testServer);
    basePackageCacheManager.myPackageServers.addAll(PackageServer.defaultServers());

    BasePackageCacheManager.InputStreamWithSrc inputWithSrc = basePackageCacheManager.loadFromPackageServer("example.fhir.uv.myig", "0.2.0");

    assertCorrectPackageContent(inputWithSrc);
    server.shutdown();
  }

  @Test
  @DisplayName("Test that package management moves to next server after 404")
  public void testPackageWithConfiguredServer404() throws IOException {
    BasePackageCacheManager basePackageCacheManager = getFakeBasePackageCacheManager();

    MockPackageServer serverA = new MockPackageServer();
    serverA.enqueueResponseCode(404);

    MockPackageServer serverB = new MockPackageServer();

    serverB.enqueueDummyPackageDescription();
    serverB.enqueueDummyPackage();

    String packageServerAUrl = serverA.getPackageServerUrl();
    String packageServerBUrl = serverB.getPackageServerUrl();

    PackageServer testServerA = new PackageServer(packageServerAUrl)
      .withAuthenticationMode(SimpleHTTPClient.AuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM);

    PackageServer testServerB = new PackageServer(packageServerBUrl)
      .withAuthenticationMode(SimpleHTTPClient.AuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM);

    basePackageCacheManager.addPackageServer(testServerA);
    basePackageCacheManager.addPackageServer(testServerB);
    basePackageCacheManager.myPackageServers.addAll(PackageServer.defaultServers());

    BasePackageCacheManager.InputStreamWithSrc inputWithSrc = basePackageCacheManager.loadFromPackageServer("example.fhir.uv.myig", "0.2.0");

    assertCorrectPackageContent(inputWithSrc);
    serverA.shutdown();
    serverB.shutdown();
  }

  private static void assertCorrectPackageContent(BasePackageCacheManager.InputStreamWithSrc inputWithSrc) throws IOException {
    NpmPackage npmPackage = NpmPackage.fromPackage(inputWithSrc.stream, inputWithSrc.url, false);

    assertEquals("Dummy IG For Testing", npmPackage.title())
    ;
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
    };
  }

}
