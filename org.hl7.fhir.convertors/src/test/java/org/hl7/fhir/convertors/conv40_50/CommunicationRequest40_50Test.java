package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class CommunicationRequest40_50Test {

  @Test
  public void convertCommunicationRequest40to50() throws IOException {

    InputStream r4InputJson = this.getClass().getResourceAsStream("/communication_request_40.json");
    InputStream r5ExpectedOutputJson = this.getClass().getResourceAsStream("/communication_request_40_converted_to_50.json");

    org.hl7.fhir.r4.model.CommunicationRequest r4Actual = (org.hl7.fhir.r4.model.CommunicationRequest) new org.hl7.fhir.r4.formats.JsonParser().parse(r4InputJson);
    org.hl7.fhir.r5.model.Resource r5Converted = VersionConvertorFactory_40_50.convertResource(r4Actual);

    org.hl7.fhir.r5.formats.JsonParser r5Parser = new org.hl7.fhir.r5.formats.JsonParser();
    org.hl7.fhir.r5.model.Resource r5Expected = r5Parser.parse(r5ExpectedOutputJson);

    Assertions.assertTrue(r5Expected.equalsDeep(r5Converted),
      "Failed comparing\n" + r5Parser.composeString(r5Expected) + "\nand\n" + r5Parser.composeString(r5Converted));
  }

  @Test
  public void convertCommunicationRequest50to40() throws IOException {
    InputStream r5InputJson = this.getClass().getResourceAsStream("/communication_request_50.json");
    InputStream r4ExpectedOutputJson = this.getClass().getResourceAsStream("/communication_request_50_converted_to_40.json");

    org.hl7.fhir.r5.model.CommunicationRequest r5Actual = (org.hl7.fhir.r5.model.CommunicationRequest) new org.hl7.fhir.r5.formats.JsonParser().parse(r5InputJson);
    org.hl7.fhir.r4.model.Resource r4Converted = VersionConvertorFactory_40_50.convertResource(r5Actual);

    org.hl7.fhir.r4.formats.JsonParser r4Parser = new org.hl7.fhir.r4.formats.JsonParser();
    org.hl7.fhir.r4.model.Resource r4Expected = r4Parser.parse(r4ExpectedOutputJson);

    Assertions.assertTrue(r4Expected.equalsDeep(r4Converted),
      "Failed comparing\n" + r4Parser.composeString(r4Expected) + "\nand\n" + r4Parser.composeString(r4Converted));
  }
}
