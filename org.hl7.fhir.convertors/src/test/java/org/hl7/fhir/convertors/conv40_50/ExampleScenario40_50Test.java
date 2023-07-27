package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleScenario40_50Test {

  @Test
  @DisplayName("Test r5 -> r4 ExampleScenario conversion.")
  public void testR5_R4() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/example_scenario_50.xml");

    org.hl7.fhir.r5.model.ExampleScenario r5_actual = (org.hl7.fhir.r5.model.ExampleScenario) new org.hl7.fhir.r5.formats.XmlParser().parse(r5_input);
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_40_50.convertResource(r5_actual);

    org.hl7.fhir.r4.formats.XmlParser r4_parser = new org.hl7.fhir.r4.formats.XmlParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r4_parser.compose(stream, r4_conv);

    org.hl7.fhir.r4.model.Resource r4_streamed = (org.hl7.fhir.r4.model.ExampleScenario) new org.hl7.fhir.r4.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_streamed);

    assertTrue(r5_actual.equalsDeep(r5_conv), "should be the same");
  }

}
