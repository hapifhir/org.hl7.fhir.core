package org.hl7.fhir.utilities.http.okhttpimpl;

import okhttp3.*;
import okio.Buffer;
import org.hl7.fhir.utilities.ToolingClientLogger;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoggingInterceptor implements Interceptor{

    private ToolingClientLogger logger;

    public LoggingInterceptor(ToolingClientLogger logger) {
      this.logger = logger;
    }

    public LoggingInterceptor setLogger(ToolingClientLogger logger) {
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
        long responseTimeInMillis = response.receivedResponseAtMillis() - response.sentRequestAtMillis();
        logger.logResponse(Integer.toString(response.code()), headerList, bodyBytes, responseTimeInMillis);
      }

      // Reading byte[] clears body. Need to recreate.
      ResponseBody body = ResponseBody.create(bodyBytes, contentType);
      return response.newBuilder().body(body).build();
    }
}
