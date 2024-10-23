package org.hl7.fhir.utilities.http;

import lombok.With;
import okhttp3.*;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.http.okhttpimpl.LoggingInterceptor;
import org.hl7.fhir.utilities.http.okhttpimpl.ProxyAuthenticator;
import org.hl7.fhir.utilities.http.okhttpimpl.RetryInterceptor;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ManagedFhirWebAccessBuilder extends ManagedWebAccessBuilderBase<ManagedFhirWebAccessBuilder>{

  /**
   * The singleton instance of the HttpClient, used for all requests.
   */
  private static OkHttpClient okHttpClient;

  private long timeout;
  private TimeUnit timeoutUnit;
  private int retries;
  private ToolingClientLogger logger;
  private LoggingInterceptor loggingInterceptor;

  public ManagedFhirWebAccessBuilder withTimeout(long timeout, TimeUnit timeoutUnit) {
    this.timeout = timeout;
    this.timeoutUnit = timeoutUnit;
    return this;
  }

  public ManagedFhirWebAccessBuilder withRetries(int retries) {
    this.retries = retries;
    return this;
  }

  public ManagedFhirWebAccessBuilder withLogger(ToolingClientLogger logger) {
    this.logger = logger;
    this.loggingInterceptor = new LoggingInterceptor(logger);
    return this;
  }


  public ManagedFhirWebAccessBuilder(String userAgent, List<ServerDetailsPOJO> serverAuthDetails) {
    super(userAgent, serverAuthDetails);
  }

  private void setHeaders(Request.Builder httpRequest) {
    for (Map.Entry<String, String> entry : this.getHeaders().entrySet()) {
      httpRequest.header(entry.getKey(), entry.getValue());
    }
  }

  public Response httpCall(Request.Builder httpRequest) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
      case DIRECT:
        OkHttpClient okHttpClient = getOkHttpClient();
        //TODO check and throw based on httpRequest:
        // if (!ManagedWebAccess.inAllowedPaths(url)) {
        //      throw new IOException("The pathname '"+url+"' cannot be accessed by policy");
        // }
        //TODO add auth headers to httpRequest
        return okHttpClient.newCall(httpRequest.build()).execute();
      case MANAGED:
        setHeaders(httpRequest);
        return ManagedWebAccess.getFhirWebAccessor().httpCall(httpRequest);
      case PROHIBITED:
        throw new IOException("Access to the internet is not allowed by local security policy");
      default:
        throw new IOException("Internal Error");
    }
  }

  private OkHttpClient getOkHttpClient() {
    if (okHttpClient == null) {
      okHttpClient = new OkHttpClient();
    }
    OkHttpClient.Builder builder = okHttpClient.newBuilder();
    if (logger != null) builder.addInterceptor(loggingInterceptor);
    builder.addInterceptor(new RetryInterceptor(retries));
    builder.proxyAuthenticator(new ProxyAuthenticator());
    return builder.connectTimeout(timeout, timeoutUnit)
      .writeTimeout(timeout, timeoutUnit)
      .readTimeout(timeout, timeoutUnit).build();
  }

}
