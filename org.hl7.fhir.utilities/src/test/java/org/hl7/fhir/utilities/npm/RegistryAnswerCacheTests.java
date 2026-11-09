package org.hl7.fhir.utilities.npm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Nonnull;

import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.settings.FhirSettingsPOJO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * The registry answers a long-running process keeps: answers are reused until they are older than the ttl, and a
 * request that failed is asked again. The servers are local fakes.
 */
class RegistryAnswerCacheTests {

  private static final long TTL = 60 * 60 * 1000L;
  private static final String PACKAGE_ID = "example.fhir.uv.dep";
  private static final String PACKAGE_CANONICAL = "http://example.org/fhir/dep";
  private static final String IG_URL = "http://example.org/fhir/ci/ImplementationGuide/example.fhir.uv.ci";
  private static final String CI_PACKAGE_ID = "example.fhir.uv.ci";

  private static final String CATALOG = "[{\"name\": \"" + PACKAGE_ID + "\", \"version\": \"2.0.0\", \"canonical\": \"" + PACKAGE_CANONICAL + "\"}]";
  private static final String VERSIONS = "{\"name\": \"" + PACKAGE_ID + "\", \"versions\": {"
    + "\"1.0.0\": {\"name\": \"" + PACKAGE_ID + "\", \"version\": \"1.0.0\"},"
    + "\"2.0.0\": {\"name\": \"" + PACKAGE_ID + "\", \"version\": \"2.0.0\"}}}";
  private static final String OTHER_PACKAGE_ID = "example.fhir.uv.other";
  private static final String OTHER_VERSIONS = "{\"name\": \"" + OTHER_PACKAGE_ID + "\", \"versions\": {"
    + "\"0.1.0\": {\"name\": \"" + OTHER_PACKAGE_ID + "\", \"version\": \"0.1.0\"}}}";
  private static final String QAS = "[{\"url\": \"" + IG_URL + "\", \"package-id\": \"" + CI_PACKAGE_ID + "\","
    + " \"date\": \"Sat, 30 Nov, 2024 00:31:05 +0000\", \"repo\": \"Example/ci/branches/main/qa.json\"}]";

  /** A fake package server and build.fhir.org: answers by path, or with 503 while it is down */
  private static class FakeRegistry extends Dispatcher {
    final List<String> paths = Collections.synchronizedList(new ArrayList<>());
    volatile boolean down;
    volatile String catalog = CATALOG;
    volatile String versions = VERSIONS;
    volatile String qas = QAS;

    @Nonnull
    @Override
    public MockResponse dispatch(@Nonnull RecordedRequest request) {
      String path = request.getPath();
      paths.add(path);
      if (down) {
        return new MockResponse().setResponseCode(503);
      }
      if (path.startsWith("/catalog?")) {
        return json(catalog);
      } else if (path.equals("/" + PACKAGE_ID)) {
        return json(versions);
      } else if (path.equals("/" + OTHER_PACKAGE_ID)) {
        return json(OTHER_VERSIONS);
      } else if (path.startsWith("/ig/qas.json")) {
        return json(qas);
      }
      return new MockResponse().setResponseCode(404);
    }

    private static MockResponse json(String body) {
      return new MockResponse().setBody(body).addHeader("Content-Type", "application/json");
    }

    long count(String prefix) {
      synchronized (paths) {
        return paths.stream().filter(p -> p.startsWith(prefix)).count();
      }
    }
  }

  private MockWebServer server;
  private FakeRegistry registry;

  @BeforeAll
  static void beforeAll() {
    ManagedWebAccess.loadFromFHIRSettings(FhirSettingsPOJO.builder().ssrfProtectionEnabled(false).build());
  }

  @AfterAll
  static void afterAll() {
    ManagedWebAccess.loadFromFHIRSettings();
  }

  @BeforeEach
  void startServer() throws IOException {
    registry = new FakeRegistry();
    server = new MockWebServer();
    server.setDispatcher(registry);
    server.start();
  }

  @AfterEach
  void stopServer() throws IOException {
    server.shutdown();
  }

  private String root() {
    String url = server.url("/").toString();
    return url.substring(0, url.length() - 1);
  }

  private PackageServer packageServer() {
    return new PackageServer(root()).withAllowHttp(true).withAllowPrivateNetwork(true);
  }

  private FilesystemPackageCacheManager packageCacheManager(RegistryAnswerCache answers) throws IOException {
    return new FilesystemPackageCacheManager.Builder()
      .withTestingCacheFolder()
      .withPackageServers(List.of(packageServer()))
      .withCiBuildClient(new CIBuildClient(root(), TTL, false))
      .withRegistryAnswerCache(answers)
      .build();
  }

