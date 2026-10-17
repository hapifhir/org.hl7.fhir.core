package org.hl7.fhir.utilities.http.okhttpimpl;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * An {@link Interceptor} for {@link okhttp3.OkHttpClient} that controls the number of times we retry a to execute a
 * given request, before reporting a failure. This includes unsuccessful return codes and timeouts. Redirect
 * responses (3xx) are treated as successful for retry purposes, since they are expected outcomes handled by the
 * caller rather than failures. So are 401 and 403: repeating a request with the same credentials cannot change
 * an authentication or authorisation decision, and {@link org.hl7.fhir.utilities.http.ManagedHTTPClient} handles
 * a 401 itself by refreshing credentials that can go stale.
 * <p>
 * {@code maxRetry} is the number of attempts made after the first, so 0 sends the request exactly once.
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
    IOException lastException = null;

    do {
      try {
        // If we are retrying a failed request that failed due to a bad response from the server, we must close it first
        if (response != null) {
          response.close();
        }
        response = chain.proceed(request);
      } catch (IOException e) {
        // The failed attempt's response (if any) was already closed above; forget it so a
        // subsequent IOException doesn't cause a stale, closed Response to be returned below.
        response = null;
        lastException = e;
        // Include a small break in between requests - but only if there will be another one.
        if (retryCounter < maxRetry) {
          try {
            Thread.sleep(RETRY_TIME);
          } catch (InterruptedException e1) {
            log.info(chain.request().method() + " to url -> " + chain.request().url() + " interrupted on try <" + retryCounter + ">");
          }
        }
      } finally {
        retryCounter++;
      }
    } while (isRetryable(response) && (retryCounter <= maxRetry));

    // Every attempt failed at the transport level. Report the last failure rather than making one more attempt
    // outside the budget - a request carrying credentials must not be sent more times than the caller allowed.
    if (response == null) {
      throw lastException;
    }
    return response;
  }

  private static boolean isRetryable(Response response) {
    if (response == null) {
      return true;
    }
    int code = response.code();
    return !response.isSuccessful() && !response.isRedirect() && code != 401 && code != 403;
  }

}