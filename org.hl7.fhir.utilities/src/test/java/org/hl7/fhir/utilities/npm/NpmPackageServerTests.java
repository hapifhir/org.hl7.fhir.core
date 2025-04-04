package org.hl7.fhir.utilities.npm;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class NpmPackageServerTests {
  public static final String KNOWN_PACKAGE_ID = "hl7.fhir.us.core";
  public static final String KNOWN_PACKAGE_VERSION = "8.0.0-ballot";
  PackageServer server = new PackageServer("http://fs.get-ig.org/pkgs").withServerType(PackageServer.PackageServerType.NPM);
  @Test
  public void testKnownPackageExists() throws IOException {
    //hl7.fhir.us.core@8.0.0-ballot
    PackageClient client = new PackageClient(server);
    boolean knownPackageExists = client.exists(KNOWN_PACKAGE_ID, KNOWN_PACKAGE_VERSION);
    assertThat(knownPackageExists).isTrue();
  }

  @Test
  public void testBadPackageDoesntExist() throws IOException {
    PackageClient client = new PackageClient(server);
    boolean knownPackageExists = client.exists("not.a.real.package", "1.0.0");
    assertThat(knownPackageExists).isFalse();
  }

  @Test
  public void testGetPackage() throws IOException {
    PackageClient client = new PackageClient(server);
    InputStream inputStream = client.fetch(KNOWN_PACKAGE_ID, KNOWN_PACKAGE_VERSION);
    assertThat(inputStream).isNotNull();
    NpmPackage npmPackage = NpmPackage.fromPackage(inputStream);
    assertThat(npmPackage).isNotNull();
    assertThat(npmPackage.id()).isEqualTo(KNOWN_PACKAGE_ID);
  }

  @Test
  public void testGetPackageInfo() throws IOException {
    PackageClient client = new PackageClient(server);
    String url = client.url(KNOWN_PACKAGE_ID, KNOWN_PACKAGE_VERSION);
    System.out.println(url);
  }

}
