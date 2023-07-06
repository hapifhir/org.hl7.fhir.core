package org.hl7.fhir.utilities.npm;

import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PackageServerTest {

  MockPackageServer server;

  @BeforeEach
  public void beforeEach() throws IOException {
    server = new MockPackageServer();
  }

  @AfterEach
  public void afterEach() throws IOException {
    server.shutdown();
  }

  @Test
  public void testPrivatePackageNpmServer() throws IOException, InterruptedException {

    String packageServerUrl = server.getPackageServerUrl();

    server.enqueueDummyPackageDescription();
    server.enqueueDummyPackage();

    PackageServer testServer = new PackageServer(packageServerUrl)
      .withMode(PackageServer.PackageServerAuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM)
      .withUsername(MockPackageServer.DUMMY_USERNAME)
      .withPassword(MockPackageServer.DUMMY_PASSWORD);
    PackageClient packageClient = new PackageClient(testServer);

    InputStream inputStream = packageClient.fetch(MockPackageServer.DUMMY_PACKAGE_NAME, MockPackageServer.DUMMY_PACKAGE_VERSION);

    RecordedRequest packageRequest = server.getMockWebServer().takeRequest();

    assertEquals(packageServerUrl + "/" + MockPackageServer.DUMMY_PACKAGE_NAME + "/" + MockPackageServer.DUMMY_PACKAGE_VERSION, packageRequest.getRequestUrl().toString());
    assertBasicAuthorization(packageRequest);

    RecordedRequest tarballRequest = server.getMockWebServer().takeRequest();

    assertEquals(server.getTarballUrl(), tarballRequest.getRequestUrl().toString());
    assertBasicAuthorization(tarballRequest);

    assertEquals(packageServerUrl + "/" + MockPackageServer.DUMMY_PACKAGE_NAME + "/" + MockPackageServer.DUMMY_PACKAGE_VERSION, packageRequest.getRequestUrl().toString());

    NpmPackage npmPackage = NpmPackage.fromPackage(inputStream);
    assertDummyPackageContent(npmPackage);
  }

  @Test
  public void testPackageNpmServer() throws IOException, InterruptedException {

    String packageServerUrl = server.getPackageServerUrl();

    server.enqueueDummyPackageDescription();
    server.enqueueDummyPackage();

    PackageServer testServer = new PackageServer(packageServerUrl)
      .withServerType(PackageServer.PackageServerType.NPM);
    PackageClient packageClient = new PackageClient(testServer);

    InputStream inputStream = packageClient.fetch(MockPackageServer.DUMMY_PACKAGE_NAME, MockPackageServer.DUMMY_PACKAGE_VERSION);

    RecordedRequest packageRequest = server.getMockWebServer().takeRequest();

    assertEquals(packageServerUrl + "/" + MockPackageServer.DUMMY_PACKAGE_NAME + "/" + MockPackageServer.DUMMY_PACKAGE_VERSION, packageRequest.getRequestUrl().toString());
    assertNull(packageRequest.getHeader("Authorization"));

    RecordedRequest tarballRequest = server.getMockWebServer().takeRequest();

    assertEquals(server.getTarballUrl(), tarballRequest.getRequestUrl().toString());
    assertNull(tarballRequest.getHeader("Authorization"));

    assertEquals(packageServerUrl + "/" + MockPackageServer.DUMMY_PACKAGE_NAME + "/" + MockPackageServer.DUMMY_PACKAGE_VERSION, packageRequest.getRequestUrl().toString());

    NpmPackage npmPackage = NpmPackage.fromPackage(inputStream);
    assertDummyPackageContent(npmPackage);
  }

  @Test
  public void testPackageFhirServer() throws IOException, InterruptedException {

    String packageServerUrl = server.getPackageServerUrl();
    server.enqueueDummyPackage();

    PackageServer testServer = new PackageServer(packageServerUrl);

    PackageClient packageClient = new PackageClient(testServer);
    InputStream inputStream = packageClient.fetch(MockPackageServer.DUMMY_PACKAGE_NAME, MockPackageServer.DUMMY_PACKAGE_VERSION);

    RecordedRequest tarballRequest = server.getMockWebServer().takeRequest();

    assertEquals(server.getPackageServerUrl() + "/" + MockPackageServer.DUMMY_PACKAGE_NAME + "/" + MockPackageServer.DUMMY_PACKAGE_VERSION, tarballRequest.getRequestUrl().toString());
    assertNull(tarballRequest.getHeader("Authorization"));

    NpmPackage npmPackage = NpmPackage.fromPackage(inputStream);
    assertDummyPackageContent(npmPackage);
  }
  private static void assertBasicAuthorization(RecordedRequest packageRequest) {
    String authorizationHeader = packageRequest.getHeader("Authorization");

    byte[] data = Base64.getDecoder().decode(authorizationHeader.substring(6));
    String authorizationValue = new String(data, StandardCharsets.UTF_8);
    String[] authorizationColumns = authorizationValue.split(":");

    assertEquals(MockPackageServer.DUMMY_USERNAME, authorizationColumns[0]);
    assertEquals(MockPackageServer.DUMMY_PASSWORD, authorizationColumns[1]);
  }

  private void assertDummyPackageContent(NpmPackage npmPackage) throws IOException {
    assertEquals("Dummy IG For Testing", npmPackage.title())
    ;
    assertEquals("Dummy IG description (built Thu, Jul 6, 2023 15:16-0400-04:00)", npmPackage.description());

  }


  public Buffer getDummyPackageAsBuffer() throws IOException {

    byte[] fileData = this.getClass().getResourceAsStream("/npm/dummy-package.tgz").readAllBytes();
    Buffer buf = new Buffer();
    buf.write(fileData);

    return buf;
  }
}
