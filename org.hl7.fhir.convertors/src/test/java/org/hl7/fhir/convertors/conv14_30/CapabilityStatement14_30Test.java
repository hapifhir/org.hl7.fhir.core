package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_30;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CapabilityStatement14_30Test {
  @Test
  @DisplayName("Test r4 -> dstu2016 CapabilityStatement conversion.")
  public void testDstu3_Dstu2016() throws IOException {
    InputStream dstu3_input = this.getClass().getResourceAsStream("/capability_statement_30.json");

    org.hl7.fhir.dstu3.model.CapabilityStatement dstu3 = (org.hl7.fhir.dstu3.model.CapabilityStatement) new org.hl7.fhir.dstu3.formats.JsonParser().parse(dstu3_input);
    org.hl7.fhir.dstu2016may.model.Resource dstu2016_conv = VersionConvertorFactory_14_30.convertResource(dstu3);

    org.hl7.fhir.dstu2016may.formats.JsonParser dstu2016_parser = new org.hl7.fhir.dstu2016may.formats.JsonParser();

    InputStream dstu2016_input = this.getClass().getResourceAsStream("/conformance_30_14.json");
    org.hl7.fhir.dstu2016may.model.Conformance dstu2016_actual = (org.hl7.fhir.dstu2016may.model.Conformance) dstu2016_parser.parse(dstu2016_input);

    assertTrue(dstu2016_actual.equalsDeep(dstu2016_conv), "should be the same");
  }
}
