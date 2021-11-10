package org.hl7.fhir.r4.utils.client.network;

import okhttp3.*;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FhirLoggingInterceptor implements Interceptor {

  private ToolingClientLogger logger;

  public FhirLoggingInterceptor(ToolingClientLogger logger) {
    this.logger = logger;
  }

  public FhirLoggingInterceptor setLogger(ToolingClientLogger logger) {
    this.logger = logger;
    return this;
  }

  @NotNull
  @Override
  public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
    // Log Request
    Request request = chain.request();
    logger.logRequest(request.method(), request.url().toString(), new ArrayList<>(request.headers().names()),
      request.body() != null ? request.body().toString().getBytes() : null);

    // Log Response
    Response response = null;
    response = chain.proceed(chain.request());

    MediaType contentType = null;
    byte[] bodyBytes = null;
    if (response.body() != null) {
      contentType = response.body().contentType();
      bodyBytes = response.body().bytes();
    }

    // Get Headers as List
    List<String> headerList = new ArrayList<>();
    Map<String, List<String>> headerMap = response.headers().toMultimap();
    headerMap.keySet().forEach(key -> headerMap.get(key).forEach(value -> headerList.add(key + ":" + value)));

    logger.logResponse(Integer.toString(response.code()), headerList, bodyBytes);

    // Reading byte[] clears body. Need to recreate.
    ResponseBody body = ResponseBody.create(bodyBytes, contentType);
    return response.newBuilder().body(body).build();
  }
}
