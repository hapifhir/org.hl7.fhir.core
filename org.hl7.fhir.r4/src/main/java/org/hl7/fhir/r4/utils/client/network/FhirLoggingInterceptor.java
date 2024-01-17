package org.hl7.fhir.r4.utils.client.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.hl7.fhir.utilities.ToolingClientLogger;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class FhirLoggingInterceptor implements Interceptor {

  private ToolingClientLogger logger;

  public FhirLoggingInterceptor(ToolingClientLogger logger) {
    this.logger = logger;
  }

  public FhirLoggingInterceptor setLogger(ToolingClientLogger logger) {
    this.logger = logger;
    return this;
  }

  @Override
  public Response intercept(@Nonnull Interceptor.Chain chain) throws IOException {
    // Log Request
    Request request = chain.request();
    List<String> hdrs = new ArrayList<>();
    for (String s : request.headers().toString().split("\\n")) {
      hdrs.add(s.trim());
    }
    byte[] cnt = null;
    if (request.body() != null) {
      Buffer buf = new Buffer();
      request.body().writeTo(buf);
      cnt = buf.readByteArray();
    }
    if (logger != null) {
      logger.logRequest(request.method(), request.url().toString(), hdrs, cnt);
    }

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

    if (logger != null) {
      logger.logResponse(Integer.toString(response.code()), headerList, bodyBytes);
    }

    // Reading byte[] clears body. Need to recreate.
    ResponseBody body = ResponseBody.create(bodyBytes, contentType);
    return response.newBuilder().body(body).build();
  }
}
