package org.hl7.fhir.utilities.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@AllArgsConstructor
public class FhirRequest {

  public enum HttpMethod {
    GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH
  }

  @With @Getter
  private final String url;

  @With @Getter
  private HttpMethod method;

  @With @Getter
  private byte[] body;
}
