package org.hl7.fhir.dstu2016may.test;

import org.hl7.fhir.dstu2016may.formats.JsonParser;
import org.hl7.fhir.dstu2016may.model.Resource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResourceEqualsTests {

  private JsonParser dstu2016_parser = new JsonParser();;

  @ParameterizedTest
  @ValueSource(strings = { "conformance_example_1.json", "immunization_example_1.json", "patient_example_1.json" })
  public void testEquals(String resourcePath) throws IOException {

    org.hl7.fhir.dstu2016may.model.Resource resourceA = getResource(resourcePath);

    org.hl7.fhir.dstu2016may.model.Resource resourceB = getResource(resourcePath);

    assertTrue(resourceA.equalsShallow(resourceB));
    assertTrue(resourceA.equalsDeep(resourceB));

  }

  private Resource getResource(String resource) throws IOException {
    Resource resourceA;
    InputStream inputA = this.getClass().getResourceAsStream(getResourcePath(resource));
    resourceA = dstu2016_parser.parse(inputA);
    return resourceA;
  }

  @Nonnull
  private static String getResourcePath(String resource) {
    return "/" + resource;
  }

  /*
   * All files pairs contain a single difference, which can be evaluated with a
   * diff. These differences are at various depths in the element tree, but not at
   * the shallow level.
   */
  @ParameterizedTest
  @CsvSource({ "conformance_example_1.json,conformance_example_2.json",
      "immunization_example_1.json,immunization_example_2.json", "patient_example_1.json,patient_example_2.json" })
  public void testEqualsDeepFalse(String resourceAName, String resourceBName) throws IOException {
    org.hl7.fhir.dstu2016may.model.Resource resourceA = getResource(resourceAName);

    org.hl7.fhir.dstu2016may.model.Resource resourceB = getResource(resourceBName);
    assertTrue(resourceA.equalsShallow(resourceB));
    assertFalse(resourceA.equalsDeep(resourceB));
  }

  /*
   * All files pairs contain a single difference, which can be evaluated with a
   * diff. These differences are at the shallow level.
   */
  @ParameterizedTest
  @CsvSource({ "conformance_example_1.json,conformance_example_3.json",
      "immunization_example_1.json,immunization_example_3.json", "patient_example_1.json,patient_example_3.json" })
  public void testEqualsShallowFalse(String resourceAName, String resourceBName) throws IOException {
    org.hl7.fhir.dstu2016may.model.Resource resourceA = getResource(resourceAName);

    org.hl7.fhir.dstu2016may.model.Resource resourceB = getResource(resourceBName);
    assertFalse(resourceA.equalsShallow(resourceB));
    assertFalse(resourceA.equalsDeep(resourceB));
  }
}
