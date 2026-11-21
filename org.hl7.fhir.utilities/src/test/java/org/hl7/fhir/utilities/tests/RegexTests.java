package org.hl7.fhir.utilities.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RegexTests {

  @Test
  void testPath1() throws IOException {
    Assertions.assertFalse("http://fhir.org/guides/cqf/common/Library/FHIR-ModelInfo|4.0.1".matches("Library"));
  }

  @Test
  void testPath2() throws IOException {
    Assertions.assertTrue("http://fhir.org/guides/cqf/common/Library/FHIR-ModelInfo|4.0.1".matches(".*Library.*"));
  }

  @Test
  void testPath3() throws IOException {
    Assertions.assertTrue("http://fhir.org/guides/cqf/common/Library/FHIR-ModelInfo|4.0.1".matches("(?s).*Library.*"));
  }

}
