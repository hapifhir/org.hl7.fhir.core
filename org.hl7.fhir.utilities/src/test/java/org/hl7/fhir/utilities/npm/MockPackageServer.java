package org.hl7.fhir.utilities.npm;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.Buffer;

import java.io.IOException;

public class MockPackageServer {
  MockWebServer server = new MockWebServer();
  HttpUrl httpUrl;

  public MockPackageServer() throws IOException {
    server = new MockWebServer();
    server.start();
    httpUrl = server.url("/");
  }

  public MockWebServer getMockWebServer() {
    return server;
  }

  public String getPackageServerUrl() {
    return "http://" + httpUrl.host() + ":" + httpUrl.port();
  }

  public void shutdown() throws IOException {
    server.shutdown();
  }

  public void enqueueDummyPackageDescription() {
    server.enqueue(new MockResponse().setBody("{" +
      "\"dist\": { \"tarball\": \"" + getTarballUrl() + "\"}"+
      "}"));
  }

  public String getTarballUrl() {
    return getPackageServerUrl() + "/tarballUrl";
  }
  public void enqueueDummyPackage() throws IOException {
    server.enqueue(new MockResponse().setBody(getDummyPackageAsBuffer()));
  }

  private Buffer getDummyPackageAsBuffer() throws IOException {

    byte[] fileData = this.getClass().getResourceAsStream("/npm/dummy-package.tgz").readAllBytes();
    Buffer buf = new Buffer();
    buf.write(fileData);

    return buf;
  }
}
