package org.hl7.fhir.utilities.npm;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongSupplier;
import java.util.function.Predicate;

/**
 * Answers from the package registries (catalog searches and version lists) and from build.fhir.org (the list of
 * IG builds), kept for a while so that a long-running process doesn't ask the same question again and again.
 * The validator, for example, checks the dependencies of an IG in every build of a watch session.
 * <p>
 * Only answers are kept: a request that fails (an error status, a timeout, no network, a body that can't be
 * parsed) throws, nothing is kept, and the next caller asks again. So does a body that the caller can't use. A
 * search that finds nothing is an answer.
 * <p>
 * Nothing is cached unless a cache is given to the clients, see
 * {@link FilesystemPackageCacheManager.Builder#withRegistryAnswerCache(RegistryAnswerCache)} and
 * {@link PackageClient#PackageClient(PackageServer, RegistryAnswerCache)}.
 */
public class RegistryAnswerCache {

  public interface Fetcher<T> {
    T fetch() throws IOException;
  }

  private record Answer(Object value, long time) {}

  private final long ttlMillis;
  private final LongSupplier clock;
  private final Map<String, Answer> answers = new ConcurrentHashMap<>();

  /**
   * @param ttlMillis how long an answer is used before the question is asked again
   */
  public RegistryAnswerCache(long ttlMillis) {
    this(ttlMillis, System::currentTimeMillis);
  }

  RegistryAnswerCache(long ttlMillis, LongSupplier clock) {
    this.ttlMillis = ttlMillis;
    this.clock = clock;
  }

  /**
   * @param key the request, e.g. its url; the same key must always be fetched as the same type
   * @return the kept answer if it is younger than the ttl, otherwise the fetcher's answer, which is then kept
   * @throws IOException if the fetcher fails; nothing is kept
   */
  public <T> T get(String key, Fetcher<T> fetcher) throws IOException {
    return get(key, fetcher, value -> true);
  }

  /**
   * @param keep whether the fetcher's answer can be used later; if not, it is returned but not kept
   */
  @SuppressWarnings("unchecked")
  public <T> T get(String key, Fetcher<T> fetcher, Predicate<T> keep) throws IOException {
    Answer answer = answers.get(key);
    if (answer != null && clock.getAsLong() - answer.time() < ttlMillis) {
      return (T) answer.value();
    }
    T value = fetcher.fetch();
    if (keep.test(value)) {
      answers.put(key, new Answer(value, clock.getAsLong()));
    }
    return value;
  }
}
