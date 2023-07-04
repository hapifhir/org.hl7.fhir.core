package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationDefinition40_50Test {


  @Test
  @DisplayName("Test r5 -> r4 OperationDefinition conversion.")
  public void testR5_R4() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/opdef-4.xml");

    org.hl7.fhir.r4.model.OperationDefinition r4_actual = (org.hl7.fhir.r4.model.OperationDefinition) new org.hl7.fhir.r4.formats.XmlParser().parse(r4_input);
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_actual);

    org.hl7.fhir.r5.formats.XmlParser r5_parser = new org.hl7.fhir.r5.formats.XmlParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r5_parser.compose(stream, r5_conv);

    org.hl7.fhir.r5.model.Resource r5_streamed = (org.hl7.fhir.r5.model.OperationDefinition) new org.hl7.fhir.r5.formats.XmlParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_40_50.convertResource(r5_streamed);

    assertTrue(r4_actual.equalsDeep(r4_conv), "should be the same");
  }
}
