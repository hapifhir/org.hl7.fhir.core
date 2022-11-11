package org.hl7.fhir.convertors.conv43_50;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Requirements43_50Test {


  @Test
  @DisplayName("Test r5 -> r4 Requirements conversion.")
  public void testR5_R4() throws IOException {
    InputStream r5_input = this.getClass().getResourceAsStream("/requirements_50_example.json");

    org.hl7.fhir.r5.model.Requirements r5_actual = (org.hl7.fhir.r5.model.Requirements) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_input);
    org.hl7.fhir.r4b.model.Resource r4_conv = VersionConvertorFactory_43_50.convertResource(r5_actual);

    org.hl7.fhir.r4b.formats.XmlParser r4_parser = new org.hl7.fhir.r4b.formats.XmlParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r4_parser.compose(stream, r4_conv);

    org.hl7.fhir.r4b.model.Resource r4_streamed = (org.hl7.fhir.r4b.model.Basic) new org.hl7.fhir.r4b.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_43_50.convertResource(r4_streamed);

    assertTrue(r5_actual.equalsDeep(r5_conv), "should be the same");
  }

}
