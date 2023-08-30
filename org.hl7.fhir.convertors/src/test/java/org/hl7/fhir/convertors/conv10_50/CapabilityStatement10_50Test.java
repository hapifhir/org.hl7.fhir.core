package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CapabilityStatement10_50Test {
  @Test
  @DisplayName("Test r5 -> dstu2 CapabilityStatement conversion.")
  public void testR5_Dstu2() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/capability_statement_50_with_30_extensions.json");

    org.hl7.fhir.r5.model.CapabilityStatement r5_actual = (org.hl7.fhir.r5.model.CapabilityStatement) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_input);
    org.hl7.fhir.dstu2.model.Resource dstu2_conv = VersionConvertorFactory_10_50.convertResource(r5_actual);

    org.hl7.fhir.dstu2.formats.JsonParser dstu2_parser = new org.hl7.fhir.dstu2.formats.JsonParser();

    InputStream dstu2_input = this.getClass().getResourceAsStream("/conformance_50_10.json");
    org.hl7.fhir.dstu2.model.Conformance dstu2_actual = (org.hl7.fhir.dstu2.model.Conformance) dstu2_parser.parse(dstu2_input);

    assertTrue(dstu2_actual.equalsDeep(dstu2_conv), "should be the same");
  }
}
