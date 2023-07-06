package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Test;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

public class FilesystemPackageCacheManagerTests {

  @Test
  public void testPrivatePackage() throws IOException {
    BasePackageCacheManager basePackageCacheManager = new BasePackageCacheManager() {
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
    PackageServer testServer = new PackageServer("http://localhost:4873").withServerType(PackageServer.PackageServerType.NPM).withMode(PackageServer.PackageServerAuthenticationMode.BASIC).withUsername("alfred").withPassword("numan");

    basePackageCacheManager.addPackageServer(testServer);
    basePackageCacheManager.myPackageServers.addAll(PackageServer.publicServers());

    BasePackageCacheManager.InputStreamWithSrc inputWithSrc = basePackageCacheManager.loadFromPackageServer("example.fhir.uv.myig", "0.2.0");


    NpmPackage npm = NpmPackage.fromPackage(inputWithSrc.stream, inputWithSrc.url, false);

    System.out.println(npm.description());
  }
}
