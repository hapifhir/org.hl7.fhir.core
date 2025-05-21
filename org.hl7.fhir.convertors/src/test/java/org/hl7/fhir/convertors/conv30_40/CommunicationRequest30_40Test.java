package org.hl7.fhir.convertors.conv30_40;


import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class CommunicationRequest30_40Test {

  @Test
  public void convertCommunicationRequest30to40() throws IOException {

    InputStream r4_input = this.getClass().getResourceAsStream("/communication_request_30.json");
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream("/communication_request_30_converted_to_40.json");

    org.hl7.fhir.dstu3.model.CommunicationRequest dstu3_actual = (org.hl7.fhir.dstu3.model.CommunicationRequest) new org.hl7.fhir.dstu3.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_30_40.convertResource(dstu3_actual);

    org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
    org.hl7.fhir.r4.model.Resource r4_expected = r4_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(r4_expected.equalsDeep(r4_conv),
      "Failed comparing\n" + r4_parser.composeString(r4_expected) + "\nand\n" + r4_parser.composeString(r4_conv));
  }

  @Test
  void testCommunicationRequestConversion40To30() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/communication_request_40.json");
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream("/communication_request_40_converted_to_30.json");

    org.hl7.fhir.r4.model.CommunicationRequest r4_actual = (org.hl7.fhir.r4.model.CommunicationRequest) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_40.convertResource(r4_actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3_expected = dstu3_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(dstu3_expected.equalsDeep(dstu3_conv),
      "Failed comparing\n" + dstu3_parser.composeString(dstu3_expected) + "\nand\n" + dstu3_parser.composeString(dstu3_conv));
  }
}
