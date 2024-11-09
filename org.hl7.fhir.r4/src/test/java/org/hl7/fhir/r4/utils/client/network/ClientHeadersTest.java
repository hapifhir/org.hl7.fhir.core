package org.hl7.fhir.r4.utils.client.network;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ClientHeadersTest {
  ClientHeaders clientHeaders;

  HTTPHeader h1 = new HTTPHeader("header1", "value1");
  HTTPHeader h2 = new HTTPHeader("header2", "value2");
  HTTPHeader h3 = new HTTPHeader("header3", "value3");

  @BeforeEach
  void setUp() {
    clientHeaders = new ClientHeaders();
  }

  @Test
  @DisplayName("Happy path add headers individually.")
  void addHeader() {
    clientHeaders.addHeader(h1);
    Assertions.assertEquals(1, clientHeaders.headers().size());
    clientHeaders.addHeader(h2);
    Assertions.assertEquals(2, clientHeaders.headers().size());
  }

  @Test
  @DisplayName("Test duplicate header added individually throws FHIRException.")
  void addHeaderDuplicateAdd() {
    clientHeaders.addHeader(h1);
    Assertions.assertThrows(FHIRException.class, () -> clientHeaders.addHeader(h1));
  }

  @Test
  @DisplayName("Happy path add headers as list.")
  void addHeaders() {
    List<HTTPHeader> headersList = Arrays.asList(h1, h2, h3);
    clientHeaders.addHeaders(headersList);
    Assertions.assertEquals(3, clientHeaders.headers().size());
    Assertions.assertEquals(headersList, clientHeaders.headers());
  }

  @Test
  @DisplayName("Happy path add headers as list.")
  void addHeadersDuplicateAdd() {
    List<HTTPHeader> headersList = Arrays.asList(h1, h2, h1);
    Assertions.assertThrows(FHIRException.class, () -> clientHeaders.addHeaders(headersList));
  }

  @Test
  @DisplayName("Happy path remove existing header.")
  void removeHeader() {
    clientHeaders.addHeader(h1);
    clientHeaders.addHeader(h2);
    clientHeaders.addHeader(h3);
    clientHeaders.removeHeader(h2);
    Assertions.assertEquals(2, clientHeaders.headers().size());
    clientHeaders.removeHeader(new HTTPHeader("header3", "value3"));
    Assertions.assertEquals(1, clientHeaders.headers().size());
  }

  @Test
  @DisplayName("Remove header not contained in list.")
  void removeHeaderUnknown() {
    clientHeaders.addHeader(h1);
    clientHeaders.addHeader(h2);
    Assertions.assertThrows(FHIRException.class, () -> clientHeaders.removeHeader(h3));
  }

  @Test
  @DisplayName("Happy path remove list of existing headers.")
  void removeHeaders() {
    List<HTTPHeader> headersToAddList = Arrays.asList(h1, h2, h3);
    List<HTTPHeader> headersToRemoveList = Arrays.asList(h2, h3);
    clientHeaders.addHeaders(headersToAddList);
    clientHeaders.removeHeaders(headersToRemoveList);
    Assertions.assertEquals(1, clientHeaders.headers().size());
  }

  @Test
  @DisplayName("Remove list containing unknown header.")
  void removeHeadersUnknown() {
    List<HTTPHeader> headersToAddList = Arrays.asList(h1, h3);
    List<HTTPHeader> headersToRemoveList = Arrays.asList(h2, h3);
    clientHeaders.addHeaders(headersToAddList);
    Assertions.assertThrows(FHIRException.class, () -> clientHeaders.removeHeaders(headersToRemoveList));
  }

  @Test
  void clearHeaders() {
    List<HTTPHeader> headersToAddList = Arrays.asList(h1, h3);
    clientHeaders.addHeaders(headersToAddList);
    Assertions.assertEquals(2, clientHeaders.headers().size());
    clientHeaders.clearHeaders();
    Assertions.assertEquals(0, clientHeaders.headers().size());
  }
}
