package org.hl7.fhir.utilities.npm;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongSupplier;
import java.util.function.Predicate;

import org.hl7.fhir.utilities.http.HTTPResultException;

/**
 * Answers from the package registries (catalog searches and version lists), kept for a while so that a
 * long-running process doesn't ask the same question again and again. The validator, for example, checks the
 * dependencies of an IG in every build of a watch session.
 * <p>
 * Only answers are kept: a request that fails (an error status, a timeout, no network, a body that can't be
 * parsed) throws, nothing is kept, and the next caller asks again. So does a body that the caller can't use. A
 * search that finds nothing is an answer. A 404 is kept as well, for a shorter time: an unknown package is almost
 * always still unknown a few minutes later.
 * <p>
 * The cache belongs to whoever creates it, which decides how long it lives. Nothing is cached unless a cache is
 * given to the clients, see
 * {@link FilesystemPackageCacheManager.Builder#withRegistryAnswerCache(RegistryAnswerCache)} and
 * {@link PackageClient#PackageClient(PackageServer, RegistryAnswerCache)}.
 */
public class RegistryAnswerCache {

  public static final long DEFAULT_ANSWER_TTL = 60 * 60 * 1000L;
  public static final long DEFAULT_NOT_FOUND_TTL = 5 * 60 * 1000L;

  public interface Fetcher<T> {
    T fetch() throws IOException;
  }

  /**
   * either an answer, or the 404 that was the answer (notFound)
   */
  private record Answer(Object value, IOException notFound, long time) {}

  private final long answerTtlMillis;
  private final long notFoundTtlMillis;
  private final LongSupplier clock;
  private final Map<String, Answer> answers = new ConcurrentHashMap<>();

  public RegistryAnswerCache() {
    this(DEFAULT_ANSWER_TTL, DEFAULT_NOT_FOUND_TTL);
  }

  /**
   * @param answerTtlMillis how long an answer is used before the question is asked again
   * @param notFoundTtlMillis how long a 404 is used before the question is asked again
   */
  public RegistryAnswerCache(long answerTtlMillis, long notFoundTtlMillis) {
    this(answerTtlMillis, notFoundTtlMillis, System::currentTimeMillis);
  }

  RegistryAnswerCache(long answerTtlMillis, long notFoundTtlMillis, LongSupplier clock) {
    this.answerTtlMillis = answerTtlMillis;
    this.notFoundTtlMillis = notFoundTtlMillis;
    this.clock = clock;
  }

  /**
   * @param key the request, e.g. its url; the same key must always be fetched as the same type
   * @return the kept answer if it is younger than the ttl, otherwise the fetcher's answer, which is then kept
   * @throws IOException if the fetcher fails; nothing is kept, except a 404, which is thrown again until it expires
   */
  public <T> T get(String key, Fetcher<T> fetcher) throws IOException {
    return get(key, fetcher, value -> true);
  }

  /**
   * @param keep whether the fetcher's answer can be used later; if not, it is returned but not kept. A 404 is
   *             kept either way.
   */
  @SuppressWarnings("unchecked")
  public <T> T get(String key, Fetcher<T> fetcher, Predicate<T> keep) throws IOException {
    Answer answer = answers.get(key);
    if (answer != null) {
      long age = clock.getAsLong() - answer.time();
      if (answer.notFound() != null && age < notFoundTtlMillis) {
        throw new IOException(answer.notFound().getMessage(), answer.notFound().getCause());
      }
      if (answer.notFound() == null && age < answerTtlMillis) {
        return (T) answer.value();
      }
    }
    T value;
    try {
      value = fetcher.fetch();
    } catch (IOException e) {
      if (isNotFound(e)) {
        answers.put(key, new Answer(null, e, clock.getAsLong()));
      }
      throw e;
    }
    if (keep.test(value)) {
      answers.put(key, new Answer(value, null, clock.getAsLong()));
    }
    return value;
  }

  private static boolean isNotFound(IOException e) {
    return e.getCause() instanceof HTTPResultException http && http.httpCode == 404;
  }
}
