package org.hl7.fhir.utilities.npm;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PackageServerTest {

  @Test
  public void testPrivatePackage() throws IOException {
    PackageServer testServer = new PackageServer("http://localhost:4873").withMode(PackageServer.PackageServerAuthenticationMode.BASIC).withUsername("alfred").withPassword("numan");
    PackageClient packageClient = new PackageClient(testServer);

    packageClient.fetch("@mypackage/helloworld", "1.0.0");
  }
}
