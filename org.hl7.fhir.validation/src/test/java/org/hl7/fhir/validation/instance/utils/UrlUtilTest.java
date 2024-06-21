package org.hl7.fhir.validation.instance.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;

public class UrlUtilTest {
  private IWorkerContext context;

  public UrlUtilTest() {
    context = TestingUtilities.getSharedWorkerContext();
  }

  @ParameterizedTest
  @ValueSource(strings = {
    "data:text/plain,FHIR",
    "data:,Hello%2C%20World%21",
    "data:text/plain;base64,SGVsbG8sIFdvcmxkIQ==",
    "data:text/plain;charset=UTF-8,FHIR",
    "data:application/octet-stream;base64,RkhJUg==",
    "http://hl7.org/fhir",
    "https://hl7.org/fhir",
    "https://en.wikipedia.org/w/index.php?title=Fast_Healthcare_Interoperability_Resources",
  })
  public void testValidUrl(String url) {
    assertNull(UrlUtil.checkValidUrl(url, context));
  }

  @ParameterizedTest
  @ValueSource(strings = {
    "",
    "data:text/plain", // Actual data is missing
  })
  public void testInvalidUrl(String url) {
    assertNotNull(UrlUtil.checkValidUrl(url, context));
  }

}
