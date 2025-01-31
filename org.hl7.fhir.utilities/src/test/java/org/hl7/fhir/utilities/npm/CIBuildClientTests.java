package org.hl7.fhir.utilities.npm;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import org.junit.jupiter.api.Test;

import okhttp3.mockwebserver.MockWebServer;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

public class CIBuildClientTests {

  static final String DUMMY_PACKAGE = "my.dummy.package";

  public static final String DUMMY_PACKAGE_URL = "http://example.org/my-dummy-package";
  public static final String DUMMY_PACKAGE_NAME = "DummyPackage";
  static final String dummyQas = "[\n" +
    "  {\n" +
    "    \"url\": \"" + DUMMY_PACKAGE_URL + "\",\n" +
    "    \"name\": \"" + DUMMY_PACKAGE_NAME + "\",\n" +
    "    \"title\": \"Dummy Package\",\n" +
    "    \"description\": \"Not a real package.\",\n" +
    "    \"status\": \"draft\",\n" +
    "    \"package-id\": \""+ DUMMY_PACKAGE +"\",\n" +
    "    \"ig-ver\": \"1.1.0\",\n" +
    "    \"date\": \"Sat, 30 Nov, 2024 00:31:05 +0000\",\n" +
    "    \"dateISO8601\": \"2024-11-30T00:31:05+00:00\",\n" +
    "    \"version\": \"4.0.1\",\n" +
    "    \"repo\": \"Dummy-Organisation/dummy-project/branches/main/qa.json\"\n" +
    "  }]";

  public static final String DUMMY_PACKAGE_DATE = "20241227181832";
  static final String dummyManifest = "{\n" +
    "  \"version\" : \"1.1.0\",\n" +
    "  \"fhirVersion\" : [\"4.0.1\"],\n" +
    "  \"date\" : \"" + DUMMY_PACKAGE_DATE + "\",\n" +
    "  \"name\" : \""+ DUMMY_PACKAGE_NAME +"\",\n" +
    "  \"jurisdiction\" : \"urn:iso:std:iso:3166#CA\"\n" +
    "}";

  @Test
  public void testOnlyOneQasQueryUnderRefreshThreshold() throws IOException, InterruptedException {
    MockWebServer server = new MockWebServer();
    CIBuildClient ciBuildClient = getCiBuildClient(server);

    enqueueJson(server, dummyQas);
    enqueueDummyTgzStream(server, "fake tgz");
    verifyInputStreamContent(ciBuildClient.loadFromCIBuild(DUMMY_PACKAGE, "main"), "fake tgz");

    assertThat(server.getRequestCount()).isEqualTo(2);
    assertThat(server.takeRequest().getPath()).startsWith("/ig/qas.json?nocache=");
    assertThat(server.takeRequest().getPath()).startsWith("/ig/Dummy-Organisation/dummy-project/branches/main/package.tgz");

    enqueueDummyTgzStream(server, "fake tgz 2");

    verifyInputStreamContent(ciBuildClient.loadFromCIBuild(DUMMY_PACKAGE, "main"), "fake tgz 2");
  }

  @Test
  public void testNewQasQueryOverRefreshThreshold() throws IOException, InterruptedException {
    MockWebServer server = new MockWebServer();
    CIBuildClient ciBuildClient = getCiBuildClient(server);

    enqueueJson(server, dummyQas);
    enqueueDummyTgzStream(server, "fake tgz");
    verifyInputStreamContent(ciBuildClient.loadFromCIBuild(DUMMY_PACKAGE, "main"), "fake tgz");

    assertThat(server.getRequestCount()).isEqualTo(2);
    assertThat(server.takeRequest().getPath()).startsWith("/ig/qas.json?nocache=");
    assertThat(server.takeRequest().getPath()).startsWith("/ig/Dummy-Organisation/dummy-project/branches/main/package.tgz");

    enqueueJson(server, dummyQas);
    enqueueDummyTgzStream(server, "fake tgz 2");

    Thread.sleep(1500);
    verifyInputStreamContent(ciBuildClient.loadFromCIBuild(DUMMY_PACKAGE, "main"), "fake tgz 2");
  }

  @Test
  public void testGetPackageId() {
    MockWebServer server = new MockWebServer();
    CIBuildClient ciBuildClient = getCiBuildClient(server);

    enqueueJson(server, dummyQas);

    String packageId = ciBuildClient.getPackageId(DUMMY_PACKAGE_URL);
    assertThat(packageId).isEqualTo(DUMMY_PACKAGE);
  }

  @Test
  public void testGetPackageUrl() {
    MockWebServer server = new MockWebServer();
    CIBuildClient ciBuildClient = getCiBuildClient(server);

    enqueueJson(server, dummyQas);

    String packageUrl = ciBuildClient.getPackageUrl(DUMMY_PACKAGE);
    assertThat(packageUrl).isEqualTo(DUMMY_PACKAGE_URL);
  }

  @Test
  public void testIsCurrentPackage() throws IOException {
    MockWebServer server = new MockWebServer();
    CIBuildClient ciBuildClient = getCiBuildClient(server);

    enqueueJson(server, dummyQas);

    enqueueJson(server, dummyManifest);

    NpmPackage npmPackage = Mockito.spy(NpmPackage.empty());
    doReturn(DUMMY_PACKAGE_DATE).when(npmPackage).date();
    doReturn(DUMMY_PACKAGE_URL).when(npmPackage).url();
    assertTrue(ciBuildClient.isCurrent(DUMMY_PACKAGE, npmPackage));
    enqueueJson(server, dummyManifest);

    String wrongDate = "1092302309";
    assertThat(wrongDate).isNotEqualTo(DUMMY_PACKAGE_DATE);
    doReturn(wrongDate).when(npmPackage).date();
    assertFalse(ciBuildClient.isCurrent(DUMMY_PACKAGE, npmPackage));
  }

  private static void enqueueDummyTgzStream(MockWebServer server, String fake_tgz) {
    server.enqueue(
      new MockResponse()
        .setBody(fake_tgz)
        .addHeader("Content-Type", "application/text")
        .setResponseCode(200));
  }


  private static CIBuildClient getCiBuildClient(MockWebServer server) {
    HttpUrl serverRoot = server.url("");
    return new CIBuildClient(serverRoot.toString().substring(0, serverRoot.toString().length() - 1), 1000, false);
  }


  private static void enqueueJson(MockWebServer server, String qasJson) {
    byte[] payload = qasJson.getBytes(StandardCharsets.UTF_8);
    server.enqueue(
      new MockResponse()
        .setBody(new String(payload))
        .addHeader("Content-Type", "application/json")
        .setResponseCode(200)
    );
  }

  private static void verifyInputStreamContent(BasePackageCacheManager.InputStreamWithSrc inputStream, String expected) throws IOException {
    String content = new String(inputStream.stream.readAllBytes());
    assertThat(content).isEqualTo(expected);
  }
}
