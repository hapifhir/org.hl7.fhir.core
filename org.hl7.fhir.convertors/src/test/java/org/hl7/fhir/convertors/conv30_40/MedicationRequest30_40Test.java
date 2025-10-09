package org.hl7.fhir.convertors.conv30_40;


import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MedicationRequest30_40Test {

  @Test
  public void convertMedicationRequest30to40() throws IOException {

    InputStream dstu3InputJson = this.getClass().getResourceAsStream("/medication_request_30.json");
    InputStream r4ExpectedOutputJson = this.getClass().getResourceAsStream("/medication_request_30_converted_to_40.json");

    org.hl7.fhir.dstu3.model.MedicationRequest dstu3Actual = (org.hl7.fhir.dstu3.model.MedicationRequest) new org.hl7.fhir.dstu3.formats.JsonParser().parse(dstu3InputJson);
    org.hl7.fhir.r4.model.Resource r4Converted = VersionConvertorFactory_30_40.convertResource(dstu3Actual);

    org.hl7.fhir.r4.formats.JsonParser r4Parser = new org.hl7.fhir.r4.formats.JsonParser();
    org.hl7.fhir.r4.model.Resource r4Expected = r4Parser.parse(r4ExpectedOutputJson);

    Assertions.assertTrue(r4Expected.equalsDeep(r4Converted),
      "Failed comparing\n" + r4Parser.composeString(r4Expected) + "\nand\n" + r4Parser.composeString(r4Converted));
  }

  @Test
  public void convertMedicationRequest40to30() throws IOException {
    InputStream r4InputJson = this.getClass().getResourceAsStream("/medication_request_40.json");
    InputStream dstu3ExpectedOutputJson = this.getClass().getResourceAsStream("/medication_request_40_converted_to_30.json");

    org.hl7.fhir.r4.model.MedicationRequest r4Actual = (org.hl7.fhir.r4.model.MedicationRequest) new org.hl7.fhir.r4.formats.JsonParser().parse(r4InputJson);
    org.hl7.fhir.dstu3.model.Resource dstu3Converted = VersionConvertorFactory_30_40.convertResource(r4Actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3Parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3Expected = dstu3Parser.parse(dstu3ExpectedOutputJson);

    Assertions.assertTrue(dstu3Expected.equalsDeep(dstu3Converted),
      "Failed comparing\n" + dstu3Parser.composeString(dstu3Expected) + "\nand\n" + dstu3Parser.composeString(dstu3Converted));
  }
}
