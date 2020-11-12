package org.hl7.fhir.r5.utils.client.network;

import okhttp3.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class FhirRequestBuilderTest {

  @Test
  void addDefaultHeaders() {
    Request.Builder request = new Request.Builder().url("www.google.com");
    FhirRequestBuilder.addDefaultHeaders(request);

    Map headers = request.build().headers().toMultimap();
    Assertions.assertNotNull(headers.get("User-Agent"), "User-Agent header null.");
    Assertions.assertEquals(headers.get("User-Agent"), "hapi-fhir-tooling-client",
      "User-Agent header not populated with expected value \"hapi-fhir-tooling-client\".");

    Assertions.assertNotNull(headers.get("Accept-Charset"), "Accept-Charset header null.");
    Assertions.assertEquals(headers.get("Accept-Charset"), FhirRequestBuilder.DEFAULT_CHARSET,
      "Accept-Charset header not populated with expected value " + FhirRequestBuilder.DEFAULT_CHARSET);
  }

  @Test
  void addResourceFormatHeaders() {
  }

  @Test
  void addHeaders() {
  }
}