package org.hl7.fhir.utilities.npm;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.Buffer;

import java.io.IOException;

public class MockPackageServer {
  public static final String DUMMY_PACKAGE_NAME = "example.fhir.uv.myig";
  public static final String DUMMY_PACKAGE_VERSION = "0.2.0";
  public static final String DUMMY_USERNAME = "alfred";
  public static final String DUMMY_PASSWORD = "numan";

  public static final String DUMMY_TOKEN = "dummyTokenValue";
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

  public void enqueueResponseCode(int code) throws IOException {
    server.enqueue(new MockResponse().setResponseCode(code));
  }

  private Buffer getDummyPackageAsBuffer() throws IOException {

    byte[] fileData = this.getClass().getResourceAsStream("/npm/dummy-package.tgz").readAllBytes();
    Buffer buf = new Buffer();
    buf.write(fileData);

    return buf;
  }
}
