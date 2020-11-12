package org.hl7.fhir.r5.utils.client.network;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Retry Interceptor
 */
public class RetryInterceptor implements Interceptor {

  public int maxRetry;
  private int retryCounter = 0;

  public RetryInterceptor(int maxRetry) {
    this.maxRetry = maxRetry;
  }

  @Override
  public @NotNull Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();
    System.out.println("retryNum = " + retryCounter);
    Response response = chain.proceed(request);
    while (!response.isSuccessful() && (retryCounter < maxRetry)) {
      retryCounter++;
      System.out.println("retryNum = " + retryCounter);
      response = chain.proceed(request);
    }
    return response;
  }
}