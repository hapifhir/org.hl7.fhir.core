package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.utilities.FileUtilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Questionnaire40_50Test {

  @Test
  @DisplayName("Test r5 -> r4 Questionnaire conversion.")
  public void testR5_R4() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/q_open_40.json");
    String source = FileUtilities.streamToString(r4_input);
    System.out.println(source);

    org.hl7.fhir.r4.model.Questionnaire r4_actual = (org.hl7.fhir.r4.model.Questionnaire) new org.hl7.fhir.r4.formats.JsonParser().parse(source);
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_actual);

    org.hl7.fhir.r5.formats.JsonParser r5_parser = new org.hl7.fhir.r5.formats.JsonParser();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    r5_parser.compose(stream, r5_conv);

    org.hl7.fhir.r5.model.Resource r5_streamed = (org.hl7.fhir.r5.model.Questionnaire) new org.hl7.fhir.r5.formats.JsonParser().parse(new ByteArrayInputStream(stream.toByteArray()));
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_40_50.convertResource(r5_streamed);

    assertTrue(r4_actual.equalsDeep(r4_conv), "should be the same");
  }
}
