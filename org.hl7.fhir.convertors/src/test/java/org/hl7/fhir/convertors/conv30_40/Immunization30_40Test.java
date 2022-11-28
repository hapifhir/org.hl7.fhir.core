package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class Immunization30_40Test {

  private org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
  private org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();

  public static Stream<Arguments> getR4toDSTU3Arguments() {
    return Stream.of(
      Arguments.of("test1", "/immunization_40-not-done.json", "/immunization_30_completed_notGiven.json")
    );
  }
  @ParameterizedTest(name = "Test r4 -> dstu3 immunization conversions {0}")
  @MethodSource("getR4toDSTU3Arguments")
  public void test1(String testName, String r4_input_resource, String dstu3_expected_output_resource) throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream(r4_input_resource);
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream(dstu3_expected_output_resource);

    org.hl7.fhir.r4.model.Immunization r4_actual = (org.hl7.fhir.r4.model.Immunization) r4_parser.parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_40.convertResource(r4_actual, new BaseAdvisor_30_40(false));

    org.hl7.fhir.dstu3.model.Resource dstu3_expected = dstu3_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(dstu3_expected.equalsDeep(dstu3_conv),
      "Failed comparing\n" + dstu3_parser.composeString(dstu3_expected) + "\nand\n" + dstu3_parser.composeString(dstu3_conv));
  }

  public static Stream<Arguments> getDSTU3toR4Arguments() {
    return Stream.of(
      Arguments.of("test1", "/immunization_30_completed_notGiven.json", "/immunization_40-not-done-notGiven.json")
    );
  }

  @ParameterizedTest(name = "Test dstu3 -> r4 immunization conversions {0}")
  @MethodSource("getDSTU3toR4Arguments")
  public void test2(String testName, String dstu3_input_resource, String r4_expected_output_resource) throws IOException {
    InputStream dstu3_input = this.getClass().getResourceAsStream(dstu3_input_resource);

    org.hl7.fhir.dstu3.model.Immunization dstu3_actual = (org.hl7.fhir.dstu3.model.Immunization) dstu3_parser.parse(dstu3_input);
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_30_40.convertResource(dstu3_actual, new BaseAdvisor_30_40(false));

    InputStream r4_expected_output = this.getClass().getResourceAsStream(r4_expected_output_resource);
    org.hl7.fhir.r4.model.Resource r4_expected = r4_parser.parse(r4_expected_output);

    Assertions.assertTrue(r4_expected.equalsDeep(r4_conv),
      "Failed comparing\n" + r4_parser.composeString(r4_expected) + "\nand\n" + r4_parser.composeString(r4_conv));
  }

  @Test
  @DisplayName("")
  public void test3() throws IOException {

  }
}
