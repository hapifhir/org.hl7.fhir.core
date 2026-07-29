package org.hl7.fhir.utilities.http.okhttpimpl;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * An {@link Interceptor} for {@link okhttp3.OkHttpClient} that controls the number of times we retry a request
 * before reporting a failure. This includes unsuccessful return codes and timeouts.
 */
@Slf4j
public class RetryInterceptor implements Interceptor {

  public static final long RETRY_DELAY_MILLIS = 2000;

  // Maximum number of times to retry the request before failing
  private final int maxRetry;

  public RetryInterceptor(int maxRetry) {
    this.maxRetry = Math.max(0, maxRetry);
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response response = null;

    for (int attempt = 0; attempt <= maxRetry; attempt++) {
      try {
        if (response != null) {
          response.close();
          response = null;
        }
        response = chain.proceed(request);

        if (response.isSuccessful() || attempt == maxRetry) {
          return response;
        }
      } catch (IOException e) {
        if (attempt == maxRetry) {
          throw e;
        }
      }

      try {
        Thread.sleep(RETRY_DELAY_MILLIS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        log.info(chain.request().method() + " to url -> " + chain.request().url()
          + " interrupted on try <" + attempt + ">");
        if (response != null) {
          return response;
        }
        throw new IOException("Interrupted while waiting to retry " + request.method()
          + " to " + request.url(), e);
      }
    }

    throw new IOException("Request retry loop exited without a response for " + request.method()
      + " to " + request.url());
  }

}
