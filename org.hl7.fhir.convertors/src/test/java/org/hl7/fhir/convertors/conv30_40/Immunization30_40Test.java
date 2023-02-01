package org.hl7.fhir.convertors.conv30_40;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Immunization30_40Test {

  private org.hl7.fhir.r4.formats.JsonParser r4Parser = new org.hl7.fhir.r4.formats.JsonParser();
  private org.hl7.fhir.dstu3.formats.JsonParser dstu3Parser = new org.hl7.fhir.dstu3.formats.JsonParser();

  public static Stream<Arguments> getR4toDSTU3Arguments() {
    return Stream.of(
      Arguments.of("not-done no notGiven extension", "/immunization_40_not-done.json", "/immunization_30_completed_notGiven.json"),
      Arguments.of("completed no notGiven extension", "/immunization_40_completed.json", "/immunization_30_completed_given.json"),
      Arguments.of("entered-in-error no notGiven extension", "/immunization_40_entered-in-error.json", "/immunization_30_entered-in-error_given.json"),
      Arguments.of("entered-in-error notGiven extension", "/immunization_40_entered-in-error_notGiven-extension.json", "/immunization_30_entered-in-error_notGiven.json")
    );
  }
  @ParameterizedTest(name = "Test r4 -> dstu3 immunization conversions: {0}")
  @MethodSource("getR4toDSTU3Arguments")
  public void R4toDSTU3Tests(String testName, String r4InputResource, String dstu3ExpectedOutputResource) throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream(r4InputResource);
    InputStream dstu3ExpectedOutput = this.getClass().getResourceAsStream(dstu3ExpectedOutputResource);

    org.hl7.fhir.r4.model.Immunization r4Actual = (org.hl7.fhir.r4.model.Immunization) r4Parser.parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3Converted = VersionConvertorFactory_30_40.convertResource(r4Actual, new BaseAdvisor_30_40(false));

    org.hl7.fhir.dstu3.model.Resource dstu3Expected = dstu3Parser.parse(dstu3ExpectedOutput);

    Assertions.assertTrue(dstu3Expected.equalsDeep(dstu3Converted),
      "Failed comparing\n" + dstu3Parser.composeString(dstu3Expected) + "\nand\n" + dstu3Parser.composeString(dstu3Converted));
  }

  public static Stream<Arguments> getDSTU3toR4Arguments() {
    return Stream.of(
      Arguments.of("completed notGiven=true", "/immunization_30_completed_notGiven.json", "/immunization_40_not-done_notGiven-extension.json"),
      Arguments.of("completed notGiven=false", "/immunization_30_completed_given.json", "/immunization_40_completed_given-extension.json"),
      Arguments.of("entered-in-error notGiven=true", "/immunization_30_entered-in-error_notGiven.json", "/immunization_40_not-done_notGiven-extension.json")
    );
  }

  @ParameterizedTest(name = "Test dstu3 -> r4 immunization conversions: {0}")
  @MethodSource("getDSTU3toR4Arguments")
  public void DSTU3toR4Tests(String testName, String dstu3InputResource, String r4ExpectedOutputResource) throws IOException {
    InputStream dstu3_input = this.getClass().getResourceAsStream(dstu3InputResource);

    org.hl7.fhir.dstu3.model.Immunization dstu3_actual = (org.hl7.fhir.dstu3.model.Immunization) dstu3Parser.parse(dstu3_input);
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_30_40.convertResource(dstu3_actual, new BaseAdvisor_30_40(false));

    InputStream r4_expected_output = this.getClass().getResourceAsStream(r4ExpectedOutputResource);
    org.hl7.fhir.r4.model.Resource r4_expected = r4Parser.parse(r4_expected_output);

    Assertions.assertTrue(r4_expected.equalsDeep(r4_conv),
      "Failed comparing\n" + r4Parser.composeString(r4_expected) + "\nand\n" + r4Parser.composeString(r4_conv));
  }

}
