package org.hl7.fhir.convertors.conv30_50;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StructureDefinition30_50Test {
  @Test
  @DisplayName("Test r5 -> dstu3 device conversion.")
  public void test1() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/0_structuredefinition_50.json");
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream("/0_structuredefinition_30.json");

    org.hl7.fhir.r5.model.StructureDefinition r5_actual = (org.hl7.fhir.r5.model.StructureDefinition) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_50.convertResource(r5_actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3_expected = dstu3_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(dstu3_expected.equalsDeep(dstu3_conv),
      "Failed comparing\n" + dstu3_parser.composeString(dstu3_expected) + "\nand\n" + dstu3_parser.composeString(dstu3_conv));
  }
}