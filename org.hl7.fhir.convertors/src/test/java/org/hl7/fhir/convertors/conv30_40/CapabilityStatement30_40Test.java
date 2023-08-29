package org.hl7.fhir.convertors.conv30_40;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CapabilityStatement30_40Test {
  @Test
  @DisplayName("Test r4 -> dstu3 CapabilityStatement conversion.")
  public void testR4_Dstu3() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/capability_statement_40_with_30_extensions.json");

    org.hl7.fhir.r4.model.CapabilityStatement r5_actual = (org.hl7.fhir.r4.model.CapabilityStatement) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_40.convertResource(r5_actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();

    InputStream dstu3_input = this.getClass().getResourceAsStream("/capability_statement_40_30.json");
    org.hl7.fhir.dstu3.model.CapabilityStatement dstu3_actual = (org.hl7.fhir.dstu3.model.CapabilityStatement) dstu3_parser.parse(dstu3_input);

    assertTrue(dstu3_actual.equalsDeep(dstu3_conv), "should be the same");
  }
}
