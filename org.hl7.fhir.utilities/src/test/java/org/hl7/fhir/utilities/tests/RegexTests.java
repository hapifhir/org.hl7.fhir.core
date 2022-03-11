package org.hl7.fhir.utilities.tests;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexTests {

  @Test
  public void testPath1() throws IOException {
    Assertions.assertFalse("http://fhir.org/guides/cqf/common/Library/FHIR-ModelInfo|4.0.1".matches("Library"));
  }
  
  @Test
  public void testPath2() throws IOException {
    Assertions.assertTrue("http://fhir.org/guides/cqf/common/Library/FHIR-ModelInfo|4.0.1".matches(".*Library.*"));
  }
  
  @Test
  public void testPath3() throws IOException {
    Assertions.assertTrue("http://fhir.org/guides/cqf/common/Library/FHIR-ModelInfo|4.0.1".matches("(?s).*Library.*"));
  }

}
