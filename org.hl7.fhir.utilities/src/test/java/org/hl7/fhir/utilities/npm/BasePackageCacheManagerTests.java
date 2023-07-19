package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasePackageCacheManagerTests {

  @Test
  public void testPrivatePackageBasicAuth() throws IOException {
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


    NpmPackage npmPackage = NpmPackage.fromPackage(inputWithSrc.stream, inputWithSrc.url, false);

    assertEquals("Dummy IG For Testing", npmPackage.title())
    ;
    assertEquals("Dummy IG description (built Thu, Jul 6, 2023 15:16-0400-04:00)", npmPackage.description());
    server.shutdown();
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
