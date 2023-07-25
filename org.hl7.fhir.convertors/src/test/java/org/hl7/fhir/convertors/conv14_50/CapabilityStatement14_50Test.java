package org.hl7.fhir.convertors.conv14_50;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CapabilityStatement14_50Test {
  @Test
  @DisplayName("Test r5 -> dstu2016 CapabilityStatement conversion.")
  public void testR5_Dstu2016() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/capability_statement_50_with_30_extensions.json");

    org.hl7.fhir.r5.model.CapabilityStatement r5_actual = (org.hl7.fhir.r5.model.CapabilityStatement) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_input);
    org.hl7.fhir.dstu2016may.model.Resource dstu2016_conv = VersionConvertorFactory_14_50.convertResource(r5_actual);

    org.hl7.fhir.dstu2016may.formats.JsonParser dstu2016_parser = new org.hl7.fhir.dstu2016may.formats.JsonParser();

    InputStream dstu2016_input = this.getClass().getResourceAsStream("/conformance_50_14.json");
    org.hl7.fhir.dstu2016may.model.Conformance dstu2016_actual = (org.hl7.fhir.dstu2016may.model.Conformance) dstu2016_parser.parse(dstu2016_input);

    assertTrue(dstu2016_actual.equalsDeep(dstu2016_conv), "should be the same");
  }
}
