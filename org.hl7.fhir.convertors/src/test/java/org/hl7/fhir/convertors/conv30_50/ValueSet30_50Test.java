package org.hl7.fhir.convertors.conv30_50;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValueSet30_50Test {
  @Test
  @DisplayName("Test r5 -> dstu3 ValueSet conversion.")
  public void testR5_Dstu3() throws IOException {
    InputStream dstu3_input = this.getClass().getResourceAsStream("/valueset_30.json");

    org.hl7.fhir.dstu3.model.ValueSet dstu3_actual = (org.hl7.fhir.dstu3.model.ValueSet) new org.hl7.fhir.dstu3.formats.JsonParser().parse(dstu3_input);
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_30_50.convertResource(dstu3_actual);

    org.hl7.fhir.r5.formats.JsonParser r5_parser = new org.hl7.fhir.r5.formats.JsonParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r5_parser.compose(stream, r5_conv);

    org.hl7.fhir.r5.model.Resource r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_50.convertResource(r5);

    assertTrue(dstu3_actual.equalsDeep(dstu3_conv), "should be the same");
  }
}
