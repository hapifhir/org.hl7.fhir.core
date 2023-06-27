package org.hl7.fhir.utilities.npm;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PackageServerTest {

  @Test
  public void testPrivatePackage() throws IOException {
    PackageServer testServer = new PackageServer("http://localhost:4873")
      .withMode(PackageServer.PackageServerAuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM)
      .withUsername("alfred")
      .withPassword("numan");
    PackageClient packageClient = new PackageClient(testServer);

    List<PackageInfo> packageVersions = packageClient.getVersions("example.fhir.uv.myig");

    //System.out.println(packageVersions.get(0));

    InputStream inputStream = packageClient.fetch("example.fhir.uv.myig","0.2.0" );

    NpmPackage npmPackage = NpmPackage.fromPackage(inputStream);

    System.out.println(npmPackage.description());

  }
}
