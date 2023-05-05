package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_30;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CapabilityStatement10_30Test {
  @Test
  @DisplayName("Test dstu3 -> dstu2 CapabilityStatement conversion.")
  public void testDstu3_Dstu2() throws IOException {
    InputStream dstu3_input = this.getClass().getResourceAsStream("/capability_statement_30.json");

    org.hl7.fhir.dstu3.model.CapabilityStatement dstu3 = (org.hl7.fhir.dstu3.model.CapabilityStatement) new org.hl7.fhir.dstu3.formats.JsonParser().parse(dstu3_input);
    org.hl7.fhir.dstu2.model.Resource dstu2_conv = VersionConvertorFactory_10_30.convertResource(dstu3);

    org.hl7.fhir.dstu2.formats.JsonParser dstu2_parser = new org.hl7.fhir.dstu2.formats.JsonParser();

    InputStream dstu2_input = this.getClass().getResourceAsStream("/conformance_30_10.json");
    org.hl7.fhir.dstu2.model.Conformance dstu2_actual = (org.hl7.fhir.dstu2.model.Conformance) dstu2_parser.parse(dstu2_input);

    assertTrue(dstu2_actual.equalsDeep(dstu2_conv), "should be the same");
  }
}
