package org.hl7.fhir.validation.cli.controller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hl7.fhir.validation.cli.BaseRestTest;
import org.hl7.fhir.validation.cli.ValidatorGui;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class HttpGetContextTest extends BaseRestTest {

  private final String GET_CONTEXT_URL = "http://localhost:" + ValidatorGui.getPort() + "/context";

  @Test
  @DisplayName("Testing status code on get context endpoint.")
  public void testStatus() throws IOException {
    HttpUriRequest request = new HttpGet(GET_CONTEXT_URL);
    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
    Assertions.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
  }

  @Test
  @DisplayName("Testing media type on get context endpoint.")
  public void testMediaType() throws IOException {
    HttpUriRequest request = new HttpGet(GET_CONTEXT_URL);
    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
    String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
    Assertions.assertEquals(JSON_MIME_TYPE, mimeType );
  }

  @Test
  @DisplayName("Testing status code on get context endpoint.")
  public void testJSONPayload() throws IOException {
    HttpUriRequest request = new HttpGet(GET_CONTEXT_URL);
    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
    CliContext resource = retrieveResourceFromResponse(httpResponse, CliContext.class);
    Assertions.assertEquals(new CliContext(), resource);
  }

}