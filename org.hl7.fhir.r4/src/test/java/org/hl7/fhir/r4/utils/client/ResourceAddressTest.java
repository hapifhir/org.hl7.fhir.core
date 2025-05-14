package org.hl7.fhir.r4.utils.client;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResourceAddressTest {
  public static Stream<Arguments> getHttpParameters() {
    return Stream.of(
        Arguments.of(Map.of(
          "param1", "value=",
          "param2", "value2")),
      Arguments.of(Map.of(
        "param1", "value%",
        "param2", "value2")),
      Arguments.of(Map.of(
        "param1", "value&",
        "param2", "value2")),
      Arguments.of(Map.of(
        "param1", "value_1",
        "param2", "value2")),
      Arguments.of(Map.of(
          "param1", "urn:oid:1.2.3.4.5",
          "param2", "value2")),
      Arguments.of(Map.of(
        "param1", "urn:oid:1.2.3.4.5",
        "param2", "value=",
        "param3", "value&",
        "param4", "value%",
        "param5", "value5"
      ))
    );
  }

  @Test
  public void appendHttpParametersTest() {
   Map<String, String> params = new HashMap<>();
    params.put("param1", "value1");

    URI uri = ResourceAddress.appendHttpParameters(URI.create("http://example.com"), params);
    assertThat(uri.toString()).isEqualTo("http://example.com?param1=value1");
  }

  @ParameterizedTest
  @MethodSource("getHttpParameters")
  public void appendHttpParametersEscapeTest(Map<String, String> params) {
    URI uri = ResourceAddress.appendHttpParameters(URI.create("http://example.com"), params);
    System.out.println(uri.toString());
    List<NameValuePair> actualParams = URLEncodedUtils.parse(uri, StandardCharsets.UTF_8);
    assertThat(actualParams).hasSize(params.size());
    for (NameValuePair pair: actualParams) {
      String expectedValue = params.get(pair.getName());
      assertThat(pair.getValue()).isEqualTo(expectedValue);
    }
  }

}