  @Test
  void answerIsKeptUntilTheTtlEnds() throws IOException {
    AtomicLong now = new AtomicLong(1000);
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, now::get);
    AtomicInteger asked = new AtomicInteger();

    assertEquals("a1", answers.get("q", () -> "a" + asked.incrementAndGet()));
    now.addAndGet(TTL - 1);
    assertEquals("a1", answers.get("q", () -> "a" + asked.incrementAndGet()));
    assertEquals(1, asked.get());

    now.addAndGet(1);
    assertEquals("a2", answers.get("q", () -> "a" + asked.incrementAndGet()));
    assertEquals("a2", answers.get("q", () -> "a" + asked.incrementAndGet()));
    assertEquals(2, asked.get());
  }

  @Test
  void questionsAreKeptApart() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    assertEquals("a", answers.get("q1", () -> "a"));
    assertEquals("b", answers.get("q2", () -> "b"));
    assertEquals("a", answers.get("q1", () -> "c"));
  }

  @Test
  void answerThatCantBeUsedIsNotKept() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    assertEquals("", answers.get("q", () -> "", a -> !a.isEmpty()));
    assertEquals("a", answers.get("q", () -> "a", a -> !a.isEmpty()));
    assertEquals("a", answers.get("q", () -> "b", a -> !a.isEmpty()));
  }

  @Test
  void failureIsNotKept() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    IOException failure = assertThrows(IOException.class, () -> answers.get("q", () -> {
      throw new IOException("timeout");
    }));
    assertEquals("timeout", failure.getMessage());
    assertThrows(IllegalStateException.class, () -> answers.get("q", () -> {
      throw new IllegalStateException("unparseable");
    }));

    assertEquals("a", answers.get("q", () -> "a"));
    assertEquals("a", answers.get("q", () -> "b"));
  }

  @Test
  void clientsSharingAnswersSearchAndListVersionsOnce() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    for (int i = 0; i < 2; i++) {
      PackageClient client = new PackageClient(packageServer(), answers);
      List<PackageInfo> found = client.search(null, PACKAGE_CANONICAL, null, false, null, true);
      assertThat(found).extracting(PackageInfo::getId).containsExactly(PACKAGE_ID);
      assertThat(client.getVersions(PACKAGE_ID)).extracting(PackageInfo::getVersion).containsExactlyInAnyOrder("1.0.0", "2.0.0");
    }
    assertEquals(1, registry.count("/catalog?"));
    assertEquals(1, registry.count("/" + PACKAGE_ID));
  }

  @Test
  void clientWithoutAnswersAsksEveryTime() throws IOException {
    for (int i = 0; i < 2; i++) {
      PackageClient client = new PackageClient(packageServer());
      assertThat(client.search(null, PACKAGE_CANONICAL, null, false, null, true)).hasSize(1);
      assertThat(client.getVersions(PACKAGE_ID)).hasSize(2);
    }
    assertEquals(2, registry.count("/catalog?"));
    assertEquals(2, registry.count("/" + PACKAGE_ID));
  }

  @Test
  void searchThatFindsNothingIsAnAnswer() throws IOException {
    registry.catalog = "[]";
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    for (int i = 0; i < 2; i++) {
      assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).isEmpty();
    }
    assertEquals(1, registry.count("/catalog?"));
  }

  @Test
  void failedSearchIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    registry.down = true;
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).isEmpty();
    long whileDown = registry.count("/catalog?");
    registry.down = false;
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).hasSize(1);
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).hasSize(1);
    assertEquals(whileDown + 1, registry.count("/catalog?"));
  }

  @Test
  void failedVersionListIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    registry.down = true;
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).isEmpty();
    long whileDown = registry.count("/" + PACKAGE_ID);
    registry.down = false;
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).hasSize(2);
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).hasSize(2);
    assertEquals(whileDown + 1, registry.count("/" + PACKAGE_ID));
  }

  @Test
  void versionListsAreKeptPerPackage() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    for (int i = 0; i < 2; i++) {
      PackageClient client = new PackageClient(packageServer(), answers);
      assertThat(client.getVersions(PACKAGE_ID)).extracting(PackageInfo::getVersion).containsExactlyInAnyOrder("1.0.0", "2.0.0");
      assertThat(client.getVersions(OTHER_PACKAGE_ID)).extracting(PackageInfo::getVersion).containsExactly("0.1.0");
    }
    assertEquals(1, registry.count("/" + PACKAGE_ID));
    assertEquals(1, registry.count("/" + OTHER_PACKAGE_ID));
  }

  @Test
  void unknownPackageIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    for (int i = 0; i < 2; i++) {
      assertThat(new PackageClient(packageServer(), answers).getVersions("example.fhir.uv.unknown")).isEmpty();
    }
    assertThat(registry.count("/example.fhir.uv.unknown")).isGreaterThanOrEqualTo(2);
  }

  @Test
  void versionListWithoutVersionsIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    registry.versions = "{\"error\": \"try later\"}";
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).isEmpty();
    registry.versions = VERSIONS;
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).hasSize(2);
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).hasSize(2);
    assertEquals(2, registry.count("/" + PACKAGE_ID));
  }

  @Test
  void unparseableAnswerIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    registry.catalog = "[{";
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).isEmpty();
    registry.catalog = CATALOG;
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).hasSize(1);
    assertEquals(2, registry.count("/catalog?"));
  }

  @Test
  void ciBuildClientsSharingAnswersLoadTheListOnce() {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    CIBuildClient template = new CIBuildClient(root(), TTL, false);
    for (int i = 0; i < 2; i++) {
      CIBuildClient client = template.withAnswers(answers);
      assertEquals(CI_PACKAGE_ID, client.getPackageId(IG_URL));
      assertEquals(IG_URL, client.getPackageUrl(CI_PACKAGE_ID));
    }
    assertEquals(1, registry.count("/ig/qas.json"));
  }

  @Test
  void failedCiListIsAskedAgainByTheNextClient() {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    CIBuildClient template = new CIBuildClient(root(), TTL, false);
    registry.down = true;
    assertNull(template.withAnswers(answers).getPackageId(IG_URL));
    long whileDown = registry.count("/ig/qas.json");
    registry.down = false;
    assertEquals(CI_PACKAGE_ID, template.withAnswers(answers).getPackageId(IG_URL));
    assertEquals(CI_PACKAGE_ID, template.withAnswers(answers).getPackageId(IG_URL));
    assertEquals(whileDown + 1, registry.count("/ig/qas.json"));
  }

  @Test
  void ciListThatCantBeReadIsAskedAgain() {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    CIBuildClient template = new CIBuildClient(root(), TTL, false);
    registry.qas = QAS.replace("Example/ci/branches/main/qa.json", "noslash");
    // as without answers, the list is used although it can't be read
    assertEquals(CI_PACKAGE_ID, template.withAnswers(answers).getPackageId(IG_URL));
    long whileBroken = registry.count("/ig/qas.json");
    registry.qas = QAS;
    assertEquals(IG_URL, template.withAnswers(answers).getPackageUrl(CI_PACKAGE_ID));
    assertEquals(IG_URL, template.withAnswers(answers).getPackageUrl(CI_PACKAGE_ID));
    assertEquals(whileBroken + 1, registry.count("/ig/qas.json"));
  }

  @Test
  void packageCacheManagersSharingAnswersAskOnce() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL);
    for (int i = 0; i < 2; i++) {
      FilesystemPackageCacheManager pcm = packageCacheManager(answers);
      assertEquals(PACKAGE_ID, pcm.getPackageId(PACKAGE_CANONICAL));
      assertEquals(CI_PACKAGE_ID, pcm.getPackageId(IG_URL));
      assertEquals("2.0.0", pcm.getLatestVersion(PACKAGE_ID, true));
    }
    // the catalog is searched for each canonical; the IG url isn't there, so it's found in the CI build list
    assertEquals(2, registry.count("/catalog?"));
    assertEquals(1, registry.count("/ig/qas.json"));
    assertEquals(1, registry.count("/" + PACKAGE_ID));
  }

  @Test
  void packageCacheManagersWithoutAnswersAskEveryTime() throws IOException {
    for (int i = 0; i < 2; i++) {
      FilesystemPackageCacheManager pcm = packageCacheManager(null);
      assertEquals(PACKAGE_ID, pcm.getPackageId(PACKAGE_CANONICAL));
      assertEquals(CI_PACKAGE_ID, pcm.getPackageId(IG_URL));
      assertEquals("2.0.0", pcm.getLatestVersion(PACKAGE_ID, true));
    }
    assertEquals(4, registry.count("/catalog?"));
    assertEquals(2, registry.count("/ig/qas.json"));
    assertEquals(2, registry.count("/" + PACKAGE_ID));
  }
}
