package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.r5.formats.JsonParser;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CapabilityStatement30_50Test {


  @Test
  @DisplayName("Test r5 -> dstu3 capabilityStatement conversion.")
  public void testR5_DSTU3() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/capability_statement_50.json");

    JsonParser r5_parser = new JsonParser();
    org.hl7.fhir.r5.model.CapabilityStatement r5_actual = (org.hl7.fhir.r5.model.CapabilityStatement) r5_parser.parse(r5_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_50.convertResource(r5_actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    dstu3_parser.compose(stream, dstu3_conv);

    org.hl7.fhir.dstu3.model.Resource dstu3_streamed = (org.hl7.fhir.dstu3.model.CapabilityStatement) dstu3_parser.parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_30_50.convertResource(dstu3_streamed);

    assertTrue(r5_actual.equalsDeep(r5_conv), "should be the same");
  }

}
