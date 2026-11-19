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
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //single literal character split
      String[] headerLines = request.headers().toString().split("\\n");

      for (String headerLine : headerLines) {
        hdrs.add(headerLine.trim());
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
      long start = System.currentTimeMillis();
      final Response response;
      try {
        response = chain.proceed(chain.request());
      } catch (IOException | RuntimeException e) {
        // no response to log, but the request has been logged: say what became of it, or the log
        // shows a request with no answer, and nothing about the time it took to fail
        logFailure(e, start);
        throw e;
      }

      // the original response is always closed: its body is read into memory and a new response
      // is returned with a copy of it, so the network connection is released whatever happens
      try (response) {
        MediaType contentType = response.body().contentType();
        byte[] bodyBytes;
        try {
          bodyBytes = response.body().bytes();
        } catch (IOException | RuntimeException e) {
          // the response started, but reading the body failed (e.g. a read timeout)
          logFailure(e, start);
          throw e;
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
        return response.newBuilder().body(ResponseBody.create(bodyBytes, contentType)).build();
      }
    }

    private void logFailure(Exception e, long start) {
      if (logger != null) {
        logger.logFailure(e.getClass().getSimpleName() + (e.getMessage() != null ? ": " + e.getMessage() : ""), System.currentTimeMillis() - start);
      }
    }
}
