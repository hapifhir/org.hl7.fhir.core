package org.hl7.fhir.utilities;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * An {@link Interceptor} for {@link okhttp3.OkHttpClient} that controls the number of times we retry a to execute a
 * given request, before reporting a failure. This includes unsuccessful return codes and timeouts.
 */
public class TxInterceptor implements Interceptor {

  private String getKey(String method, String url) {
    return method + " " + url;
  }

  private static TxInterceptor instance;

  public static TxInterceptor getInstance() {
    if (instance == null) {
      instance = new TxInterceptor();
    }
    return instance;
  }

  final Set<String> queriedUrls;

  private TxInterceptor() {
    queriedUrls = new HashSet<>();
  }

  @Override
  public Response intercept(Interceptor.Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());

    final String key = getKey(response.request().method(), response.request().url().toString());
    if (!queriedUrls.contains(key)) {
      queriedUrls.add(key);
      System.out.print("");
    }

    return response;
  }

}