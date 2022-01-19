package org.hl7.fhir.utilities;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An {@link Interceptor} for {@link okhttp3.OkHttpClient} that tracks visits to specific urls
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

  final Map<String, Integer> queriedUrls;

  private TxInterceptor() {
    queriedUrls = new HashMap<>();
  }

  @Override
  public Response intercept(Interceptor.Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());

    final String key = getKey(response.request().method(), response.request().url().toString());
    final int count = queriedUrls.containsKey(key) ? queriedUrls.get(key) : 1;

    queriedUrls.put(key, count+1);
    System.out.print("");

    return response;
  }

}