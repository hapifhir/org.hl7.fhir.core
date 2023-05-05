package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CapabilityStatement30_50Test {
  @Test
  @DisplayName("Test r5 -> dstu3 CapabilityStatement conversion.")
  public void testR5_Dstu3() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/capability_statement_50_with_30_extensions.json");

    org.hl7.fhir.r5.model.CapabilityStatement r5_actual = (org.hl7.fhir.r5.model.CapabilityStatement) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_50.convertResource(r5_actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();

    InputStream dstu3_input = this.getClass().getResourceAsStream("/capability_statement_50_30.json");
    org.hl7.fhir.dstu3.model.CapabilityStatement dstu3_actual = (org.hl7.fhir.dstu3.model.CapabilityStatement) dstu3_parser.parse(dstu3_input);

    assertTrue(dstu3_actual.equalsDeep(dstu3_conv), "should be the same");
  }
}
