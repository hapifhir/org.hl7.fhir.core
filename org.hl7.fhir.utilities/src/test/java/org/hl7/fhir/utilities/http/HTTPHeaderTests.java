package org.hl7.fhir.utilities.http;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HTTPHeaderTests {
  @Test
  void testHTTPHeaderEquals() {
    HTTPHeader header1 = new HTTPHeader("name", "value1");
    HTTPHeader sameAsHeader1 = new HTTPHeader("name", "value1");
    assertThat(header1).isEqualTo(sameAsHeader1);

    HTTPHeader notSameNameAsHeader1 = new HTTPHeader("name2", "value1");
    assertThat(header1).isNotEqualTo(notSameNameAsHeader1);

    HTTPHeader notSameValueAsHeader1 = new HTTPHeader("name", "value2");
    assertThat(header1).isNotEqualTo(notSameValueAsHeader1);
  }
}
