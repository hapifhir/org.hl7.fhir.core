package org.hl7.fhir.utilities.http.okhttpimpl;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * An {@link Interceptor} for {@link okhttp3.OkHttpClient} that controls the number of times we retry a to execute a
 * given request, before reporting a failure. This includes unsuccessful return codes and timeouts.
 */
@Slf4j
public class RetryInterceptor implements Interceptor {

  // Delay between retying failed requests, in millis
  private final long RETRY_TIME = 2000;

  // Maximum number of times to retry the request before failing
  private final int maxRetry;

  // Internal counter for tracking the number of times we've tried this request
  private int retryCounter = 0;

  public RetryInterceptor(int maxRetry) {
    this.maxRetry = maxRetry;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response response = null;

    do {
      try {
        // If we are retrying a failed request that failed due to a bad response from the server, we must close it first
        if (response != null) {
          response.close();
        }
        response = chain.proceed(request);
      } catch (IOException e) {
        try {
          // Include a small break in between requests.
          Thread.sleep(RETRY_TIME);
        } catch (InterruptedException e1) {
          log.info(chain.request().method() + " to url -> " + chain.request().url() + " interrupted on try <" + retryCounter + ">");
        }
      } finally {
        retryCounter++;
      }
    } while ((response == null || !response.isSuccessful()) && (retryCounter <= maxRetry + 1));

    /*
     * if something has gone wrong, and we are unable to complete the request, we still need to initialize the return
     * response so we don't get a null pointer exception.
     */
    return response != null ? response : chain.proceed(request);
  }

}