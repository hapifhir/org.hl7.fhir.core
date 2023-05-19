package org.hl7.fhir.convertors.conv30_50;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPlan30_50Test {

  @Test
  @DisplayName("Test r5 -> dstu3 TestPlan conversion.")
  public void testR5_dstu3() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/testplan_50_example.json");

    org.hl7.fhir.r5.model.TestPlan r5_actual = (org.hl7.fhir.r5.model.TestPlan) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_50.convertResource(r5_actual);

    org.hl7.fhir.dstu3.formats.XmlParser r4_parser = new org.hl7.fhir.dstu3.formats.XmlParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r4_parser.compose(stream, dstu3_conv);

    org.hl7.fhir.dstu3.model.Resource dstu3_streamed = (org.hl7.fhir.dstu3.model.Basic) new org.hl7.fhir.dstu3.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_30_50.convertResource(dstu3_streamed);

    assertTrue(r5_actual.equalsDeep(r5_conv), "should be the same");
  }
}
