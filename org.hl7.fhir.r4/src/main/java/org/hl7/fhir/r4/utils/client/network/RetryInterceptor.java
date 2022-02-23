package org.hl7.fhir.r4.utils.client.network;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * An {@link Interceptor} for {@link okhttp3.OkHttpClient} that controls the number of times we retry a to execute a
 * given request, before reporting a failure. This includes unsuccessful return codes and timeouts.
 */
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
  public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();
    Response response = null;

    do {
      try {
        // If we are retrying a failed request that failed due to a bad response from the server, we must close it first
        if (response != null) {
//          System.out.println("Previous " + chain.request().method() + " attempt returned HTTP<" + (response.code())
//            + "> from url -> " + chain.request().url() + ".");
          response.close();
        }
        // System.out.println(chain.request().method() + " attempt <" + (retryCounter + 1) + "> to url -> " + chain.request().url());
        response = chain.proceed(request);
      } catch (IOException e) {
        try {
          // Include a small break in between requests.
          Thread.sleep(RETRY_TIME);
        } catch (InterruptedException e1) {
          System.out.println(chain.request().method() + " to url -> " + chain.request().url() + " interrupted on try <" + retryCounter + ">");
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