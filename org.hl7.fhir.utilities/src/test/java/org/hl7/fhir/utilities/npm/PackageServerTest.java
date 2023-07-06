package org.hl7.fhir.utilities.npm;

import okio.Buffer;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PackageServerTest {

  @Test
  public void testPrivatePackage() throws IOException {

    MockWebServer server = new MockWebServer();





    // Start the server.
    server.start();


    HttpUrl httpUrl = server.url("/");

    String packageServerUrl = getPackageServerUrl(httpUrl);

    server.enqueue(new MockResponse().setBody("{" +
      "\"dist\": { \"tarball\": \""+ packageServerUrl +"\"}"+
      "}"));
    // Schedule some responses.
    server.enqueue(new MockResponse().setBody(getBinaryFileAsBuffer("/Users/david.otasek/IN/2023-05-26-private-npm-registry/sample-ig/output/package.tgz")));


    PackageServer testServer = new PackageServer(packageServerUrl)
      .withMode(PackageServer.PackageServerAuthenticationMode.BASIC)
      .withServerType(PackageServer.PackageServerType.NPM)
      .withUsername("alfred")
      .withPassword("numan");
    PackageClient packageClient = new PackageClient(testServer);

   // List<PackageInfo> packageVersions = packageClient.getVersions("example.fhir.uv.myig");

    //System.out.println(packageVersions.get(0));

    InputStream inputStream = packageClient.fetch("example.fhir.uv.myig","0.2.0" );

    NpmPackage npmPackage = NpmPackage.fromPackage(inputStream);

    System.out.println(npmPackage.description());

  }

  @Nonnull
  private static String getPackageServerUrl(HttpUrl httpUrl) {
    return "http://" + httpUrl.host() + ":" + httpUrl.port();
  }

  public static Buffer getBinaryFileAsBuffer(String path) throws IOException {
    File file = new File(path);
    byte[] fileData = FileUtils.readFileToByteArray(file);
    Buffer buf = new Buffer();
    buf.write(fileData);

    return buf;
  }
}
