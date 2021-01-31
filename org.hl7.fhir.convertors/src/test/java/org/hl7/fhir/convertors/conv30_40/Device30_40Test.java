package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class Device30_40Test {
  @Test
  @DisplayName("Test r4 -> dstu3 device conversion.")
  public void test1() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/0_device_40.json");
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream("/0_device_30.json");

    org.hl7.fhir.r4.model.Device r4_actual = (org.hl7.fhir.r4.model.Device) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertor_30_40.convertResource(r4_actual, true);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3_expected = dstu3_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(dstu3_expected.equalsDeep(dstu3_conv),
      "Failed comparing\n" + dstu3_parser.composeString(dstu3_expected) + "\nand\n" + dstu3_parser.composeString(dstu3_conv));
  }

  @Test
  @DisplayName("Test r4 -> dstu3 device conversion, part 2.")
  public void test2() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/1_device_40.json");
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream("/1_device_30.json");

    org.hl7.fhir.r4.model.Device r4_actual = (org.hl7.fhir.r4.model.Device) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertor_30_40.convertResource(r4_actual, true);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3_expected = dstu3_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(dstu3_expected.equalsDeep(dstu3_conv),
      "Failed comparing\n" + dstu3_parser.composeString(dstu3_expected) + "\nand\n" + dstu3_parser.composeString(dstu3_expected));
  }
}