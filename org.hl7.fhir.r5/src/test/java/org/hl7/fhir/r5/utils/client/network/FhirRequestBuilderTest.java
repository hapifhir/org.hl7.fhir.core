package org.hl7.fhir.r5.utils.client.network;

import okhttp3.Headers;
import okhttp3.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FhirRequestBuilderTest {


  @Test
  void addDefaultHeaders() {
    Request.Builder request = new Request.Builder().url("http://www.google.com");
    FhirRequestBuilder.addDefaultHeaders(request);

    Map<String, List<String>> headersMap = request.build().headers().toMultimap();
    Assertions.assertNotNull(headersMap.get("User-Agent"), "User-Agent header null.");
    Assertions.assertEquals("hapi-fhir-tooling-client", headersMap.get("User-Agent").get(0),
      "User-Agent header not populated with expected value \"hapi-fhir-tooling-client\".");

    Assertions.assertNotNull(headersMap.get("Accept-Charset"), "Accept-Charset header null.");
    Assertions.assertEquals(FhirRequestBuilder.DEFAULT_CHARSET, headersMap.get("Accept-Charset").get(0),
      "Accept-Charset header not populated with expected value " + FhirRequestBuilder.DEFAULT_CHARSET);
  }

  @Test
  void addResourceFormatHeaders() {
    String testFormat = "yaml";
    Request.Builder request = new Request.Builder().url("http://www.google.com");
    FhirRequestBuilder.addResourceFormatHeaders(request, testFormat);

    Map<String, List<String>> headersMap = request.build().headers().toMultimap();
    Assertions.assertNotNull(headersMap.get("Accept"), "Accept header null.");
    Assertions.assertEquals(testFormat, headersMap.get("Accept").get(0),
      "Accept header not populated with expected value " + testFormat + ".");

    Assertions.assertNotNull(headersMap.get("Content-Type"), "Content-Type header null.");
    Assertions.assertEquals(testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET, headersMap.get("Content-Type").get(0),
      "Content-Type header not populated with expected value \"" + testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET + "\".");
  }

  @Test
  void addHeaders() {
    String headerName1 = "headerName1";
    String headerValue1 = "headerValue1";
    String headerName2 = "headerName2";
    String headerValue2 = "headerValue2";

    Headers headers = new Headers.Builder()
      .add(headerName1, headerValue1)
      .add(headerName2, headerValue2)
      .build();

    Request.Builder request = new Request.Builder().url("http://www.google.com");
    FhirRequestBuilder.addHeaders(request, headers);

    Map<String, List<String>> headersMap = request.build().headers().toMultimap();
    Assertions.assertNotNull(headersMap.get(headerName1), headerName1 + " header null.");
    Assertions.assertEquals(headerValue1, headersMap.get(headerName1).get(0),
      headerName1 + " header not populated with expected value " + headerValue1 + ".");
    Assertions.assertNotNull(headersMap.get(headerName2), headerName2 + " header null.");
    Assertions.assertEquals(headerValue2, headersMap.get(headerName2).get(0),
      headerName2 + " header not populated with expected value " + headerValue2 + ".");
  }
}