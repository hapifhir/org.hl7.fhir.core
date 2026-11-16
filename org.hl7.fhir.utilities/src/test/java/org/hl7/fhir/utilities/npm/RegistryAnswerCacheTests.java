package org.hl7.fhir.utilities.npm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Nonnull;

import org.hl7.fhir.utilities.http.HTTPResultException;
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
 * The registry answers a long-running process keeps: answers are reused until they are older than the ttl, a 404
 * until it is older than the shorter not-found ttl, and a request that failed otherwise is asked again. The
 * servers are local fakes.
 */
class RegistryAnswerCacheTests {

  private static final long TTL = 60 * 60 * 1000L;
  private static final long NOT_FOUND_TTL = 5 * 60 * 1000L;
  private static final String UNKNOWN_PACKAGE_ID = "example.fhir.uv.unknown";
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
        return json(QAS);
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
    // the cache first: the other withers must pass it on
    return new FilesystemPackageCacheManager.Builder()
      .withRegistryAnswerCache(answers)
      .withTestingCacheFolder()
      .withPackageServers(List.of(packageServer()))
      .withCiBuildClient(new CIBuildClient(root(), TTL, false))
      .build();
  }

  @Test
  void answerIsKeptUntilTheTtlEnds() throws IOException {
    AtomicLong now = new AtomicLong(1000);
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL, now::get);
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
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    assertEquals("a", answers.get("q1", () -> "a"));
    assertEquals("b", answers.get("q2", () -> "b"));
    assertEquals("a", answers.get("q1", () -> "c"));
  }

  @Test
  void answerThatCantBeUsedIsNotKept() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    assertEquals("", answers.get("q", () -> "", a -> !a.isEmpty()));
    assertEquals("a", answers.get("q", () -> "a", a -> !a.isEmpty()));
    assertEquals("a", answers.get("q", () -> "b", a -> !a.isEmpty()));
  }

  @Test
  void failureIsNotKept() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
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
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
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
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    for (int i = 0; i < 2; i++) {
      assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).isEmpty();
    }
    assertEquals(1, registry.count("/catalog?"));
  }

  @Test
  void failedSearchIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
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
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
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
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    for (int i = 0; i < 2; i++) {
      PackageClient client = new PackageClient(packageServer(), answers);
      assertThat(client.getVersions(PACKAGE_ID)).extracting(PackageInfo::getVersion).containsExactlyInAnyOrder("1.0.0", "2.0.0");
      assertThat(client.getVersions(OTHER_PACKAGE_ID)).extracting(PackageInfo::getVersion).containsExactly("0.1.0");
    }
    assertEquals(1, registry.count("/" + PACKAGE_ID));
    assertEquals(1, registry.count("/" + OTHER_PACKAGE_ID));
  }

  @Test
  void unknownPackageIsKeptForTheNotFoundTtl() throws IOException {
    AtomicLong now = new AtomicLong(1000);
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL, now::get);
    // the http client asks again after a 404, so one question can be more than one request
    assertThat(new PackageClient(packageServer(), answers).getVersions(UNKNOWN_PACKAGE_ID)).isEmpty();
    long once = registry.count("/" + UNKNOWN_PACKAGE_ID);
    now.addAndGet(NOT_FOUND_TTL - 1);
    assertThat(new PackageClient(packageServer(), answers).getVersions(UNKNOWN_PACKAGE_ID)).isEmpty();
    assertEquals(once, registry.count("/" + UNKNOWN_PACKAGE_ID));

    now.addAndGet(1);
    assertThat(new PackageClient(packageServer(), answers).getVersions(UNKNOWN_PACKAGE_ID)).isEmpty();
    assertEquals(2 * once, registry.count("/" + UNKNOWN_PACKAGE_ID));
  }

  @Test
  void notFoundIsThrownAgainUntilItsTtlEnds() throws IOException {
    AtomicLong now = new AtomicLong(1000);
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL, now::get);
    AtomicInteger asked = new AtomicInteger();
    RegistryAnswerCache.Fetcher<String> notFound = () -> {
      asked.incrementAndGet();
      throw new IOException("not found", new HTTPResultException(404, "Not Found", "http://example.org/x", null));
    };

    IOException first = assertThrows(IOException.class, () -> answers.get("q", notFound));
    now.addAndGet(NOT_FOUND_TTL - 1);
    IOException kept = assertThrows(IOException.class, () -> answers.get("q", notFound));
    assertEquals(first.getMessage(), kept.getMessage());
    assertThat(kept.getCause()).isInstanceOf(HTTPResultException.class);
    assertEquals(1, asked.get());

    now.addAndGet(1);
    assertEquals("a", answers.get("q", () -> "a"));
    assertEquals("a", answers.get("q", notFound));
    assertEquals(1, asked.get());
  }

  @Test
  void otherHttpErrorsAreNotKept() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    assertThrows(IOException.class, () -> answers.get("q", () -> {
      throw new IOException("unavailable", new HTTPResultException(503, "Service Unavailable", "http://example.org/x", null));
    }));
    assertEquals("a", answers.get("q", () -> "a"));
  }

  @Test
  void unknownPackageDownloadIsKeptForTheNotFoundTtl() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    assertThrows(Exception.class, () -> packageCacheManager(answers).loadPackage(UNKNOWN_PACKAGE_ID, "1.0.0"));
    long once = registry.count("/" + UNKNOWN_PACKAGE_ID + "/1.0.0");
    assertThat(once).isPositive();
    assertThrows(Exception.class, () -> packageCacheManager(answers).loadPackage(UNKNOWN_PACKAGE_ID, "1.0.0"));
    assertEquals(once, registry.count("/" + UNKNOWN_PACKAGE_ID + "/1.0.0"));
  }

  @Test
  void unknownPackageDownloadWithoutAnswersIsAskedEveryTime() throws IOException {
    assertThrows(Exception.class, () -> packageCacheManager(null).loadPackage(UNKNOWN_PACKAGE_ID, "1.0.0"));
    long once = registry.count("/" + UNKNOWN_PACKAGE_ID + "/1.0.0");
    assertThat(once).isPositive();
    assertThrows(Exception.class, () -> packageCacheManager(null).loadPackage(UNKNOWN_PACKAGE_ID, "1.0.0"));
    assertEquals(2 * once, registry.count("/" + UNKNOWN_PACKAGE_ID + "/1.0.0"));
  }

  @Test
  void versionListWithoutVersionsIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    registry.versions = "{\"error\": \"try later\"}";
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).isEmpty();
    registry.versions = VERSIONS;
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).hasSize(2);
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).hasSize(2);
    assertEquals(2, registry.count("/" + PACKAGE_ID));
  }

  @Test
  void keptAnswerIsWhatTheRegistrySaidNotWhatACallerFiltered() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    registry.versions = VERSIONS.replace("}}}", "}, \"2.1.0-ballot\": {\"name\": \"" + PACKAGE_ID + "\", \"version\": \"2.1.0-ballot\"}}}");
    assertEquals("2.0.0", new PackageClient(packageServer(), answers).getLatestVersion(PACKAGE_ID, true));
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).extracting(PackageInfo::getVersion).contains("2.1.0-ballot");
    assertEquals(1, registry.count("/" + PACKAGE_ID));

    registry.catalog = CATALOG.replace("}]", "}, {\"name\": \"" + OTHER_PACKAGE_ID + "\", \"version\": \"0.1.0\", \"canonical\": \"" + PACKAGE_CANONICAL + "/other\"}]");
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).hasSize(1);
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, false)).hasSize(2);
    assertEquals(1, registry.count("/catalog?"));
  }

  @Test
  void versionListThatCantBeReadIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    registry.versions = "{\"versions\": {\"1.0.0\": \"x\"}}";
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).isEmpty();
    registry.versions = VERSIONS;
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).hasSize(2);
    assertThat(new PackageClient(packageServer(), answers).getVersions(PACKAGE_ID)).hasSize(2);
    assertEquals(2, registry.count("/" + PACKAGE_ID));
  }

  @Test
  void catalogThatCantBeReadIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    registry.catalog = CATALOG.replace("\"version\"", "\"date\": \"20241130003105\", \"version\"");
    // as without answers, the error is thrown to the caller
    assertThrows(RuntimeException.class, () -> new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true));
    registry.catalog = CATALOG;
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).hasSize(1);
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).hasSize(1);
    assertEquals(2, registry.count("/catalog?"));
  }

  @Test
  void unparseableAnswerIsAskedAgain() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    registry.catalog = "[{";
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).isEmpty();
    registry.catalog = CATALOG;
    assertThat(new PackageClient(packageServer(), answers).search(null, PACKAGE_CANONICAL, null, false, null, true)).hasSize(1);
    assertEquals(2, registry.count("/catalog?"));
  }

  @Test
  void packageCacheManagersSharingAnswersAskOnce() throws IOException {
    RegistryAnswerCache answers = new RegistryAnswerCache(TTL, NOT_FOUND_TTL);
    for (int i = 0; i < 2; i++) {
      FilesystemPackageCacheManager pcm = packageCacheManager(answers);
      assertEquals(PACKAGE_ID, pcm.getPackageId(PACKAGE_CANONICAL));
      assertEquals(CI_PACKAGE_ID, pcm.getPackageId(IG_URL));
      assertEquals("2.0.0", pcm.getLatestVersion(PACKAGE_ID, true));
      assertEquals("2.0.0", pcm.getLatestVersion(PACKAGE_ID, "2.0.x"));
    }
    // the catalog is searched for each canonical; the IG url isn't there, so it's found in the CI build list,
    // which isn't kept: it is how current builds are found, so each manager loads it once
    assertEquals(2, registry.count("/catalog?"));
    assertEquals(2, registry.count("/ig/qas.json"));
    assertEquals(1, registry.count("/" + PACKAGE_ID));
  }

  @Test
  void packageCacheManagersWithoutAnswersAskEveryTime() throws IOException {
    for (int i = 0; i < 2; i++) {
      FilesystemPackageCacheManager pcm = packageCacheManager(null);
      assertEquals(PACKAGE_ID, pcm.getPackageId(PACKAGE_CANONICAL));
      assertEquals(CI_PACKAGE_ID, pcm.getPackageId(IG_URL));
      assertEquals("2.0.0", pcm.getLatestVersion(PACKAGE_ID, true));
      assertEquals("2.0.0", pcm.getLatestVersion(PACKAGE_ID, "2.0.x"));
    }
    assertEquals(4, registry.count("/catalog?"));
    assertEquals(2, registry.count("/ig/qas.json"));
    assertEquals(4, registry.count("/" + PACKAGE_ID));
  }
}
