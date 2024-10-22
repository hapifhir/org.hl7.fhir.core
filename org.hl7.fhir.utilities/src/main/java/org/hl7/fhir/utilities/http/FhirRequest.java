package org.hl7.fhir.utilities.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

import javax.annotation.Nullable;
import java.net.URL;

@AllArgsConstructor
public class FhirRequest {

  public FhirRequest() {
    url = null;
    method = HttpMethod.GET;
    body = null;
  }

  public enum HttpMethod {
    GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH
  }

  @With @Getter @Nullable
  private final URL url;

  @With @Getter
  private HttpMethod method;

  @With @Getter @Nullable
  private byte[] body;

  @With @Getter @Nullable
  private String contentType;
}
