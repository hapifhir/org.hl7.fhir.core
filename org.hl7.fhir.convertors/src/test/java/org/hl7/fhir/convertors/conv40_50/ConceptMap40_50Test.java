package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConceptMap40_50Test {


  @Test
  @DisplayName("Test r5 -> r4 ConceptMap conversion.")
  public void testR5_R4() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/cm_nomap.json");

    org.hl7.fhir.r4.model.ConceptMap r4_actual = (org.hl7.fhir.r4.model.ConceptMap) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_actual);
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_40_50.convertResource(r5_conv);

    System.out.println(new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(r4_actual));
    System.out.println(new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(r4_conv));
    assertTrue(r4_actual.equalsDeep(r4_conv), "should be the same");
  }
}
