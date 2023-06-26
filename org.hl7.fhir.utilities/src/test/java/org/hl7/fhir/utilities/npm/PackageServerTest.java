package org.hl7.fhir.utilities.npm;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PackageServerTest {

  @Test
  public void testPrivatePackage() throws IOException {
    PackageServer testServer = new PackageServer("http://localhost:4873").withMode(PackageServer.PackageServerAuthenticationMode.BASIC).withUsername("alfred").withPassword("numan");
    PackageClient packageClient = new PackageClient(testServer);

    List<PackageInfo> packageVersions = packageClient.getVersions("@mypackage/helloworld");

    System.out.println(packageVersions.get(0));

  }
}
