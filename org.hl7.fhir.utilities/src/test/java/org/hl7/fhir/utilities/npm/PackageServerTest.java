package org.hl7.fhir.utilities.npm;

import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackageServerTest {

  public static final String DUMMY_PACKAGE_NAME = "example.fhir.uv.myig";
  public static final String DUMMY_PACKAGE_VERSION = "0.2.0";
  public static final String DUMMY_USERNAME = "alfred";
  public static final String DUMMY_PASSWORD = "numan";

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
  public void testPrivatePackage() throws IOException, InterruptedException {

    String packageServerUrl = server.getPackageServerUrl();

    server.enqueueDummyPackageDescription();
    server.enqueueDummyPackage();

    PackageServer testServer = new PackageServer(packageServerUrl)
      .withMode(PackageServer.PackageServerAuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM)
      .withUsername(DUMMY_USERNAME)
      .withPassword(DUMMY_PASSWORD);
    PackageClient packageClient = new PackageClient(testServer);

    InputStream inputStream = packageClient.fetch(DUMMY_PACKAGE_NAME, DUMMY_PACKAGE_VERSION);

    RecordedRequest packageRequest = server.getMockWebServer().takeRequest();

    assertEquals(packageServerUrl + "/" + DUMMY_PACKAGE_NAME + "/" + DUMMY_PACKAGE_VERSION, packageRequest.getRequestUrl().toString());
    assertBasicAuthorization(packageRequest);

    RecordedRequest tarballRequest = server.getMockWebServer().takeRequest();

    assertEquals(server.getTarballUrl(), tarballRequest.getRequestUrl().toString());
    assertBasicAuthorization(tarballRequest);

    assertEquals(packageServerUrl + "/" + DUMMY_PACKAGE_NAME + "/" + DUMMY_PACKAGE_VERSION, packageRequest.getRequestUrl().toString());

    NpmPackage npmPackage = NpmPackage.fromPackage(inputStream);

    assertDummyPackageContent(npmPackage);
  }

  private static void assertBasicAuthorization(RecordedRequest packageRequest) {
    String authorizationHeader = packageRequest.getHeader("Authorization");

    byte[] data = Base64.getDecoder().decode(authorizationHeader.substring(6));
    String authorizationValue = new String(data, StandardCharsets.UTF_8);
    String[] authorizationColumns = authorizationValue.split(":");

    assertEquals(DUMMY_USERNAME, authorizationColumns[0]);
    assertEquals(DUMMY_PASSWORD, authorizationColumns[1]);
  }

  private void assertDummyPackageContent(NpmPackage npmPackage) throws IOException {
    assertEquals("Dummy IG For Testing", npmPackage.title())
    ;
    assertEquals("Dummy IG description (built Thu, Jul 6, 2023 15:16-0400-04:00)", npmPackage.description());
    server.shutdown();
  }


  public Buffer getDummyPackageAsBuffer() throws IOException {

    byte[] fileData = this.getClass().getResourceAsStream("/npm/dummy-package.tgz").readAllBytes();
    Buffer buf = new Buffer();
    buf.write(fileData);

    return buf;
  }
}
