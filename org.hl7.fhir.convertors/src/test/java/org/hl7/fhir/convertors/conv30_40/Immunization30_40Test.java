package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class Immunization30_40Test {

  @Test
  @DisplayName("Test r4 -> dstu3 immunization conversion.")
  public void test1() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/immunization_40.json");
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream("/immunization_30.json");

    org.hl7.fhir.r4.model.Immunization r4_actual = (org.hl7.fhir.r4.model.Immunization) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_40.convertResource(r4_actual, new BaseAdvisor_30_40(false));

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3_expected = dstu3_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(dstu3_expected.equalsDeep(dstu3_conv),
      "Failed comparing\n" + dstu3_parser.composeString(dstu3_expected) + "\nand\n" + dstu3_parser.composeString(dstu3_conv));
  }

  @Test
  @DisplayName("Test dstu3 -> r4 immunization conversion.")
  public void test2() throws IOException {
    InputStream dstu3_input = this.getClass().getResourceAsStream("/immunization_30.json");
    InputStream r4_expected_output = this.getClass().getResourceAsStream("/immunization_40.json");

    org.hl7.fhir.dstu3.model.Immunization dstu3_actual = (org.hl7.fhir.dstu3.model.Immunization) new org.hl7.fhir.dstu3.formats.JsonParser().parse(dstu3_input);
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_30_40.convertResource(dstu3_actual, new BaseAdvisor_30_40(false));

    org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
    org.hl7.fhir.r4.model.Resource r4_expected = r4_parser.parse(r4_expected_output);

    Assertions.assertTrue(r4_expected.equalsDeep(r4_conv),
      "Failed comparing\n" + r4_parser.composeString(r4_expected) + "\nand\n" + r4_parser.composeString(r4_conv));
  }

}
