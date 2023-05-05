package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_40;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CapabilityStatement14_40Test {
  @Test
  @DisplayName("Test r4 -> dstu2016 CapabilityStatement conversion.")
  public void testR4_Dstu3() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/capability_statement_40_with_30_extensions.json");

    org.hl7.fhir.r4.model.CapabilityStatement r4_actual = (org.hl7.fhir.r4.model.CapabilityStatement) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.dstu2016may.model.Resource dstu2016_conv = VersionConvertorFactory_14_40.convertResource(r4_actual);

    org.hl7.fhir.dstu2016may.formats.JsonParser dstu2016_parser = new org.hl7.fhir.dstu2016may.formats.JsonParser();

    InputStream dstu2016_input = this.getClass().getResourceAsStream("/conformance_40_14.json");
    org.hl7.fhir.dstu2016may.model.Conformance dstu2016_actual = (org.hl7.fhir.dstu2016may.model.Conformance) dstu2016_parser.parse(dstu2016_input);

    assertTrue(dstu2016_actual.equalsDeep(dstu2016_conv), "should be the same");
  }
}
